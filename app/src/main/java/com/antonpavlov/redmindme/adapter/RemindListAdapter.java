package com.antonpavlov.redmindme.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.antonpavlov.redmindme.R;
import com.antonpavlov.redmindme.dto.RemindDTO;

import java.util.List;

public class RemindListAdapter extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder> {

    private List<RemindDTO> remindDTOList;

    public RemindListAdapter(List<RemindDTO> remindDTOList) {
        this.remindDTOList = remindDTOList;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflate = layoutInflater.inflate(R.layout.remind_item, parent, false);

        return new RemindViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        RemindDTO data = remindDTOList.get(position);

        holder.textView.setText(data.getTitle());
        holder.textDescription.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return remindDTOList.size();
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView textView;
        TextView textDescription;

        public RemindViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textView = (TextView) itemView.findViewById(R.id.itemTextViewTitle);
            textDescription = (TextView) itemView.findViewById(R.id.textDescription);
        }
    }
}
