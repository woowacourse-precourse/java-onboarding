package onboarding.problem1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PageNumberGame {
	public static final Integer POBI_WIN = 1;
	public static final Integer CRONG_WIN = 2;
	public static final Integer TIE_MATCH = 0;
	public static final Integer EXCEPTION = -1;

	private static Integer addEachNumber(Integer number) {
		return Arrays.stream(number.toString().split(""))
			.mapToInt(Integer::parseInt)
			.sum();
	}

	private static Integer multipleEachNumber(Integer number) {
		return Arrays.stream(number.toString().split(""))
			.mapToInt(Integer::parseInt)
			.reduce((total, num) -> total * num)
			.getAsInt();
	}

	private static Integer calculateMaxScore(List<Integer> pages) {
		Optional<Integer> addEachMax = pages.stream()
			.map(PageNumberGame::addEachNumber)
			.max(Comparator.comparing(result -> result));
		Optional<Integer> multipleEachMax = pages.stream()
			.map(PageNumberGame::multipleEachNumber)
			.max(Comparator.comparing(result -> result));
		return Math.max(addEachMax.get(), multipleEachMax.get());
	}

	private static Integer compareScore(Integer pobiScore, Integer crongScore) {
		if (crongScore < pobiScore) {
			return POBI_WIN;
		} else if (pobiScore < crongScore) {
			return CRONG_WIN;
		} else {
			return TIE_MATCH;
		}
	}

	public static Integer start(List<Integer> pobi, List<Integer> crong) {
		Integer pobiScore = calculateMaxScore(pobi);
		Integer crongScore = calculateMaxScore(crong);
		return compareScore(pobiScore, crongScore);
	}
}
