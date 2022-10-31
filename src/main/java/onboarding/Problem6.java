package onboarding;

import java.util.*;

public class Problem6 {
    public static Map<String, String> twoLettersEmail = new HashMap<>();
    public static Set<String> emailWithSameLetters = new HashSet<>();

    public static List<String> sendEmailNotification(List<List<String>> forms) {
        List<String> answer;

        for(List<String> student : forms) {
            String nickname = student.get(1);
            String email = student.get(0);
            for(int i = 0; i < nickname.length() - 1; i++) {
                String splitName = nickname.substring(i, i + 2);
                if(twoLettersEmail.containsKey(splitName)) {
                    emailWithSameLetters.add(email);
                    emailWithSameLetters.add(twoLettersEmail.get(splitName));
                } else {
                    twoLettersEmail.put(splitName, email);
                }
            }
        }

        answer = new ArrayList<>(emailWithSameLetters);

        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String em1 = s1.split("@")[0];
                String em2 = s2.split("@")[0];

                return em1.compareToIgnoreCase(em2);
            }
        });

        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        return sendEmailNotification(forms);
    }
}