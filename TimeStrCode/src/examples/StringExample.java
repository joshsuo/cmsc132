package examples;
public class StringExample {

	public static void main(String[] args) {
		String str1 = new String("College"), str2 = new String(str1);
		System.out.println(str1 != str2 ? "Different" : "Same");
	
		String str3 = "Park", str4 = "Park";
		System.out.println(str3 != str4 ? "Different2" : "Same2");

		String str5 = new String("Terps"), str6 = new String("Terps");
		System.out.println(str5 != str6 ? "Different3" : "Same3");
	}
}
