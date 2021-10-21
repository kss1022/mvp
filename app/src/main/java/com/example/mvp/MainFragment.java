package com.example.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainFragment extends Fragment
implements MainContract.View{


    private  MainContract.Presenter mPresenter;

    RecyclerView mRecylcerView;
    RecyclerView.LayoutManager mLayoutManager;
    MainAdapter mMainAdatper;
    FloatingActionButton mFloatingActionButton;

    MainFragment()
    {}


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.fragment_main , container, false);

       mRecylcerView = rootView.findViewById(R.id.recycler_main);


       mLayoutManager = new LinearLayoutManager(getActivity());
       mRecylcerView.setLayoutManager(mLayoutManager);
       mRecylcerView.setHasFixedSize(true);

       mMainAdatper = new MainAdapter();

       mRecylcerView.setAdapter(mMainAdatper);


        mFloatingActionButton =  (FloatingActionButton) rootView.findViewById(R.id.fab_main_changedata);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //데이터를 바꿔준다.
                //        String[] fakeData = { "1", "2", "3" , "4", "5" , "6", "7"};

            }
        });




        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        //onResume일떄 Presenter에서 데이터를 호출한다.
        mPresenter.start();
    }

    @Override
    public void setAdapterData(String[] data) {
        mMainAdatper.setStringData(data);
    }

    @Override
    public boolean isActive() {
        // Return true if the fragment is currently added to its activity.
        return isAdded();
    }

    @Override
    public void showMissingTask() {
        Toast.makeText(getActivity(), " fragment is not currently added", Toast.LENGTH_SHORT);
    }





}
