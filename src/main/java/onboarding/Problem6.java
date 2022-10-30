package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Map<String, String> users = new HashMap<>();
        HashSet<String> emails = new HashSet<>();

        for(int i=0; i< forms.size(); i++) {
            String email = forms.get(i).get(0);
            String nickname = forms.get(i).get(1);
            for(int j=0; j<nickname.length()-1; j++){
                String check1 = nickname.substring(j,j+2);
                if(!users.containsKey(check1)){
                    users.put(check1,email);
                } else{
                    emails.add(users.get(check1));
                    emails.add(email);
                }
            }
        }
        answer = emails.stream()
                .sorted()
                .collect(Collectors.toList());

        return answer;
    }
    // 이메일 유효성 체크
    public static boolean emailCheck(String email){
        // 11자 이상 20자 미만
        // 이메일 형식이 email.com 이 아닌 경우
        return email.length() >= 11 && email.length() < 20 && Pattern.matches("^[a-z0-9A-Z._-]*@[email]*.[com]*$",email);
    }
    // 닉네임 유효성 체크
    public static boolean nicknameCheck(String nickname){
        // 특수문자, 영어, 숫자 예외처리
        // 닉네임 길이는 1자 이상 20자 미만
        return nickname.length() >= 1 && nickname.length() < 20 && Pattern.matches("[가-힣]*$",nickname);
    }
}
