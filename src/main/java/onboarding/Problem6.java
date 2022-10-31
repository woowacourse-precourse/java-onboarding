package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static Map<String, String> listToMap(List<List<String>> forms) {
        Map<String, String> formsMap = new HashMap<>();
        for(List<String> form: forms) {
            formsMap.put(form.get(1), form.get(0));
        }
        return formsMap;
    }

    public static List<String> validateEmailPattern(Map<String, String> forms) {

        String emailRegex = "/^[0-9a-zA-Z-_]{1,9}@email.com/&";
        Pattern emailPattern = Pattern.compile(emailRegex);

        List<String> emailList = (List<String>) forms.values();
        List<String> invalidEmailList = new ArrayList<>();

        for(String email : emailList) {
            Matcher matching = emailPattern.matcher(email);
            if(!matching.matches())
                invalidEmailList.add(email);
        }
        return invalidEmailList;
    }

}