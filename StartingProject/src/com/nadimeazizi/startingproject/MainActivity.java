package com.nadimeazizi.startingproject;

import java.util.List;

import com.nadimeazizi.startingproject.data.NoteItem;
import com.nadimeazizi.startingproject.data.NotesDataSource;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

	private NotesDataSource datasource;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        datasource = new NotesDataSource(this);
        List<NoteItem> notes = datasource.findAll();
        NoteItem note = notes.get(0);
        note.setText("Updated!");
        datasource.update(note);
        
        notes = datasource.findAll();
        note = notes.get(0);
        
        Log.i("NOTES", note.getKey() + ": " + note.getText());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
