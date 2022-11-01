package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem6Test {
	@BeforeEach
	void resetTokenCounter() {
		Problem6.tokenCounter.clear();
	}

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

	@DisplayName("모든 forms 에 대해 token 카운팅 테스트")
	@Test
	void countingAllTokensTest() {
		// given : form list 가 주어졌을 때
		List<List<String>> forms = new ArrayList<>(List.of(
				new ArrayList<>(List.of("temp1@email.com", "김재준재준")),
				new ArrayList<>(List.of("temp2@email.com", "우테코재준")),
				new ArrayList<>(List.of("temp3@email.com", "최고야재준")),
				new ArrayList<>(List.of("temp4@email.com", "제발우테코"))
		));

		// when : 모든 forms 의 nickname 들에 대해 토큰의 개수를 카운팅
		Problem6.countAllTokensFromForms(forms);

		// then :
		Map<String, Integer> result = Problem6.tokenCounter;
		final Map<String, Integer> expected = new HashMap<>() {{
			put("고야", 1);
			put("김재", 1);
			put("준재", 1);
			put("발우", 1);
			put("제발", 1);
			put("최고", 1);
			put("코재", 1);
			put("야재", 1);
			put("우테", 2);
			put("테코", 2);
			put("재준", 3);
		}};

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("어떤 nickname 이 중복이 안될 때 테스트")
	@Test
	void checkNotDuplicatedNicknameTest() {
		// given : tokenCounter 와 중복인지 판단해야할 nickname 이 주어졌을 때
		final String nickname = "배달의민족화이팅";
		List<List<String>> forms = new ArrayList<>(List.of(
				new ArrayList<>(List.of("temp1@email.com", "김재준재준")),
				new ArrayList<>(List.of("temp2@email.com", "우테코재준")),
				new ArrayList<>(List.of("temp3@email.com", "최고야재준")),
				new ArrayList<>(List.of("temp4@email.com", "제발우테코")),
				new ArrayList<>(List.of("temp5@email.com", nickname))
		));
		Problem6.countAllTokensFromForms(forms);

		// when : 해당 nickname 이 forms 에 대해 중복이 안됐는지 테스트
		boolean result = Problem6.isDuplicated(nickname);

		// then : 중복이 안된 nickname 이기에 false 반환
		assertThat(result).isFalse();
	}

	@DisplayName("어떤 nickname 이 중복이 될 때 테스트")
	@Test
	void checkDuplicatedNicknameTest() {
		// given : tokenCounter 와 중복인지 판단해야할 nickname 이 주어졌을 때
		final String nickname = "발우준우재";
		List<List<String>> forms = new ArrayList<>(List.of(
				new ArrayList<>(List.of("temp1@email.com", "김재준재준")),
				new ArrayList<>(List.of("temp2@email.com", "우테코재준")),
				new ArrayList<>(List.of("temp3@email.com", "최고야재준")),
				new ArrayList<>(List.of("temp4@email.com", "제발우테코")),
				new ArrayList<>(List.of("temp5@email.com", nickname))
		));
		Problem6.countAllTokensFromForms(forms);

		// when : 해당 nickname 이 forms 에 대해 중복이 됐는지 테스트
		boolean result = Problem6.isDuplicated(nickname);

		// then : 중복이 된 nickname 이기에 true 반환
		assertThat(result).isTrue();
	}

	@ParameterizedTest(name = "MAIN TEST : {0} 에서 중복되는 이메일 리스트 => {1}")
	@MethodSource("generateFormList")
	void solutionTest(List<List<String>> forms, List<String> expected) {
		// when : solution(main) 을 실행했을 때
		List<String> result = Problem6.solution(forms);

		// then : 중복되는 nickname 을 가진 모든 email 리스트가 중복없이 정렬되어 나와야 함
		assertThat(result).isEqualTo(expected);
	}

	private static Stream<Arguments> generateFormList() {
		return Stream.of(
				Arguments.of(List.of(
						List.of("rlawowns97@email.com", "재준이가짱"),
						List.of("ghdtjrwn@email.com", "홍석주가짱"),
						List.of("wooteco@email.com", "우아한테크코스"),
						List.of("iphonemaster@email.com", "아이폰아이좋아"),
						List.of("galaxymaster@email.com", "삼성이미래다"),
						List.of("woowahan@email.com", "우아한형제들")
				), List.of("ghdtjrwn@email.com", "rlawowns97@email.com", "wooteco@email.com", "woowahan@email.com")),
				Arguments.of(List.of(
						List.of("tomato@email.com", "토마토마토마토마토"),
						List.of("whoisthebest@email.com", "내가짱"),
						List.of("applespy@email.com", "갤럭시짱"),
						List.of("galaxyspy@email.com", "애플이미래다"),
						List.of("light@email.com", "빛을쏟는스카이"),
						List.of("next@email.com", "다음은당신")
				), List.of()),
				Arguments.of(List.of(
						List.of("az@email.com", "토마토마토마토마토"),
						List.of("zb@email.com", "내가짱짱"),
						List.of("ca@email.com", "갤럭시짱짱"),
						List.of("cq@email.com", "애플이짱짱"),
						List.of("ef@email.com", "빛을쏟는짱짱"),
						List.of("ee@email.com", "토마도가좋아")
				), List.of("az@email.com",
						"ca@email.com",
						"cq@email.com",
						"ee@email.com",
						"ef@email.com",
						"zb@email.com"))
		);
	}
}