package onboarding;


public class prob2 {
	public static String check(StringBuilder str2, int length) {
		StringBuilder str = str2;
		System.out.println(str);
		for (int i = 0; i < length; i++) {
			if (str.length() == 0) {
				return "";
			}
			//System.out.println("i : " + i);
			if (i+1 < str.length()) {
				if (str.charAt(i) == str.charAt(i + 1)) {
					//System.out.println("str.charAt(i) : " + str.charAt(i));
					//System.out.println("str.charAt(i+1) : " + str.charAt(i + 1));

					str.deleteCharAt(i);
					str.deleteCharAt(i);
					length -= 2;

					check(str, length);
				}
			}

		}
		return str.toString();
	}


	public static void main(String[] args) {
		String s = "browoanoommnaon";
//		String s = "skkkkkiiiirtttt";
//		String s = "zyelleyz";
		StringBuilder str = new StringBuilder(s);
		System.out.println("test : " + (check(str, s.length())));

	}

}