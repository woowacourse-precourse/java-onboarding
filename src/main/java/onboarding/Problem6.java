package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		List<String> answer = new ArrayList<>();

		// 이메일들을 모아놓을 set 과 중복체크를 위한 hashMap 설정
		HashSet<String> emails = new HashSet<>();
		HashMap<String, String> hashMap = new HashMap<>();



		return answer;
	}

//	public static void main(String[] args) {
//		List<List<String>> forms = new ArrayList<>();
//		forms.add(0, List.of(new String[] {"jm@email.com", "제이엠"}));
//		forms.add(1, List.of(new String[] {"jason@email.com", "제이슨"}));
//		forms.add(2, List.of(new String[] {"woniee@email.com", "워니"}));
//		forms.add(3, List.of(new String[] {"mj@email.com", "엠제이"}));
//		forms.add(4, List.of(new String[] {"nowm@email.com", "이제엠"}));
////		System.out.println(forms.get(1).get(1));
//		System.out.println(forms.size());
//
////		List<String> answer = new ArrayList<>();
////		for (List<String> form : forms) {
////			for (String s : form) {
////
////			}
////		}
//		String[] answer = new String[forms.size()];
//
//		HashSet<String> emails = new HashSet<>();
//		Map<String, String> hashMap = new HashMap<>();
//
//		for (int i = 0; i < forms.size(); i++) {
//			List<String> form = new ArrayList<>(forms.get(i));
////			System.out.println(form);
//			String s = form.get(1);
////			System.out.println(s);
//
//			for (int j = 0; j < s.length() - 1; j++) {
//				String key = s.substring(j, j + 2);
//				if (hashMap.containsKey(key)) {
//					String email = hashMap.get(key);
//					if (!email.equals(forms.get(i).get(0))) {
//						emails.add(email);
//						emails.add(forms.get(i).get(0));
//					}
//				}
//				hashMap.put(key, forms.get(i).get(0));
//			}
//		}
//
//		List<String> collect = emails.stream().sorted().collect(Collectors.toList());
//		answer = collect.toArray(new String[0]);
//
//		System.out.println(Arrays.toString(answer));
//	}
}
