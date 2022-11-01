package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
            List.of("jm@email.com", "제이엠"),
            List.of("jason@email.com", "제이슨"),
            List.of("woniee@email.com", "워니"),
            List.of("mj@email.com", "엠제이"),
            List.of("nowm@email.com", "이제엠")
        );

        System.out.printf("%-30s|%-30s|", "forms", "result");
        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.printf("%-30s|%-30s|", forms, solution(forms));
        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        FormsValidator.validate(forms);
        answer = findEmailsWithLimitedNicknames(forms);
        return answer;
    }

    private static List<String> findEmailsWithLimitedNicknames(List<List<String>> forms) {
        Map<String, String> charDuplicateCheckRepo = new HashMap<>();
        Set<String> resultEmails = new HashSet<>();
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            findNicknamesWithDuplicateCharacters(charDuplicateCheckRepo, resultEmails, email,
                nickname);
        }
        return resultEmails.stream().sorted().collect(Collectors.toList());
    }

    private static void findNicknamesWithDuplicateCharacters(
        Map<String, String> charDuplicateCheckRepo,
        Set<String> resultEmails, String email, String nickname) {

        for (int i = 0; i < nickname.length() - 1; i++) {
            String charScanner = nickname.substring(i, i + 2);
            if (charDuplicateCheckRepo.containsKey(charScanner)) {
                String charScannerEmail = charDuplicateCheckRepo.get(charScanner);
                getResultEmail(resultEmails, email, charScannerEmail);
            }
            charDuplicateCheckRepo.put(charScanner, email);
        }
    }

    private static void getResultEmail(Set<String> resultEmails, String email,
                                       String charScannerEmail) {
        if (!Objects.equals(charScannerEmail, email)) {
            resultEmails.add(charScannerEmail);
            resultEmails.add(email);
        }
    }

    private static class FormsValidator {
        private static final int MIN_NUMBER_OF_CREWS = 1;
        private static final int MAX_NUMBER_0F_CREWS = 10000;

        public static void validate(List<List<String>> forms) {
            if (checkNumberOfCrews(forms)) {
                throw new IllegalArgumentException(
                    "A crew consists of at least 1 and no more than 10,000 people.");
            }
            for (List<String> form : forms) {
                EmailValidator.validate(form.get(0));
                NicknameValidator.validate(form.get(1));
            }
        }

        private static boolean checkNumberOfCrews(List<List<String>> forms) {
            return forms.size() < MIN_NUMBER_OF_CREWS || forms.size() > MAX_NUMBER_0F_CREWS;
        }

        private static class EmailValidator {
            private static final int MIN_EMAIL_LENGTH = 11;
            private static final int MAX_EMAIL_LENGTH = 20;

            public static void validate(String email) {
                if (!isValidEmailFormat(email)) {
                    throw new IllegalArgumentException("It doesn't fit the email format.");
                }

                if (checkLengthOfEmail(email)) {
                    throw new IllegalArgumentException(
                        "Emails should be at least 11 and less than 20 characters in length.");
                }

                if (!isValidEmailDomain(email)) {
                    throw new IllegalArgumentException(
                        "Emails can only be submitted with the domain \"email.com\".");
                }
            }

            private static boolean checkLengthOfEmail(String email) {
                return email.length() < MIN_EMAIL_LENGTH || email.length() >= MAX_EMAIL_LENGTH;
            }

            private static boolean isValidEmailDomain(String email) {
                String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            }

            private static boolean isValidEmailFormat(String email) {
                String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            }
        }

        private static class NicknameValidator {
            private static final int MIN_NICKNAME_LENGTH = 1;
            private static final int MAX_NICKNAME_LENGTH = 20;

            public static void validate(String nickname) {
                if (!isKoreanNickname(nickname)) {
                    throw new IllegalArgumentException("Nicknames are only available in Korean.");
                }

                if (checkNicknameLength(nickname)) {
                    throw new IllegalArgumentException(
                        "Nicknames should be at least 11 and less than 20 characters in length.");
                }
            }

            private static boolean isKoreanNickname(String nickname) {
                String regex = "^[가-힣]*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(nickname);
                return matcher.matches();
            }

            private static boolean checkNicknameLength(String nickname) {
                return nickname.length() < MIN_NICKNAME_LENGTH ||
                    nickname.length() >= MAX_NICKNAME_LENGTH;
            }
        }
    }
}
