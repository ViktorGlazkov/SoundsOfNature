package com.dev.viktorg.soundsofnature.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.dev.viktorg.soundsofnature.R;
import com.dev.viktorg.soundsofnature.service.ListViewService;
import com.dev.viktorg.soundsofnature.service.MediaPlayerService;
import com.dev.viktorg.soundsofnature.quiz.Quiz;
import com.dev.viktorg.soundsofnature.quiz.QuizService;

public class QuizActivity extends AppCompatActivity {
    private Quiz quiz;
    private QuizService quizService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quizService = new QuizService();

        setListView();
    }

    private void setListView() {
        quiz = quizService.getQuiz(this);
        TextView pointsTextView = (TextView) findViewById(R.id.points);
        pointsTextView.setText(getString(R.string.points) + quizService.getPoints());

        TextView imagesTextView = (TextView) findViewById(R.id.img_text_viev);
        imagesTextView.setText(getString(R.string.images) + quiz.getImageIds().size());

        ListViewService.setListView(this, quiz.getNames(), quiz.getImageIds(),
                R.id.quiz_list, getListener());

        MediaPlayerService.playMusicById(this, quiz.getAudioId());
    }

    private AdapterView.OnItemClickListener getListener() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MediaPlayerService.stopMusic();

                if (isRight(position)) {
                    quizService.addPoint();

                    if (isWin()) {
                        quizService.showSuccesfulDialog(QuizActivity.this);

                    } else {
                        setListView();
                    }

                } else {
                    quizService.showFailtureDialog(QuizActivity.this, quiz.getTrueImageId());
                }
            }
        };
    }

    private boolean isRight(int position) {
        return quiz.getImageIds().get(position) == quiz.getTrueImageId();
    }

    private boolean isWin() {
        return quizService.getPoints() >= 25;
    }
}
