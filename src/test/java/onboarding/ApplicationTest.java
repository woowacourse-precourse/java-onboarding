package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
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
        void case4() {
            List<Integer> pobi = List.of(-11,-10 );
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case5() {
            List<Integer> pobi = List.of(1,2 );
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case6() {
            List<Integer> pobi = List.of(211,212 );
            List<Integer> crong = List.of(399,400);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case7() {
            List<Integer> pobi = List.of(200,201 );
            List<Integer> crong = List.of(397,398);
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
        void case3() {
            String cryptogram = "zz";
            Boolean result=true;
            assertThat(Problem2.duplicate(cryptogram,0)).isEqualTo(result);
        }

        @Test
        void case4() {
            String cryptogram = "zx";
            Boolean result=false;
            assertThat(Problem2.duplicate(cryptogram,0)).isEqualTo(result);
        }
        @Test
        void case5() {
            String cryptogram = "ccccccccccc";
            String result="c";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case6() {
            String cryptogram = "cccccccccc";
            String result="";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case7() {
            String cryptogram = "c";
            String result="c";
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
        void case3() {
            int number = 3;
            Boolean result = true;
            assertThat(Problem3.check369(number)).isEqualTo(result);
            number = 2;
            result = false;
            assertThat(Problem3.check369(number)).isEqualTo(result);
        }

        @Test
        void case4() {
            int number = 3543;
            int[] result= {3,5,4,3};
            assertThat(Problem3.converter(number)).isEqualTo(result);
        }
        @Test
        void case5() {
            int number = 10000;
            int result= 12000;
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
        void case2() {
            String word = "@!#!@# 13123!@Z";
            String result = "@!#!@# 13123!@A";
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
        void case2(){
            String s="apple";
            List<String> result = List.of("ap", "pp", "pl","le");
            assertThat(Problem6.subStrings(s)).isEqualTo(result);
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
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan","jun");
            List<String> result = List.of("jun","andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case2(){
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko"),
                    List.of("mrko","hojin")
            );
            List<String> result=List.of("donut","shakevan","hojin");
            assertThat(Problem7.findFriends(user, friends)).isEqualTo(result);
        }
        @Test
        void case3(){
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> result=List.of("andole","jun","andole","jun");
            assertThat(Problem7.findAcquaintance(user,Problem7.findFriends(user,friends), friends)).isEqualTo(result);
        }

        @Test
        void case4(){
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            HashMap<String,Integer> result=new HashMap<>();
            result.put("andole",20);
            result.put("jun",20);
            assertThat(Problem7.friendScoreCalculator(Problem7.findAcquaintance(user,Problem7.findFriends(user,friends), friends))).isEqualTo(result);
        }
        @Test
        void case5(){
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
            HashMap<String,Integer> result=new HashMap<>();
            result.put("andole",20);
            result.put("jun",20);
            result.put("bedi",3);
            result.put("donut",1);
            result.put("shakevan",1);
            assertThat(Problem7.visitScoreCalculator(Problem7.friendScoreCalculator(Problem7.findAcquaintance(user,Problem7.findFriends(user,friends), friends)),visitors)).isEqualTo(result);
        }
    }
    @Test
    void case6() {
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
}
