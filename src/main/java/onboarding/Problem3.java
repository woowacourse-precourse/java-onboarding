package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        List<Integer> stream = IntStream.range(1, number+1)
                .boxed()
                .collect(Collectors.toList());

        for(int data : stream){
            answer += threeMultiple(data);
        }
        return answer;
    }

    private static int threeMultiple(int number) {
        int thousands = number / 1000;
        int hundreds = number % 1000 / 100;
        int tens = number % 100 / 10;
        int units = number % 10;
        int result = 0;

        result += check(thousands);
        result += check(hundreds);
        result += check(tens);
        result += check(units);

        return result;
    }

    private static int check(int number){
        if(number == 3 || number == 6 || number == 9){
            return 1;
        }
        else{
            return 0;
        }
    }
}
