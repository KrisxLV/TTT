package com.example.scuffedtictactoe


import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.scuffedtictactoe.databinding.ActivityMain3Binding
import com.example.scuffedtictactoe.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {
    enum class Gajiens{
        krusts,
        nulle
    }

    private var pirmaisGajiens = Gajiens.krusts
    private var tgajiens = Gajiens.krusts

    private var saraksts = mutableListOf<Button>()

    private lateinit var binding : ActivityMain3Binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        laukums()
    }

    private fun laukums() {
        saraksts.add(binding.a1)
        saraksts.add(binding.a2)
        saraksts.add(binding.a3)
        saraksts.add(binding.b1)
        saraksts.add(binding.b2)
        saraksts.add(binding.b3)
        saraksts.add(binding.c1)
        saraksts.add(binding.c2)
        saraksts.add(binding.c3)
    }

    fun Poga(view: View) {
        if(view !is Button)
            return
        simbols(view)

        if(uzvara(nulle)) {
            rezultats("O uzvarēja")

        }

        if(uzvara(krusts)) {
            rezultats("X uzvarēja")

        }


        if(pilns()) {
            rezultats("Draw")
        }
    }

    private fun uzvara(t: String): Boolean {

        if(ir(binding.a1,t) && ir(binding.a2,t) && ir(binding.a3,t))
            return true
        if(ir(binding.b1,t) && ir(binding.b2,t) && ir(binding.b3,t))
            return true
        if(ir(binding.c1,t) && ir(binding.c2,t) && ir(binding.c3,t))
            return true
        if(ir(binding.a1,t) && ir(binding.b1,t) && ir(binding.c1,t))
            return true
        if(ir(binding.a2,t) && ir(binding.b2,t) && ir(binding.c2,t))
            return true
        if(ir(binding.a3,t) && ir(binding.b3,t) && ir(binding.c3,t))
            return true
        if(ir(binding.a1,t) && ir(binding.b2,t) && ir(binding.c3,t))
            return true
        if(ir(binding.c1,t) && ir(binding.b2,t) && ir(binding.c1,t))
            return true
        return false
    }

    private fun ir(button: Button, symbol : String): Boolean = button.text == symbol


    private fun rezultats(title: String) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setPositiveButton("Reset")
            { _,_ ->
                resetoLaukumu()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetoLaukumu()
    {
        for (button in saraksts)
        {
            button.text = ""
        }

    }

    private fun pilns(): Boolean {
        for (button in saraksts) {
            if (button.text == "")
                return false
        }
        return true
    }

    private fun simbols(button: Button) {
        if (button.text != "")
            return

         if(tgajiens == Gajiens.nulle) {
            button.text = nulle
            tgajiens = Gajiens.krusts
        }
        else if(tgajiens == Gajiens.krusts) {
            button.text = krusts
            tgajiens = Gajiens.nulle
        }
    }

    companion object {
      const val krusts = "X"
      const val nulle = "O"
    }

}




