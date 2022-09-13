package com.example.quiz;

import android.app.Activity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button ansA, ansB, ansC;
    //Button submitBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.questão.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        totalQuestionsTextView = findViewById(R.id.total_questions);
//        questionTextView = findViewById(R.id.question);
//        ansA = findViewById(R.id.ans_A);
//        ansB = findViewById(R.id.ans_B);
//        ansC = findViewById(R.id.ans_C);
//        //submitBtn = findViewById(R.id.submit_btn);
//
//        ansA.setOnClickListener(this);
//        ansB.setOnClickListener(this);
//        ansC.setOnClickListener(this);
//
//        //submitBtn.setOnClickListener(this);
//
//        totalQuestionsTextView.setText("Level "+totalQuestion);
//
//        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
//        if(clickedButton.getId()==R.id.submit_btn){
//            if(selectedAnswer.equals(QuestionAnswer.escolhaCerta
//                    [currentQuestionIndex])){
//                score++;
//            }
//            currentQuestionIndex++;
//            loadNewQuestion();
//        }else{
//            //choices button clicked
//            selectedAnswer  = clickedButton.getText().toString();
//            clickedButton.setBackgroundColor(Color.MAGENTA);
//
//        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.questão[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.escolha[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.escolha[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.escolha[currentQuestionIndex][2]);

    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }

}