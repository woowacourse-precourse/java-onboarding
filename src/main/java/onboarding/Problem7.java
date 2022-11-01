package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem7 {
	public static void main(String[] args) {
		String user = "mrko";
		List<List<String>> friends = new ArrayList<List<String>>();
		
		List<String> a1 = new ArrayList<>();
		a1.add("donut");
		a1.add("andole");
		
		List<String> a2 = new ArrayList<>();
		a2.add("donut");
		a2.add("jun");
		
		List<String> a3 = new ArrayList<>();
		a3.add("donut");
		a3.add("mrko");
		
		List<String> a4 = new ArrayList<>();
		a4.add("shakevan");
		a4.add("andole");
		
		List<String> a5 = new ArrayList<>();
		a5.add("shakevan");
		a5.add("jun");
		
		List<String> a6 = new ArrayList<>();
		a6.add("shakevan");
		a6.add("mrko");
		
		friends.add(a1);
		friends.add(a2);
		friends.add(a3);
		friends.add(a4);
		friends.add(a5);
		friends.add(a6);
		
		List<String> visitors = new ArrayList<>();
		visitors.add("bedi");
		visitors.add("bedi");
		visitors.add("donut");
		visitors.add("bedi");
		visitors.add("shakevan");
		
		List<String> answer = solution(user,friends,visitors);
		
		System.out.print(answer);
	}
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        List<String> friend = new ArrayList<>();
        List<String> recommand = new ArrayList<>();
        List<List<Object>> point = new ArrayList<List<Object>>();
        
        int check = 0;
        
        for(int i = 0; i<friends.size(); i++) {
        	if(friends.get(i).get(0).equals(user)) {
        		friend.add(friends.get(i).get(1));
        	}
        	if(friends.get(i).get(1).equals(user)) {
        		friend.add(friends.get(i).get(0));
        	}
        }
        
        for(int i = 0; i<friends.size(); i++) {
        	for(int j = 0; j<friend.size(); j++) {
        		if(friends.get(i).get(0).equals(friend.get(j))&& !(friends.get(i).get(1).equals(user))) {
        			recommand.add(friends.get(i).get(1));
        		}
        	}
        }
        for(int i = 0; i<friend.size(); i++) {
        	for(int j = 0; j<recommand.size(); j++) {
        		if(friend.get(i).equals(recommand.get(j))) {
        			recommand.remove(friend.get(i));
        		}
        	}
        }
        for(int i = 0; i<recommand.size(); i++) {
        	List<Object> a = new ArrayList<>();
        	if(point.size() == 0) {
        		a.add(recommand.get(i));
        		a.add(10);
        		point.add(a);
        	}else {
        		for(int j = 0; j<point.size(); j++){
            		if(point.get(j).get(0).equals(recommand.get(i))) {
            			Object p = point.get(j).get(1);
            			point.get(j).set(1, (int)(p)+10);
            			check++;
            		}
            	}
        		if(check == 0) {
        			a.add(recommand.get(i));
        			a.add(10);
        			point.add(a);
        		}else {
        			check = 0;
        		}
        	}
        	
        }
        for(int i = 0; i<friend.size(); i++) {
        	for(int j = 0; j<visitors.size(); j++) {
        		if(friend.get(i).equals(visitors.get(j))) {
        			visitors.remove(friend.get(i));
        		}
        	}
        }
        for(int i = 0; i<visitors.size(); i++) {
        	List<Object> a = new ArrayList<>();
        	if(point.size()==0) {
        		a.add(visitors.get(i));
        		a.add(1);
        		point.add(a);
        	}else {
        		for(int j = 0; j<point.size(); j++) {
        			if(point.get(j).get(0).equals(visitors.get(i))) {
        				Object p = point.get(j).get(1);
        				point.get(j).set(1, (int)(p)+1);
        				check++;
        			}
        		}
        		if(check == 0) {
        			a.add(visitors.get(i));
        			a.add(10);
        			point.add(a);
        		}else {
        			check = 0;
        		}
        	}
        }
        int max = (int) point.get(0).get(1);
        int index = 0;
        int num = point.size();
        for(int i = 0; i<num; i++) {
        	for(int j = 0; j<point.size(); j++) {
        		if((int)point.get(j).get(1) > max) {
            		max = (int)point.get(j).get(1);
            		index = j;
            	}
        	}
        	if(answer.size()<=5) {
        		answer.add((String)point.get(index).get(0));
        		point.remove(index);
        		max = 0;
        		index = 0;   
        	}
        }
        return answer;
    }
}
