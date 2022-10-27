package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Validator.isValidate(forms);
        return answer;
    }

    static class Validator{
        public static boolean isValidate(List<List<String>> forms){
            try {
                isCorrectCrewSize(forms);
                isCorrectEmailForm(forms);
                isCorrectEmailSize(forms);
                isCorrectNickname(forms);
                return true;
            } catch (Exception error) {
                return false;
            }
        }

        private static void isCorrectCrewSize(List<List<String>> forms){
            if (forms.size() < 1 || forms.size() > 10000){
                throw new IllegalArgumentException("Not correct crew size");
            }
        }

        private static void isCorrectEmailForm(List<List<String>> forms){
            List<String> emails = forms.stream()
                    .map(list -> list.get(0)) // 이메일 추출
                    .collect(Collectors.toList());
            emails.stream()
                    .map(email -> email.split("@"))
                    .forEach(split -> {
                        if (split.length != 3){
                            throw new IllegalArgumentException("'@' is should be one");
                        }
                        if (!split[2].equals("email.com")){
                            throw new IllegalArgumentException("domain should be 'email.com'");
                        }
                    });
        }

        private static void isCorrectEmailSize(List<List<String>> forms){
            forms.stream().map(list -> list.get(0)).forEach(email -> {
                if (email.length() < 10 || email.length() >= 20) {
                    throw new IllegalArgumentException("email length is not correct");
                }
            });
        }

        private static void isCorrectNickname(List<List<String>> forms){
            forms.stream().map(list -> list.get(1)).forEach(nickname -> {
                if (nickname.length() < 1 || nickname.length() >= 20){
                    throw new IllegalArgumentException("Nickname length is not correct");
                }
                if (!Pattern.compile("^[가-힣]*$").matcher(nickname).matches()){
                    throw new IllegalArgumentException("Nickname should be korean");
                }
            });
        }

    }
}
