package onboarding;

import java.util.*;

public class Problem6 {

    // 닉네임에 중복이 있나 체크해주는 함수
    private static boolean checkDuplication(String str1, String str2) {
        // (i, i+1)의 str1 문자를 추출해 str2에 포함되는지 확인
        for (int i = 0; i < str1.length()-1; i++) {
            if (str2.contains(str1.substring(i, i+2))) {
                return true;
            }
        }
        return false;
    }

    // 중복된 이메일 반환 시 오름차순 정렬, 중복 제거해주는 함수
    private static List<String> sortEmail(List<String> list) {
        Set<String> set = new HashSet<>(list); // 즁복을 제거하기 위해 Set에 넣었다 뺀다.
        List<String> newList = new ArrayList<>(set); // solution 함수 반환 값과 타입을 맞추기 위해
        Collections.sort(newList); // 오름차순으로 정렬
        return newList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // i마다 j를 i-1까지 돌며 중복을 확인하고 중복이 존재하면 answer 리스트에 이메일을 담는다.
        for (int i = 0; i < forms.size(); i++) {
            for (int j = 0; j < i; j++) {
                if(checkDuplication(forms.get(i).get(1), forms.get(j).get(1))) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }

        // 이메일 정렬, 중복 제거 후 반환
        return sortEmail(answer);
    }
}
