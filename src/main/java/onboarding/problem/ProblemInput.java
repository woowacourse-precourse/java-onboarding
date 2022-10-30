package onboarding.problem;

/**
 * 문제의 입력값을 적절히 변환하며
 * 입력에 오류가 있는지 확인하는
 * 입력과 관련된 역할을 담당하는 인터페이스이다.
 */
public interface ProblemInput {

    boolean hasError();
}
