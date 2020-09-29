package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import kotlin.random.nextInt

class Quiz : AppCompatActivity() {
    var questions=arrayOf(
        "web development",
        "game development",
        "networking",
        "game design",
        "video editing","apple","cooking","handball","basketball","swimming","cricket","android","mango","mobile","books","engineering","kotlin","java","laptop","computers"
    )
    private lateinit var rightAns:TextView
    lateinit var  questionTextView:TextView
    lateinit var  userAnswer:EditText
    lateinit var random: Random
    lateinit var question:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        rightAns=findViewById(R.id.rightAns)
       questionTextView= findViewById(R.id.questionView)
        userAnswer=findViewById(R.id.ansField)
        startQuiz()
    }
    private fun correctAnswer(){
        rightAns.visibility=View.VISIBLE
        rightAns.setBackgroundColor(Color.GREEN)
        rightAns.text=question
        //handler
        Handler(Looper.getMainLooper()).postDelayed({
           startQuiz()
        }, 3000)




    }
    private fun wrongAnswer(){

        rightAns.visibility=View.VISIBLE
        rightAns.setBackgroundColor(Color.RED)
        rightAns.text=userAnswer.text.toString()

    }
    fun checkAnswer(view: View){
     if(userAnswer.text.toString().equals(question,ignoreCase=true))
     { correctAnswer()
         Toast.makeText(this,"Good Job!!",Toast.LENGTH_SHORT).show()
     }
      else
     { wrongAnswer()
         Toast.makeText(this,"Try again!!",Toast.LENGTH_SHORT).show()
     }
    }
private fun startQuiz(){
    rightAns.text=""
    userAnswer.text=null
 rightAns.visibility=View.INVISIBLE
random=Random
   question=questions[random.nextInt(questions.size)]
    questionTextView.text=mixLetters(question)
}
    fun showAnswer(view: View) {
        rightAns.visibility=View.VISIBLE
     rightAns.text=question
    }

    fun changeButton(view: View){
       startQuiz()
    }


    private fun mixLetters(word: String):String
    {
        val characters: CharArray = word.toCharArray()
        for (i in characters.indices) {
            val randomIndex = (Math.random() * characters.size).toInt()
            val temp = characters[i]
            characters[i] = characters[randomIndex]
            characters[randomIndex] = temp
        }
        return String(characters)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java))
    }










}