package onboarding;

import java.util.*;

public class Problem6 {
    // 기능 구현 목록
    // 1. 예외처리
    //  (1) 크루의 수가 1명 이상 10000명 이하가 아닌 경우
    //  (2) 이메일형식(email.com)에 부합하지 않거나 이메일의 길이가 11자 이상 20자 미만이 아닌 경우
    //  (3) 닉네임의 길이가 1자 이상 20자 미만이 아닌 경우.
    //  (4) 닉네임이 한글이 아닌 경우.
    // 2. 같은 글자가 연속으로 포함되는 크루들을 찾아내기
    public static List<String> solution(List<List<String>> forms) {

        // 예외 처리
        // 1. 크루의 수가 1명 이상 10000명 이하가 아닌 경우
        if (!(1 <= forms.size() && 10000 >= forms.size())){
            List<String> answer = List.of("크루의 수가 1명 이상 10000명 이하가 아닌 경우");
            return answer;
        }
        for (int c = 0; c < forms.size(); c++) {

            String email = forms.get(c).get(0);
            String [] email_arr = email.split("@",2);
            String email_type = email_arr[1];


            String name = forms.get(c).get(1);

            // 2. 이메일형식(email.com)에 부합하지 않거나 이메일의 길이가 11자 이상 20자 미만이 아닌 경우
            if ((!(11 <= email.length() && 20 > email.length())) || (!(email_type.equals("email.com")))){

                List<String> answer = List.of("이메일형식(email.com)에 부합하지 않거나 이메일의 길이가 11자 이상 20자 미만이 아닌 경우");
                return answer;
            }
            // 3. 닉네임의 길이가 1자 이상 20자 미만이 아닌 경우.
            else if ((!(1 <= name.length() && 20 > name.length())) ) {

                List<String> answer = List.of("닉네임의 길이가 1자 이상 20자 미만이 아닌 경우");
                return answer;
            }
            // 4. 닉네임이 한글이 아닌 경우.

            else if (!(name.matches("[ㄱ-ㅎㅏ-ㅣ가-힣]+"))) {
                List<String> answer = List.of("닉네임이 한글이 아닌 경우");
                return answer;
            }

        }


        return result;
    }
}

        //if(!(result.contains(forms.get(i))){
        //result.add();