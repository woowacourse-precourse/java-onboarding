package onboarding.problem1;

public interface PageCalculationFeature<T, R> {
    R plus(T input);
    R multiply(T input);
}
