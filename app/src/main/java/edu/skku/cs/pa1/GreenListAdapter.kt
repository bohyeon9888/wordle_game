package edu.skku.cs.pa1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class GreenListAdapter(val data: ArrayList<letter_unit>,val context: Context): BaseAdapter() {

    fun findGreen(inputs: List<String?>){
        for (i: Int in 0..4){
            if(inputs[i+5]=="green"){
                data.add(letter_unit(inputs[i]))
            }
        }
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(p0: Int): Any {
        return data[p0]
    }


    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val generatedView = inflater.inflate(R.layout.letter_list, null)

        val letterView = generatedView.findViewById<TextView>(R.id.letter)

        letterView.text = data[p0].letter
        letterView.setBackgroundColor(Color.GREEN)
        letterView.setTextColor(Color.BLACK)


        return generatedView
    }
}