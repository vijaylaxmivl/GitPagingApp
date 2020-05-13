package com.vl.gitpagingapp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vl.gitpagingapp.R;
import com.vl.gitpagingapp.databinding.RecyclerviewItemBinding;
import com.vl.gitpagingapp.model.GitResponse;

public class ItemAdapter extends PagedListAdapter<GitResponse, ItemAdapter.ItemViewHolder> {

    private Context mCtx;
    private RecyclerviewItemBinding recyclerviewItemBinding;

    public ItemAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        GitResponse item = getItem(position);

        if (item != null) {

            holder.txtName.setText("" + item.name);
            holder.txtOpenICount.setText("" + item.openIssuesCount);

            holder.txtAdmin.setText("" + item.permissions.admin);
            holder.txtPush.setText("" + item.permissions.push);
            holder.txtPull.setText("" + item.permissions.pull);
            holder.txtDescription.setText("" + item.description);
            try {
                holder.txtLicense.setText("" + item.license.name);
            } catch (Exception e) {

            }
        } else {
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }

    }


    private static DiffUtil.ItemCallback<GitResponse> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<GitResponse>() {
                @Override
                public boolean areItemsTheSame(GitResponse oldItem, GitResponse newItem) {
                    return oldItem.id == newItem.id;
                }

                @Override
                public boolean areContentsTheSame(GitResponse oldItem, GitResponse newItem) {
                    return oldItem.equals(newItem);
                }
            };


    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtName, txtOpenICount, txtLicense, txtAdmin, txtPush, txtPull, txtDescription;

        public ItemViewHolder(View itemView) {
            super(itemView);


            txtName = itemView.findViewById(R.id.txtName);
            txtOpenICount = itemView.findViewById(R.id.txtOpenICount);
            txtLicense = itemView.findViewById(R.id.txtLicense);
            txtAdmin = itemView.findViewById(R.id.txtAdmin);
            txtPush = itemView.findViewById(R.id.txtPush);
            txtPull = itemView.findViewById(R.id.txtPull);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }
}
