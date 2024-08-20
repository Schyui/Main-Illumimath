package com.example.ror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SceneIntro extends AppCompatActivity {
    private TextView mDialogView;
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private Button mButtonDialog, Follow;
    AnimationDrawable animidle,animwiz,animstay;
    ImageView idle,wizard,stay;
    Animation walk;
    MediaPlayer menu, start;
    private int mDialogNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_scene_intro);

        menu = MediaPlayer.create(SceneIntro.this, R.raw.talkmusic);
        menu.setLooping(true);
        menu.start();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        mDialogView = (TextView) findViewById(R.id.dialogtest);
        mButtonDialog = (Button) findViewById(R.id.ClickMe);
        Follow = (Button) findViewById(R.id.Follow);
        Follow.setVisibility(View.INVISIBLE);

        idle=(ImageView) findViewById(R.id.character);
        idle.setBackgroundResource(R.drawable.character);
        idle.setVisibility(View.VISIBLE);
        animidle = (AnimationDrawable) idle.getBackground();
        animidle.start();

        stay=(ImageView) findViewById(R.id.characterstay);
        stay.setBackgroundResource(R.drawable.character);
        stay.setVisibility(View.VISIBLE);
        animstay = (AnimationDrawable) stay.getBackground();
        animstay.start();

        wizard=(ImageView) findViewById(R.id.wizard);
        wizard.setBackgroundResource(R.drawable.wizard);
        animwiz = (AnimationDrawable) wizard.getBackground();
        animwiz.start();


        walk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.walkanim);
        idle.setVisibility(View.INVISIBLE);



        stay.setVisibility(View.INVISIBLE);

        idle.postDelayed(new Runnable() {
            public void run() {
                idle.setBackgroundResource(R.drawable.walkcharacter);
                idle.startAnimation(walk);
                animidle = (AnimationDrawable) idle.getBackground();
                animidle.start();

                idle.postDelayed(new Runnable() {
                    public void run() {
                        idle.setBackgroundResource(R.drawable.character);
                        idle.setVisibility(View.VISIBLE);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();

                    }
                }, 3000);

            }
        }, 100);





        mButtonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateDialog();

                idle.setVisibility(View.VISIBLE);
                if(mDialogNumber==15){
                    mButtonDialog.setEnabled(false);
                    mDialogView.setVisibility(View.INVISIBLE);
                    mButtonDialog.setVisibility(View.INVISIBLE);
                    Follow.setVisibility(View.VISIBLE);
                    Follow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            openMainAct();
                            menu.stop();
                        }
                    });

                }
            }
        });
    }

    private void updateDialog(){
        mDialogView.setText(mQuestionLibrary.getDialogTest(mDialogNumber));

        mDialogNumber++;

    }
    public void openMainAct(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}