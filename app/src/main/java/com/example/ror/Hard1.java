package com.example.ror;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import android.graphics.drawable.AnimationDrawable;

public class Hard1 extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView, ScoreText;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button buttonStart1;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    MediaPlayer menu, start;
    private int life=3;
    ImageView idle, wizard, fightwiz, dead, fight, fightring, heartOne,heartTwo,heartThree, dialogBox, wizspell;

    AnimationDrawable animidle, animdead, animfight, animwiz, animfightwiz,animfightring;

    private Button  Restart, Continue, Exit;
    private TextView GameOver, fightview;

    Dialog myDialog;
    private Button  retry;
    private ImageButton Home,Retry,SettingsGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard1);

        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        myDialog = new Dialog(this);
        menu = MediaPlayer.create(Hard1.this, R.raw.h1);
        menu.setLooping(true);
        idle=(ImageView) findViewById(R.id.character);
        idle.setBackgroundResource(R.drawable.character);
        idle.setVisibility(View.VISIBLE);
        animidle = (AnimationDrawable) idle.getBackground();
        animidle.start();
        final ImageButton btnOpenPopup = (ImageButton)findViewById(R.id.btnsettings);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                btnOpenPopup.setEnabled(false);
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.settingspopup2, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                ImageButton btnDismiss = (ImageButton)popupView.findViewById(R.id.dismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                        btnOpenPopup.setEnabled(true);
                    }});

                ImageButton btnUnmute = (ImageButton)popupView.findViewById(R.id.onbuttonimg);
                btnUnmute.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        menu.setVolume(1,1);
                    }
                });

                ImageButton btnMmute = (ImageButton)popupView.findViewById(R.id.offbuttonimg);
                btnMmute.setOnClickListener(new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        menu.setVolume(0,0);
                    }});

                popupWindow.showAtLocation(btnOpenPopup, Gravity.CENTER, 0, 0);

            }});

        TextView fightview = findViewById(R.id.startfight);
        fightview.setVisibility(View.INVISIBLE);

        wizard=(ImageView) findViewById(R.id.wizard);
        wizard.setBackgroundResource(R.drawable.hardanim);
        animwiz = (AnimationDrawable) wizard.getBackground();
        animwiz.start();

        fight = (ImageView) findViewById(R.id.characterattack);
        fight.setBackgroundResource(R.drawable.fightcharacterburst);
        fight.setVisibility(View.INVISIBLE);
        animfight = (AnimationDrawable) fight.getBackground();

        fightwiz = (ImageView) findViewById(R.id.wizattack);
        fightwiz.setBackgroundResource(R.drawable.fightwizard);
        fightwiz.setVisibility(View.INVISIBLE);
        animfightwiz = (AnimationDrawable) fightwiz.getBackground();



        fightring = (ImageView) findViewById(R.id.fightring);
        fightring.setBackgroundResource(R.drawable.fightcharacter);
        fightring.setVisibility(View.INVISIBLE);
        animfightring = (AnimationDrawable) fightring.getBackground();

        heartOne=(ImageView)findViewById(R.id.heart1);
        heartTwo=(ImageView)findViewById(R.id.heart2);
        heartThree=(ImageView)findViewById(R.id.heart3);
        wizspell = (ImageView) findViewById(R.id.wizspell);

        dialogBox=(ImageView)findViewById(R.id.dialogbox);

        GameOver = (TextView) findViewById(R.id.GameOver);
        GameOver.setVisibility(View.INVISIBLE);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        buttonStart1= (Button) findViewById(R.id.buttonStart);

        Restart= (Button) findViewById(R.id.Restart);
        Restart.setVisibility(View.INVISIBLE);
        Exit= (Button) findViewById(R.id.Exit);
        Exit.setVisibility(View.INVISIBLE);
        Home= findViewById(R.id.home);
        Home.setVisibility(View.VISIBLE);
        Retry= findViewById(R.id.retry);
        Retry.setVisibility(View.VISIBLE);
        SettingsGame= findViewById(R.id.btnsettings);
        SettingsGame.setVisibility(View.VISIBLE);


        Continue= (Button) findViewById(R.id.Continue);
        Continue.setVisibility(View.INVISIBLE);
        Continue.setEnabled(false);

        mQuestionView.setVisibility(View.INVISIBLE);
        mButtonChoice1.setVisibility(View.INVISIBLE);
        mButtonChoice2.setVisibility(View.INVISIBLE);
        mButtonChoice3.setVisibility(View.INVISIBLE);
        dialogBox.setVisibility(View.INVISIBLE);
        Restart.setEnabled(false);
        Exit.setEnabled(false);
        mButtonChoice1.setEnabled(false);
        mButtonChoice2.setEnabled(false);
        mButtonChoice3.setEnabled(false);
        heartOne.setVisibility(View.INVISIBLE);
        heartTwo.setVisibility(View.INVISIBLE);
        heartThree.setVisibility(View.INVISIBLE);
        wizspell.setVisibility(View.INVISIBLE);

        ScoreText= findViewById(R.id.score_text);
        mScoreView.setVisibility(View.INVISIBLE);
        ScoreText.setVisibility(View.INVISIBLE);
        mScoreView.setText(""+mScore+"/10");

        buttonStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mButtonChoice1.setVisibility(View.VISIBLE);
                mButtonChoice2.setVisibility(View.VISIBLE);
                mButtonChoice3.setVisibility(View.VISIBLE);
                buttonStart1.setVisibility(View.INVISIBLE);
                mQuestionView.setVisibility(View.VISIBLE);
                mButtonChoice1.setEnabled(true);
                mButtonChoice2.setEnabled(true);
                mButtonChoice3.setEnabled(true);
                menu.start();
                heartOne.setVisibility(View.VISIBLE);
                heartTwo.setVisibility(View.VISIBLE);
                heartThree.setVisibility(View.VISIBLE);
                ScoreText.setVisibility(View.VISIBLE);
                dialogBox.setVisibility(View.VISIBLE);
                mScoreView.setVisibility(View.VISIBLE);
                fightview.setVisibility(View.VISIBLE);
                fightview.postDelayed(new Runnable() {
                    public void run() {
                        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                        alphaAnimation.setDuration(400);
                        fightview.startAnimation(alphaAnimation);
                        fightview.setVisibility(View.INVISIBLE);
                    }
                }, 1000);

            }
        });

        Restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainAct();
            }
        });
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice1.getText() ==mAnswer|| (mButtonChoice1.getText().equals("30"))){
                    idle.postDelayed(new Runnable() {
                        public void run() {



                            idle.setBackgroundResource(R.drawable.attackcharacter);
                            animidle = (AnimationDrawable) idle.getBackground();
                            animidle.start();

                            idle.postDelayed(new Runnable() {
                                public void run() {
                                    idle.setBackgroundResource(R.drawable.character);
                                    idle.setVisibility(View.VISIBLE);
                                    animidle = (AnimationDrawable) idle.getBackground();
                                    animidle.start();

                                }
                            }, 1000);

                        }
                    }, 100);
                    mScore = mScore+1;
                    updateScore(mScore);
                    updateQuestion();

                    animfightring.start();
                    fightring.postDelayed(new Runnable() {
                        public void run() {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                            alphaAnimation.setDuration(1500);
                            fightring.startAnimation(alphaAnimation);
                            fightring.setVisibility(View.INVISIBLE);
                        }
                    }, 500);
                    animfight.start();
                    fight.postDelayed(new Runnable() {
                        public void run() {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                            alphaAnimation.setDuration(1500);
                            fight.startAnimation(alphaAnimation);
                            fight.setVisibility(View.INVISIBLE);
                        }
                    }, 500);

                    if(mQuestionNumber==10){
                        Continue.setVisibility(View.VISIBLE);
                        ShowPopupWin();
                        Continue.setEnabled(true);
                        mButtonChoice1.setVisibility(View.INVISIBLE);
                        mButtonChoice2.setVisibility(View.INVISIBLE);
                        mButtonChoice3.setVisibility(View.INVISIBLE);
                        mQuestionView.setVisibility(View.INVISIBLE);
                        dialogBox.setVisibility(View.INVISIBLE);
                    }

                }else{

                    updateQuestion();
                    life--;
                    if(life==0){
                        Retry.setVisibility(View.INVISIBLE);
                        Home.setVisibility(View.INVISIBLE);
                        SettingsGame.setVisibility(View.INVISIBLE);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);


                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                        ShowPopup();
                        GameOver.setVisibility(View.VISIBLE);
                        heartOne.setVisibility(View.INVISIBLE);
                        mButtonChoice1.setEnabled(false);
                        mButtonChoice2.setEnabled(false);
                        mButtonChoice3.setEnabled(false);
                        Restart.setEnabled(true);
                        Restart.setVisibility(View.VISIBLE);
                        Exit.setEnabled(true);
                        Exit.setVisibility(View.VISIBLE);
                        dead=(ImageView) findViewById(R.id.characterdead);
                        dead.setBackgroundResource(R.drawable.deadcharacter);
                        animdead = (AnimationDrawable) dead.getBackground();
                        animidle.stop();
                        animdead.start();
                        animdead.setOneShot(true);
                        idle.setVisibility(View.INVISIBLE);

                        dialogBox.setVisibility(View.INVISIBLE);
                        mQuestionView.setVisibility(View.INVISIBLE);

                        Restart.setVisibility(View.INVISIBLE);

                        Restart.postDelayed(new Runnable() {
                            public void run() {
                                Restart.setVisibility(View.VISIBLE);
                            }
                        }, 1100);
                        Exit.setVisibility(View.INVISIBLE);

                        Exit.postDelayed(new Runnable() {
                            public void run() {
                                Exit.setVisibility(View.VISIBLE);
                            }
                        }, 1100);

                    }
                    if(life==3){

                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartOne.setVisibility(View.INVISIBLE);

                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }
                    if(life==2){

                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartTwo.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }
                    if(life==1){

                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartThree.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }

                }


            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText() ==mAnswer){
                    idle.postDelayed(new Runnable() {
                        public void run() {



                            idle.setBackgroundResource(R.drawable.attackcharacter);
                            animidle = (AnimationDrawable) idle.getBackground();
                            animidle.start();

                            idle.postDelayed(new Runnable() {
                                public void run() {
                                    idle.setBackgroundResource(R.drawable.character);
                                    idle.setVisibility(View.VISIBLE);
                                    animidle = (AnimationDrawable) idle.getBackground();
                                    animidle.start();

                                }
                            }, 1000);

                        }
                    }, 100);
                    mScore = mScore+1;
                    updateScore(mScore);
                    updateQuestion();

                    animfightring.start();
                    fightring.postDelayed(new Runnable() {
                        public void run() {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                            alphaAnimation.setDuration(1500);
                            fightring.startAnimation(alphaAnimation);
                            fightring.setVisibility(View.INVISIBLE);
                        }
                    }, 500);
                    animfight.start();
                    fight.postDelayed(new Runnable() {
                        public void run() {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                            alphaAnimation.setDuration(1500);
                            fight.startAnimation(alphaAnimation);
                            fight.setVisibility(View.INVISIBLE);
                        }
                    }, 500);
                    if(mQuestionNumber==10){
                        Continue.setVisibility(View.VISIBLE);
                        Continue.setEnabled(true);
                        mButtonChoice1.setVisibility(View.INVISIBLE);
                        mButtonChoice2.setVisibility(View.INVISIBLE);
                        mButtonChoice3.setVisibility(View.INVISIBLE);
                        dialogBox.setVisibility(View.INVISIBLE);
                        mQuestionView.setVisibility(View.INVISIBLE);
                        ShowPopupWin();
                    }
                }else{

                    updateQuestion();
                    life--;
                    if(life==0){
                        Retry.setVisibility(View.INVISIBLE);
                        Home.setVisibility(View.INVISIBLE);
                        SettingsGame.setVisibility(View.INVISIBLE);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                        ShowPopup();
                        GameOver.setVisibility(View.VISIBLE);
                        heartOne.setVisibility(View.INVISIBLE);
                        mButtonChoice1.setEnabled(false);
                        mButtonChoice2.setEnabled(false);
                        mButtonChoice3.setEnabled(false);
                        Restart.setEnabled(true);
                        Restart.setVisibility(View.VISIBLE);
                        Exit.setEnabled(true);
                        Exit.setVisibility(View.VISIBLE);
                        dead=(ImageView) findViewById(R.id.characterdead);
                        dead.setBackgroundResource(R.drawable.deadcharacter);
                        animdead = (AnimationDrawable) dead.getBackground();
                        animidle.stop();
                        animdead.start();
                        animdead.setOneShot(true);
                        idle.setVisibility(View.INVISIBLE);

                        dialogBox.setVisibility(View.INVISIBLE);
                        mQuestionView.setVisibility(View.INVISIBLE);

                        Restart.setVisibility(View.INVISIBLE);

                        Restart.postDelayed(new Runnable() {
                            public void run() {
                                Restart.setVisibility(View.VISIBLE);
                            }
                        }, 1100);
                        Exit.setVisibility(View.INVISIBLE);

                        Exit.postDelayed(new Runnable() {
                            public void run() {
                                Exit.setVisibility(View.VISIBLE);
                            }
                        }, 1100);
                    }
                    if(life==3){
                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartOne.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }
                    if(life==2){
                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartTwo.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }
                    if(life==1){
                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartThree.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }

                }

            }

        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((mButtonChoice3.getText() == mAnswer) ){
                    idle.postDelayed(new Runnable() {
                        public void run() {



                            idle.setBackgroundResource(R.drawable.attackcharacter);
                            animidle = (AnimationDrawable) idle.getBackground();
                            animidle.start();

                            idle.postDelayed(new Runnable() {
                                public void run() {
                                    idle.setBackgroundResource(R.drawable.character);
                                    idle.setVisibility(View.VISIBLE);
                                    animidle = (AnimationDrawable) idle.getBackground();
                                    animidle.start();

                                }
                            }, 1000);

                        }
                    }, 100);
                    animfightring.start();
                    fightring.postDelayed(new Runnable() {
                        public void run() {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                            alphaAnimation.setDuration(1500);
                            fightring.startAnimation(alphaAnimation);
                            fightring.setVisibility(View.INVISIBLE);
                        }
                    }, 500);
                    animfight.start();
                    fight.postDelayed(new Runnable() {
                        public void run() {
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                            alphaAnimation.setDuration(1500);
                            fight.startAnimation(alphaAnimation);
                            fight.setVisibility(View.INVISIBLE);

                        }
                    }, 500);

                    mScore = mScore+1;

                    updateScore(mScore);
                    updateQuestion();

                    if(mQuestionNumber==10){
                        Continue.setVisibility(View.VISIBLE);
                        Continue.setEnabled(true);
                        mButtonChoice1.setVisibility(View.INVISIBLE);
                        mButtonChoice2.setVisibility(View.INVISIBLE);
                        mButtonChoice3.setVisibility(View.INVISIBLE);
                        dialogBox.setVisibility(View.INVISIBLE);
                        mQuestionView.setVisibility(View.INVISIBLE);
                        ShowPopupWin();
                    }

                }else{

                    updateQuestion();

                    life--;
                    if(life==0){
                        Retry.setVisibility(View.INVISIBLE);
                        Home.setVisibility(View.INVISIBLE);
                        SettingsGame.setVisibility(View.INVISIBLE);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                        ShowPopup();
                        GameOver.setVisibility(View.VISIBLE);
                        heartOne.setVisibility(View.INVISIBLE);
                        mButtonChoice1.setEnabled(false);
                        mButtonChoice2.setEnabled(false);
                        mButtonChoice3.setEnabled(false);
                        Restart.setEnabled(true);
                        Restart.setVisibility(View.VISIBLE);
                        Exit.setEnabled(true);
                        Exit.setVisibility(View.VISIBLE);
                        dead=(ImageView) findViewById(R.id.characterdead);
                        dead.setBackgroundResource(R.drawable.deadcharacter);
                        animdead = (AnimationDrawable) dead.getBackground();
                        animidle.stop();
                        animdead.start();
                        animdead.setOneShot(true);
                        idle.setVisibility(View.INVISIBLE);

                        dialogBox.setVisibility(View.INVISIBLE);
                        mQuestionView.setVisibility(View.INVISIBLE);

                        Restart.setVisibility(View.INVISIBLE);
                        Restart.postDelayed(new Runnable() {
                            public void run() {
                                Restart.setVisibility(View.VISIBLE);
                            }
                        }, 1100);

                        Exit.setVisibility(View.INVISIBLE);

                        Exit.postDelayed(new Runnable() {
                            public void run() {
                                Exit.setVisibility(View.VISIBLE);
                            }
                        }, 1100);

                    }
                    if(life==3){
                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartOne.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }
                    if(life==2){
                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartTwo.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }
                    if(life==1){
                        idle.setBackgroundResource(R.drawable.hitcharacter);
                        animidle = (AnimationDrawable) idle.getBackground();
                        animidle.start();
                        idle.postDelayed(new Runnable() {
                            public void run() {
                                idle.setBackgroundResource(R.drawable.character);
                                idle.setVisibility(View.VISIBLE);
                                animidle = (AnimationDrawable) idle.getBackground();
                                animidle.start();


                            }
                        }, 1500);
                        wizspell.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                wizspell.startAnimation(alphaAnimation);
                                wizspell.setVisibility(View.INVISIBLE);
                            }
                        }, 10);

                        heartThree.setVisibility(View.INVISIBLE);
                        animfightwiz.start();
                        fightwiz.postDelayed(new Runnable() {
                            public void run() {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
                                alphaAnimation.setDuration(2000);
                                fightwiz.startAnimation(alphaAnimation);
                                fightwiz.setVisibility(View.INVISIBLE);
                            }
                        }, 10);
                    }


                }

            }

        });

        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAct2();
                menu.stop();
            }
        });
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainAct();
                menu.stop();
            }
        });
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
                menu.stop();
            }
        });
        Retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainAct();
                menu.stop();
            }
        });
    }


    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestionHard(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1Hard(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2Hard(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3Hard(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswerHard(mQuestionNumber);
        mQuestionNumber++;

    }
    private void updateScore(int point){
        mScoreView.setText(""+mScore+"/10");
    }
    public void openAct2(){
        Intent intent = new Intent(this, Hard2.class);
        startActivity(intent);
    }
    public void openMainAct(){
        Intent intent = new Intent(this, Hard1.class);
        startActivity(intent);
    }

    public void openMainMenu(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
    public void ShowPopup(){
        LayoutInflater li = LayoutInflater.from(this);
        android.app.AlertDialog.Builder alertDialogBuilder = new
                android.app.AlertDialog.Builder(this);

        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.activity_popup);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        this.getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }

    public void ShowPopupWin(){
        LayoutInflater li = LayoutInflater.from(this);
        android.app.AlertDialog.Builder alertDialogBuilder = new
                android.app.AlertDialog.Builder(this);

        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.activity_popupwin);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        this.getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }


    //for exit button
    public void clickexit(View view){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
    @Override
    protected void onPause() {
        super.onPause();
        menu.release();
        finish();
    }
}