package onboarding;

import java.util.*;

public class Problem6 {

    static Map<String, Integer> mymap = new HashMap<>();

    public static List<String> solution(List<List<String>> forms) {
        return pro(forms);
    }

    static List<String> pro(List<List<String>> forms) {
        List<String> answer;

        for(int i = 0; i < forms.size(); i++) {
            addTwoLetters(forms.get(i).get(1), i);
        }

        answer = getEmailList(forms);

        Collections.sort(answer);

        return answer;
    }

    static List<String> getEmailList(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();

        for(List<String> form : forms) {
            String nickname = form.get(1);
            String email = form.get(0);
            for(int i = 0; i < nickname.length() - 1; i++) {
                String str = nickname.substring(i, i + 2);
                if(mymap.get(str) > 1) {
                    emailList.add(email);
                    break;
                }
            }
        }
        return emailList;
    }

    // 문자열을 두 글자씩 조합
    static void addTwoLetters(String nickname, int idx) {
        for(int i = 0; i < nickname.length() - 1; i++) {
            String s = nickname.substring(i, i + 2);
            add(s, idx);
        }
    }

    // 닉네임에 특정 문자열이 포함되이 있는 경우에 크루의 인덱스를 추가
    static void add(String letters, int idx) {
        mymap.put(letters, (mymap.getOrDefault(letters, 0) + 1));
    }

}
