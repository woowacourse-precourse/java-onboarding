package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> demo_answer = new HashSet<>();
        //Set<String> dedup_name = new HashSet<>();
        int size = forms.size();
        //int[] flag = new int[size];

        for(int i=1; i<size; i++){
            String pre_email = forms.get(i-1).get(0);
            String pre_name = forms.get(i-1).get(1);

            String email = forms.get(i).get(0);
            String name = forms.get(i).get(1);

            for(int j=1; j<name.length(); j++){
                String two_alp = String.valueOf(name.charAt(j-1)) + name.charAt(j);
                for(int k=0; k<i; k++){
                    if(forms.get(k).get(1).contains(two_alp)){
                        demo_answer.add(forms.get(k).get(0));
                        demo_answer.add(forms.get(i).get(0));
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>(demo_answer);
        Collections.sort(answer);
        return answer;
    }
}
