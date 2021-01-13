package kg.geektech.ruslan.productapp.navigation

import android.content.Context
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import kg.geektech.ruslan.feature_product_info.ProductInfoFragment
import kg.geektech.ruslan.model.navigation.NavigationProvider
import kg.geektech.ruslan.model.navigation.features.FeatureProductNavigator
import kg.geektech.ruslan.productapp.App
import kg.geektech.ruslan.productapp.R

class NavigationProviderImpl(private val context: Context) : NavigationProvider {
    override fun provideFeatureNavigation(): FeatureProductNavigator =
        object : FeatureProductNavigator {
            override fun showFeatureProductInfo(id: String) {
                val app = context as App
                val activity = app.getCurrentActivity()
                val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                val navController = navHostFragment.navController
                navController.navigate(R.id.productInfoFragment, Bundle().also { it.putString(ProductInfoFragment.ID_KEY, id) })
            }

        }
}