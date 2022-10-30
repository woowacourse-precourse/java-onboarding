package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        Stream<String> stream = Arrays.asList(word.split("")).stream();
        return stream.reduce("",(x,y)-> {
            char c =y.charAt(0);
            if (c>='A'&&c<='Z')
                return x + (char) ('A' + 'Z' - c);
            else if (c>='a'&&c<='z')
                return x + (char) ('a' + 'z' - c);
            else
                return x+c;
        });
    }
}
