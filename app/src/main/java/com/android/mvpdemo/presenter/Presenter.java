package com.android.mvpdemo.presenter;

import com.android.mvpdemo.bean.Person;
import com.android.mvpdemo.model.OnPersonInfoListener;
import com.android.mvpdemo.model.PersonInfo;
import com.android.mvpdemo.view.PersonView;

/**
 * Created by zhaoruolei1992 on 2016/5/16.
 */
public class Presenter {
    private PersonInfo personInfo;
    private PersonView personView;

    public Presenter(PersonView personView) {
        this.personInfo = new PersonInfo();
        this.personView = personView;
    }
    public void getPersonInfo() {
        try {
            personView.showLoading();
            personInfo.getPersonInfo( new OnPersonInfoListener() {
                @Override
                public void getUserInfoSuccess(Person person) {
                         personView.toMainActivity(person);
                         personView.hideLoading();
                }

                @Override
                public void getUserInfoFailed() {
                         personView.showFailedError();
                         personView.hideLoading();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
