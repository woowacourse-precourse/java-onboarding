package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        
        @Test
        void nullPageTest() {
        	//given
        	List<Integer> crong = new LinkedList<>();
        	List<Integer> pobi = new LinkedList<>();
        	crong.add(null);
        	crong.add(4);
        	pobi.add(3);
        	pobi.add(null);
        	//when
        	boolean result = true;
        	
        	//then
        	assertThat(Problem1.isNullPage(crong.get(0), crong.get(1))).isEqualTo(result);
        	assertThat(Problem1.isNullPage(pobi.get(0), pobi.get(1))).isEqualTo(result);
        }
        
        @Test
        void leftPageInRangeTest() {
        	//given
        	List<Integer> pobi = List.of(1, 6);
        	List<Integer> crong = List.of(399, 8);
        	
        	//when
        	boolean result = true;
        	
        	//then
        	assertThat(Problem1.isLeftPageInRange(pobi.get(0))).isEqualTo(result);
        	assertThat(Problem1.isLeftPageInRange(crong.get(0))).isEqualTo(result);
        }
        
        @Test
        void leftPageInRangeExceptionTest() {
        	//given
        	List<Integer> pobi = List.of(0, 8);
        	List<Integer> crong = List.of(401, 8);
        	
        	//when
        	boolean result = false;
        	
        	//then
        	assertThat(Problem1.isLeftPageInRange(pobi.get(0))).isEqualTo(result);
        	assertThat(Problem1.isLeftPageInRange(crong.get(0))).isEqualTo(result);
        }
        
        @Test
        void ExceptionTest() {
        	
        	//case1: 앞면 or 뒷면을 갖고 있는 경우
        	//given, when
        	List<Integer> pobiA = new LinkedList<>();
        	pobiA.add(null);
        	pobiA.add(4);
        	//then
        	assertThat(Problem1.isCorrectPage(pobiA.get(0), pobiA.get(1))).isEqualTo(false);
        	
        	//case2: 연속된 페이지가 아닌 경우
        	//given, when
        	List<Integer> crongA = List.of(1, 8);
        	//then
        	assertThat(Problem1.isCorrectPage(crongA.get(0), crongA.get(1))).isEqualTo(false);
        	
        	//case3: 범위밖인 경우
        	//given, when
        	List<Integer> crongB = List.of(401, 402);
        	List<Integer> crongC = List.of(-1, 0);
        	//then
        	assertThat(Problem1.isCorrectPage(crongB.get(0), crongB.get(1))).isEqualTo(false);
        	assertThat(Problem1.isCorrectPage(crongC.get(0), crongC.get(1))).isEqualTo(false);
        	
        	//case4: 홀,짝이 다른 경우
        	//given, when
        	List<Integer> crongD = List.of(388, 389);
        	//then
        	assertThat(Problem1.isCorrectPage(crongD.get(0), crongD.get(1))).isEqualTo(false);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() {
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
    }
}
