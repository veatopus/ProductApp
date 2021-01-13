package kg.geektech.ruslan.local.client

import android.content.Context
import androidx.room.Room
import kg.geektech.ruslan.local.dao.ProductDao
import kg.geektech.ruslan.local.database.AppDatabase

class DatabaseClient {

    internal fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "product.database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    fun providePlaylistDao(database: AppDatabase): ProductDao? = database.playlistDao()

    fun provideDetailPlaylistDao(database: AppDatabase): ProductDao? = database.playlistDao()

}