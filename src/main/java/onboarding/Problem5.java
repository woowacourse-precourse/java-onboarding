package onboarding;

import service.problem5.Problem5ServiceImpl;
import service.problem5.Problem5Serviceable;

import java.util.*;

public class Problem5 {
    private static final Problem5Serviceable service = new Problem5ServiceImpl();
    public static List<Integer> solution(int money){
        return service.getChanges(money);
    }
}
