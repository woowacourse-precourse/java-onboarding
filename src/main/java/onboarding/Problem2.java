package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
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
