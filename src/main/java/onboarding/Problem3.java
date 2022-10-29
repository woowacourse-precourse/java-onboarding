package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {

        List<String> list = new ArrayList<>();

        IntStream.range(1, number+1)
            .mapToObj(String::valueOf)
            .forEach(list::add);

        int count = 0;

        for ( String s : list ) {
            count += countEach369(s);
        }

        return count;
    }

    private static int countEach369(String str) {

        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            cnt += has369(str.charAt(i));
        }

        return cnt;
    }

    private static int has369(char c) {

        if (c == '3') {
            return 1;
        }
        else if (c == '6') {
            return 1;
        }
        else if (c == '9') {
            return 1;
        }
        else {
            return 0;
        }
    }
}
