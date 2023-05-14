package edu.skku.cs.pa1

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class WordListAdapter(val data: ArrayList<word_array>, val context: Context): BaseAdapter() {
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
        val generatedView = inflater.inflate(R.layout.word_list, null)

        val textView1 = generatedView.findViewById<TextView>(R.id.text1)
        val textView2 = generatedView.findViewById<TextView>(R.id.text2)
        val textView3 = generatedView.findViewById<TextView>(R.id.text3)
        val textView4 = generatedView.findViewById<TextView>(R.id.text4)
        val textView5 = generatedView.findViewById<TextView>(R.id.text5)

        textView1.text = data[p0].arr1
        textView2.text = data[p0].arr2
        textView3.text = data[p0].arr3
        textView4.text = data[p0].arr4
        textView5.text = data[p0].arr5

        when (data[p0].arr1_color) {
            "green" -> {
                textView1.setBackgroundColor(Color.GREEN)
                textView1.setTextColor(Color.BLACK)
            }
            "yellow" -> {
                textView1.setBackgroundColor(Color.YELLOW)
                textView1.setTextColor(Color.BLACK)
            }
            "gray" -> {
                textView1.setBackgroundColor(Color.GRAY)
                textView1.setTextColor(Color.WHITE)
            }
        }

        when (data[p0].arr2_color) {
            "green" -> {
                textView2.setBackgroundColor(Color.GREEN)
                textView2.setTextColor(Color.BLACK)
            }
            "yellow" -> {
                textView2.setBackgroundColor(Color.YELLOW)
                textView2.setTextColor(Color.BLACK)
            }
            "gray" -> {
                textView2.setBackgroundColor(Color.GRAY)
                textView2.setTextColor(Color.WHITE)
            }
        }

        when (data[p0].arr3_color) {
            "green" -> {
                textView3.setBackgroundColor(Color.GREEN)
                textView3.setTextColor(Color.BLACK)
            }
            "yellow" -> {
                textView3.setBackgroundColor(Color.YELLOW)
                textView3.setTextColor(Color.BLACK)
            }
            "gray" -> {
                textView3.setBackgroundColor(Color.GRAY)
                textView3.setTextColor(Color.WHITE)
            }
        }

        when (data[p0].arr4_color) {
            "green" -> {
                textView4.setBackgroundColor(Color.GREEN)
                textView4.setTextColor(Color.BLACK)
            }
            "yellow" -> {
                textView4.setBackgroundColor(Color.YELLOW)
                textView4.setTextColor(Color.BLACK)
            }
            "gray" -> {
                textView4.setBackgroundColor(Color.GRAY)
                textView4.setTextColor(Color.WHITE)
            }
        }

        when (data[p0].arr5_color) {
            "green" -> {
                textView5.setBackgroundColor(Color.GREEN)
                textView5.setTextColor(Color.BLACK)
            }
            "yellow" -> {
                textView5.setBackgroundColor(Color.YELLOW)
                textView5.setTextColor(Color.BLACK)
            }
            "gray" -> {
                textView5.setBackgroundColor(Color.GRAY)
                textView5.setTextColor(Color.WHITE)
            }
        }

        return generatedView
    }

}