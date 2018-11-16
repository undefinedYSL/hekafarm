package com.ysl.hekafarm;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.StackAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStackAdapter extends StackAdapter<Integer> {

	public static Map<String,String> map = new HashMap<String, String>();

	public TestStackAdapter(Context context) {
		super(context);
		map.put("0","一号羊场");
		map.put("1","二号羊场");
		map.put("2","三号羊场");
		map.put("3","四号羊场");
		map.put("4","种羊场");
	}

	public static RecyclerView recyclerView;
	public static CitemAdapter adapter;
	public static List<HKitem> citemList = new ArrayList<>();

	@Override
	public void bindView(Integer data, int position, CardStackView.ViewHolder holder) {
		if (holder instanceof ColorItemLargeHeaderViewHolder) {
			ColorItemLargeHeaderViewHolder h = (ColorItemLargeHeaderViewHolder) holder;
			h.onBind(data, position);
		}
		if (holder instanceof ColorItemWithNoHeaderViewHolder) {
			ColorItemWithNoHeaderViewHolder h = (ColorItemWithNoHeaderViewHolder) holder;
			h.onBind(data, position);
		}
		if (holder instanceof ColorItemViewHolder) {
			ColorItemViewHolder h = (ColorItemViewHolder) holder;
			h.onBind(data, position);
		}
	}

	@Override
	protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
		View view;
		switch (viewType) {
			case R.layout.list_card_item_larger_header:
				view = getLayoutInflater().inflate(R.layout.list_card_item_larger_header, parent, false);
				return new ColorItemLargeHeaderViewHolder(view);
			case R.layout.list_card_item_with_no_header:
				view = getLayoutInflater().inflate(R.layout.list_card_item_with_no_header, parent, false);
				return new ColorItemWithNoHeaderViewHolder(view);
			default:
				view = getLayoutInflater().inflate(R.layout.list_card_item, parent, false);
				return new ColorItemViewHolder(view);
		}

	}

	@Override
	public int getItemViewType(int position) {
		if (position == 9) {
			//TODO TEST LARGER ITEM
			return R.layout.list_card_item_larger_header;
		} else if (position == 10) {
			return R.layout.list_card_item_with_no_header;
		}else {
			return R.layout.list_card_item;
		}
	}

	static class ColorItemViewHolder extends CardStackView.ViewHolder {
		View mLayout;
		View mContainerContent;
		TextView mTextTitle;

		public ColorItemViewHolder(View view) {
			super(view);
			mLayout = view.findViewById(R.id.frame_list_card_item);
			mContainerContent = view.findViewById(R.id.container_list_content);
			mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
			initItems();
			recyclerView = (RecyclerView)view.findViewById(R.id.rv_c);
			LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
			recyclerView.setLayoutManager(layoutManager);
			recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
			adapter = new CitemAdapter(citemList);
			recyclerView.setAdapter(adapter);
		}



		@Override
		public void onItemExpand(boolean b) {
			mContainerContent.setVisibility(b ? View.VISIBLE : View.GONE);
		}

		public void onBind(Integer data, int position) {
			mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), data), PorterDuff.Mode.SRC_IN);
			mTextTitle.setText(map.get(String.valueOf(position)));
		}

	}

	static class ColorItemWithNoHeaderViewHolder extends CardStackView.ViewHolder {
		View mLayout;
		TextView mTextTitle;

		public ColorItemWithNoHeaderViewHolder(View view) {
			super(view);
			mLayout = view.findViewById(R.id.frame_list_card_item);
			mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
		}

		@Override
		public void onItemExpand(boolean b) {
		}

		public void onBind(Integer data, int position) {
			mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), data), PorterDuff.Mode.SRC_IN);
			mTextTitle.setText(map.get(String.valueOf(position)));
		}

	}

	static class ColorItemLargeHeaderViewHolder extends CardStackView.ViewHolder {
		View mLayout;
		View mContainerContent;
		TextView mTextTitle;

		public ColorItemLargeHeaderViewHolder(View view) {
			super(view);
			mLayout = view.findViewById(R.id.frame_list_card_item);
			mContainerContent = view.findViewById(R.id.container_list_content);
			mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
		}

		@Override
		public void onItemExpand(boolean b) {
			mContainerContent.setVisibility(b ? View.VISIBLE : View.GONE);
		}

		@Override
		protected void onAnimationStateChange(int state, boolean willBeSelect) {
			super.onAnimationStateChange(state, willBeSelect);
			if (state == CardStackView.ANIMATION_STATE_START && willBeSelect) {
				onItemExpand(true);
			}
			if (state == CardStackView.ANIMATION_STATE_END && !willBeSelect) {
				onItemExpand(false);
			}
		}

		public void onBind(Integer data, int position) {
			mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), data), PorterDuff.Mode.SRC_IN);
			mTextTitle.setText(map.get(String.valueOf(position)));

			itemView.findViewById(R.id.rv_c).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					((CardStackView)itemView.getParent()).performItemClick(ColorItemLargeHeaderViewHolder.this);
				}
			});
		}

	}

	public static void initItems() {
		citemList.clear();
		citemList.add(new HKitem("风速：","30m/s"));
		citemList.add(new HKitem("光照：","1200lux"));
		citemList.add(new HKitem("温度：","12℃"));
		citemList.add(new HKitem("湿度：","30%"));
		citemList.add(new HKitem("CO2浓度：","1200ppm"));
	}
}
