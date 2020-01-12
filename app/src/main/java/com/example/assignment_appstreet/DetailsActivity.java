package com.example.assignment_appstreet;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity  extends AppCompatActivity {
    public TextView usernameTv,nameTv,urlTv,avtarTv,repoTv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.git_detail);

        usernameTv = (TextView) findViewById(R.id.usernameTv);
        nameTv = (TextView) findViewById(R.id.nameTv);
        urlTv = (TextView) findViewById(R.id.urlTv);
        findViewById(R.id.repoTv).setVisibility(View.GONE);
        findViewById(R.id.avtarTv).setVisibility(View.GONE);


       usernameTv.setText("Name: "+getIntent().getStringExtra("name"));
       nameTv.setText("Desc: "+getIntent().getStringExtra("desc"));
       urlTv.setText("URL: "+getIntent().getStringExtra("url"));

    }
}
