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
    	ArrayList<String> visitorsList = new ArrayList<>(visitors);
        String friendsOfUser=" ";
        ArrayList<String> friendsOfUserList = new ArrayList<>();
        Map<String, Integer> friendScore = new HashMap<>();
        
        for(int i=0; i<friends.size(); i++) {
        	if(friends.get(i).contains(user)&&friends.get(i).get(0)!=user) {
        		friendsOfUser=friends.get(i).get(0);
        		friendsOfUserList.add(friendsOfUser);
        		if(visitorsList.contains(friendsOfUser)) {//메서드화
        			visitorsList.remove(visitorsList.indexOf(friendsOfUser));
        		}
        	}
        	if(friends.get(i).contains(user)&&friends.get(i).get(0)==user) {
        		friendsOfUser=friends.get(i).get(1);
        		friendsOfUserList.add(friendsOfUser);
        		if(visitorsList.contains(friendsOfUser)) {//메서드화
        			visitorsList.remove(visitorsList.indexOf(friendsOfUser));
        		}
        	}	
        }
        //put으로 맵 초기화
        for(int i=0; i<friendsOfUserList.size();i++) {
        	for(int j=0; j<friends.size(); j++) {
	        	if(friends.get(j).contains(friendsOfUserList.get(i))
	        			&&friends.get(j).contains(user)==false
	        			&&friends.get(j).get(0)!=friendsOfUserList.get(i)) {
	        		friendScore.put(friends.get(j).get(0),0);
	        	}else if(friends.get(j).contains(friendsOfUserList.get(i))
	        			&&friends.get(j).contains(user)==false
	        			&&friends.get(j).get(0)==friendsOfUserList.get(i)) {
	        		friendScore.put(friends.get(j).get(1),0);
	        	}
        	}
        }
        
        //replace로 초기값 설정된 자료형에 대입
        for(int i=0; i<friendsOfUserList.size();i++) {
        	for(int j=0; j<friends.size(); j++) {
	        	if(friends.get(j).contains(friendsOfUserList.get(i))
	        			&&friends.get(j).contains(user)==false
	        			&&friends.get(j).get(0)!=friendsOfUserList.get(i)) {
	        		friendScore.replace(friends.get(j).get(0),
	        				(int)friendScore.get(friends.get(j).get(0))+10);
	        	}else if(friends.get(j).contains(friendsOfUserList.get(i))
	        			&&friends.get(j).contains(user)==false
	        			&&friends.get(j).get(0)==friendsOfUserList.get(i)) {
	        		friendScore.replace(friends.get(j).get(1), 
	        				(int)friendScore.get(friends.get(j).get(1))+10);
	        	}
        	}
        }
        
        Map<String, Integer> visitorScore = new HashMap<>();
        for(int i=0; i<visitorsList.size(); i++) {
        	visitorScore.put(visitorsList.get(i),
        			Collections.frequency(visitorsList, visitorsList.get(i)));
        }
        friendScore.forEach((key,value) 
        		-> visitorScore.merge(key, value, (v1, v2) -> v1+v2));
        
        //마지막 정렬 추천 점수 0점 추천 x 최대 5명까지 점수순(내림차순)-이름순(오름차순)
        List<Map.Entry<String, Integer>> sortingList 
        	= new LinkedList<>(visitorScore.entrySet());
        Collections.sort(sortingList, new Comparator<Map.Entry<String, Integer>>(){
        	@Override
        	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        		int comparision = (o1.getValue() - o2.getValue()) * -1;
        		return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        	}
        });
        
        Map<String, Integer> answermap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = sortingList.iterator(); iter.hasNext();) {
        	Map.Entry<String, Integer> entry = iter.next();
        	answermap.put(entry.getKey(), entry.getValue());
        }
        List<String> answer = new ArrayList<>(answermap.keySet()); 
        
        return answer;
        
    }
}

