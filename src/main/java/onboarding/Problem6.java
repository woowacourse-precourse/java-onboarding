package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
// 1. Set을 이용하여 equals 재정의를 통하여 해결해봄
//    > Set은 중복인 인덱스 정보를 가져오기가 힘들었음
// 2. HashMap을 이용히여 분절과 해당 인덱스를 저장
//    > 해결
public class Problem6 {
	
	public static void make_and_Check_Token(String now_name , int indx , HashMap<String,Integer> map,HashSet<Integer> set) {
		for(int i =0; i<now_name.length()-1; i++) {
			String token = now_name.substring(i, i+2);
			if(map.containsKey(token)) {
				if(map.get(token)==indx)
					continue;
				set.add(map.get(token));
				set.add(indx);
				map.put(token, indx);
			}else {
				map.put(token, indx);
			}
		}
	}
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        
        int size  = forms.size();
        for(int i=0; i<size; i++) {
        	String now_name = forms.get(i).get(1);
        	make_and_Check_Token(now_name,i,map,set); // 닉네임을 2글자씩 쪼개서 set에 넣어줌
        }
        answer = new LinkedList<>();
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
        	 answer.add(forms.get(it.next()).get(0));
        }
        Collections.sort(answer);
        System.out.println(answer.toString());
        return answer;
    }
}
