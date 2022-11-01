package onboarding;

public class Problem4 {
	public static String solution(String word) {
		String answer = "";

		answer = makeBackward(word);

		return answer;
	}

	/**
    * 단어를 거꾸로 만든다.
    * @param 목표 단어
    * @return 거꾸로 변경된 단어
    */
	private static String makeBackward(String word) {
		char[] newWord = new char[word.length()];

		for (int index = 0; index < word.length(); index++) {

			newWord[index] = backwardChar(word.charAt(index));

		}

		return String.copyValueOf(newWord);
	}

	/**
    * 해당철자에 거꾸로된 철자를 찾는다
    * @param 해당 철자
    * @return 거꾸로 변경된 철자
    */
	private static char backwardChar(char ch) {

		char backwardChar = ch;

		int sortResult = sortSpelling(ch);
		
		if(sortResult != 0) {
			backwardChar = (char)(sortResult-ch);
		}

		return backwardChar;
	}

	/**
    * 해당철자를 분류하여 전달한다
    * @param 해당 철자
    * @return 분류된 값(65 + 90 : 대문자인경우 / 97 + 122 : 소문자인경우 / 0 : 그외)
    */
	private static int sortSpelling(char ch) {

		int sortResult = 0;
		if (65 <= ch && ch <= 90) {
			sortResult = 65 + 90; /* 대문자인경우 */
		}
		if (97 <= ch && ch <= 122) {
			sortResult = 97 + 122; /* 소문자인경우 */
		}


		return sortResult;
	}
}
