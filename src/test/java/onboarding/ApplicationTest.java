package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        void case4(){
            List<Integer> pobi = List.of(101, 102);
            List<Integer> crong = List.of(101, 102);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

//        @Test
//        void isCorrectSize(){
//            List<Integer> pobi = List.of(101, 102);
//            List<Integer> crong = List.of(41, 42, 43);
//
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
//        }
//
//        @Test
//        void isCorrectRange1(){
//            List<Integer> pobi = List.of(1, 2);
//            List<Integer> crong = List.of(41, 42);
//
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
//        }
//        @Test
//        void isCorrectRange2(){
//            List<Integer> pobi = List.of(10, 11);
//            List<Integer> crong = List.of(399, 400);
//
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
//        }
//
//        @Test
//        void isConsecutive(){
//            List<Integer> pobi = List.of(11, 14);
//            List<Integer> crong = List.of(399, 400);
//
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
//        }
//
//        @Test
//        void leftOddCheck(){
//            List<Integer> pobi = List.of(10, 12);
//            List<Integer> crong = List.of(399, 400);
//
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
//        }
//
//        @Test
//        void rightEvenCheck(){
//            List<Integer> pobi = List.of(11, 12);
//            List<Integer> crong = List.of(398, 399);
//
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
//        }
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

//        @Test
//        void case3() {
//            String cryptogram = "zzeeelleyz";
//            String result = "eyz";
//            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
//        }

//        @Test
//        void isCorrectSize1() {
//            String cryptogram = "";
//            assertThat(Problem2.Validator.isValidate(cryptogram)).isFalse();
//        }
//
//        @Test
//        void isCorrectSize2() {
//            String cryptogram = "adbawkbdadjvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkbdajvbjkzbvkjznsckascasadbawkb";
//            assertThat(Problem2.Validator.isValidate(cryptogram)).isFalse();
//        }
//
//        @Test
//        void isOnlyLowerCase() {
//            String cryptogram = "zyelleAyz";
//            assertThat(Problem2.Validator.isValidate(cryptogram)).isFalse();
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

//        @Test
//        void isCorrectRange1() {
//            int number = 0;
//            assertThat(Problem3.Validator.isValidate(number)).isFalse();
//        }
//
//        @Test
//        void isCorrectRange2() {
//            int number = 10001;
//            assertThat(Problem3.Validator.isValidate(number)).isFalse();
//        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

//        @Test
//        void correctSizeTest(){
//            String word = "";
//            assertThat(Problem4.Validator.isValidate(word)).isFalse();
//        }
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
            int money = 12345;
            List<Integer> result = List.of(0, 1, 0, 2, 0, 3, 0, 4, 5);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

//        @Test
//        void correctRangeTest1(){
//            int money = 0;
//            assertThat(Problem5.Validator.isValidate(money)).isFalse();
//        }
//
//        @Test
//        void correctRangeTest2(){
//            int money = 1000001;
//            assertThat(Problem5.Validator.isValidate(money)).isFalse();
//        }
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

//        @Test
//        void crewCountTest(){
//            List<List<String>> forms = List.of();
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
//
//        @Test
//        void emailFormTest1(){
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠"),
//                    List.of("nowm@emaail.com", "이제엠")
//            );
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
//
//        @Test
//        void emailFormTest2(){
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠"),
//                    List.of("nowm@email.co", "이제엠")
//            );
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
//
//        @Test
//        void emailSizeTest1(){
//            List<List<String>> forms = List.of(
//                    List.of("jmasdadasd@email.com", "제이엠"),
//                    List.of("nowm@email.co", "이제엠")
//            );
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
//
//        @Test
//        void emailSizeTest2(){
//            List<List<String>> forms = List.of(
//                    List.of("@email.com", "제이엠"),
//                    List.of("nowm@email.co", "이제엠")
//            );
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
//
//        @Test
//        void nickNameTest1(){
//            List<List<String>> forms = List.of(
//                    List.of("jason@email.com", ""),
//                    List.of("woniee@email.com", "워니")
//            );
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
//
//        @Test
//        void nickNameTest2(){
//            List<List<String>> forms = List.of(
//                    List.of("jason@email.com", "jason"),
//                    List.of("woniee@email.com", "워니")
//            );
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
//
//        @Test
//        void nickNameTest3(){
//            List<List<String>> forms = List.of(
//                    List.of("jason@email.com", "무구정광대다라나니경무구정광대다라나니경"),
//                    List.of("woniee@email.com", "워니")
//            );
//            assertThat(Problem6.Validator.isValidate(forms)).isFalse();
//        }
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
