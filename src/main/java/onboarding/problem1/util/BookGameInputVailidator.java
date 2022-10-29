package onboarding.problem1.util;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BookGameInputVailidator {

	public static boolean playerHasNullItem(List<Integer> bookGamePlayer) {
		return bookGamePlayer.stream().anyMatch(Objects::isNull);
	}

	public static boolean listLengthValidator(List<Integer> bookGamePlayer) {
		return bookGamePlayer.size() == 2;
	}

	public static boolean pageRangeValidator(List<Integer> bookGamePlayer) {
		return bookGamePlayer.stream().allMatch(page ->
			page > 2 && page < 399 // 1,2 페이지와 399, 400페이지 제외
		);
	}

	public static boolean nextPageValidator(List<Integer> bookGamePlayer) {
		Collections.sort(bookGamePlayer);
		return bookGamePlayer.get(0) + 1 == bookGamePlayer.get(1);
	}

	public static boolean oddPageValidator(List<Integer> bookGamePlayer) {
		return bookGamePlayer.get(0) % 2 == 1;
	}

	public static boolean evenPageValidator(List<Integer> bookGamePlayer) {
		return bookGamePlayer.get(1) % 2 == 0;
	}
}
