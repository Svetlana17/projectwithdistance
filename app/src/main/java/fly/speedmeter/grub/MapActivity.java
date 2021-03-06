package fly.speedmeter.grub;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.melnykov.fab.FloatingActionButton;

import fly.speedmeter.grub.LocationShare.SettingsActivity;

public class MapActivity extends ActionBarActivity {
    private FloatingActionButton distanse;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        distanse = (FloatingActionButton) findViewById(R.id.fabdistanse);
        distanse.setVisibility(View.INVISIBLE);
        distanse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MapActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
       @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.mainS) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            if(id==R.id.action_settings){
                Intent intents = new Intent(this, Settings.class);
                startActivity(intents);
                if(id==R.id.options){
                    Intent intent1=new Intent(this, SettingsActivity.class);
                    startActivity(intent1);
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}


