package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    private static int START_INDEX = 0;
    private static boolean[] ALARM_SYSTEM = null;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        fillAlarmSystem(forms.size());
        nickNameLoop(extractNickName(forms));
        addEmailInResultList(answer, forms);
        return answer;
    }

    private static void fillAlarmSystem(int formsSize) {
        ALARM_SYSTEM = new boolean[formsSize];
        Arrays.fill(ALARM_SYSTEM, false);
    }

    private static List<List<String>> extractNickName(List<List<String>> forms) {
        List<List<String>> nickNameList = new ArrayList<>();
        forms.forEach(form -> nickNameList.add(cutNickName(form.get(1))));
        return nickNameList;
    }

    private static List<String> cutNickName(String nickName) {
        List<String> TwoNickNameString = new ArrayList<>();
        for (int i = 0; i < nickName.length() - 1; i++) {
            TwoNickNameString.add(nickName.substring(i, i + 2));
        }
        return TwoNickNameString;
    }

    private static void nickNameLoop(List<List<String>> nickNameList) {
        for (int i = 0; i < nickNameList.size() - 1; i++) {
            START_INDEX = i;
            nickNameToStringLoop(nickNameList.get(i), nickNameList);
        }
    }

    private static void nickNameToStringLoop(List<String> nickNameToString, List<List<String>> nickNameList) {
        nickNameToString.forEach(nickNameString -> compareOtherNickName(nickNameString, nickNameList));
    }

    private static void compareOtherNickName(String nickNameString, List<List<String>> nickNameList) {
        for (int i = START_INDEX + 1; i < nickNameList.size(); i++) {
            if (ALARM_SYSTEM[i]) continue;
            if (nickNameList.get(i).contains(nickNameString)) {
                ALARM_SYSTEM[START_INDEX] = true;
                ALARM_SYSTEM[i] = true;
            }
        }
    }

    private static void addEmailInResultList(List<String> result, List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            if (ALARM_SYSTEM[i]) {
                result.add(forms.get(i).get(0));
            }
        }
        sortResultList(result);
    }

    private static void sortResultList(List<String> result) {
        Collections.sort(result);
    }
}
