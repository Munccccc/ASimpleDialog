package com.munc.asimpledialog;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.munc.asimpledialog.util.DialogUtils;
import com.munc.asimpledialog.widget.SimpleArcDialog;
import com.munc.asimpledialog.widget.SimpleArcLoader;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.loader)
    SimpleArcLoader mSimpleArcLoader;
    private SimpleArcDialog mDialog;

    Handler mhandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        getDialog();
    }

    private void getDialog() {
        mDialog = DialogUtils.setSimpleDialog(MainActivity.this, mSimpleArcLoader);
    }

    @OnClick(R.id.bt)
    public void onViewClicked() {
        mDialog.show();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDialog.dismiss();
            }
        }, 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mhandler.removeCallbacksAndMessages(null);
    }
}
