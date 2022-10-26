package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

		createList(cryptogram);

        return answer;
    }

	//String을 List로 변환하는 함수
	public static List<Character> createList(String word)
	{
		List<Character> wordList = new ArrayList<>();

		for (int i = 0; i < word.length(); i++)
			wordList.add(word.charAt(i));

		return wordList;
	}

	//중복하는 단어를 제거
	public static String remove(String cryptogram)
	{

	}
}
