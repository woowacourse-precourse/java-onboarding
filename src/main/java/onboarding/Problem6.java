package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static Map<Integer, String> userEmailMap;
    public static Map<String, Integer> subStrUserIndexMap;
    public static List<Integer> duplicatedIndex;
    public static int EMAIL_INDEX = 0;
    public static int NICK_NAME_INDEX = 1;


    public static List<String> solution(List<List<String>> forms) {
        initUserEmailMap(forms);
        initSubStrUserIndexMap();
        initDuplicatedIndexList();

        List<String> userInfo;
        for (int userIndex = 0; userIndex < forms.size(); userIndex++) {
            userInfo = forms.get(userIndex);
            findDuplicated(userIndex, userInfo);
        }

        List<Integer> indexList = getDistinctIndexList();
        List<String> answer = getAnswerList(indexList);
        Collections.sort(answer);
        return answer;
    }

    public static void initSubStrUserIndexMap() {
        subStrUserIndexMap = new HashMap<>();
    }

    public static void initDuplicatedIndexList() {
        duplicatedIndex = new ArrayList<>();
    }

    public static void initUserEmailMap(List<List<String>> forms) {
        userEmailMap = new HashMap<>();
        for (int userIndex = 0; userIndex < forms.size(); userIndex++) {
            userEmailMap.put(userIndex, forms.get(userIndex).get(EMAIL_INDEX));
        }
    }

    public static void findDuplicated(int userIndex, List<String> userInfo) {
        String nickname = userInfo.get(NICK_NAME_INDEX);
        String subStrKey;

        for (int i = 0; i < nickname.length() - 1; i++) {
            subStrKey = nickname.substring(i, i + 2);
            if (subStrUserIndexMap.containsKey(subStrKey)) {
                Integer initUserIndex = subStrUserIndexMap.get(subStrKey);
                duplicatedIndex.add(userIndex);
                duplicatedIndex.add(initUserIndex);
            } else {
                subStrUserIndexMap.put(subStrKey, userIndex);
            }
        }
    }

    public static List<Integer> getDistinctIndexList() {
        return duplicatedIndex.stream().distinct().collect(Collectors.toList());
    }

    public static List<String> getAnswerList(List<Integer> indexList) {
        List<String> emailsList = new ArrayList<>();
        indexList.forEach(userIndex -> emailsList.add(userEmailMap.get(userIndex)));
        return emailsList;
    }
}
