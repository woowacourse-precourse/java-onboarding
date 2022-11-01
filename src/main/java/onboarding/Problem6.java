package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	
    	ArrayList<String> clone = new ArrayList<String>();
		ArrayList<String> answer = new ArrayList<String>();
		
		for (int i = 0; i < forms.size(); i++) {
			String member = forms.get(i).get(1);
			for (int j = 0; j < member.length() - 1; j++) {
				String[] arr = new String[member.length()];
				arr[j] = member.substring(j, j + 2);
				for (int k = 0; k < forms.size(); k++) {
					if (forms.get(k).get(1).contains(arr[j]) && forms.get(k).get(1) != forms.get(i).get(1)) {
						clone.add(forms.get(k).get(0));
					}
				}
			}
		}
		for(String s : clone) {
			if(!answer.contains(s)) {
				answer.add(s);
			}
		}
		
		answer.sort(null);
		
		return answer;
    }
}
