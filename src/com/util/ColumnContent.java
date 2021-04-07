package com.util;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * ColumnContent.java:工具类，此于为各个JTable提供列名称。
 * @author czp
 * @time 2013-7-11 上午12:23:56
 * 
 */
public class ColumnContent {
	
	
	
	// XIAOFEI_CLUMN_NAME:用于主界面AppMainFrame的Jtable中
	public static final String[] XIAOFEI_CLUMN_NAME=new String[]{"消费项目","项目单价","打折比例","消费数量","消费金额","消费时间","服务生","记账人",""};
	
	// YUDING_CLUMN_NAME:用于预定管理界面YdglDialog的Jtable中
	public static final String[] YUDING_CLUMN_NAME=new String[]{"预定编号","宾客姓名","联系电话","预定状态","预定包间类型","预定包间编号","预抵时间","保留时间","预定时间","备注"};
	
	// FUWUSHENG_CLUMN_NAME:用于服务生查询界面FwscxDialog的Jtable中
	public static final String[] FUWUSHENG_CLUMN_NAME=new String[]{"编号","姓名","性别","身份证","联系方式","服务区域","服务等级"};
	
	// BAOJIANLEIXING_CLUMN_NAME:用于系统设置界面XtszDialog的包间项目的Jtable中
	public static final String[] BAOJIANLEIXING_CLUMN_NAME=new String[]{"包间类型","最低消费","标准计费方式","容纳人数"};
	
	// BAOJIAN_CLUMN_NAME:用于系统设置界面XtszDialog的包间项目的Jtable中
	public static final String[] BAOJIAN_CLUMN_NAME=new String[]{"包间号","包间类型","包间状态","所在区域"};
	
	// SHANGPINLEIBIE_CLUMN_NAME:用于系统设置界面XtszDialog的商品项目设置的Jtable中
	public static final String[] SHANGPINLEIBIE_CLUMN_NAME=new String[]{"类别编号","商品类别","是否需要服务生提供服务"};
	
	// SHANGPIN_CLUMN_NAME:用于系统设置界面XtszDialog的商品项目设置的Jtable中
	public static final String[] SHANGPIN_CLUMN_NAME=new String[]{"项目编码","名称","单位","预设单价","成本价","项目类别","当前库存","自动计算库存","报警库存","能否兑换","兑换积分"};
	
	// FUWWUSHENGDENGJI_CLUMN_NAME:用于系统设置界面XtszDialog的服务生设置的Jtable中
	public static final String[] FUWUSHENGDENGJI_CLUMN_NAME=new String[]{"等级编号","服务生等级"};
	
	// FUWUSHENG1_CLUMN_NAME:用于系统设置界面XtszDialog的服务生项目设置的Jtable中
	public static final String[] FUWUSHENG1_CLUMN_NAME=new String[]{"编号","姓名","简称","性别","服务区域","区域性质","服务级别","联系方式","身份证"};
	
	// QUANXIANZU_CLUMN_NAME:用于系统设置界面XtszDialog的操作员设置的Jtable中
	public static final String[] QUANXIANZU_CLUMN_NAME=new String[]{"权限组编号","权限组名称"};
	
	// CAOZUOYUAN_CLUMN_NAME:用于系统设置界面XtszDialog的操作员设置的Jtable中
	public static final String[] CAOZUOYUAN_CLUMN_NAME=new String[]{"操作员编号","操作员姓名","当前状态","最大抹零金额(元)"};
	
	// JIFEIFANGFA_CLUMN_NAME:用于系统设置界面XtszDialog的计费设置的Jtable中
	public static final String[] JIFEIFANGFA_CLUMN_NAME=new String[]{"计费类型","计费单位(小时)","计费时间片(分钟)","进店后多久开始计费(分钟)","不足计费单位的计费方法"};
	
	// TESHUJIERI_CLUMN_NAME:用于系统设置界面XtszDialog的计费设置下的节假日设置的Jtable中
	public static final String[] TESHUJIERI_CLUMN_NAME=new String[]{"日期","名称"};
	
	// HUIYUANDENGJI_CLUMN_NAME:用于系统设置界面XtszDialog的会员设置的Jtable中
	public static final String[] HUIYUANDENGJI_CLUMN_NAME=new String[]{"会员等级编号","会员等级","初始积分","打折比率"};
	
	// SHANGPIN1_CLUMN_NAME:用于增加消费界面ZjxfDialog的Jtable中
	public static final String[] SHANGPIN1_CLUMN_NAME=new String[]{"项目编号","项目名称","单价","当前库存"};
	
	// XIAOFEIQINGDAN_CLUMN_NAME:用于增加消费界面ZjxfDialog的Jtable中
	public static final String[] XIAOFEIQINGDAN_CLUMN_NAME=new String[]{"包间号","项目名称","单价","打折比例","数量","金额","入账时间","服务生","记账人"};
	
	//CAIGOUSHANGPIN_CLUMN_NAME:用于采购商品界面CgjhDialog的Jtable中
		public static final String[] CAIGOUSHANGPIN_CLUMN_NAME=new String[]{"项目编码","项目名称","单位 ","单价","数量","金额"};
		
