package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int arr[]=new int[forms.size()];

        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < forms.get(i).get(1).length() - 1; j++) {
                String str="";
                str+= Character.toString(forms.get(i).get(1).charAt(j));
                str += Character.toString(forms.get(i).get(1).charAt(j + 1));

                for (int k = 0; k < forms.size(); k++) {
                    if (k == i) {
                        continue;
                    }
                    if (forms.get(k).get(1).contains(str)) {
                        arr[k]=1;
                    }
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                answer.add(forms.get(i).get(0));
            }
        }
        Collections.sort(answer);

        return answer;
    }
}
