package com.example.ranjecoffeemanagement

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomAdapter(var context: Context, var data:ArrayList<Block>):BaseAdapter() {
    private class ViewHolder(row: View?) {
        var Vblockname: TextView
        var Vstdate: TextView
        var Vbushesnum: TextView
        var Vacre: TextView
        var Vorgmanure: TextView
        var Vlaborgmanure: TextView
        var Vnorgmanure: TextView
        var Vlabnorgmanure: TextView
        var Vweeding: TextView
        var Vlabweeding: TextView
        var Vpruning: TextView
        var Vlabpruning: TextView
        var Vspraying: TextView
        var Vlabspraying: TextView
        var Vcherrypick: TextView
        var Vlabcherrypick: TextView
        var Vtransport: TextView
        var Vlabtransport: TextView
        var Vmilling: TextView
        var Vlabmilling: TextView
        var Vdrying: TextView
        var Vlabdrying: TextView
        var Vsorting: TextView
        var Vlabsorting: TextView

        init {
            this.Vblockname = row?.findViewById(R.id.vblock) as TextView
            this.Vstdate = row?.findViewById(R.id.vstdate) as TextView
            this.Vbushesnum = row?.findViewById(R.id.vbushesnum) as TextView
            this.Vacre = row?.findViewById(R.id.vacre) as TextView
            this.Vorgmanure = row?.findViewById(R.id.vorgmanure) as TextView
            this.Vlaborgmanure = row?.findViewById(R.id.vlaborgmanure) as TextView
            this.Vnorgmanure = row?.findViewById(R.id.vnorgmanure) as TextView
            this.Vlabnorgmanure = row?.findViewById(R.id.vlabnorgmanure) as TextView
            this.Vweeding = row?.findViewById(R.id.vweeding) as TextView
            this.Vlabweeding = row?.findViewById(R.id.vlabweeding) as TextView
            this.Vpruning = row?.findViewById(R.id.vpruning) as TextView
            this.Vlabpruning = row?.findViewById(R.id.vlabpruning) as TextView
            this.Vspraying = row?.findViewById(R.id.vspraying) as TextView
            this.Vlabspraying = row?.findViewById(R.id.vlabspraying) as TextView
            this.Vcherrypick = row?.findViewById(R.id.vcherrypick) as TextView
            this.Vlabcherrypick = row?.findViewById(R.id.vlabcherrypick) as TextView
            this.Vtransport = row?.findViewById(R.id.vtransport) as TextView
            this.Vlabtransport = row?.findViewById(R.id.vlabtransport) as TextView
            this.Vmilling = row?.findViewById(R.id.vmilling) as TextView
            this.Vlabmilling = row?.findViewById(R.id.vlabmilling) as TextView
            this.Vdrying = row?.findViewById(R.id.vdrying) as TextView
            this.Vlabdrying = row?.findViewById(R.id.vlabdrying) as TextView
            this.Vsorting = row?.findViewById(R.id.vsorting) as TextView
            this.Vlabsorting = row?.findViewById(R.id.vlabsorting) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.viewdata_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item: Block = getItem(position) as Block
        viewHolder.Vblockname.text = item.blockname
        viewHolder.Vstdate.text = item.stdate
        viewHolder.Vbushesnum.text = item.bushesnum
        viewHolder.Vacre.text = item.acre
        viewHolder.Vorgmanure.text = item.orgmanure
        viewHolder.Vlaborgmanure.text = item.laborgmanure
        viewHolder.Vnorgmanure.text = item.norgmanure
        viewHolder.Vlabnorgmanure.text = item.labnorgmanure
        viewHolder.Vweeding.text = item.weeding
        viewHolder.Vlabweeding.text = item.labweeding
        viewHolder.Vpruning.text = item.pruning
        viewHolder.Vlabpruning.text = item.labpruning
        viewHolder.Vspraying.text = item.spraying
        viewHolder.Vlabspraying.text = item.labspraying
        viewHolder.Vcherrypick.text = item.cherrypicking
        viewHolder.Vlabcherrypick.text = item.labcherrypicking
        viewHolder.Vtransport.text = item.transport
        viewHolder.Vlabtransport.text = item.labtransport
        viewHolder.Vmilling.text = item.milling
        viewHolder.Vlabmilling.text = item.labmilling
        viewHolder.Vdrying.text = item.drying
        viewHolder.Vlabdrying.text = item.labdrying
        viewHolder.Vsorting.text = item.sorting
        viewHolder.Vlabsorting.text = item.labsorting
        return view as View
    }

    override fun getItem(position: Int): Any {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}