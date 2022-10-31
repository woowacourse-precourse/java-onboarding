package onboarding;

import java.util.*;

public class Problem6 {
    private static final int MIN_CREW_COUNT = 1;
    private static final int MAX_CREW_COUNT = 10000;
    private static final int MIN_EMAIL_LENGTH = 11;
    private static final int MAX_EMAIL_LENGTH = 19;
    private static final String DOMAIN = "email.com";
    private static final int MIN_NICKNAME_LENGTH = 1;
    private static final int MAX_NICKNAME_LENGTH = 19;
    private static final String NAME_REG = "^[가-힣]*$";

    private static final int FORM_EMAIL = 0;
    private static final int FORM_NICKNAME = 1;
    private static List<String> answer = new ArrayList<>();
    private static List<Set<String>> partsOfNicknameList = new ArrayList<>();
    private static Map<String, Integer> nicknameAndCountMap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        checkException(forms);
        setupData(forms);
        getAnswer(forms);
        Collections.sort(answer);
        return answer;
    }

    public static void checkException(List<List<String>> forms) {
        if(!isValidCrewRange(forms))
            throw new IllegalArgumentException("크루원은 1명 이상 10,000명 이하입니다.");

        if(!isValidEmailLength(forms))
            throw new IllegalArgumentException("이메일의 유효 길이는 11~19자입니다.");

        if(!isValidDomain(forms))
            throw new IllegalArgumentException("신청 가능한 이메일의 도메인은 [email.com] 입니다.");

        if(!isValidNicknameRegex(forms))
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");

        if(!isValidNicknameLength(forms))
            throw new IllegalArgumentException("닉네임의 유효 길이는 1~19자입니다.");
    }

    public static boolean isValidCrewRange(List<List<String>> forms) {
        return forms.size() >= MIN_CREW_COUNT && forms.size() <= MAX_CREW_COUNT;
    }

    public static boolean isValidEmailLength(List<List<String>> forms) {
        return forms.stream().allMatch(form -> form.get(FORM_EMAIL).length() >= MIN_EMAIL_LENGTH && form.get(FORM_EMAIL).length() <= MAX_EMAIL_LENGTH);
    }

    public static boolean isValidDomain(List<List<String>> forms) {
        return forms.stream().allMatch(form -> form.get(FORM_EMAIL).contains(DOMAIN));
    }

    public static boolean isValidNicknameRegex(List<List<String>> forms) {
        return forms.stream().allMatch(form -> form.get(FORM_NICKNAME).matches(NAME_REG));
    }

    public static boolean isValidNicknameLength(List<List<String>> forms) {
        return forms.stream().allMatch(form -> form.get(FORM_NICKNAME).length() >= MIN_NICKNAME_LENGTH && form.get(FORM_NICKNAME).length() <= MAX_NICKNAME_LENGTH);
    }

    public static void getAnswer(List<List<String>> forms) {
        for (int i = 0; i < partsOfNicknameList.size(); i++) {
            if (partsOfNicknameList.get(i).stream().anyMatch(part -> nicknameAndCountMap.get(part) > 1)) {
                answer.add(forms.get(i).get(FORM_EMAIL));
            }
        }
    }

    public static void setupData(List<List<String>> forms) {
        forms.stream()
                .map(form -> nicknameDecomposition(form.get(FORM_NICKNAME)))
                .forEach(parts -> {
                    partsOfNicknameList.add(parts);
                    parts.forEach(part -> nicknameAndCountMap.put(part, nicknameAndCountMap.getOrDefault(part, 0) + 1));
                });
    }

    public static Set<String> nicknameDecomposition(String nickname) {
        Set<String> separatedNickname = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            separatedNickname.add(nickname.substring(i, i + 2));
        }
        return separatedNickname;
    }
}
