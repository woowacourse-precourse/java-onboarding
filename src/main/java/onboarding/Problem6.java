package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        try {
            checkCrewLimit(forms.size());

            for (int i=0;i<forms.size();i++){
                String email = forms.get(i).get(0);
                validationEmail(email);
            }

            return answer;
        }catch (Exception e){
            return answer;
        }
    }

    public static void checkCrewLimit(int crew_count) throws Exception {
        if (crew_count<1||crew_count>10000) throw new Exception("인원 제한 초과");
    }

    public static void validationEmail(String email) throws Exception {
        int e_length = email.length();
        if (e_length<11||e_length>=20) throw new Exception("Eamil Length must Be 11~19");
        if (!email.matches("^[a-zA-Z0-9]+@email.com$")) throw new Exception("It's Wrong Format Email");
    }

}
