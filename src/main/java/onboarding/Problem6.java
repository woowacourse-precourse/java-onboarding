package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Problem6 {

    private static class Constants {
        protected static final int EMAIL = 0;
        protected static final int NICKNAME = 1;
        protected static final String EMAIL_TYPE = "email.com";
    }

    private static class UserVerifier {
        protected void isRightEmailType(String email) {
            if (!email.contains(Constants.EMAIL_TYPE)) {
                throw new IllegalArgumentException("이메일 형식은" + Constants.EMAIL_TYPE + "도메인만 지원됩니다.");
            }
        }

        // 이메일이 11자 이상 20자 미만인가
        protected void isEmailLengthThan11CharactersAndLessThan20Characters(String email) {
            if (email.length() <= 10 || 21 <= email.length()) {
                throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 이하입니다.");
            }
        }

        protected void isNicknameKorean(String nickname) {
            String regex = "^[가-힣]*$";
            if (!nickname.matches(regex)) {
                throw new IllegalArgumentException("닉네임에는 한글만 사용할 수 있습니다.");
            }
        }

        protected void isCrewMemberSizeThan1MemberAndLessThan100Member(List<List<String>> crew) {
            if (crew.size() < 1 || 100 < crew.size()) {
                throw new IllegalArgumentException("크루의 멤버 수는 1명 이상 100명 이하만 입력 가능합니다.");
            }
        }
    }

    public static List<List<String>> users = new ArrayList<>();
    public static List<String> result = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        initList(forms);
        return validateUserNickname(forms);
    }

    private static void initList(List<List<String>> forms) {
        users.add(forms.get(0));
    }

    private static List<String> validateUserNickname(List<List<String>> forms) {
        for (int i = 1; i < forms.size(); i++) {
            List<String> user = forms.get(i);
            // 만약 중복되는 닉네임이 있고
            if (isLetterWordsInAlreadyExistsNicknames(user.get(Constants.NICKNAME))) {
                // result 리스트에 이메일이 존재하지 않는다면
                if (!isAlreadyExistsEmailInResult(user.get(Constants.EMAIL))) {
                    result.add(user.get(Constants.EMAIL));
                }
            }
            users.add(user);
        }
        // 이메일 기준 오름차순 정렬
        sortList();
        return result;
    }

    // 이미 있는 닉네임 중에서 글자가 연속적으로 포함되는 닉네임이 있는가
    private static boolean isLetterWordsInAlreadyExistsNicknames(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            for (List<String> user : users) {
                String alreadyExistsNickname = user.get(Constants.NICKNAME);
                if (alreadyExistsNickname.contains(nickname.substring(i, i + 2))) {
                    // 이미 존재하는 닉네임이라면 users 안에 있는 이메일도 result 에 저장해야함
                    ifAlreadyExistsEmailInResultAndSave(user);
                    return true;
                }
            }
        }
        return false;
    }

    private static void ifAlreadyExistsEmailInResultAndSave(List<String> user) {
        if (!isAlreadyExistsEmailInResult(user.get(Constants.EMAIL))) {
            result.add(user.get(Constants.EMAIL));

        }
    }

    private static boolean isAlreadyExistsEmailInResult(String email) {
        for (String alreadyExistsEmail : result) {
            if (Objects.equals(alreadyExistsEmail, email)) {
                return true;
            }
        }
        return false;
    }

    private static void sortList() {
        Collections.sort(result);
    }
}