package com.zgluis.ricknmorty.shared;

import com.zgluis.ricknmorty.shared.response.FetchCharactersResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface CharactersAPI {

    String CONTEXT = "character";

    @GET(CONTEXT)
    Single<FetchCharactersResponse> fetch();

}
