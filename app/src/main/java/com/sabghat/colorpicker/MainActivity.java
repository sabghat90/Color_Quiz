package com.sabghat.colorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestionNo, tvQuestion;
    private Button btnOption1, btnOption2, btnOption3, btnOption4;
    private ArrayList<ModelClass> colorPickerModelClassArrayList;
    Random random;
    int currentScore = 1, questionAttempted = 1, currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hooks
        tvQuestionNo = findViewById(R.id.tv_no_of_questions);
        tvQuestion = findViewById(R.id.tv_question);
        btnOption1 = findViewById(R.id.btn_option1);
        btnOption2 = findViewById(R.id.btn_option2);
        btnOption3 = findViewById(R.id.btn_option3);
        btnOption4 = findViewById(R.id.btn_option4);

        colorPickerModelClassArrayList = new ArrayList<>();
        random = new Random();

        initData(colorPickerModelClassArrayList);

        currentPosition = random.nextInt(colorPickerModelClassArrayList.size());

        setDataToViews(currentPosition);


        // Buttons onClick
        btnOption1.setOnClickListener(view -> {
            if (colorPickerModelClassArrayList.get(currentPosition).getAnswer() == colorPickerModelClassArrayList.get(currentPosition).getOption1()) {
                currentScore++;
            }
            questionAttempted++;
            currentPosition = random.nextInt(colorPickerModelClassArrayList.size());
            setDataToViews(currentPosition);
        });

        btnOption2.setOnClickListener(view -> {
            if (colorPickerModelClassArrayList.get(currentPosition).getAnswer() == colorPickerModelClassArrayList.get(currentPosition).getOption2()) {
                currentScore++;
            }
            questionAttempted++;
            currentPosition = random.nextInt(colorPickerModelClassArrayList.size());
            setDataToViews(currentPosition);
        });

        btnOption3.setOnClickListener(view -> {
            if (colorPickerModelClassArrayList.get(currentPosition).getAnswer() == colorPickerModelClassArrayList.get(currentPosition).getOption3()) {
                currentScore++;
            }
            questionAttempted++;
            currentPosition = random.nextInt(colorPickerModelClassArrayList.size());
            setDataToViews(currentPosition);
        });

        btnOption4.setOnClickListener(view -> {
            if (colorPickerModelClassArrayList.get(currentPosition).getAnswer() == colorPickerModelClassArrayList.get(currentPosition).getOption4()) {
                currentScore++;
            }
            questionAttempted++;
            currentPosition = random.nextInt(colorPickerModelClassArrayList.size());
            setDataToViews(currentPosition);
        });
    }

    private void bottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView =
                LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,
                        (LinearLayout)findViewById(R.id.idLLScore));

        TextView tvScore = bottomSheetView.findViewById(R.id.tv_score);
        Button btnRestart = bottomSheetView.findViewById(R.id.btn_restart);

        tvScore.setText("Your Score Is " + currentScore);

        btnRestart.setOnClickListener(view -> {
            currentPosition = random.nextInt(colorPickerModelClassArrayList.size());
            setDataToViews(currentPosition);
            questionAttempted = 1;
            currentScore = 0;
            bottomSheetDialog.dismiss();
        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentPosition) {
        tvQuestionNo.setText(questionAttempted + "/10");

        if (questionAttempted == 10){
            bottomSheet();
        }
        else {
            tvQuestion.setText(colorPickerModelClassArrayList.get(currentPosition).getQuestion());

            btnOption1.setBackgroundColor(colorPickerModelClassArrayList.get(currentPosition).getOption1());
            btnOption2.setBackgroundColor(colorPickerModelClassArrayList.get(currentPosition).getOption2());
            btnOption3.setBackgroundColor(colorPickerModelClassArrayList.get(currentPosition).getOption3());
            btnOption4.setBackgroundColor(colorPickerModelClassArrayList.get(currentPosition).getOption4());
        }


    }

    private void initData(ArrayList<ModelClass> colorPickerModelClassArrayList) {
        colorPickerModelClassArrayList.add(new ModelClass("Select the BLUE Color: ",Color.CYAN,
                Color.BLACK,Color.BLUE,Color.MAGENTA,Color.BLUE));

        colorPickerModelClassArrayList.add(new ModelClass("Select the BLACK Color: ",Color.BLACK,
                Color.WHITE,Color.RED,Color.YELLOW,Color.BLACK));

        colorPickerModelClassArrayList.add(new ModelClass("Select the RED Color: ",Color.YELLOW,
                Color.WHITE,Color.BLACK,Color.RED,Color.RED));

        colorPickerModelClassArrayList.add(new ModelClass("Select the GREEN Color: ",Color.GREEN,
                Color.WHITE,Color.BLUE,Color.YELLOW,Color.GREEN));

        colorPickerModelClassArrayList.add(new ModelClass("Select the BLACK Color: ",Color.BLACK,
                Color.MAGENTA,Color.GREEN,Color.RED,Color.BLACK));

        colorPickerModelClassArrayList.add(new ModelClass("Select the YELLOW Color: ",Color.YELLOW,
                Color.WHITE,Color.MAGENTA,Color.BLACK,Color.YELLOW));

        colorPickerModelClassArrayList.add(new ModelClass("Select the MAGENTA Color: ",Color.RED,
                Color.WHITE,Color.MAGENTA,Color.YELLOW,Color.MAGENTA));

        colorPickerModelClassArrayList.add(new ModelClass("Select the LTGRAY Color: ",Color.RED,
                Color.WHITE,Color.MAGENTA,Color.LTGRAY,Color.LTGRAY));

        colorPickerModelClassArrayList.add(new ModelClass("Select the DKGRAY Color: ",Color.RED,
                Color.WHITE,Color.MAGENTA,Color.DKGRAY,Color.DKGRAY));

        colorPickerModelClassArrayList.add(new ModelClass("Select the YELLOW Color: ",Color.RED,
                Color.WHITE,Color.MAGENTA,Color.YELLOW,Color.YELLOW));
    }
}