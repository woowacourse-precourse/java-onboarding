package onboarding;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem6Test {

	/**
	 * 1. 제약사항 확인
	 *   -> 1) forms 길이 체크 (1~10000 인지 확인)
	 *   -> 2) 이메일 형식 체크 + 닉네임 길이 체크 + 닉네임 한글만 있는지 체크
	 *       =>@뒤에 email.com 이 오는지 + 이메일 길이가 11~20인지 + 닉네임 길이가 1~20 인지 확인 + 유니코드로 가 ~ 힣까지 범위 체크
	 * 2. 로직 생각
	 *   -> 1) split로 분리 후 전체 순회하면서 indexof로 최초로 같은 인넥스를 찾아서 거기서 부터 얼마만큼 길이가 같은지 체 2개, 3개, 4개... 따로 넣기
	 *       ex) 제이엠호 제이엠슨 제이엠 이제엠 이엠슨지조리
	 *          제이, 제이엠, 이엠슨, 이엠 이 패턴이 나올 수 있음
	 *       => 10,000 * 20
	 *   -> 2) 중복없이 저장된 패턴을 kmp알고리즘으로 패턴을 체크함
	 *       => kmp : O(N) , 중복없이 저장된 패턴을 순회하며 일치찾기? O(N) O(N^2)일거같은데.... 일단 구현해보자
	 */

	@Test
	void 패턴_생성_체크() {
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이엠"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);


		Set<String> check = Set.of("제이");
		Assertions.assertThat(new Problem6.Pattern(forms)).isEqualTo(new Problem6.Pattern(check));
	}

	@Test
	void 패턴_생성_체크2() {
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "사랑해사랑해"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);

		Set<String> check = Set.of("제이");
		Assertions.assertThat(new Problem6.Pattern(forms)).isEqualTo(new Problem6.Pattern(check));
	}


	@Test
	void 패턴_생성_체크3() {
		List<List<String>> forms = List.of(
			List.of("onepiece@email.com", "원피수"),
			List.of("jason@email.com", "제이슨"),
			List.of("onepisu@email.com", "원피수"),
			List.of("mj@email.com", "엠제이"),
			List.of("suonepi@email.com", "수원피")
		);

		Set<String> check = Set.of("원피", "피수","제이");
		Assertions.assertThat(new Problem6.Pattern(forms)).isEqualTo(new Problem6.Pattern(check));
	}

	@Test
	void 패턴_생성_체크4() {
		List<List<String>> forms = List.of(
			List.of("aaa@email.com", "이름"),
			List.of("bbb@email.com", "이름"),
			List.of("ccc@email.com", "이름"),
			List.of("ddd@email.com", "이름")
		);
		Set<String> check = Set.of("이름");
		Assertions.assertThat(new Problem6.Pattern(forms)).isEqualTo(new Problem6.Pattern(check));
	}


	@Test
	void 추가_테스트_케이스(){
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제"),
			List.of("jason@email.com", "제"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);
		assertThat(Problem6.solution(forms).size()).isEqualTo(0);
	}

	@Test
	void 추가_테스트_케이스2(){
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이엠"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이엠제")
		);

		List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com");

		assertThat(Problem6.solution(forms).size()).isEqualTo(4);
		assertThat(Problem6.solution(forms)).isEqualTo(result);
	}

	@Test
	void 추가_테스트_케이스3(){
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이엠"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("mk@email.com", "엠제웅"),
			List.of("nawm@email.com", "팍이제이"),
			List.of("nbwm@email.com", "팍제워니"),
			List.of("ncwm@email.com", "팍제웅니")
		);

		assertThat(Problem6.solution(forms).size()).isEqualTo(forms.size());

	}

	@Test
	void forms_길이_체크() {
		List<List<String>> forms = List.of();
		assertThrows(IllegalArgumentException.class,
			() -> Problem6.Advice.checkInputDataLength(forms));
	}

	@Test
	void 이메일_형식_체크() {
		String email = "test1@naver.com";
		assertThrows(IllegalArgumentException.class,
			() -> Problem6.Advice.checkEmailValidation(email));
	}
	@Test
	void 이메일_길이_체크(){
		String email2 = "test12123123123345667890test@email.com";
		assertThrows(IllegalArgumentException.class,
			() -> Problem6.Advice.checkEmailLength(email2));
	}

	@Test
	void 닉네임_길이_체크(){
		String nickname = "";
		String nickname2 = "가가가가가가가가가가가가가가가가가가가가가가각미나어리마너리마나러미나어리마널";

		assertThrows(IllegalArgumentException.class,
			() -> Problem6.Advice.checkNicknameLength(nickname));

		assertThrows(IllegalArgumentException.class,
			() -> Problem6.Advice.checkNicknameLength(nickname2));

	}

	@Test
	void 닉네임_한글만_있는지_체크(){
		String nickname = "가나라다라,1.2.₩-ㅁ=";

		assertThrows(IllegalArgumentException.class,
			() -> Problem6.Advice.checkNicknameIsKorean(nickname));
	}

	@Test
	void case추가(){
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "상원상원"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);
		List<String> result = List.of("jason@email.com", "mj@email.com");
		assertThat(Problem6.solution(forms)).isEqualTo(result);
	}

	@Test
	void case추가2(){
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "사랑해사랑해"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);
		List<String> result = List.of("jason@email.com", "mj@email.com");
		assertThat(Problem6.solution(forms)).isEqualTo(result);
	}

	@Test
	void case추가3(){
		List<List<String>> forms = List.of(
			List.of("jm@email.com", "제이슨"),
			List.of("jason@email.com", "제이슨"),
			List.of("woniee@email.com", "워니"),
			List.of("mj@email.com", "엠제이"),
			List.of("nowm@email.com", "이제엠")
		);
		List<String> result = List.of("jason@email.com","jm@email.com", "mj@email.com");
		assertThat(Problem6.solution(forms)).isEqualTo(result);
	}

	@Test
	void case추가4(){
		List<List<String>> forms = List.of(
			List.of("aaa@email.com", "이름"),
			List.of("bbb@email.com", "이름"),
			List.of("ccc@email.com", "이름"),
			List.of("ddd@email.com", "이름")
		);
		List<String> result = List.of("aaa@email.com", "bbb@email.com", "ccc@email.com", "ddd@email.com");
		assertThat(Problem6.solution(forms)).isEqualTo(result);
	}
}