package onboarding;

import java.util.*;


public class Problem6 {

	/*
	 * 기능 구현 리스트 
	 * 1. 이메일 형식은 'email.com'로 제한 / 11자 이상 20자 미만 
	 * 2. 닉네임은 1자이상 20자 미만 / 두 글자 이상 문자가 반복 X 
	 * 3. 이메일형식으로 출력 / 오름차순   
	 */
	
	

	public static List<String> solution(List<List<String>> forms) {
		// 닉네임 단어 2str
		List<String> nickTwoword = new ArrayList<>();
		List<String> answer = new ArrayList<>();
		// 중복 체크 위해 단어 2개씩 추가 
		for (List<String> form : forms) {
			String nickName = form.get(1);
			for (int i = 0; i <= nickName.length() - 2; i++) {
				nickTwoword.add(nickName.substring(i, i + 2));
			}
		}
		
		for (int j = 0; j < forms.size(); j++) {
			String nickName = forms.get(j).get(1);
			// 자신의 중복 단어 삭제  
			for (int i = 0; i <= nickName.length() - 2; i++) {
				nickTwoword.remove(nickName.substring(i, i + 2));
			}
			// 중복단어 있으면 정답에 넣기 
			// 그리고 다시 자신의 단어 넣기   
			for (int l = 0; l <= nickName.length() - 2; l++) {
				if (nickTwoword.contains(nickName.substring(l, l + 2))) {
					answer.add(forms.get(j).get(0));
					nickTwoword.add(nickName.substring(l, l + 2));
				} else {
					nickTwoword.add(nickName.substring(l, l + 2));
				}

			}

		}
		Collections.sort(answer);
		return answer;

	}
}
