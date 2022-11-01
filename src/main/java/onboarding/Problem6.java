package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
	public static void main(String[] args) {
		List<List<String>> forms = new ArrayList<List<String>>(2);
		
		List<String> a1 = new ArrayList<>();
		a1.add("jm@email.com");
		a1.add("제이엠");
		
		List<String> a2 = new ArrayList<>();
		a2.add("jason@email.com");
		a2.add("제이슨");
		
		List<String> a3 = new ArrayList<>();
		a3.add("woniee@email.com");
		a3.add("워니");
		
		List<String> a4 = new ArrayList<>();
		a4.add("mj@email.com");
		a4.add("엠제이");
		
		List<String> a5 = new ArrayList<>();
		a5.add("nowm@email.com");
		a5.add("이제엠");
		
		forms.add(a1);
		forms.add(a2);
		forms.add(a3);
		forms.add(a4);
		forms.add(a5);
		
		System.out.println(solution(forms));
	}
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int[] index = null;
        
        for(int i = 0; i<forms.size(); i++) {
        	char[] arr = forms.get(i).get(1).toCharArray();
        	String[] str = new String[arr.length-1];
        	int count = 0;
        	for(int j = 0; j<arr.length-1; j++) {
        		char[] arr1 = {arr[j], arr[j+1]};
        		str[j] = new String(arr1);
        		
        		for(int k = 0; k < forms.size(); k++) {
        			if(forms.get(k).get(1).contains(str[j])) {
        				count += 1;
        			}
        		}
        		if(count == 1) {
        			count = 0;
        		}else {
        			index = new int[count];
        			count = 0;
        			
        			for(int l = 0; l<forms.size(); l++) {
        				if(forms.get(l).get(1).contains(str[j])) {
        					index[count] = l;
        					count++;
        				}
        			}
        		}
        	}
        }
        for(int m = 0; m<index.length; m++) {
        	answer.add(forms.get(index[m]).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
}
