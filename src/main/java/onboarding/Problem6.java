package onboarding;

import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * 기능 목록 1) putHash 2) putName 3) overLapCheck 4) check 5) makeAnswer
 * 
 * @version java11 2022년 10월 31일
 * @author 이규호(tlqkrus012345)
 *
 */
public class Problem6 {

	static HashMap<String, String> formsMap = new HashMap<>();
	static HashSet<String> setName = new HashSet<>();
	static HashSet<String> setEmail = new HashSet<>();
	static String[] name;

	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();
		name = new String[forms.size()];

		putHash(forms);
		putName(forms);
		overLapCheck();
		return answer;
	}

	/**
	 * HashMap에 key값 이메일 value값 닉네임을 집어넣는 기능이다
	 * 
	 * @param forms
	 */
	public static void putHash(List<List<String>> forms) {
		for (List<String> list : forms) {
			formsMap.put(list.get(0), list.get(1));

		}
	}

	/**
	 * String배열에 닉네임을 집어넣는 기능이다
	 * 
	 * @param forms
	 */
	public static void putName(List<List<String>> forms) {
		int i = 0;
		for (List<String> list : forms) {
			name[i] = list.get(1);
		}
	}

	/**
	 * 닉네임이 저장되어 있는 name배열의 크기만큼 반복을 한다 
	 * name배열의 i번째 인덱스에서 연속된 두 문자를 checkId에 넣는다 ex) name[0] = 제이엠 checkId = 제이 checkId = 이엠 순으로 들어간다 
	 * name의 배열 크기만큼 확인하는 기능이다
	 */
	public static void overLapCheck() {
		for (int i = 0; i < name.length; i++) {

			for (int j = 0; j < name[i].length() - 1; j++) {
				String checkId = name[i].substring(j, j + 2);

				for (int k = i + 1; k < name.length; k++) {
					check(checkId, i, k);
				}
			}
		}
	}

	/**
	 * 
	 * @param id
	 * @param inow
	 * @param know
	 */
	public static void check(String id, int inow, int know) {

	}

	/**
	 * 
	 */
	public static void makeAnser() {

	}
}
