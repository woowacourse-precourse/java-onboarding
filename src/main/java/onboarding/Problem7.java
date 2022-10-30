package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
class Info implements Comparable<Info>{
	String name;
	int score;
	Info(String name, int score){
		this.name = name;
		this.score = score;
	}
	@Override
	public int compareTo(Info o){ //문자열의 정렬 설정!! 
		if(o.score == this.score) {
			if(this.name.compareTo(o.name)>0) {
				return 1;
			}else {
				return -1;
			}
		}else {
			return o.score-score;
		}
	}
}
public class Problem7 {
	static int indx = 0;
	static List<String> id = new LinkedList<>();
	static List<List<Integer>> graph = new LinkedList<>();
	static HashMap<String,Integer> map = new HashMap<>();
	public static List<String> calculate_Score(List<String> visitors){
		int[] score = new int[30001];
		for(String x: visitors) {
			int f1 = convert_Indx(x);
			score[f1] += 1;
		}
		for(int x:graph.get(0)) {
			score[x] =-1;
			for(int y:graph.get(x)) {
				if(score[y]!=-1) {
					score[y] +=10;
				}
			}
		}
		List<Info> list = new LinkedList<>();
		for(int i=1; i<indx ; i++) {
			if(score[i]>0) {
				list.add(new Info(id.get(i),score[i]));
			}
		}
		Collections.sort(list);
		List<String> answer = new LinkedList<>();
		for(Info o : list) {
			answer.add(o.name);
		}
		return answer;
	}
	public static int convert_Indx(String name) {
		if(map.containsKey(name)) {
			return map.get(name);
		}else {
			id.add(name);
			graph.add(new LinkedList<Integer>());
			map.put(name,indx);
		}  
		return indx++;
	}
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        convert_Indx(user);
        for(int i=0 ; i<friends.size(); i++) {
        	int f1 = convert_Indx(friends.get(i).get(0));
        	int f2 = convert_Indx(friends.get(i).get(1));
        	graph.get(f1).add(f2);
        	graph.get(f2).add(f1);
        }
        answer = calculate_Score(visitors);
        return answer;
    }
}
