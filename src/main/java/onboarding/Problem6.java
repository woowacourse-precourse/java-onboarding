package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        final Comparator<String> COMPARATOR = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] str1 = o1.split("@");
                String[] str2 = o2.split("@");
                return str1[0].compareTo(str2[0]);
            }
        };

        return answer;
    }

}
