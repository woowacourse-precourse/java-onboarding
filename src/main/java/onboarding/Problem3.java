package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        AtomicInteger count = new AtomicInteger();
        List<String> list = Arrays.asList("3", "6", "9");
        while (number > 0) {
            Stream.of(String.valueOf(number--).split(""))
                    .forEach(num -> {
                        if (list.contains(num)) {
                            count.getAndIncrement();
                        }
                    });
        }
        return count.get();
    }
}
