package onboarding.problem6.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NicknameChecker {

    private static final int EMAIL_INDEX = 0;
    private static final int NICKNAME_INDEX = 1;
    private static final int NICKNAME_DUPLICATE_LENGTH = 2;
    private static final int NICKNAME_DUPLICATE_SIZE = 2;
    private final Map<String, Set<String>> nicknameChecker = new HashMap<>();

    public NicknameChecker(List<List<String>> applyList) {
        this.saveNickName(applyList);
    }

    private void saveNickName(List<List<String>> applyList) {
        applyList.forEach(user -> distinctSubString(user.get(NICKNAME_INDEX))
                .forEach(nickname -> saveNickname(nickname, user.get(EMAIL_INDEX))));
    }

    public List<String> distinctSubString(String text) {
        return IntStream.range(0, (text.length() - 1))
                .mapToObj(index -> text.substring(index, (index + NICKNAME_DUPLICATE_LENGTH)))
                .distinct()
                .collect(Collectors.toList());
    }

    private void saveNickname(String nickname, String email) {
        Set<String> orDefault = this.nicknameChecker.getOrDefault(nickname, new HashSet<>());
        orDefault.add(email);
        this.nicknameChecker.put(nickname, orDefault);
    }

    public Set<String> duplicateEmails() {
        Set<String> strings = new HashSet<>();
        this.nicknameChecker.values().stream()
                .filter(NicknameChecker::isNicknameDuplicate)
                .forEach(strings::addAll);
        return strings;
    }

    private static boolean isNicknameDuplicate(Set<String> emailList) {
        return emailList.size() >= NICKNAME_DUPLICATE_SIZE;
    }
}
