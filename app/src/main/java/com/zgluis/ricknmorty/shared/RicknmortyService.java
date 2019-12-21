package com.zgluis.ricknmorty.shared;

import android.app.Application;
import android.util.Log;

import com.zgluis.ricknmorty.RicknmortyApplication;
import com.zgluis.ricknmorty.shared.response.FetchCharactersResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class RicknmortyService {

    @Inject
    Retrofit retrofit;

    private static String TAG = "RicknmortyService";

    private RicknmortyApplication ricknmortyApplication;
    private CharactersAPI charactersAPI;

    public RicknmortyService(Application application) {
        this.ricknmortyApplication = (RicknmortyApplication) application;
        this.ricknmortyApplication.getDependencyComponent().inject(this);
        charactersAPI = retrofit.create(CharactersAPI.class);
    }

    public Single<FetchCharactersResponse> fetchCharacters() {
        Log.d(TAG, "fetchCharacters()");
        return charactersAPI.fetch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
