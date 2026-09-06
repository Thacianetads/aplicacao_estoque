import { Component, inject, signal } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { ProdutoService } from './produto.services';

export interface ProdutoItem {
  id: string;
  nome: string;
  codigo: string;
  fornecedor: string;
  estoque: number;
  preco: number;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, NgFor, NgIf],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected readonly title = signal('frontend');

  private produtoService = inject(ProdutoService);

  produtoList: ProdutoItem[] = [];

  newProduto: Partial<ProdutoItem> = {
    nome: '',
    codigo: '',
    fornecedor: '',
    estoque: 0,
    preco: 0
  };

  editingProduto: ProdutoItem | null = null;

  constructor() {
    this.loadProdutos();
  }

  loadProdutos(): void {
    this.produtoService.getProduto().subscribe({
      next: (produtos) => (this.produtoList = produtos),
      error: (err) => console.error('Erro ao carregar produtos:', err),
    });
  }

  addProduto(): void {
    if (this.newProduto.nome?.trim()) {
      this.produtoService.addProduto(this.newProduto).subscribe({
        next: (updatedList) => {
          this.produtoList = updatedList;
          this.newProduto = { nome: '', codigo: '', fornecedor: '', estoque: 0, preco: 0 };
        },
        error: (err) => console.error('Erro ao adicionar produto:', err),
      });
    }
  }



  deleteProduto(id: string): void {
    this.produtoService.deleteProduto(id).subscribe({
      next: (updatedList) => (this.produtoList = updatedList),
      error: (err) => console.error('Erro ao deletar produto:', err),
    });
  }

  editProduto(produto: ProdutoItem): void {
    this.editingProduto = { ...produto };
  }

  saveEdit(): void {
    if (this.editingProduto) {
      this.produtoService.updateProduto(this.editingProduto).subscribe({
        next: (updatedList) => {
          this.produtoList = updatedList;
          this.editingProduto = null;
        },
        error: (err) => console.error('Erro ao salvar edição:', err),
      });
    }
  }

  cancelEdit(): void {
    this.editingProduto = null;
  }
}
