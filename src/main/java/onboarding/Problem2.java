package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	static final int first = 0;
	static final int last = 1;

    public static String solution(String cryptogram) {
        String answer = "answer";

		checkException(cryptogram);

		List<Character> cryptogram_list = toList(cryptogram);

		//연속해서 중복되는 문자가 없을 때 까지
		while (true) {
			boolean isVisited = false;
			//연속해서 중복되는 범위를 구함
			List<Integer> range = findDuplicationRange(cryptogram_list);

			removeWord(range, cryptogram_list);

			for(int i = 0; i < range.size(); i++){
				if (range.get(i) == 0)
					isVisited = true;
				if (range.get(i) != 0)
				{
					isVisited = false;
					break;
				}
			}

			if (isVisited == true || range.size() == 0)
				break;
			//문자의 중복되는 범위를 제거
			//remove(cryptogram_list, range[first], range[last]);

			//연속해서 중복되는 문자가 없을 경우 종료
			//if (range[last] == 0)
			//	break;
		}
		answer = toString(cryptogram_list);

        return answer;
    }
	//String을 List로 변환
	public static List<Character> toList(String cryptogram) {
		List<Character> cryptogram_list = new ArrayList<>();

		for (int i = 0; i < cryptogram.length(); i++)
			cryptogram_list.add(cryptogram.charAt(i));

		return cryptogram_list;
	}
	//list를 String으로 변환
	public static String toString(List<Character> cryptogram_list) {
		String str = "";

		for (int i = 0; i < cryptogram_list.size(); i++)
			str += cryptogram_list.get(i);
		return str;
	}
	//중복 제거 함수
	public static List<Character> remove(List<Character> cryptogram_list, int first, int last) {
		int index = first;

		for (int i = index; i < last; i++)
			cryptogram_list.remove(first);

		return cryptogram_list;
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
	public static boolean checkUpperCase(String cryptogram) {
		for (int i = 0; i < cryptogram.length(); i++)
			if (Character.isUpperCase(cryptogram.charAt(i)))
				return true;

		return false;
	}
	public static boolean checkException(String cryptogram){
		if (cryptogram.length() < 1 || cryptogram.length() > 1000)
			throw new IllegalArgumentException("ERROR");
		//대문자가 있는지
		if (checkUpperCase(cryptogram))
			throw new IllegalArgumentException("ERROR");
		return true;
	}
}
