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
