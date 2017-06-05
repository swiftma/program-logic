package shuo.laoma.regex.c89;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void split1(){
		String str = "abc,def,hello";
		String[] fields = str.split(",");
		System.out.println("field num: "+fields.length);
		System.out.println(Arrays.toString(fields));
	}
	
	
	public static void split2(){
		String str = "abc  def      hello.\n   world";
		String[] fields = str.split("[\\s.]+");
		System.out.println("field num: "+fields.length);
		System.out.println(Arrays.toString(fields));
	}
	
	public static void split3(){
		String str = ",abc,,def,,";
		String[] fields = str.split(",");
		System.out.println("field num: "+fields.length);
		System.out.println(Arrays.toString(fields));
	}
	
	public static void validate(){
	    String regex = "\\d{8}";
	    String str = "12345678";
	    System.out.println(str.matches(regex));
	}
	
    public static void find(){
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        String str = "today is 2017-06-02, yesterday is 2017-06-01";
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println("find "+matcher.group()
                +" position: "+matcher.start()+"-"+matcher.end());
        }
    }
    
    public static void findGroup() {
        String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        String str = "today is 2017-06-02, yesterday is 2017-06-01";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("year:" + matcher.group(1)
                + ",month:" + matcher.group(2)
                + ",day:" + matcher.group(3));
        }
    }
    
    public static void replace1(){
    	String regex = "\\s+";
    	String str = "hello    world       good";
    	System.out.println(str.replaceAll(regex, " "));
    }
    
	public static void replace2() {
		String regex = "(\\d{4})-(\\d{2})-(\\d{2})";
		String str = "today is 2017-06-02.";
		System.out.println(str.replaceFirst(regex, "$1/$2/$3"));
	}
  
	public static void replace3() {
		String regex = "#";
		String str = "#this is a test";
		System.out.println(str.replaceAll(regex, "\\$"));	
	}
	
	public static void replaceCat() {
	    Pattern p = Pattern.compile("cat");
	    Matcher m = p.matcher("one cat, two cat, three cat");
	    StringBuffer sb = new StringBuffer();
	    int foundNum = 0;
	    while (m.find()) {
	        m.appendReplacement(sb, "dog");
	        foundNum++;
	        if (foundNum == 2) {
	            break;
	        }
	    }
	    m.appendTail(sb);
	    System.out.println(sb.toString());
	}
	
	private static Pattern templatePattern = Pattern.compile("\\{(\\w+)\\}");

	public static String templateEngine(String template, Map<String, Object> params) {
	    StringBuffer sb = new StringBuffer();
	    Matcher matcher = templatePattern.matcher(template);
	    while (matcher.find()) {
	        String key = matcher.group(1);
	        Object value = params.get(key);
	        matcher.appendReplacement(sb, value != null ?
	                Matcher.quoteReplacement(value.toString()) : "");
	    }
	    matcher.appendTail(sb);
	    return sb.toString();
	}
	
	public static void templateDemo() {
	    String template = "Hi {name}, your code is {code}.";
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("name", "老马");
	    params.put("code", 6789);
	    System.out.println(templateEngine(template, params));
	}
	
	public static void main(String[] args) {
		templateDemo();
	}

}
