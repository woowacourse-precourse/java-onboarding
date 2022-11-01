package onboarding;

interface Calculator<T, O> {

    void setVariable(T t);
    O calculation();
}