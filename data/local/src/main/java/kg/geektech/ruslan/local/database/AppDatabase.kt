package kg.geektech.ruslan.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kg.geektech.ruslan.local.dao.ProductDao
import kg.geektech.ruslan.model.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
@TypeConverters()
abstract class AppDatabase : RoomDatabase() {
    abstract fun playlistDao(): ProductDao?
}