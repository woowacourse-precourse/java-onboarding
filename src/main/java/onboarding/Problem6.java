package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer=LCS(forms);
        Collections.sort(answer);
        return answer;
    }
    private static List<String> LCS(List<List<String>> forms){
        Set<String> set=new HashSet<String>();
        int[][] dp;
        String s1,s2;
        for(List<String> list:forms){
            for (List<String> dif:forms){
                if(search(list,dif))  continue;
                s1=list.get(1);
                s2=dif.get(1);
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
        return new ArrayList<>(set);
    }
    private static boolean search(List<String> li,List<String>di){
        if(     equalCheck(li.get(1),di.get(1)) ||
                (nickNameCheck(li.get(1)) || nickNameCheck(di.get(1))) ||
                (emailCheck(li.get(0)) || emailCheck(di.get(0)))
          ) return true;
        if(nickNameCheck(li.get(1)) || nickNameCheck(di.get(1))) return true;
        return false;
    }
    private static boolean equalCheck(String s1,String s2){
        return s1.equals(s2);
    }
    private static boolean nickNameCheck(String str){
        if(str.length() >=1 && str.length() <20)  return false;
        return true;
    }
    private static boolean emailCheck(String str){
        if(str.substring(str.length()-10).contains("@email.com")) return false;
        return true;
    }
}
