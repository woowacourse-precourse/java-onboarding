package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	 
    	
    	// 친구리스트 관련
    	List<String> answer = new ArrayList<String>();
    	Map<String, Set<String>> f = new HashMap<>();
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	
    	for (List<String> fname : friends) {
    		// 친구리스트에서 이름들을 하나씩 꺼낸다.
    		// 왼쪽꺼
    		String f_left = fname.get(0);
    		// 오른쪽꺼
    		String f_right = fname.get(1);
    		
    		// 왼쪽꺼용 하나 만든다음에 만약 왼쪽이 안들어가있으면 새로 하나 공간을 만든다.
    		// 왼쪽이의 친구 오른쪽 정보를 넣는다.
    		Set<String> f_left_set = f.getOrDefault(f_left, new HashSet<>());
    		f_left_set.add(f_right);
    		f.put(f_left, f_left_set);
    		
    		// 왼쪽이랑 똑같이 반복해준다.
    		Set<String> f_right_set = f.getOrDefault(f_right, new HashSet<>());
    		f_right_set.add(f_left);
    		f.put(f_right, f_right_set);
    	}
    	
    	
    	Set<String> user_f = f.get(user);
    	Map<Integer, List<String>> result = new TreeMap<>(Comparator.reverseOrder());
    	
    	
    	for (String fm : f.keySet()) {
    		if (fm.equals(user) || user_f.contains(fm)) {
    			continue;
    		}
    		Set<String> f2 = f.get(fm);
    		
    		for (String fm2 : user_f) {
    			if (f2.contains(fm2)) {
    				// 10점을 더한다.
    				int putNum = map.getOrDefault(fm,  0) + 10;
    				map.put(fm, putNum);
    			}
    		}
    	}
    	
    	// 방문자관련
    	for (String v : visitors) {
    		if (f.get(user).contains(v)) {
    			continue;
    		}
    		// 1점을 더한다.
    		map.put(v, map.getOrDefault(v, 0) + 1);
    	}
    	
    	
    	
    	for (String k : map.keySet()) {
    		List<String> r = result.getOrDefault(map.get(k), new ArrayList<>());
    		
    		r.add(k);
    		result.put(map.get(k), new ArrayList<>(r));
    	}
    	
    	
    	
    	// 점수가 같으면 이름순 정렬
    	for (int i : result.keySet()) {
    		List<String> r = result.get(i);
    		
    		Collections.sort(r);
    		
    		answer.addAll(r);
    	}

    	

        return answer;
    }
    
//    public static void main(String[] args) {
//    	 
//             String user = "mrko";
//             List<List<String>> friends = List.of(
//                     List.of("donut", "andole"),
//                     List.of("donut", "jun"),
//                     List.of("donut", "mrko"),
//                     List.of("shakevan", "andole"),
//                     List.of("shakevan", "jun"),
//                     List.of("shakevan", "mrko")
//             );
//             List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//             System.out.println(solution(user, friends, visitors));
//	}
}
