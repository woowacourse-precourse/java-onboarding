package onboarding;

import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return IntStream
                .rangeClosed(1, number)
                .map(Problem3::count369InNumber)
                .sum();
    }

    private static int count369InNumber(int number) {
        List<Integer> numberList = Util.changeIntToIntList(number);
        return (int) numberList.stream()
                .filter(Problem3::is369)
                .count();
    }

    private static boolean is369(int number) {
        return number == 3 || number == 6 || number == 9;
    }


}

/* 구현 로직
 * 입력받은 숫자까지 반복문을 돌린다.
 * 숫자를 각 자리로 쪼개서 3,6,9의 갯수를 찾는다.
 * 모든 값을 더한 것이 답이 된다.
 * */

/* 필요 기능
 * 1. 입력받은 숫자 안에 3,6,9의 갯수를 세는 함수
 *   1-2. 입력 받은 숫자를 숫자 리스트 형태로 반환하는 함수
 *   1-3. 숫자의 리스트 안에 369갯수를 세주는 함수 -> 맨 위의 함수랑 겹친다?
 *   1-4. 숫자가 369에 포함되어있는지 확인하는 함수 -> 깊이가 증가..
 *
 * 4으로 변경
 * indent depth 2까진 괜찮을꺼 같음..
 * */

/*
 * Problem1에서 사용한 changeIntToIntList 함수를 재활용할 수 있을 것 같다.
 * Util이라는 클래스를 만들어서 재활용해보자.
 * */