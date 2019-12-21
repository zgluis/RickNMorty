package com.zgluis.ricknmorty.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zgluis.ricknmorty.R;
import com.zgluis.ricknmorty.RicknmortyApplication;
import com.zgluis.ricknmorty.ui.adapters.CharacterRowAdapter;
import com.zgluis.ricknmorty.model.Character;
import com.zgluis.ricknmorty.shared.RicknmortyService;
import com.zgluis.ricknmorty.shared.response.FetchCharactersResponse;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    private final String TAG = "MainFragment";

    @Inject
    RicknmortyService ricknmortyService;

    @BindView(R.id.rv_main)
    RecyclerView rvCharacters;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        // TODO: Use the ViewModel
        fetchCharacters();
    }

    private void fetchCharacters(){
        ricknmortyService.fetchCharacters().subscribe(new SingleObserver<FetchCharactersResponse>() {
            @Override
            public void onSubscribe(Disposable d) { }

            @Override
            public void onSuccess(FetchCharactersResponse response) {
                //TODO: Validate response

                initView(response.getResults());
                Log.d(TAG, response.toString());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "Error fetching characters", e);

            }
        });
    }

    private void initView(List<Character> characters){
        rvCharacters.setAdapter(new CharacterRowAdapter(characters));
        rvCharacters.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    @Override
    public void onAttach(Context context) {
        ((RicknmortyApplication) (context.getApplicationContext())).getDependencyComponent().inject(this);
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
