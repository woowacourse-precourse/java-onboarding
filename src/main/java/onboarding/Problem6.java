package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    public static Map<String, List<String>> repository = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        Validator.isValidate(forms);
        addSplitNicknameToMap(forms);
        List<String> overlapResult = getOverlapResult();
        return processResult(overlapResult);
    }

    private static void addSplitNicknameToMap(List<List<String>> forms){
        for(List<String> form : forms){
            String nickname = form.get(1);
            for (int i = 0; i < nickname.length() - 1 ; i++) {
                String subWord = nickname.substring(i, i + 2);
                List<String> list = repository.getOrDefault(subWord, new ArrayList<>());
                list.add(form.get(0));  // add email
                repository.put(subWord, list);
            }
        }
//        forms.stream()
//                .map(form -> form.get(1))
//                .forEach(nickname -> {
//                    for (int i = 0; i < nickname.length() - 1 ; i++) {
//                        String subWord = nickname.substring(i, i + 2);
//                        repository.getOrDefault(subWord, new ArrayList<>()).add();
//                    });
    }

    private static List<String> getOverlapResult(){
        return repository.values().stream()
                .filter(list -> list.size() >= 2)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static List<String> processResult(List<String> list){
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
            if (forms.size() < 1 || forms.size() > 10000){
                throw new IllegalArgumentException("Not correct crew size");
            }
        }

        private static void isCorrectEmailForm(List<List<String>> forms){
            List<String> emails = forms.stream()
                    .map(list -> list.get(0)) // 이메일 추출
                    .collect(Collectors.toList());
            emails.stream()
                    .map(email -> email.split("@"))
                    .forEach(split -> {
                        if (split.length != 3){
                            throw new IllegalArgumentException("'@' is should be one");
                        }
                        if (!split[2].equals("email.com")){
                            throw new IllegalArgumentException("domain should be 'email.com'");
                        }
                    });
        }

        private static void isCorrectEmailSize(List<List<String>> forms){
            forms.stream().map(list -> list.get(0)).forEach(email -> {
                if (email.length() < 10 || email.length() >= 20) {
                    throw new IllegalArgumentException("email length is not correct");
                }
            });
        }

        private static void isCorrectNickname(List<List<String>> forms){
            forms.stream().map(list -> list.get(1)).forEach(nickname -> {
                if (nickname.length() < 1 || nickname.length() >= 20){
                    throw new IllegalArgumentException("Nickname length is not correct");
                }
                if (!Pattern.compile("^[가-힣]*$").matcher(nickname).matches()){
                    throw new IllegalArgumentException("Nickname should be korean");
                }
            });
        }

    }
}
