package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();



        // result로 오름차순 정렬되게 stream 구현
        return answer.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    // 닉네임 검증 메서드
    public static boolean nickNameCheck(String nickName) {
        return nickName.length() >= 1 && nickName.length() < 20 && Pattern.matches("^[가-힣a-zA-Z]*$", nickName);
    }

    // 이메일 검증 메서드
    public static boolean emailCheck(String email) {
        return email.length() >= 11 && email.length() < 20 && Pattern.matches("^[_a-zA-Z0-9-\\.]+@email.com+$", email);
    }

    // 차출 나올 수 있는 연속문자 검색
    public static String esNgram(String nickName, int n){
        StringTokenizer stringTokenizer = new StringTokenizer(nickName.trim()," ");
        List<String> strArr = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            String token = stringTokenizer.nextToken();
            for(int i=0; i<token.length(); i++){
                if(i+n > token.length()){
                    break;
                }
                strArr.add(token.substring(i,i+n));
            }
        }
        return String.join(" ", strArr);
    }

}
