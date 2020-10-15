package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
     buttons are laid out in a 3 by 3 like this
     the the text and new game button
     1 2 3
     4 5 6
     7 8 9
     textbox
     new game button
    */

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    TextView playerTurn;
    Button newGame;
    int player;
    String currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find way to make it as array
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        playerTurn = findViewById(R.id.playerTurn);
        newGame = findViewById(R.id.buttonNewGame);
        player = 1;
        currentPlayer = currentPlayerIs(player);

        // put text in each one
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        playerTurn.setText("Player " + currentPlayer + "'s turn");
        newGame.setText("New game");
    }

    public String currentPlayerIs(int player){
        if(player % 2 == 0){
            return "O";
        } else {
            return "X";
        }
    }

    public void nextTurn(Button buttonInUse){
        player++;
        currentPlayer = currentPlayerIs(player);
        playerTurn.setText("Player " + currentPlayer + "'s turn");
        buttonInUse.setEnabled(false);
    }

    public void onClick(View v){
        if(v.equals(button1)){
            button1.setText(currentPlayer);
            nextTurn(button1);
        } else if(v.equals(button2)){
            button2.setText(currentPlayer);
            nextTurn(button2);
        } else if(v.equals(button3)){
            button3.setText(currentPlayer);
            nextTurn(button3);
        } else if(v.equals(button4)){
            button4.setText(currentPlayer);
            nextTurn(button4);
        } else if(v.equals(button5)){
            button5.setText(currentPlayer);
            nextTurn(button5);
        } else if(v.equals(button6)){
            button6.setText(currentPlayer);
            nextTurn(button6);
        } else if(v.equals(button7)){
            button7.setText(currentPlayer);
            nextTurn(button7);
        } else if(v.equals(button8)){
            button8.setText(currentPlayer);
            nextTurn(button8);
        } else if(v.equals(button9)){
            button9.setText(currentPlayer);
            nextTurn(button9);
        }
    }
}