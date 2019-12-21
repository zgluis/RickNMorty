package com.zgluis.ricknmorty.shared;

import com.zgluis.ricknmorty.MainActivity;
import com.zgluis.ricknmorty.RicknmortyApplication;
import com.zgluis.ricknmorty.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ApplicationModule.class, NetworkModule.class})
public interface DependencyComponent {
    void inject(RicknmortyApplication ricknmortyApplication);
    void inject(RicknmortyService ricknmortyService);
    void inject(MainActivity mainActivity);
    void inject(MainFragment mainFragment);
}
