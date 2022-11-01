package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return getUseLimitedNickNameUserEmails(forms);
    }

    private static List<String> getUseLimitedNickNameUserEmails(List<List<String>> forms) {
        HashMap<String, Integer> subNickNameFrequencies = getSubNickNameFrequencies(forms);

        HashSet<String> useLimitedNickNameUserEmails = new HashSet<>();
        forms.stream()
            .filter(form -> {
                String nickName = form.get(Form.NICKNAME.index);
                return isLimitedNickName(subNickNameFrequencies, nickName);
            })
            .forEach(form -> {
                String email = form.get(Form.EMAIL.index);
                useLimitedNickNameUserEmails.add(email);
            });

        return useLimitedNickNameUserEmails.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    private static boolean isLimitedNickName(
        HashMap<String, Integer> subNickNameFrequencies,
        String nickName
    ) {
        HashSet<String> subNickNames = getSubNickNames(nickName);
        return subNickNames.stream()
            .anyMatch(subNickName -> {
                int frequency = subNickNameFrequencies.get(subNickName);
                return frequency > 1;
            });
    }

    private static HashMap<String, Integer> getSubNickNameFrequencies(List<List<String>> forms) {
        HashMap<String, Integer> subNickNameFrequencies = new HashMap<>();
        forms.forEach(form -> {
            String nickName = form.get(Form.NICKNAME.index);
            getSubNickNames(nickName).forEach(
                subNickName -> subNickNameFrequencies.merge(subNickName, 1, Integer::sum)
            );
        });
        return subNickNameFrequencies;
    }

    private static HashSet<String> getSubNickNames(String nickName) {
        HashSet<String> subNickNames = new HashSet<>();
        for (int i = 0; i < nickName.length() - 1; i++) {
            subNickNames.add(nickName.substring(i, i + 2));
        }
        return subNickNames;
    }

    private enum Form {
        EMAIL(0),
        NICKNAME(1);

        private final int index;

        Form(int index) {
            this.index = index;
        }
    }
}
