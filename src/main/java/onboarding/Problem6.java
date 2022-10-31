package onboarding;

import java.util.List;

public class Problem6 {

    class Form{
        String nickname;
        String email;

        public Form(String nickname, String email) throws Exception {
            if (!isValidEmail(email)) {
                throw new Exception("Wrong email");
            }

            if (!isValidNickname(nickname)) {
                throw new Exception("Wrong name");
            }

            this.nickname = nickname;
            this.email = email;
        }

        private boolean isValidNickname(String nickname) {
            if (!isKoreanNickname(nickname)) return false;
            if (!isValidNicknameSize(nickname.length())) return false;

            return true;
        }

        private boolean isValidNicknameSize(int length) {
            return length >= 1 && length < 20;
        }

        private boolean isKoreanNickname(String nickname) {
            boolean isKorean = true;
            for (int i = 0; i < nickname.length() ; i++) {
                isKorean = isKoreanCharacter(nickname.charAt(i));
            }

            return isKorean;
        }

        private boolean isKoreanCharacter(char c) {
            return (c >= '가' && c <= '힣') || (c >= 'ㄱ' && c <= 'ㅎ');
        }

        private boolean isValidEmail(String email) {
            if (!isValidEmailSize(email.length())) return false;
            if (!isContainsEmail(email)) return false;

            return false;
        }

        private boolean isContainsEmail(String email) {
            String[] s = email.split("@");
            return s[1].equals("email.com");
        }

        private boolean isValidEmailSize(int length) {
            return length >= 11 && length< 20;
        }
    }

    private static boolean isValidPersonal(int n) {
        return n >= 1 && n <= 10_000;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("");
        if(!isValidPersonal(forms.size())) return answer;



        return answer;
    }
}
