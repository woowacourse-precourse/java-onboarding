package onboarding;

import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

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
		makeAnswer();
		
		for(String email : setEmail) {
			answer.add(email);
		}
		
		Collections.sort(answer);
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
			i++;
		}
	}

	/**
	 * 닉네임이 저장되어 있는 name배열의 크기만큼 반복을 한다 name배열의 i번째 인덱스에서 연속된 두 문자를 checkId에 넣는다 ex)
	 * name[0] = 제이엠 checkId = 제이 checkId = 이엠 순으로 들어간다 name의 배열 크기만큼 확인하는 기능이다
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
	 * 중복된 문자열이 있는지 확인하고 있으면 setName에 집어넣는 기능이다
	 * 
	 * @param id
	 * @param inow overLapCheck의 현재의 i번째
	 * @param know overLapCheck의 현재의 k번째
	 */
	public static void check(String id, int inow, int know) {
		for (int i = 0; i < name[know].length() - 1; i++) {
			if (id.equals(name[know].substring(i, i + 2))) {
				setName.add(name[inow]);
				setName.add(name[know]);
			}
		}
	}

	/**
	 * setName에 저장한 닉네임(중복된 닉네임)과 formsMap과 비교하여 동일한 값이 있으면 해당 value값으로 key값인 이메일을 setEmail에 집어넣는 기능이다
	 */
	public static void makeAnswer() {
		for (Map.Entry<String, String> entry : formsMap.entrySet()) {

			for (String id : setName) {
				if (entry.getValue().equals(id)) {
					setEmail.add(entry.getKey());
				}
			}
		}
	}
}
