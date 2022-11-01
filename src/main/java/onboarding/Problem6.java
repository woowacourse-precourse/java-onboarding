package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    private static List<String> sortHashSetAsList(HashSet<String> hashSet){
        return hashSet.stream().sorted().collect(Collectors.toList());
    }
    public static List<String> solution(List<List<String>> forms) {
        return null;
    }
}
