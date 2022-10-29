package onboarding;

import java.awt.event.ItemEvent;
import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> nameEmailMap = new HashMap<>();
        List<String> crewList = new ArrayList<>(); // 겹치는 이름을 사용한 crew 리스트

        // 각 crew에 대해서 닉네임 중복 검사 실시
        for (List<String> crewInfo: forms){
            filteringCrew(crewInfo, nameEmailMap, crewList);
        }
        Set<String> answer = new TreeSet<String>(crewList); // set 변환으로 중복 제거

        return answer.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void filteringCrew(List<String> crewInfo, Map<String, String> nameEmailMap, List<String> crewList){
        String email = crewInfo.get(0), name = crewInfo.get(1);
        for (int i = 0; i < name.length() -1; i++){
            String splitedName = name.substring(i, i + 2); // 두 글자씩 자르기
            checkDuplicated(email, splitedName, crewList, nameEmailMap); // 한 crew가 여러 번 삽입됨 -> 나중에 필터링
        }
    }

    public static void checkDuplicated(String email ,String splitedName, List<String> crewList, Map<String, String> nameEmailMap){
        if (!nameEmailMap.containsKey(splitedName)){
            nameEmailMap.put(splitedName, email); // Map에 저장
            return;
        }
        crewList.add(nameEmailMap.get(splitedName)); // 기존 map에 있던 crew
        crewList.add(email); // 새로 검사 중인 crew
    }
}
