package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.regex.Pattern.compile;

public class Problem6 {

    private final static Pattern emailRegexPattern = compile("^(.+)@email.com");

    private static Map<String, List<Integer>> nicknameDuplicateMap;

    public static List<String> solution(List<List<String>> forms) {
        nicknameDuplicateMap = new HashMap<>();
        assert validateEmail(forms);

        createNicknameDuplicateMap(forms);

        return getDuplicateNicknameUserList(forms);
    }

    private static List<String> getDuplicateNicknameUserList(List<List<String>> forms) {
        return forms.stream()
                .filter(user -> hasDuplicateNickname(user.get(1)))
                .map(user -> user.get(0))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean hasDuplicateNickname(String nickname) {
        return getPartialNicknameSet(nickname).stream()
                .anyMatch(Problem6::isDuplicate);
    }

    private static boolean isDuplicate(String partialNickname) {
        return nicknameDuplicateMap.get(partialNickname).size() > 1;
    }

    private static void createNicknameDuplicateMap(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            final int index = i;
            final String nickname = forms.get(index).get(1);
            getPartialNicknameSet(nickname)
                    .forEach(nick -> nicknameDuplicateMap
                            .computeIfAbsent(nick, list -> new ArrayList<>())
                            .add(index)
                    );
        }
    }

    private static Set<String> getPartialNicknameSet(String nickname) {
        return IntStream.range(0, nickname.length() - 1)
                .mapToObj(i -> nickname.substring(i, i + 2))
                .collect(Collectors.toSet());
    }

    private static boolean validateEmail(List<List<String>> forms) {
        return forms.stream()
                .map(form -> form.get(0))
                .allMatch(Problem6::isEmailValidate);
    }

    private static boolean isEmailValidate(String email) {
        return checkEmailFormat(email) && checkEmailLength(email);
    }

    private static boolean checkEmailFormat(String email) {
        return emailRegexPattern.matcher(email).matches();
    }

    private static boolean checkEmailLength(String email) {
        return email.length() >= 11 && email.length() < 20;
    }
}
