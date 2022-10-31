package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static boolean findRedundancy(String string1, String string2){
        char c1, c2;
        for(int i=0; i<string1.length() - 1; i++){
            c1 = string1.charAt(i);
            c2 = string1.charAt(i+1);
            for(int j=0; j<string2.length()-1; j++){
                if(c1 == string2.charAt(j)){
                    if(c2 == string2.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
