package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem6Test {
	@ParameterizedTest(name = "''''{0}'''' 에서 나온 토큰 : {1}")
	@MethodSource("generateNicknames")
	void 한_닉네임에서_중복없이_토큰_추출_테스트(String nickname, Set<String> expected) {
		// when : nickname 에서 중복없이 2글자 토큰을 추출할 때
		Set<String> result = Problem6.extractTokensFromNicknameWithoutDuplication(nickname);

		// then : 정상적으로 추출되었는지 확인
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> generateNicknames() {
		return Stream.of(
				Arguments.of("우테코의아들", new HashSet<>(List.of("우테", "테코", "코의", "의아", "아들"))),
				Arguments.of("우테코테코", new HashSet<>(List.of("우테", "테코", "코테"))),
				Arguments.of("김재준재준", new HashSet<>(List.of("김재", "재준", "준재"))),
				Arguments.of("김김재김재김김", new HashSet<>(List.of("김김", "김재", "재김"))),
				Arguments.of("김김김재", new HashSet<>(List.of("김김", "김재"))),
				Arguments.of("토마토마토", new HashSet<>(List.of("토마", "마토")))
		);
	}

	@DisplayName("tokenCounter 가 empty 할 때, 토큰이 모두 1개씩 저장되는지 확인")
	@Test
	void 토큰의_개수가_저장되는지_테스트() {
		// given : nickname "김재준재" 에서 토큰화된 `Set` 이 주어졌을 때
		final Set<String> tokensOfNickname = new HashSet<>(List.of("김재", "재준", "준재"));

		// when : 토큰들의 개수를 'tokenCounter' 에 추가
		Problem6.countToken(tokensOfNickname);

		// then : 한 닉네임에 대해서는 모두 1개씩 추가되어야 한다.
		Map<String, Integer> result = Problem6.tokenCounter;
		final Map<String, Integer> expected = new HashMap<>() {{
			put("김재", 1);
			put("재준", 1);
			put("준재", 1);
		}};

		assertThat(result).isEqualTo(expected);
	}
}