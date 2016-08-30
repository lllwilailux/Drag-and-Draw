package com.augmentis.ayp.draganddraw;

import android.support.v4.app.Fragment;

/**
 * Created by Wilailux on 8/30/2016.
 */
public class DragAndDrawActivity extends SingleFragmentActivity {
    @Override
    protected Fragment onCreateFragment() {
        return DragAndDrawFragment.newInstance();
    }
}
