package com.zgluis.ricknmorty;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zgluis.ricknmorty.shared.RicknmortyService;
import com.zgluis.ricknmorty.ui.main.MainFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    RicknmortyService ricknmortyService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((RicknmortyApplication) (getApplicationContext())).getDependencyComponent().inject(this);

        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}
