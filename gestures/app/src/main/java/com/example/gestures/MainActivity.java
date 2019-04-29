package com.example.gestures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private TextView msg;
    private GestureDetector gst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (TextView) findViewById(R.id.dmsg);
        this.gst = new GestureDetector(this,this);
        gst.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gst.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        msg.setText("onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        msg.setText("onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        msg.setText("Double Tap");
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        msg.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        msg.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        msg.setText("OnSingletapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        msg.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        msg.setText("OnLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        msg.setText("onFling");
        return false;
    }
}
