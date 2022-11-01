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
            List<Integer> pobi = List.of(99, 103);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case5(){
            List<Integer> pobi = List.of(399, 400);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case6(){
            List<Integer> pobi = List.of(401, 402);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case7(){
            List<Integer> pobi = List.of(99, 100);
            List<Integer> crong = List.of(-1, 0);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case8(){
            List<Integer> pobi = List.of(1,2);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case9(){
            List<Integer> pobi = List.of(99, 100);
            List<Integer> crong = List.of(399, 400);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case10(){
            List<Integer> pobi = List.of(121,122);
            List<Integer> crong = List.of(211, 212);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case11(){
            List<Integer> pobi = List.of(121,122,123);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case12(){
            List<Integer> pobi = List.of(121,122);
            List<Integer> crong = List.of(212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case13(){
            List<Integer> pobi = List.of(122,121);
            List<Integer> crong = List.of(211,212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
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
        void case3(){
            String cryptogram = "abbaa";
            String result = "a";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case4(){
            String cryptogram = "aazzqweqweaaq";
            String result = "qweqweq";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case5(){
            String cryptogram = "ksekkset";
            String result = "kseset";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case6(){
            String cryptogram = "aabbb";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case7(){
            String cryptogram = "zyellleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case8(){
            String cryptogram = "zyelllllleyz";
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
        @Test
        void case3(){
            int number = 333;
            int result = 228;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
        @Test
        void case4(){
            int number = 2;
            int result = 0;
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
        void case2(){
            String word = "Hello Everyone!";
            String result = "Svool Veviblmv!";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
        @Test
        void case3(){
            String word = "abcdefghijklmnopqrstuvwxyz";
            String result = "zyxwvutsrqponmlkjihgfedcba";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void case4(){
            String word = "abcdefghijklmnopqrstuvwxyz !@#$#";
            String result = "zyxwvutsrqponmlkjihgfedcba !@#$#";
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
        @Test
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("onepiece@email.com", "원피수"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("onepisu@email.com", "원피수"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("suonepi@email.com", "수원피")
            );
            List<String> result = List.of("jason@email.com","mj@email.com","onepiece@email.com","onepisu@email.com","suonepi@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
        @Test
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("kim@email.com", "김ㅡ이"),
                    List.of("nam@email.com", "ㅡ이야"),
                    List.of("choi@email.com", "최강"),
                    List.of("lee@email.com", "강합니다!"),
                    List.of("jun@email.com", "왜ㅇㅡ이야?")
            );
            List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
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
        void case2() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("mrko","jun"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case3() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("mrko","jun"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("jun","andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case4() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("mrko","jun"),
                    List.of("bedi","jun"),
                    List.of("bedi","donut"),
                    List.of("donut","jun"),
                    List.of("donut","mrko"),
                    List.of("shakevan", "andole"),
                    List.of("jun","andole"),
                    List.of("shakevan","jun"),
                    List.of("shakevan","mrko")
            );
            List<String> visitors = List.of("donut","shakevan");
            List<String> result = List.of("andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case5() {
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
        void case6() {
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

        @Test
        void case7() {
            String user = "hello";
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
            List<String> result = List.of("mrko", "anne", "donut", "sam");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case8(){
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut","jun"),
                    List.of("donut","mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of();
            List<String> result = List.of("andole","jun");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case9() {
            String user = "Walter";
            List<List<String>> friends = List.of(
                    List.of("Christa", "Alyce"),
                    List.of("Hobart", "Retha"),
                    List.of("Elijah", "Josh"),
                    List.of("Cecil", "Lamont"),
                    List.of("Eliza", "Lamont"),
                    List.of("Austyn", "Retha"),
                    List.of("Retha", "Mara" ),
                    List.of("Walter", "Lamont"),
                    List.of("Retha", "Walter"),
                    List.of("Urban", "Walter")
            );
            List<String> visitors = List.of("Cecil", "Eliza", "Adonis", "Mara");
            List<String> result = List.of("Cecil", "Eliza", "Mara", "Austyn", "Hobart");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case10() {
            String user = "Eliza";
            List<List<String>> friends = List.of(
                    List.of("Cecil", "Hobart"),
                    List.of("Austyn", "Mara"),
                    List.of("Adonis", "Eliza"),
                    List.of("Lamont", "Retha"),
                    List.of("Jan", "Christa"),
                    List.of("Milton", "Retha"),
                    List.of("Josh", "Eliza" ),
                    List.of("Eliza", "Jesus"),
                    List.of("Retha", "Eliza")
            );
            List<String> visitors = List.of("Retha", "Rosalia", "Hobart", "Jayne");
            List<String> result = List.of("Lamont", "Milton", "Hobart", "Jayne", "Rosalia");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case11() {
            String user = "Adonis";
            List<List<String>> friends = List.of(
                    List.of("Kali", "Kali"),
                    List.of("Walter", "Urban"),
                    List.of("Adonis", "Mara"),
                    List.of("Eliza", "Lamont"),
                    List.of("Josh", "Milton"),
                    List.of("Jayne", "Elijah"),
                    List.of("Jan", "Urban" ),
                    List.of("Urban", "Adonis"),
                    List.of("Adonis", "Christa"),
                    List.of("Retha", "Adonis")
            );
            List<String> visitors = List.of("Rosalia", "Elijah", "Lamont", "Cecil");
            List<String> result = List.of("Jan", "Walter", "Cecil", "Elijah", "Lamont");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case12() {
            String user = "Jan";
            List<List<String>> friends = List.of(
                    List.of("Lamont", "Christa"),
                    List.of("Mara", "Mara"),
                    List.of("Kali", "Adonis"),
                    List.of("Urban", "Lamont"),
                    List.of("Jesus", "Austyn"),
                    List.of("Rosalia", "Alyce"),
                    List.of("Jan", "Rosalia" ),
                    List.of("Jayne", "Jan"),
                    List.of("Jan", "Adonis"),
                    List.of("Josh", "Jan")
            );
            List<String> visitors = List.of("Adonis", "Cecil", "Adonis", "Eliza", "Josh", "Urban");
            List<String> result = List.of("Alyce", "Kali", "Cecil", "Eliza", "Urban");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
