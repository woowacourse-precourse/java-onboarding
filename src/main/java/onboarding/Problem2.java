package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	public enum Word{
		min(1),
		max(1000);

		private final int length;
		Word(int length) {
			this.length = length;
		}
	}

    public static String solution(String cryptogram) {
        String answer;
		List<Character> cryptogram_list;

		checkException(cryptogram);

		cryptogram_list =  convertToList(cryptogram);

		do {
			removeWord(findDuplicationRange(cryptogram_list), cryptogram_list);
			//연속해서 중복되는 문자가 없을 때 까지
		} while (!findDuplicationWord(findDuplicationRange(cryptogram_list)));

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
		StringBuilder cryptogram = new StringBuilder();

		for (Character character : cryptogram_list)
			cryptogram.append(character);

		return cryptogram.toString();
	}

	//중복 제거 후 중복이 있는지 찾는 함수
	public static boolean findDuplicationWord(List<Integer> range) {
		for (Integer integer : range) {
			if (integer != 0)
				return false;
		}
		return true;
	}
	//중복되는 문자의 범위를 찾는 함수
	public static List<Integer> findDuplicationRange(List<Character> cryptogram_list) {
		List<Integer> duplicationRange_list = new ArrayList<>();

		for (int i = 0; i < cryptogram_list.size() - 1; i++) {
			int cnt = 0;
			boolean isVisited = false;
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
	public static void removeWord(List<Integer> range, List<Character> cryptogram_list) {
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

	}
	//대문자 있는지 확인
	public static boolean checkLowerCase(String cryptogram) {
		for (int i = 0; i < cryptogram.length(); i++) {
			if (!Character.isLowerCase(cryptogram.charAt(i)))
				return false;
		}

		return true;
	}
	public static void checkException(String cryptogram){
		if (cryptogram.length() < Word.min.length || cryptogram.length() > Word.max.length)
			throw new IllegalArgumentException("ERROR");
		if (!checkLowerCase(cryptogram))
			throw new IllegalArgumentException("ERROR");
	}
}
