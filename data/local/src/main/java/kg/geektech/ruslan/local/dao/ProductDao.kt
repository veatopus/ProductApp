package kg.geektech.ruslan.local.dao

import androidx.room.*
import kg.geektech.ruslan.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    suspend fun getAll(): MutableList<Product>

    @Query("SELECT * FROM product WHERE id = :id")
    suspend fun getById(id: String): Product?

    @Query("SELECT * FROM product WHERE isFavourite = 1")
    suspend fun getFavouriteProduct(): MutableList<Product>?

    @Query("SELECT * FROM product WHERE isChoice = 1")
    suspend fun getChoiceProduct(): MutableList<Product>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWithReplace(product: Product)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertWithIgnore(product: Product)

    @Delete
    suspend fun delete(product: Product)

}