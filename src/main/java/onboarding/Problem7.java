package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        
        List<Friend> candi_list = new ArrayList<>();
        Map<String,Set<String>> friend_relation = new HashMap<>();
        Map<String, Integer> users_score = new HashMap<>();
        
        for(List<String> friend : friends) {
        	String user1 = friend.get(0);
        	String user2 = friend.get(1);
        	
        	if(!friend_relation.containsKey(user1)) {
        		friend_relation.put(user1, new HashSet<>());
        	}
        	if(!friend_relation.containsKey(user2)) {
        		friend_relation.put(user2, new HashSet<>());
        	}
        	
        	Set<String> user1Friends = friend_relation.get(user1);
        	user1Friends.add(user2);
        	Set<String> user2Friends = friend_relation.get(user2);
        	user2Friends.add(user1);
        	
        	if(!users_score.containsKey(user1)) {
        		users_score.put(user1, 0);
        	}
        	if(!users_score.containsKey(user2)) {
        		users_score.put(user2, 0);
        	}
        }
        
        Set<String> user_friends = friend_relation.get(user);
        
        for(Entry<String,Set<String>> entry : friend_relation.entrySet()) {
        	String candi_user = entry.getKey();
        	
        	if(candi_user.equals(user)) {
        		continue;
        	}
        	
        	if(user_friends.contains(candi_user)) {
        		continue;
        	}
        	
        	Set<String> candi_friends = entry.getValue();
        	for(String user_friend : user_friends) {
        		for(String candi_friend : candi_friends) {
        			if(user_friend.equals(candi_friend)) {
        				users_score.put(candi_user, users_score.getOrDefault(candi_user, 0)+10);
        				break;
        			}
        		}
        	}
        }
        
        for(String visitor : visitors) {
        	if(!users_score.containsKey(visitor)) {
        		users_score.put(visitor, 0);
        	}
        	
        	users_score.put(visitor, users_score.get(visitor)+1);
        }
        
        for(Entry<String, Integer> entry : users_score.entrySet()) {
        	String name = entry.getKey();
        	int score = entry.getValue();
        	
        	if(name.equals(user)) {
        		continue;
        	}
        	
        	if(user_friends.contains(name)) {
        		continue;
        	}
        	
        	candi_list.add(new Friend(name, score));
        }
        
        candi_list.sort((a,b)->{
        	if(a.getScore()>b.getScore()) return -1;
        	else if(a.getScore()<b.getScore()) return 1;
        	else {
        		if(a.getName().compareTo(b.getName())>0) return 1;
        		else if(a.getName().compareTo(b.getName())<0) return -1;
        		else return 0;
        	}
        });
        
        List<String> answer = new ArrayList<>(5);
        for(int i=0;i<5;i++) {
        	if(i>=candi_list.size()) 
        		break;
        	
        	if(candi_list.get(i).getScore()==0) 
        		break;
        	
        	answer.add(candi_list.get(i).getName());
        }
        return answer;
    }
    
}

class Friend{
	private String name;
	private int score;
	
	public Friend(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
