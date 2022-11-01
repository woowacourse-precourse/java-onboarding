package onboarding;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ProblemTest {
	//개인적으로 자바 문법을 테스트 해보기 위한 test클래스
	@Nested
	class JavaGrammarTest {
		@Test
		public void stringSplitNullCharacter() {
			String s = "abcde";
			String[] split = s.split("");
			for (String character : split) {
				System.out.println(character);
			}
		/*
		빈 문자열로 split하면, 모든 문자가 string 배열의 원소로 나옴.
		 */
		}
		@Test
		public void unInitArrayLookup(){
			int[] emptyArray = new int[6];
			System.out.println(emptyArray[0]);
			//int는 primitive이기에 0으로 값이 초기화 되어 있음.
		}

		@Test
		public void testMap(){
			Map<String,Integer> map;
		}

	}

	@Nested
	class TestProblem1{
		List<Integer> validatePage=List.of(3,4);

		@Test
		public void pageNumberIsNull(){
			List<Integer> nullPage = new ArrayList<>();
			nullPage.add(null);
			nullPage.add(null);
			Assertions.assertThat(Problem1.solution(validatePage,nullPage)).isEqualTo(-1);
		}

		@Test
		public void pageSizeIsNotCorrect(){
			List<List<Integer>> testCases = new ArrayList<>();

			List<Integer> pageSize1=List.of(1);
			List<Integer> pageSize3=List.of(3,4,5);
			List<Integer> pageSize4=List.of(5,6,7,8);

			testCases.add(pageSize1);
			testCases.add(pageSize3);
			testCases.add(pageSize4);

			for(List<Integer> testCase : testCases)
				Assertions.assertThat(Problem1.solution(validatePage,testCase)).isEqualTo(-1);
		}

		@Test
		public void pageNumberIsNotContinuous(){
			List<List<Integer>> testCases = new ArrayList<>();

			List<Integer> notContinuousPageNumberCase1=List.of(3,6);
			List<Integer> notContinuousPageNumberCase2=List.of(9,12);
			List<Integer> notContinuousPageNumberCase3=List.of(105,124);

			testCases.add(notContinuousPageNumberCase1);
			testCases.add(notContinuousPageNumberCase2);
			testCases.add(notContinuousPageNumberCase3);

			for(List<Integer> testCase : testCases)
				Assertions.assertThat(Problem1.solution(validatePage,testCase)).isEqualTo(-1);
		}

		@Test
		public void pageNumberNotMatchOddEven(){
			List<List<Integer>> testCases = new ArrayList<>();

			List<Integer> notMathOddEven1 = List.of(22,23);
			List<Integer> notMathOddEven2 = List.of(6,7);
			List<Integer> notMathOddEven3 = List.of(322,323);

			testCases.add(notMathOddEven1);
			testCases.add(notMathOddEven2);
			testCases.add(notMathOddEven3);

			for(List<Integer> testCase : testCases)
				Assertions.assertThat(Problem1.solution(validatePage,testCase)).isEqualTo(-1);
		}

		@Test
		public void pageNumberIsNotInRange(){
			List<List<Integer>> testCases = new ArrayList<>();

			List<Integer> pageNumberOverRange1 = List.of(401,402);
			List<Integer> pageNumberOverRange2 = List.of(683,684);
			List<Integer> pageNumberUnderRange1 = List.of(-21,-20);
			List<Integer> pageNumberUnderRange2 = List.of(-1,0);

			testCases.add(pageNumberOverRange1);
			testCases.add(pageNumberOverRange2);
			testCases.add(pageNumberUnderRange1);
			testCases.add(pageNumberUnderRange2);

			for(List<Integer> testCase : testCases)
				Assertions.assertThat(Problem1.solution(validatePage,testCase)).isEqualTo(-1);
		}

		//continuous에서 이미 체크됨.
		@Test
		public void leftNumberIsBiggerThanRightNumber(){
			List<List<Integer>> testCases = new ArrayList<>();

			List<Integer> leftBiggerRight1 = List.of(45,44);
			testCases.add(leftBiggerRight1);

			for(List<Integer> testCase : testCases)
				Assertions.assertThat(Problem1.solution(validatePage,testCase)).isEqualTo(-1);
		}

		@Test
		public void pageIsNull(){
			List<Integer> test = null;
			Assertions.assertThat(Problem1.solution(validatePage,test)).isEqualTo(-1);
		}

		/*
		시간 나면 실제 유의미한 값을 가진 list들로 테스트 해보기.
		 */
	}

	@Nested
	class TestProblem2 {
		@Test
		public void removeDuplicateCharPractice() {
			String str="zyelleyz";
			char[] charArray = str.toCharArray();
			String result = "";
			char preChar = '\0';

			for (char ch : charArray) {
				if(ch != preChar)
					result += ch;
				else
					result=result.substring(0,result.length()-1);
				preChar=ch;
			}
		}

		@Test
		public void emptyStringThrowException(){
			String str="";
			Assertions.assertThatThrownBy(()->Problem2.solution(str))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void stringContainUpperCase(){
			String str = "Test String";
			Assertions.assertThatThrownBy(()->Problem2.solution(str))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void stringIsNull(){
			String str = null;
			Assertions.assertThatThrownBy(()->Problem2.solution(str))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void testCase(){
			String[] cryptograms = {"abbbd", "nhhhj","nhdddjjh", "woowacourse", "test", "ccabbbacdeef", "saaddas"};
			String[] result = {"ad", "nj","n", "acourse", "test", "cdf", "sas"};
			for(int i=0;i<cryptograms.length;i++)
				Assertions.assertThat(Problem2.solution(cryptograms[i]))
					.isEqualTo(result[i]);
		}
	}

	@Nested
	class TestProblem3{
		@Test
		public void checkNumberIsZero(){
			int underRangeNumber = 0;
			Assertions.assertThatThrownBy(()->Problem3.solution(underRangeNumber))
				.isInstanceOf(IllegalArgumentException.class);
		}
		@Test
		public void checkNumberOver10000(){
			int overRangeNumber = 10001;
			Assertions.assertThatThrownBy(()->Problem3.solution(overRangeNumber))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Nested
	class TestProblem4{
		@Test
		public void translateTest(){
			String te_st = Problem4.solution("Te st!!");
			Assertions.assertThat(te_st).isEqualTo("Gv hg!!");
		}
		@Test
		public void checkWordLength0(){
			Assertions.assertThatThrownBy(()->Problem4.solution(""))
				.isInstanceOf(IllegalArgumentException.class);
		}
		@Test
		public void checkWordLengthOver1000(){
			String testString = new String(new char[1001]).replace('\0','A');
			Assertions.assertThatThrownBy(()->Problem4.solution(testString))
				.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		public void stringIsNull(){
			String str = null;
			Assertions.assertThatThrownBy(()->Problem4.solution(str))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Nested
	class TestProblem5{
		@Test
		public void testCase(){
			List<Integer> solution = Problem5.solution(66666);
			List<Integer> expected = List.of(1,1,1,1,1,1,1,1,6);

			Assertions.assertThat(solution).isEqualTo(expected);
		}

		@Test
		public void numberIsNotInRange(){
			int zero = 0;
			int overRangeNumber = 1000001;

			Assertions.assertThatThrownBy(()->Problem5.solution(zero))
				.isInstanceOf(IllegalArgumentException.class);
			Assertions.assertThatThrownBy(()->Problem5.solution(overRangeNumber))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Nested
	class TestProblem6{
		@Test
		void testCase1(){
			List<List<String>> forms = List.of(
				List.of("jm@email.com", "제이엠"),
				List.of("jason@email.com", "제이슨"),
				List.of("woniee@email.com", "워니"),
				List.of("javajigi@email.com", "이슨제"),
				List.of("mj@email.com", "엠제이"),
				List.of("nowm@email.com", "이제엠")
			);
			List<String> result = List.of("jason@email.com", "javajigi@email.com","jm@email.com", "mj@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		void testCase2() {
			List<List<String>> forms = List.of(
				List.of("kim@email.com", "김소이"),
				List.of("nam@email.com", "소이야"),
				List.of("choi@email.com", "최강"),
				List.of("lee@email.com", "강합니다"),
				List.of("jun@email.com", "왜아소이야")
			);
			List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		void testCase3(){
			List<List<String>> forms = List.of(
				List.of("onepiece@email.com", "원피스"),
				List.of("jason@email.com", "제이슨"),
				List.of("onepisu@email.com", "원피수"),
				List.of("mj@email.com", "엠제이"),
				List.of("suonepi@email.com", "수원피")
			);
			List<String> result = List.of("jason@email.com","mj@email.com","onepiece@email.com"
				,"onepisu@email.com","suonepi@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}

		@Test
		void testCase4(){
			List<List<String>> forms = List.of(
				List.of("jm@email.com", "제이엠"),
        List.of("jason@email.com", "제이슨"),
        List.of("woniee@email.com", "워니"),
        List.of("mj@email.com", "엠제이"),
        List.of("nowm@email.com", "이제엠"),
        List.of("jasp@email.com", "박이김"),
        List.of("jp@email.com", "김이박"),
        List.of("qpw@email.com", "김이순"),
        List.of("teemo@email.com", "티모"),
        List.of("banana@email.com", "대위티모"),
        List.of("secondJm@email.com", "제이엠"),
        List.of("apple@email.com", "땷횱봵"),
        List.of("stran@email.com", "횱봵으"),
        List.of("zebra@email.com", "두글자이상의문자가연속적으로이제맞티모")
			);
			List<String> result = List.of("apple@email.com", "banana@email.com", "jason@email.com",
				"jm@email.com", "jp@email.com", "mj@email.com", "nowm@email.com", "qpw@email.com",
				"secondJm@email.com", "stran@email.com", "teemo@email.com", "zebra@email.com");
			assertThat(Problem6.solution(forms)).isEqualTo(result);
		}
	}

	@Nested
	class TestProblem7{
		@Test
		public void testCase1(){
			String user = "mrko";
			List<List<String>> friends = List.of(
				List.of("donut", "andole"),
				List.of("donut", "jun"),
				List.of("donut", "mrko"),
				List.of("shakevan", "andole"),
				List.of("shakevan", "jun"),
				List.of("shakevan", "mrko")
			);
			List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
			List<String> result = List.of("andole", "jun", "bedi");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}

		@Test
		void case4() {
			String user = "andole";
			List<List<String>> friends = List.of(
				List.of("andole", "jun"),
				List.of("donut", "jun"),
				List.of("donut", "shakevan"),
				List.of("shakevan", "andole"),
				List.of("shakevan", "jun"),
				List.of("shakevan", "bedi"),
				List.of("anne", "jun")
			);
			List<String> visitors = List.of("donut", "mrko", "peter", "sam");
			List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}

		@Test
		void case5() {
			String user = "andole";
			List<List<String>> friends = List.of(
				List.of("andole", "jun"),
				List.of("andole", "bedi"),
				List.of("jun", "shakevan"),
				List.of("jun", "kane"),
				List.of("jun", "sam"),
				List.of("bedi", "shakevan"),
				List.of("bedi", "anne"),
				List.of("bedi", "sam"),
				List.of("anne", "mrko")
			);
			List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
			List<String> result = List.of("sam", "shakevan", "anne", "kane", "mrko");
			assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
		}
	}
}

/*
궁금증
for문 안에 람다표현식을 쓸 때,
Variable used in lambda expression should be final or effectively final가 발생
근데, List일 떄는 오류가 나는데, Array를 참조하는 경우엔 오류가 나지 않음. 왜 그럴까??????
 */