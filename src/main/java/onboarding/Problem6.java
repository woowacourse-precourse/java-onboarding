package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return memberLimit(forms)
                ? List.of()
                : formCheck(forms);
    }

    private static boolean memberLimit(List<List<String>> forms) {
        return forms.size() < 1 || forms.size() > 10000;
    }

    private static List<String> formCheck(List<List<String>> forms) {
        ArrayList<String> duplicatedMembers = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            String email1 = forms.get(i).get(0);
            String nickName1 = forms.get(i).get(1);

            if (emailValidation(email1) || nickNameValidation(nickName1))
                return List.of();

            for (int j = i + 1; j < forms.size(); j++) {
                String email2 = forms.get(j).get(0);
                String nickName2 = forms.get(j).get(1);
                if(duplicatedLetter(nickName1, nickName2)) {
                    duplicatedMembers.add(email1);
                    duplicatedMembers.add(email2);
                }
            }
        }

        return duplicatedMembers.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    private static boolean emailValidation(String email) {
        return email.length() >= 20 || email.length() < 11 || !email.matches("^\\w+@email\\.com$");
    }

    private static boolean nickNameValidation(String nickName) {
        return nickName.length() >= 20 || nickName.length() < 1 || !nickName.matches("^[가-힣]+$") || nickName.matches("^[가-힣]*([가-힣])\\1[가-힣]*$");
    }

    private static boolean duplicatedLetter(String nickName1, String nickName2) {
        for (int i = 0; i < nickName1.length() - 1; i++) {
            String twoCharacter = nickName1.substring(i, i + 2);
            if(nickName2.contains(twoCharacter))
                return true;
        }
        return false;
    }
}
