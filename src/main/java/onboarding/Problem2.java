package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        String[] str = cryptogram.split("");
        List<String> strList = new ArrayList<>(Arrays.asList(str));
        boolean boo = true;

        return answer;
    }
}

// "browoanoommnaon"	"brown"
// "zyelleyz"	        ""

// 입력 문자열을 분리하여 배열로 저장한 후 리스트로 변환
// while문을 진행하여 연속적으로 중복되는 문자열은 삭제
//  -> 모두 중복되어 문자열이 없거나 더이상 중복되는 문자열이 없을 경우 반복문 빠져나옴
// 리스트의 문자열을 합쳐서 출력