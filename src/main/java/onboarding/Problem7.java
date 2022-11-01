package onboarding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem7 {
	 public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
	        List<String> answer = new ArrayList<>();
	        
	        
	        /*
	         * 사용자의 친구의 친구 +10점
	         * 사용자의 타임라인에 방문한 횟수 +1점
	         * 추천 점수가 0점인 경우 제외 상위 최대 5명(점수가 같으면 이름순)
	         * 
	         * */	        
	        //현재 친구를 삭제하기 위한 복사 friendslist
	        List<List<String>> copyFriendsList = new ArrayList<List<String>>(friends);
	        
	        /*사용자랑 친구인 nowfriend 찾고 copyFriendslist에서 삭제*/
	        List<String> nowFriendsList = new ArrayList<String>();
	        int length=copyFriendsList.size();
	        
	        for(int i=0; i<length; i++) {
	        	//양쪽에 있는 이름을 각각 저장
	        	String leftName = copyFriendsList.get(i).get(0);
	        	String rightName = copyFriendsList.get(i).get(1);
	        	//사용자와 친구인 경우 
	        	if(leftName == user) {
	        		//nowfriendslist에 추가
	        		nowFriendsList.add(rightName);
	        		//친구 리스트에서 삭제
	        		copyFriendsList.remove(i);
	        		length--;
	        		i--;
	        	}
	        	else if(rightName == user) {
	        		nowFriendsList.add(leftName);
	        		copyFriendsList.remove(i);
	        		length--;
	        		i--;
	        	}
	        }
	        /*Friends에서 nowfriend랑 친구인 사람  +10점씩*/
	        HashMap<String, Integer> friendRecommendScore = new HashMap<String, Integer>(); 
	        for(int i=0; i<copyFriendsList.size(); i++) {
	        	//양쪽에 있는 이름을 각각 저장
	        	String leftName = copyFriendsList.get(i).get(0);
	        	String rightName = copyFriendsList.get(i).get(1);
	        	//사용자 친구의 친구인 경우
	        	if(nowFriendsList.contains(leftName)) {
	        		//hashmap에 저장되어 있으면 +10점
	        		if(friendRecommendScore.containsKey(rightName)) {
	        			friendRecommendScore.put(rightName, friendRecommendScore.get(rightName)+10);
	        		//없으면 새로 추가 후 10점
	        		}else {
	        			friendRecommendScore.put(rightName, 10);
					}
	        	}
	        	else if(nowFriendsList.contains(rightName)) {
	        		if(friendRecommendScore.containsKey(leftName)) {
	        			friendRecommendScore.put(leftName, friendRecommendScore.get(leftName)+10);
	        		}else {
	        			friendRecommendScore.put(leftName, 10);
					}
	        	}	        		
	        }
	        
	        /*방문자중에서 nowfriend아닌 사람 +1점씩*/
	        for(int i=0; i<visitors.size(); i++) {
	        	//사용자와 친구가 아닌 타임라인 방문자
	        	if(nowFriendsList.contains(visitors.get(i)) == false) {
	        		
	        		if(friendRecommendScore.containsKey(visitors.get(i))) {
	        			friendRecommendScore.put(visitors.get(i), friendRecommendScore.get(visitors.get(i))+1);
	        		}
	        		else {
	        			friendRecommendScore.put(visitors.get(i), 1);
					}
	        		
	        	}
	        }
	        
	        /* 점수가 가장 높은 순으로 정렬(내림차순)
	         * 추천 점수가 같을 경우 이름순
	         * 
	         * compare 
	         * A > B일 때 
	         * return 0 => 동일한 경우
	         * return 1 => 좌측 값이 큰 경우
	         * return -1 => 좌측 값이 작은 경우
	         * https://lookingfor.tistory.com/entry/자바-문자열-비교-함수-compare-compareTo
	         * 
	         * map 정렬 
	         * https://cornswrold.tistory.com/114
	         */
	        List<Map.Entry<String, Integer>> list = new LinkedList<>(friendRecommendScore.entrySet());
	        
	        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	        	@Override
	        	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
	        		//값을 비교하여 -1을 곱해 내림차순 정렬
	        		int comparision = (o1.getValue() - o2.getValue()) * -1;
	        		//값이 같을 경우(0) 이름(key)값의 오름차순 정렬
	        		return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
	        	}
		       
			});
	        //순서 유지를 위한 LinkedHashMap
	        HashMap<String, Integer> sortedFriendRecommendScore = new LinkedHashMap<String, Integer>();
	        for(Iterator<Map.Entry<String, Integer>> iterator = list.iterator(); iterator.hasNext();) {
	        	Map.Entry<String, Integer> entry = iterator.next();
	        	sortedFriendRecommendScore.put(entry.getKey(), entry.getValue());
	        }
	        
	        /*점수 최대 5명 커트*/
	        int count =0;
	        
	        Iterator<String> keys = sortedFriendRecommendScore.keySet().iterator();
	        while(keys.hasNext()) {
	        	if(count > 4) {
	        		break;
	        	}
	        	answer.add(keys.next());
	        	count++;
	        }
	        
	        return answer;
	 }

}
