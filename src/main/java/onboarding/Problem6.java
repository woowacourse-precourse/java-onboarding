package onboarding;

/**
 * 기능 요구 사항
 * 1. 중복 조건, 크루 명수 제한
 * 2. 이메일 길이 제한, 도메인 조건
 * 3. 닉네임 설정
 * 4. 오름차순 정렬, 중복 제거
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        checkEmail(forms, answer);
        return answer.stream().sorted().distinct().collect(Collectors.toList());
    }
    // 2. 이메일 길이 제한, 도메인 조건
    public static List<String> checkEmail(List<List<String>> forms, List<String> answer) {
        List<List<String>> valid_forms = forms;
        List<String> nickname_origin = new ArrayList<>();
        List<Integer> nickname_index = new ArrayList<>();

        for(int i = 0; i < valid_forms.size(); i++) {
            nickname_origin.add(forms.get(i).get(1));
        }
        for(int i = 0; i < valid_forms.size(); i++) {
            checkDuplicate(nickname_origin, nickname_index, forms.get(i).get(1), i);
        }
        // 4. 오름차순 정렬, 중복제거
        Collections.sort(nickname_index);
        List<Integer> listWithoutDuplicates = nickname_index.stream()
                .distinct()
                .collect(Collectors.toList());
        for(Integer listWithoutDuplicate : listWithoutDuplicates) {
            answer.add(valid_forms.get(listWithoutDuplicate).get(0));
        }
        return answer;
    }
    // 1. 중복 조건 && 3. 닉네임 설정
    public static void checkDuplicate(List<String> nickname_origin, List<Integer> index_list, String nick_name, int number) {
        for(int i = 0; i < nick_name.length()-1; i++) {
            String sub = nick_name.substring(i,i+2); // 부분 문자열 추출
            for(int j = 0; j < nickname_origin.size(); j++) {
                if(j != number) {
                    if(nickname_origin.get(j).contains(sub)) {
                        index_list.add(j);
                    }
                }
            }
        }
    }
}
