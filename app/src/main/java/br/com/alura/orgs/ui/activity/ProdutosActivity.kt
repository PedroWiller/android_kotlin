package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDao
import br.com.alura.orgs.ui.recycleview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos){

    private val dao = ProdutoDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.getAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecycleView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.getAll())
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            goToProductForm()
        }
    }

    private fun goToProductForm() {
        val intent = Intent(this, FormProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configRecycleView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.adapter = adapter
    }
}