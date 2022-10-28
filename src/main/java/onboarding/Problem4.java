package onboarding;

public class Problem4 {
	public static String solution(String word) {
		char [] wordArray = word.toCharArray();
		int asciiNum = 0;

		for (int i = 0; i <wordArray.length; i++) {
			asciiNum = (int)wordArray[i];
			if (asciiNum >= 65 && asciiNum <= 90) {
				System.out.println("upper case : " + (char) asciiNum);
			} else if (asciiNum >= 97 && asciiNum <= 122) {
				System.out.println("lower case: " + (char) asciiNum);
			}
		}

		String answer = "";
		return answer;
	}
}
