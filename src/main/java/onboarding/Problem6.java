package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem6 {
    static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        try {
            checkCrewLimit(forms.size());

            for (List<String> form:forms){
                String email = form.get(0);
                String nickname = form.get(1);

                validationEmail(email);
                validationNickname(nickname);
                for(List<String> eqForm: forms){
                    if (form.equals(eqForm)) continue;

                    String eqNickname = eqForm.get(1);
                    getEqNickNameBySubstring(nickname,eqNickname,email);
                }
            }

            return answer.stream().distinct().collect(Collectors.toList());
        }catch (Exception e){
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

    public static void checkCrewLimit(int crew_count) throws Exception {
        if (crew_count<1||crew_count>10000) throw new Exception("인원 제한 초과");
    }

    public static void validationEmail(String email) throws Exception {
        int e_length = email.length();
        if (e_length<11||e_length>=20) throw new Exception("Eamil Length must Be 11~19");
        if (!email.matches("^[a-zA-Z0-9]+@email.com$")) throw new Exception("It's Wrong Format Email");
    }

    public static void validationNickname(String nickname) throws Exception{
        int n_length = nickname.length();
        if (!nickname.matches("^[가-힣]*$")) throw new Exception("Nickname Must be written Hangeul");
        if (n_length<1||n_length>=20) throw new Exception("Nickname Length must Be 1~19");
    }

}
