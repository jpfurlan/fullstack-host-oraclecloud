import { Component, OnInit } from '@angular/core';
import { ListaDeComprasService } from '../../services/lista-de-compras.service';
import { ItemLista } from '../../models/item-lista.model';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-lista-de-compras-tabela',
  templateUrl: './lista-de-compras-tabela.component.html',
  styleUrls: ['./lista-de-compras-tabela.component.scss'],
})
export class ListaDeComprasTabelaComponent implements OnInit {
  displayedColumns: string[] = ['nome', 'quantidade', 'actions'];
  dataSource: ItemLista[] = [];

  constructor(
    private listaDeComprasService: ListaDeComprasService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.listaDeComprasService.getItems().subscribe((items) => {
      this.dataSource = items;
    });
  }

  openDialog(item?: ItemLista): void {
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      data: item ? { ...item } : { nome: '', quantidade: '' },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        if (item) {
          // Update
          this.listaDeComprasService
            .updateItem(item.id, result)
            .subscribe(() => {
              this.refresh();
            });
        } else {
          // Add
          this.listaDeComprasService.addItem(result).subscribe(() => {
            this.refresh();
          });
        }
      }
    });
  }

  deleteItem(id: number): void {
    this.listaDeComprasService.deleteItem(id).subscribe(() => {
      this.refresh();
    });
  }

  private refresh(): void {
    this.listaDeComprasService.getItems().subscribe((items) => {
      this.dataSource = items;
    });
  }
}
