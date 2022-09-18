
public class ReplaceChar {
	public static void main(String[] args) {
		String tel="+33(0)6-36. 663 3 40";
		CharSequence cs =new StringBuffer("0123456789-() ");
		System.out.println(tel.replaceAll("[0-9+(). \\-]","").length());
//		System.out.println(tel.replace);
	}
}
