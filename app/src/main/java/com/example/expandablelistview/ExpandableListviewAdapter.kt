package com.example.expandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import java.text.ParsePosition

class ExpandableListviewAdapter(var context: Context,var title:MutableList<String>,var subTitle:MutableList<MutableList<String>>):
        BaseExpandableListAdapter(){
    override fun getGroupCount(): Int {
        return title.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return subTitle[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): String {
        return title[groupPosition]

    }

    override fun getChild(groupPosition: Int, childPosition: Int): CharSequence? {
        return subTitle[groupPosition][childPosition]

    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView ==null)
        {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.title_layout,null)
        }

        val mTitle = convertView!!.findViewById<TextView>(R.id.Iv_title)
        mTitle.text = getGroup(groupPosition)
        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (convertView ==null)
        {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.subtitle_layout,null)
        }
        val mSubTitle = convertView!!.findViewById<TextView>(R.id.Iv_subtitle)
        mSubTitle.text = getChild(groupPosition,childPosition)
        return convertView
    }

}
