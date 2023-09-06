package com.app.mobile_p3_relativelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.app.mobile_p3_relativelayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var hasilHitung = 0.0
    private  var operatorVar = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        with(binding){
            fun setButtonClickListener(button: Button, newNumber: String) {
                button.setOnClickListener {
                    val caretPosition: Int = tvRes.selectionStart

                    val newText: String =
                        tvRes.text.toString().substring(0, caretPosition) + newNumber + tvRes.text.toString().substring(
                            caretPosition
                        )
                    tvRes.setText(newText)



                    tvRes.setSelection(caretPosition+1)
                }
            }

            setButtonClickListener(bt1, "1")
            setButtonClickListener(bt2, "2")
            setButtonClickListener(bt3, "3")
            setButtonClickListener(bt4, "4")
            setButtonClickListener(bt5, "5")
            setButtonClickListener(bt6, "6")
            setButtonClickListener(bt7, "7")
            setButtonClickListener(bt8, "8")
            setButtonClickListener(bt9, "9")

            bt0.setOnClickListener{
                if (tvRes.length()>0 && tvRes.selectionStart > 0){
                    val texpos: Int = tvRes.selectionStart
                    val newNumber = "0"
                    val newText: String =
                        tvRes.text.toString().substring(0, texpos) + newNumber + tvRes.text.toString().substring(
                            texpos
                        )
                    tvRes.setText(newText)
                    tvRes.setSelection(texpos+1)
                }
            }

            btDel.setOnClickListener {
                val textpos: Int = tvRes.selectionStart
                if (textpos > 0) {
                    val text = tvRes.text.toString()
                    val newText: String = text.substring(0, textpos - 1) + text.substring(textpos)
                    tvRes.setText(newText)
                    tvRes.setSelection(textpos - 1)
                }
            }

            btC.setOnClickListener{
                tvRes.setText("")
            }

            btPlus.setOnClickListener{

                try{
                    when(operatorVar){
                        "+" -> hasilHitung += tvRes.text.toString().toDouble()
                        "-" -> hasilHitung -= tvRes.text.toString().toDouble()
                        "/" -> hasilHitung /= tvRes.text.toString().toDouble()
                        "*" -> hasilHitung *= tvRes.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }


                operatorVar = "+"

                tvRes.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }


            btMinus.setOnClickListener{
                try{
                    when(operatorVar){
                        "+" -> hasilHitung += tvRes.text.toString().toDouble()
                        "-" -> hasilHitung -= tvRes.text.toString().toDouble()
                        "/" -> hasilHitung /= tvRes.text.toString().toDouble()
                        "*" -> hasilHitung *= tvRes.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }


                operatorVar = "-"
                tvRes.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }

            btBagi.setOnClickListener{
                try{
                    when(operatorVar){
                        "+" -> hasilHitung += tvRes.text.toString().toDouble()
                        "-" -> hasilHitung -= tvRes.text.toString().toDouble()
                        "/" -> hasilHitung /= tvRes.text.toString().toDouble()
                        "*" -> hasilHitung *= tvRes.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }


                operatorVar = "/"

                tvRes.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }

            btKali.setOnClickListener{
                try{
                    when(operatorVar){
                        "+" -> hasilHitung += tvRes.text.toString().toDouble()
                        "-" -> hasilHitung -= tvRes.text.toString().toDouble()
                        "/" -> hasilHitung /= tvRes.text.toString().toDouble()
                        "*" -> hasilHitung *= tvRes.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }


                operatorVar = "*"

                tvRes.setText("")
                textHasil.text = hasilHitung.toString()
                textHasil.visibility = View.VISIBLE
            }

            btSamadengan.setOnClickListener{

                try{
                    when(operatorVar){
                        "+" -> hasilHitung += tvRes.text.toString().toDouble()
                        "-" -> hasilHitung -= tvRes.text.toString().toDouble()
                        "/" -> hasilHitung /= tvRes.text.toString().toDouble()
                        "*" -> hasilHitung *= tvRes.text.toString().toDouble()
                    }
                }
                catch (_: NumberFormatException){

                }

                operatorVar = "+"
                tvRes.setText(hasilHitung.toString())
                hasilHitung = 0.0

                textHasil.visibility = View.GONE
                tvRes.setSelection(tvRes.text.length)
            }




        }



    }
}