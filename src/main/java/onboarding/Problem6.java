package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1. 제약사항 확인
 *   -> 1) forms 길이 체크 (1~10000 인지 확인)
 *   -> 2) 이메일 형식 체크 + 닉네임 길이 체크 + 닉네임 한글만 있는지 체크
 *       =>@뒤에 email.com 이 오는지 + 이메일 길이가 11~20인지 + 닉네임 길이가 1~20 인지 확인 + 유니코드로 가 ~ 힣까지 범위 체크
 * 2. 로직 생각
 *   -> 1) (1) split로 분리 후 전체 순회하면서 indexof로 최초로 같은 인넥스를 찾아서 거기서 부터 얼마만큼 길이가 같은지 체 2개, 3개, 4개... 따로 넣기
 *          ex) 제이엠호 제이엠슨 제이엠 이제엠 이엠슨지조리
 *              제이, 제이엠, 이엠슨, 이엠 이 패턴이 나올 수 있음
 *              => 10,000 * 20 * 10,000 ???
 *
 *         (2) 모든 단어를 돌면서 길이가 2,3,4,... 까지 모든 패턴을 만듦 (n-1)n / 2 개
 *             HashSet을 선언 후 add 하는데 그 대 Contains해서 이미 있는 패턴이면 다른 HashSet에 담아줌 (add, contains -> O(1)
 *             => 최악의 경우 10000 * 20 * 19 라서 위 1번보다는 시간이 적게 들 것이라 예상
 *   -> 2) 중복없이 저장된 패턴을 kmp알고리즘으로 패턴을 체크함
 *       => kmp : O(N) , 중복없이 저장된 패턴을 순회하며 일치찾기? O(N) O(N^2)일거같은데.... 일단 구현해보자
 */
public class Problem6 {

    private static final String EMAIL_PATTERN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        validate(forms);
        List<String> answer = new ArrayList<>(getOverlapEmailsByNickname(findPattern(forms), forms));
        Collections.sort(answer);

        return answer;
    }
    public static Set<String> getOverlapEmailsByNickname(Set<String> overlapPattern, List<List<String>> forms) {
        Set<String> emails = new HashSet<>();
        for (String pattern : overlapPattern) {
            int[] kmpTable = makeKmpTable(pattern);
            for (List<String> form : forms) {
                if (form.get(1).length() != 1 && doKMP(form.get(1), pattern, kmpTable)){
                    emails.add(form.get(0));
                }
            }
        }

        return emails;
    }

    public static int[] makeKmpTable(String pattern){
        int patternLength = pattern.length();
        int[] kmpTable = new int[patternLength];

        int count = 0;
        for (int i = 1; i < patternLength; i++) {
            while (count > 0 && pattern.charAt(i) != pattern.charAt(count)) {
                count = kmpTable[count - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(count)) {
                count += 1;
                kmpTable[i] = count;
            }
        }
        return kmpTable;
    }
    public static Boolean doKMP(String nickname, String pattern, int[] kmpTable){
        int nicknameLen = nickname.length();
        int patternLen = pattern.length();

        int count = 0;
        for (int i = 0; i < nicknameLen; i++) {
            while (count > 0 && nickname.charAt(i) != pattern.charAt(count)) {
                count = kmpTable[count - 1];
            }
            if (nickname.charAt(i) == pattern.charAt(count)) {
                if (count == patternLen - 1) {
                    return true;
                }
                count += 1;
            }
        }
        return false;
    }

    public static Set<String> findPattern(List<List<String>> forms) {
        Set<String> allPattern = new HashSet<>();
        Set<String> overlapPattern = new HashSet<>();
        for (List<String> form : forms) {
            if (form.get(1).length() == 1) {
                continue;
            }
            findPatternByWord(allPattern, overlapPattern, form.get(1));
        }

        return overlapPattern;
    }
    public static void findPatternByWord(Set<String> allPattern, Set<String> overlapPattern, String word) {
        for (int i = 2; i <= word.length(); i ++ ) {
            for (int j = 0; j <= word.length() - i; j ++ ) {
                String subWord = word.substring(j, j + i);
                addPatternToHashSet(allPattern, overlapPattern, subWord);
            }
        }
    }

    private static void addPatternToHashSet(Set<String> allPattern, Set<String> overlapPattern, String subWord) {
        if (allPattern.contains(subWord)) {
            overlapPattern.add(subWord);
        }
        allPattern.add(subWord);
    }

    private static void validate(final List<List<String>> forms) {
        validateInputData(forms);
        validateEmailAndNickname(forms);
    }

    private static void validateInputData(final List<List<String>> forms){
        Advice.checkInputDataLength(forms);
    }

    private static void validateEmailAndNickname(final List<List<String>> forms) {
        for (List<String> form : forms) {
            Advice.checkEmailValidation(form.get(0));
            Advice.checkEmailLength(form.get(0));
            Advice.checkNicknameLength(form.get(1));
            Advice.checkNicknameIsKorean(form.get(1));
        }
    }


    static class Advice{
        private static final char KOREAN_START = "가".charAt(0);
        private static final char KOREAN_FINAL = "힣".charAt(0);

        private Advice(){}
        public static void checkInputDataLength(final List<List<String>> forms) {
            if (forms.size() < 1 || forms.size() > 10000) {
                throw new IllegalArgumentException();
            }
        }

        public static void checkEmailValidation(final String email) {
            if (!EMAIL_PATTERN.equals(email.substring(email.indexOf("@") + 1))) {
                throw new IllegalArgumentException();
            }
        }

        public static void checkEmailLength(final String email) {
            if (email.length() < 11 || email.length() > 20) {
                throw new IllegalArgumentException();
            }
        }

        public static void checkNicknameLength(final String nickname) {
            if (nickname.length() < 1 || nickname.length() > 20) {
                throw new IllegalArgumentException();
            }
        }

        public static void checkNicknameIsKorean(final String nickname) {
            for (String str : nickname.split("")) {
                if (str.charAt(0) < KOREAN_START || str.charAt(0) > KOREAN_FINAL) {
                    throw new IllegalArgumentException();
                }
            }
        }

    }
}
