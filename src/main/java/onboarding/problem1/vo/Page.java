package onboarding.problem1.vo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 페이지 숫자 값을 보관하고 있는 VO 클래스입니다.
 * @author BackFoxx
 */
public class Page {
	private final Integer pageNumber;

	private Page(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * 인자로 들어온 값을 pageNumber 로 하는 Page 객체를 만드는 정적 팩토리 메소드입니다.
	 */
	public static Page of(Integer pageNumber) {
		return new Page(pageNumber);
	}

	/**
	 * @return Page 에서 보관하고 있는 페이지 숫자를 반환합니다.
	 */
	public Integer getNumber() {
		return pageNumber;
	}

	/**
	 * pageNumber 의 각 자릿수 숫자를 분리하여 List<Integer> 형태로 반환하는 메소드입니다.
	 */
	public List<Integer> getEachNumberList() {
		return pageNumber
			.toString().chars()
			.map(ascii -> ascii - 48)
			.boxed().collect(Collectors.toList());
	}
}
