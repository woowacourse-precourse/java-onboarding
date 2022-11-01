package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	int f_size = forms.size();
		List<String> answer = new ArrayList<>(Arrays.asList());
		
		List<String> mail = new ArrayList<>(Arrays.asList());  // 이메일만 리스트에 저장
		List<String> name = new ArrayList<>(Arrays.asList());  // 이름만 리스트에 저장
		
		for(int i = 0; i<f_size; i++) {
			List<String> email = forms.get(i);
			mail.add(email.get(0));
			name.add(email.get(1));
		}
		//System.out.println(mail);
		//System.out.println(name);
		
		for(int i = 0; i<f_size; i++) {
			String n = name.get(i);  // 이름 하나씩 n 변수에 저장
			for(int j = 0; j<n.length()-1; j++) {
				String overlap = n.substring(j, j+2); // 이름 두 글자씩 슬라이싱
				
				// 각 문자열 안에 overlap과 중복되는 문자열이 있는지 찾기
				for(int o = name.indexOf(n)+1; o < f_size; o++) {
					// 중복 문자열이 발견되면,,,
					if(name.get(o).contains(overlap)) {
						
						if(!answer.contains(mail.get(i))) { answer.add(mail.get(i)); }
						if(!answer.contains(mail.get(o))) { answer.add(mail.get(o)); }
					}
				}
			}
		}
		
		Collections.sort(answer);
		return answer;
    }
}
