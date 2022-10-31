package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Set<String> set=new HashSet<String>();
        int[][] dp;
        String s1,s2;
        for(List<String> list:forms){
            for (List<String> dif:forms){
                s1=list.get(1);
                s2=dif.get(1);
                if(s1.equals(s2))  continue;
                dp=new int[s1.length()+1][s2.length()+1];
                for (int i=0; i<s1.length()+1;i++){
                    for (int j=0; j<s2.length()+1;j++){
                        if(i*j == 0)  dp[i][j]=0;
                        else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                            dp[i][j]=dp[i-1][j-1]+1;
                            if(dp[i][j] >=2){
                                set.add(dif.get(0));
                                break;
                            }
                        }
                        else dp[i][j]=0;
                    }
                }
            }
        }
        answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer;
    }
}
