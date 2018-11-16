package com.ysl.hekafarm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CitemAdapter extends RecyclerView.Adapter<CitemAdapter.ViewHolder>{

	private Context mContext;

	private List<HKitem> mCitemList;

	static class ViewHolder extends RecyclerView.ViewHolder{
		CardView cardView;
		TextView tv_key;
		TextView tv_value;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			cardView = (CardView)itemView;
			tv_key = (TextView) itemView.findViewById(R.id.tv_c_key);
			tv_value = (TextView)itemView.findViewById(R.id.tv_c_value);
		}
	}

	public CitemAdapter(List<HKitem> hkList) {
		mCitemList = hkList;
	}

	@NonNull
	@Override
	public CitemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
		if (mContext == null){
			mContext = parent.getContext();
		}
		View view = LayoutInflater.from(mContext).inflate(R.layout.c_item,parent,false);
		final CitemAdapter.ViewHolder holder = new CitemAdapter.ViewHolder(view);
		holder.cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getAdapterPosition();
				HKitem hkitem = mCitemList.get(position);
				Log.d("onClick","我点击了一个cardview");

			}
		});
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull CitemAdapter.ViewHolder viewHolder, int position) {
		HKitem hkitem = mCitemList.get(position);
		viewHolder.tv_key.setText(hkitem.getKey());
		viewHolder.tv_value.setText(hkitem.getValue());
	}

	@Override
	public int getItemCount() {
		return mCitemList.size();
	}
}
