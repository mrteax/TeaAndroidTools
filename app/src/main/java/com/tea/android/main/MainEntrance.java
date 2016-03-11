package com.tea.android.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.LinearLayout;

import com.tea.android.utils.InputTypeActivity;
import com.tea.android.utils.KeyboardHeightDetector;
import com.tea.android.utils.R;

/**
 * Created by brc on 16/3/11.
 */
public class MainEntrance extends AppCompatActivity {
    private LinearLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);
        initScreen();
    }

    private void initScreen() {
        rootView = (LinearLayout) this.findViewById(R.id.root_view);
        setup();
    }

    private void setup() {
        for (final ToolsItem item : ToolsItem.values()) {
            AppCompatButton iBtn = new AppCompatButton(this);
            iBtn.setText(item.getTitle());
            iBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.setClass(MainEntrance.this, item.getJumpActivity());
                    MainEntrance.this.startActivity(intent);
                }
            });
            rootView.addView(iBtn);
        }
    }

    enum ToolsItem {
        KEYBOARDHEIGHTDETECTOR {
            @Override
            public String getTitle() {
                return "keyboard height detector";
            }

            @Override
            public Class<?> getJumpActivity() {
                return KeyboardHeightDetector.class;
            }
        },
        INPUTTYPEACTIVITY {
            @Override
            public String getTitle() {
                return "input type editors";
            }

            @Override
            public Class<?> getJumpActivity() {
                return InputTypeActivity.class;
            }
        },
        ;
        public abstract String getTitle();
        public abstract Class<?> getJumpActivity();

    }

}
