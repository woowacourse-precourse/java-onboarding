package onboarding;

import java.util.*;

public class Problem6 {

    private static List<String> pairedWords = new ArrayList<>(); // 두개씩 닉네임을 짝지어서 저장하는 리스트
    private static Set<String> duplicate = new HashSet<>(); // 중복을 저장하는 리스트

    public static List<String> solution(List<List<String>> forms) {
        if (!isValidCrewSize(forms.size())) {
            return Collections.emptyList();
        }

        for (int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            if (!isValidNicknameRange(nickname) || isValidNicknameFormat(nickname) || !isValidEmailRange(email) || !isValidEmailFormat(email)) {
                return Collections.emptyList();
            }
        }

        List<String> pairedString = pairNicknameByTwo(forms);
        return isDuplicated(forms, pairedString);
    }

    private static boolean isValidCrewSize(int size) {
        return size >= 1 && size <= 10000;
    }

    private static boolean isValidNicknameRange(String nickname) {
        return nickname.length() >= 1 && nickname.length() < 20;
    }

    private static boolean isValidNicknameFormat(String nickname) {
        return nickname.matches("^[ㄱ-ㅎ가-힣]*$ ");
    }

    private static boolean isValidEmailRange(String email) {
        return email.length() >= 11 && email.length() < 20;
    }

    private static boolean isValidEmailFormat(String email) {
        int index = email.indexOf('@');
        String format = email.substring(index + 1);
        return format.equals("email.com");
    }

    private static List<String> pairNicknameByTwo(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            String nickname = forms.get(i).get(1);
            for (int j = 0; j < nickname.length() - 1; j++) {
                pairedWords.add(nickname.substring(j, j + 2));
            }
        }
        return pairedWords;
    }

    private static List<String> isDuplicated(List<List<String>> forms, List<String> pairedWords) {
        for (int i = 0; i < forms.size(); i++) {
            String preEmail = forms.get(i).get(0);
            for (int j = i + 1; j < forms.size(); j++) {
                String nextEmail = forms.get(j).get(0);
                String nextNickname = forms.get(j).get(1);
                for (String word : pairedWords) {
                    if (nextNickname.contains(word)) {
                        duplicate.add(preEmail);
                        duplicate.add(nextEmail);
                        break;
                    }
                    break;
                }
            }
            break;
        }
        List<String> answer = new ArrayList<>(duplicate);
        Collections.sort(answer);
        return answer;
    }
}
