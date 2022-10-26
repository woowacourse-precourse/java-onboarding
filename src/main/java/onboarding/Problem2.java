package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

		answer = listToString(remove(createList(cryptogram)));
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
		for (int i = 0; i < duplication.size() - 1; i++)
		{
			System.out.println("hi");
			if (duplication.get(i) == duplication.get(i + 1))
			{
				duplication.remove(i);
				duplication.remove(i);
				i--;
			}

			if (i + 1 == duplication.size() - 1)
			{
				if (!duplicaionCheck(duplication))
					i = -1;
			}
		}
		return duplication;
	}

	public static boolean duplicaionCheck(List<Character> list)
	{
		for (int i = 0; i < list.size() - 1; i++)
		{
			if (list.get(i) == list.get(i + 1))
				return false;
		}
		return true;
	}
	public static String listToString(List<Character> list)
	{
		String str = "";

		for (int i = 0; i < list.size(); i++)
			str += list.get(i);
		return str;
	}
}
