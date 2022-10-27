package onboarding.problem3;

import java.util.function.Predicate;

public class Iterator369 implements CustomIterator<Integer>{

    public static final String NINE = "9";
    public static final String SIX = "6";
    public static final String THREE = "3";
    private final Integer target;

    private final Counter<Integer> counter;

    public Iterator369(Integer target, Counter<Integer> counter) {
        this.target = target;
        this.counter = counter;
    }

    @Override
    public void iterateOnCondition() {
        for(Integer i = 1; i <= this.target; i++) {
            String[] splitNumbers = i.toString().split("");
            countOn369Condition(splitNumbers);
        }
    }

    private void countOn369Condition(String[] splitNumbers) {
        for (String splitNumber : splitNumbers) {
            if(is369(splitNumber)) {
                counter.countUp();
            }
        }
    }

    private boolean is369(String splitNumber) {
        return splitNumber.equals(THREE) || splitNumber.equals(SIX) || splitNumber.equals(NINE);
    }
}
