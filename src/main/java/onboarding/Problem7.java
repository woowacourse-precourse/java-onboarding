package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	
    	List<String> prevFriends = new ArrayList<String>();
		List<String> name = new ArrayList<String>();
		List<Integer> score = new ArrayList<Integer>();
		
		for(int i = 0; i < friends.size(); i++) {
			if(friends.get(i).contains(user)) {
				for(int j = 0; j < friends.get(i).size(); j++) {
					if(friends.get(i).get(j) != user) {
						prevFriends.add(friends.get(i).get(j));
					}
				}
			}
		}
		
		for(int i = 0; i < prevFriends.size(); i++) {
			for(int j = 0; j < friends.size(); j++) {
				if(friends.get(j).contains(prevFriends.get(i))) {
					for(int k = 0; k < friends.get(j).size(); k++) {
						if(friends.get(j).get(k) != prevFriends.get(i) && friends.get(j).get(k) != user ) {
							if(name.contains(friends.get(j).get(k))) {
								score.set(name.indexOf(friends.get(j).get(k)),score.get(name.indexOf(friends.get(j).get(k)))+10);
							} else {
								name.add(friends.get(j).get(k));
								score.add(10);
							}
						}
					}
				}
			}
		}
		
		for(int i = 0; i < visitors.size(); i++) {
			if(!prevFriends.contains(visitors.get(i))) {
				if(name.contains(visitors.get(i))) {
					score.set(name.indexOf(visitors.get(i)),score.get(name.indexOf(visitors.get(i)))+1); 
			} else {
				name.add(visitors.get(i));
				score.add(1);
			}
		}
		}
		
		for(int i=0; i < name.size()-1; i++) {
			for(int j = i+1; j < name.size(); j++ ){
				if(name.get(i).compareTo(name.get(j)) > 0) {
					String tempName = name.get(i);
					name.set(i, name.get(j));
					name.set(j, tempName);
					
					int tempScore = score.get(i);
					score.set(i, score.get(j));
					score.set(j, tempScore);
					
				}
			}
		}
		
		for(int i=0; i < score.size()-1; i++) {
			for(int j = i+1; j < score.size(); j++ ){
				if(score.get(j) > score.get(i)) {
					String tempName = name.get(i);
					name.set(i, name.get(j));
					name.set(j, tempName);
					
					int tempScore = score.get(i);
					score.set(i, score.get(j));
					score.set(j, tempScore);
					
				}
			}
		}
		
        List<String> answer = Collections.emptyList();
        answer = name;
        return answer;

    }
}
