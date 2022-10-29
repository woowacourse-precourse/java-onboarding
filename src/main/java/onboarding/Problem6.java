package onboarding;

import java.util.List;

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

}
