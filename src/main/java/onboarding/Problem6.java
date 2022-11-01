package onboarding;

import java.util.*;

/**
 * 기능 목록
 * 1. 초기화 과정.
 * 2. 닉네임을 중복확인. (즉 연속적인 문자가 있는 것들을 인지 할 수 있어야한다.)
 * 3. 각각의 닉네임들을 모두 잘라서 후보로 두어야한다.
 * 4. HashMap<email,name> , HashMap<email,boolean>
 * 5.
 */
//닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p6 = new Problem6();
        List<String> answer = List.of("answer");
        HashMap<String, String> nameMap = p6.initNameMap(forms);
        HashMap<String, Boolean> answerMap = p6.initAnswerMap(forms);
        List<String> duplicateCandidate = p6.getDuplicateCandidate(nameMap);


        return answer;
    }

    public HashMap<String, Boolean> getAnswerMap(HashMap<String, Boolean> answerMap,
                                                 HashMap<String, String> nameMap, List<String> duplicateCandidate) {
        for (String key : nameMap.keySet()) {
            if (compare(nameMap.get(key), duplicateCandidate)) {
                answerMap.replace(key, answerMap.get(key), Boolean.TRUE);
            }
        }
        return answerMap;
    }

    private Boolean compare(String value,List<String> duplicateCandidate) {
        for (String compareWord : duplicateCandidate) {
            if (compareEachAlphabet(value, compareWord)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private Boolean compareEachAlphabet(String value, String candidate) {
        for (int i = 0; i < value.length() - 1; i++) {
            if (value.substring(i, i + 2).equals(candidate)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public List<String> getDuplicateCandidate(HashMap<String, String> nameMap) {
        List<String> candidates = new ArrayList<>();
        for (String value : nameMap.values()) {
            if (checkNameNotAlreadyAdd(candidates, value)) {
                candidates.add(value);
            }
        }
        return candidates;
    }

    public Boolean checkNameNotAlreadyAdd(List<String> candidates, String candidate) {
        for (String s : candidates) {
            if (s.equals(candidate)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public HashMap<String, Boolean> initAnswerMap(List<List<String>> forms) {
        HashMap<String, Boolean> answerMap = new HashMap<>();
        for (List<String> s : forms) {
            answerMap.put(s.get(0), Boolean.FALSE);
        }
        return answerMap;
    }

    public HashMap<String, String> initNameMap(List<List<String>> forms) {
        HashMap<String, String> nameMap = new HashMap<>();
        for (List<String> s : forms) {
            nameMap.put(s.get(0), s.get(1));
        }
        return nameMap;
    }

}
