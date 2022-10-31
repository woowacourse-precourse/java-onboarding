package onboarding;

import java.util.*;

/**
 * n : 닉네임의 길이.
 * N : 비교하려는 지원자 수.
 * s : 닉네임 하나를 구성하는 shingle 개수. (s=n-k+1)
 * k : shingle 하나의 길이.
 * k=2이고 10<n<20 일 때 이 알고리즘은 O(N)에 문제를 해결합니다.
 */
public class Problem6 {
    private final static int IDX_EMAIL = 0;
    private final static int IDX_NICKNAME = 1;
    private final static int K = 2;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer;
        Map<String, Integer> shingleCountMap = createShingleMap(forms);
        answer = findDuplicatedNickname(forms, shingleCountMap);
        Collections.sort(answer);

        return answer;
    }

    /* 모든 닉네임에 등장하는 shingle들의 등장횟수를 기록하는 Map을 반환합니다.
     * time complexity = O(sN) */
    private static Map<String, Integer> createShingleMap(List<List<String>> forms) {
        Map<String, Integer> shingleCountMap = new HashMap<>();
        forms.forEach(form->addShinglesOfNickname(form.get(IDX_NICKNAME), shingleCountMap));

        return shingleCountMap;
    }

    /* nickname 하나의 shingle들이 등장한 횟수를 shingleCountMap에 등록합니다.
     * 이미 존재한다면 개수를 1 추가한다.
     * 없었다면 개수를 0으로 초기화한다.
     * time complexity : O(s) */
    private static void addShinglesOfNickname(String nickname, Map<String, Integer> shingleCountMap) {
        Set<String> shinglesOfNickname = shingling(nickname);
        shinglesOfNickname.forEach(shingle -> updateCount(shingle, shingleCountMap));
    }

    /* shingleCountMap에 shingle 하나의 등장 횟수를 등록합니다.
     * time complexity = O(s) */
    private static void updateCount(String shingle, Map<String, Integer> shingleCountMap) {
        if (shingleCountMap.containsKey(shingle))
            shingleCountMap.replace(shingle, shingleCountMap.get(shingle)+1);
        else
            shingleCountMap.put(shingle, 1);
    }

    /** 입력받은 닉네임에 대한 k-shingle 집합을 반환합니다
     * time complexity = O(s) */
    private static Set<String> shingling(String nickname) {
        Set<String> shingleSet = new HashSet<>();
        for(int i=0;i<nickname.length()-K+1;i++)
           shingleSet.add(nickname.substring(i, i+K));
        return shingleSet;
    }

    /** 연속으로 k개의 음절이 중복된 닉네임을 사용한 지원자들을 List 형태로 반환합니다.
     * time complexity = O(sN) */
    private static List<String> findDuplicatedNickname(List<List<String>> forms, Map<String, Integer> shingleCountMap) {
        List<String> result = new ArrayList<>();
        forms.forEach(form -> { if(isDuplicatedNickname(form.get(IDX_NICKNAME), shingleCountMap)){
                result.add(form.get(IDX_EMAIL));
        }});

        return result;
    }

    /** nickname에 다른 닉네임들과 연속으로 k개의 중복된 문자가 존재하는 지 확인합니다.
     * time complexity = O(s) */
    private static boolean isDuplicatedNickname(String nickname, Map<String, Integer> shingleCountMap) {
        Set<String> shingleSet;
        shingleSet = shingling(nickname);
        boolean retVal = false;
        for (String s : shingleSet)
            retVal = (shingleCountMap.get(s) > 1) ? true : retVal;

        return retVal;
    }
}
