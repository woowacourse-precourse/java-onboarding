////
import java.util.ArrayList;
import java.util.HashMap;

public class Prob6 {
	
	public ArrayList<String> nickChk(String[][] nick) {
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
	
	public static void main(String[] args) {
		System.out.println("Problem 6");
		Prob6 prob6 = new Prob6();
		ArrayList<String> result = new ArrayList<>();
		
		String[][] nick = {{"jm@email.com", "¡¶¿Ãø•"}, {"jason@email.com", "¡¶¿ÃΩº"}, 
				{"woniee@email.com", "øˆ¥œ"}, {"mj@email.com", "ø•¡¶¿Ã"}, {"nowm@email.com", "¿Ã¡¶ø•"}};
		
		result = prob6.nickChk(nick);
		System.out.println(result.toString());
		
	}
}
