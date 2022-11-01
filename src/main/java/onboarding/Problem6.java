package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    // TODO 크루의 닉네임을 가져오는 메서드
    public static List<String> getNickname(List<List<String>> list) {
        List<String> answer = new ArrayList<>();
        for (int i =0; i < list.size(); i ++) {
            String name = list.get(i).get(1);
            for (int j = i+1; j < list.size(); j++) {
                String compare = list.get(j).get(1);

                if (isDupl(name, compare)) {
                    answer.add(list.get(i).get(0));
                    answer.add(list.get(j).get(0));
                }
            }
        }
        return answer;
    }

    // TODO 닉네임이 연속으로 중복되는지 판단하는 메서드
    public static boolean isDupl(String name, String compare) {
        for (int i = 0; i < name.length()-1; i++) {
            String str = name.substring(i, i+2);

            return (compare.contains(str));
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getNickname(forms);
        answer = answer.stream().distinct().sorted().collect(Collectors.toList());
        return answer;
    }
}
