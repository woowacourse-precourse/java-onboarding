package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;


public class Problem7 {
   
	// 유저의 친구 리스트만 따로 빼놓기
	static List<String> userFriendList;
	static Set<String> userFriendSet;
	
	// 친구 추천 가능성 있는 사람들 목록
	static HashMap<String,Friend> fhm;
	
	// 마지막 우선순위에따라 5명 뽑기위한 PQ
	static PriorityQueue<Friend> pq;
	
	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
       
        userFriendList = new ArrayList<>();
        userFriendSet = new HashSet<>();
        
        fhm = new HashMap<>();
        
        for(int i = 0, size = friends.size(); i < size; i++) {
        	String left = friends.get(i).get(0);
        	String right = friends.get(i).get(1);
        	
        	// 친구관계중 하나가 user면 반대편만 userFrinedList에 넣고
        	if(left.equals(user)) {
        		userFriendList.add(right);
        		userFriendSet.add(right);
        	} else if(right.equals(user)) {
        		userFriendList.add(left);
        		userFriendSet.add(left);
        	} else {
        	// 아니면 둘의 친구관계를 설정해 줌
        		friendRegist(left, right);
        		friendRegist(right, left);        		
        	}
        	
        }
       
        // 방문자들 +1점씩
        visitorScorePlus(visitors);
        
        pq = new PriorityQueue<>();
        
        Iterator<HashMap.Entry<String, Friend>> it = fhm.entrySet().iterator();
        while(it.hasNext()) {
        	HashMap.Entry<String, Friend> entry = it.next();
        	Friend curFriend = entry.getValue();
        	
        	// 사용자와 함께 아는 친구의 수 당 +10점
        	knowEachOther(curFriend);
        	
        	// 점수 분배 끝냈으니까 pq에 넣기
        	// 0점은 넣을 필요 없음
        	if(curFriend.recommendScore!=0 && !userFriendSet.contains(curFriend.name)) {
        		pq.add(curFriend);
        	}
        }
        
        String[] answerarr;
        if(pq.size()>=5) {
        	answerarr = new String[5];
        } else {
        	answerarr = new String[pq.size()];
        }
        int idx = 0;
        while(answer.size()<5 && pq.size()>0) {
        	Friend cur = pq.poll();
        	answerarr[idx++] = cur.name;
        }
        
        answer = List.of(answerarr);
        
        return answer;
    }
    
    static class Friend implements Comparable<Friend>{
    	String name;
    	// 찾을때 빨리 찾으려고 Set 씀
    	Set<String> friendSet;
    	int recommendScore = 0;
    	
    	public Friend(String name) {
			this.name = name;
			this.friendSet = new HashSet<>();
		}

		void addFriend(String fname) {
    		this.friendSet.add(fname);
    	}

		@Override
		public int compareTo(Friend o) {
			if(this.recommendScore==o.recommendScore) {
				return this.name.compareTo(o.name);
			}
			
			// 추천 점수 내림차순
			return o.recommendScore-this.recommendScore;
		}
    	
    }
    
    static void friendRegist(String left, String right) {
    	
    	if(fhm.containsKey(left)) {
    		fhm.get(left).friendSet.add(right);
    	} else {
    		fhm.put(left, new Friend(left));
    		fhm.get(left).friendSet.add(right);
    	}
    	
    }
    
    static void visitorScorePlus(List<String> visitors) {
    	 for(int i = 0, size = visitors.size(); i < size; i++) {
         	String visitor = visitors.get(i);
         	// 타임라인 방문하면 +1점
         	if(fhm.containsKey(visitor)) {
         		fhm.get(visitor).recommendScore++;         		
         	} else {
         		fhm.put(visitor, new Friend(visitor));
         		fhm.get(visitor).recommendScore++;         		
         	}
         }
    }
    
    static void knowEachOther(Friend curfriend) {
    	for(int i = 0, len = userFriendList.size(); i < len; i++) {
    		if(curfriend.friendSet.contains(userFriendList.get(i))) {
    			curfriend.recommendScore += 10;
    		}
    	}
    }
    
}
