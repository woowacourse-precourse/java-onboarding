package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

		remove(createList(cryptogram));
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
	public static List<Character> remove(List<Character> duplication)
	{
		for (int i = 0; i < duplication.size(); i++)
		{
			if (i + 1 <= duplication.size())
			{
				if (duplication.get(i) == duplication.get(i + 1))
				{
					duplication.remove(i);
					duplication.remove(i + 1);
				}
			}
		}
		return duplication;
	}
}
