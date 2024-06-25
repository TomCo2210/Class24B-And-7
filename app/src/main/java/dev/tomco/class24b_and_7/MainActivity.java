package dev.tomco.class24b_and_7;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.textview.MaterialTextView;

import dev.tomco.class24b_and_7.Interfaces.MoveCallback;
import dev.tomco.class24b_and_7.Utilities.MoveDetector;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView main_LBL_movex;
    private MaterialTextView main_LBL_movey;

    private ExtendedFloatingActionButton main_BTN_send;

    private MoveDetector moveDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initMoveDetector();

        initViews();
    }

    private void initViews() {
        main_BTN_send.setOnClickListener((view) -> {
            String text = "Hello World!";
            Intent i = new Intent(getApplicationContext(), ScoreActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("KEY_MESSAGE", text);
            i.putExtras(bundle);
            startActivity(i);
            finish();
        });
    }

    private void initMoveDetector() {
        moveDetector = new MoveDetector(this,
                new MoveCallback() {
                    @Override
                    public void moveX() {
                        main_LBL_movex.setText(String.valueOf(moveDetector.getMoveCountX()));
                    }

                    @Override
                    public void moveY() {
                        main_LBL_movey.setText(String.valueOf(moveDetector.getMoveCountY()));
                    }
                });
    }

    private void findViews() {
        main_LBL_movex = findViewById(R.id.main_LBL_movex);
        main_LBL_movey = findViewById(R.id.main_LBL_movey);
        main_BTN_send = findViewById(R.id.main_BTN_send);

    }

    @Override
    protected void onPause() {
        super.onPause();
        moveDetector.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        moveDetector.start();
    }
}