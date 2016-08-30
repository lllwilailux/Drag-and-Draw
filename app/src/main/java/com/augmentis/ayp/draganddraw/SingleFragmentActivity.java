package com.augmentis.ayp.draganddraw;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public abstract class SingleFragmentActivity extends AppCompatActivity {

private static final String TAG = "SingleFragmentActivity";

    @LayoutRes
    protected int getLayoutResId() {
        return
                R.layout.activity_single_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        Log.d(TAG, "On create activity");

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.alone_fragment);

        if( f == null ) {
            f = onCreateFragment();

            fm.beginTransaction()
                    .add(R.id.alone_fragment, f)
                    .commit();
            Log.d(TAG, "Fragment is created");
        } else {
            Log.d(TAG, "Fragment have already been created");

        }
    }

    protected abstract Fragment onCreateFragment();
}
