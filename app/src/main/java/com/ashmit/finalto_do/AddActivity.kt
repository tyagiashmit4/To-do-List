package com.ashmit.finalto_do

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch


class AddActivity : AppCompatActivity() {
    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        var etName=findViewById<EditText>(R.id.etName)
        var etProirity=findViewById<EditText>(R.id.etPriority)
        var save=findViewById<Button>(R.id.Save)
        save.setOnClickListener {
            val newNote = Note(etName.text.toString()?:"" ,etProirity.text.toString() ?: "")
            lifecycleScope.launch {
                noteDatabase.addNote(newNote)
                Toast.makeText(this@AddActivity,"${newNote.name} added" ,Toast.LENGTH_SHORT).show()
                Log.d("ABCD,","${newNote.name} added")
            }
        }

    }
}