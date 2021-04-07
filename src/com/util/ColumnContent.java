package com.util;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * ColumnContent.java:�����࣬����Ϊ����JTable�ṩ�����ơ�
 * @author czp
 * @time 2013-7-11 ����12:23:56
 * 
 */
public class ColumnContent {
	
	
	
	// XIAOFEI_CLUMN_NAME:����������AppMainFrame��Jtable��
	public static final String[] XIAOFEI_CLUMN_NAME=new String[]{"������Ŀ","��Ŀ����","���۱���","��������","���ѽ��","����ʱ��","������","������",""};
	
	// YUDING_CLUMN_NAME:����Ԥ���������YdglDialog��Jtable��
	public static final String[] YUDING_CLUMN_NAME=new String[]{"Ԥ�����","��������","��ϵ�绰","Ԥ��״̬","Ԥ����������","Ԥ��������","Ԥ��ʱ��","����ʱ��","Ԥ��ʱ��","��ע"};
	
	// FUWUSHENG_CLUMN_NAME:���ڷ�������ѯ����FwscxDialog��Jtable��
	public static final String[] FUWUSHENG_CLUMN_NAME=new String[]{"���","����","�Ա�","���֤","��ϵ��ʽ","��������","����ȼ�"};
	
	// BAOJIANLEIXING_CLUMN_NAME:����ϵͳ���ý���XtszDialog�İ�����Ŀ��Jtable��
	public static final String[] BAOJIANLEIXING_CLUMN_NAME=new String[]{"��������","�������","��׼�Ʒѷ�ʽ","��������"};
	
	// BAOJIAN_CLUMN_NAME:����ϵͳ���ý���XtszDialog�İ�����Ŀ��Jtable��
	public static final String[] BAOJIAN_CLUMN_NAME=new String[]{"�����","��������","����״̬","��������"};
	
	// SHANGPINLEIBIE_CLUMN_NAME:����ϵͳ���ý���XtszDialog����Ʒ��Ŀ���õ�Jtable��
	public static final String[] SHANGPINLEIBIE_CLUMN_NAME=new String[]{"�����","��Ʒ���","�Ƿ���Ҫ�������ṩ����"};
	
	// SHANGPIN_CLUMN_NAME:����ϵͳ���ý���XtszDialog����Ʒ��Ŀ���õ�Jtable��
	public static final String[] SHANGPIN_CLUMN_NAME=new String[]{"��Ŀ����","����","��λ","Ԥ�赥��","�ɱ���","��Ŀ���","��ǰ���","�Զ�������","�������","�ܷ�һ�","�һ�����"};
	
	// FUWWUSHENGDENGJI_CLUMN_NAME:����ϵͳ���ý���XtszDialog�ķ��������õ�Jtable��
	public static final String[] FUWUSHENGDENGJI_CLUMN_NAME=new String[]{"�ȼ����","�������ȼ�"};
	
	// FUWUSHENG1_CLUMN_NAME:����ϵͳ���ý���XtszDialog�ķ�������Ŀ���õ�Jtable��
	public static final String[] FUWUSHENG1_CLUMN_NAME=new String[]{"���","����","���","�Ա�","��������","��������","���񼶱�","��ϵ��ʽ","���֤"};
	
	// QUANXIANZU_CLUMN_NAME:����ϵͳ���ý���XtszDialog�Ĳ���Ա���õ�Jtable��
	public static final String[] QUANXIANZU_CLUMN_NAME=new String[]{"Ȩ������","Ȩ��������"};
	
	// CAOZUOYUAN_CLUMN_NAME:����ϵͳ���ý���XtszDialog�Ĳ���Ա���õ�Jtable��
	public static final String[] CAOZUOYUAN_CLUMN_NAME=new String[]{"����Ա���","����Ա����","��ǰ״̬","���Ĩ����(Ԫ)"};
	
	// JIFEIFANGFA_CLUMN_NAME:����ϵͳ���ý���XtszDialog�ļƷ����õ�Jtable��
	public static final String[] JIFEIFANGFA_CLUMN_NAME=new String[]{"�Ʒ�����","�Ʒѵ�λ(Сʱ)","�Ʒ�ʱ��Ƭ(����)","������ÿ�ʼ�Ʒ�(����)","����Ʒѵ�λ�ļƷѷ���"};
	
