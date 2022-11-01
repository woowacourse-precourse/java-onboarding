package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> list = new ArrayList<>(List.of());
        if(forms.size() < 1 || forms.size() > 10000){
            return list;
        }
        if(nameException(forms) || emailException(forms)){
            return list;
        }
        for(int i = 0; i < forms.size(); i++){
            String nickname1 = forms.get(i).get(1);
            for(int j = i+1; j < forms.size(); j++){
                String nickname2 = forms.get(j).get(1);
                if(checkDuplicate(nickname1, nickname2)){
                    list.add(forms.get(i).get(0));
                    list.add(forms.get(j).get(0));
                }
            }
        }
        List<String> answer = printEmail(list);
        return answer;
    }

    public static boolean emailException(List<List<String>> forms) {
        for(int i = 0; i < forms.size(); i++) {
            String email = forms.get(i).get(0);
            if(email.length() < 11 || email.length() >= 20 || !isValidEmail(email)){
                return true;
            }
        }
        return false;
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches()) return true;
        return false;
    }

    public static boolean nameException(List<List<String>> forms){
        String regExp = "^[가-힣]*$";
        for(int i = 0; i < forms.size(); i++) {
            String name = forms.get(i).get(1);
            if(!name.matches(regExp) || name.length() < 1 || name.length() >= 20){
                return true;
            }
        }
        return false;
    }

    public static List<String> printEmail(List<String> list) {
        // 중복 제거
        Set<String> set = new HashSet<>(list);
        List<String> answer = new ArrayList<>(set);
        // 오름차순 정렬
        Collections.sort(answer);
        return answer;
    }

    private static boolean checkDuplicate(String n1, String n2) {
        for(int i = 0; i < n1.length(); i++){
            char ch1 = n1.charAt(i);
            for(int j = 0; j < n2.length(); j++){
                char ch2 = n2.charAt(j);
                if(n1.length() > i+1 && n2.length() > j+1){
                    if(ch1 == ch2 && n1.charAt(i+1) == n2.charAt(j+1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
