package service.problem5;

import java.util.List;

public interface Problem5Serviceable {
    int[] CASH = {50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1};
    int[] CHANGES = new int[CASH.length];
    List<Integer> getChanges(int money);
}
