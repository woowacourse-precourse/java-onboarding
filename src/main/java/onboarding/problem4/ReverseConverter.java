package onboarding.problem4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseConverter {
	public static final List<Character> dict = IntStream.rangeClosed('A', 'Z')
		.mapToObj(c -> (char)c)
		.collect(Collectors.toList());
}
