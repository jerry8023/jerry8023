package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String DATE="yyyy-MM-dd";//������
	public static final String DATE_TIME="yyyy-MM-dd  HH:mm:ss";
	public static final String TIME="HH:mm:ss";
	public static final String YEAR_MONTH="yyyy-MM";//����
	public static final String DAY="dd";
	public static final String DATE_TIME1="yyyyMMddHHmmss";
	public static final String HOUR="HH";
	public static final String MINUTE="mm";
	public static final String YEAR="yyyy";
	public static final String MONTH="MM";
	public static final String DATE_TIME2="MM-dd  HH:mm";
	
	
	/**
	 * ���ݴ�����������Ͷ��󣬽���ת��Ϊָ��ģʽ���ַ���
	 * @param date
	 * @return
	 */
	public static String getStrDate(Date date,String pattern){
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(date);
		
	}
	
	
	
	
	//���ַ���ת��ΪUtil.date����
	public static Date parseDate(String strDate,String pattern){
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		 try {
			Date date = sdf.parse(strDate);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 
		 return null;
	}
	
	
	//���ַ���ת��ΪSql.date����
	public static java.sql.Date strToSqlDate(String date,String pattern){
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			java.util.Date utilDate =  sdf.parse(date);
			
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			
			return sqlDate;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}


