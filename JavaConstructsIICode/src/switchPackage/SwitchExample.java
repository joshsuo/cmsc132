package switchPackage;

public class SwitchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 132;
		String lang ="";
		
		switch(num) {
		case 131:
		case 132:
			lang = "Java";
			break;
		case 216:
			lang = "C";
			break;
		default:
			lang="?";
		break;
		}
		
		System.out.println(lang);
		
		//new way as of Java 12
		lang = "";
		
		lang = switch(num) {
		case 131, 132 ->"Java";
		case 216 -> "C";
		default -> "?";
		};
		
		System.out.println(lang);
	}

}
