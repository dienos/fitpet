package jth.fitpet.presentation.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import jth.fitpet.domain.model.WeatherRepo
import jth.fitpet.presentation.BR
import jth.fitpet.presentation.databinding.WeatherItemBinding
import jth.fitpet.presentation.databinding.WeatherItemHeaderBinding


class WeatherListAdapter(private val context : Context, private val list: List<WeatherRepo>) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int = list.size

    override fun getChildrenCount(positon: Int): Int = list[positon].list.size

    override fun getGroup(position: Int): Any = list[position].city.name

    override fun getChild(groupPosition: Int, childPosition: Int): Any =
        list[groupPosition].list[childPosition]

    override fun getGroupId(positon: Int): Long = list[positon].city.id.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long =
        list[groupPosition].list[childPosition].dt

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parentView: ViewGroup?): View {
        val binding = WeatherItemHeaderBinding.inflate(LayoutInflater.from(context), parentView, false)
        binding.setVariable(BR.header_item, list[groupPosition].city)

        return binding.root
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parentView: ViewGroup?): View {
        val binding = WeatherItemBinding.inflate(LayoutInflater.from(context), parentView, false)
        binding.setVariable(BR.item, list[groupPosition].list[childPosition])
        binding.setVariable(BR.weather_item, list[groupPosition].list[childPosition].weather[0])

        return binding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true

}