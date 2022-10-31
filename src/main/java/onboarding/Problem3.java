package onboarding;

import java.util.ArrayList;

public class Problem3 {
//    기능 요구 사항
//      배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서,
//      3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.
//
//      숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
//
//      제한사항
//      number는 1 이상 10,000 이하인 자연수이다.
//      실행 결과 예시
//      number	result
//      13	    4
//      33	    14

    //     -- 요약 --
//    1. 3, 6, 9 가 포함된 수가 매개변수(number)로 주어지면 crap 발생
//    2. crap의 횟수를 return 하라.
//    3. 매개변수는 1 ~ 10,000 자연수
    public static int solution(int number) {
        int answer = 0;
        answer = clapCount(number);
        return answer;
    }

    public static int clapCount(int number) {
        int clapResult = 0;    // 박수친 횟수 결과
        for (int sequence = 0; sequence  <= number; sequence++) {   // number를 최대한도로 0부터 순서대로 카운트
            ArrayList<Integer> temp = new ArrayList<>();    // 한자리식 담을 임시 저장소
            String num = Integer.toString(sequence);    // 자릿수 계산을 위한 문자열 변환
            for (int index = 0; index < num.length(); index++) {    // 일, 십, 백,천 만 단위 별 숫사 한개씩 비교 조건
                temp.add(num.charAt(index) - '0');  // ArrayList에 한자릿식 더하기
            }
            for (int units : temp) {
                if (units == 3 || units == 6 || units == 9) {   // 자릿수별 3,6,9 확인
                    clapResult += 1;    //
                }
            }
        }

        return clapResult;
    }
}
