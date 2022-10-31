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
//        @Test
//        void exceptionTest() {
//        	String cryptogram = "aaabb";
//        	String expected = "";
//        	assertThat(Problem2.solution(cryptogram)).isEqualTo(expected);
//        }
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
        @Test
        void countThreeSixNineTest() {
        	//given
        	int number = 336;
        	//when
        	int result = 3;
        	//then
//        	assertThat(Problem3.countAllThreeSixNine(number)).isEqualTo(result);
        	
        	//given
        	int number2 = 3335;
        	//when
        	int result2 = 3;
        	//then
//        	assertThat(Problem3.countAllThreeSixNine(number2)).isEqualTo(result2);
        	
        	//given
        	int number3 = 10000;
        	//when
        	int result3 = 0;
        	//then
//        	assertThat(Problem3.countAllThreeSixNine(number3)).isEqualTo(result3);
        	
        	int number4 = 1;
        	int result4 = 0;
//        	assertThat(Problem3.countAllThreeSixNine(number4)).isEqualTo(result4);
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
        	String word = "Woo wA PreCOuRsEZ";
        	String expected = "Dll dZ KivXLfIhVA";
        	assertThat(Problem4.solution(word)).isEqualTo(expected);
        }
        @Test
        void execptionTest() {
        	String word = "알파벳외의문자는변환하지않아요abcdeZYX-_~?!";
        	String expected = "알파벳외의문자는변환하지않아요zyxwvABC-_~?!";
        	assertThat(Problem4.solution(word)).isEqualTo(expected);
        }
        @Test
        void totalTest2() {
        	String word = "abcd ! efghij ? klmn 가 opqrstu 나 vwxyzABC 뷁 DEFGHI ~JKL^MNOPQRSTUVWXYZ";
        	String expected = "zyxw ! vutsrq ? ponm 가 lkjihgf 나 edcbaZYX 뷁 WVUTSR ~QPO^NMLKJIHGFEDCBA";
        	assertThat(Problem4.solution(word)).isEqualTo(expected);
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
        
        @Test
        void test1() {
        	int money = 999_999;
        	List<Integer> expected = List.of(19, 4, 1, 4, 1, 4, 1, 4, 9);
        	assertThat(Problem5.solution(money)).isEqualTo(expected);
        }
        @Test
        void test2() {
        	int money = 1_000_000;
            List<Integer> expected = List.of(20, 0, 0, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(expected);
        }
        @Test
        void test3() {
        	int money = 1;
            List<Integer> expected = List.of(0, 0, 0, 0, 0, 0, 0, 0, 1);
            assertThat(Problem5.solution(money)).isEqualTo(expected);
        }
        @Test
        void test4() {
        	int money = 734_065;
            List<Integer> expected = List.of(14, 3, 0, 4, 0, 0, 1, 1, 5);
            assertThat(Problem5.solution(money)).isEqualTo(expected);
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
        @Test
        void test1() {
            List<List<String>> forms = List.of(
                    List.of("kim@email.com", "ㅡ이"),
                    List.of("nam@email.com", "ㅡ어어어ㅡ이"),
                    List.of("choi@email.com", "강력합니다"),
                    List.of("lee@email.com", "강함니댜"),
                    List.of("jun@email.com", "ㅇㅡ이야")
            );
            List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
        @Test
        void noneDuplicateTest() {
        	List<List<String>> forms = List.of(
                    List.of("jm@email.com", "가나다"),
                    List.of("jason@email.com", "라마바"),
                    List.of("woniee@email.com", "사아자차"),
                    List.of("mj@email.com", "카타파"),
                    List.of("nowm@email.com", "하")
            );
//        	List<String> result = List.of("");
        	assertThat(Problem6.solution(forms)).isEmpty();
        }
        @Test
        void test2() {
        	List<List<String>> forms = List.of(
        			List.of("a@email.com", "우아한테크프리코스"),
        			List.of("abe@email.com", "우아일주차"),
        			List.of("abb@email.com", "리코이주차"),
        			List.of("aba@email.com", "테프이주"),
					List.of("ab@email.com", "가나라마바사아한"),
					List.of("aa@email.com", "가라바아나마사리코"),
					List.of("aaaae@email.com", "우아한형제들"),
					List.of("aaaad@email.com", "김밥형제"),
					List.of("aaaab@email.com", "밥형우한제"),
					List.of("aaaaa@email.com", "배달의민족"),
					List.of("ssse@email.com", "의민족"),
					List.of("sss@email.com", "뷁쉙퉭톩굵"),
					List.of("ssa@email.com", "가쉙볽톩굵벡"),
					List.of("sssd@email.com", "이건없겠지"));
        	
        	List<String> result = List.of("a@email.com",
								      "aa@email.com",
								      "aaaaa@email.com",
								      "aaaab@email.com",
								      "aaaad@email.com",
								      "aaaae@email.com",
								      "ab@email.com",
								      "aba@email.com",
								      "abb@email.com",
								      "abe@email.com",
								      "ssa@email.com",
								      "sss@email.com",
								      "ssse@email.com");
        	assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
        @Test
        void exceptionTest() {
        	List<List<String>> forms = List.of(
        			List.of("jungi123@email.com", "예외사항확인"),
        			List.of("jungi@email.com", "예외"));
        	List<String> result = List.of("jungi123@email.com", "jungi@email.com");
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
        @Test
        void makeAllFriendshipTest() {
        	//given
        	String user = "e";
        	List<List<String>> friends = List.of(
                    List.of("a", "b"),
                    List.of("b", "c"),
                    List.of("c", "d"),
                    List.of("e", "f"),
                    List.of("f", "g"),
                    List.of("g", "h"),
                    List.of("h", "i"),
                    List.of("i", "j"),
                    List.of("j", "e")
            );
        	List<String> visitor = new LinkedList<>();
        	Problem7.solution(user, friends, visitor);
        }
        @Test
        void increaseScoreMutualFriend() {
        	//given
        	String user = "e";
        	List<List<String>> friends = List.of(
                    List.of("a", "b"),
                    List.of("b", "c"),
                    List.of("c", "d"),
                    List.of("e", "f"),
                    List.of("f", "e"),
                    List.of("g", "h"),
                    List.of("h", "i")
            );
        	List<String> visitor = new LinkedList<>();
        	Problem7.solution(user, friends, visitor);
        }
        @Test
        void test1() {
        	//given
        	String user = "aa";
        	List<List<String>> friends = List.of(
                    List.of(user, "bbb"),
                    List.of("ccc", user),
                    List.of(user, "ddd"),
                    List.of(user, "eee"),
                    List.of("abc", "bbb"),
                    List.of("abc", "ccc"),
                    List.of("abc", "ddd"),
                    List.of("abc", "eee"),
                    
                    List.of("aba", "bbb"),
                    List.of("aba", "ccc"),
                    List.of("aba", "ddd"),
                    List.of("aba", "eee"),
                    
                    List.of("abb", "bbb"),
                    List.of("abb", "ccc"),
                    List.of("abb", "ddd"),
                    List.of("abb", "eee"),
                    
                    List.of("aab", "bbb"),
                    List.of("aab", "ccc"),
                    List.of("aab", "ddd"),
                    List.of("aab", "eee"),
                    
                    List.of("c", "bbb"),
                    List.of("c", "ccc"),
                    List.of("c", "ddd"),
                    List.of("c", "eee"),
                    
                    List.of("b", "bbb"),
                    List.of("b", "ccc"),
                    List.of("b", "ddd"),
                    List.of("b", "eee")
            );
        	List<String> visitor = new LinkedList<>();
        	//given
        	List<String> result = List.of("aab", "aba", "abb", "abc", "b");
        	//then
        	assertThat(Problem7.solution(user, friends, visitor)).isEqualTo(result);
        	
        	//when
        	for(int i=0; i<40; i++) {
        		visitor.add("aaaa");
        		visitor.add(user);
        	}
        	//given
        	List<String> newResult = List.of("aaaa", "aab", "aba", "abb", "abc");
        	assertThat(Problem7.solution(user, friends, visitor)).isEqualTo(newResult);
        }
    }
}
