package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	
    	List<String> prev = new ArrayList<String>();
		List<String> prev2 = new ArrayList<String>();
		List<String> mail = new ArrayList<String>();
		

		for(int i =0; i < forms.size(); i++) {
			for(int j =0; j < forms.get(i).get(1).length()-1; j++) {
				String str = forms.get(i).get(1).substring(j, j+2);
				if(!prev.contains(str)) {
					prev.add(str);
				} else {
					mail.add(forms.get(i).get(0));
				}
			}
		}
		
		for(int i =1; i < forms.size(); i++) {
			for(int j =0; j < forms.get(i).get(1).length()-1; j++) {
				String str = forms.get(i).get(1).substring(j, j+2);
				if(!prev2.contains(str)) {
					prev2.add(str);
				for(int k = 0; k < forms.get(0).get(1).length()-1; k++) {
					String str0 = forms.get(0).get(1).substring(k, k+2);
					if(prev2.contains(str0)) {
						if (!mail.contains(forms.get(0).get(0))) {
							mail.add(forms.get(0).get(0));
							}
						}
					}
				}
			}
		}
		
        List<String> answer = List.of("answer");
        answer = mail;
        return answer;
    }
}
