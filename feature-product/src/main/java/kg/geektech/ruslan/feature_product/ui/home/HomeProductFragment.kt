package kg.geektech.ruslan.feature_product.ui.home

import androidx.recyclerview.widget.RecyclerView
import kg.geektech.ruslan.core_utils.utils.helpers.isVisible
import kg.geektech.ruslan.feature_product.R
import kg.geektech.ruslan.feature_product.base_product_component.BaseProductFragment
import kg.geektech.ruslan.feature_product.databinding.FragmentProductBinding
import org.koin.android.ext.android.inject

class HomeProductFragment : BaseProductFragment<HomeProductViewModel, FragmentProductBinding>(R.layout.fragment_product) {

    override fun getRecyclerView(): RecyclerView = binding?.recyclerView!!

    override fun getViewModel(): HomeProductViewModel = inject<HomeProductViewModel>().value

    override fun getViewBinding(): FragmentProductBinding? = rootView?.let {
        FragmentProductBinding.bind(
            it
        )
    }

    override fun progress(isProgress: Boolean) {
        binding?.progressBar?.isVisible(isProgress)
    }
}