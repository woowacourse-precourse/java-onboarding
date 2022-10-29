package onboarding;

import java.util.List;

// [이메일, 닉네임]으로 이루어진 리스트를 받음
// 이메일은 이메일 형식에 맞추어, 11자 이상 20자 미만으로 한다.
// 이메일은 email.com 도메인만 가능
// 닉네임은 한글만 가능하며 1자 이상 20자 미만으로 한다.
// 리스트 내부에서의 닉네임에 같은 글자가 연속적으로 포함된다면
// 해당 지원자의 이메일 목록을 반환
// 이메일 목록은 오름차순으로 정렬하고 중복은 제거

// todo
// 1. 일단.. 제약조건부터 구현해보자!
// 1-1. 이메일의 뒷부분이 @email.com인지 검사
// 1-2. 이메일의 길이가 11이상 20미만인지 검사
// 1-3. 닉네임이 한글인지 검사
// 1-4. 닉네임의 길이가 1이상 20미만인지 검사

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        String email = "";
        String name = "";
        int emailLength = 0;
        int nameLength = 0;

        for (List form : forms) {
            email = (String) form.get(0);
            name =  (String) form.get(1);
            emailLength = email.length();
            nameLength = name.length();

            if(email.substring(emailLength-10, emailLength) != "@email.com"){
                return answer;
            }
            if(11 <= emailLength && emailLength < 20){
                return answer;
            }

            if(name.matches("^[가-힣]*$")) {
                return answer;
            }
            if(1 <= nameLength && nameLength < 20){
                return answer;
            }
        }




        return answer;
    }
}
