/**   
* @Title: Constants.java 
* @Package com.rtmap.pay.constants 
* @Description: TODO(用一句话描述该文件做什么) 
* @author maoyun0903 maoyun@rtmap.com   
* @date 2015-4-12 下午01:51:10 
* @version V1.0   
*/
package com.netty.muarine.constants;

/** 
 * @ClassName: Constants 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author maoyun0903 maoyun@rtmap.com 
 * @date 2015-4-12 下午01:51:10 
 * @version V1.0  
 *  
 */
public interface Constants {
	/**
	 * @ClassName: ORDER_STATUS 
	 * @Description: 订单状态
	 * @author maoyun0903(maoyun0903@163.com)
	 * @date 2015-4-18 上午11:04:34 
	 * @version V1.0
	 */
	interface ORDER_STATUS{
		/**
		 * 已下单，未支付
		 */
		int NONE = 0;
		/**
		 * 已支付,未提货
		 */
		int DONE = 1;
		/**
		 * 已提货
		 */
		int GET = 2;
		/**
		 * 已退货
		 */
		int RETURN = 3;
		/**
		 * 交易已取消
		 */
		int CANCEL = 4;
		/**
		 * 交易已删除
		 */
		int DELETE = 9;
	}
	/**
	 * 是否录入商品
	 * @author 轩
	 *
	 */
	interface Enter_Status{
		/**
		 * 未录入
		 */
		int NONE = 0;
		/**
		 * 已录入
		 */
		int DONE = 1;
	}
	
	/**
	 * 兑换状态
	 * @author 轩
	 *
	 */
	interface EXCHANGE_STATUS{
		/**
		 * 未兑换
		 */
		String NONE = "1";
		/**
		 * 已兑换
		 */
		String DONE = "2";
		
	}
	/**
	 * 商场账户状态
	 * @author 轩
	 *
	 */
	interface MARKETACCOUNT_STATUS{
		/**
		 * 不可用
		 */
		String NOUSE = "0";
		/**
		 * 可用
		 */
		String USE = "1";
	}
	/**
	 * 优惠券状态
	 * @author 轩
	 *
	 */
	interface TICKETWRITEOFF_STATUS{
		/**
		 * 未发放
		 */
		int NONE = 0;
		/**
		 * 已发放
		 */
		int GRANT = 1;
		/**
		 * 已领取
		 */
		int GET = 2;
		/**
		 * 已核销
		 */
		int USE = 4;		
	}
	
	/**
	 * 积分来源类型
	 * @author 轩
	 *
	 */
	interface JIFEN_SOURCE_STATUS{
		/**
		 * 支付
		 */
		String PAY = "1";
		/**
		 * 游戏 
		 */
		String GAME = "2";
		/**
		 * 积分兑换
		 */
		String EXCHANGE = "3";			
	}
	
	/**
	 * 核销类型
	 * @author 轩
	 *
	 */
	interface WRITE_OFF_TYPE{
		/**
		 * 优惠券
		 */
		String TICKET= "01";
		/**
		 * 兑换商品
		 */
		String EXCHANGE_PRODUCT = "02";
		/**
		 * 定位扫码
		 */
		String LOCATION = "03";			
		/**
		 * 提货
		 */
		String DELIVERY = "04";
	}
	
	/**
	 * 奖品类型
	 * @author 轩
	 *
	 */
	interface PRIZE_TYPE{		
		/**
		 * 商品
		 */
		String PRODUCT = "1";		
		/**
		 * 优惠券
		 */
		String TICKET= "2";
	}
	
	/**
	 * 积分商品是否可用
	 * @author 轩
	 *
	 */
	interface AVAILABLE_STATUS{
		
		/**
		 * 可用
		 */
		String USE = "1";		
		/**
		 * 不可用
		 */
		String NO= "2";
		
	}
	
}
