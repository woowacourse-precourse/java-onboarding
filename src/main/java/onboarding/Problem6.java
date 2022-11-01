package onboarding;

import onboarding.problem6.Alarm;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Alarm alarm = new Alarm();
        return alarm.getEmailOfDuplicatedNicknameUsers(forms);
    }
}
