package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
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


        //리스트첫번째친구목록이있는경우
        @Test
        void case2(){
            String user="mrko";
            List<List<String>>friends=List.of(
                    List.of("donut","unio"),
                    List.of("donut","uazo"),
                    List.of("donut","mrko"),
                    List.of("shakevan","seri"),
                    List.of("shakevan","uazi"),
                    List.of("shakevan","mrko"),
                    List.of("jun","mrko"),
                    List.of("jun","unio"),
                    List.of("jun","shakevan"),
                    List.of("kevin","donut"),
                    List.of("kevin","shakevan"),
                    List.of("kevin","jun")
            );
            List<String>visitors=List.of("bedi","bedi","donut","bedi","shakevan");
            List<String>result=List.of("kevin","unio","seri","uazi","uazo");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }
        //추천할친구가없는경우
        @Test
        void case3(){
            String user="youdik";
            List<List<String>>friends=List.of(
                    List.of("donut","youdik"),
                    List.of("youdik","jun"),
                    List.of("youdik","kevin"),
                    List.of("shakevan","youdik"),
                    List.of("uazo","youdik")
            );
            List<String>visitors=List.of("donut","jun","shakevan","uazo","shakevan");
            List<String>result=Collections.emptyList();
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }

        @Test
        void case4(){
            String user="mrko";
            List<List<String>>friends=List.of(
                    List.of("mrko","jun"),
                    List.of("donut","jun"),
                    List.of("donut","mrko"),
                    List.of("shakevan","andole"),
                    List.of("shakevan","jun"),
                    List.of("shakevan","mrko")
            );
            List<String>visitors=List.of("bedi","bedi","donut","bedi","shakevan");
            List<String>result=List.of("andole","bedi");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }
        @Test
        void case5(){
            String user="mrko";
            List<List<String>>friends=List.of(
                    List.of("mrko","jun"),
                    List.of("donut","jun"),
                    List.of("donut","mrko"),
                    List.of("shakevan","andole"),
                    List.of("jun","andole"),
                    List.of("shakevan","jun"),
                    List.of("shakevan","mrko")
            );
            List<String>visitors=List.of("bedi","bedi","donut","bedi","shakevan");
            List<String>result=List.of("andole","bedi");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }
        @Test
        void case6(){
            String user="mrko";
            List<List<String>>friends=List.of(
                    List.of("mrko","jun"),
                    List.of("bedi","jun"),
                    List.of("bedi","donut"),
                    List.of("donut","jun"),
                    List.of("donut","mrko"),
                    List.of("shakevan","andole"),
                    List.of("jun","andole"),
                    List.of("shakevan","jun"),
                    List.of("shakevan","mrko")
            );
            List<String>visitors=List.of("donut","shakevan");
            List<String>result=List.of("andole","bedi");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }
        @Test
        void case7(){
            String user="andole";
            List<List<String>>friends=List.of(
                    List.of("andole","jun"),
                    List.of("donut","jun"),
                    List.of("donut","shakevan"),
                    List.of("shakevan","andole"),
                    List.of("shakevan","jun"),
                    List.of("shakevan","bedi"),
                    List.of("anne","jun")
            );
            List<String>visitors=List.of("donut","mrko","petter","sam");
            List<String>result=List.of("donut","anne","bedi","mrko","petter");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }
        @Test
        void case8(){
            String user="andole";
            List<List<String>>friends=List.of(
                    List.of("andole","jun"),
                    List.of("andole","bedi"),
                    List.of("jun","shakevan"),
                    List.of("jun","kane"),
                    List.of("jun","sam"),
                    List.of("bedi","shakevan"),
                    List.of("bedi","anne"),
                    List.of("bedi","sam"),
                    List.of("anne","mrko")
            );
            List<String>visitors=List.of("donut","anne","mrko","mrko","sam");
            List<String>result=List.of("sam","shakevan","anne","kane","mrko");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }
        @Test
        void case9(){
            String user="hello";
            List<List<String>>friends=List.of(
                    List.of("andole","jun"),
                    List.of("andole","bedi"),
                    List.of("jun","shakevan"),
                    List.of("jun","kane"),
                    List.of("jun","sam"),
                    List.of("bedi","shakevan"),
                    List.of("bedi","anne"),
                    List.of("bedi","sam"),
                    List.of("anne","mrko")
            );
            List<String>visitors=List.of("donut","anne","mrko","mrko","sam");
            List<String>result=List.of("mrko","anne","donut","sam");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }

        @Test
        void case10(){
            String user="hello";
            List<List<String>>friends=List.of(
                    List.of("hello","jun"),
                    List.of("hello","bedi"),
                    List.of("hello","shakevan"),
                    List.of("hello","kane"),
                    List.of("jun","sam"),
                    List.of("jun","shakevan"),
                    List.of("jun","anne"),
                    List.of("bedi","sam"),
                    List.of("bedi","anne"),
                    List.of("bedi","mrko"),
                    List.of("shakevan","anne"),
                    List.of("shakevan","sam"),
                    List.of("shakevan","bedi"),
                    List.of("kane","donut"),
                    List.of("kane","anne")
            );
            List<String>visitors=List.of("kyoun","andole","kyoun","abbun","andole","abbun","hi","ohoh","hi",
                    "stella","kkk");
            List<String>result=List.of("anne","sam","donut","mrko","abbun");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }

        @Test
        void case11(){
            String user="hello";
            List<List<String>>friends=List.of(
                    List.of("hello","jun"),
                    List.of("hello","bedi"),
                    List.of("hello","shakevan"),
                    List.of("hello","kane"),
                    List.of("hello","hi"),
                    List.of("jun","sam"),
                    List.of("jun","shakevan"),
                    List.of("jun","anne"),
                    List.of("bedi","sam"),
                    List.of("bedi","anne"),
                    List.of("bedi","mrko"),
                    List.of("shakevan","anne"),
                    List.of("shakevan","sam"),
                    List.of("shakevan","bedi"),
                    List.of("shakevan","annb"),
                    List.of("kane","donut"),
                    List.of("kane","anne"),
                    List.of("kane","annb"),
                    List.of("hi","annb")
            );
            List<String>visitors=List.of("kyoun","andole","kyoun","abbun","andole","abbun");
            List<String>result=List.of("anne","annb","sam","donut","mrko");
            assertThat(Problem7.solution(user,friends,visitors)).isEqualTo(result);
        }

    }
}
