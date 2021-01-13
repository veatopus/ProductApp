package kg.geektech.ruslan.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class Product(
    var name: String? = null,
    var price: String? = null,
    var desc: String? = null,
    var company: String? = null,
    @NotNull
    @PrimaryKey
    var id: String,
    var img: String? = null,
    var isFavourite: Boolean = false,
    var isChoice: Boolean = false
)
