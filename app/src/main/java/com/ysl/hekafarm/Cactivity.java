package com.ysl.hekafarm;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class Cactivity extends AppCompatActivity {

	public static final String C_NAME = "c_name";
	public static final String C_POSITION = "position";
	private TextView tv_ccontent,tv_ctitle;
	private SpannableStringBuilder multiWord;
	private String djtitle;
	private int position;
	private int width,height;
	private int screenwidth,screenheight;
	private int drawablewidth,drawableheight;

	private static String[] content1 = new String[]{
			"      2017年1月14日，青海省在全省扶贫开发工作第二次会议上提出：我省将以习近平总书记扶贫开发战略思想为指导，深入贯彻“  四个全面  ”战略布局和新发展理念，围绕“四个扎扎实实” 重大要求和“两不愁三保障”目标任务，确保完成11个贫困县摘帽、500个贫困村退出、14万贫困人口脱贫的年度目标任务。\n" +
					"      2017年年度青海省扶贫会议工作会议召开，会中对2017年所取得的成果进行了总结和表彰。\n"+
					"      2018年2月5日至6日，青海省省委省政府召开全省扶贫开发工作会议。2018年4月中旬至5月上旬，青海省省纪委监委组成6个调研督导组，对全省15个深度贫困县扶贫领域腐败和作风问题专项治理情况进行了调研督导。调研督导全程突出“精准”，精准谋划、精准培训、精准检查、精准研判。\n" +
					"      河卡种羊场于2017年精准识别贫困户共40户自筹70万元扶贫资金,购买羊960只、牛128头，按照农户自愿的原则 ，将牛羊进行分配,愿意养羊的每户免费提供给40只，愿意养牛的每户免费提供给8头 ，与贫困户签订了协议 ， 明确了养殖规定的与畜牧大队干部的职责。2018年年初 ,  对扶贫工作开展“回头看”" +
					"“向前走”， 场党委、牧业大队党支部对精准扶贫户进行了摸底调查，通过精准扶贫职工群众的思想有了大幅度改观，扶贫先扶志 ，实现了思想脱贫，据调查精准扶贫户羊羔繁活率达到了100%，生产热情高涨 ，场党委的初心得到了职工群众认可。\n"+"  a",
			"      种羊场党委心系群众，对贫困户和特困户开展慰问活动，对因病致困致残的党员、老党员、因病致贫的特困职工群众、生活困难的干部职工群众和奋战在生产一线的职工进行走访慰问，做到不缺一户、不漏一人。"+"\n"+"  a",
			"      每年举办“七一”党建活动，开展多项文体活动，种羊场领导以普通职工的身份积极参与，促进了上下关系的和睦，极大地激发了职工参加文体活动的热情。\n"+
					"2018年2月5日至6日，青海省省委省政府召开全省扶贫开发工作会议。2018年4月中旬至5月上旬，青海省省纪委监委组成6个调研督导组，对全省15个深度贫困县扶贫领域腐败和作风问题专项治理情况进行了调研督导。调研督导全程突出“精准”，精准谋划、精准培训、精准检查、精准研判。\n" +
					"      河卡种羊场于2017年精准识别贫困户共40户自筹70万元扶贫资金,购买羊960只、牛128头，按照农户自愿的原则， 将牛羊进行分配,愿意养羊的每户免费提供给40只 ，愿意养牛的每户免费提供给8头 ,  与贫困户签订了协议 ， 明确了养殖规定的与畜牧大队干部的职责。 2018年年初 ，对扶贫工作开展“回头看”" +
					"“向前走”，场党委 、牧业大队党支部对精准扶贫户进行了摸底调查，通过精准扶贫职工群众的思想有了大幅度改观 ，扶贫先扶志，实现了思想脱贫 ，据调查精准扶贫户羊羔繁活率达到了100% ，生产热情高涨，场党委的初心得到了职工群众认可。\n"+"  a",
			"      每年举办“七一”党建活动进行党章学习：\n"+
					"      认真开展“两学一做”学习教育，各支部以集中学、联合学，自学的方式扎实学习习近平总书记新系列讲话精神、十九大精神及党纪党规等。机关党支部通过集中宣讲、座谈、讨论等形式学系列讲话、学会议精神，引导党员干部、机关工作人员以“两学一做”学习教育为载体，定期打扫思想灰尘，进行党性体检，提高自身素质与业务工作能力。\n"+"  a",
			"      表先进，树典型，通过表彰先进激励斗志，鞭策全场干部职工向被表彰的先进人物、先进事迹学习 。 以身边先进模范宣传 ，加强身边事教育身边人，用他们不平凡的事迹来教育、影响、感召全场党员、干部、职工向模范榜样学习，不忘初心，继续前进，扛起先锋旗全心全意为人民群众服务，从眼前做起，从小事做起，在自己的岗位上兢兢业业，恪守初心，传递正能量。\n"+
					"      种羊场领导及工作人员切实为民，服务为民，为造福广大农民的生活，发展繁荣农村经济而努力工作，当地村社纷纷送来锦旗以表感谢。\n"+
					"      在党建工作的不断进行下，种羊场先后在2016年和2017年被评为先进基层党组织和先进党组织。\n"+"  a",
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cactivity);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar3);
		toolbar.setTitle("党建工作");
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
		StatusBarUtil.setImmersiveStatusBar(this,true);

		WindowManager wm = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics dm  = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(dm);
		width = dm.widthPixels;
		height = dm.heightPixels;
		float density = dm.density;         // 屏幕密度（0.75 / 1.0 / 1.5）
		int densityDpi = dm.densityDpi;     // 屏幕密度dpi（120 / 160 / 240）
		// 屏幕宽度算法:屏幕宽度（像素）/屏幕密度
		screenwidth = (int) (width / density);  // 屏幕宽度(dp)
		screenheight = (int) (height / density);// 屏幕高度(dp)
		drawablewidth = (int) (0.9*width);
		drawableheight = (int) (0.5625*drawablewidth);

		Log.d("drawablewidth:",String.valueOf(drawablewidth));
		Log.d("drawableheight",String.valueOf(drawableheight));
		Intent intent = getIntent();
		djtitle = intent.getStringExtra(C_NAME);
		position = intent.getIntExtra(C_POSITION,0);
		init();
	}

	private void init() {
		tv_ccontent = (TextView)findViewById(R.id.tv_ca);
		tv_ctitle = (TextView)findViewById(R.id.tv_ca_title);
		tv_ctitle.setText(djtitle);

		loadContent();
	}

	private void loadContent() {
		int size = content1[position].length();
		int s = size-1;
		int e = size;
		multiWord = new SpannableStringBuilder();

		switch (position) {
			case 0:
				multiWord.append(content1[position]);
				Drawable drawablec0 = getResources().getDrawable(R.drawable.dj1);
				drawablec0.setBounds(0, 0, drawablewidth, drawableheight);
				ImageSpan imageSpanc0 = new ImageSpan(drawablec0, ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpanc0, s, e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_ccontent.setText(multiWord);
				break;
			case 1:
				multiWord.append(content1[position]);
				Drawable drawablec1 = getResources().getDrawable(R.drawable.dj2);
				drawablec1.setBounds(0, 0, drawablewidth, drawableheight);
				ImageSpan imageSpanc1 = new ImageSpan(drawablec1, ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpanc1, s, e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_ccontent.setText(multiWord);
				break;
			case 2:
				multiWord.append(content1[position]);
				Drawable drawablec2 = getResources().getDrawable(R.drawable.dj3);
				drawablec2.setBounds(0, 0, drawablewidth, drawableheight);
				ImageSpan imageSpanc2 = new ImageSpan(drawablec2, ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpanc2, s, e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_ccontent.setText(multiWord);
				break;
			case 3:
				multiWord.append(content1[position]);
				Drawable drawablec3 = getResources().getDrawable(R.drawable.dj4);
				drawablec3.setBounds(0, 0, drawablewidth, drawableheight);
				ImageSpan imageSpanc3 = new ImageSpan(drawablec3, ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpanc3, s, e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_ccontent.setText(multiWord);
				break;
			case 4:
				multiWord.append(content1[position]);
				Drawable drawablec4 = getResources().getDrawable(R.drawable.dj5);
				drawablec4.setBounds(0, 0, drawablewidth, drawableheight);
				ImageSpan imageSpanc4 = new ImageSpan(drawablec4, ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpanc4, s, e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_ccontent.setText(multiWord);
				break;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:

				finish();
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
