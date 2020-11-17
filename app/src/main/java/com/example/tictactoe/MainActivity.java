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

        gameSetup();
    }

    public void gameSetup(){
        // player setup
        player = 1;
        currentPlayer = currentPlayerIs(player);

        // put text in each one
        button1.setEnabled(true);
        button1.setText(" ");
        button2.setEnabled(true);
        button2.setText("  ");
        button3.setEnabled(true);
        button3.setText("   ");
        button4.setEnabled(true);
        button4.setText("    ");
        button5.setEnabled(true);
        button5.setText("     ");
        button6.setEnabled(true);
        button6.setText("      ");
        button7.setEnabled(true);
        button7.setText("       ");
        button8.setEnabled(true);
        button8.setText("        ");
        button9.setEnabled(true);
        button9.setText("         ");
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
        String winner = checkForWin();
        declareTheWinner(winner);
    }

    public void declareTheWinner(String winner) {
        if(winner != null || winner == ""){
            playerTurn.setText("Player " + winner + " won the game");
            button1.setEnabled(false);
            button2.setEnabled(false);
            button3.setEnabled(false);
            button4.setEnabled(false);
            button5.setEnabled(false);
            button6.setEnabled(false);
            button7.setEnabled(false);
            button8.setEnabled(false);
            button9.setEnabled(false);
        }
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
        } else if(v.equals(newGame)){
            gameSetup();
        }
    }

    public String checkForWin(){

        // get button data
        String text1 = (String)button1.getText();
        String text2 = (String)button2.getText();
        String text3 = (String)button3.getText();
        String text4 = (String)button4.getText();
        String text5 = (String)button5.getText();
        String text6 = (String)button6.getText();
        String text7 = (String)button7.getText();
        String text8 = (String)button8.getText();
        String text9 = (String)button9.getText();
        boolean winner = false;
        String winnerText;

        // look for winner if they exist
        winner = didSomeoneWin(text1,text2,text3);
        if(winner){
            return text1;
        }
        winner = didSomeoneWin(text4,text5,text6);
        if(winner){
            return text4;
        }
        winner = didSomeoneWin(text7,text8,text9);
        if(winner){
            return text7;
        }
        winner = didSomeoneWin(text1,text4,text7);
        if(winner){
            return text1;
        }
        winner = didSomeoneWin(text2,text5,text8);
        if(winner){
            return text2;
        }
        winner = didSomeoneWin(text3,text6,text9);
        if(winner){
            return text3;
        }
        winner = didSomeoneWin(text1,text5,text9);
        if(winner){
            return text1;
        }
        winner = didSomeoneWin(text3,text5,text7);
        if(winner){
            return text3;
        }
        return null;
    }

    public boolean didSomeoneWin(String  box1, String  box2, String  box3){
        if(box1 == box2 && box1 == box3 )
            return true;
        return false;
    }
}