	//GONGHOUDANWEI_CLUMN_NAME:用于采购商品界面CgjhDialog的进货单位的JWindow中
	public static final String[] GONGHOUDANWEI_CLUMN_NAME=new String[]{"单位名称","联系电话","地址","备注"};
		
		
	//FEIYONGSHOURU1_CLUMN_NAME:用于财物管理界面CwglDialog的费用收入统计表1的JTable中
	public static final String[] FEIYONGSHOURU1_CLUMN_NAME=new String[]{"项目名称","项目金额","项目类型","备注信息"};
		
		
	//FEIYONGSHOURU1_CLUMN_NAME:用于财物管理界面CwglDialog的费用收入统计表1的JTable中
	public static final String[] FEIYONGSHOURU2_CLUMN_NAME=new String[]{"项目名称","项目金额","项目时间","经手人","备注信息"};
		
		
	//JINGYINGTONGJIBIAO1_CLUMN_NAME:用于财物管理界面CwglDialog的经营情况统计表1的JTable中
	public static final String[] JINGYINGTONGJIBIAO1_CLUMN_NAME=new String[]{"项目名称","发生金额(元)","累计金额(元)"};
		
		
	//JINGYINGTONGJIBIAO2_CLUMN_NAME:用于财物管理界面CwglDialog的经营情况统计表2的JTable中
	public static final String[] JINGYINGTONGJIBIAO2_CLUMN_NAME=new String[]{"日期","项目名称","金额","经手人"};
		
	//ZHANGKUAIYSYF_CLUMN_NAME:用于财物管理界面CwglDialog的应收应付表的应收应付账款的JTable中
	public static final String[] ZHANGKUAIYSYF_CLUMN_NAME=new String[]{"日期","单位名称","类型","应付账款","已付账款","应收账款","已收账款","备注"};
		
	//ZHANGKUAIMINGXIYSYF_CLUMN_NAME:用于财物管理界面CwglDialog的应收应付表的应收应付账款明细的JTable中
	public static final String[] ZHANGKUAIMINGXIYSYF_CLUMN_NAME=new String[]{"货单号","项目编码","项目名称","单位","单价","数量","金额"};
	
	
	public static final String[] XIAOFEIQINGDANMINGXI_CLUMN_NAME=new String[]{"包间号","消费项目","单价","打折比例","折后单价","打折金额","消费数量","应收金额","服务生","消费时间","记账人"};

	public static final String[] HUIYUAN_CLUMN_NAME=new String[]{"会员编号","会员姓名","性别","会员卡类型","储值卡余额","会员等级","当前积分","累计消费金额","生日","电话","登记日期","当前状态","备注"};

	public static final String[] HUIYUANXIAOFEI_CLUMN_NAME=new String[]{"会员编号","会员姓名","账单号","结算状态","手牌号","消费金额","优惠金额","实收金额","储值卡消费","结算时间"};

	public static final String[] CHUZHIKACHONGZHI_CLUMN_NAME=new String[]{"会员编号","会员姓名","充值时间","本次充值金额","折兑后金额","收款人"};

	public static final String[] CHUZHIKAZHUANZHANG_CLUMN_NAME=new String[]{"会员编号","会员姓名","转账类型","转账金额","转账时间","经手人"};

	public static final String[] GONGHUOSHANGXINXI_CLUMN_NAME=new String[]{"单位编号","单位全称","单位简拼","联系人","联系电话","联系地址","默认供应商","备注"};

	public static final String[] WANGLAIZHANGWUGHS_CLUMN_NAME=new String[]{"单位编号","单位简拼","业务编号","货单类型","填单日期","经手员工","应付账款","已付账款","应收账款","登记时间","备注"};

	public static final String[] CANGKU_CLUMN_NAME=new String[]{"仓库编号","仓库名称"};

	public static final String[] SHANGPINKUCUN_CLUMN_NAME=new String[]{"项目编号","项目名称","单位","当前库存","单位成本","库存总额"};

	public static final String[] ZAIDIANBINKEXIAOFEI_CLUMN_NAME=new String[]{"包间号","消费项目","单价","打折比例","折后单价","数量","优惠金额","应收金额","入账时间","消费结束时间","记账人","服务生"};

	public static final String[] LIDIANBINKEXIAOFEI_CLUMN_NAME=new String[]{"账单号","包间号","消费项目","单价","打折比例","折后单价","数量","优惠金额","应收金额","入账时间","消费结束时间","记账人","服务生"};

	public static final String[] DANXIANGDAZHESHEZHI_CLUMN_NAME=new String[]{"会员等级","打折比例","折后单价"};

	public static final String[] TICHENG_CLUMN_NAME=new String[]{"服务生等级","轮单提成","点单提成"};

	//用于商品管理界面中采购进货的供应商表CajhDialogWindow
	public static final String[] SUPPLIER_CLUMN_NAME = new String[]{"编号","单位名称","联系电话","地址","备注"};
	
	//用于商品管理界面中采购进货的供应商表CajhDialogWindow中添加商品的商品采购清单
	public static final String[] SHANGPINXIANGMU_CLUMN_NAME = new String[]{"项目编号","项目名称","单位成本","当前库存"};
	
	//商品管理采购进货中的添加商品界面ZjspCgjhDialog
	public static final String[] SHANGPINCAIGOULIST_CLUMN_NAME = new String[]{"项目编号","项目名称","单位","单价","数量","金额"};
	
	
	public static final String[] TIANJIASHANGPINXIANGMU_CLUMN_NAME = new String[]{"编号","名称","单位","数量","成本"};
	
	
	
	
	/**
	 * 
	 * @param columName:传入上面的列名称数组
	 * @return Vector<String>:返回列名称集合
	 * 
	 */
	public static Vector<String> arrayToVector(String[] columName){
		Vector<String> returnVector = new Vector<String>();
		
		//方法一：使用Collections集合工具类转换
		Collections.addAll(returnVector, columName);
		
		
		//通过遍历的方式逐一加到集合类中
		/*for(String col:columName){
			returnVector.add(col);
		}*/
		
		
		return returnVector;	
		
	}
}
