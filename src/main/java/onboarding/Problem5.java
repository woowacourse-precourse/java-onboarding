package onboarding;

import com.sun.source.tree.Tree;
import java.util.*;

public class Problem5 {

    private static LinkedHashMap<Integer, Integer> bank = new LinkedHashMap<>();

    private static void bankInit() {
        Integer[] moneys = new Integer[]{ 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for(Integer money : moneys) {
            bank.put(money, 0);
        }
    }
    private static void exchangeMoney(Integer money) {

        for(Integer key: bank.keySet()) {

            Integer count = (Integer)(money / key);
            bank.put(key, count);
            money -= (key * count);
        }
    }

}
