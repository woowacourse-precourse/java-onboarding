package onboarding;

import java.util.List;

public class Problem6 {
    /*
    1. 닉네임 두개를 선택
    2. 두 닉네임의 중복 여부 검사
    3. 중복일 시 리스트에 이메일 push
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    // 두 닉네임의 중복 여부를 검사하는 함수 isDuplicate()
    private static boolean isDuplicate(String nickname1, String nickname2) {
        for (int i=0; i<nickname1.length()-1; i++){
            String substr1 = nickname1.substring(i, i+2);
            for (int j=0; j<nickname2.length()-1; j++){
                String substr2 = nickname2.substring(j, j+2);
                if(substr1.equals(substr2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
