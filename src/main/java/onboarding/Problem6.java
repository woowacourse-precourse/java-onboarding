package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    private static boolean isDoubleSame(String a, String b){
        int len = Math.min(a.length(), b.length());

        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-1;j++){
                if(a.charAt(i) == b.charAt(j) && a.charAt(i+1) == b.charAt(j+1))return true;
            }
        }
        return false;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        boolean[] check = new boolean[forms.size()];

        for (int i=0;i<forms.size();i++) {
            List<String> cur = forms.get(i);
            for (int j=0;j<forms.size();j++) {
                if(i == j)continue;
                List<String> next = forms.get(j);
                if(isDoubleSame(cur.get(1), next.get(1))){
                    check[i] = true;
                    check[j] = true;
                }
            }
        }

        for (int i=0;i<forms.size();i++) {
            if(check[i])answer.add(forms.get(i).get(0));
        }
        Collections.sort(answer);
        return answer;
    }
}
