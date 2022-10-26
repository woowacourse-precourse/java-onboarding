package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }


    /*
    기능 1
    각 자리 숫자를 배열로 만드는 기능
    * */
    public static int[] makeArrayOfNum(int num)
    {
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        // Int -> Stream<String> -> Stream<Integer> -> Array
    }
    /*
    기능 2
    왼쪽 페이지 숫자 배열과 오른쪽 페이지 숫자 배열이 주어졌을때, 최댓값을 구하는 기능
    * */

    /*
    기능 3
    점수를 비교해 승자 값을 리턴하는 기능
    * */

    /*
    기능 4
    페이지가 주어졌을 때, 예외사항을 판단하는 기능
     */
}