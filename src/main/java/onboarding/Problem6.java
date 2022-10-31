package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/**\
 * @Problem: 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.
 */
public class Problem6 {
    /**
     * @Method: solution
     */
    public static List<String> solution(List<List<String>> forms) {
        Set<String> answerSet = checkNickName(forms);
        return toSortedList(answerSet);
    }

    /**
     * @Method: checkNickName
     */
    private static Set<String> checkNickName(List<List<String>> crews) {
        Map<String, List<String>> subNameMap = makeSubNameMap(crews);
        return toAnswerSet(subNameMap);
    }

    /**
     * @Method: makeSubNameMap
     */
    private static Map<String, List<String>> makeSubNameMap(List<List<String>> crews) {
        Map<String, List<String>> subNameMap = new HashMap<>();

        for (List<String> crew : crews) {
            String email = crew.get(0);
            String nickName = crew.get(1);
            // 1. 이름을 각각 2글자씩 겹치게 쪼개서 해당 값을 key, 이메일을 value로 HashMap에 저장한다.
            for (int i = 0; i < nickName.length() - 1; i++) {
                String subName = getSubName(nickName, i);
                addSubNameToMap(subNameMap, email, subName);
            }
        }
        return subNameMap;
    }

    /**
     * @Method: addSubNameToMap
     */
    private static void addSubNameToMap(Map<String, List<String>> subNameMap, String email, String subName) {
        // 2. HashMap에서 Key가 겹치는 경우, 겹치는 닉네임이 존재하는 것이므로 판단한다.
        if(subNameMap.containsKey(subName)) {
            List<String> emailList = subNameMap.get(subName);
            //  2 - 1. 이때, 한명의 닉네임에 겹치는 단어 (ex: 제이제이)가 존재할 수 있기 때문에, value의 이메일과 현재 이메일을 비교하여 예외처리를 한다.
            if(!emailList.contains(email)) {
                emailList.add(email);
                subNameMap.replace(subName, emailList);
            }
        }
        else {
            List<String> emailList = new ArrayList<>();
            emailList.add(email);
            subNameMap.put(subName, emailList);
        }
    }

    /**
     * @Method: getSubName
     */
    private static String getSubName(String nickName, int index) {
        return nickName.substring(index, index + 2);
    }

    /**
     * @Method: toAnswerSet
     */
    private static Set<String> toAnswerSet(Map<String, List<String>> subNameMap) {
        Set<String> answerSet = new HashSet<>();
        for (String key : subNameMap.keySet()) {
            List<String> emailList = subNameMap.get(key);
            if (emailList.size() > 1) {
                answerSet.addAll(emailList);
            }
        }
        return answerSet;
    }

    /**
     * @Method: toSortedList
     */
    private static List<String> toSortedList(Set<String> answerSet) {
        // 3. Set을 사용하여 중복되는 이메일을 제거하고, 정렬한다.
        return answerSet.stream().sorted().collect(Collectors.toList());
    }
}