package onboarding;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // nickname 만 모아서 String 배열로 반환하는 함수
    private static String[] returnNickname(List<List<String>> forms) {
        String[] nickname = new String[forms.size()];
        for(int i = 0; i<forms.size(); i++) {
            nickname[i] = forms.get(i).get(1);
        }

        return nickname;
    }

    // 닉네임을 두 글자씩 쪼개서 String 배열에 저장해서 리턴하는 함수
    /*
    ex) 제이엠 -> 제이, 이엠
     */
    private static String[] splitString(String nickname) {
        // 글자수 - 1 만큼 사이클 돌면 됨.
        char[] chars = nickname.toCharArray();
        String[] str = new String[chars.length -1];
        for(int i = 0; i<chars.length-1; i++) {
            str[i] = String.valueOf(chars[i]);
            str[i] += chars[i+1];
        }

        return str;
    }

    // 닉네임을 두 글자씩 쪼갠 배열(기준)과 비교 대상 닉네임을 쪼갠 것을 매개변수로 받음
    private static boolean findWord(String[] standard, String[] nickname) {
        for(int i = 0; i< standard.length; i++) {
            for(int j = 0; j < nickname.length; j++) {
                if (standard[i].equals(nickname[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    // 이메일 리스트 중복 제거
    private static List<String> removeDuplication(List<String> list) {
        list = list.stream().distinct().collect(Collectors.toList());

        return list;
    }

    // 이메일 리스트 오름차순 정렬
    private static List<String> sort(List<String> input) {
        input.sort(Comparator.naturalOrder());
        return input;
    }
}
