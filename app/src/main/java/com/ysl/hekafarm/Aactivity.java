package com.ysl.hekafarm;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class Aactivity extends AppCompatActivity {

	public static final String A_NAME = "a_name";
	public static final String A_POSITION = "position";
	private TextView tv_acontent,tv_atitle;
	private SpannableStringBuilder multiWord;
	private String hktitle;
	private int position;
	private int width,height;
	private int screenwidth,screenheight;
	private int drawablewidth,drawableheight;

	public static int news ;


	private static String[] content0 = new String[]{

			"    积极调整产业结构，利用成熟的技术力量和机械化程度高的优势，有效利用土地资源，抓住国家农垦改革有利政策，大力发展特高原色农牧产业。以牧草种植为重点，合理布局草产业发展格局，坚持走种植规模化、品种优良化、生产标准化、经营产业化、加工精细化的路子，结合本地区“有机产品”认证的优势，进一步发展“牛羊生态健康养殖”业，同时，紧紧抓住国家加强草原生态保护的重大历史机遇，按照“合理布局、加大投入、统筹发展、提质增效”的思路，用产业化的思维和循环经济的理念谋划产业发展，努力推动农牧业健康发展，不断加大草畜转化力度，提高种草养畜的效益，逐步形成“以草养畜，以畜促草”的有机循环农牧业。"+"\n"+"  a",
			"    河卡种羊场每年举办“七一”党建活动，开展多项文体活动，场领导以普通职工的身份积极参与，促进了上下关系的和睦 ，极大地激" +
					"发了职工参加文体活动的热情。在积极参加文体活动的过程中，专长和个性能得到充分体现，成就感与自信心进一步提升；在挥" +
					"洒汗水、捍卫荣誉的同时，紧张的工作情绪得以舒缓，有助于培养机智顽强、坚持不懈的作风和积极向上、勇于进取的良好心态；" +
					"在团结协作、共克困难中，团队意识明显增强  ，人际关系更加融洽，精神面貌焕然一新，进一步激发了员工的参与热情，使企业精" +
					"神、核心价值观更加深入人心，增强了战斗力和向心力，促进了生产、管理、等各项工作的协调发展，同时增强了民族团结进步。 表先" +
					"进，树典型，通过表彰先进激励斗志，鞭策全场干部职工向被表彰的先进人物  、先进事迹学习。 以身边先进模范宣传  ，加强身边事教" +
					"育身边人，用他们不平凡的事迹来教育、影响、感召全场党员、干部、职工向模范榜样学习，不忘初心,继续前进,扛起先锋旗全心全" +
					"意为人民群众服务，从眼前做起，从小事做起，在自己的岗位上兢兢业业,恪守初心,传递正能量。"+"\n"+"  a",
			"   我场于2017年精准识别贫困户共40户，自筹70万元扶贫资金，购买羊960只、牛128头，按照农户自愿的原则，将牛羊进行分配，愿意养羊的每户免费提供给40只，愿意养牛的每户免费提供给8头，与贫困户签订协议，明确了养殖规定与畜牧大队干部职责。2018年年初，对扶贫工作开展“回头看”“向前走”，场党委、牧业大队党支部对精准扶贫户进行了摸底调查，通过精准扶贫职工群众的思想有了大幅度改观，扶贫先扶志，实现了思想脱贫，据调查精准扶贫户羊羔繁活率达到了100%，生产热情高涨，场党委的初心得到了职工群众认可。"+"\n"+"  a",
			"     青海省河卡种羊场的发展得到了各级领导的亲切关怀和指导，激励着一代又一代的羊场儿女不断探索、追求卓越。"+"\n"+"  a",
			"    以身边先进模范宣传，加强身边事教育身边人，用他们不平凡的事迹来教育、影响、感召全场党员、干部、职工向模范榜样学习，不忘初心，继续前进，扛起先锋旗全心全意为人民群众服务，从眼前做起，从小事做起，在自己的岗位上兢兢业业，恪守初心，传递正能量。"+"\n"+"  a",
			"     青海省农牧厅主办，省农牧机械推广站、草原总站、草原学会联合举办的“全省牧草（燕麦）生产全程机械化技术实训”活动在青海省河卡种羊场举办，免耕播种机、牧草收获机、摊晒机、搂草机、打捆机、打捆包膜机、叉运机轮番上阵，上演了一场牧草生产全程机械化的盛宴。"+"\n"+"  a",
			"    认真开展“两学一做”学习教育，各支部以集中学、联合学，自学的方式扎实学习习近平总书记新系列讲话精神、十九大精神及党纪党规等。牧业党支部、农业党支部开展草原田间课堂，支部书记、联点领导前往牧业草场、农业田间地头开展政策宣讲，机关党支部通过集中宣讲、座谈、讨论等形式学系列讲话、学会议精神，引导党员干部、机关工作人员以“两学一做”学习教育为载体，定期打扫思想灰尘，进行党性体检，提高自身素质与业务工作能力；"+"\n"+"  a",
			"本报海北讯 （记者 尹耀增） 按照《海北藏系母羊“两年三胎”高效养殖推广项目实施方案》，在海北藏族自治州海晏县哈勒景乡实施的藏羊“两年三胎”项目第三阶段产羔工作已顺利完成。\n" +
					"\n" +
					"截至目前，68户项目户15000只生产母羊顺利完成羔羊生产，产羔14999只，成活14981只，成活率99.8﹪，其中双胞胎2对，流产3只，经对30只羔羊称重，平均出生重为4.05㎏，对照组羔羊平均体重为3.69㎏，相比平均出生重重了0.36㎏，高出12.5﹪。因本阶段提前配送了种公羊的精料和母羊的精料及青贮草，从而保证了公羊和母羊的体质，并防治了内外寄生虫，为提高羔羊成活率和保持母羊体质奠定了基础。"+"\n"+"  a",
			"    积极调整产业结构，利用成熟的技术力量和机械化程度高的优势，有效利用土地资源，抓住国家农垦改革有利政策，大力发展特高原色农牧产业" +
					"。以牧草种植为重点，合理布局草产业发展格局，坚持走种植规模化、品种优良化、生产标准化、经营产业化、加工精细化的路子，结合" +
					"本地区“有机产品”认证的优势 ，进一步发展“牛羊生态健康养殖”业，同时，紧紧抓住国家加强草原生态保护的重大历史机遇，按照" +
					"“合理布局、加大投入、统筹发展、提质增效”的思路  ，用产业化的思维和循环经济的理念谋划产业发展，努力推动农牧业健康发展  ，" +
					"不断加大草畜转化力度，提高种草养畜的效益，逐步形成  “以草养畜，以畜促草”的有机循环农牧业。"+"\n"+"  a",
			"    青海高原半细毛羊对严酷的高寒环境条件具有良好的适应性,对饲养管理条件的改善反应明显,公羊多有螺旋型角，母羊" +
					"无角或有小角,羊毛呈明显或不明显的波状弯曲,油汗多呈白色或乳黄色。"+"\n"+"  a",
			"    自1958年起，青海省河卡种羊场场以“绵羊改良，促进畜牧业发展”为宗旨，一直从事 “青海高原毛肉兼用半细毛羊”的繁" +
					"育工作，1963年由青海省人民政府和农业部批准，正式确定为培育毛肉兼用半细毛羊种羊场，在严酷的自然环境下，经过" +
					"20多年几代科技工作者和职工群众艰苦努力的工作，在1987年7月成功培育出了毛肉兼用半细毛羊，各项生产性能达到了育种" +
					"指标，顺利通过了省级鉴定验收，被省政府命名为“青海高原毛肉兼用半细毛羊”，荣获“青海科技进步一等奖”科技成果奖，" +
					"在发展高效特色畜牧业，加快畜牧业产业化进程方面，发挥了国有种畜场的带动、示范、辐射功能。"+"\n"+"  a",
			"    积极调整产业结构，利用成熟的技术力量和机械化程度高的优势，有效利用土地资源，抓住国家农垦改革有利政策，大力发展特高原色农牧产业。以" +
					"牧草种植为重点，合理布局草产业发展格局，坚持走种植规模化、品种优良化、生产标准化、经营产业化、加工精细化的路子，结合本地区“" +
					"有机产品”认证的优势，进一步发展“牛羊生态健康养殖”业，同时，紧紧抓住国家加强草原生态保护的重大历史机遇，按照“合理布局、加" +
					"大投入、统筹发展、提质增效”的思路，用产业化的思维和循环经济的理念谋划产业发展，努力推动农牧业健康发展，不断加大草畜转化力度，" +
					"提高种草养畜的效益，逐步形成“以草养畜，以畜促草”的有机循环农牧业。"+"\n"+"  a",
		"    本报海北讯 （记者 尹耀增） 按照《海北藏系母羊“两年三胎”高效养殖推广项目实施方案》，在海北藏族自治州海晏县哈勒景乡实施的藏羊“两年三胎”项目第三阶段产羔工作已顺利完成。\n" +
				"\n" +
				"    截至目前，68户项目户15000只生产母羊顺利完成羔羊生产，产羔14999只，成活14981只，成活率99.8﹪，其中双胞胎2对，流产3只，经对30只羔羊称重，平均出生重为4.05㎏，对照组羔羊平均体重为3.69㎏，相比平均出生重重了0.36㎏，高出12.5﹪。因本阶段提前配送了种公羊的精料和母羊的精料及青贮草，从而保证了公羊和母羊的体质，并防治了内外寄生虫，为提高羔羊成活率和保持母羊体质奠定了基础。"+"\n"+"  a",

					"认真开展“两学一做”学习教育，各支部以集中学、联合学，自学的方式扎实学习习近平总书记新系列讲话精神、十九大精神及党纪党规等。牧" +
					"业党支部、农业党支部开展草原田间课堂，支部书记、联点领导前往牧业草场、农业田间地头开展政策宣讲，机关党支部通过集中宣讲、座谈、" +
					"讨论等形式学系列讲话、学会议精神，引导党员干部、机关工作人员以“两学一做”学习教育为载体，定期打扫思想灰尘，进行党性体检，提高" +
					"自身素质与业务工作能力。"+"\n"+"  a",

	};

	private static String[] content1 = new String[]{
			"    本报海北讯 （记者 尹耀增） 按照《海北藏系母羊“两年三胎”高效养殖推广项目实施方案》，在海北藏族自治州海晏县哈勒景乡实施的藏羊“两年三胎”项目第三阶段产羔工作已顺利完成。\n" +
					"\n" +
					"    截至目前，68户项目户15000只生产母羊顺利完成羔羊生产，产羔14999只，成活14981只，成活率99.8﹪，其中双胞胎2对，流产3只，经对30只羔羊称重，平均出生重为4.05㎏，对照组羔羊平均体重为3.69㎏，相比平均出生重重了0.36㎏，高出12.5﹪。" +
					"    因本阶段提前配送了种公羊的精料和母羊的精料及青贮草，从而保证了公羊和母羊的体质，并防治了内外寄生虫，为提高羔羊成活率和保持母羊体质奠定了基础。"+"\n"+"  a",
			"      青海新闻网讯 近日，农业农村部发布公告，由我省和甘肃省联合申报的“欧拉羊”畜禽遗传资源入选国家畜禽遗传资源，并列入名录。	\n"+
					"　　畜禽遗传资源是生物多样性的重要组成部分，是畜牧业发展的重要物质基础和国家战略性资源，具有不可再生性。畜禽遗传资源的拥有量和研发能力已成为衡量一个国家畜牧业综合实力和可持续发展能力的重要指标之一。“欧拉羊”在我省主要分布于黄南藏族自治州等地，是经过长期繁衍与自然封闭形成的珍贵绵羊遗传资源，体形外貌一致，遗传性能稳定、经济价值高，是我省绵山羊资源中极具特色和潜力的品种。“欧拉羊”成为国家级遗传资源，对我省发展藏羊产业和打造“青海·中国藏羊之府”整体品牌、助推我省特色农牧业可持续发展，具有重要意义。"+"\n" +"  a",
			"    泽库县，隶属于青海省黄南藏族自治州，位于青海省的东南部， 黄南藏族自治州中南部，东与甘肃省夏河县毗邻，南连河南蒙古族自治县，西靠青海省同德县，东北与同仁接壤。高原大陆性季风气候，属高原亚寒带湿润气候区，雨热同季，气温较低，热量不足，无霜短期，日照时间长。元属吐蕃等处宣慰司辖。民国十八年(1929年)置同仁县。1953年，由同仁县析置泽库县。\n" +
					"\n" +
					"    和日寺：亦称“切更寺、“切更尔寺”，藏语称“和日贡特却扎西林”，意为“和日妙乘吉祥洲”。该寺为宁玛派寺院，早年为帐房寺。和日寺的藏戏和石经墙闻名遐迩。藏戏以《松赞干布》最为出名。石经墙高3米，长200多米，全由刻有-的石板砌成。-内容主要为《甘珠尔》、《丹珠尔》和《大般若经》，约2亿字。经石上并镌刻有大小佛像、图案、佛教故事画等2000余幅，字体清晰工整，绘画精美舒展，皆为不可多得的石刻艺术品，被誉为“世界石书奇观”。\n" +
					"\n" +
					"    阿卡包子——是指青海地区藏传佛教寺庙的包子，阿卡是安多藏语中对藏传佛教僧人的一种尊称，是安多藏语的汉语音译。包子看起来就像大饺子，皮薄馅大，里面有羊肉、牛肉和大葱，并且汤汁肥美。蘸点辣椒酱和醋，味道十分鲜美\n" +
					"\n" +


					"    泽库藏羊呈原始自然的生长过程，无任何污染环境，终身无劳役，一生中摄入大量的虫草、雪莲等名贵中草药，使藏羊体大肢高，体质坚实，所产羊毛优良。肉色鲜红，有光泽，肌纤维致密，富有韧性。煮沸后肉汤澄清透明，脂肪团聚于表面，膻味小、具羊肉固有的香味。味道鲜美纯正、口感好，肥瘦相间、香味浓郁、风味独特等特点，在羊肉中独具特色。（中国农林科技网）"+"\n"+"  a",
			        "        近日，从青海省科技厅组织的藏羊高效繁育与产品追溯体系观摩会上传出消息，该省已建立藏羊高效繁育与产品追溯体系。\n" +

					"　　据了解，“藏羊高效繁育与产品质量保障技术集成示范项目”为2014年落户海北藏族自治州的省级重大科技项目，总投资6045万元，由“藏羊良种繁育及人工授精技术示范”、“藏羊高效养殖技术集成与示范推广”和“高原型藏羔羊肉精深加工及质量追溯体系建立”三个子课题构成，项目期为三年。\n" +

					"　　为解决优良种羊选育进程缓慢问题，海北州牧科所从该省高原型藏羊主产区，引入能繁优良公羊100只、母羊500只，组建高原型藏羊繁育核心群；制定核心群科学选配方案，规范饲养管理技术，建立核心群个体系谱档案，对种公羊进行驯化、诱导和调教；利用电刺激进行采精，选择优良公母羊进行选种选配。\n" +

					"　　海北州牧科所科技项目部主任周玉青介绍，通过高效养殖综合技术应用，可实现羔羊早期断奶，进行舍饲、半舍饲饲养，提高母羊繁殖性能，缩短繁殖间隔，增加羔羊出生重、断奶重和繁活率，实现羔羊当年出生，6个月出栏。\n" +

					"　　在加工、物流和营销环节，则主要以应用信息科技手段建立羔羊肉产品质量追溯体系，建立产品在养殖、生产、销售环节的档案资料，不仅能保障产品质量，还为下一步延伸藏羊产业发展链条，打造高原藏羔羊肉特色品牌奠定了基础。”周玉青说。（罗云鹏）"+"\n"+"  a",

			"     经过40多个小时近2200多公里的长途跋涉,100头牦牛、1000只藏羊从青海海北州祁连县启程,11月7日早晨乘长途车到达阳信县借剑牛业公司,拉开了海北州“千牛万羊”进山东的帷幕。\n" +
					"\n" +
					"    据介绍,我省紧密结合脱贫攻坚创新援青模式,解决海北州牦牛肉、藏羊肉销售难题,开展了海北州牛羊肉进山东活动。初步商定,利用阳信畜产品养殖加工优势,今年帮助海北州在我省至少销售牦牛1000头、藏羊1万只,以后根据情况不断扩大销量。\n" +
					"\n" +
					"    青海省海北州平均海拔3000米以上,牦牛、藏羊养殖是海北州重要的支柱产业。但销售加工分割有局限,影响了牧民的收入。据了解,每入鲁一头牦牛可为牧民增收近5000元,藏羊500元。\n" +
					"\n" +
					"    开展牦牛、藏羊活畜进入支援省市,在6个援青省市中尚属首次。“海北牦牛”“海北藏羊”“祁连山有机牛羊肉”等名优特色产品品牌进入我省,既能让全省消费者品尝到有机绿色的高原牛羊肉美味,又能推动海北牛羊产业化发展进程,促进海北州畜牧业增效、农牧民增收、贫困户脱贫。\n" +
					"\n" +
					"(通讯员 李剑桥 张勇)"+"\n"+"  a",




			"    这是一次理论创新、实践创新的历史性突破，青海草原将由此揭开现代生态畜牧业高层次发展新篇章。”这是连日来省内外专家验收通过海北藏系羊“两年三胎”高效养殖试验推广项目，给予的高度评价。\n" +
					"\n" +
					"    通过几天来对一批推广示范点的现场检查测定，来自甘肃、青海的畜牧业专家欣喜地看到，海北藏族自治州自2012年秋实施的藏系羊“两年三胎” 高效养殖试验推广项目，至今年秋已在所辖4个县10个牧户圆满完成一轮生产周期，2000只试验母羊两年均产下三胎羔羊，两月断奶，6月出栏平均体重37.39公斤，繁活率、6月龄出栏率分别比对照组高12%和59%，户均年增收6.66万元，成果十分显著。\n" +
					"\n" +
					"    专家组组长、来自甘肃省的中国藏羊研究权威郭健研究员在10月17日召开的验收会上宣布：这个项目以藏系母羊营养调控、羔羊适时断奶、早期补饲及安全监控等为技术核心，母羊繁殖周期缩短为八个月，实现了放牧加补饲条件下藏系母羊两年产三胎的目标，颠覆了教科书上藏系羊“晚熟”、“低产”等论断，理论创新、实践创新，探索出符合高寒牧区藏系羊高效养殖新模式，经济、社会和生态效益显著，值得大力推广，专家组一致同意通过验收。\n" +
					"\n" +
					"    主持这项工作的海北州委农牧工作领导小组组长更藏介绍说：推进“三区”战略，建设生态文明先行区，省委、省政府提出“禁牧不禁养、减畜不减收”的目标，作为全省生态畜牧业发展示范州，海北如何在“两难”抉择中创新发展，藏系羊“两年三胎”项目的成功实践，找到了答案。仅养200只母羊就能增收近7万元，草场超载问题破解，市场有效供给大幅增加，利国利民，现代生态畜牧业由此开高效发展历史新河。榜样的力量无穷，广大牧民热情高涨，目前全州项目示范区已扩展到43户、8.6万只藏系母羊；并已扶持带动起6438户牧民、74.9万只羊进入放牧加补饲的生态畜牧业高效养殖行列。（记者 官群）"+"\n"+"  a",



			"      12月8日,青海省科技厅组织专家对青海大学承担的”2014年2015年高寒草地放牧藏羊高效养殖综合配套技术示范与推广”项目通过了科技成果评价,成果达到国际先进水平。\n" +
					"\n" +
					"    该研究应用高寒草地放牧藏羊高效养殖综合配套技术,在全省6个牧业州40个生态畜牧业合作社共15810只母羊中进行了推广, 提高了项目区牧民科学养殖水平,为全国草地生态畜牧业试验区建设提供了重要的技术支撑，,通过藏母羊关键繁育期和羔羊早期断奶半舍饲精准补饲等技术措施的应用,项目区羔羊成活率达到了96.45% , 6月龄体重达37.75公斤以上，比传统放牧羔羊体重增加17公斤, 提高了藏羊生产性能，具有明显的经济效益。试验方案设计合理,试验数据翔实可靠,技术成熟,具有较强的实用性和可操作性。"+"\n"+"  a",
			"    8月14日至9月14日，刚察县农牧局组织全县五乡镇兽医站开展了为期一个月的藏羊药浴工作。期间，共药浴藏羊478000多只,药浴率达到95℅以上，药浴后杀虫效果明显, 未出现羊只中毒症状。\n" +
					"    为确保药浴质量和防止羊只中毒，我县抽调20余名兽医技术人员、75名村防疫人员参加药浴工作。并安排专人留守值班，加强对药物管理。同时，县兽医技术人员利用此次药浴机会，对参加药浴工作的村防疫人员就牛羊养殖技术、内外寄生虫防疫知识、以及驱虫对养殖业发展的重要性等方面进行了深度的讲解和指导。并及时解决了农牧民群众在牛羊养殖中遇到的疑难问题，深受农牧民群众欢迎。"+"\n"+"  a",
			"“    在这样一个特殊的经济背景下，今年的‘藏毯展’势必是提振企业信心，促进藏毯产业崛起的展会！”\n" +
					"\n" +
					"    说起“藏毯展”，就不得不提及一个响亮的名字———“藏羊”，作为青海省藏毯业的“领头羊”和行业标杆，青海藏羊地毯(集团)有限公司在展会创办初期，不仅利用企业的外销资源不遗余力地招商招展，而且在一届又一届的中国（青海）藏毯国际展览会影响下成长壮大。\n" +
					"\n" +
					"    6月23日，“藏羊”集团院内，工人们正有序地将一条条精美的展毯搬运装车，运往目的地———西宁市城南青海国际会展中心。董事长马新民介绍，今年“藏毯展”，“藏羊”集团设精品馆、现货馆及首次重磅亮相的“有机藏毯馆”，参展产品数量、品质、类型都有新突破。在保留传统销售渠道的同时，“藏羊”集团还将融入互联网+藏羊的创新模式，利用现代高科技技术，吸引更多的国内外地毯生产商，体现青海作为藏毯原产地的产业优势和品牌优势。\n" +
					"\n" +
					"    站在正在全力打造的“世界藏毯之都”，“藏羊”集团坐拥手工和机织藏毯近千个品种，产品远销欧、美、日等34个国家和地区，产品出口市场已增加到了30个国家和地区，拥有国外固定大客户140多家，业务遍布世界五大洲，出口创汇额和内外贸销售额均位居全国藏毯企业之首。尤其在“一带一路”国家战略构想蓝图下，2014年，“藏羊”集团依托青海省政府“走出去、请进来”的政策支持，通过展会平台推动我省积极融入“一带一路”建设，与丝绸之路经济带沿线国家实现经贸互通，签订藏毯出口合同。目前，哈萨克斯坦、土库曼斯坦、吉尔吉斯坦、塔吉克斯坦等古丝路中亚五国都有“藏羊”的身影。\n" +
					"\n" +
					"    马新民认为，不少行业深受当前全球经济下行压力的影响持续低迷，甚至面临消亡，而地毯业历经千年洗礼流传至今，因其生产要素环保可持续再生且有较好的设备技术基础，产品和种类不断推陈出新，中高端地毯产品发展迅速，人均购买力持续增大。在这样的背景下，举办2015“藏毯展”意义非凡，不仅能有效带动全省藏毯产业发展，还将极大地提振、鼓舞其他产业调整结构、升级转型的信心。\n" +
					"\n" +
					"    在谈到藏毯产业与“一带一路”发展关系时，马新民说，西宁是唐蕃古道和古丝绸之路的交汇点，这两条线基本是地毯的生产国，延伸到欧洲便是消费国。借助“一带一路”战略和“藏毯展”搭建的国际化平台，打开南亚、中亚藏毯的市场，推广传播青海藏文化与民族工艺，提升品牌竞争力和影响力将指日可待。"+"\n"+"  a",
	};

	private static String[] content2 = new String[]{
			"“    我要把青海枸杞卖到全世界!”海西蒙古族藏族自治州乌兰县赛西珊瑚果种植专业合作社带头人张海红,在“十三五”开局之年,把一粒粒“青海红”卖到了德国。\n" +
					"\n" +
					"    瞅准青海积极融入国家一带一路战略带来的大机遇,赛西珊瑚果种植专业合作社在种植生产基础上延伸产业链,加大开发枸杞芽茶饮料、枸杞蜂蜜、枸杞鸡、枸杞酒等精深加工产品,合作社的枸杞成功销入欧盟市场,2016年枸杞芽茶饮料顺利拿下德国企业“大单”,成为长期合作伙伴。而当地298户农户在张海红的带领下,脱下“贫困帽”走上小康路。\n" +
					"\n" +
					"    融入大战略,开拓大格局,促进大发展。理念转变提升之间,青海外向型经济打开新市场空间,对外开放步伐走出了新线路,越来越多的企业、集体和个人同张海红的合作社一样,收获着转变“生产”出的倍增发展红利。\n" +
					"\n" +
					"    2016年9月8日,一条钢铁巨龙“呜呜——呜——”呼啸着从西宁市双寨铁路物流中心发出,前往位于比利时的欧洲第二大集装箱港口安特卫普。这是青藏高原首趟中欧班列,它载着青海高原出名的特色产品藏毯、枸杞,以疾风迅雷之势驶向一万公里外的欧洲。\n" +
					"\n" +
					"“    装载44个标准集装箱,途经甘肃、新疆两省区,由阿拉山口口岸出境,沿线路过哈萨克斯坦、俄罗斯、白俄罗斯、波兰、德国5国,最终到达比利时安特卫普,全程9838公里,其中国内段2644公里,国外段7194公里,运行全程约需12天。”浏览青藏高原首趟中欧班列“说明书”,不由脑海浮现一条青海走出世界的“新丝路”,这条青海着力打造的新时代新贸易丝路,恰与国家一带一路发展路径相一。\n" +
					"\n" +
					"    “这不是巧合,这是青海主动谋变、积极在转变中寻找突破跳跃的行动之一。”在省商务厅厅长尚玉龙看来,欧洲市场长期对我国青藏高原产品保持较高关注度,其中比利时已为青海藏毯提供6年保税仓储服务,另外柴达木盆地出产的枸杞在德国、荷兰等地也广受欢迎。“中欧班列”的开通,不仅将有效盘活青藏高原有机农牧产品、药材、民族手工艺品等特色资源,还将作为一个重要支点,撬动出青海立足本地发挥资源禀赋,融入“一带一路”经济带外向发展的无限潜能。\n" +
					"\n" +
					"    长期以来,青海藏羊地毯(集团)有限公司出口的地毯都是发海运到欧洲,再装箱装船出口。海运时间大概要45天,加上欧洲运抵各消费国家的时间,其运费和运距周期不言而喻,这很大程度影响了企业的资金回流周转率。而“中欧班列”比海运节省30多天,比航空运费低了五分之三。且“中欧班列”所经的沿线国家都是地毯消费国,可以说,“中欧班列”的开通,为青海特色产品直销全世界搭建了“直通车”。\n" +
					"\n" +
					"    如今搭乘“中欧班列”,不仅仅是一条条精美绝伦的藏毯插上翅膀“飞”出了国门,不仅仅是一粒粒小小“青海红”拓展出大市场,更进一步促进青海由对外贸易内陆腹地加快向前沿阵地转变。\n" +
					"\n" +
					"    作为青海行业标杆、藏毯业“领头羊”的青海藏羊地毯(集团)有限公司,在我国经济下行压力和全球金融危机的不利环境下,2016年实现了出口额达3760万美元的“逆袭”,较2015年增加了近1000万美元。不仅如此,还开拓了迪拜与土耳其两个产品销售国,在“一带一路”沿线国家铺设了10家地毯体验店。 由此,全球37个国家遍布“藏羊”的身影。\n" +
					"\n" +
					"“    青海藏毯产业借助国家一带一路战略和藏毯展搭建的国际化平台成功走出国门,向全世界展现着青藏高原的瑰丽精品,而今,‘中欧班列’的运行,再次为特色民族产业打开欧洲市场构建了开放通道,为推广传播青海文化与民族工艺,提升品牌竞争力和影响力拓展了全新空间。”企业负责人马新民感慨万千。\n" +
					"\n" +
					"    回顾企业发展史,从2008年通过“藏毯展”推介会走出国门,到获得全世界地毯业最高展会——德国汉诺威国际地面地毯材料展览会的“入场券”,再到“十三五”开局之年乘着“中欧班列”大放异彩,“藏羊”正是青海积极融入“一带一路”建设和对外开放国家战略的受益者之一。\n" +
					"\n" +

								"为了在低迷的市场大环境中谋发展,“藏羊”的生产方式、销售模式不停转变,每年针对不同销售国家的特色研发个性化产品,因地制宜打造出符合“一带一路”国家的高、中、低端不同消费群体的产品,实现了利益最大化；在生产过程中, 企业大量运用了信息化和大数据管理,实现了成本最小化。转型发展的路子走对了,带来的是订单量的直线上涨,“藏羊”全年吸纳了青海藏区6000多吨羊毛,直接带动了牧民增收。在转型升级中, 遵循打造“构建全方位、多层次、宽领域的对外开放格局”的外向型经济总基调,不断探寻中,青海培育出外贸竞争的新优势,开放型经济发展格局逐步形成—— 2016年,青海曹家堡保税物流中心(B型)落成,成为构建青海开放型经济新体制的重要平台和对外开放的又一重磅节点。一条又一条国际新航线的开通,中欧班列、青海曹家堡保税物流中心等“对外通道”并驾齐驱,各地区发挥资源、区位、民族、产业等比较优势积极融入“一带一路”建设,西宁市和海东市的竞争力进一步增强,柴达木和环湖地区承接国际资本和产业转移的步伐加快……融入大战略,迈向大发展,青海加快生成开放型经济新增长极。"+"\n"+"  a",
			"2018中国(青海)藏毯国际展览会开展在即，5月31日，位于青海国际会展中心A馆展馆的各个展位正在紧锣密鼓地进行布展，藏羊国际地毯股份有限公司的精品展位上，销售员包先生正在和布展的工人们摆放要展出销售的藏毯。\n" +
					"\n" +
					"　　近200平方米的展位已经装饰完毕，7个展架上整齐的堆放着近500张不同尺寸、不同花色的手工藏毯，后面墙上挂着5张风格迥异的地毯。其中，有以温暖的红色为主的黄昏景，以淡灰色为主的荷花中国风，以青色为主的渐变风，以牡丹为主的富贵风和以黑色为主的泼墨风，在射灯的映衬下格外抓人眼球。几个架子中间摆放着小玻璃桌和皮椅，是休息和顾客沟通的区域。\n" +
					"\n" +
					"　　另一面，工作人员正在进行射灯调试：“这个射灯非常重要。墙上挂的毯子在亮光下才能显出特别来，顾客在远处一眼就能看见，所以得把射灯调好了。”\n" +
					"\n" +
					"　　据了解，这里的藏毯都是用桑蚕丝手工编织，一张毯子需要半年才能出成品。“不仅是挂毯，近几年好多人家用地毯做地板，一是因为花色多样，摆在家里好看，二是觉得地毯没有甲醛，用着安全，所以，咱们纯手工编织的藏毯就变得比较受欢迎。”包先生说。\n" +
					"\n" +
					"　　“我们春节后就已经开始做准备，并且，在一个月前进行展位的装修工作。”一位正在搬运地毯的师傅告诉记者，两天前，要销售展出的地毯开始陆续进馆，展位上的工作人员早晨八时到馆晚上八时才下班，所有的展会工作在紧锣密鼓的筹备中进行着，明天还要仔细再归置检查展位的细节，为6月2日的开幕做好充分的准备。\n" +
					"\n" +
					"　　“这次在展馆展出销售的藏毯共有3000多平方米，都是本地手工编织的藏毯，满铺的、挂壁的，各种风格都有；去年我们也参加了藏毯展，销售额比较客观，希望今年能更好。”包先生说。"+"\n"+"  a",
			"山加，分红金额28420元；关布道尔吉，分红金额14210元；同加，分红金额49735元；金明，分红金额21315元……”7月9日，都兰县香加乡科学图生态畜牧业合作社的分红仪式，让这片美丽的草原再次欢腾起来。\n" +
					" \n" +
					"　　“去年底我们合作社就分红了，那是第一次分红，当时大家都高兴坏了，今年分得更多，我们家分了28000多元，最多的分了7万多元……”拿着分红的钱，华青加高兴得合不拢嘴。\n" +
					" \n" +
					"　　“这是今年我们合作社26户牧户高效养殖的利润分红，一共48万多元。今年收益好得很，贫困户每户也有2万元的分红。你看我们牧民们高兴得要跳起来了。”合作社理事长那木卡也是眉开眼笑。\n" +
					" \n" +
					"　　距都兰县城50公里的香加乡科学图生态畜牧业合作社成立于2016年，如今已发展成为全县最大规模的牛羊养殖专业合作社之一，总资产达4000万元以上，入股牲畜20000头(只)，入股草场4940公顷。\n" +
					" \n" +
					"　　那木卡介绍，合作社成立后，积极鼓励牧户转变传统的养殖方式，推进规模经营。藏羊高效养殖配套技术越来越成熟，为牧民增收致富提供了保障。村上的牧民，特别是贫困户收入得到很大提高，鼓舞了群众致富奔小康的干劲。\n" +
					" \n" +
					"　　“我们合作社发展的速度比较快一点，主要是因为高效养殖带来的效益特别突出，我们脱贫户都成为股东了。但我们是把生态放在第一位的，以草定畜，16亩(1.06公顷)草场定一只羊，多余的就出栏。”那木卡说。\n" +
					" \n" +
					"　　作为致富领头人的那木卡颇具商业头脑，说起高效养殖，头头是道。“以前的羊羔要养到10个月才出栏，一只羊最多卖400多元钱，还不算人工工资和草料。现在高效养殖的羊羔到四五个月就能出栏，如果体重不超过35公斤，一只羊羔就能赚到700元钱，如果再往大里养，不太划算，因为羊羔体重超过35公斤，就算成年羊了，价格就要低一些。我们的羊羔四五个月就出栏了，早早就被格尔木的饭馆订掉了。”\n" +
					" \n" +
					"　　那木卡告诉我们，传统放牧是早上天亮就把羊群赶出去，晚上天黑才赶回圈里，在草原上放牧时间特别长。而现在，早上十点钟把羊群赶到天然草场，下午三四点钟就赶回圈里，在草原上放牧三到五个小时就可以了。天然草场的放牧时间缩短了，加上羔羊早早出栏，草场的压力减轻了，草长得特别好。天然草场的草刚好留到冬天给母羊吃，母羊冬天不会塌膘，料也不用买太多。\n" +
					" \n" +
					"　　“今年我们给母羊做了同期发情，3月底配的种，现在母羊已经怀孕，到9月15号左右母羊就开始下第二胎了，基本上做到了三年两胎。原来牧民们都习惯每年秋季集中屠宰，羊肉集中上市，羊肉的价格就掉下来了。高效养殖的羔羊出栏早，能够均衡出栏，也就保证羊肉价格一年四季不会有太大的起伏。”合作社监事才仁补充说。\n" +
					" \n" +
					"　　在合作社，记者遇到来自另外一个村的才仁道力吉，他是代表本村的6户牧民前来咨询加入科学图合作社的相关事宜。\n" +
					" \n" +
					"　　“我们虽然是柯柯哈达村的，但科学图村合作社搞得好，收入很高，我们就想加入到他们合作社里来。”\n" +
					" \n" +
					"　　“其实在哪个合作社都一样，只要你们掌握了高效养殖技术，严格按照配方饲养，效果都很好。在你们养殖的过程中，如果遇到困难，我们就来给你们讲课，帮你们解决……”青海大学农牧学院副教授、产业平台专家王志有耐心解释。2014年，都兰县开始发展高效养殖技术，从最初的5个试点，发展到5个乡镇的32个点，高效养殖的母羊从最初的300多只，发展到2017年底的10000多只，成效颇为显著。\n" +
					" \n" +
					"　　“2016年，我们对科学图村生态畜牧业合作社在格尔木出售的40多只四月龄羔羊，进行跟踪称重，最大的能达到18.5公斤，最小的14.5公斤，平均每公斤按61.5元计价，一只羊羔卖到1143元。最后我们初步计算，除去饲料、人工成本，一只羔羊比传统养殖的能增收200到350元钱。2016年6月龄的羔羊体重平均达到33.8公斤，2017年的至少达到了36.8公斤以上。所以说，高效养殖这项技术，根据我们四年的连续实施效益是非常可观的。”都兰县畜牧兽医工作站畜牧师王传洋详细介绍。\n" +
					" \n" +
					"　　“母羊从妊娠期到泌乳期结束一共需要大约20公斤料，羊羔断奶到六月龄出栏，体重达到35公斤以上，要用72公斤料，从羊羔到母羊一共才要92公斤料，按1公斤3元计算，共276元钱，就是从母羊到羊羔所有饲料的成本。一只羊出肉率在50%左右，按最低标准1公斤羊肉20元计算，一只羊能卖350元钱，也是挺合算的。350元，减去276元，一只羊能有70元钱的利润，100只羊至少有7000元的利润，300只羊就有21000元的利润，像今年1公斤羊肉五六十元，利润就很大了……”\n" +
					" \n" +
					"　　在7月底天峻县举办的全省“牦牛藏羊高效养殖技术培训班”上，省农牧业科技创新羊产业平台首席专家、青海大学农牧学院教授侯生珍对藏羊高效养殖成本和效益的分析，令来自全省高效养殖技术推广的负责人及技术人员频频点头。\n" +
					" \n" +
					"　　我省草原面积5.47亿亩(2313万公顷)，是全省最大的生态系统。青海也是世界牦牛藏羊的主要生产区，牦牛藏羊是广大牧民群众赖于生存的物质基础。由于传统养殖模式，母畜繁殖性能低下、幼畜生长发育缓慢，家畜生产周期长，自然草地的生态压力较大，人草畜矛盾突出。\n" +
					" \n" +
					"　　针对这一难题，在省农牧厅的大力支持下，侯生珍带领着高原动物生产教学科研团队，以科技为引领，通过生产技术和生产方式的创新，展开了三江源藏羊规范高效养殖技术的研发与攻关，并将生态畜牧业发展与草地生态环境保护有机结合起来，科学核定了藏羊不同生理阶段放牧强度、补饲时间和补饲量，形成了一整套推动藏羊传统放牧养殖向高效、集约、生态化方向发展的技术路径和技术生产体系。通过技术手段，破解畜牧业生产中存在的诸多技术瓶颈问题。\n" +
					" \n" +
					"　　省农牧厅副厅长马清德认为，草地生态畜牧业持续健康发展，离不开科技创新的支撑和引领，而今，牦牛、藏羊高效养殖技术的诞生，无疑让生态畜牧业发展又跨上了新的台阶。高效养殖产业不仅能更好地为生态畜牧业增效、牧业增收服务，还能助推生态环保、有效提升牧民收益，促进脱贫攻坚巩固发展。\n" +
					" \n" +
					"　　对于高效养殖，有着多年养殖经验的共和县恰卜恰镇兴隆肉羊养殖专业合作社理事长马生海，感受很深。“前些年我们用自己的土办法养殖，羊的死亡率很高。后来我县农牧局、扶贫局，把青海大学的教授们请过来给我们讲高效养殖技术。我听了多次课后，开始用人家的方法养，包括一天喂多少料，草吃多少，放牧多少小时等等。结果和以前相比，收入多了一倍。以前一只羊一年下一胎，现在我们的羊是一年下两胎，一次下两个，你说效益提高了多少！ 2015年我们合作社开始有起色，2016年和2017年就好起来了，尤其是去年，纯收入就达到了80万元，平均每个人增加了2万多元的收入，今年看情况还要更好。”马生海说。\n" +
					" \n" +
					"　　同时，也正是产业平台专家的进村入社，让高效养殖技术真正落到了实处。\n" +
					" \n" +
					"　　“青海省农牧业科技创新羊产业技术研发与熟化平台，已经实现了全省羊产业技术研发—推广—应用三级平台的顺利对接，打通了农牧科技下乡‘最后一公里’的技术应用通道。”省农牧厅科技处处长熊进宁说。\n" +
					" \n" +
					"　　从事了三十多年畜牧兽医工作的都兰县畜牧兽医站站长刘东升认为，高效养殖是一项需要人力集中、技术集成精准的养殖方式，仅就分群放牧这一项要求，单独的牧户就无法做到，这项精准的技术也施展不开。必须借助生态畜牧业合作社的平台，统一配种、统一组群、统一防疫、统一放牧、统一饲喂、统一出栏，这样效果才能最大程度显现。\n" +
					" \n" +
					"　　“科学图生态畜牧业合作社的组织化程度很高，示范效果也极其明显，如果这项技术在合作社稳定发展下去，羊群就会一年比一年整齐。”\n" +
					" \n" +
					"　　融入了科技创新，生态畜牧业的内涵更加充实饱满。\n" +
					" \n" +
					"　　7月29日，在天峻县梅陇生态畜牧业合作社的秋季草场，正在进行草地生态畜牧业建设十周年现场观摩。\n" +
					" \n" +
					"　　“这是我们合作社高效养殖的羔羊群，羔羊到2个月的时候进行断奶补饲，6月龄羊羔的平均重量可以达到35公斤，比传统放牧的羊羔高出8公斤左右。”\n" +
					" \n" +
					"　　最后出来被观摩代表“检阅”的羊群是梅陇合作社6月龄的羔羊群。欢快奔跑着的雪白整齐的羔羊群，让代表们连声赞叹。\n" +
					" \n" +
					"　　在梅陇合作社藏羊高效养殖技术规范宣传栏里，技术要点简洁清晰：“羔羊出生后必须吃上初乳，7天内羔羊全舍饲饲养，日喂精料补充料3次，青干草2次，自由饮水，饮水要清洁、卫生……”\n" +
					" \n" +
					"　　“我们合作社高效养殖走的技术路线就是牲畜鉴定，然后淘汰不合格种畜，给合格母畜补饲，统一配种、产羔，再早期断奶，断奶后集中育肥。其实就是母畜放牧加补饲，种畜统一管理和配种，幼畜早期断奶，羔羊6月龄就能全部出栏，达到藏羊繁殖率95%以上。”梅陇生态畜牧业合作社理事长军青介绍。\n" +
					" \n" +
					"　　“自全国草地生态畜牧业试验区建设以来，我们都兰县始终把科技创新摆在首位，各试点社加强高效养殖、畜种改良、饲草种植等技术推广应用。2014到2017年，15个试点社开展藏羊高效养殖技术推广，羔羊繁活、羔羊增重、母羊损亡实现‘两增一降’，每只羔羊增值180元以上。2017年，全县牧民人均可支配收入达11350元，较2010年增长122.5%。科技创新支撑畜牧业发展成效显著，牧民从科技创新中尝到了增收致富的‘甜头’。”都兰县副县长张炳玉说。\n" +
					" \n" +
					"　　实践证明，羔羊6月龄出栏，相当于天然草场承载数量减少了50%，加快了羊群周转，有效地减轻了草场压力，科技手段有效破解了生产发展与生态保护之间的固有矛盾，为全省牧区贯彻落实生态保护第一理念，提供了可靠的现实路径。(王玉娟)"+"\n"+"  a",
			"贵南县过马营镇藏羊之府生态畜牧业合作社前身为贵南县尕洛托家庭牧场，该家庭牧场成立于2014年，2016年在贵南县委、县政府和县农牧部门的扶持下，以星级量化评定为抓手，通过股份制改造、生产要素整合转型升级为股份合作制合作社，合作社现有入社社员22户，入股草场20326.3亩、牲畜3460头只。2017年合作社通过一年的努力净收入达82.35万元：其中种植收入15万元，养殖收入50.35万元，农机具租赁收入17万元，发放牧工工资18.8405万元，预留公积金17.5万元，实现分红46.0095万元，合作社22户8583.89股，平均每股分红约53.6元，户均分红2.09万元。同时，合作社分流富余劳动力外出就业增收40.74万元。\n" +
					"\n" +
					"    藏羊之府生态畜牧业合作社积极发挥财政资金的杠杆作用，将贫困户到户扶持资金购置的牲畜以入股的形式与合作社建立联系，通过合作社发展，走特色产业扶贫路子，不仅解决了贫困户增收问题，还为合作社发展增添了动力。合作社利用经营收益，通过入股分红和提供就业发放工资的形式反哺贫困户，让贫困户享受发展红利，帮助贫困户脱贫致富。此次分红为4户贫困户分红54013.256元，户均分红13503.314元，解决贫困户就业4人，发放工资4万元。贫困户更藏加是合作社的放牧工，在加入合作社之前，一家3口全靠他放牧为生，地少、牛羊少，又缺技术，眼看自己脱贫无望，2017年，更藏加主动申请加入合作社，把自己的牲畜和草场连同产业扶持资金购置的牲畜全部入股到合作社里，算下来不多不少正好227.85股，2018年初分红拿到了12213元。除了分红，更藏加还能从合作社领到5000元的工资。领到钱，脱了贫，高高兴兴过新年的更藏加深深的为合作社点了“赞”。 分红大会结束后，合作社理事会向合作社成员发放价值1000元的新年慰问品，以感谢合作社成员一年付出的辛苦和努力。"+"\n"+"  a",
			"被誉为“高原之舟”的牦牛与北极熊、企鹅共称为“世界三大高寒动物”。世界上95%的牦牛在中国，这其中又有80%在安多藏区。8月21日，“改革开放40年新变迁·脱贫攻坚看甘肃”2018全国百家网媒扶贫攻坚典型宣传活动在甘南州夏河县的行程，网媒记者就走进了甘肃安多清真绿色食品有限公司。这里正在通过打造世界牦牛品牌和藏羊品牌来不断提升牧区牛羊肉附加值，带动当地牧民群众增收致富。"+"\n"+"  a",
					"\n" +
					"　　8月21日，在甘肃安多清真绿色食品有限公司，牦牛、藏羊市场收购价格随时更新。下午2时，藏羊的多地市场收购价格中最好的是安多集团的收购价，每斤为29元，高出其它市场收购价1元到2元。甘肃安多清真绿色食品有限公司营销部副总经理夏微告诉记者，目前，牦牛尚未开启大规模收购，等开始收购后安多集团的收购价依然高于外部市场。而藏羊的收购在高于市场价格的同时，牧民还会得到来自政府的补助，每只藏羊(36斤以上)补助50元，建档立卡的贫困户每只藏羊则补助70元，由此把实实在在的利润让给牧民，助力牧民群众增收致富。"+"\n"+"  a",

	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aactivity);

		Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
		toolbar.setTitle("首页详细");
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
		hktitle = intent.getStringExtra(A_NAME);
		position = intent.getIntExtra(A_POSITION,0);
		init();
	}

	private void init() {
		tv_acontent = (TextView)findViewById(R.id.tv_aa);
		tv_atitle = (TextView)findViewById(R.id.tv_aa_title);
		tv_atitle.setText(hktitle);

		if (news == 0){
			loadContent0();
		}else if (news ==1){
			loadContent1();
		}else if (news == 2){
			loadContent2();
		}


	}

	private void loadContent0(){
		int size = content0[position].length();
		int s = size-1;
		int e = size;
        if (multiWord != null){
            multiWord.clear();
        }
		multiWord = new SpannableStringBuilder();

//		StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);
//		ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#000000"));
//		multiWord.setSpan(colorSpan,0,30,Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//		multiWord.setSpan(styleSpan,0,4,Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

		switch (position){
			case 0:
				multiWord.append(content0[position]);
				Drawable drawable0 = getResources().getDrawable(R.drawable.cy1);
				drawable0.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan0 = new ImageSpan(drawable0,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan0,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 1:
				multiWord.append(content0[position]);
				Drawable drawable1 = getResources().getDrawable(R.drawable.qywh1);
				drawable1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan1 = new ImageSpan(drawable1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 2:
				multiWord.append(content0[position]);
				Drawable drawable2 = getResources().getDrawable(R.drawable.fp1);
				drawable2.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan2 = new ImageSpan(drawable2,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan2,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 3:
				multiWord.append(content0[position]);
				Drawable drawable3 = getResources().getDrawable(R.drawable.ldgh01);
				drawable3.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan3 = new ImageSpan(drawable3,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan3,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 4:
				multiWord.append(content0[position]);
				Drawable drawable4 = getResources().getDrawable(R.drawable.tj1);
				drawable4.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan4 = new ImageSpan(drawable4,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan4,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 5:
				multiWord.append(content0[position]);
				Drawable drawable5 = getResources().getDrawable(R.drawable.jx1);
				drawable5.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan5 = new ImageSpan(drawable5,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan5,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 6:
				multiWord.append(content0[position]);
				Drawable drawable6 = getResources().getDrawable(R.drawable.xx1);
				drawable6.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan6 = new ImageSpan(drawable6,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan6,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
		}
	}

	private void loadContent1(){
		int size = content1[position].length();
		int s = size-1;
		int e = size;
		if (multiWord != null){
		    multiWord.clear();
        }
		multiWord = new SpannableStringBuilder();
		switch (position){
			case 0:
				multiWord.append(content1[position]);
				Drawable drawable0_1 = getResources().getDrawable(R.drawable.one21);
				drawable0_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan0_1 = new ImageSpan(drawable0_1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan0_1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 1:
				multiWord.append(content1[position]);
				Drawable drawable1_1 = getResources().getDrawable(R.drawable.one22);
				drawable1_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan1_1 = new ImageSpan(drawable1_1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan1_1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 2:
				multiWord.append(content1[position]);
				Drawable drawable2_2 = getResources().getDrawable(R.drawable.one23);
				drawable2_2.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan2_2 = new ImageSpan(drawable2_2,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan2_2,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 3:
				multiWord.append(content1[position]);
				Drawable drawable3_1= getResources().getDrawable(R.drawable.one24);
				drawable3_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan3_1 = new ImageSpan(drawable3_1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan3_1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 4:
				multiWord.append(content1[position]);
				Drawable drawable4_11 = getResources().getDrawable(R.drawable.one25);
				drawable4_11.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan4_11= new ImageSpan(drawable4_11,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan4_11,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 5:
				multiWord.append(content1[position]);
				Drawable drawable5_1= getResources().getDrawable(R.drawable.one26);
				drawable5_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan5_1 = new ImageSpan(drawable5_1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan5_1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 6:
				multiWord.append(content1[position]);
				Drawable drawable6_1 = getResources().getDrawable(R.drawable.one27);
				drawable6_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan6_1 = new ImageSpan(drawable6_1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan6_1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;

			case 7:
				multiWord.append(content1[position]);
				Drawable drawable7_1 = getResources().getDrawable(R.drawable.one28);
				drawable7_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan7_1 = new ImageSpan(drawable7_1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan7_1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 8:
				multiWord.append(content1[position]);
				Drawable drawable8_1 = getResources().getDrawable(R.drawable.one29);
				drawable8_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan8_1 = new ImageSpan(drawable8_1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan8_1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
		}

	}

	private void loadContent2(){
		int size = content2[position].length();
		int s = size-1;
		int e = size;
        if (multiWord != null){
            multiWord.clear();
        }
		multiWord = new SpannableStringBuilder();
		switch (position){
			case 0:
				multiWord.append(content2[position]);

				Drawable drawable0_1 = getResources().getDrawable(R.drawable.onethreeone);

				drawable0_1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan0_1 = new ImageSpan(drawable0_1,ImageSpan.ALIGN_BOTTOM);


				multiWord.setSpan(imageSpan0_1,s-1,e-1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 1:
				multiWord.append(content2[position]);
				Drawable drawable1 = getResources().getDrawable(R.drawable.onethreetwo);
				drawable1.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan1 = new ImageSpan(drawable1,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan1,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 2:
				multiWord.append(content2[position]);
				Drawable drawable2 = getResources().getDrawable(R.drawable.onethreethree1);
				drawable2.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan2 = new ImageSpan(drawable2,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan2,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 3:
				multiWord.append(content2[position]);
				Drawable drawable3 = getResources().getDrawable(R.drawable.onethrnnfour1);
				drawable3.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan3 = new ImageSpan(drawable3,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan3,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
				break;
			case 4:
				multiWord.append(content2[position]);
				Drawable drawable4 = getResources().getDrawable(R.drawable.onethreefive1);
				drawable4.setBounds(0,0,drawablewidth,drawableheight);
				ImageSpan imageSpan4 = new ImageSpan(drawable4,ImageSpan.ALIGN_BOTTOM);
				multiWord.setSpan(imageSpan4,s,e, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
				tv_acontent.setText(multiWord);
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
