package onboarding.problem1.vo;

import java.util.List;

/**
 * 왼쪽 Page 와 오른쪽 Page 를 보관하고 있는 VO 클래스입니다.
 * @author BackFoxx
 */
public class Pages {
	private final Page leftPage;
	private final Page rightPage;

	private Pages(Page leftPage, Page rightPage) {
		this.leftPage = leftPage;
		this.rightPage = rightPage;
	}

	/**
	 * 인자로 들어온 값을 각각 왼쪽, 오른쪽 Page 로 하는 Pages 객체를 만드는 정적 팩토리 메소드입니다.
	 * @param target 인자로 들어온 List 의 0번 째 값을 왼쪽 Page , 1번 째 값을 오른쪽 Page 로 각각 저장합니다.
	 */
	public static Pages of(List<Integer> target) {
		if (target.size() != 2) {
			throw new IllegalArgumentException("Pages 로 만드려는 List 에는 2개의 Integer 만 있어야 합니다.");
		}

		return new Pages(
			Page.of(target.get(0)),
			Page.of(target.get(1))
		);
	}

	/**
	 * @return 왼쪽 Page 객체를 반환합니다.
	 */
	public Page getLeftPage() {
		return leftPage;
	}

	/**
	 * @return 오른쪽 Page 객체를 반환합니다.
	 */
	public Page getRightPage() {
		return rightPage;
	}
}
