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
    
        @Test
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이제이")
            );
            List<String> result = List.of();
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이제이"),
                    List.of("eya@email.com", "이야")
            );
            List<String> result = List.of();
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case4() {
            List<List<String>> forms = List.of(
                    List.of("g@email.com", "제이제이"),
                    List.of("d@email.com", "이제이제"),
                    List.of("e@email.com", "제이"),
                    List.of("a@email.com", "이제"),
                    List.of("c@email.com", "제이야"),
                    List.of("b@email.com", "아제이"),
                    List.of("f@email.com", "이야")
            );
            List<String> result = List.of("a@email.com", "b@email.com", "c@email.com", "d@email.com", "e@email.com", "f@email.com", "g@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case5() {
            List<List<String>> forms = List.of(
                    List.of("ga@email.com", "제이제이"),
                    List.of("dbb@email.com", "이제이제"),
                    List.of("ec@email.com", "제이"),
                    List.of("ad@email.com", "이제"),
                    List.of("cee@email.com", "제이야"),
                    List.of("bfff@email.com", "아제이"),
                    List.of("fg@email.com", "이야")
            );
            List<String> result = List.of("ad@email.com", "bfff@email.com", "cee@email.com", "dbb@email.com", "ec@email.com", "fg@email.com", "ga@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case6() {
            List<List<String>> forms = List.of(
                    List.of("ga@email.com", "제이제이"),
                    List.of("dbb@email.com", "이제이제"),
                    List.of("ec@email.com", "제이"),
                    List.of("ad@email.com", "이제"),
                    List.of("cee@email.com", "제이야"),
                    List.of("bfff@email.com", "아제이"),
                    List.of("fg@email.com", "이야"),
                    List.of("adg@email.com", "이")
            );
            List<String> result = List.of("ad@email.com", "bfff@email.com", "cee@email.com", "dbb@email.com", "ec@email.com", "fg@email.com", "ga@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case7() {
            List<List<String>> forms = List.of(
                    List.of("jm1@email.com", "제이제이"),
                    List.of("jm2@email.com", "제"),
                    List.of("jm3@email.com", "이")
            );
            List<String> result = List.of();
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case8() {
            List<List<String>> forms = List.of(
                    List.of("jm3@email.com", "제이제이"),
                    List.of("jm1@email.com", "제이"),
                    List.of("jm2@email.com", "이제")
            );
            List<String> result = List.of("jm1@email.com", "jm2@email.com", "jm3@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case9() {
            List<List<String>> forms = List.of(
                    List.of("onepiece@email.com", "원피수"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("onepisu@email.com", "원피수"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("suonepi@email.com", "수원피")
            );
            List<String> result = List.of("jason@email.com",  "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case10() {
            List<List<String>> forms = List.of(
                    List.of("onepiece@email.com", "ㅡ피수"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("onepisu@email.com", "ㅡ피수"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("suonepi@email.com", "수ㅡ피")
            );
            List<String> result = List.of("jason@email.com",  "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case11() {
            List<List<String>> forms = List.of(
                    List.of("사a@email.com", "제이제이"),
                    List.of("라b@email.com", "이제이제"),
                    List.of("마c@email.com", "제이"),
                    List.of("가d@email.com", "이제"),
                    List.of("다e@email.com", "제이야"),
                    List.of("나f@email.com", "아제이"),
                    List.of("바g@email.com", "이")
            );
            List<String> result = List.of("가d@email.com", "나f@email.com", "다e@email.com", "라b@email.com", "마c@email.com", "사a@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case12() {
            List<List<String>> forms = List.of(
                    List.of("사a@email.com", "제이제이"),
                    List.of("ㄱb@email.com", "이제이제"),
                    List.of("마c@email.com", "제이"),
                    List.of("가나다라마바사아자@email.com", "이제"),
                    List.of("ㄴe@email.com", "제이야"),
                    List.of("나f@email.com", "아제이"),
                    List.of("바g@email.com", "이"),
                    List.of("abcdefgh@email.com", "가나다라마바사아자차카타파하가나다라마"),
                    List.of("abcdefghi@email.com", "기리기리기리기리기리기리기리기리기이제")
            );
            List<String> result = List.of("abcdefghi@email.com", "ㄱb@email.com", "ㄴe@email.com", "가나다라마바사아자@email.com", "나f@email.com", "마c@email.com", "사a@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case13() {
            List<List<String>> forms = List.of(
                    List.of("사a@email.com", "제이제이"),
                    List.of("ㄱb@email.com", "이제이제"),
                    List.of("마c@email.com", "제이"),
                    List.of("가나다라마바사아자@email.com", "이제"),
                    List.of("ㄴe@email.com", "제이야"),
                    List.of("나f@email.com", "아제이"),
                    List.of("바g@email.com", "이"),
                    List.of("abcdefgh@email.com", "가나다라마바사아자차카타파하가나다라마"),
                    List.of("abcdefghi@email.com", "기리기리기리이제기리기리기리기리기리기")
            );
            List<String> result = List.of("abcdefghi@email.com", "ㄱb@email.com", "ㄴe@email.com", "가나다라마바사아자@email.com", "나f@email.com", "마c@email.com", "사a@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case14() {
            List<List<String>> forms = List.of(
                    List.of("사a@email.com", "제이제이"),
                    List.of("ㄱb@email.com", "이제이제"),
                    List.of("마c@email.com", "제이"),
                    List.of("가나다라마바사아자@email.com", "이제"),
                    List.of("ㄴe@email.com", "제이야"),
                    List.of("나f@email.com", "아제이"),
                    List.of("바g@email.com", "이"),
                    List.of("abcdefgh@email.com", "가나다라마바사아자차카타파하가나다라마"),
                    List.of("abcdefghi@email.com", "이제기리기리기리기리기리기리기리기리기")
            );
            List<String> result = List.of("abcdefghi@email.com", "ㄱb@email.com", "ㄴe@email.com", "가나다라마바사아자@email.com", "나f@email.com", "마c@email.com", "사a@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case15() {
            List<List<String>> forms = List.of(
                    List.of("kim@email.com", "김ㅡ이"),
                    List.of("nam@email.com", "ㅡ이야"),
                    List.of("choi@email.com", "최강"),
                    List.of("lee@email.com", "강합니다"),
                    List.of("jun@email.com", "왜ㅇㅡ이야")
            );
            List<String> result = List.of("jun@email.com", "kim@email.com", "nam@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    
        @Test
        void case16() {
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
            List<String> result = List.of("apple@email.com",
                    "banana@email.com",
                    "jason@email.com",
                    "jm@email.com",
                    "jp@email.com",
                    "mj@email.com",
                    "nowm@email.com",
                    "qpw@email.com",
                    "secondJm@email.com",
                    "stran@email.com",
                    "teemo@email.com",
                    "zebra@email.com");
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
                    List.of("donut", "andol"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("jun", "andol", "andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case3() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("andole", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case4() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andol"),
                    List.of("donut", "junn"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "junb"),
                    List.of("shakevan", "juna"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andol", "andole", "jun", "juna", "junb");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case5() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andol"),
                    List.of("donut", "junn"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "junb", "juna");
            List<String> result = List.of("andol", "andole", "jun", "junn", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case6() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andol"),
                    List.of("donut", "junn"),
                    List.of("junn", "junns"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "junb", "juna");
            List<String> result = List.of("andol", "andole", "jun", "junn", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case7() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("jun", "junn"),
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
        void case8() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "donut")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("shakevan", "andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case9() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("jun");
            List<String> result = List.of("jun");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case10() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("shakevan", "mrko"),
                    List.of("shakevan", "jun")
            );
            List<String> visitors = List.of();
            List<String> result = List.of("jun");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case11() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("shakevan", "junn"),
                    List.of("shakevan", "jun")
            );
            List<String> visitors = List.of("abc");
            List<String> result = List.of("abc");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case12() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("jun", "andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
        
        @Test
        void case13() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("jun", "bedi", "andole");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case14() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("mrko", "jun"),
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
        void case15() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("mrko", "jun"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("jun", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    
        @Test
        void case16() {
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
        void case17() {
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
        void case18() {
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
}
