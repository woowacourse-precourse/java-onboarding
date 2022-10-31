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
