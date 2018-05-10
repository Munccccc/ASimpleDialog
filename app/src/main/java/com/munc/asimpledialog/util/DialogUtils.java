package com.munc.asimpledialog.util;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.munc.asimpledialog.R;
import com.munc.asimpledialog.widget.ArcConfiguration;
import com.munc.asimpledialog.widget.SimpleArcDialog;
import com.munc.asimpledialog.widget.SimpleArcLoader;


/**
 * Created by DELL on 2018/4/25.
 */

public class DialogUtils {
    private static int mColors[] = {Color.parseColor("#C2100D")};// CG

    public static SimpleArcDialog setSimpleDialog(@NonNull Context context, SimpleArcLoader mSimpleArcLoader) {
        final SimpleArcDialog mDialog = new SimpleArcDialog(context, R.style.iphone_progress_dialog, null);
        mDialog.setConfiguration(new ArcConfiguration(context));
        mDialog.showWindow(false);
        mDialog.setCancelable(false);
        ArcConfiguration configuration = new ArcConfiguration(context);
        configuration.setLoaderStyle(SimpleArcLoader.STYLE.SIMPLE_ARC);
        configuration.setColors(mColors);
        configuration.setText("加载中...");
        configuration.setArcMargin(10);
        configuration.setAnimationSpeed(SimpleArcLoader.SPEED_FAST);
//      configuration.setAnimationSpeedWithIndex(SimpleArcLoader.SPEED_FAST);
        // Using this configuration with Dialog
        mDialog.setConfiguration(configuration);
        // Using this configuration with ArcLoader
        mSimpleArcLoader.refreshArcLoaderDrawable(configuration);
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (mDialog != null && mDialog.isShowing()) {
                    mDialog.dismiss();
                }
            }
        });
        return mDialog;
    }

}
