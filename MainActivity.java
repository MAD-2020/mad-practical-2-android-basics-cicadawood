package sg.edu.np.mad.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private TextView textViewScore;
    private int score = 0;

    private static final String TAG = "Whack-A-Mole";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Finished Pre-Initialisation!");


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        textViewScore = findViewById(R.id.score);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


        textViewScore.setText("0");




    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        textViewScore.setText("0");
        Log.v(TAG, "Starting GUI!");
    }

    @Override
    public void onClick(View v) {
        String logMsg;
        switch (v.getId()){
            case R.id.btn1:
                if (((Button) v).getText().toString().equals("*")){
                    score += 1;
                    setNewMole();
                    textViewScore.setText(String.valueOf(score));
                    logMsg = "Hit, score added!";
                }
                else{
                    score-=1;
                    setNewMole();
                    textViewScore.setText(String.valueOf(score));
                    logMsg= "Missed, score deducted!";
                }
                Log.v(TAG,"Button Left Clicked!\n"+logMsg);
                break;

            case R.id.btn2:

                if (((Button) v).getText().toString().equals("*")){
                    score += 1;
                    setNewMole();
                    textViewScore.setText(String.valueOf(score));
                    logMsg = "Hit, score added!";
                }
                else{
                    score-=1;
                    setNewMole();
                    textViewScore.setText(String.valueOf(score));
                    logMsg= "Missed, score deducted!";
                }
                Log.v(TAG,"Button Middle Clicked!\n"+logMsg);
                break;

            case R.id.btn3:

                if (((Button) v).getText().toString().equals("*")){
                    score += 1;
                    setNewMole();
                    textViewScore.setText(String.valueOf(score));
                    logMsg = "Hit, score added!";
                }
                else{
                    score-=1;
                    setNewMole();
                    textViewScore.setText(String.valueOf(score));
                    logMsg= "Missed, score deducted!";
                }
                Log.v(TAG,"Button Right Clicked!\n"+logMsg);
                break;

        }
    }

    private void setNewMole(){
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if (randomLocation ==1){
            btn1.setText("*");
            btn2.setText("O");
            btn3.setText("O");
        }
        else if (randomLocation ==2){
            btn1.setText("O");
            btn2.setText("*");
            btn3.setText("O");
        }
        else{
            btn1.setText("O");
            btn2.setText("O");
            btn3.setText("*");
        }
    }
}
