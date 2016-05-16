package com.android.mvpdemo.view;

import com.android.mvpdemo.bean.Person;

/**
 * Created by zhaoruolei1992 on 2016/5/16.
 */
public interface  PersonView {
    void showLoading();
    void hideLoading();
    void toMainActivity(Person person);
    void showFailedError();
}
