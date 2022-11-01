package onboarding;
/***
 * 기능목록
 * 1. 닉네임의 두 글자인 부분 문자열들의 빈도수 저장하는 기능
 * 2. 중복된 문자열을 가진 사용자의 이메일을 저장하는 기능
 */

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashMap<String, Integer> subNameCount = new HashMap<>();
        subNameCount = getSubNameCount(forms);
        answer = getEmailList(forms,subNameCount);

        return answer;
    }
    public static HashMap<String, Integer> getSubNameCount(List<List<String>> forms) {
        HashMap<String, Integer> subNameCount = new HashMap<>();
        for (int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            for (int j = 0; j + 1 < name.length(); j++) {
                String subName = name.substring(j, j + 2);
                subNameCount.put(subName, subNameCount.getOrDefault(subName, 0) + 1);
            }
        }
        return subNameCount;
    }
    public static List<String> getEmailList(List<List<String>> forms, HashMap<String, Integer> subNameCount) {
    }
}