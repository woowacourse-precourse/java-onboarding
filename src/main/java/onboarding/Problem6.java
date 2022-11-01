package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * 1. 제약사항 확인
 *   -> 1) forms 길이 체크 (1~10000 인지 확인)
 *   -> 2) 이메일 형식 체크 + 닉네임 길이 체크 + 닉네임 한글만 있는지 체크
 *       =>@뒤에 email.com 이 오는지 + 이메일 길이가 11~20인지 + 닉네임 길이가 1~20 인지 확인 + 유니코드로 가 ~ 힣까지 범위 체크
 * 2. 로직 생각
 *   -> 1)   (1) 모든 단어를 돌면서 길이가 2인 패턴을 찾음 (n)개 ( 2이상을 찾을 필요가 없는 이유 : 어차피 3, 4에도 2가 포함되어있음)
 *               HashSet을 3개 선언(전체 패턴, 중복패턴, 찾고있는 단어의 패턴)
 *               찾고있는 단어의 패턴에 모든 패턴을 넣은 후 전체패턴과 겹치는 것이 있는지 확인 겹칠 경우 중복 패턴에 추가
 *
 *   -> 2) 중복패턴에 저장된 패턴을 kmp알고리즘으로 패턴을 체크함
 *       => kmp : O(N)
 */
public class Problem6 {

    private static final String EMAIL_PATTERN = "email.com";

    public static List<String> solution(List<List<String>> forms) {
        validate(forms);

        List<String> answer = Result.getResult(new Pattern(forms), forms);
        return answer;
    }

    private static void validate(final List<List<String>> forms) {
        Advice.validate(forms);
    }

    static class Result{
        private Result(){}
        public static List<String> getResult(Pattern pattern, List<List<String>> forms) {
            List<String> emailsList = new ArrayList<>(pattern.getOverlapEmails(forms));
            Collections.sort(emailsList);
            return emailsList;
        }

    }

    static class Pattern{
        private Set<String> pattern;

        public Pattern() {
            this(new HashSet<>());
        }

        public Pattern(Set<String> pattern) {
            this.pattern = pattern;
        }

        public Pattern(List<List<String>> forms) {
            this.pattern = findPattern(forms);
        }

        private Set<String> findPattern(List<List<String>> forms) {
            Set<String> allPattern = new HashSet<>();
            Set<String> overlapPattern = new HashSet<>();
            for (List<String> form : forms) {
                overlapPattern = findPattern(allPattern, overlapPattern, form);
            }
            return overlapPattern;
        }

        private Set<String> findPattern(Set<String> allPattern, Set<String> overlapPattern, List<String> form) {
            if (form.get(1).length() == 1) {
                return overlapPattern;
            }
            overlapPattern = findPatternByWord(allPattern, overlapPattern, form.get(1));
            return overlapPattern;
        }

        private Set<String> findPatternByWord(Set<String> allPattern,Set<String> overlapPattern, String word) {
            Set<String> wordPatterns = new HashSet<>();
            for (int j = 0; j < word.length() - 1; j ++ ) {
                String subWord = word.substring(j, j + 2);
                wordPatterns.add(subWord);
            }
            return addPatternFromHashSet(allPattern, overlapPattern, wordPatterns);
        }

        private Set<String> addPatternFromHashSet(Set<String> allPattern,Set<String> overlapPattern, Set<String> wordPatterns) {
            for (String wordPattern : wordPatterns) {
                checkIfOverlapPattern(allPattern, overlapPattern, wordPattern);
            }
            return overlapPattern;
        }

        private static void checkIfOverlapPattern(Set<String> allPattern, Set<String> overlapPattern, String wordPattern) {
            if (allPattern.contains(wordPattern)) {
                overlapPattern.add(wordPattern);
            }
            allPattern.add(wordPattern);
        }

        public Set<String> getOverlapEmails(List<List<String>> forms) {
            Set<String> emails = new HashSet<>();
            for (String pattern : this.pattern) {
                getKmpTableByPattern(forms, emails, pattern);
            }
            return emails;
        }

        private void getKmpTableByPattern(List<List<String>> forms, Set<String> emails, String pattern) {
            int[] kmpTable = makeKmpTable(pattern);
            for (List<String> form : forms) {
                if (form.get(1).length() != 1 && doKMP(form.get(1), pattern, kmpTable)) {
                    emails.add(form.get(0));
                }
            }
        }

        private int[] makeKmpTable(String pattern){
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

        private Boolean doKMP(String nickname, String pattern, int[] kmpTable){
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

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pattern pattern1 = (Pattern)o;
            return Objects.equals(pattern, pattern1.pattern);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pattern);
        }

        @Override
        public String toString() {
            return "Pattern{" +
                "pattern=" + pattern +
                '}';
        }
    }


    static class Advice{
        private static final char KOREAN_START = "가".charAt(0);
        private static final char KOREAN_FINAL = "힣".charAt(0);

        private Advice(){}

        public static void validate(final List<List<String>> forms) {
            checkInputDataLength(forms);
            for (List<String> form : forms) {
                checkEmailValidation(form.get(0));
                checkEmailLength(form.get(0));
                checkNicknameLength(form.get(1));
                checkNicknameIsKorean(form.get(1));
            }
        }
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
