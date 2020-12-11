package com.example.parseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private RecyclerViewClickListener listener;
    LayoutInflater inflater;
    List<Post> posts;

    public Adapter(Context ctx, List<Post> posts, RecyclerViewClickListener listener) {
        this.inflater = LayoutInflater.from(ctx);
        this.posts = posts;
        this.listener = listener;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myId.setText(String.valueOf(posts.get(position).getId()));
        holder.myTitle.setText(posts.get(position).getTitle());
        holder.myDescription.setText(posts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myId, myTitle,myDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myId = itemView.findViewById(R.id.id_view);
            myTitle = itemView.findViewById(R.id.title_view);
            myDescription = itemView.findViewById(R.id.desc_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition() );
        }
    }
    public interface RecyclerViewClickListener{
        void onClick(View v,int position);
    }
}



















