package onboarding.problem7;

import java.util.*;

public class Sns {
    public static final int RECOMMEND_NUMBER = 5;

    public HashSet<String> memberSet = new HashSet<>();
    public HashMap<String, HashSet<String>> friendShip = new HashMap<>();
    public HashMap<String, HashMap<String, Integer>> visitHistory = new HashMap<>();
}
