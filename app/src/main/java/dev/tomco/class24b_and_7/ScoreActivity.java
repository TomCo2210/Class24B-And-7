package dev.tomco.class24b_and_7;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textview.MaterialTextView;

public class ScoreActivity extends AppCompatActivity {

    private MaterialTextView score_LBL_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        findViews();
        initViews();
    }

    private void findViews() {
        score_LBL_text = findViewById(R.id.score_LBL_text);
    }

    private void initViews() {
        Intent prev = getIntent();
        score_LBL_text.setText(prev.getExtras().getString("KEY_MESSAGE"));
    }
}