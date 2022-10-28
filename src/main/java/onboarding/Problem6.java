package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem6 {
    static HashMap<String, String> names = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    static void inputNames(String form) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<form.length()-1; i++) {
            String rem="";
            rem = rem + form.charAt(i) + form.charAt(i+1);
            set.add(rem);
        }
        for (String strings : set) {
            checkNames(strings);
        }
    }

}
