package github.com.fioshi.guilhermefiochi_rm95508_recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nome = view.findViewById<TextView>(R.id.nomePraia)
        val cidade = view.findViewById<TextView>(R.id.cidade)
        val estado = view.findViewById<TextView>(R.id.estado)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(item: ItemModel) {
            nome.text = item.name
            cidade.text = item.cidade
            estado.text = item.estado

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged();
    }
}