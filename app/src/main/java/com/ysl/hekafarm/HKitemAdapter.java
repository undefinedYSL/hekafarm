package com.ysl.hekafarm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HKitemAdapter extends RecyclerView.Adapter<HKitemAdapter.ViewHolder> {

	private Context mContext;

	private List<HKitem> mHkitemList;

	static class ViewHolder extends RecyclerView.ViewHolder{
		CardView cardView;
		ImageView imageView;
		TextView tv_title,tv_content,tv_date;

		public ViewHolder(View itemView){
			super(itemView);
			cardView = (CardView)itemView;
			imageView = (ImageView)itemView.findViewById(R.id.iv_a_preview);
			tv_content = (TextView)itemView.findViewById(R.id.tv_a_content);
			tv_title = (TextView)itemView.findViewById(R.id.tv_a_title);
			tv_date = (TextView)itemView.findViewById(R.id.tv_a_date);
		}
	}

	public HKitemAdapter(List<HKitem> hkList) {
		mHkitemList = hkList;
	}

	@NonNull
	@Override
	public HKitemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		if (mContext == null){
			mContext = parent.getContext();
		}
		View view = LayoutInflater.from(mContext).inflate(R.layout.a_item,parent,false);
		final ViewHolder holder = new ViewHolder(view);
		holder.cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getAdapterPosition();
				HKitem hkitem = mHkitemList.get(position);
				Log.d("onClick","我点击了一个cardview");
				switch (position){
					case 0:
						Intent intent1 = new Intent(mContext,OneActivity.class);
						mContext.startActivity(intent1);
						break;
					case 1:
						Intent intent2 = new Intent(mContext,TwoActivity.class);
						mContext.startActivity(intent2);
						break;
					case 2:
						Intent intent3 = new Intent(mContext,ThreeActivity.class);
						mContext.startActivity(intent3);
						break;
					case 7:
						Intent intent8 = new Intent(mContext,three1Activity.class);
						mContext.startActivity(intent8);
						break;
					case 3:
						Intent intent4 = new Intent(mContext,FourActivity.class);
						mContext.startActivity(intent4);
						break;
					case 4:
						Intent intent5 = new Intent(mContext,FiveActivity.class);
						mContext.startActivity(intent5);
						break;
					case 5:
						Intent intent6 = new Intent(mContext,SixActivity.class);
						mContext.startActivity(intent6);
						break;
					case 6:
						Intent intent7 = new Intent(mContext,SevenActivity.class);
						mContext.startActivity(intent7);
						break;
				}
//				Intent intent = new Intent(mContext,Aactivity.class);
//				intent.putExtra(Aactivity.A_NAME,hkitem.getTitle());
//				intent.putExtra(Aactivity.A_POSITION,position);
//				mContext.startActivity(intent);
			}
		});
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull HKitemAdapter.ViewHolder viewHolder, int position) {
		HKitem hkitem = mHkitemList.get(position);
		viewHolder.tv_date.setText(hkitem.getDate());
		viewHolder.tv_content.setText(hkitem.getContent());
		viewHolder.tv_title.setText(hkitem.getTitle());
		Glide.with(mContext).load(hkitem.getImgID()).into(viewHolder.imageView);
	}

	@Override
	public int getItemCount() {
		return mHkitemList.size();
	}
}
