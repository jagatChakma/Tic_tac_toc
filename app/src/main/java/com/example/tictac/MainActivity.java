package com.example.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button[][] = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCounts = 0;
    private int player1Points = 0;
    private int player2Points = 0;
    private TextView textViewPlayer1, textViewPlayer2;
    private Button reser_button, newGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.textViewPlayer1);
        textViewPlayer2 = findViewById(R.id.textViewPlayer2);

        reser_button = findViewById(R.id.button_reset);
        newGame = findViewById(R.id.new_game_button);

        reser_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetGame();
            }
        });

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResetBoard();
            }
        });

        button[0][0] = findViewById(R.id.button_00);
        button[0][1] = findViewById(R.id.button_01);
        button[0][2] = findViewById(R.id.button_02);
        button[1][0] = findViewById(R.id.button_10);
        button[1][1] = findViewById(R.id.button_11);
        button[1][2] = findViewById(R.id.button_12);
        button[2][0] = findViewById(R.id.button_20);
        button[2][1] = findViewById(R.id.button_21);
        button[2][2] = findViewById(R.id.button_22);

        for (int i=0; i<3;i++){
            for (int j=0;j<3;j++){
                button[i][j].setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View view) {
        Button b = (Button)view;

        if (!b.getText().toString().equals("")){
            return;
        }if (player1Turn){
            b.setText("X");
        }else {
            b.setText("O");
        }
        roundCounts++;

        if (checkforWin()){
            if (player1Turn){
                Player1Wins();
            }else {
                Player2Wins();
            }
        }else if (roundCounts == 9){
                Draw();
            }
        else {
            player1Turn = !player1Turn;
        }
    }

    private void Player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins", Toast.LENGTH_LONG).show();
        UpdatePointsText();
    }

    private void Player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins", Toast.LENGTH_LONG).show();
        UpdatePointsText();
    }

    private void Draw() {
        Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
    }

    private void ResetGame(){
        player1Points = 0;
        player2Points = 0;
        UpdatePointsText();
        ResetBoard();
    }

    private void UpdatePointsText() {
        textViewPlayer1.setText("Player 1:"+player1Points);
        textViewPlayer2.setText("Player 2:"+player2Points);
    }

    private void ResetBoard() {
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                button[i][j].setText("");
            }
        }
    }

    private boolean checkforWin(){
        String field[][] = new String[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                field[i][j] = button[i][j].getText().toString();
            }
        }

        for (int i=0;i<3;i++){
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && !field[i][0].equals("")){
                return true;
            }
        }

        for (int i=0;i<3;i++){
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && !field[0][i].equals("")){
                return true;
            }
        }

        if (field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2]) && !field[0][0].equals("")){
            return true;
        }

        if (field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0]) && !field[0][2].equals("")){
            return true;
        }

        return false;
    }
}
