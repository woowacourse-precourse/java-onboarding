package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return getAlarmList(forms);
    }

    private static List<String> getAlarmList(List<List<String>> forms) {
        HashSet<String> alarmSet = new HashSet<>();
        HashMap<String, String> partialNickNameEmailMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            List<String> partialNickNameList = makePartialNickNameList(nickName);
            checkAndEnrollPartialNickNameList(partialNickNameList, email, alarmSet, partialNickNameEmailMap);
        }

        return convertMapToListAndSort(alarmSet);
    }

    private static void checkAndEnrollPartialNickNameList(List<String> partialNickNameList, String email, HashSet<String> alarmSet, HashMap<String, String> partialNickNameEmailMap) {
        for (String partialNickName : partialNickNameList) {
            checkAndEnrollPartialNickName(partialNickName, email, alarmSet, partialNickNameEmailMap);
        }
    }

    private static void checkAndEnrollPartialNickName(String partialNickName, String email, HashSet<String> alarmSet, HashMap<String, String> partialNickNameEmailMap) {
        if (isExistingName(partialNickName, partialNickNameEmailMap)) {
            String existingRegisteredEmail = partialNickNameEmailMap.get(partialNickName);
            addTwoEmailsToAlarmSet(alarmSet, email, existingRegisteredEmail);
            return;
        }
        enrollNickNameEmail(partialNickName, email, partialNickNameEmailMap);
    }

    private static void enrollNickNameEmail(String partialNickName, String email, HashMap<String, String> partialNickNameEmailMap) {
        partialNickNameEmailMap.put(partialNickName, email);
    }

    private static void addTwoEmailsToAlarmSet(HashSet<String> alarmSet, String newEmail, String existingRegisteredEmail) {
        alarmSet.add(newEmail);
        alarmSet.add(existingRegisteredEmail);
    }

    private static boolean isExistingName(String partialNickName, HashMap<String, String> partialNickNameEmailMap) {
        return partialNickNameEmailMap.containsKey(partialNickName);
    }

    private static List<String> makePartialNickNameList(String nickName) {
        List<String> partialNickNameList = new ArrayList<>();
        for (int splitLength = 2; splitLength <= nickName.length(); splitLength++) {
            for (int startIdx = 0; startIdx <= (nickName.length() - splitLength); startIdx++) {
                partialNickNameList.add(nickName.substring(startIdx, startIdx + splitLength));
            }
        }
        return partialNickNameList;
    }
}
