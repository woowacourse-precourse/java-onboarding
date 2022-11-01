package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    private static boolean EmailVaildCheck(String input){
        return input.contains("@email.com");
    }
    private static boolean redunCheck(String first, String second){
        boolean result = false;
        if(first.length() > 2)
            for(int i = 0; i < first.length()-1; i++){
                result = second.contains(first.substring(i, i+2));
                if(result)
                    break;
            }
        else {
            result = first.equals(second);
        }
        return result;
    }
}
