package onboarding;

import java.util.*;

public class Problem6 {
    public static final Map<String, Integer> registeredNickNames = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = checkNickName(forms);
        return answer;
    }

    public static List<String> checkNickName(List<List<String>> forms) {
        SortedSet<String> emails = new TreeSet<>();

        setRegisteredNickNames(forms);

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
            if(registeredNickNames.get(seperatedNickName) > 1) {
                return true;
            }
        }
        return false;
    }

    public static void setRegisteredNickNames(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String nickName = forms.get(i).get(1);
            for (int j = 0; j < nickName.length() - 1; j++) {
                String seperatedNickName = nickName.substring(j, j + 2);
                registeredNickNames.put(seperatedNickName, registeredNickNames.getOrDefault(seperatedNickName, 0) + 1);
            }
        }
    }
}
