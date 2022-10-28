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

    static void checkNames(String tmp) {
        if(names.get(tmp) == null) {
            names.put(tmp,"1");
        }
        else {
            names.put(tmp,"2");
        }
    }

    static boolean overlapNames(String form) {
        boolean result = false;

        for(int i=0; i<form.length()-1; i++) {
            String rem="";
            rem = rem + form.charAt(i) + form.charAt(i+1);
            if(names.get(rem).equals("2")) {
                result = true;
                break;
            }
        }
        return result;
    }

}
