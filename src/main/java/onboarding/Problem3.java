package onboarding;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem3 {
    public static int getPoint(int num){
        Stream<String> stream = Arrays.asList(Integer.toString(num).split("")).stream();
        return stream.mapToInt(e -> Integer.parseInt(e)).reduce(0,(x,y)-> {
            if((y %10)==3 ||(y %10)==6||(y %10)==9)
                return x+=1;
            return x;
        });
    }
    public static int solution(int number) {
        int answer = IntStream.range(1, number+1).reduce(0,(x,y)->x+getPoint(y));
        return answer;
    }
}
