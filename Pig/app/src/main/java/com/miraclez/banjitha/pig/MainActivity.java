package com.miraclez.banjitha.pig;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView im;
    TextView scoreTV;
    Button roll;
    int a=0,c=0,na=0,nb=0,w=0,p=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scoreTV= (TextView) findViewById(R.id.scoreTextView);
        setContentView(R.layout.activity_main);
        im= (ImageView) findViewById(R.id.imageView);
        roll= (Button) findViewById(R.id.rollbutton);
        im.setImageResource(R.drawable.st);
        ((TextView) findViewById(R.id.atxt)).setTextColor(0xFFFF1306);
        ((TextView) findViewById(R.id.bTxt)).setTextColor(0xFF010000);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onHold(View view) {
        c=0;
        if(p==1){
            p=2;
            ((TextView) findViewById(R.id.bTxt)).setTextColor(0xFFFF1306);
            ((TextView) findViewById(R.id.atxt)).setTextColor(0xFF010000);
        }else{
            p=1;
            ((TextView) findViewById(R.id.atxt)).setTextColor(0xFFFF1306);
            ((TextView) findViewById(R.id.bTxt)).setTextColor(0xFF010000);
        }
    }

    public void onReset(View view) {
        roll.setClickable(true);
        roll.setEnabled(true);
        na=0;
        nb=0;
        w=0;
        c=0;
        ((TextView) findViewById(R.id.atxt)).setTextColor(0xFFFF1306);
        ((TextView) findViewById(R.id.bTxt)).setTextColor(0xFF010000);
        im.setImageResource(R.drawable.st);
        ((TextView) findViewById(R.id.scoreTextView)).setText("" + na);
        ((TextView) findViewById(R.id.scoreBTextView)).setText(""+nb);
    }

    public void onRoll(View view) {
        Random r=new Random();
        a=r.nextInt(6)+1;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if(w==1){
                    im.setImageResource(R.drawable.a);
                }else if(w==2){
                    im.setImageResource(R.drawable.b);
                }else{
                    im.setImageResource(R.drawable.st);
                }

            }
        }, 3000);
        if(p==1){
            na+=a;
            c+=a;
            if (na>=50){
                Toast.makeText(MainActivity.this,"Player A win....!",Toast.LENGTH_LONG).show();
                im.setImageResource(R.drawable.a);
                roll.setEnabled(false);
                roll.setClickable(false);
                w=1;

            }
        }else{
            nb+=a;
            c+=a;
            if (nb>=50){
                Toast.makeText(MainActivity.this,"Player B win....!",Toast.LENGTH_LONG).show();
                im.setImageResource(R.drawable.b);
                roll.setEnabled(false);
                roll.setClickable(false);
                w=2;
            }
        }

        switch (a){
            case 1:
                im.setImageResource(R.drawable.dice1);
                if(a==1){
                    if (p==1){
                        //na-=a;
                        na-=(c);
                        p=2;
                        ((TextView) findViewById(R.id.bTxt)).setTextColor(0xFFFF1306);
                        ((TextView) findViewById(R.id.atxt)).setTextColor(0xFF010000);

                    }else{
                       // nb-=a;
                        p=1;
                        nb-=(c);
                        ((TextView) findViewById(R.id.atxt)).setTextColor(0xFFFF1306);
                        ((TextView) findViewById(R.id.bTxt)).setTextColor(0xFF010000);
                    }
                }
                c=0;
                break;
            case 2:
                im.setImageResource(R.drawable.dice2);
                break;
            case 3:
                im.setImageResource(R.drawable.dice3);
                break;
            case 4:
                im.setImageResource(R.drawable.dice4);
                break;
            case 5:
                im.setImageResource(R.drawable.dice5);
                break;
            case 6:
                im.setImageResource(R.drawable.dice6);
                break;


        }
//        scoreTV.setText(""+n);
        ((TextView) findViewById(R.id.scoreTextView)).setText(""+na);
        ((TextView) findViewById(R.id.scoreBTextView)).setText("" + nb);
    }
}
