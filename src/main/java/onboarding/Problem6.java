package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<ValidForm> validForms = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            // 이메일, 닉네임 유효성 검사
            if (isValidEmail(email) && isValidNickname(nickname)) {
                validForms.add(new ValidForm(email, nickname));
            }
        }

        Map<String, String> duplicateWords = new HashMap<>(); // word, email 저장, 중복 무시
        Set<String> duplicateEmailSet = new HashSet<>(); // email 저장, 중복 무시

        for (ValidForm validForm : validForms) {
            String email = validForm.getEmail();
            String nickname = validForm.getNickname();

            if (nickname.length() != 1) { // 닉네임 한자리 수 제외
                List<String> nicknameWords = getNicknameWords(nickname);

                for (String word : nicknameWords) {
                    if (duplicateWords.containsKey(word)) {
                        duplicateEmailSet.add(email);
                        duplicateEmailSet.add(duplicateWords.get(word));
                    } else {
                        duplicateWords.put(word, email);
                    }
                }
            }
        }
        
        // 문자열 오름차순 정렬 후 리턴
        List<String> duplicateEmails = new ArrayList<>(duplicateEmailSet);
        duplicateEmails.sort(Comparator.naturalOrder());

        return duplicateEmails;
    }

    // 1. 이메일 형식에 부합하는가?
    // 2. 이메일 길이가 11자 이상 20자 미만인가?
    // 3. 신청한 이메일이 email 도메인인가?
    private static boolean isValidEmail(String email) {
        if (11 <= email.length() && email.length() < 20) {
            Pattern pattern = Pattern.compile("^(.*)+@email\\.com+$");
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }
        return false;
    }

    // 4. 닉네임이 한글인가?
    // 5. 닉네임 길이가 1자 이상 20자 미만인가?
    // Q. 한글은 공백이 포함되는가?
    private static boolean isValidNickname(String nickname) {
        if (1 <= nickname.length() && nickname.length() < 20) {
            Pattern pattern = Pattern.compile("^[ㄱ-ㅣ가-힣]+$");
            Matcher matcher = pattern.matcher(nickname);
            return matcher.matches();
        }
        return false;
    }

    private static List<String> getNicknameWords(String nickname) {
        List<String> nicknameWords = new ArrayList<>();

        for (int i = 0; i < nickname.length(); i++) {
            for (int j = 2 + i; j < nickname.length() + 1; j++) {
                nicknameWords.add(nickname.substring(i, j));
            }
        }

        return nicknameWords;
    }

    private static class ValidForm {

        private final String email;
        private final String nickname;

        public ValidForm(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public String getNickname() {
            return nickname;
        }
    }
}
