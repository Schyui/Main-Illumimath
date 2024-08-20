package com.example.ror;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

public class Menu extends AppCompatActivity {
    Dialog myDialog;
    MediaPlayer menu, start;
    private Button Play;
    private ImageButton btnMute, btnUnmute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        menu = MediaPlayer.create(Menu.this, R.raw.menu);
        start = MediaPlayer.create(Menu.this, R.raw.press);
        start.setLooping(false);
        menu.setLooping(true);
        menu.start();



        final Button btnOpenPopup = (Button)findViewById(R.id.settingsbutton);
        btnOpenPopup.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                start.start();
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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Play= (Button) findViewById(R.id.startbutton);
        Play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openMainAct();
                menu.stop();
                start.start();


            }
        });
        //for settings button/popup
        myDialog = new Dialog(this);

    }
    //for settings button/popup
    public void ShowPopupSettings(View v) {
        start.start();
        ImageView imgclose;
        myDialog.setContentView(R.layout.settingspopup);
        imgclose = (ImageView) myDialog.findViewById(R.id.closebutton);
        imgclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });
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
        start.start();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    //for start button, transition to intro+dialogue
    public void openMainAct(){
        Intent intent = new Intent(this, SceneIntro.class);
        startActivity(intent);
    }
    @Override
    protected void onPause() {
        super.onPause();
        menu.release();
        finish();
    }

}