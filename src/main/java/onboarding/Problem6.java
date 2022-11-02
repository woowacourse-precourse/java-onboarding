package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static Map<Integer, String> userEmailMap;
    public static Map<String, Integer> subStrUserIndexMap = new HashMap<>();
    public static List<Integer> duplicatedIndexList = new ArrayList<>();
    private static final int EMAIL_INDEX = 0;
    private static final int NICK_NAME_INDEX = 1;


    public static List<String> solution(List<List<String>> forms) {
        initUserEmailMap(forms);
        List<String> userInfo;
        for (int userIndex = 0; userIndex < forms.size(); userIndex++) {
            userInfo = forms.get(userIndex);
            modifyDuplicatedIndexList(userIndex, userInfo);
        }

        List<Integer> indexList = getDistinctIndexList();
        return getSortedEmailListByIndex(indexList);
    }

    public static void initUserEmailMap(List<List<String>> forms) {
        userEmailMap = new HashMap<>();
        for (int userIndex = 0; userIndex < forms.size(); userIndex++) {
            userEmailMap.put(userIndex, forms.get(userIndex).get(EMAIL_INDEX));
        }
    }

    public static void modifyDuplicatedIndexList(int userIndex, List<String> userInfo) {
        String nickname = userInfo.get(NICK_NAME_INDEX);
        String subStrKey;

        for (int i = 0; i < nickname.length() - 1; i++) {
            subStrKey = nickname.substring(i, i + 2);
            if (subStrUserIndexMap.containsKey(subStrKey)) {
                Integer initUserIndex = subStrUserIndexMap.get(subStrKey);
                duplicatedIndexList.add(userIndex);
                duplicatedIndexList.add(initUserIndex);
            } else {
                subStrUserIndexMap.put(subStrKey, userIndex);
            }
        }
    }

    public static List<Integer> getDistinctIndexList() {
        return duplicatedIndexList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> getSortedEmailListByIndex(List<Integer> indexList) {
        List<String> emailsList = new ArrayList<>();
        for (Integer userIndex : indexList) {
            emailsList.add(userEmailMap.get(userIndex));
        }
        Collections.sort(emailsList);
        return emailsList;
    }
}
