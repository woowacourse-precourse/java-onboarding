package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        try {
            List<String> emailList = setInit(forms, 0);
            List<String> nameList = setInit(forms, 1);

            verificationEmail(emailList);
            List<String> duplicateNameList = duplicateName(nameList);

            return getResult(forms, duplicateNameList);
        } catch (Exception error) {
            return (List<String>) error;
        }
    }

    private static List<String> getResult(List<List<String>> forms,
        List<String> duplicateNameList) {
        List<String> sortedList = new ArrayList<>();
        for (List<String> form : forms) {
            for (String duplicateName : duplicateNameList) {
                if (Objects.equals(form.get(1), duplicateName)) {
                    sortedList.add(form.get(0));
                }
            }
        }
        Collections.sort(sortedList);
        return sortedList;
    }

    public static List<String> setInit(List<List<String>> forms, int index) {
        List<String> initlist = new ArrayList<>();
        for (List<String> form : forms) {
            initlist.add(form.get(index));
        }

        return initlist;
    }

    public static void verificationEmail(List<String> forms) {
        String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@email.com";

        for (String form : forms) {
            if (!(Pattern.matches(emailPattern, form))) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<String> duplicateName(List<String> forms) {
        String nameString = "";
        List<String> duplicateNameList = new ArrayList<>();

        for (String form : forms) {
            nameString += form + " ";
        }

        for (String word : forms) {
            for (int i = 0; i < word.length(); i++) {
                if (i + 1 < word.length()) {
                    String duplication = word.substring(i, i + 2);
                    List<String> checkpattern = checkPattern(duplication, nameString, word);
                    if (checkpattern.size() > 0) {
                        duplicateNameList.addAll(checkpattern);
                    }
                }
            }
        }

        return duplicateNameList.stream().distinct().collect(Collectors.toList());
    }

    public static List<String> checkPattern(String duplication, String nameString, String word) {
        List<String> duplicationList = new ArrayList<>();
        String combinedWord = "[가-힣]*" + duplication + "[가-힣]*\\s{1}";
        Pattern pattern = Pattern.compile(combinedWord);
        Matcher matcher = pattern.matcher(nameString);

        while (matcher.find()) {
            duplicationList.add(matcher.group().trim());
        }
        duplicationList.remove(word);

        return duplicationList;
    }
}
