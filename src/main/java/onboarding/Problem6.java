package onboarding;

import java.util.*;

public class Problem6 {
    public static final Set<String> registeredNickNames = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkNickName(forms);
        return answer;
    }

    public static List<String> checkNickName(List<List<String>> forms) {
        SortedSet<String> emails = new TreeSet<>();

        for (int i = 0; i < forms.size(); i++) {
            String crewEmail = forms.get(i).get(0);
            String crewNickName = forms.get(i).get(1);

            if (isOverLap(crewNickName)) {
                emails.add(crewEmail);
            }
        }

        return convertSetToList(emails);
    }

    public static List<String> convertSetToList(SortedSet<String> set) {
        List<String> sortedEmails = new ArrayList<>();
        while(!set.isEmpty()) {
            sortedEmails.add(set.first());
            set.remove(set.first());
        }
        return sortedEmails;
    }

    public static boolean isOverLap(String nickName) {
        for (int i = 0; i < nickName.length() - 1; i++) {
            String seperatedNickName = nickName.substring(i, i + 2);
            if(registeredNickNames.contains(seperatedNickName)) {
                return true;
            }
            registeredNickNames.add(seperatedNickName);
        }
        return false;
    }
}
