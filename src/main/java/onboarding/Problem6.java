package onboarding;

import java.util.*;

/*
 * 기능 구현사항
 * 1. 한글 문자열을 2칸단위로 해쉬값에 저장하고 값을 늘리는 기능
 * 2. 문자열의 해쉬값에 대응되는 값이 1보다 크다면  TreeSet에 담아 중복제거거와 정렬 수행
 * 3. 첫먼째 문자열을 다시 확인해서 해쉬값이 1보다 크다면 첫번째 문자열도 넣는 기능
 *
 * */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        TreeSet<String> emails = new TreeSet<>();
        setHash(forms, emails);
        return new ArrayList<String>(emails);
    }

    static void setHash(List<List<String>> forms, TreeSet<String> emails) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (List<String> form : forms) {
            for (int i = 0; i < form.get(1).length() - 1; i++) {
                String s = String.valueOf((form.get(1).charAt(i))) + String.valueOf((form.get(1).charAt(i + 1)));
                if(hashMap.get(s) == null) hashMap.put(s, 1);
                else hashMap.put(s, hashMap.get(s) + 1);
                if(hashMap.get(s) > 1) addEmail(form.get(0), emails);
            }
        }
        checkFirst(forms.get(0).get(1),forms.get(0).get(0), hashMap, emails );

    }

    static void addEmail(String email, TreeSet<String> emails) {
        emails.add(email);
    }

    static void checkFirst(String name, String email, HashMap<String, Integer> hashMap, TreeSet<String> emails  ) {
        for (int i = 0; i < name.length() - 1; i++) {
            String s = String.valueOf(name.charAt(i)) + String.valueOf(name.charAt(i + 1));
            if(hashMap.get(s) > 1) addEmail(email, emails);
        }
    }

}

