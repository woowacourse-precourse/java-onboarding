package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        int i = 0;
        int s = 0;
        int same = 0;
        int outSize = forms.size();
        int[] countsub = new int[outSize];

        //check the same substring
        for(i = 0; i < outSize; i++){
            List<String> First = forms.get(i);
            //repeat the n-1
            for(s = i+1; s < outSize; s++){
                List<String> Second = forms.get(s);
                same = Substring(First.get(1), Second.get(1));
                if(same == 2){ //Save that list order have substring
                    countsub[s] = 1;
                    countsub[i] = 1;
                }
            }
        }
        //save the email /check the countsub and input the answer
        for(i = 0; i < outSize; i++){
            if(countsub[i] == 1){
                List<String> temp = forms.get(i);
                answer.add(temp.get(0));
            }
        }
        Collections.sort(answer);
        return answer;
    }
    static int Substring(String first, String second){
        int[][] dp = new int[20][20];
        //save length
        int flength = first.length();
        int slength = second.length();
        int sub = 0;
        //check the substring use LCS
        //if sub is 2, then break the loop
        loop:
        for(int i = 0; i < flength; i++){
            for(int j = 0; j < slength; j++){
                if(first.charAt(i) == second.charAt(j)){
                    dp[i][j] = 1;
                    if(i > 0 && j > 0){
                        dp[i][j] += dp[i-1][j-1];
                    }
                    sub = Math.max(sub, dp[i][j]);
                    if(sub == 2){
                        break loop;
                    }
                }
            }
        }

        return sub;
    }
}
