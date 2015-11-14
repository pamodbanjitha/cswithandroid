package com.example.banjitha.my2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton b7;
    ImageButton b8;
    ImageButton b9;
    ImageView image;
    boolean winner=false;
    int count;
    int a[][]=new int[3][3];
    {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[i][j]=0;
            }
        }
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1= (ImageButton) findViewById(R.id.imageButton);
        b2= (ImageButton) findViewById(R.id.imageButton2);
        b3= (ImageButton) findViewById(R.id.imageButton3);
        b4= (ImageButton) findViewById(R.id.imageButton4);
        b5= (ImageButton) findViewById(R.id.imageButton5);
        b6= (ImageButton) findViewById(R.id.imageButton6);
        b7= (ImageButton) findViewById(R.id.imageButton7);
        b8= (ImageButton) findViewById(R.id.imageButton8);
        b9= (ImageButton) findViewById(R.id.imageButton9);
        image= (ImageView) findViewById(R.id.imageView);
        count = 0;
        b1.setImageResource(R.drawable.blue);
        b2.setImageResource(R.drawable.blue);
        b3.setImageResource(R.drawable.blue);
        b4.setImageResource(R.drawable.blue);
        b5.setImageResource(R.drawable.blue);
        b6.setImageResource(R.drawable.blue);
        b7.setImageResource(R.drawable.blue);
        b8.setImageResource(R.drawable.blue);
        b9.setImageResource(R.drawable.blue);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b1.setImageResource(R.drawable.d1);
                    a[0][0]=1;
                }if(count%2==1){
                    b1.setImageResource(R.drawable.d2);
                    a[0][0]=2;
                }
                findWinner();
                b1.setEnabled(false);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b2.setImageResource(R.drawable.d1);
                    a[0][1]=1;
                }if(count%2==1){
                    b2.setImageResource(R.drawable.d2);
                    a[0][1]=2;
                }
                findWinner();
                b2.setEnabled(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b3.setImageResource(R.drawable.d1);
                    a[0][2]=1;
                }if(count%2==1){
                    b3.setImageResource(R.drawable.d2);
                    a[0][2]=2;
                }
                findWinner();
                b3.setEnabled(false);
               // a[0][2]=1;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b4.setImageResource(R.drawable.d1);
                    a[1][0]=1;
                }if(count%2==1){
                    b4.setImageResource(R.drawable.d2);
                    a[1][0]=2;
                }
                findWinner();
                b4.setEnabled(false);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b5.setImageResource(R.drawable.d1);
                    a[1][1]=1;
                }if(count%2==1){
                    b5.setImageResource(R.drawable.d2);
                    a[1][1]=2;
                }
                findWinner();
                b5.setEnabled(false);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b6.setImageResource(R.drawable.d1);
                    a[1][2]=1;
                }if(count%2==1){
                    b6.setImageResource(R.drawable.d2);
                    a[1][2]=2;
                }
                findWinner();
                b6.setEnabled(false);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b7.setImageResource(R.drawable.d1);
                    a[2][0]=1;
                }if(count%2==1){
                    b7.setImageResource(R.drawable.d2);
                    a[2][0]=2;
                }
                findWinner();
                b7.setEnabled(false);
               // a[2][0]=1;
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b8.setImageResource(R.drawable.d1);
                    a[2][1]=1;
                }if(count%2==1){
                    b8.setImageResource(R.drawable.d2);
                    a[2][1]=2;
                }
                findWinner();
                b8.setEnabled(false);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2==0){
                    b9.setImageResource(R.drawable.d1);
                    a[2][2]=1;
                }if(count%2==1){
                    b9.setImageResource(R.drawable.d2);
                    a[2][2]=2;
                }

                    findWinner();

                b9.setEnabled(false);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void findWinner(){
        if(a[0][0]==a[1][1]){
            if(a[1][1]==a[2][2]){
                if(a[0][0]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }if(a[0][0]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }
               // winner=true;

            }
        }
        if(a[0][0]==a[1][0]){
            if(a[1][0]==a[2][0]){

                if(a[0][0]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }else if(a[0][0]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }
               // winner=true;
            }
        }
        if(a[0][1]==a[1][1]){
            if(a[1][1]==a[2][1]){
                if(a[0][1]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }else if(a[0][1]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }
               // winner=true;
            }
        }
        if(a[0][2]==a[1][2]){
            if(a[1][2]==a[2][2]){
                if(a[0][2]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }else if(a[0][2]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }
                //winner=true;
            }
        }
        if(a[0][0]==a[0][1]){
            if(a[0][1]==a[0][2]){
                if(a[0][0]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }else if(a[0][0]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }
               // winner=true;
            }
        }
        if(a[1][0]==a[1][1]){
            if(a[1][1]==a[1][2]){
                if(a[1][0]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }else if(a[1][0]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }
                //winner=true;
            }
        }
        if(a[2][0]==a[2][1]){
            if(a[2][1]==a[2][2]){
                if(a[2][0]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }else if(a[2][0]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }

            }
        }
        if(a[0][2]==a[1][1]){
            if(a[1][1]==a[2][0]){
                if(a[2][0]==1){
                    image.setImageResource(R.drawable.d1);
                    winner=true;
                }else if(a[2][0]==2){
                    image.setImageResource(R.drawable.d2);
                    winner=true;
                }

            }
        }
        if(winner){
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
        }

    }
}
