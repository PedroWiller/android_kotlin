package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produto

class ProdutoDao {

    fun add(produto: Produto){
        produtos.add(produto)
    }

    fun getAll(): List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}