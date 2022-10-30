package onboarding.problem6.service;

import onboarding.problem6.domain.NicknameChecker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NicknameService {

    private static final int EMAIL_INDEX = 0;
    private static final int NICKNAME_INDEX = 1;
    private static final int NICKNAME_DUPLICATE_LENGTH = 2;

    public static List<String> duplicateNicknameEmail(List<List<String>> applyList) {
        NicknameChecker nicknameChecker = new NicknameChecker();

        saveNickName(applyList, nicknameChecker);

        return sortList(duplicateEmails(applyList, nicknameChecker));
    }

    private static void saveNickName(List<List<String>> applyList, NicknameChecker nicknameChecker) {
        applyList.forEach(user -> distinctSubString(user.get(NICKNAME_INDEX))
                .forEach(nicknameChecker::saveNickname));
    }

    private static Set<String> duplicateEmails(List<List<String>> applyList, NicknameChecker nicknameChecker) {
        Set<String> result = new HashSet<>();

        applyList.stream()
                .filter(user -> distinctSubString(user.get(NICKNAME_INDEX)).stream()
                        .anyMatch(nicknameChecker::isDuplicate))
                .forEach(user -> result.add(user.get(EMAIL_INDEX)));

        return result;
    }

    public static List<String> distinctSubString(String text) {
        return IntStream.range(0, (text.length() - 1))
                .mapToObj(i -> text.substring(i, (i + NICKNAME_DUPLICATE_LENGTH)))
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<String> sortList(Set<String> result) {
        return result.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
