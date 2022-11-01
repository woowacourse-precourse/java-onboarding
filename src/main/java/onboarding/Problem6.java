package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
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
}
