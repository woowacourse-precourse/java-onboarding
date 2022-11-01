package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	
        List<String> already_friend = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<String, Integer>();
        
        // user 친구 확인
        for(int i = 0; i < friends.size(); i++) {
        	
        	if(friends.get(i).contains(user)) { 
        		int which_frd = 2 - (friends.get(i).indexOf(user)+1); // user 친구의 인덱스 위치
        		already_friend.add(friends.get(i).get(which_frd));
        	}
        } // user 친구 확인 작업 완료
        //System.out.println(already_friend);
        
        // user와 함께아는 친구 확인
        for(int i = 0; i < friends.size(); i++) {
        	for(int j = 0; j < already_friend.size(); j++) {
        		if(friends.get(i).contains(already_friend.get(j)) && !friends.get(i).contains(user)) {
        			
        			int which_frd = 2 - (friends.get(i).indexOf(already_friend.get(j))+1);  // user와  함께아는 친구 위치
        			
        			if(!already_friend.contains(friends.get(i).get(which_frd))){ // 만약 user와 이미 아는 친구가 아니라면
        				String frd_frd = friends.get(i).get(which_frd);
        				if(!score.containsKey(frd_frd)) {
        					score.put(frd_frd, 10);
        				}
        				else {
        					score.put(frd_frd, score.get(frd_frd) + 10);
        				}
        			}
        			
        		}
        	}
        }
        
        // 방문자 점수 추가
        for(int i = 0; i < visitors.size(); i++) {
        	if(!score.containsKey(visitors.get(i))) {
        		if(!already_friend.contains(visitors.get(i))) {
        			score.put(visitors.get(i), 1);
        		}
        	}
        	else { score.put(visitors.get(i), score.get(visitors.get(i)) + 1); }
        }
        List<String> answer = new ArrayList<>(score.keySet());
        return answer;
    }
}
