package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public static Map<String, List<String>> repository = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        Validator.isValidate(forms);
        addSplitNicknameToMap(forms);
        List<String> overlapList = getOverlapList();
        return handleResult(overlapList);
    }

    /** 문자열을 2단어씩 잘라서 Map 에 추가
     */
    private static void addSplitNicknameToMap(List<List<String>> forms){
        final int EMAIL_IDX = 0;
        final int NICKNAME_IDX = 1;
        forms.forEach(form -> {
            String nickname = form.get(NICKNAME_IDX);
            IntStream.range(0, nickname.length() - 1)
                    .mapToObj(i -> nickname.substring(i, i + 2))
                    .forEach(subWord -> {
                        List<String> list = repository.getOrDefault(subWord, new ArrayList<>());
                        list.add(form.get(EMAIL_IDX));
                        repository.put(subWord, list);
                    });
        });
    }

    private static List<String> getOverlapList(){
        final int MIN_OVERLAP_COUNT = 2;
        return repository.values().stream()
                .filter(list -> list.size() >= MIN_OVERLAP_COUNT) // 중복되는 단어가 있는 경우
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<String> handleResult(List<String> list){
        return list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    static class Validator{
        public static boolean isValidate(List<List<String>> forms){
            try {
                isCorrectCrewSize(forms);
                isCorrectEmailForm(forms);
                isCorrectEmailSize(forms);
                isCorrectNickname(forms);
                return true;
            } catch (Exception error) {
                return false;
            }
        }

        private static void isCorrectCrewSize(List<List<String>> forms){
            final int MAX_SIZE = 10000;
            final int MIN_SIZE = 1;
            if (forms.size() < MIN_SIZE || forms.size() > MAX_SIZE){
                throw new IllegalArgumentException("Not correct crew size");
            }
        }

        private static void isCorrectEmailForm(List<List<String>> forms){
            final int EMAIL_IDX = 0;
            final int SPLIT_EMAIL_IDX = 2;
            final int CORRECT_SPLIT_COUNT = 3;
            List<String> emails = forms.stream()
                    .map(list -> list.get(EMAIL_IDX)) // 이메일 추출
                    .collect(Collectors.toList());
            emails.stream()
                    .map(email -> email.split("@"))
                    .forEach(split -> {
                        if (split.length != CORRECT_SPLIT_COUNT){
                            throw new IllegalArgumentException("'@' is should be one");
                        }
                        if (!split[SPLIT_EMAIL_IDX].equals("email.com")){
                            throw new IllegalArgumentException("domain should be 'email.com'");
                        }
                    });
        }

        private static void isCorrectEmailSize(List<List<String>> forms){
            final int EMAIL_IDX = 0;
            final int MIN_EMAIL_SIZE = 10;
            final int MAX_EMAIL_SIZE = 20;
            forms.stream().map(list -> list.get(EMAIL_IDX)).forEach(email -> {
                if (email.length() < MIN_EMAIL_SIZE || email.length() >= MAX_EMAIL_SIZE) {
                    throw new IllegalArgumentException("email length is not correct");
                }
            });
        }

        private static void isCorrectNickname(List<List<String>> forms){
            final int NICKNAME_IDX = 1;
            final int MIN_NICKNAME_SIZE = 1;
            final int MAX_NICKNAME_SIZE = 20;
            forms.stream().map(list -> list.get(NICKNAME_IDX)).forEach(nickname -> {
                if (nickname.length() < MIN_NICKNAME_SIZE || nickname.length() >= MAX_NICKNAME_SIZE){
                    throw new IllegalArgumentException("Nickname length is not correct");
                }
                if (!Pattern.compile("^[가-힣]*$").matcher(nickname).matches()){
                    throw new IllegalArgumentException("Nickname should be korean");
                }
            });
        }
    }
}
