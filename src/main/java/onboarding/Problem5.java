package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
	private static int totalMoney;
    public static List<Integer> solution(int money) {
    	totalMoney = money;
        List<Integer> totalChanges = new ArrayList<Integer>();
        startChange(totalChanges);
        return totalChanges;
    }
    private static List<Integer> startChange(List<Integer> totalChanges) {
    	totalChanges.add(getFiftyThousand());
    	totalChanges.add(getTenThousand());
    	totalChanges.add(getFiveThousand());
    	totalChanges.add(getOneThousand());
    	totalChanges.add(getFiveHundread());
    	totalChanges.add(getOneHundread());
    	totalChanges.add(getFifty());
    	totalChanges.add(getTen());
    	totalChanges.add(getOne());
    	return totalChanges;
    }
    private static int getFiftyThousand() {
    	int changes = totalMoney / 50000;
    	totalMoney %= 50000;
    	return changes;
    }
    private static int getTenThousand() {
    	int changes = totalMoney / 10000;
    	totalMoney %= 10000;
    	return changes;
    }
    private static int getFiveThousand() {
    	int changes = totalMoney / 5000;
    	totalMoney %= 5000;
    	return changes;
    }
    private static int getOneThousand() {
    	int changes = totalMoney / 1000;
    	totalMoney %= 1000;
    	return changes;
    }
    private static int getFiveHundread() {
    	int changes = totalMoney / 500;
    	totalMoney %= 500;
    	return changes;
    }
    private static int getOneHundread() {
    	int changes = totalMoney / 100;
    	totalMoney %= 100;
    	return changes;
    }
    private static int getFifty() {
    	int changes = totalMoney / 50;
    	totalMoney %= 50;
    	return changes;
    }
    private static int getTen() {
    	int changes = totalMoney / 10;
    	totalMoney %= 10;
    	return changes;
    }
    private static int getOne() {
    	int changes = totalMoney / 1;
    	totalMoney %= 1;
    	return changes;
    }
}
