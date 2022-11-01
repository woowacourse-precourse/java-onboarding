package onboarding;

import java.util.Comparator;
import java.util.Map;

public class Problem7 {
    public static final int MAX_RECOMMEND_SIZE = 5;
    public static final int FRIEND_IN_COMMON_SCORE = 10;
    public static final int VISITOR_SCORE = 1;

    public static final Comparator<Map.Entry<String, Integer>> byValDesc = Map.Entry.comparingByValue(Comparator.reverseOrder());
    public static final Comparator<Map.Entry<String, Integer>> byKeyAsc = Map.Entry.comparingByKey();
    public static final Comparator<Map.Entry<String, Integer>> sortConditions = byValDesc.thenComparing(byKeyAsc);


}
