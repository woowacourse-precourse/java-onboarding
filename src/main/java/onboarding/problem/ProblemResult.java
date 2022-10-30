package onboarding.problem;

/**
 * 문제의 결과 관련 책임을 가진 인터페이스.
 * @param <R> 결과로 반환되어야 하는 타입.
 */
public interface ProblemResult<R> {

	R toResult();
}
