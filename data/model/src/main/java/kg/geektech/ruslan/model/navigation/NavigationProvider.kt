package kg.geektech.ruslan.model.navigation

import kg.geektech.ruslan.model.navigation.features.FeatureProductNavigator

interface NavigationProvider {
    fun provideFeatureNavigation(): FeatureProductNavigator
}