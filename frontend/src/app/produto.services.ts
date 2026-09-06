import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProdutoItem } from './app';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  private apiUrl = 'http://localhost:8080/produto';

  constructor(private http: HttpClient) {}

  getProduto(): Observable<ProdutoItem[]> {
    return this.http.get<ProdutoItem[]>(this.apiUrl);
  }

  getProdutoById(id: string): Observable<ProdutoItem> {
    return this.http.get<ProdutoItem>(`${this.apiUrl}/${id}`);
  }

  addProduto(produto: Partial<ProdutoItem>): Observable<ProdutoItem[]> {
    return this.http.post<ProdutoItem[]>(this.apiUrl, produto);
  }

  updateProduto(produto: ProdutoItem): Observable<ProdutoItem[]> {
    return this.http.put<ProdutoItem[]>(this.apiUrl, produto);
  }

  deleteProduto(id: string): Observable<ProdutoItem[]> {
    return this.http.delete<ProdutoItem[]>(`${this.apiUrl}/${id}`);
  }
}
