package com.netty.core.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;

/**
 * 
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精 确的浮点数运算，包括加减乘除和四舍五入。
 */

public class ArithUtil {

	// 默认除法运算精度

	private static final int DEF_DIV_SCALE = 10;

	// 这个类不能实例化

	private ArithUtil() {

	}
	
	/**
	 * 随机字符串（数字和字母相间）
	 * @param m 位数
	 * @return
	 */
	public static String getAutoRandom(int m){
		try{
			StringBuffer sbf=new StringBuffer();
			for (int i = 0; i < m/2; i++) {
				char c = 'a';
				Random random = new Random();			 
			   	c = (char) (c + (int) (Math.random() * 26));		 
				sbf.append(c+""+Math.abs(random.nextInt())%10);
			}  
			return sbf.toString();
		}catch(Exception e){			
			return "123456";
		}
	} 
	
	/**
	 * 产生6位随机数
	 * @return
	 */
	public static String getNumber6FromRandom(){
	   // return getRandomNum(4); //因此短信网关有问题，暂时跳过了
	    return nextRintBetweenMin_Max(1000, 9999)+"";
		//return "0000";
	}
	
	/**
	 * 产生随机数
	 * @param t 需要返回随机数的位数
	 * @return
	 */
	public static String getRandomNum(int t){
		   Random r = new Random();
		   int seed=(int)Math.pow(10, t);
		   System.out.println(seed);
		return String.valueOf(r.nextInt(seed)); 
	}

	/**
	 * 
	 * 提供精确的加法运算。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被加数
	 * 
	 * @param v2
	 * 
	 *            加数
	 * 
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.add(b2).doubleValue();

	}

	public static float add(float v1, float v2) {

		BigDecimal b1 = new BigDecimal(Float.toString(v1));

		BigDecimal b2 = new BigDecimal(Float.toString(v2));

		return b1.add(b2).floatValue();

	}

	public static BigDecimal addToBigDecimal(float v1, float v2) {

		BigDecimal b1 = new BigDecimal(Float.toString(v1));

		BigDecimal b2 = new BigDecimal(Float.toString(v2));

		return b1.add(b2);

	}

	/**
	 * 
	 * 提供精确的加法运算。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被加数
	 * 
	 * @param v2
	 * 
	 *            加数
	 * 
	 * @param scale
	 * 
	 *            表示表示需要精确到小数点以后几位。
	 * 
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2, int scale) {

		return round(add(v1, v2), scale);

	}

	public static float add(float v1, float v2, int scale) {

		return round(add(v1, v2), scale);

	}

	public static BigDecimal addToBigDecimal(float v1, float v2, int scale) {

		return roundToBigDecimal(addToBigDecimal(v1, v2), scale);

	}

	/**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被减数
	 * 
	 * @param v2
	 * 
	 *            减数
	 * 
	 * @return 两个参数的差
	 */

	public static double sub(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.subtract(b2).doubleValue();

	}

	public static float sub(float v1, float v2) {

		BigDecimal b1 = new BigDecimal(Float.toString(v1));

		BigDecimal b2 = new BigDecimal(Float.toString(v2));

		return b1.subtract(b2).floatValue();

	}

	/**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被减数
	 * 
	 * @param v2
	 * 
	 *            减数
	 * 
	 * @param scale
	 * 
	 *            表示表示需要精确到小数点以后几位。
	 * 
	 * @return 两个参数的差
	 */

	public static double sub(double v1, double v2, int scale) {

		return round(sub(v1, v2), scale);

	}

	public static float sub(float v1, float v2, int scale) {

		return round(sub(v1, v2), scale);

	}

	/**
	 * 
	 * 提供精确的乘法运算。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被乘数
	 * 
	 * @param v2
	 * 
	 *            乘数
	 * 
	 * @return 两个参数的积
	 */

