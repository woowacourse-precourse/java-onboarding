package onboarding;

import java.util.*;
/*
* 1. 이중 리스트에서 인덱스 번호와 닉네임으로 분해해서 Map에 저장 후 반환하는 메소드 작성
* 2. 조건에 따라 두 글자 이상 연속적으로 중복되어 있는 경우 인덱스 번호를 순서대로 뽑아내는 메소드 작성
* 3. 반환된 인덱스에 따라 forms 리스트에서 이메일 추출 후 정렬, 정렬된 객체 반환.
* */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Map<Integer, String> decomposition(List<List<String>> info) {
        Map<Integer, String> tempMap = new HashMap<>();
        for (int i = 0; i < info.size(); i++) {
            tempMap.put(info.indexOf(info.get(i)), info.get(i).get(1));
        }
        return tempMap;
    }
}