	// TESHUJIERI_CLUMN_NAME:����ϵͳ���ý���XtszDialog�ļƷ������µĽڼ������õ�Jtable��
	public static final String[] TESHUJIERI_CLUMN_NAME=new String[]{"����","����"};
	
	// HUIYUANDENGJI_CLUMN_NAME:����ϵͳ���ý���XtszDialog�Ļ�Ա���õ�Jtable��
	public static final String[] HUIYUANDENGJI_CLUMN_NAME=new String[]{"��Ա�ȼ����","��Ա�ȼ�","��ʼ����","���۱���"};
	
	// SHANGPIN1_CLUMN_NAME:�����������ѽ���ZjxfDialog��Jtable��
	public static final String[] SHANGPIN1_CLUMN_NAME=new String[]{"��Ŀ���","��Ŀ����","����","��ǰ���"};
	
	// XIAOFEIQINGDAN_CLUMN_NAME:�����������ѽ���ZjxfDialog��Jtable��
	public static final String[] XIAOFEIQINGDAN_CLUMN_NAME=new String[]{"�����","��Ŀ����","����","���۱���","����","���","����ʱ��","������","������"};
	
	//CAIGOUSHANGPIN_CLUMN_NAME:���ڲɹ���Ʒ����CgjhDialog��Jtable��
		public static final String[] CAIGOUSHANGPIN_CLUMN_NAME=new String[]{"��Ŀ����","��Ŀ����","��λ ","����","����","���"};
		
	//GONGHOUDANWEI_CLUMN_NAME:���ڲɹ���Ʒ����CgjhDialog�Ľ�����λ��JWindow��
	public static final String[] GONGHOUDANWEI_CLUMN_NAME=new String[]{"��λ����","��ϵ�绰","��ַ","��ע"};
		
		
	//FEIYONGSHOURU1_CLUMN_NAME:���ڲ���������CwglDialog�ķ�������ͳ�Ʊ�1��JTable��
	public static final String[] FEIYONGSHOURU1_CLUMN_NAME=new String[]{"��Ŀ����","��Ŀ���","��Ŀ����","��ע��Ϣ"};
		
		
	//FEIYONGSHOURU1_CLUMN_NAME:���ڲ���������CwglDialog�ķ�������ͳ�Ʊ�1��JTable��
	public static final String[] FEIYONGSHOURU2_CLUMN_NAME=new String[]{"��Ŀ����","��Ŀ���","��Ŀʱ��","������","��ע��Ϣ"};
		
		
	//JINGYINGTONGJIBIAO1_CLUMN_NAME:���ڲ���������CwglDialog�ľ�Ӫ���ͳ�Ʊ�1��JTable��
	public static final String[] JINGYINGTONGJIBIAO1_CLUMN_NAME=new String[]{"��Ŀ����","�������(Ԫ)","�ۼƽ��(Ԫ)"};
		
		
	//JINGYINGTONGJIBIAO2_CLUMN_NAME:���ڲ���������CwglDialog�ľ�Ӫ���ͳ�Ʊ�2��JTable��
	public static final String[] JINGYINGTONGJIBIAO2_CLUMN_NAME=new String[]{"����","��Ŀ����","���","������"};
		
	//ZHANGKUAIYSYF_CLUMN_NAME:���ڲ���������CwglDialog��Ӧ��Ӧ�����Ӧ��Ӧ���˿��JTable��
	public static final String[] ZHANGKUAIYSYF_CLUMN_NAME=new String[]{"����","��λ����","����","Ӧ���˿�","�Ѹ��˿�","Ӧ���˿�","�����˿�","��ע"};
		
	//ZHANGKUAIMINGXIYSYF_CLUMN_NAME:���ڲ���������CwglDialog��Ӧ��Ӧ�����Ӧ��Ӧ���˿���ϸ��JTable��
	public static final String[] ZHANGKUAIMINGXIYSYF_CLUMN_NAME=new String[]{"������","��Ŀ����","��Ŀ����","��λ","����","����","���"};
	
	
	public static final String[] XIAOFEIQINGDANMINGXI_CLUMN_NAME=new String[]{"�����","������Ŀ","����","���۱���","�ۺ󵥼�","���۽��","��������","Ӧ�ս��","������","����ʱ��","������"};

