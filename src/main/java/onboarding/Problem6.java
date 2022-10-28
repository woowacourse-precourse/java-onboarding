package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    // 처음 아이디어
    // 각 닉네임마다 두글자씩 잘라서 배열에 받는 함수 생성
    // 두 배열씩 비교하여 겹치는 값이 있는지 확인하는 함수 생성
    // 겹치는 배열이 존재하는 아이디만 정렬 후 반환

    public static List<String> nameDivideTwo(String s) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.length() % 2 == 1 && i == s.length()-1) {
                list.add(String.valueOf(s.charAt(i)));
            }
            list.add(String.valueOf(s.charAt(i)+s.charAt(i+1)));
        }
        return list;
    }

    public static boolean hasCommon(List<String> one, List<String> two) {
        boolean hasCommon = false;
        for (String s_one : one) {
            for (String s_two : two) {
                if (s_one.contains(s_two)) {
                    hasCommon = true;
                    break;
                }
            }
        }
        return hasCommon;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
