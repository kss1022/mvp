package com.example.mvp;

public class MainContract {

    interface View extends  BaseView<Presenter>
    {
        void setAdapterData(String[] data);


        boolean isActive();
        void showMissingTask();
    }


    interface  Presenter extends BasePresenter
    {
    }

}
