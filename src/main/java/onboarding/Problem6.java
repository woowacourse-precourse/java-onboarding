package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        List<String> invalidNicknames = getInvalidNicknames(forms);
        answer = getEmailsOfInvalidNickname(forms, invalidNicknames);

        return answer;
    }

    public static List<String> getInvalidNicknames(List<List<String>> forms){
        List<String> invalidNickNames = new ArrayList<>();

        return invalidNickNames;
    }

    public static Map<String, Integer> getStringsOfLength2Cnt(List<List<String>> forms){
        Map<String, Integer> stringsOfLength2Cnt = new HashMap<>();

        return stringsOfLength2Cnt;
    }

    public static List<String> getEmailsOfInvalidNickname(List<List<String>> forms, List<String> invalidNicknames){
        List<String> emailsOfInvalidNickname = new ArrayList<>();

        return emailsOfInvalidNickname;
    }
}
