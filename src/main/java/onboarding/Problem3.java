package onboarding;

import onboarding.problem3.ClapCounter;
import onboarding.problem3.Counter;
import onboarding.problem3.CustomIterator;
import onboarding.problem3.GameOperator;
import onboarding.problem3.Iterator369;

public class Problem3 {
    public static int solution(int number) {
        Counter<Integer> counter = new ClapCounter();
        CustomIterator<Integer> iterator = new Iterator369(number, counter);
        GameOperator gameOperator = new GameOperator(iterator);

        gameOperator.start();

        return counter.getCount();
    }
}
