package onboarding;

import java.util.*;

public class Problem6 {
    static HashMap<String, String> names = new HashMap<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = new ArrayList<>();

        for (List<String> strings : forms) {
            inputNames(strings.get(1));
        }
        for (List<String> strings : forms) {
            if (overlapNames(strings.get(1))) {
                answer.add(strings.get(0));
            }
        }
        Collections.sort(answer);

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
