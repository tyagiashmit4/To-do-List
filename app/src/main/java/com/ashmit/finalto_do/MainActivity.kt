package com.ashmit.finalto_do

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val noteDatabase by lazy { NoteDatabase.getDatabase(this).noteDao() }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button=findViewById<Button>(R.id.button)

        button.setOnClickListener{
            val intent= Intent(this,AddActivity::class.java)
            startActivity(intent
            )
        }
        observeNotes()
    }
    private fun observeNotes() {
        lifecycleScope.launch {
            noteDatabase.getNotes().collect { notesList ->
                if (notesList.isNotEmpty()) {
                    val rvNotes=findViewById<RecyclerView>(R.id.rv_notes)
                    rvNotes.adapter=NotesAdapter(notesList)
                    rvNotes.layoutManager= LinearLayoutManager(this@MainActivity)
                    rvNotes.setHasFixedSize(true)


                }
            }
        }
    }
}
