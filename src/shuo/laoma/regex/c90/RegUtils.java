package shuo.laoma.regex.c90;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtils {

	public static Pattern HTTP_PATTERN = Pattern.compile(
			"http://" + "[-0-9a-zA-Z.]+" // 主机名
			+ "(:\\d+)?" // 端口
			+ "(" // 可选的路径和查询 - 开始
				+ "/[-\\w$.+!*'(),%;:@&=]*" // 第一层路径
				+ "(/[-\\w$.+!*'(),%;:@&=]*)*" // 可选的其他层路径
				+ "(\\?[-\\w$.+!*'(),%;:@&=]*)?" // 可选的查询字符串
			+ ")?"); // 可选的路径和查询 - 结束 
	
	public static Pattern CHINESE_PATTERN = Pattern.compile(
			"[\\u4e00-\\u9fff]");

	public static Pattern GENERAL_EMAIL_PATTERN = Pattern.compile(
			"[0-9a-zA-Z][-._0-9a-zA-Z]{0,63}" // 用户名
			+ "@" 
			+ "([0-9a-zA-Z][-0-9a-zA-Z]{0,62}\\.)+" // 域名部分
			+ "[a-zA-Z]{2,3}"); // 顶级域名

	public static Pattern QQ_EMAIL_PATTERN = Pattern.compile(
			"(?![-0-9a-zA-Z._]*(--|\\.\\.|__))" // 点、减号、下划线不能连续出现两次或两次以上
			+ "[a-zA-Z]" // 必须以英文字母开头
			+ "[-0-9a-zA-Z._]{1,16}" // 3-18位 英文、数字、减号、点、下划线组成
			+ "[a-zA-Z0-9]@qq\\.com"); // 由英文字母、数字结尾

	public static Pattern SINA_EMAIL_PATTERN = Pattern.compile(
			"[a-z0-9]" // 4-16个字符，可使用英文小写、数字、下划线，但下划线不能在首尾
			+ "[a-z0-9_]{2,14}" 
			+ "[a-z0-9]@sina\\.com");

	public static Pattern IP_PATTERN = Pattern.compile(
			"(?<![0-9])" // 左边不能有数字
			+ "((0{0,2}[0-9]|0?[0-9]{2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}"
			+ "(0{0,2}[0-9]|0?[0-9]{2}|1[0-9]{2}|2[0-4][0-9]|25[0-5])" 
			+ "(?![0-9])"); // 右边不能有数字

	public static Pattern ID_CARD_PATTERN = Pattern.compile(
			"(?<![0-9])" // 左边不能有数字
			+ "[1-9][0-9]{14}" // 一代身份证
			+ "([0-9]{2}[0-9xX])?" // 二代身份证多出的部分
			+ "(?![0-9])"); // 右边不能有数字

	public static Pattern TIME_PATTERN = Pattern.compile(
			"(?<![0-9])" // 左边不能有数字
			+ "([0-1][0-9]|2[0-3])" // 小时
			+ ":" + "[0-5][0-9]"// 分钟
			+ "(?![0-9])"); // 右边不能有数字

	public static Pattern DATE_PATTERN = Pattern.compile(
			"(?<![0-9])" // 左边不能有数字
			+ "\\d{4}-" // 年
			+ "(0?[1-9]|1[0-2])-" // 月
			+ "(0?[1-9]|[1-2][0-9]|3[01])"// 日
			+ "(?![0-9])"); // 右边不能有数字

	public static Pattern FIXED_PHONE_PATTERN = Pattern.compile(
			"(?<![0-9])" // 左边不能有数字
			+ "(\\(?0[0-9]{2,3}\\)?-?)?" // 区号
			+ "[0-9]{7,8}"// 市内号码
			+ "(?![0-9])"); // 右边不能有数字

	public static Pattern MOBILE_PHONE_PATTERN = Pattern.compile(
			"(?<![0-9])" // 左边不能有数字
			+ "((0|\\+86|0086)\\s?)?" // 0 +86 0086
			+ "1[34578][0-9]-?[0-9]{4}-?[0-9]{4}" // 186-1234-5678
			+ "(?![0-9])"); // 右边不能有数字

	public static Pattern ZIP_CODE_PATTERN = Pattern.compile(
			"(?<![0-9])" // 左边不能有数字
			+ "[1-9][0-9]{5}" 
			+ "(?![0-9])"); // 右边不能有数字
	
	public static boolean isZipCode(String text) {
		return ZIP_CODE_PATTERN.matcher(text).matches();
	}

	public static void findZipCode(String text) {
		Matcher matcher = ZIP_CODE_PATTERN.matcher(text);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	public static void main(String[] args) {
		
	}
}
