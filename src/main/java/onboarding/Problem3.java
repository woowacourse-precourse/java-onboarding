package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Problem3 {
    static int[] totalClapsCache = new int[10001];
    static final int EMPTY = -1;

    static {
        Arrays.fill(totalClapsCache, EMPTY);
    }

    static final List<Character> conditions = Arrays.asList('3', '6', '9');


    public static int solution(int number) {
        return 0;
    }

    public static int getClaps(int order) {

        Stream<Character> characterStream = String.valueOf(order).
                chars().
                mapToObj(x -> (char) x);

        return (int) (characterStream
                .filter(ch -> conditions.contains(ch))
                .count());
    }

}


