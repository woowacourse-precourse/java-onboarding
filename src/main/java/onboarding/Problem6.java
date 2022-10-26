package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Integer> map = new HashMap<>();
        
		for(int i = 0; i < forms.size(); i++) {
			for(int j = 0; j < forms.get(i).get(1).length() - 2; j++) {
				String s = forms.get(i).get(1).substring(j, j + 2);
				
				map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
			}
		}
		
		boolean[] flag = new boolean[forms.size()];
		ArrayList<String> arr = new ArrayList<>();
		
		for(String key : map.keySet()) {
			if(map.get(key) > 1) {
				for(int i = 0; i < forms.size(); i++) {
					if(flag[i]) {
						continue;
					}
					if(forms.get(i).get(1).contains(key)) {
						arr.add(forms.get(i).get(0));
						flag[i] = true;
					}
				}
			}
		}
		
		Collections.sort(arr);
		
        return arr;
    }
}
