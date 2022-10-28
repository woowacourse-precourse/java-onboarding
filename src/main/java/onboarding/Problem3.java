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