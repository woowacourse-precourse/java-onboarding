package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    /*
    중복된 이름 찾기
     */
    private static boolean checkDuplicate(String str1,String str2){
        for(int i=0;i<str1.length()-1;i++){
            String temp=str1.substring(i,i+2);
            if(str2.contains(temp)){
                return true;
            }
        }
        return false;
    }
}
