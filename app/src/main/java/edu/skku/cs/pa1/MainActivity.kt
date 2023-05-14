package edu.skku.cs.pa1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myAdapter: WordListAdapter
        var greenFinder: GreenListAdapter
        var yellowFinder: YellowListAdapter
        var grayFinder: GrayListAdapter

        var randomData = RandomAnswer()
        var randomLine = randomData.random()
        randomLine = randomLine.uppercase()
        var answerArr = randomLine.chunked(1)
        val wordEditText = findViewById<EditText>(R.id.editTextWord)

        var items = ArrayList<word_array>()
        var greens = ArrayList<letter_unit>()
        var yellows = ArrayList<letter_unit>()
        var grays = ArrayList<letter_unit>()

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            var inputword = wordEditText.text.toString()

            if (!randomData.contains(inputword)){
                Toast.makeText(applicationContext, "Word ${inputword} not in dictionary!", Toast.LENGTH_LONG).show()
                wordEditText.text.clear()
            }else {
                inputword = inputword.uppercase()
                val wordArr = inputword.chunked(1)
                val ret_items = compareWord(answerArr, wordArr)

                items.add(word_array(ret_items[0], ret_items[1], ret_items[2], ret_items[3], ret_items[4],
                    ret_items[5], ret_items[6], ret_items[7], ret_items[8], ret_items[9]))

                myAdapter = WordListAdapter(items, applicationContext)
                myAdapter.notifyDataSetChanged()

                greenFinder = GreenListAdapter(greens, applicationContext)
                greenFinder.findGreen(ret_items)

                yellowFinder = YellowListAdapter(yellows, applicationContext)
                yellowFinder.findYellow(ret_items)

                grayFinder = GrayListAdapter(grays, applicationContext)
                grayFinder.findGray(ret_items)

                val listView = findViewById<ListView>(R.id.WordListView)
                val greenList = findViewById<ListView>(R.id.LetterListGreen)
                val yellowList = findViewById<ListView>(R.id.LetterListYellow)
                val grayList = findViewById<ListView>(R.id.LetterListGrey)

                listView.adapter = myAdapter
                greenList.adapter = greenFinder
                yellowList.adapter = yellowFinder
                grayList.adapter = grayFinder

                wordEditText.text.clear()
            }

        }

    }

    private fun compareWord(answers: List<String>, inputs: List<String>): List<String?> {
        var ret_item: MutableList<String?> = mutableListOf(*arrayOfNulls(10))

        for (i: Int in 0..4){
            if (answers.contains(inputs[i])){
                if(answers[i] == inputs[i]){
                    ret_item[i] = inputs[i]
                    ret_item[i+5] = "green"
                } else {
                    ret_item[i] = inputs[i]
                    ret_item[i+5] = "yellow"
                }
            } else {
                ret_item[i] = inputs[i]
                ret_item[i+5] = "gray"
            }
        }
        var put_items: List<String?> = ret_item.toList()

        return put_items
    }

    fun RandomAnswer(): MutableList<String> {
        val assetManager = applicationContext.assets
        val inputStream = assetManager.open("wordle_words.txt")

        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val lines = mutableListOf<String>()

        bufferedReader.useLines { lines.addAll(it) }

        return lines
    }


}

