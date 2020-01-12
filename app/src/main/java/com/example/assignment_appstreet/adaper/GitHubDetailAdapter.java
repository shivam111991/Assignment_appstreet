package com.example.assignment_appstreet.adaper;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_appstreet.DetailsActivity;
import com.example.assignment_appstreet.MainActivity;
import com.example.assignment_appstreet.R;
import com.example.assignment_appstreet.model.TopGithubModel;

import java.util.List;

public class GitHubDetailAdapter extends RecyclerView.Adapter<GitHubDetailAdapter.ViewHolder> {
    private List<TopGithubModel> items;
    MainActivity mainActivity;


    public GitHubDetailAdapter(List<TopGithubModel> items, MainActivity mainActivity) {
        this.items = items;
        this.mainActivity=mainActivity;

    }
    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  v = LayoutInflater.from(parent.getContext()).inflate(R.layout.git_detail, parent, false);
        return new ViewHolder(v);
    }
    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        TopGithubModel item = items.get(position);
        holder.usernameTv.setText("USERBANE: "+item.getUsername());
        holder.nameTv.setText("NAME: "+item.getName());
        holder.urlTv.setText("URL: "+item.getUrl());
        holder.avtarTv.setText("AVTAR: "+item.getAvatar());
        holder.repoTv.setText("REPOURL: "+item.getRepo().getUrl());




    }
    @Override public int getItemCount() {
        return items.size();
    }
    public  class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout parentLl;
        private TextView usernameTv,nameTv,urlTv,avtarTv,repoTv;
        public ViewHolder(View itemView) {
            super(itemView);
            parentLl = (LinearLayout) itemView.findViewById(R.id.parentLl);
            usernameTv = (TextView) itemView.findViewById(R.id.usernameTv);
            nameTv = (TextView) itemView.findViewById(R.id.nameTv);
            urlTv = (TextView) itemView.findViewById(R.id.urlTv);
            avtarTv = (TextView) itemView.findViewById(R.id.avtarTv);
            repoTv = (TextView) itemView.findViewById(R.id.repoTv);

            parentLl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mainActivity, DetailsActivity.class);
                    intent.putExtra("name",items.get(getAdapterPosition()).getRepo().getName());
                    intent.putExtra("desc",items.get(getAdapterPosition()).getRepo().getDescription());
                    intent.putExtra("url",items.get(getAdapterPosition()).getRepo().getUrl());


                    ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mainActivity,
                            new View(mainActivity) ,
                            "detail"
                    );

                    ActivityCompat.startActivity(mainActivity, intent, options.toBundle());
                }
            });
        }
    }
}