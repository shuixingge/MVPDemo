package com.android.mvpdemo.model;

import com.android.mvpdemo.apis.PersonApi;
import com.android.mvpdemo.bean.Person;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zhaoruolei1992 on 2016/5/16.
 */
public class PersonInfo implements IModelInfo {
    @Override
    public void getPersonInfo(final OnPersonInfoListener listener) {
        try {
            PersonApi personApi = PersonApi.getPersonApi();
            personApi.getRxService()
                    .fetchPersonResult()
                    .subscribeOn(Schedulers.newThread())
                    .map(new Func1<List<Person>, Person>() {
                        @Override
                        public Person call(List<Person> persons) {
                            return persons.get(0);
                        }
                    })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Person>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            listener.getUserInfoFailed();
                        }

                        @Override
                        public void onNext(Person person) {
                            listener.getUserInfoSuccess(person);
                        }
                    });


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
