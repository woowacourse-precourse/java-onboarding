package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    	ArrayList<String> crew1 = new ArrayList<String>();
		ArrayList<String> frifriends = new ArrayList<String>();
		ArrayList<Integer> crew2 = new ArrayList<Integer>();
		for (int i = 0; i < friends.size(); i++) {
			String member = friends.get(i).get(0);
			if(member.equals(user)) {
				if(crew1.contains(friends.get(i).get(1))) {
					continue;
				}else {
					frifriends.add(friends.get(i).get(1));
				}
			}
			member = friends.get(i).get(1);
			if(member.equals(user)) {
				if(crew1.contains(friends.get(i).get(0))) {
					continue;
				}else {
					frifriends.add(friends.get(i).get(0));
				}
			}
		}
		
		for (int i = 0; i < friends.size(); i++) {
			String member = friends.get(i).get(0);
			String fMember = friends.get(i).get(1);
			if(fMember.equals(user) || frifriends.contains(fMember)) {
				continue;
			}else if(frifriends.contains(member)) {
				if(crew1.contains(fMember)) {
					crew2.set(crew1.indexOf(fMember), crew2.get(crew1.indexOf(fMember))+10);
				}else {
					crew1.add(fMember);
					crew2.add(0);
				}
			}
			member = friends.get(i).get(1);
			fMember = friends.get(i).get(0);
			if(fMember.equals(user) || frifriends.contains(fMember)) {
				continue;
			}else if(frifriends.contains(member)) {
				if(crew1.contains(fMember)) {
					crew2.set(crew1.indexOf(fMember), crew2.get(crew1.indexOf(fMember))+10);
				}else {
					crew1.add(fMember);
					crew2.add(0);
				}
			}
		}
		
		for(String s : visitors) {
			if(s.equals(user) || frifriends.contains(s)) {
				continue;
			}else if(crew1.contains(s)) {
				crew2.set(crew1.indexOf(s), crew2.get(crew1.indexOf(s))+1);
			}else {
				crew1.add(s);
				crew2.add(1);
			}
		}
		
		
		List<String> answer = Collections.emptyList();
		if(crew1.size()>5) {
			for(int i =0; i<5; i++) {
				int max =0;
				for(int num : crew2) {
					if(num>max) {
						max=num;
					}
				}
				int crewIndex = crew2.indexOf(max);
				answer.add(crew1.get(crewIndex));
				crew2.set(crewIndex, -1);
				
			}
							
				
			return answer;
		}else{
			for(int i =0; i<crew1.size(); i++) {
				int max =0;
				for(int num : crew2) {
					if(num>max) {
						max=num;
					}
				}
				int crewIndex = crew2.indexOf(max);
				answer.add(crew1.get(crewIndex));
				crew2.set(crewIndex, -1);
				
			}
			return answer;
		}
		
    }
}
