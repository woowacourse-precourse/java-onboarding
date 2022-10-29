package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        //System.out.println(forms.size());
        int[] arr = new int[forms.size()];
        //System.out.println(arr.size());
        for(int i = 0; i < forms.size(); i++){
            String tmp = forms.get(i).get(1);
            for(int j = 0; j < tmp.length() - 1; j++){
                String sstr = tmp.substring(j,j+2);
                for(int k = 0; k < forms.size(); k++){
                    if(i == k) continue;
                    if(arr[k] == 1) continue;
                    if(forms.get(k).get(1).contains(sstr)) arr[k] = 1;
                }
            }
        }
        for(int i = 0; i < forms.size(); i++){
            if(arr[i] == 1){
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
