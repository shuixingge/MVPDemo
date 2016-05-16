package com.android.mvpdemo.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.mvpdemo.R;
import com.android.mvpdemo.bean.Person;
import com.android.mvpdemo.presenter.Presenter;
import com.android.mvpdemo.view.PersonView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements PersonView {
    private ProgressDialog pd = null;
    @Bind(R.id.name)
    TextView name_tv;
    @Bind(R.id.country)
    TextView country_tv;
    @Bind(R.id.gender)
    TextView gender_tv;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.profile_image)
    CircleImageView avatar;
    Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        pd = new ProgressDialog(this);
        pd.setMessage("正在加载……");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getPersonInfo();
            }
        });


    }

    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.cancel();
    }

    @Override
    public void toMainActivity(Person person) {
        name_tv.setText(person.getId());
        country_tv.setText(person.getCountry());
        gender_tv.setText(person.getGender());
        String avatarUrl = person.getAvatarUrl();
        Log.i("tag", avatarUrl);
        Picasso.with(this)
                .load(avatarUrl)
                .into(avatar);
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "获取信息有误", Toast.LENGTH_SHORT).show();
    }
}
