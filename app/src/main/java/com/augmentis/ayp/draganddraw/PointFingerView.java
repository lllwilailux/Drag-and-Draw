package com.augmentis.ayp.draganddraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilailux on 8/30/2016.
 */
public class PointFingerView extends View {

    private static final String TAG = "PointFingerView";

    private PointF mCircleCenter;
    private Paint mBoxPaint;
    private Paint mBackgroundPaint;

    private List<PointF> mCircleList = new ArrayList<>();

    public PointFingerView(Context context) {
        super(context,null);
    }

    public PointFingerView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x22ff0000);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xfff8efe0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);

        for (PointF p : mCircleList) {
            canvas.drawCircle(p.x,p.y,150,mBoxPaint);
        }

//        if (mCircleCenter != null) {
//            canvas.drawCircle(mCircleCenter.x,mCircleCenter.y,150,mBoxPaint);
//        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);
        int index = MotionEventCompat.getActionIndex(event);
        int touchCount = event.getPointerCount();

        PointF currentPoint = new PointF(event.getX(),event.getY());

        Log.i(TAG,"index = " + index
                +",action = " + actionToString(action)
                + ",pointer = " + currentPoint);

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mCircleList.add(new PointF(event.getX(),event.getY()));
//                mCircleCenter = currentPoint;
                break;

            case MotionEvent.ACTION_MOVE:
                for (int i = 0; i < touchCount; i++) {
                    mCircleList.get(i).x = event.getX(i);
                    mCircleList.get(i).y = event.getY(i);
                }
                break;
//                mCircleCenter = currentPoint;
//                Log.i(TAG,"Move : " +currentPoint);

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mCircleList.clear();
//                mCircleCenter = null;
//                invalidate();
                break;

            case MotionEvent.ACTION_POINTER_DOWN:
                mCircleList.add(new PointF(event.getX(index),event.getY(index)));
                break;

            case MotionEvent.ACTION_POINTER_UP:
                mCircleList.remove(index);
                break;
        }
        invalidate();
        return true;
    }

    public static String actionToString(int action) {
        switch (action) {

            case MotionEvent.ACTION_DOWN: return "Down";
            case MotionEvent.ACTION_MOVE: return "Move";
            case MotionEvent.ACTION_POINTER_DOWN: return "Pointer Down";
            case MotionEvent.ACTION_UP: return "Up";
            case MotionEvent.ACTION_POINTER_UP: return "Pointer Up";
            case MotionEvent.ACTION_OUTSIDE: return "Outside";
            case MotionEvent.ACTION_CANCEL: return "Cancel";
        }
        return "";
    }
}
