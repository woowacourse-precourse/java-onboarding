package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        // 1. nickname 만 모아서 String 배열로 반환
        String[] nicknames = returnNickname(forms);

        // 2. 기준이 되는 닉네임을 2글자씩 쪼개서 리스트로 반환한 standard 와
        // 비교 대상이 되는 닉네임을 2글자씩 쪼개서 리스트로 반환한 nickname 을
        // findword 함수로 비교하여 일치한다면 일치하는 두 닉네임의 이메일을 저장
        for(int i = 0; i<nicknames.length; i++) {
            for(int j = i+1; j<nicknames.length; j++) {
                // 기준이 되는 닉네임 쪼개기
                List <String> standard = splitString(nicknames[i]);
                // 비교 대상이 되는 닉네임 쪼개기
                List <String> nickname = splitString(nicknames[j]);
                // standard 와 nickname 을 비교해서 같은 글자가 연속적으로 포함될 경우
                if(findWord(standard, nickname)) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        // 4. 이메일 리스트 중복 항목 제거
        answer = removeDuplication(answer);

        // 5. 이메일 리스트 오름차순 후 리턴
        return sort(answer);
    }

    // nickname 만 모아서 String 배열로 반환하는 함수
    private static String[] returnNickname(List<List<String>> forms) {
        String[] nickname = new String[forms.size()];
        for(int i = 0; i<forms.size(); i++) {
            nickname[i] = forms.get(i).get(1);
        }

        return nickname;
    }

    // 닉네임을 두 글자씩 쪼개서 String 리스트에 저장해서 리턴하는 함수
    /*
    ex) 제이엠 -> 제이, 이엠
     */
    private static List<String> splitString(String nickname) {
        // 글자수 - 1 만큼 사이클 돌면 됨.
        char[] chars = nickname.toCharArray();
        String[] str = new String[chars.length -1];
        for(int i = 0; i<chars.length-1; i++) {
            str[i] = String.valueOf(chars[i]);
            str[i] += chars[i+1];
        }

        return Arrays.asList(str);
    }

    // 닉네임을 두 글자씩 쪼갠 배열(기준)과 비교 대상 닉네임을 두 글자씩 쪼갠 것을 매개변수로 받아서
    // 일치하는 부분이 있는지 비교한 후, 있다면 true 를 리턴함
    private static boolean findWord(List<String> standard, List<String> nickname) {
        for(int i = 0; i< standard.size(); i++) {
            if(nickname.contains(standard.get(i))) {
                return true;
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
