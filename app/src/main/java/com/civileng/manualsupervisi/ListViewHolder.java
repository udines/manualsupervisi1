package com.civileng.manualsupervisi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by fata on 10/18/2017.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {

    private ListClickListener clickListener;
    private final TextView title;
    private final TextView subtitle;
    private final View view;

    public ListViewHolder(View itemView, ListClickListener listener) {
        super(itemView);
        clickListener = listener;
        view = itemView;
        title = (TextView)itemView.findViewById(R.id.item_title);
        subtitle = (TextView)itemView.findViewById(R.id.item_subtitle);
    }

    public void setView(final ListModel model) {
        title.setText(model.getTitle());
        subtitle.setText(model.getSubtitle());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener != null) {
                    clickListener.onClick(model);
                }
            }
        });
    }
}
