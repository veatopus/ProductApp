package kg.geektech.ruslan.feature_product.base_product_component

import android.view.View
import kg.geektech.ruslan.core_utils.utils.BaseAdapter
import kg.geektech.ruslan.feature_product.R
import kg.geektech.ruslan.feature_product.databinding.ItemProductBinding
import kg.geektech.ruslan.model.Product

class ProductAdapter(val onLikeClicked: (model: Product) -> Unit) :
    BaseAdapter<Product>(R.layout.item_product) {

    override fun onBind(view: View, model: Product) {
        ItemProductBinding.bind(view).also { binding ->
            binding.tvName.text = model.name
            binding.btnFavorite.isSelected = model.isFavourite
            binding.btnFavorite.setOnClickListener {
                binding.btnFavorite.isSelected = !binding.btnFavorite.isSelected
                model.isFavourite = !model.isFavourite
                onLikeClicked(model)
            }
        }
    }


}