package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    private static List<String> duplicateNicknames;
    private static List<String> answer;
    private static RememberDto rememberDto;

    public static List<String> solution(List<List<String>> forms) {
        initSystem(forms);
        checkNicknameInForms(forms);
        return getSortedAnswer(answer);
    }

    private static void initSystem(List<List<String>> forms) {
        validateFormat(forms);
        rememberDto = new RememberDto();
        duplicateNicknames = new ArrayList<>();
        duplicateNicknames.add(forms.get(0).get(1));
        answer = new ArrayList<>();
        answer.add(forms.get(0).get(0));
    }

    private static void validateFormat(List<List<String>> forms) {
        for(List<String> crew : forms) {
            if(!crew.get(0).contains("@email.com")) {
                throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
            }
        }
    }

    private static void checkNicknameInForms(List<List<String>> forms) {
        for (int i = 1; i < forms.size(); i++) {
            if (isDuplicateNicknamesContainsNickname(forms.get(i))) {
                answer.add(forms.get(i).get(0));
            }
            duplicateNicknames.add(forms.get(i).get(1));
        }
    }

    private static boolean isDuplicateNicknamesContainsNickname(List<String> crew) {
        String email = crew.get(0);
        String nickname = crew.get(1);

        for (String duplicateNickname : duplicateNicknames) {
            if (duplicateNickname.length() == 1) {
                continue;
            }

            for (int i = 0; i < nickname.length() - 1; i++) {
                String check = nickname.substring(i, i + 2);
                if (rememberDto.nickname.contains(check)) {
                    answer.add(rememberDto.email);
                    rememberDto = new RememberDto();
                    return true;
                }
                if (duplicateNickname.contains(check)) {
                    return true;
                }
            }
        }
        rememberDto.rememberCrew(email, nickname);
        return false;
    }

    private static List<String> getSortedAnswer(List<String> answer) {
        if (answer.size() == 1) {
            answer.remove(0);
            return answer;
        }

        return answer.stream().sorted().collect(Collectors.toList());
    }

    public static class RememberDto {
        private String email;
        private String nickname;

        public RememberDto() {
            this.email = "";
            this.nickname = "";
        }

        public void rememberCrew(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }
    }
}
