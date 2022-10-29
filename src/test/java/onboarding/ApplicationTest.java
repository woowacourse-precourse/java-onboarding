package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
        void getScore() {
        	List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(197, 198);
            int result = 2;
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
        	int result = -1;
        	
        	//then
        	assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        
        @Test
        void leftPageInRangeTest() {
        	//given
        	List<Integer> pobi = List.of(1, 6);
        	List<Integer> crong = List.of(399, 8);
        	
        	//when
        	int result = -1;
        	
        	//then
        	assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        
        @Test
        void leftPageInRangeExceptionTest() {
        	//given
        	List<Integer> pobi = List.of(0, 8);
        	List<Integer> crong = List.of(401, 8);
        	
        	//when
        	int result = -1;
        	
        	//then
        	assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        
        @Test
        void ExceptionTest() {
        	int result = -1;
        	//case1: 앞면 or 뒷면을 갖고 있는 경우
        	//given, when
        	List<Integer> pobiA = new LinkedList<>();
        	List<Integer> crongA = List.of(3,4);
        	pobiA.add(null);
        	pobiA.add(4);
        	//then
        	assertThat(Problem1.solution(pobiA, crongA)).isEqualTo(result);
        	
        	//case2: 연속된 페이지가 아닌 경우
        	//given, when
        	List<Integer> pobiB = List.of(1, 8);
        	//then
        	assertThat(Problem1.solution(pobiB, crongA)).isEqualTo(result);
        	
        	//case3: 범위밖인 경우
        	//given, when
        	List<Integer> pobiC = List.of(401, 402);
        	List<Integer> crongC = List.of(-1, 0);
        	//then
        	assertThat(Problem1.solution(pobiC, crongC)).isEqualTo(result);
        	
        	//case4: 홀,짝이 다른 경우
        	//given, when
        	List<Integer> pobiD = List.of(43, 44);
        	List<Integer> crongD = List.of(388, 389);
        	//then
        	assertThat(Problem1.solution(pobiD, crongD)).isEqualTo(result);
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
        
        @Test
        void worstCaseTest1() {
        	//given
        	StringBuilder sb = new StringBuilder();
        	for(char c=97; c<=122; c++) {
        		for(int j=0; j<38; j++) {
        			sb.append(c);
        		}
        	}
        	String cryptogram = sb.toString();
        	//when
        	String result = "";
        	//then
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void worstCaseTest2() {
        	//given
        	char[] cryptogramArr = new char[1000];
        	int p1= 0;
        	int p2= 999;
        	char alphabet = 97;
        	while(p1 < p2) {
        		cryptogramArr[p1] = alphabet;
        		cryptogramArr[p2] = alphabet;
        		alphabet += 1;
        		if(alphabet == 123) {
        			alphabet = 97;
        		}
        		p1 += 1;
        		p2 -= 1;
        	}
        	String cryptogram = String.valueOf(cryptogramArr);
        	//when
        	String result = "";
        	//then
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        	
        }
        @Test
        void worstCaseException() {
        	//given
        	char[] cryptogramArr = new char[999];
        	int p1= 0;
        	int p2= 998;
        	char alphabet = 97;
        	while(p1 <= p2) {
        		cryptogramArr[p1] = alphabet;
        		cryptogramArr[p2] = alphabet;
        		alphabet += 1;
        		if(alphabet == 123) {
        			alphabet = 97;
        		}
        		p1 += 1;
        		p2 -= 1;
        	}
        	String cryptogram = String.valueOf(cryptogramArr);
        	//when
        	String expected = cryptogram;
        	//then
            assertThat(Problem2.solution(cryptogram)).isEqualTo(expected);
        }
        @Test
        void exceptionTest() {
        	String cryptogram = "aaabb";
        	String expected = "";
        	assertThat(Problem2.solution(cryptogram)).isEqualTo(expected);
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
        @Test
        void totalTest() {
        	String word = "Woo wA PreCOuRsE";
        	String expected = "Dll dZ KivXLfIhV";
        	assertThat(Problem4.solution(word)).isEqualTo(expected);
        }
        @Test
        void convertCharReverseTest() {
        	char[] lowerAlphabets = new char[26];
        	for(int i=0; i<lowerAlphabets.length; i++) {
        		lowerAlphabets[i] = (char)(97 + i);
        	}
        	System.out.println(Arrays.toString(lowerAlphabets));
        	Problem4.convertCharArrReverse(lowerAlphabets);
        	System.out.println(Arrays.toString(lowerAlphabets));
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
