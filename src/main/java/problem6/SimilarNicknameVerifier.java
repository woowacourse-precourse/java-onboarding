package problem6;

import problem1.Page;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimilarNicknameVerifier {

    private final Set<String> caughtEmails = new HashSet<>();
    private final List<List<String>> forms;
    public SimilarNicknameVerifier(List<List<String>> forms) {
        Validator.validate(forms);
        this.forms = forms;
        verify();
    }

    private void verify() {
        for (int i = 0; i < forms.size(); i++) {
            catchSimilar(forms.get(i), i);
        }
    }

    private void catchSimilar(List<String> form, int position) {
        for (int i = 0; i < position; i++) {
            catchSimilar(forms.get(i), form);
        }
    }

    private void catchSimilar(List<String> otherForm, List<String> myForm) {
        String myNickname = myForm.get(1);
        String otherNickname = otherForm.get(1);

        if (isSimilar(myNickname, otherNickname)) {
            caughtEmails.add(myForm.get(0));
            caughtEmails.add(otherForm.get(0));
        }
    }

    private boolean isSimilar(String myNickname, String otherNickname) {
//        return Stream.iterate(0, i -> i + 1).limit(myNickname.length() - 1)
//                .map(i -> myNickname.substring(i, i + 2))
//                .anyMatch(substr -> otherNickname.contains(substr));
        return IntStream.range(0, myNickname.length() - 1)
                .mapToObj(i -> myNickname.substring(i, i + 2))
                .anyMatch(substr -> otherNickname.contains(substr));
//        for (int i = 0; i < myNickname.length() - 1; i++) {
//            if (otherNickname.contains(myNickname.substring(i, i + 2)))
//                return true;
//        }
//        return false;
    }


    public List<String> getEmails() {
        List<String> result = new ArrayList<>(caughtEmails);

        Collections.sort(result);

        return result;
    }

    public static class Validator {
        private static final int CREW_NUMBER_LOWER_BOUNDS = 1;
        private static final int CREW_NUMBER_UPPER_BOUNDS = 10000;
        private static final String ERR_CREW_NUMBER = "크루의 수는 1 이상 10,000 이하입니다.";
        private static final String ERR_EMAIL =  "올바르지 않은 이메일 형식입니다.";
        private static final String ERR_NICKNAME = "올바르지 않은 닉네임 형식입니다.";

        public static void validate(List<List<String>> forms) {
            validateCrewNumber(forms);
            validateCrewInfo(forms);
        }

        private static void validateCrewNumber(List<List<String>> forms) {
            if (forms.size() < CREW_NUMBER_LOWER_BOUNDS
                    || forms.size() > CREW_NUMBER_UPPER_BOUNDS) {
                throw new IllegalArgumentException(ERR_CREW_NUMBER);
            }
        }

        private static void validateCrewInfo(List<List<String>> forms) {
            for (List<String> crew : forms) {
                validateEmail(crew.get(0));
                validateNickname(crew.get(1));
            }
        }

        private static void validateEmail(String email) {
            Pattern emailPattern = Pattern.compile("^[a-zA-z0-9]{1,9}@email\\.com$");
            Matcher matcher = emailPattern.matcher(email);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(ERR_EMAIL);
            }
        }

        private static void validateNickname(String nickname) {
            Pattern nicknamePattern = Pattern.compile("^[가-힣]{1,19}$");
            Matcher matcher = nicknamePattern.matcher(nickname);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(ERR_NICKNAME);
            }
        }
    }
}
