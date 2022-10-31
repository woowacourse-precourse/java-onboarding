package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static boolean IS_SAME(String A, String B){
        boolean result = false;
        for (int i = 0; i < A.length() - 1; i++){
            String key_A = A.substring(i, i+2);
            for (int j = 0; j < B.length() - 1; j++){
                String key_B = B.substring(j, j+2);
                if(key_A.equals(key_B)){
                    result = true;
                    return result;
                }
            }
        }
        return result;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        int[] Arr = new int[forms.size()];
        Arrays.fill(Arr, 0);
        for (int i = 0; i < forms.size() - 1; i++){
            for(int j = i + 1; j < forms.size(); j++){
                if(IS_SAME(forms.get(i).get(1), forms.get(j).get(1))){
                    Arr[i] += 1;
                    Arr[j] += 1;
                }
            }
        }
        for (int i = 0; i < Arr.length; i++){
            if(Arr[i] > 0){
                answer.add(forms.get(i).get(0));
            }
        }
        answer.sort(String.CASE_INSENSITIVE_ORDER);
        return answer;
    }
}
