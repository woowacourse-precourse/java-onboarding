package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	ArrayList<String> result = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();
		String str, temp;
		
		for(int i=0; i < nick.length; i++) {
			str = nick[i][1];
			for(int j=0; j < str.length()-1; j++) {
				temp = Character.toString(str.charAt(j)) + Character.toString(str.charAt(j+1));
				
				if(map.containsKey(temp)) {
					result.add(nick[i][0]);
					if(!result.contains(map.get(temp))) 
					{ result.add(map.get(temp)); }
				}
				map.put(temp, nick[i][0]);
			}
		}		
		return result;
    }
}
