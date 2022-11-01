package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    // list for store forms
    private static List<List<String>> storage = new ArrayList<>();
    // list for store similar index
    int[] idx = {};
    // func : compare with prior nicknames, return Boolean
    private static Boolean isSimilar(String nick1, String nick2) {
        int firstLen = nick1.length();
        int secondLen = nick2.length();
        if (firstLen == 1 || secondLen == 1)
            return false;

        for(int i=0;i<firstLen-1;i++){
            String check = nick1.substring(i,i+2);
            System.out.println(check);
            if (nick2.contains(check))
                return true;
        }
        return false;
    }
    // func : found similar nicknames, return List<String> email
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        storage.add(List.of("jm@email.com","제이엠"));
        isSimilar("구이이","엠제이");
        return answer;
    }
}
