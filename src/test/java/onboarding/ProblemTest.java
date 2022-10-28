package onboarding;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ProblemTest {
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
			String[] cryptograms = {"abbbd", "nhhhj","nhdddjjh", "woowacourse", "test"};
			String[] result = {"ad", "nj","n", "acourse", "test"};
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
			String te_st = Problem4.solution("Te st");
			Assertions.assertThat(te_st).isEqualTo("Gv hg");
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
}

/*
궁금증
for문 안에 람다표현식을 쓸 때,
Variable used in lambda expression should be final or effectively final가 발생
근데, List일 떄는 오류가 나는데, Array를 참조하는 경우엔 오류가 나지 않음. 왜 그럴까??????
 */