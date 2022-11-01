package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	 
    	
    	// 친구리스트 관련
    	Map<String, Set<String>> f = new HashMap<>();
    	
    	
    	for(int i=0; i<friends.size(); i++) {
    		// 친구리스트에서 이름들을 하나씩 꺼낸다.
    		List<String> friend = friends.get(i);
    		// 왼쪽꺼
    		String f_left = friend.get(0);
    		// 오른쪽꺼
    		String f_right = friend.get(1);
    		
    		// 왼쪽꺼용 하나 만든다음에 만약 왼쪽이 안들어가있으면 새로 하나 공간을 만든다.
    		// 왼쪽이의 친구 오른쪽 정보를 넣는다.
    		Set<String> f_left_set = f.getOrDefault(f_left, new HashSet<>());
    		f_left_set.add(f_right);
    		f.put(f_right, f_left_set);
    		
    		// 왼쪽이랑 똑같이 반복해준다.
    		Set<String> f_right_set = f.getOrDefault(f_right, new HashSet<>());
    		f_right_set.add(f_left);
    		f.put(f_left, f_right_set);
    		
    	}
    	
    	

        return null;
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
