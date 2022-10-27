package onboarding.problem1;

public interface PageComparisonFeature<T,R> {

    R lagerNumberOfCondition(T t);

    R comparePageBetween(T first, T second);
}
