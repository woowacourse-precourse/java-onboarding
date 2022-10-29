package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    private static boolean isCorrectInput(List<List<String>> forms) {
        if(forms.size()<1||forms.size()>10000) return false;
        System.out.println("테스트 통과1");
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            String[] split = email.split("@");
            if(!split[1].equals("email.com")) return false;
            if(nickName.length()<1||nickName.length()>=20) return false;
            if(email.length()<11||email.length()>=20) return false;
            if (!nickName.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) return false;
        }

        return true;
    }
}
