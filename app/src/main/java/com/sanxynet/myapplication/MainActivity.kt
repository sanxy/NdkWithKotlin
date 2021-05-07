package com.sanxynet.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        findViewById<TextView>(R.id.sample_text).text = stringFromJNI()

        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            val addOutput = add(10,2)
            Toast.makeText(applicationContext, addOutput.toString(), Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.buttonSubtract).setOnClickListener {
            val subtractOutput = sub(10,2)
            Toast.makeText(applicationContext, subtractOutput.toString(), Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.buttonMultiply).setOnClickListener {
            val multiplyOutput = multiply(10,2)
            Toast.makeText(applicationContext, multiplyOutput.toString(), Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.buttonDivide).setOnClickListener {
            val DivideOutput = divide(10,2)
            Toast.makeText(applicationContext, DivideOutput.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun add(x: Int, y: Int): Int

    external fun sub(x: Int, y: Int): Int

    external fun multiply(x: Int, y: Int): Int

    external fun divide(x: Int, y: Int): Int

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}