package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	static final int start = 0;
	static final int finish = 1;

    public static String solution(String cryptogram) {
        String answer = "answer";

		exceptionCheck(cryptogram);

		List<Character> word = createList(cryptogram);

		//연속해서 중복되는 문자가 없을 때 까지
		while (true)
		{
			//연속해서 중복되는 범위를 구함
			int [] range = findDuplication(word);
			//문자의 중복되는 범위를 제거
			remove(word, range[start], range[finish]);

			//연속해서 중복되는 문자가 없을 경우 종료
			if (range[1] == 0)
				break;
		}
		answer = listToString(word);

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

	//중복되는 문자의 범위를 찾는 함수
	public static int[] findDuplication(List<Character> wordlist) {
		boolean isVisited = false;
		int[ ] range = new int[2];
		int last = 0;

		for (int i = 0; i < wordlist.size(); i++) {
			//연속해서 중복이 된 문자의 범위를 저장함
			if (isVisited) {
				range[0] = i - 1;
				range[1] = last + 1;
				return range;
			}
			for (int j = i + 1; j < wordlist.size(); j++) {
				//연속해서 중복되지 않았을 때
				if (wordlist.get(i) != wordlist.get(j))
					break;
				//연속해서 중복되었을 때
				if (wordlist.get(i) == wordlist.get(j)) {
					last = j;		//인덱스를 저장
					isVisited = true;
				}
			}
		}
		return range;
	}

	public static boolean isUpperCase(String word)
	{
		for (int i = 0; i < word.length(); i++)
		{
			if (Character.isUpperCase(word.charAt(i)))
				return true;
		}
		return false;
	}
	public static boolean exceptionCheck(String word){
		if (word.length() < 1 || word.length() > 1000)
			throw new IllegalArgumentException("ERROR");
		//대문자가 있는지
		if (isUpperCase(word))
			throw new IllegalArgumentException("ERROR");
		return true;
	}
}
