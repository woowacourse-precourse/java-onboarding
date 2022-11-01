package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	List<String> answer = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		// 중복된 글자 카운트
		for (List<String> list : forms) {
			String id = list.get(1);
			for (int i = 0; i < id.length() - 1; i++) {
				String letter = id.substring(i, i + 2);
				map.put(letter, map.getOrDefault(letter, 0) + 1); 
			}
		}
		// 중복된 글자가 있는 닉네임에 해당하는 이메일을 배열 리스트에 넣기
		for (List<String> list : forms) {
			String email = list.get(0), id = list.get(1);
			for (int i = 0; i < id.length() - 1; i++) {
				String letter = id.substring(i, i + 2);
				if (map.get(letter) >= 2 && !answer.contains(email)) {
					answer.add(email);
					break;
				}
			}
		}
		Collections.sort(answer);
        return answer;
    }
}
