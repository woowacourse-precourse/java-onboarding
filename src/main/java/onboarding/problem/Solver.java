package onboarding.problem;

/**
 * 문제 풀이 관련 책임을 가진 인터페이스
 * @param <I> 문제의 입력 타입
 * @param <R> 해결한 결과 타입
 */
public interface Solver<I extends ProblemInput, R extends ProblemResult<?>> {

    /**
     * 문제의 입력을 통해 문제를 해결한 뒤 결과를 반환한다.
     * @param input 타입 파라미터로 정의한 타입의 입력
     * @return 결과는 타입 파라미터로 정의된 결과로 반환된다.
     */
    R solve(I input);
}
