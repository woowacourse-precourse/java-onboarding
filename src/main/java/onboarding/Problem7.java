package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	
        List<String> already_friend = new ArrayList<>();
        HashMap<String, Integer> score = new HashMap<String, Integer>();
        
        // user ģ�� Ȯ��
        for(int i = 0; i < friends.size(); i++) {
        	
        	if(friends.get(i).contains(user)) { 
        		int which_frd = 2 - (friends.get(i).indexOf(user)+1); // user ģ���� �ε��� ��ġ
        		already_friend.add(friends.get(i).get(which_frd));
        	}
        } // user ģ�� Ȯ�� �۾� �Ϸ�
        //System.out.println(already_friend);
        
        // user�� �Բ��ƴ� ģ�� Ȯ��
        for(int i = 0; i < friends.size(); i++) {
        	for(int j = 0; j < already_friend.size(); j++) {
        		if(friends.get(i).contains(already_friend.get(j)) && !friends.get(i).contains(user)) {
        			
        			int which_frd = 2 - (friends.get(i).indexOf(already_friend.get(j))+1);  // user��  �Բ��ƴ� ģ�� ��ġ
        			
        			if(!already_friend.contains(friends.get(i).get(which_frd))){ // ���� user�� �̹� �ƴ� ģ���� �ƴ϶��
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
        
        // �湮�� ���� �߰�
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
