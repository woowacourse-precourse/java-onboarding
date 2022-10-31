package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        if (validation("crew_limit",forms.size())) {
            for (List<String> form : forms) {
                String email = form.get(0);
                String nickname = form.get(1);

                if (validation("email_valid", email)
                        &&
                        validation("nickname_valid", nickname)) {
                    for (List<String> eqForm : forms) {
                        if (form.equals(eqForm)) continue;

                        String eqNickname = eqForm.get(1);
                        getEqNickNameBySubstring(nickname, eqNickname, email);
                    }
                }
            }
            List<String> collect = answer.stream().distinct().collect(Collectors.toList());
            Collections.sort(collect);
            return collect;
        }else {
            return new ArrayList<>();
        }
    }

    private static void getEqNickNameBySubstring(String nickname,String eqNickname,String email) {
        IntStream.range(0,nickname.length()-1)
                .mapToObj(i -> nickname.substring(i,i+2))
                .forEach(nickname_s ->{
                    if (eqNickname.contains(nickname_s)){
                        answer.add(email);
                    }
                });
    }


    private static <T> boolean validation(String err_type,T err_param){
        if (err_type.equals("crew_limit")&&err_param instanceof Integer) {
            int crew_limit = (int) err_param;
            return 0<crew_limit&&crew_limit<10001;
        }
        else if (err_type.equals("email_valid")&&err_param instanceof String){
            String email = (String) err_param;
            if (!email.matches("^[a-zA-Z0-9]+@email.com$")) return false;
            return 10<email.length()&&email.length()<20;
        }
        else if (err_type.equals("nickname_valid")&&err_param instanceof String){
            String nickname = (String) err_param;
            if (!nickname.matches("^[가-힣]*$")) return false;
            return 0<nickname.length()&&nickname.length()<20;
        }

        return false;
    }
}
