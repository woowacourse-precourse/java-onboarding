package onboarding;

import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList(); 		
		answer=new ArrayList<>();
		String[] arrUserFriends = new String[friends.size()];
		Map<String,Integer> friendsMap = new HashMap<>();		
		int arrLength=0;
		// 유저와 친구인 사람 찾기
		for(int i=0; i<friends.size(); i++) { 
			if(friends.get(i).get(1).equals(user)) {        		
				arrUserFriends[arrLength]=friends.get(i).get(0); // 친구 넣기        		
				System.out.println("유저와 친구: "+friends.get(i).get(0));
				System.out.println(arrLength+"번째 배열 대입: "+arrUserFriends[arrLength]);
				arrLength++;
			}            	
		}		
		// 유저와 아는사람의 친구 점수추가
		for(int i=0; i<friends.size(); i++) { 
			for(int j=0; j<arrUserFriends.length; j++) {
				if(friends.get(i).get(0).equals(arrUserFriends[j])
						&&!friends.get(i).get(1).equals(user)) {
					System.out.println("+10점 이름:"+friends.get(i).get(1));
					friendsMap.put(friends.get(i).get(1), friendsMap.getOrDefault(friends.get(i).get(1), 0)+10);
				}
			}
		}
		//visitors 점수추가
		for(int i=0; i<visitors.size(); i++) { 	
			for(int j=0; j<arrUserFriends.length; j++) {
				if(visitors.get(i).equals(arrUserFriends[j])) {
					break;
				}
				if(j==arrUserFriends.length-1) {
					System.out.println("+1점 이름:"+visitors.get(i));
					friendsMap.put(visitors.get(i), friendsMap.getOrDefault(visitors.get(i), 0)+1);
				}
			}
		}
		// 정렬을 위한 Map.Entry 리스트 작성
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(friendsMap.entrySet());		
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {		
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {		
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		System.out.println("내림 차순 정렬");
		// 결과 출력 		 
		for(Entry<String, Integer> entry : list_entries) {
			answer.add(entry.getKey());
		}        
        return answer;
    } 
}
