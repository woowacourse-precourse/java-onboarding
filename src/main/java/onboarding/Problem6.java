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
        List<String> result = new ArrayList<>();
        Map<Integer, String> tempMap = decomposition(forms);
        Set<Integer> duplicateSet = checkDuplicate(tempMap);
        for (Integer integer : duplicateSet) {
            result.add(forms.get(integer).get(0));
        }
        Collections.sort(result);

        return result;
    }

    public static Map<Integer, String> decomposition(List<List<String>> info) {
        Map<Integer, String> tempMap = new HashMap<>();
        for (int i = 0; i < info.size(); i++) {
            tempMap.put(info.indexOf(info.get(i)), info.get(i).get(1));
        }
        return tempMap;
    }

    public static Set<Integer> checkDuplicate(Map<Integer, String> map) {
        Set<Integer> indexSet = new HashSet<>(); // 중복 방지를 위해 이름을 담을 Set 생성

        for (int i = 0; i < map.size(); i++) {
            if (i == map.size() - 1) { // i가 map의 최종 인덱스와 같아지면 종료
                return indexSet;
            }
            String nickname = map.get(i); // 첫 번째 인덱스와
            for (int j = i+1; j < map.size(); j++) {
                String nickname2 = map.get(j); // 다음 인덱스 모두 비교
                for (int k = 0; k < nickname2.length(); k++) {
                    if (nickname2.length() != k + 1) { // length를 벗어나는 예외 방지
                        if (nickname.contains(nickname2.substring(k, k+2))) { // 첫 글자부터 두 글자씩 포함되면
                            indexSet.add(i);
                            indexSet.add(j);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return indexSet;
    }
}
