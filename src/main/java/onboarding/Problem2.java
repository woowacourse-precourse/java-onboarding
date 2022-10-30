package onboarding;

public class Problem2 {
	public static String solution(String cryptogram) {
		int len;

		do {
			len = cryptogram.length();
			cryptogram = removeDup(cryptogram);
		} while(len != cryptogram.length());

		return cryptogram;
	}

	private static String removeDup(String str) {
		String ret = "";
		int i = 1;
		boolean dup = false;
		char temp;

		if(str.length() == 0)
			return str;

		temp = str.charAt(0);
		while(i < str.length()) {
			if(temp != str.charAt(i)) {
				if(!dup)
					ret += temp;
				temp = str.charAt(i);
				dup = false;
			}
			else
				dup = true;
			i++;
		}

		if(!dup)
			ret += temp;

		return ret;
	}
}
