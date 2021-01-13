package kg.geektech.ruslan.feature_product_info

import android.os.Bundle
import android.util.Log
import kg.geektech.ruslan.core_utils.utils.helpers.isVisible
import kg.geektech.ruslan.core_utils.utils.helpers.loadImage
import kg.geektech.ruslan.core_utils.utils.view.BaseFragment
import kg.geektech.ruslan.feature_product_info.databinding.FragmentProductInfoBinding
import org.koin.android.ext.android.inject
import kotlin.math.log

class ProductInfoFragment : BaseFragment<ProductInfoViewModel, FragmentProductInfoBinding>(R.layout.fragment_product_info){

    override fun getViewModel(): ProductInfoViewModel = inject<ProductInfoViewModel>().value

    override fun getViewBinding(): FragmentProductInfoBinding? = rootView?.let {
        FragmentProductInfoBinding.bind(
            it
        )
    }

    override fun initArgs(arg: Bundle) {
        val id: String? = arg.getString(ID_KEY)
        id?.let { mViewModel?.getProductById(it) }
    }

    override fun setUpViewModelObs() {
        super.setUpViewModelObs()
        mViewModel?.product?.observe(requireActivity(), { product ->
            binding?.run {
                tvName.text = product.name
                tvCompany.text = product.company
                tvPrice.text = product.price
                tvDesc.text = product.desc
                product.img?.let { ivImage.loadImage(it) }
                btnShop.isSelected = product.isChoice
                btnFavorite.isSelected = product.isFavourite
                btnShop.setOnClickListener {
                    btnShop.isSelected = !btnShop.isSelected
                    mViewModel?.shopClick(product)
                }
                btnFavorite.setOnClickListener {
                    btnFavorite.isSelected = !btnFavorite.isSelected
                    mViewModel?.favoriteClick(product)
                }
            }
        })
    }

    override fun progress(isProgress: Boolean) {
        binding?.progressBar?.isVisible(isProgress)
    }

    companion object{
        const val ID_KEY: String = "id_key"
    }

}