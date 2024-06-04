package github.com.fioshi.guilhermefiochi_rm95508_recycleview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.listaPraia);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.incluirButton)
        val nomePraia = findViewById<EditText>(R.id.nomePraia)
        val cidade = findViewById<EditText>(R.id.cidade)
        val estado = findViewById<EditText>(R.id.estado)


        button.setOnClickListener {

            if (nomePraia.text.isEmpty() || cidade.text.isEmpty() || estado.text.isEmpty()) {
                nomePraia.error = "Preencha um valor"
                return@setOnClickListener
            }

            val item = ItemModel(
                name = nomePraia.text.toString(),
                cidade = cidade.text.toString(),
                estado = estado.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )
            itemsAdapter.addItem(item)
            nomePraia.text.clear()
            cidade.text.clear()
            estado.text.clear()
        }
    }

}