package com.augmentis.ayp.draganddraw;

import android.graphics.Point;
import android.graphics.PointF;

/**
 * Created by Wilailux on 8/30/2016.
 */
public class Box {
    PointF mStart;
    PointF mEnd;

    public PointF getStart() {
        return mStart;
    }

    public void setStart(PointF start) {
        mStart = start;
    }

    public PointF getEnd() {
        return mEnd;
    }

    public void setEnd(PointF end) {
        mEnd = end;
    }
}
