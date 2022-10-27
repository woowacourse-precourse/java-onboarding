package onboarding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    private static final List<Integer> checkList = Arrays.asList(3, 6, 9);

    public static int solution(int number) {
        int answer = 0;
        List<Integer> datas = initDataOneToNumber(number);
        for (Integer data : datas) {
            answer += calcNumber(data);
        }
        return answer;
    }

    private static List<Integer> initDataOneToNumber(int number) {
        return IntStream.rangeClosed(1, number)
                .collect(ArrayList::new, List::add, List::addAll);
    }

    private static int calcNumber(int number) {
        int count = 0;
        while (number != 0) {
            count += checkList.contains(number % 10) ? 1 : 0;
            number /= 10;
        }
        return count;
    }
}
/*
문제 설명
  1. 1부터 숫자가 1씩 증가함
  2. 3,6,9가 들어가는 숫자는 말하는 대신 3,6,9의 개수만큼 손뼉을 쳐야함
  3. 1부터 number까지 손뼉을 몇 번 쳐야하는지 횟수를 리턴

문제 예시
  1. number = 13 , result 4
    => 3,6,9,13
  2. number = 33 , result 14
    => 3,6,9,13,16,19,23,26,29,30,31,32,33

제한사항 및 주의할점
  - 1 <= number <= 10,000 (자연수)
 */