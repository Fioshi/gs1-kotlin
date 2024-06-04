package github.com.fioshi.guilhermefiochi_rm95508_recycleview

data class ItemModel(
    val name: String,
    val cidade: String,
    val estado: String,
    val onRemove: (ItemModel) -> Unit
)