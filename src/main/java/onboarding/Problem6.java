package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    private static boolean[] ALARM_SYSTEM = null;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        fillAlarmSystem(forms.size());
        return answer;
    }
    private static void fillAlarmSystem(int formsSize){
        ALARM_SYSTEM = new boolean[formsSize];
        Arrays.fill(ALARM_SYSTEM,false);
    }
    private static List<List<String>> extractNickName(List<List<String>> forms){
        List<List<String>> nickNameList = new ArrayList<>();
        forms.forEach(form -> nickNameList.add(cutNickName(form.get(1))));
        return nickNameList;
    }
    private static List<String> cutNickName(String nickName){
        List<String> TwoNickNameString = new ArrayList<>();
        for (int i = 0; i < nickName.length()-1; i++) {
            TwoNickNameString.add(nickName.substring(i,i+2));
        }
        return TwoNickNameString;
    }

}
