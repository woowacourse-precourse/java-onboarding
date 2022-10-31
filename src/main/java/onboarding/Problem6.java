package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, Boolean> isContain = new HashMap<String, Boolean>();
        List<String> answer = new ArrayList<>();
        Set<String> set = new TreeSet<>();
        // O(N^2)
        for(int i=0;i<forms.size();i++){
            List<String> cur = forms.get(i);
            for(int j=i+1;j<forms.size();j++){
                List<String> nxt = forms.get(j);
                // compare
                // 두 닉네임 중, 중복되는 문자가 2개 이상인 문자 찾기
                if(isPromising(cur.get(1), nxt.get(1))) {
                    set.add(cur.get(0));
                    set.add(nxt.get(0));
                }
            }
        }

        answer = new ArrayList<>(set);
        return answer;
    }

    private static boolean isPromising(String s, String s1) {
        // s 와 s1 에서 2개 이상의 연속중복 문자 여부 확인
        int ans = 0;
        int[][] dp = new int[s.length()+1][s1.length()+1];
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=s1.length();j++){
                if(s.charAt(i-1) == s1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans >= 2;
    }
}
