package onboarding;

import java.util.List;

import onboarding.problem1.Problem1Application;
import onboarding.problem1.config.BookGameDependencyConfigurer;
import onboarding.problem1.exception.BookGameException;

class Problem1 {

	private static final BookGameDependencyConfigurer bookGameConfig = new BookGameDependencyConfigurer();

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		Problem1Application problem1 = new Problem1Application(bookGameConfig);

		try {
			problem1.validateInput(pobi, crong);
		} catch (BookGameException bookGameException) {
			return bookGameException.getExceptionCode();
		}

		return problem1.run(pobi, crong);
	}

}