	public static double mul(double v1, double v2) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.multiply(b2).doubleValue();

	}

	public static float mul(float v1, float v2) {

		BigDecimal b1 = new BigDecimal(Float.toString(v1));

		BigDecimal b2 = new BigDecimal(Float.toString(v2));

		return b1.multiply(b2).floatValue();

	}

	/**
	 * 
	 * 提供精确的乘法运算。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被乘数
	 * 
	 * @param v2
	 * 
	 *            乘数
	 * 
	 * @param scale
	 * 
	 *            表示表示需要精确到小数点以后几位。
	 * 
	 * @return 两个参数的积
	 */

	public static double mul(double v1, double v2, int scale) {

		return round(mul(v1, v2), scale);

	}

	public static float mul(float v1, float v2, int scale) {

		return round(mul(v1, v2), scale);

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被除数
	 * 
	 * @param v2
	 * 
	 *            除数
	 * 
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2) {

		return div(v1, v2, DEF_DIV_SCALE);

	}

	public static float div(float v1, float v2) {

		return div(v1, v2, DEF_DIV_SCALE);

	}

	/**
	 * 
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * 
	 * 
	 * @param v1
	 * 
	 *            被除数
	 * 
	 * @param v2
	 * 
	 *            除数
	 * 
	 * @param scale
	 * 
	 *            表示表示需要精确到小数点以后几位。
	 * 
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

			"The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		BigDecimal b2 = new BigDecimal(Double.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	public static float div(float v1, float v2, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

			"The scale must be a positive integer or zero");

		}

		BigDecimal b1 = new BigDecimal(Float.toString(v1));

		BigDecimal b2 = new BigDecimal(Float.toString(v2));

		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).floatValue();

	}

	/**
	 * 
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * 
	 * 
	 * @param v
	 * 
	 *            需要四舍五入的数字
	 * 
	 * @param scale
	 * 
	 *            小数点后保留几位
	 * 
	 * @return 四舍五入后的结果
	 */

	public static double round(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(
					"The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	public static float round(float v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

			"The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Float.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).floatValue();

	}

	public static BigDecimal roundToBigDecimal(BigDecimal b, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

			"The scale must be a positive integer or zero");

		}

		// BigDecimal b = new BigDecimal(Float.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);

	}

	public static BigDecimal roundToYjsDecimal(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

			"The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);

	}

	public static double roundToYjsDouble(double v, int scale) {

		if (scale < 0) {

			throw new IllegalArgumentException(

			"The scale must be a positive integer or zero");

		}

		BigDecimal b = new BigDecimal(Double.toString(v));

		BigDecimal one = new BigDecimal("1");

		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

	}

	/**
	 * 
	 * float 转换成 bigDecimal
	 * 
	 * @param v1
	 * 
	 * @return
	 */

	public static BigDecimal floatToBigDecimal(float v1) {

		BigDecimal b1 = new BigDecimal(Float.toString(v1));

		return b1;

	}

	public static BigDecimal doubleToBigDecimal(double v1) {

		BigDecimal b1 = new BigDecimal(Double.toString(v1));

		return b1;

	}

	/**
	 * 
	 * String 转换成 bigDecimal
	 * 
	 * @param v1
	 * 
	 * @return
	 */

	public static BigDecimal stringToBigDecimal(String v1) {

		BigDecimal b1 = new BigDecimal(v1);

		return b1;

	}
	
	/**
	 * 返回一个 MIN 和 MAX 范围内的整数值
	 * 公式：int randNumber = rand.nextInt(MAX - MIN + 1) + MIN;
	 * @param min
	 * @param max
	 * @return
	 */
	public static int nextRintBetweenMin_Max(final int MIN,final int MAX){
		 Random rand = new Random();  
		 return  rand.nextInt(MAX - MIN + 1) + MIN;
	}
	
	/**
	 * ##,###.00 现金格式化
	 * @param money
	 * @return
	 */
	public static String formatMoney(double money){
		 DecimalFormat myformat = new DecimalFormat();
		   myformat.applyPattern("##,###.00");
		   //System.out.println(myformat.format(11555555112345.12345));
		   return myformat.format(money);
	}
	
	/**
	 * 返回表示为：[0, MAX) 之间的随机整数
	 * @param MAX
	 * @return
	 */
	public static int nextRint(final int MAX){
		 Random rand = new Random(); 
		 return rand.nextInt(MAX);
	}
	
	/**
	 * 将阿拉伯数字转换成对应的大写
	 * @param amount
	 * @return
	 */
	public static String getUpperChineseMoney(String amount) {  
        
	    if (null==amount||"".equals(amount)||amount.indexOf("-")!=-1)  
	        return "";  
	      
	      
	    if (amount == null||Double.parseDouble(amount)==0) {  
	           return "零元整";  
	       }  
	         
	       boolean islt0 = false;  
	       if(Double.parseDouble(amount) < 0.001){  
	        islt0=true;  
	        amount = (-Double.parseDouble(amount))+"";  
	       }  
	  
	       final String[] upperUnit = {  
	                                  "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万",  
	                                  "仟", "佰", "拾", "元"};  
	       final String[] upperNumber = {  
	                                    "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒",  
	                                    "捌", "玖"};  
	       final String[] upperDec = {  
	                                 "角", "分"};   
	       StringBuffer convertedMoney = new StringBuffer("");  
	       String returnString = "";  
	  
	       try {  
	           //System.out.println(amount+"----------------------");  
	           DecimalFormat dcf = new DecimalFormat("###########0.00");  
	           String numString = dcf.format(Double.parseDouble(amount));  
	           System.out.println(numString+"----------------------");  
	           numString=numString.replaceAll(",",".");  
	           //System.out.println(numString+"----------------------");  
	           int dotPos = numString.indexOf(".");  
	           String integerStr = numString.substring(0, dotPos);  
	           String decStr = numString.substring(dotPos + 1);  
	           int lenInt = integerStr.length();  
	           int lenDec = 0;  
	           if ("00".equalsIgnoreCase(decStr)) {  
	               lenDec = 0;  
	           } else {  
	               lenDec = 2;  
	           }  
	  
	           if (lenInt > 13) {  
	               return "数字太大";  
	           }  
	  
	           boolean zeroFlg = false;  
	           int lenEmpty = 13 - lenInt;  
	           for (int i = 0; i < lenInt; i++) {  
	               String number = integerStr.substring(i, i + 1);  
	               String unit = upperUnit[lenEmpty + i];  
	               String upNum = upperNumber[Integer.parseInt(number)];  
	               if ("0".equalsIgnoreCase(number)) {  
	                   if (!zeroFlg) {  
	                       zeroFlg = true;  
	                   }  
	                   if ("亿".equals(unit) || "万".equals(unit) || "元".equals(unit)) {  
	                       convertedMoney.append(unit);  
	                   }  
	               } else {  
	                   if (zeroFlg) {  
	                       convertedMoney.append("零").append(upNum).append(unit);  
	                       zeroFlg = false;  
	                   } else {  
	                       convertedMoney.append(upNum).append(unit);  
	                   }  
	               }  
	           }  
	           if (lenDec == 0) {  
	               convertedMoney.append("整");  
	           } else {  
	               String jiao = upperNumber[Integer.parseInt(decStr.substring(0,  
	                       1))];  
	               if (!"0".equals(decStr.substring(0, 1))) {  
	                   convertedMoney.append(jiao).append(upperDec[0]);  
	               } else {  
	                   convertedMoney.append(jiao);  
	               }  
	  
	               String fen = upperNumber[Integer.parseInt(decStr.substring(1, 2))];  
	               if (!"0".equals(decStr.substring(1, 2))) {  
	                   convertedMoney.append(fen).append(upperDec[1]);  
	               } else {  
	                   convertedMoney.append("整");  
	               }  
	           }  
	  
	           returnString = convertedMoney.toString();  
	           //if (judgeUnit(returnString)) {  
	               returnString = returnString.replaceFirst("亿万", "亿");  
	          // }  
	  
	       } catch (Exception ex) {  
	        ex.printStackTrace();  
	           return "输入格式不正确！";  
	       }  
	       if(islt0){  
	        returnString="负"+returnString;  
	       }  
	       return returnString;  
	   }          
	
	public static String getMoneyFormat(BigDecimal money){
	    if(money==null){
	    	money=new BigDecimal(0);     
	    }
		NumberFormat currency = NumberFormat.getCurrencyInstance();//建立货币格式化引用  
		//System.out.println("Loan amount:\t" + currency.format(bigLoanAmount)); 
		return currency.format(money);
	}

	// 测试代码

	public static void main(String[] args) {
		System.out.println(getUpperChineseMoney("54545454"));  
		long a=100011;
        long b=200022;
        Double d=new Double(b-a);
        DecimalFormat   fmt   =   new   DecimalFormat("##,###,###,###,##0.00");   
        System.out.println(fmt.format(d/100));   

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println(nf.format(88888.88));

	}
	
	

}
