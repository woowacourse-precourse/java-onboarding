package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	static final int first = 0;
	static final int last = 1;

    public static String solution(String cryptogram) {
        String answer;
		List<Character> cryptogram_list;

		checkException(cryptogram);

		cryptogram_list = convertToList(cryptogram);

		while (true) {
			removeWord(findDuplicationRange(cryptogram_list), cryptogram_list);
			//연속해서 중복되는 문자가 없을 때 까지
			if (findDuplicationWord(findDuplicationRange(cryptogram_list)))
				break;
		}

		answer = convertToString(cryptogram_list);

        return answer;
    }
	public static List<Character> convertToList(String cryptogram) {
		List<Character> cryptogram_list = new ArrayList<>();

		for (int i = 0; i < cryptogram.length(); i++)
			cryptogram_list.add(cryptogram.charAt(i));

		return cryptogram_list;
	}
	public static String convertToString(List<Character> cryptogram_list) {
		String cryptogram = "";

		for (int i = 0; i < cryptogram_list.size(); i++)
			cryptogram += cryptogram_list.get(i);

		return cryptogram;
	}

	//중복 제거 후 중복이 있는지 찾는 함수
	public static boolean findDuplicationWord(List<Integer> range) {
		for (int i = 0; i < range.size(); i++)
		{
			if (range.get(i) != 0)
				return false;
		}
		return true;
	}
	//중복되는 문자의 범위를 찾는 함수
	public static List<Integer> findDuplicationRange(List<Character> cryptogram_list) {
		int cnt;
		boolean isVisited = false;
		List<Integer> duplicationRange_list = new ArrayList<>();

		for (int i = 0; i < cryptogram_list.size() - 1; i++) {
			cnt = 0;
			isVisited = false;
			for (int j = i + 1; j < cryptogram_list.size(); j++) {
				if (cryptogram_list.get(i) == cryptogram_list.get(j)) {
					cnt++;
					isVisited = true;
				}
				if (cryptogram_list.get(i) != cryptogram_list.get(j))
					break;
			}
			if (isVisited)
			{
				i += cnt;
				cnt++;
			}
			duplicationRange_list.add(cnt);
		}


		return duplicationRange_list;
	}
	public static List<Character> removeWord(List<Integer> range, List<Character> cryptogram_list) {
		boolean isVisited = false;

		for (int i = 0; i < range.size(); i++) {

			if (range.get(i) == 0)
				continue;

			for (int j = 0; j < range.get(i); j++) {
				isVisited = true;
				cryptogram_list.remove(i);
			}
			range.remove(i);

			if (isVisited)
				i--;
		}

		return cryptogram_list;
	}
	//대문자 있는지 확인
	public static boolean checkLowerCase(String cryptogram) {
		for (int i = 0; i < cryptogram.length(); i++) {
			if (!Character.isLowerCase(cryptogram.charAt(i)))
				return false;
		}

		return true;
	}
	public static boolean checkException(String cryptogram){
		if (cryptogram.length() < 1 || cryptogram.length() > 1000)
			throw new IllegalArgumentException("ERROR");
		if (!checkLowerCase(cryptogram))
			throw new IllegalArgumentException("ERROR");
		return true;
	}
}
