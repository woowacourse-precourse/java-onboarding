package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> emailSet = new HashSet<>();

        for(int i = 0; i < forms.size(); i++){
            for(int j = i; j < forms.size(); j++){
                if((i != j) && isSimilar(forms.get(i).get(1),forms.get(j).get(1))){
                    emailSet.add(forms.get(i).get(0));
                    emailSet.add(forms.get(j).get(0));
                }
            }
        }

        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);

        return answer;
    }
    static boolean isSimilar(String A, String B){
        for(int i = 1; i < B.length(); i++){
            for(int j = 1; j < A.length(); j++){
                if(A.substring(j-1,j+1).equals(B.substring(i-1,i+1))){
                    return true;
                }
            }
        }
        return false;
    }
}