	public static final String[] HUIYUAN_CLUMN_NAME=new String[]{"��Ա���","��Ա����","�Ա�","��Ա������","��ֵ�����","��Ա�ȼ�","��ǰ����","�ۼ����ѽ��","����","�绰","�Ǽ�����","��ǰ״̬","��ע"};

	public static final String[] HUIYUANXIAOFEI_CLUMN_NAME=new String[]{"��Ա���","��Ա����","�˵���","����״̬","���ƺ�","���ѽ��","�Żݽ��","ʵ�ս��","��ֵ������","����ʱ��"};

	public static final String[] CHUZHIKACHONGZHI_CLUMN_NAME=new String[]{"��Ա���","��Ա����","��ֵʱ��","���γ�ֵ���","�۶Һ���","�տ���"};

	public static final String[] CHUZHIKAZHUANZHANG_CLUMN_NAME=new String[]{"��Ա���","��Ա����","ת������","ת�˽��","ת��ʱ��","������"};

	public static final String[] GONGHUOSHANGXINXI_CLUMN_NAME=new String[]{"��λ���","��λȫ��","��λ��ƴ","��ϵ��","��ϵ�绰","��ϵ��ַ","Ĭ�Ϲ�Ӧ��","��ע"};

	public static final String[] WANGLAIZHANGWUGHS_CLUMN_NAME=new String[]{"��λ���","��λ��ƴ","ҵ����","��������","�����","����Ա��","Ӧ���˿�","�Ѹ��˿�","Ӧ���˿�","�Ǽ�ʱ��","��ע"};

	public static final String[] CANGKU_CLUMN_NAME=new String[]{"�ֿ���","�ֿ�����"};

	public static final String[] SHANGPINKUCUN_CLUMN_NAME=new String[]{"��Ŀ���","��Ŀ����","��λ","��ǰ���","��λ�ɱ�","����ܶ�"};

	public static final String[] ZAIDIANBINKEXIAOFEI_CLUMN_NAME=new String[]{"�����","������Ŀ","����","���۱���","�ۺ󵥼�","����","�Żݽ��","Ӧ�ս��","����ʱ��","���ѽ���ʱ��","������","������"};

	public static final String[] LIDIANBINKEXIAOFEI_CLUMN_NAME=new String[]{"�˵���","�����","������Ŀ","����","���۱���","�ۺ󵥼�","����","�Żݽ��","Ӧ�ս��","����ʱ��","���ѽ���ʱ��","������","������"};

	public static final String[] DANXIANGDAZHESHEZHI_CLUMN_NAME=new String[]{"��Ա�ȼ�","���۱���","�ۺ󵥼�"};

	public static final String[] TICHENG_CLUMN_NAME=new String[]{"�������ȼ�","�ֵ����","�㵥���"};

	//������Ʒ��������вɹ������Ĺ�Ӧ�̱�CajhDialogWindow
	public static final String[] SUPPLIER_CLUMN_NAME = new String[]{"���","��λ����","��ϵ�绰","��ַ","��ע"};
	
	//������Ʒ��������вɹ������Ĺ�Ӧ�̱�CajhDialogWindow�������Ʒ����Ʒ�ɹ��嵥
	public static final String[] SHANGPINXIANGMU_CLUMN_NAME = new String[]{"��Ŀ���","��Ŀ����","��λ�ɱ�","��ǰ���"};
	
	//��Ʒ����ɹ������е������Ʒ����ZjspCgjhDialog
	public static final String[] SHANGPINCAIGOULIST_CLUMN_NAME = new String[]{"��Ŀ���","��Ŀ����","��λ","����","����","���"};
	
	
	public static final String[] TIANJIASHANGPINXIANGMU_CLUMN_NAME = new String[]{"���","����","��λ","����","�ɱ�"};
	
	
	
	
	/**
	 * 
	 * @param columName:�������������������
	 * @return Vector<String>:���������Ƽ���
	 * 
	 */
	public static Vector<String> arrayToVector(String[] columName){
		Vector<String> returnVector = new Vector<String>();
		
		//����һ��ʹ��Collections���Ϲ�����ת��
		Collections.addAll(returnVector, columName);
		
		
		//ͨ�������ķ�ʽ��һ�ӵ���������
		/*for(String col:columName){
			returnVector.add(col);
		}*/
		
		
		return returnVector;	
		
	}
}
