package com.axweb.blocodenotas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.axweb.blocodenotas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val preference = PreferenciaAnotacao(applicationContext)
        val saveButton = binding.fab

        saveButton.setOnClickListener {

            val annotationRetrieved = binding.editContainer.editAnotacao.text.toString()

            if (annotationRetrieved == ""){
                Toast.makeText(this,"Digite alguma coisa...",Toast.LENGTH_SHORT).show()
            }else{
                preference.saveNote(annotationRetrieved)
                Toast.makeText(this,"Anotação salva com sucesso!",Toast.LENGTH_SHORT).show()
            }
        }

        val note = preference.retrieveNote()
        if (note != ""){
            binding.editContainer.editAnotacao.setText(note)
        }

    }

}