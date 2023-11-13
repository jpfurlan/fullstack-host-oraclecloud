import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ItemLista } from '../models/item-lista.model';

@Injectable({
  providedIn: 'root',
})
export class ListaDeComprasService {
  private apiUrl = 'http://168.138.233.110:8080/api/lista';

  constructor(private http: HttpClient) {}

  getItems(): Observable<ItemLista[]> {
    return this.http.get<ItemLista[]>(this.apiUrl);
  }

  addItem(item: ItemLista): Observable<ItemLista> {
    return this.http.post<ItemLista>(this.apiUrl, item);
  }

  updateItem(id: number, item: ItemLista): Observable<ItemLista> {
    return this.http.put<ItemLista>(`${this.apiUrl}/${id}`, item);
  }

  deleteItem(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
