package com.google.engedu.ghost;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;


public class GhostActivity extends ActionBarActivity {
    private static final String COMPUTER_TURN = "Computer's turn";
    private static final String USER_TURN = "Your turn";
    private GhostDictionary dictionary;
    private boolean userTurn = false;
    private TextView ghost;
    private TextView states;
    private Button chalange;
    SimpleDictionary sd;
    private Random random = new Random();
    String st=new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost);
        onStart(null);
        ghost= (TextView) findViewById(R.id.ghostText);
        states= (TextView) findViewById(R.id.gameStatus);
        InputStream inputStream;
        try {
            inputStream=getAssets().open("words.txt");
            sd=new SimpleDictionary(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        chalange= (Button) findViewById(R.id.challengeBt);
        chalange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sd.isWord((String) ghost.getText())){
                    states.setText("Valied");
                }else{
                    states.setText("Invalied");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ghost, menu);
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

    private void computerTurn() {
        TextView label = (TextView) findViewById(R.id.gameStatus);
        // Do computer turn stuff then make it the user's turn again
        userTurn = true;
        label.setText(USER_TURN);
        if(ghost.getText().length()>=4){
            String anyWord= dictionary.getAnyWordStartingWith((String) ghost.getText());
            if(anyWord==(String) ghost.getText()){
                label.setText("Victory");
            }else{

            }

        }
    }

    /**
     * Handler for the "Reset" button.
     * Randomly determines whether the game starts with a user turn or a computer turn.
     * @param view
     * @return true
     */
    public boolean onStart(View view) {
        userTurn = random.nextBoolean();
        TextView text = (TextView) findViewById(R.id.ghostText);
        text.setText("");
        TextView label = (TextView) findViewById(R.id.gameStatus);
        if (userTurn) {
            label.setText(USER_TURN);
        } else {
            label.setText(COMPUTER_TURN);
            computerTurn();
        }
        return true;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        char c = (char) event.getUnicodeChar();
        if ((event.getKeyCode()>=29)&&(event.getKeyCode()<=54)) {

            st+=c;
            ghost.setText(st);
            return false;


        }else{
            return super.onKeyUp(keyCode, event);
        }

    }
}
