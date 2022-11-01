package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class customApplicationTest
{
    @Nested
    class Problem1Test {
//        @Test
//        void sum()
//        {
//            List<Integer> human = List.of(123,124);
//            List<Integer> results = Arrays.asList(6,7);
//            assertThat(Problem1.sum(human)).isEqualTo(results);
//        }
//
//        @Test
//        void mul()
//        {
//            List<Integer> human = List.of(123,124);
//            List<Integer> results = Arrays.asList(6,8);
//            assertThat(Problem1.mul(human)).isEqualTo(results);
//        }
//
//        @Test
//        void max()
//        {
//            List<Integer> human = List.of(123,124);
//            int result = 8;
//            assertThat(Problem1.max(Problem1.sum(human),Problem1.mul(human))).isEqualTo(result);
//        }
//        @Test
//        void compare1()
//        {
//            int pobi = 1;
//            int crong = 2;
//            int result = 2;
//            assertThat(Problem1.compare(pobi,crong)).isEqualTo(result);
//        }
//        @Test
//        void compare2()
//        {
//            int pobi = 2;
//            int crong = 1;
//            int result = 1;
//            assertThat(Problem1.compare(pobi,crong)).isEqualTo(result);
//        }
//        @Test
//        void compare3() {
//            int pobi = 1;
//            int crong = 1;
//            int result = 0;
//            assertThat(Problem1.compare(pobi, crong)).isEqualTo(result);
//        }
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
        void case4() {
            List<Integer> pobi = List.of(99, 103);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case5() {
            List<Integer> pobi = List.of(399, 401);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case6() {
            List<Integer> pobi = List.of(399, 401, 300);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case7() {
            List<Integer> pobi = List.of(400, 401);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case8() {
            List<Integer> pobi = List.of(392, 391);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
//        @Test
//        void isUpperCaseException() {
//            String cryptogram = "BBB";
//            String result = "answer";
//            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
//        }
//
//        @Test
//        void rangeCaseException() {
//            String cryptogram = "";
//            String result = "answer";
//            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
//        }
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
        void case3() {
            String cryptogram = "zyellleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case6() {
            String cryptogram = "aazzqweqweaaq";
            String result = "qweqweq";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case7() {
            String cryptogram = "Aaazzqweqweaaq";
            String result = "answer";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case4() {
            String cryptogram = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case5() {
            String cryptogram = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
            String result = "answer";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
//        @Test
//        void case1() {
//            int number = 0;
//            int result = 0;
//            assertThat(Problem3.solution(number)).isEqualTo(result);
//        }
//
//        @Test
//        void case2() {
//            int number = 10001;
//            int result = 0;
//            assertThat(Problem3.solution(number)).isEqualTo(result);
//        }
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
        void case3() {
            int number = 333;
            int result = 228;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
        @Test
        void case4() {
            int number = 0;
            int result = 0;
            assertThat(Problem3.solution(number)).isEqualTo(0);
        }
    }

    @Nested
    class Problem4Test {
//        @Test
//        void case1() {
//            char alphabet = '0';
//            char result = '0';
//            assertThat(Problem4.mixer(alphabet,false)).isEqualTo(result);
//        }
//        @Test
//        void case2() {
//            char alphabet = 'A';
//            char result = 'Z';
//            assertThat(Problem4.mixer(alphabet,true)).isEqualTo(result);
//        }
//        @Test
//        void case3() {
//            char alphabet = 'a';
//            char result = 'z';
//            assertThat(Problem4.mixer(alphabet,false)).isEqualTo(result);
//        }
//        @Test
//        void case4() {
//            String word = "Svool, Dliow! 123";
//            String result = "Hello, World! 123";
//            assertThat(Problem4.solution(word)).isEqualTo(result);
//        }
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
        @Test
        void case2() {
            String word = "abcdefghijklmnopqrstuvwxyZ !@#!#";
            String result = "zyxwvutsrqponmlkjihgfedcbA !@#!#";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
        @Test
        void case3() {
            String word = "안녕I love you";
            String result = "안녕R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
        @Test
        void case4() {
            String word = "";
            String result = "";
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
        @Test
        void case3() {
            int money = 0;
            assertThat(Problem5.solution(money));
        }
    }

    @Nested
    class Problem6Test {
//        @Test
//        void case1() {
//         List<List<String>> forms = List.of(
//                    List.of("jm@email.co", "제이엠"));
//            List<String> result = List.of("Email");
//            assertThat(Problem6.solution(forms)).isEqualTo(result);
//        }
//        @Test
//        void case2() {
//            List<List<String>> forms = List.of(
//                    List.of("dddddddddddddddddddjm@email.com", "제이엠"));
//            List<String> result = List.of("Range");
//            assertThat(Problem6.solution(forms)).isEqualTo(result);
//        }
//        @Test
//        void case3() {
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠제이엠제이엠제이엠제이엠제이엠제이엠제이엠제이엠제이엠"));
//            List<String> result = List.of("Range");
//            assertThat(Problem6.solution(forms)).isEqualTo(result);
//        }
//        @Test
//        void case4() {
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠ddd"));
//            List<String> result = List.of("korean");
//            assertThat(Problem6.solution(forms)).isEqualTo(result);
//        }
//        @Test
//        void case5() {
//            List<List<String>> forms = new ArrayList<>();
//            List<String> result = List.of("Range");
//            assertThat(Problem6.solution(forms)).isEqualTo(result);
//        }
//        @Test
//        void case6()
//        {
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠"));
//            List<String> result = List.of("제이","이엠");
//            assertThat(Problem6.stringTrim2(forms)).isEqualTo(result);
//        }
//        @Test
//        void case7()
//        {
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠"),
//                    List.of("jdm@email.com", "제이엠"),
//                    List.of("jam@email.com", "제이엠"),
//                    List.of("jxam@email.com", "제이엠"));
//            List<String> tmp = Problem6.stringTrim2(forms);
//            List<String> result = List.of("제이","이엠");
//            List<Integer> deleteIdx= Problem6.deleteIdx(tmp,Problem6.nickNameList(forms));
//            assertThat(Problem6.deleteForms(forms,deleteIdx)).isEqualTo(result);
//        }
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
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("jason@email.com", "제이슨"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("onepiece@email.com", "원피수"),
                    List.of("onepisu@email.com", "원피수"),
                    List.of("suonepi@email.com", "수원피")
            );
            List<String> result = List.of("jason@email.com", "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
        @Test
        void case4() {
            List<List<String>> forms = List.of(
                    List.of("test@email.com","1"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("onepiece@email.com", "원피수"),
                    List.of("onepisu@email.com", "원피수"),
                    List.of("suonepi@email.com", "수원피"),
                    List.of("suonepi@naver.com", "수원피스"),
                    List.of("suonepi@abc.com", "피스피"),
                    List.of("suonepiaaaaaaaaaaaaaaaaaa@abc.com", "피스"),
                    List.of("suonepiaaaa@abc.com", ""),
                    List.of("abcd@abc.com", "피스peace")
            );
            List<String> result = List.of("jason@email.com", "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
        @Test
        void case2() {
            List<List<String>> forms = List.of();
            assertThat(Problem6.solution(forms));
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
        void case2() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.myFriendsSearch(user, friends)).isEqualTo(result);
        }
    }

}
