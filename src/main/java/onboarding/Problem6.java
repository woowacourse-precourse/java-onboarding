package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, Set<String>> ngramTokenRepository = new HashMap<>();

        // ngram 저장소 만듬 토큰 , 이메일 종류
        initializeNgramTokenRepository(ngramTokenRepository, forms);

        answer = getEmailsOfDuplicatedNickname(ngramTokenRepository);

        return answer;
    }

    public static void initializeNgramTokenRepository(Map<String, Set<String>> ngramTokenRepository, List<List<String>> forms) {
        forms.forEach(crewInfo -> {
            for (int i = 0; i < crewInfo.get(1).length() - 1; i++) {
                String email = crewInfo.get(0);
                String nickname = crewInfo.get(1);

                Set<String> emailSetOfDuplicatedNickname = ngramTokenRepository.getOrDefault(nickname.substring(i, (i + 2)), new HashSet<>());
                emailSetOfDuplicatedNickname.add(email);
                ngramTokenRepository.put(nickname.substring(i, (i + 2)), emailSetOfDuplicatedNickname);
            }
        });
    }

    public static List<String> getEmailsOfDuplicatedNickname(Map<String, Set<String>> ngramTokenRepository) {
        Set<String> set = new HashSet<>();

        Set<Set<String>> emails = ngramTokenRepository.entrySet().stream()
                .filter(ngramTokenAndEmail -> ngramTokenAndEmail.getValue().size() > 1)
                .map(Map.Entry::getValue)
                .collect(Collectors.toSet());

        for (Set<String> duplicatedEmails : emails) {
            set.addAll(duplicatedEmails);
        }
        return List.copyOf(set).stream().sorted().collect(Collectors.toList());
    }
}
