package onboarding;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Set<String> result = new TreeSet<String>();
        return result.stream().collect(Collectors.toList());
    }
}
