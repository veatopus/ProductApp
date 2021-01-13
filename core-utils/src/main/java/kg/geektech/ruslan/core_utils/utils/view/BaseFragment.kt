package kg.geektech.ruslan.core_utils.utils.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import kg.geektech.ruslan.core_utils.utils.BaseViewModel
import kg.geektech.ruslan.core_utils.utils.helpers.showToast

abstract class BaseFragment<V : BaseViewModel, B : ViewBinding>(private val layoutId: Int) :
    Fragment() {

    var mViewModel: V? = null
    var binding: B? = null

    private var hasInitializedRootView = false
    var rootView: View? = null

    abstract fun getViewModel(): V
    abstract fun getViewBinding(): B?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return getPersistentView(inflater, container)
    }

    open fun initArgs(arg: Bundle) {}

    private fun getPersistentView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View? {
        if (rootView == null) {
            rootView = inflater.inflate(layoutId, container, false)
        } else {
            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }
        binding = getViewBinding()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasInitializedRootView) {
            hasInitializedRootView = true
            mViewModel = getViewModel()
            setUpViewModelObs()
            setUpObs()
            setUpView()
            arguments?.let { initArgs(it) }
        }
    }

    private fun setUpObs() {
        mViewModel?.let { viewModel ->
            viewModel.run {
                isFinished.observe(requireActivity(), { isFinish(it) })
                isLoading.observe(requireActivity(), { progress(it) })
                toast.observe(requireActivity(), { requireContext().showToast(it) })
            }
        }
    }

    open fun progress(isProgress: Boolean) {}

    private fun isFinish(isFinish: Boolean) {
        if (isFinish) findNavController().navigateUp()
    }

    open fun setUpView() { }

    open fun setUpViewModelObs() {}
}