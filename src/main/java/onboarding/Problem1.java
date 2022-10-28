package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    /***
     *  1. 들어온 리스트들을 잘라서 더하는 sum method
     *
     * @param human 페이지 리스트
     * @return sum을 한 리스트가 출력된다.
     */
    public static List<Integer> sum(List<Integer> human)
    {
        List<Integer> sumList = new ArrayList<>();
        //입력의 경우가 두개뿐 따라서 반복문을 사용하지 않음
        sumList.add(Stream.of(String.valueOf(human.get(0)).split("")).mapToInt(Integer::parseInt).sum());
        sumList.add(Stream.of(String.valueOf(human.get(1)).split("")).mapToInt(Integer::parseInt).sum());
        return sumList;
    }

}