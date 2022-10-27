package onboarding;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1. a ~ z 알파벳을 담은 배열을 하나 생성 기능
 * 2. 알파벳 배열 반복하면서 리스트에 반전된 알파벳 추가하는 기능
 * 3. 알파벳 반전시키는 기능
 *  3-1. 알파벳 문자가 아니면 그냥 리턴
 *  3-2. 알파벳이 대문자인지 소문자인지 기억하는 flag 저장
 *  3-3. 4번 기능 활용하여 배열의 해당 인덱스 참조
 *  3-4. 대소문자 flag로 소문자인지 대문지인지 판단해서 알맞게 리스트에 저장
 * 4. 알파벳 별로 맞는 인덱스를 계산해서 반환하는 기능 (a == 25, z == 0가 됨)
 *  4-1. 모든 알파벳 upperCase()로 변경
 *  4-2. normal index = ((int)현재 알파벳 - 65)
 *  4-1. reverse index = (26(알파벳 개수) - 1) - normal index
 * */
public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        return answer;
    }

    private static char[] getAlphaCharArray() {
        return IntStream.rangeClosed('A', 'Z')
                .mapToObj(c -> Character.toString((char) c))
                .collect(Collectors.joining())
                .toCharArray();
    }
}
