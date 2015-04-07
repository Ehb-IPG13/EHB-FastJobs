package be.ehb.ipg13.fastjobs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class profiel_aanmaken_jobvoorkeuren extends ActionBarActivity {

    Button volgende;
    EditText gemeente, km;
    Spinner tijdsregeling,soortjob;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiel_aanmaken_jobvoorkeuren);
        this.getSupportActionBar().hide();

        final ImageView img = (ImageView) findViewById(R.id.imgView5);
        img.setImageResource(R.drawable.header5);

        volgende = (Button)findViewById(R.id.btn_volgende_5);
        tijdsregeling = (Spinner)findViewById(R.id.spnr_tijdsregeling);
        soortjob = (Spinner)findViewById(R.id.spnr_soortJob);
        gemeente = (EditText) findViewById(R.id.txt_gemeente);
        km = (EditText) findViewById(R.id.txt_km);
        skip = (TextView) findViewById(R.id.lbl_skip_5);

        String[] tijdsregelingen = {"", "voltijds", "deeltijds"};
        ListAdapter adapterTijdsregeling = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, tijdsregelingen);

        String[] soortenJobs = {"", "vast contract", "interim"};
        ListAdapter adapterSoortJob = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, soortenJobs);

        tijdsregeling.setAdapter((android.widget.SpinnerAdapter) adapterTijdsregeling);
        soortjob.setAdapter((android.widget.SpinnerAdapter) adapterSoortJob);

        //tijdsregeling.setBackgroundColor(Color.LTGRAY);
        //soortjob.setBackgroundColor(Color.LTGRAY);
        gemeente.setBackgroundColor(Color.parseColor("#ff2a8171"));
        km.setBackgroundColor(Color.parseColor("#ff2a8171"));

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "DDD", Toast.LENGTH_SHORT).show();
            }
        });

        volgende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences opslaanJobVoorkeuren = getSharedPreferences("jobVoorkeuren", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = opslaanJobVoorkeuren.edit();
                editor.putString("tijdsregeling", tijdsregeling.getSelectedItem().toString());
                editor.putString("soortjob", soortjob.getSelectedItem().toString());
                editor.putString("gemeente", gemeente.toString());
                editor.putString("km", km.toString());

                System.out.println("1++++: " + tijdsregeling.getSelectedItem().toString());
                System.out.println("2++++: " + opslaanJobVoorkeuren.getString("tijdsregeling", "FOUT 1"));
                System.out.println("1+---: " + soortjob.getSelectedItem().toString());
                System.out.println("2+---: " + opslaanJobVoorkeuren.getString("soortjob", "FOUT 1"));

                editor.apply();
                //Toast.makeText(getApplicationContext(), "SAVED!", Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(), opslaanErvaring.getString("bedrijf 1","!!").toString(), Toast.LENGTH_LONG).show();
                Intent i = new Intent("be.ehb.ipg13.fastjobs.trefwoorden");
                startActivity(i);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profiel_aanmaken_jobvoorkeuren, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
