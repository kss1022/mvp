package com.example.mvp;

import android.util.Log;

public class MainPresenter implements MainContract.Presenter{
    private  MainContract.View mView;


    //Datab을 가진다 -> Model
    //SetData에서 Model의 데이터를 가지고 설정해줌


    public MainPresenter(MainContract.View view)
    {
        mView = view;
        mView.setPresenter(this);
    }


    @Override
    public void start() {
        Log.d("MainPresenter", "MainPresenter Start");
        setData();
    }



    void setData()
    {
        if(!mView.isActive())
        {
            mView.showMissingTask();
            return;
        }

        String[] fakeData = { "a", "b", "c" , "d", "e" , "f", "g"};


        mView.setAdapterData(fakeData);
    }




}
