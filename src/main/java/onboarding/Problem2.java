package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

		List<Character> testList = createList(cryptogram);


		while (true)
		{
			int [] testArray = findDuplication(testList);
			remove(testList, testArray[0], testArray[1]);

			if (testArray[1] == 0)
				break;
		}
		answer = listToString(testList);

        return answer;
    }

	//String을 List로 변환
	public static List<Character> createList(String word) {
		List<Character> wordList = new ArrayList<>();

		for (int i = 0; i < word.length(); i++)
			wordList.add(word.charAt(i));

		return wordList;
	}

	//list를 String으로 변환
	public static String listToString(List<Character> list) {
		String str = "";

		for (int i = 0; i < list.size(); i++)
			str += list.get(i);
		return str;
	}

	//중복 제거 함수
	public static List<Character> remove(List<Character> wordlist, int first, int last) {
		int index = first;

		for (int i = index; i < last; i++)
			wordlist.remove(first);

		return wordlist;
	}

	//중복되는 문자의 인덱스 찾는 함수
	public static int[] findDuplication(List<Character> wordlist) {
		boolean isVisited = false;
		int[ ] range = new int[2];
		int second = 0;

		for (int i = 0; i < wordlist.size(); i++) {

			if (isVisited) {
				range[0] = i - 1;
				range[1] = second + 1;
				return range;
			}
			for (int j = i + 1; j < wordlist.size(); j++) {
				if (wordlist.get(i) != wordlist.get(j))
					break;
				if (wordlist.get(i) == wordlist.get(j)) {
					second = j;
					isVisited = true;
				}
			}
		}
		return range;
	}
}
