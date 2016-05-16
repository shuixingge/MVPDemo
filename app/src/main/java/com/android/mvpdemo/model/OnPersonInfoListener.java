package com.android.mvpdemo.model;

import com.android.mvpdemo.bean.Person;

/**
 * Created by zhaoruolei1992 on 2016/5/16.
 */
public interface OnPersonInfoListener {
    void getUserInfoSuccess(Person person);

    void getUserInfoFailed();
}
