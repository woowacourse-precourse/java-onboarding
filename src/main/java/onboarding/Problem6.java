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

        Map<String, Integer> stringsOfLength2Cnt = getStringsOfLength2Cnt(forms);

        Set<String> stringsOfLength2 = stringsOfLength2Cnt.keySet();
        for(List<String> crew : forms){
            String nickname = crew.get(1);
            for(String str : stringsOfLength2){
                if(stringsOfLength2Cnt.get(str) > 1 && nickname.contains(str)){
                    invalidNickNames.add(nickname);
                }
            }
        }

        return invalidNickNames;
    }

    public static Map<String, Integer> getStringsOfLength2Cnt(List<List<String>> forms){
        Map<String, Integer> stringsOfLength2Cnt = new HashMap<>();

        for(List<String> crew : forms){
            String nickname = crew.get(1);
            Set<String> stringsOfLength2 = splitNickname(nickname);
            for(String str : stringsOfLength2){
                stringsOfLength2Cnt.put(str, stringsOfLength2Cnt.getOrDefault(str, 0)+1);
            }
        }

        return stringsOfLength2Cnt;
    }

    public static Set<String> splitNickname(String nickname){
        Set<String> stringsOfLength2 = new HashSet<>();

        for(int i = 0;i<nickname.length()-1;i++){
            stringsOfLength2.add(nickname.substring(i, i+2));
        }

        return stringsOfLength2;
    }

    public static List<String> getEmailsOfInvalidNickname(List<List<String>> forms, List<String> invalidNicknames){
        List<String> emailsOfInvalidNickname = new ArrayList<>();

        for(List<String> crew : forms){
            String email = crew.get(0);
            String nickname = crew.get(1);
            if(invalidNicknames.contains(nickname) && !emailsOfInvalidNickname.contains(nickname)){
                emailsOfInvalidNickname.add(email);
            }
        }

        Collections.sort(emailsOfInvalidNickname);

        return emailsOfInvalidNickname;
    }
}
