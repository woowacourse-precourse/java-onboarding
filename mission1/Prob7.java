import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Prob7 {
	
	public void recom(String user, String[][] friends, String[] visitors) {
		ArrayList<String> temp = new ArrayList<>();
		Map<String, ArrayList<String>> map = new HashMap<>();
		Map<String, Integer> res = new HashMap<>();
				
		//친구 해시 만들기
		for(int i=0; i < friends.length; i++) {
			String fr1 = friends[i][0];
			String fr2 = friends[i][1];
			if(map.get(fr1) == null) {
				ArrayList<String> fri=new ArrayList<String>();
				fri.add(fr2);
				map.put(fr1,fri);
			}
			else {
				map.get(fr1).add(fr2);
			}
			if(map.get(fr2) == null) {
				ArrayList<String> fri=new ArrayList<String>();
				fri.add(fr1);
				map.put(fr2, fri);
			}
			else {
				map.get(fr2).add(fr1);
			}
			
			
			
//			if(map.get(friends[i][0]) == null) { fri.clear(); }
//			else { fri = map.get(friends[i][0]); }
//			fri.add(friends[i][1]);
//			map.put(friends[i][0], fri);
//			
//			if(map.get(friends[i][1]) == null) { fri.clear(); }
//			else { fri = map.get(friends[i][1]); }
//			fri.add(friends[i][0]); //if(!fri.contains(friends[i][0])) { fri.add(friends[i][0]); }
//			map.put(friends[i][1], fri);
		}
			
		for(Entry<String, ArrayList<String>> entry : map.entrySet()) { 
			System.out.println(entry.getKey()+":"+ entry.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Problem 7");
		Prob7 prob7= new Prob7();
		
		String user = "mkro";
		String[][] friends = {{"donut", "andole"}, {"donut", "jun"}, 
			{"donut", "mrko"}, {"shakevan", "andole"}, {"shakevan", "jun"}, {"shakevan", "mrko"}};
		String[] visitors = {"bedi", "bedi", "donut", "bedi", "shakevan"};
		
		prob7.recom(user, friends, visitors);
		System.out.println();
		
	}
}

