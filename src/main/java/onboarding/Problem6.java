package onboarding;

import java.util.*;

public class Problem6 {
    public static final int EMAIL_IDX = 0;
    public static final int NICKNAME_IDX = 1;

    public static List<String> solution(List<List<String>> forms) {
        validateCrewNumber(forms);

        Set<String> emailSet = new HashSet<>();
        getSimilarNicknameCrewEmail(forms, emailSet);

        List<String> answer = new ArrayList<>(emailSet);
        Collections.sort(answer);
        return answer;
    }

    private static void getSimilarNicknameCrewEmail(List<List<String>> forms, Set emailSet) {
        HashMap<String, List<Integer>> similarNicknameMap = new HashMap<>();

        for (int crewIdx = 0; crewIdx <= forms.size() - 1; crewIdx++) {
            String nickname = forms.get(crewIdx).get(NICKNAME_IDX);

            for (int charIdx = 0; charIdx <= nickname.length() - 2; charIdx++) {
                char[] charArray = {nickname.charAt(charIdx), nickname.charAt(charIdx + 1)};
                String continuous = String.valueOf(charArray);

                getSimilarNicknameMap(similarNicknameMap, crewIdx, continuous);
            }
        }

        getEmailSet(forms, emailSet, similarNicknameMap);
    }

    private static void getSimilarNicknameMap(HashMap<String, List<Integer>> similarNicknameMap, int crewIdx, String continuous) {
        if (similarNicknameMap.containsKey(continuous)) {
            similarNicknameMap.get(continuous).add(crewIdx);
        } else {
            similarNicknameMap.put(continuous, new ArrayList<>(List.of(crewIdx)));
        }
    }

    private static void getEmailSet(List<List<String>> forms, Set emailSet, HashMap<String, List<Integer>> similarNicknameMap) {
        Iterator<String> iterator = similarNicknameMap.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            List<Integer> crewIndices = similarNicknameMap.get(key);

            if (crewIndices.size() >= 2) {
                for (int crewIdx : crewIndices) {
                    String email = forms.get(crewIdx).get(EMAIL_IDX);
                    validateEmailFormat(email);
                    validateEmailLength(email);

                    emailSet.add(email);
                }
            }
        }
    }

    private static void validateCrewNumber(List<List<String>> forms) {
        if (forms.size() == 0 || forms.size() > 10000) {
            throw new IllegalArgumentException("크루는 1명 이상 10000명 이하여야 합니다.");
        }
    }

    private static void validateEmailFormat(String email) {
        String[] splitEmail = email.split("@");

        if (splitEmail[1].equals("email.com") == false) {
            throw new IllegalArgumentException("이메일의 도메인은 email.com으로만 제합됩니다.");
        }
    }

    private static void validateEmailLength(String email) {
        if (email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 미만이여야 합니다.");
        }
    }
}
