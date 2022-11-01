package onboarding;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

public class Problem6 {
    static int forms_length;
    static int name_length;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        forms_length = forms.size();

        try{
            constraint6(forms);
        }catch(Exception e){
            System.out.println("Problem6 exception : " + e.getMessage());
            return answer;
        }

        HashSet<String> emails = new HashSet<>();
        Map<String, String> keywords = new HashMap<>();

       
        for (int i = 0; i < forms_length; i++) {
            String name = forms.get(i).get(1);
            if(!validate_nickname(name)) continue;

            for (int j = 0; j < name_length - 1; j++) {
                String key = name.substring(j, j + 2);
                String email = forms.get(i).get(0);

                if(!validate_email(email)) continue;

                if (keywords.containsKey(key)) {
                    String key_email = keywords.get(key);
                    if (!key_email.equals(email)) {
                        emails.add(key_email);
                        emails.add(email);
                    }
                }
                keywords.put(key, email);
            }
        }

        answer = emails.stream().sorted().collect(Collectors.toList());

        return answer;
    }
    //리스트의 제한사항을 검사하는 constraint
    static void constraint6(List<List<String>> forms) throws Exception {
        if (forms_length < 1 || forms_length >10000) {
            throw new Exception("크루는 1명 이상 10,000명 이하이어야 합니다.");
        }
    }
    //닉네임 요소의 제한사항을 검사하는 validate_nickname
    static boolean validate_nickname(String name) {
        name_length = name.length();
        if (name_length < 1 ||  name_length > 20) {
            System.out.println("닉네임은 길이는 1자 이상 20자 미만이어야 한다.");
            return false;
        }
        boolean iskorean = Pattern.matches("^[ㄱ-ㅎ가-힣]*$", name);
        if (!iskorean) {
            System.out.println("닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이어야 한다.");
        return false;
        }
        return true;
    }
    //이메일 요소의 제한사항을 검사하는 validate_email
    static boolean validate_email(String key_email){
        int email_length = key_email.length();
        if (email_length < 10 ||  email_length > 20) {
            System.out.println("이메일 길이는 11자 이상 20자 미만이어야 한다");
            return false;
        }
        if (!key_email.contains("@email.com")){
            System.out.println("신청할 수 있는 이메일은 `email.com` 도메인으로만 제한됩니다.");
            return false;
        }
        return true;
    }
}