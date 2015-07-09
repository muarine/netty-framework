package com.netty.muarine.constants;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure {
	
	private static String key = "rtmap911rtmap110rtmap911rtmap119";

	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;


	/**
	 * 异步返回处理订单结果
	 */
	public static String AJAX_RETURN_XML = "<xml><return_code><![CDATA[%s]]></return_code><return_msg><![CDATA[%s]]></return_msg></xml>";

	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
		Configure.useThreadToDoReport = useThreadToDoReport;
	}

	public static String HttpsRequestClassName = "com.rtmap.pay.utils.HttpsRequest";

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static String getKey(){
		return key;
	}
	

	public static void setHttpsRequestClassName(String name){
		HttpsRequestClassName = name;
	}

}
