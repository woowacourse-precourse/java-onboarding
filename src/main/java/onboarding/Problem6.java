package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// 닉네임: 두 글자 이상의 문자가 연속적으로 같으면 중복
// 이메일의 길이는 11~19 신청가는 이메일은 email.com 으로 제한
// 닉네임은 한글, 1~19자
// 최종 결과는 오름차순으로 정렬하고 중복은 제거해서 제출

// 중복되는 닉네임을 가진 이메일을 결과에 담자

//1. 2글자만 같아도 중복으로 간주하니까 2글자씩으로 모든 경우를 구하기
//2. map에 키값을 2글자들의 모든 경우들로 하고 value는 해당 하는 2글자를 가진 이메일로 매핑.
//3. 최종적으로 map을 반복하며 value가 2개 이상인 모든 닉네임에 대해 value 값을 set에 저장
//4. set를 리스트로 변환후 정렬해보자.



public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, List<String>> all_pos = new HashMap<String, List<String>>();
        HashSet<String> filter = new HashSet<>(); // 중복 제거용 집합
        
        for (List <String> data: forms) {
        	String email = data.get(0);
        	String name = data.get(1);
        	for (int i=0; i<name.length() - 1;i++) {
        		String temp = String.valueOf(name.charAt(i)) + String.valueOf(name.charAt(i + 1));
        		if (!all_pos.containsKey(temp)) { // 두글자가 이미 키로 저장되어 있지 않으면 새로운 빈리스트 생성
        			all_pos.put(temp, new ArrayList<String>()); // 두글자-빈리스트 매핑        			
        		}
        		all_pos.get(temp).add(email); // 빈리스트에 이메일 추가
        	}
        }
        
        for(String key: all_pos.keySet()) { // 중복되는 닉네임을 가진 이메일들을 집합에 넣어줌
        	List<String> email_list = all_pos.get(key);
        	if (email_list.size() > 1) { 
        		filter.addAll(all_pos.get(key));
        	}
        }
        ArrayList<String> answer = new ArrayList<>(filter);
        Collections.sort(answer);
        return answer;
    }
}
