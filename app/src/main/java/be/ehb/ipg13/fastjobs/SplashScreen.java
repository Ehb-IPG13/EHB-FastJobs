package be.ehb.ipg13.fastjobs;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SplashScreen extends ActionBarActivity {

 boolean new_check=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //IF APP FIRST USE SET FALSE
        new_check=true;
        setContentView(R.layout.activity_splash_screen);
        //System.out.println(" => => => => => 888 <= <= <= <= <= ");
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.setTitle("Fast Job");
        this.getSupportActionBar().hide();
        //getActionBar().setTitle("hhhh");
        Thread threadSplashScreen = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                    if(new_check==true){

                    Intent i = new Intent("be.ehb.ipg13.fastjobs.basis_gegevens");
                    startActivity(i);
                    finish();
                    }else {
                        Intent goToHome = new Intent("be.ehb.ipg13.fastjobs.homescreen");
                        startActivity(goToHome);
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        threadSplashScreen.start();
    }



}
