package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 기능 목록
 * 1. 초기화 과정.
 * 2. 닉네임을 중복확인. (즉 연속적인 문자가 있는 것들을 인지 할 수 있어야한다.)
 * 3. 각각의 닉네임들을 모두 잘라서 후보로 두어야한다.
 * 4. HashMap<email,name> , HashMap<email,boolean>
 * 5. 후보들과 비교 하여 , 중복된다면 리스트에 넣고
 * 6. 해당 리스트를 정렬 하여 리턴.
 */
//닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 p6 = new Problem6();
        HashMap<String, String> nameMap = p6.initNameMap(forms);
        HashMap<String, Boolean> answerMap = p6.initAnswerMap(forms);
        List<String> duplicateCandidate = p6.getDuplicateCandidate(nameMap);

        HashMap<String, Boolean> map = p6.getAnswerMap(answerMap, nameMap, duplicateCandidate);

        return p6.getSortedAnswer(map);
    }

    public List<String> getSortedAnswer(HashMap<String, Boolean> map) {
        List<String> answer = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key)) {
                answer.add(key);
            }
        }
        return answer.stream().sorted().collect(Collectors.toList());
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

    private List<String> getDivide2WordList(List<String> candidates, String value) {
        for (int i = 0; i < value.length() - 1; i++) {
            candidates.add(value.substring(i, i + 2));
        }
        return candidates;
    }

    public List<String> getDuplicateCandidate(HashMap<String, String> nameMap) {
        List<String> candidates = new ArrayList<>();
        for (String value : nameMap.values()) {
            if (checkNameNotAlreadyAdd(candidates, value)) {
                candidates = getDivide2WordList(candidates, value);
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
