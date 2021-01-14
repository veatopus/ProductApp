package kg.geektech.ruslan.feature_product.base_product_component

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kg.geektech.ruslan.core_utils.utils.BaseAdapter
import kg.geektech.ruslan.core_utils.utils.view.BaseFragment
import kg.geektech.ruslan.feature_product.R
import kg.geektech.ruslan.model.Product


abstract class BaseProductFragment<V : BaseProductViewModel, B : ViewBinding>(layoutId: Int)
    : BaseFragment<V, B>(
    layoutId
), BaseAdapter.IBaseAdapterClickListener<Product> {
    private lateinit var adapter: ProductAdapter
    private lateinit var layoutManager: GridLayoutManager
    private lateinit var recyclerView: RecyclerView

    override fun setUpView() {
        super.setUpView()
        layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView = getRecyclerView()
        initRecycler(layoutManager)
        adapter.listener = this
    }

    abstract fun getRecyclerView(): RecyclerView

    private fun initRecycler(layoutManager: GridLayoutManager){
        this.adapter = ProductAdapter(onLikeClicked = mViewModel!!::onLikeClicked)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun setCountRecycler(count: Int){
        layoutManager.spanCount = count
        recyclerView.layoutManager = layoutManager
        adapter.notifyDataSetChanged()
    }

    private fun setData(data: MutableList<Product>){
        adapter.setData(data)
    }

    override fun setUpViewModelObs() {
        super.setUpViewModelObs()
        mViewModel?.getProduct()
        mViewModel?.product?.observe(requireActivity(), this::setData)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.number_columns, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onClick(model: Product) {
        mViewModel?.openInfoFragment(model.id)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.one_column -> {
                setCountRecycler(1)
                true
            }
            R.id.two_column -> {
                setCountRecycler(2)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}