package kg.geektech.ruslan.productapp

import android.app.Activity
import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.ruslan.core_utils.utils.di.utilsModule
import kg.geektech.ruslan.data.di.dataModule
import kg.geektech.ruslan.feature_product.di.featureProductModule
import kg.geektech.ruslan.feature_product_info.di.featureProductInfoModule
import kg.geektech.ruslan.local.di.databaseModule
import kg.geektech.ruslan.network.di.networkModule
import kg.geektech.ruslan.productapp.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    mainModule,
                    dataModule,
                    networkModule,
                    databaseModule,
                    utilsModule,
                    featureProductModule,
                    featureProductInfoModule
                )
            )
        }
    }

    companion object{
        lateinit var instance: App
    }

    private var mCurrentActivity: AppCompatActivity? = null
    fun getCurrentActivity(): AppCompatActivity? {
        return mCurrentActivity
    }

    fun setCurrentActivity(mCurrentActivity: AppCompatActivity?) {
        this.mCurrentActivity = mCurrentActivity
    }
}