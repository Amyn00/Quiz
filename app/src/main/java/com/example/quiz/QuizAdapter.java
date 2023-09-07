package com.example.quiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {
    private List<Question> qsts;

    public QuizAdapter(List<Question> qsts) {
        this.qsts = qsts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question qst = qsts.get(position);
        holder.contenuTextView.setText(qst.getContenu());
        holder.filiereTextView.setText(String.valueOf(qst.getFiliere()));
    }

    @Override
    public int getItemCount() {
        return qsts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView contenuTextView;
        public TextView filiereTextView;

        public ViewHolder(View view) {
            super(view);
            contenuTextView = view.findViewById(R.id.contenuTextView);
            filiereTextView = view.findViewById(R.id.filiereTextView);
        }
    }
}
