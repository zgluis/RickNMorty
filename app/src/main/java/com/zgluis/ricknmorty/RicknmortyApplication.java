package com.zgluis.ricknmorty;

import android.app.Application;

import com.zgluis.ricknmorty.shared.ApplicationModule;
import com.zgluis.ricknmorty.shared.DaggerDependencyComponent;
import com.zgluis.ricknmorty.shared.DependencyComponent;
import com.zgluis.ricknmorty.shared.NetworkModule;

import static com.zgluis.ricknmorty.BuildConfig.BASE_URL;

public class RicknmortyApplication extends Application {

    private DependencyComponent mDependencyComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mDependencyComponent = DaggerDependencyComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(BASE_URL))
                .build();
        mDependencyComponent.inject(this);
    }

    public DependencyComponent getDependencyComponent() {
        return mDependencyComponent;
    }
}
