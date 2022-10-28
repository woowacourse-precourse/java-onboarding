package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean isDuplicateNickName(String nick1, String nick2) {
        for(int index=0;index<nick1.length()-1;index++){
            String str = nick1.substring(index,index+2);
            if(nick2.contains(str)){
                return true;
            }
        }
        return false;
    }
}