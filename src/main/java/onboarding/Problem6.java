package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> realAnswer = new ArrayList<>();

        Set<String> set = new HashSet<>(realAnswer);
        List<String> result= new ArrayList<>(set); // result

        subStringMatching(forms, realAnswer);


        Collections.sort(result);
        return result;
    }

    private static void subStringMatching(List<List<String>> forms, List<String> answer){ // 부분 문자열 생성을 위한 메서드 생성


    }
}
