package onboarding;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;


public class Problem7 {
	static HashSet<String> finalfriendlist = new HashSet();
	static HashMap<String,Integer> recommendscore = new HashMap<>();
	public static void main(String[] args) {
		String user_pattern = "^[a-z]{1,30}$";

		String user="";
		List<List<String>> friends = new ArrayList<List<String>>(10000);
		List<String> visitors = new ArrayList<String>(10000);

		boolean check = true;
		if(Pattern.matches(user_pattern,user)) {
			if(friends.size()>=1&&friends.size()<=10000) {
				for(int i=0;i<friends.size();i++) {
					HashSet friendset1 = new HashSet();
					friendset1.add(friends.get(i).get(0));
					friendset1.add(friends.get(i).get(1));

					if(!Pattern.matches(user_pattern,friends.get(i).get(0)) || 
						!Pattern.matches(user_pattern,friends.get(i).get(1)))
					{
						check=false;
						break;
					}
					if(friends.get(i).get(0).equals(friends.get(i).get(1))) {
						check=false;
					}

					for(int j=0;j<friends.size();j++) {
						HashSet friendset2 = new HashSet();
						friendset2.add(friends.get(j).get(0));
						friendset2.add(friends.get(j).get(1));
						if(friendset1.containsAll(friendset2) && i!=j) {
							check=false;
							break;
						}
					}
				}
				if(visitors.size()>10000) {
					check=false;
				}
			}
			else {
				check=false;
			}
		}else {
			check=false;
		}
		if(check==true) {
			finalfriendlist.add(user);
			for(int i=0;i<friends.size();i++) {
				finalfriendlist.add(friends.get(i).get(0));
				finalfriendlist.add(friends.get(i).get(1));
			}
			finalfriendlist.addAll(visitors);

			ArrayList<String> finalfriendlistarr = new ArrayList<>(finalfriendlist);

			for(String friend:finalfriendlistarr) {
				recommendscore.put(friend, 0);
			}
			System.out.println(solution(user,friends,visitors));

		}
	}

	public static List<String> solution(String user,List<List<String>> friends,List<String> visitors) {
		ArrayList<String> mutualfriend=new ArrayList<>(5);
		List<String> answer = Collections.emptyList();
		ArrayList<String> result = new ArrayList<>();
 		for(List friendlist:friends) {
			for(int i =0;i<2;i++) {
				String friend=(String)friendlist.get(i);
				if(friend.equals(user)) {
					if(i==0) {
						mutualfriend.add((String)friendlist.get(1));
					}else {
						mutualfriend.add((String)friendlist.get(0));
					}
				}
			}
		}

		for(List friendlist:friends) {
			for(int i=0;i<2;i++) {
				String friend=(String)friendlist.get(i);
				for(int k=0;k<mutualfriend.size();k++) {
					if(friend.equals(mutualfriend.get(k))) {
						int score = 0;
						if(i==0) {
							score = recommendscore.getOrDefault((String)friendlist.get(1), 0)+10;
							recommendscore.put((String)friendlist.get(1),score);
						}else {
							score = recommendscore.getOrDefault((String)friendlist.get(0), 0)+10;
							recommendscore.put((String)friendlist.get(0), score);
						}

					}
				}

			}
		}

		for(String visitor:visitors) {
			int score = recommendscore.getOrDefault(visitor,0)+1;
			recommendscore.put(visitor, score);
		}

		List<Map.Entry<String, Integer>> entrylist = new LinkedList<>(recommendscore.entrySet());
		entrylist.sort(new Comparator<Map.Entry<String,Integer>>(){
			int res = 0;
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o1.getValue()>o2.getValue()) {
					res = -1;
				}
				if(o1.getValue()==o2.getValue()) {
					if(o1.getKey().compareTo(o2.getKey())>0) {
						res=1;
					}
					if(o1.getKey().compareTo(o2.getKey())<0) {
						res=-1;
					}
				}
				if(o1.getValue()<o2.getValue()) {
					res = 1;
				}
				return res;
			}
		});
		int count =0;
		for(int i=0;i<entrylist.size();i++) {
			String key = entrylist.get(i).getKey();
			int score = recommendscore.getOrDefault(key,0);
			if(score > 0 && !mutualfriend.contains(key) && !key.equals(user)) {
				result.add(key);
				count++;
				if(count==5) {
					break;
				}
			}
		}
		answer = result;
		return answer;
	}

}
