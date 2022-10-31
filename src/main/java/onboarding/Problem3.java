package onboarding;

import java.util.LinkedList;
import java.util.List;

/*
    기능 목록
    1. 파라미터로 입력된 값이 중복된 숫자인지 판단
        -> 3, 6, 9를 판단하여 반복문 실행
    2. 중복된 숫자 중 33, 66 등은 짝짝이 나야하므로 카운트 두 번
        -> 리스트에 하나씩 담아서 크기로 answer에 저장
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Character> num = new LinkedList<>();
        // Step 1. 반복을 통해 3, 6, 9의 박수를 카운트
        for(int i = 1; i<=number; i++){
            // contains 함수를 쓰기위해 문자열로 변경
            String str = String.valueOf(i);
            if(str.contains("3") || str.contains("6") || str.contains("9")) {
                // 33, 66, 369 등의 숫자들을 위해 2번째 반복 실행
                for (int j = 0; j < str.length(); j++) {
                    if(str.charAt(j) == '3')
                        num.add(str.charAt(j));
                    if(str.charAt(j) == '6')
                        num.add(str.charAt(j));
                    if(str.charAt(j) == '9')
                        num.add(str.charAt(j));
                }
            }
        }
        // Step 2. List의 크기로 리턴
        answer = num.size();
        return answer;
    }
}
