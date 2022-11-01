package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {

        // Z ~ A 까지의 아스키코드가 담긴 list 생성
        List<Integer> alpha = IntStream.range(65, 91).boxed()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        // 결과값을 담아줄 sb 생성
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            // 현재 문자의 아스키 코드
            int current = (int)word.charAt(i);

            if (current == 32){
                // 아스키고드 32번은 공백 -> 문자열이 공백이라면 그대로 sb에 담는다
                sb.append(word.charAt(i));
            } else if (Character.isLowerCase(word.charAt(i))) {
                // 현재 문자가 소문자라면,
                // findAns 메소드에서 받은 결과를 소문자로 변경해서 sb에 담아준다
                sb.append(Character.toLowerCase(findAns(alpha, current, true)));
            }else {
                // findAns 메소드에서 받은 결과를 sb에 담아준다
                sb.append(findAns(alpha, current, false));
            }
        }

        return sb.toString();
    }

    // 현재 문자의 아스키코드를 계산
    // -> alpha 리스트 인덱스로 바꿔주기 위해 -65를 해준다 (청개구리 사전)
    // -> 여기서 문자가 소문자라면 인덱스에 -32를 해줘야 원하는 값을 찾을 수 있다.

    // 청개구리 사전 속 문자를 찾기 위해 위에서 계산한 index를 alpha 리스트에 사용해서 또다른 아스키코드 값을 받아온다
    // 이 값을 다시 문자열로 변경해주고 return
    private static Character findAns(List<Integer> alpha, int num, boolean isLower){

        int index = num - 65;
        if(isLower){
            index -= 32;
        }

        int i = alpha.get(index);
        char ans = (char)(i);

        return ans;
    }
}
