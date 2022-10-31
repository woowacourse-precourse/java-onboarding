package onboarding;

import java.util.*;

public class Problem6 {
    public static Map<String, String> splitNicknameEmail = new HashMap<>();
    public static Set<String> emailWithTheSameName = new HashSet<>();

    public static List<String> sendEmailNotification(List<List<String>> forms) {
        List<String> answer;

        for(List<String> student : forms) {
            String nickname = student.get(1);
            String email = student.get(0);
            for(int i = 0; i < nickname.length() - 1; i++) {
                String splitName = nickname.substring(i, i + 2);
                if(splitNicknameEmail.containsKey(splitName)) {
                    emailWithTheSameName.add(email);
                    emailWithTheSameName.add(splitNicknameEmail.get(splitName));
                } else {
                    splitNicknameEmail.put(splitName, email);
                }
            }
        }

        answer = new ArrayList<>(emailWithTheSameName);

        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        return sendEmailNotification(forms);
    }
}