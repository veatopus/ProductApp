package kg.geektech.ruslan.core_utils.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>(
    private val holderLayoutId: Int,
) :
    RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    var data = mutableListOf<T>()
    var listener: IBaseAdapterClickListener<T>? = null

    @JvmName("setData1")
    fun setData(data: MutableList<T>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return BaseViewHolder(
            LayoutInflater.from(parent.context).inflate(holderLayoutId, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    abstract fun onBind(view: View, model: T)

    inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(model: T) {
            onBind(itemView, model)

            itemView.setOnClickListener {
                listener?.onClick(model)
            }
        }
    }

    interface IBaseAdapterClickListener<T> {
        fun onClick(model: T)
    }
}