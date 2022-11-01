package onboarding;

public class Problem4 {
    public static String solution(String word) {

		char[] momUp = new char[26];
		char[] momDown = new char[26];
		char[] childUp = new char[26];
		char[] childDown = new char[26];

		for (int i = 0; i < 26; i++) {
			momUp[i] = (char) ((int) 'A' + i);
		}
		for (int i = 0; i < 26; i++) {
			momDown[i] = (char) ((int) 'a' + i);
		}
		for (int i = 0; i < 26; i++) {
			childUp[i] = momUp[25 - i];
			childDown[i] = momDown[25 - i];
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == ' ') {
				sb.append(word.charAt(i));
			} else {
				for (int j = 0; j < 26; j++) {
					if (word.charAt(i) == momUp[j]) {
						sb.append(childUp[j]);
					} else if (word.charAt(i) == momDown[j]) {
						sb.append(childDown[j]);
					}
				}
			}
		}

        String answer = sb.toString();
        
        return answer;
    }
}
