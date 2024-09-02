package com.example.spinnerdatapass

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn:Button=findViewById(R.id.button_id)
        btn.setOnClickListener {
            val makeupItems:Spinner=findViewById(R.id.spinner_id)
            val makeupSelect=makeupItems.selectedItem.toString()

            val intent=Intent(this,SecondPage::class.java)
            val makeupList= getItem(makeupSelect)
            val makeup=makeupList.reduce{acc,item->acc+"\n"+item}
            intent.putExtra("message",makeup)
            startActivity(intent)
        }
    }
}

fun getItem(makeup:String):List<String>{
    return when(makeup){
        "Eyes"-> listOf("Eyeliner","Kajol","Mascara","Eyeshadow","Eyebrow pen or gel")
        "Face" -> listOf("Moisturizer","Primer","Foundation ","Concealer","Blush","Contour or Bronzer","Face Powder","Setting Spray")
        "Lips" -> listOf("Lip Balm","Lip Liner","LipStick")
        else -> listOf("Hair Serum","Hair Styling kit")
    }
}
