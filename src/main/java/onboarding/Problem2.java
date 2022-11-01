package onboarding;

public class Problem2 {
	private static String removeRepeatedChar(String str){
		StringBuffer answer = new StringBuffer("");
		int i = 0;
		int flag;
		int length = str.length();
		while (i < length){
			char ch = str.charAt(i);
			flag = 1;
			i++;
			while (i < length && str.charAt(i) == ch){
				flag = 0;
				i++;
			}
			if (flag == 1){
				answer.append(ch);
			}
		}
		return answer.toString();
	}

	private static boolean checkRepeated(String str){
		for (int i = 0; i + 1 < str.length(); i++){
			if (str.charAt(i) == str.charAt(i + 1)){
				return true;
			}
		}
		return false;
	}
	public static String solution(String cryptogram) {
		String answer = removeRepeatedChar(cryptogram);
		while (checkRepeated(answer)){
			answer = removeRepeatedChar(answer);
		}
		return answer;
	}
}
