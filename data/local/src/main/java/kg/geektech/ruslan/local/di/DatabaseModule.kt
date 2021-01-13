package kg.geektech.ruslan.local.di

import kg.geektech.ruslan.local.client.DatabaseClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module(override = true) {
    factory { DatabaseClient().provideDatabase(androidContext()) }
    factory { DatabaseClient().providePlaylistDao(get()) }
    factory { DatabaseClient().provideDetailPlaylistDao(get()) }
}