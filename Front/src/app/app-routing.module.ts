import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaDeComprasTabelaComponent } from './components/lista-de-compras-tabela/lista-de-compras-tabela.component';

const routes: Routes = [
  { path: '', component: ListaDeComprasTabelaComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
