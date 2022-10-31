package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem6 {
    /*
    NicknameChecker 기능 목록
    1. 닉네임을 2글자 단위로 검사해서 부분 닉네임 목록에 없다면 저장하고 있다면 중복 닉네임 목록에 추가하는 기능
    2. 이메일 리스트를 오름차순 정렬하는 기능
     */

    private static final int EMAIL_INDEX = 0;
    private static final int NICKNAME_INDEX = 1;

    public static List<String> solution(List<List<String>> forms) {
        NicknameChecker nicknameChecker = new NicknameChecker();

        nicknameChecker.check(forms);

        return nicknameChecker.getDuplicatedEmailList();
    }

    private static class NicknameChecker {
        private Map<String, String> subNicknames;
        private Map<String, Boolean> duplicatedEmails;

        public NicknameChecker() {
            subNicknames = new HashMap<>();
            duplicatedEmails = new HashMap<>();
        }

        public void check(List<List<String>> forms) {
            for (List<String> form : forms) {
                addSubNickname(form);
            }
        }

        private void addSubNickname(List<String> form) {
            String email = form.get(EMAIL_INDEX);
            String nickname = form.get(NICKNAME_INDEX);
            if (nickname.length() < 2) {
                return;
            }

            for (int i = 1; i < nickname.length(); i++) {
                String subNickname = nickname.substring(i - 1, i + 1);
                String isExist = subNicknames.getOrDefault(subNickname, "");
                if (isExist.equals("")) {
                    subNicknames.put(subNickname, email);
                    continue;
                }
                if (duplicatedEmails.getOrDefault(isExist, true)) {
                    duplicatedEmails.put(isExist, false);
                }
                if (duplicatedEmails.getOrDefault(email, true)) {
                    duplicatedEmails.put(email, false);
                }
            }
        }

        public List<String> getDuplicatedEmailList() {
            Stream<String> stream = duplicatedEmails.keySet().stream().sorted();
            return stream.collect(Collectors.toList());
        }
    }
}
