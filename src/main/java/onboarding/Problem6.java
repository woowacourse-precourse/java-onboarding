package onboarding;

import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
// import java.util.Collections;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {

		// ㅜ 이것도 불변 객체인 듯...
		List<String> answer = List.of("answer");

		List<String> result = new ArrayList<String>();

		for (List<String> form : forms) {

			boolean isDuplicate = false;

			String nickname = form.get(1);

			List<List<String>> excludingForm = new ArrayList<List<String>>();

			// ㅜ 얕은 복사
			// excludingForm = forms;

			// ㅜ 깊은 복사
			for (int i = 0; i < forms.size(); i++) {

				List<String> list = forms.get(i);
				if (list == form)
					continue;

				excludingForm.add(forms.get(i));
			}

			// ㅜ 해당 닉네임을 2글자씩 떼서 리스트에 포함되어 있는 지 확인
			for (int i = 0; i < nickname.length() - 1; i++) {

				String twoLetters = nickname.substring(i, i + 2);

				boolean _isDuplicate = checkForDuplicates(twoLetters, excludingForm);
				if (_isDuplicate) {

					isDuplicate = true;
					break;
				}
			}

			if (isDuplicate) {

				result.add(form.get(0));
			}
		}

		// ㅜ 리스트 오름차순 정렬
		// Collections.sort(result);

		// ㅜ 중복 제거 + 오름차순 정렬
		TreeSet<String> treeSet = new TreeSet<String>(result);
		result = new ArrayList<String>(treeSet);
		answer = result;
		return answer;
	}

	///////////////////////////////////////////////
	// ㅜ 타겟 문자열이 리스트에 포함되어 있는 지를 확인하는 함수
	public static boolean checkForDuplicates(String target, List<List<String>> forms) {

		for (List<String> list : forms) {

			String nickname = list.get(1);

			boolean isDuplecate = nickname.contains(target);
			if (isDuplecate) {

				return true;
			}
		}

		return false;
	}

//	public static void main(String[] args) {
//
//		List<List<String>> forms = new ArrayList<List<String>>();
//
//		String[] formArr = { "jm@email.com", "제이엠", "jason@email.com", "제이슨", "woniee@email.com", "워니", "mj@email.com",
//				"엠제이", "nowm@email.com", "이제엠" };
//
//		for (int i = 0; i < formArr.length / 2; i++) {
//
//			List<String> form = new ArrayList<String>();
//
//			form.add(formArr[i * 2]);
//			form.add(formArr[i * 2 + 1]);
//
//			forms.add(form);
//		}
//
//		System.out.println(solution(forms));
//	}

}
