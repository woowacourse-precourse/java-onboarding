package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    private static HashMap<String, Integer> recommends = new HashMap<>();

    private static String findFriendInPairs(String user, List<String> pairs) {

        return pairs.get(0).equals(user) ?
               pairs.get(1) :
               pairs.get(0);
    }

}
