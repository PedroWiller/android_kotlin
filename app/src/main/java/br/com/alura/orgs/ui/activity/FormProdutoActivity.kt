package br.com.alura.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDao
import br.com.alura.orgs.model.Produto
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configSaveButton()
    }

    private fun configSaveButton() {
        val saveButton = findViewById<Button>(R.id.salvar)
        saveButton.setOnClickListener {
            val produto = createProduct()
            val dao = ProdutoDao()
            dao.add(produto)
            finish()
        }
    }

    private fun createProduct(): Produto {
        val fieldName = findViewById<EditText>(R.id.nome)
        val nome = fieldName.text.toString()

        val fieldDecription = findViewById<EditText>(R.id.descricao)
        val descricao = fieldDecription.text.toString()

        val fieldValue = findViewById<EditText>(R.id.valor)
        val valorConverted = fieldValue.text.toString()
        val valor = if (valorConverted.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorConverted)
        }

        return  Produto(nome, descricao, valor)
    }
}