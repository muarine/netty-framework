/**   
* @Title: ErrorCode.java 
* @Package com.rtmap.pay.constants 
* @Description: TODO(用一句话描述该文件做什么) 
* @author maoyun0903 maoyun@rtmap.com   
* @date 2015-4-10 下午05:09:43 
* @version V1.0   
*/
package com.netty.muarine.constants;

import java.util.HashMap;
import java.util.Map;

/** 
 * @ClassName: ErrorCode 
 * @Description: TODO(支付返回错误码) 
 * @author maoyun0903 maoyun@rtmap.com 
 * @date 2015-4-10 下午05:09:43 
 * @version V1.0  
 *  
 */
public class ErrorCode {
	
	private static Map<String, String> map = new HashMap<String, String>();
	
	static{
		
		map.put("NOAUTH", "商户无此接口权限");
		map.put("NOTENOUGH", "余额不足");
		map.put("ORDERPAID", "商户订单已支付");
		map.put("ORDERCLOSED", "订单已关闭");
		map.put("SYSTEMERROR", "系统错误");
		map.put("APPID_NOT_EXIST", "APPID不存在");
		map.put("MCHID_NOT_EXIST", "MCHID");
		map.put("APPID_MCHID_NOT_MATCH", "appid和mch_id不匹配");
		map.put("LACK_PARAMS", "缺少参数");
		map.put("OUT_TRADE_NO_USED", "商户订单号重复");
		map.put("SIGNERROR", "签名错误");
		map.put("XML_FORMAT_ERROR", "XML格式错误");
		map.put("REQUIRE_POST_METHOD", "请使用post方法");
		map.put("POST_DATA_EMPTY", "post数据为空");
		map.put("NOT_UTF8", "编码格式错误");
		
	}
	
	public static String errMsg(String errCode){
		if(errCode != null){
			return map.get(errCode);
		}
		return "";
	}
	
}
