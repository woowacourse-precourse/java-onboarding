package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static boolean checkSame(String nickname1, String nickname2){
        for(int i=0; i<nickname1.length()-1;i++){
            if(nickname2.contains(nickname1.substring(i,i+2))){
                return true;
            }
        }
        return false;
    }
}