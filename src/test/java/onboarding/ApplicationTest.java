package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import problem7.FriendConnectionRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            List<Integer> pobi = List.of(2, 3);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case5() {
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(399, 400);
            int result = 2;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case6() {
            List<Integer> pobi = List.of(-1, 0);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case7() {
            List<Integer> pobi = List.of(401, 402);
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

        @Test
        void case3(){
            String cryptogram = "abbaa";
            String result = "a";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case4() {
            String cryptogram = "a";
            String result = "a";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void empty_param_exception() {
            String cryptogram = "";
            String result = null;
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void null_param_exception() {
            String cryptogram = "";
            String result = null;
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void param_length_exception() {
            String cryptogram = "a".repeat(1001);
            String result = null;
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void parameter_duplication_more_than_2() {
            String cryptogram = "abbbbccbbbbaa";
            String result = "a";
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
            int number = 10000;
            int result = 12000;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case4() {
            int number = 333;
            int result = 228;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void parameter_under1_return_minus_one() {
            int number = 0;
            int result = -1;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void parameter_over10000_return_minus_one() {
            int number = 10001;
            int result = -1;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void parameter_1_return_0() {
            int number = 1;
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
        void case2() {
            String word = "Svool, Dliow! 123";
            String result = "Hello, World! 123";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }


        @Test
        void parameter_mixed_upper_and_lower() {
            String word = "I   lOve  YoU";
            String result = "R   oLev  BlF";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void parameter_length_under1_exception() {
            String word = "";
            String result = "";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void parameter_length_over1000_exception() {
            String word = "A".repeat(1001);
            String result = word;
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void parameter_nonalphabetic_letter() {
            String word = "I& love you";
            String result = "R& olev blf";;
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
        void money_big_amount() {
            int money = 999_999;
            List<Integer> result = List.of(19, 4, 1, 4, 1, 4, 1, 4, 9);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void money_small_amount() {
            int money = 1;
            List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 1);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void money_amount_under1_exception() {
            int money = 0;
            List<Integer> result = null;
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void money_amount_over1000000_exception() {
            int money = 1000001;
            List<Integer> result = null;
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
        void multiple_duplications() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니니아"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠"),
                    List.of("abc@email.com", "니니아"),
                    List.of("abcd123@email.com", "홀롤홀롤")
            );

            List<String> result = List.of("abc@email.com"
                    , "jason@email.com"
                    , "jm@email.com"
                    , "mj@email.com"
                    , "woniee@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void email_domain_exception() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@wooteco.com", "제이슨"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = null;
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void email_format_exception() {
            List<List<String>> forms = List.of(
                    List.of("jm한글@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = null;
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void nickname_not_korean_exception() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "j엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = null;
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
        void same_score_sort_by_name() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("jun", "mrko"),
                    List.of("donut", "bedi"),
                    List.of("jun", "bedi"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "jun"),
                    List.of("andole", "jun"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("donut", "shakevan");
            List<String> result = List.of("andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }


        @Test
        void return_value_size_limit_by_five() {
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
            List<String> visitors = List.of("donut", "mrko", "peter", "sam", "axe");
            List<String> result = List.of("donut", "anne", "bedi", "axe", "mrko");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }


        @Test
        void user_no_friend() {
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
        void friends_connection_getFriends() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            FriendConnectionRepository.create(friends);
            Set<String> donutFriends = FriendConnectionRepository.getFriends("donut");
            Set<String> mrkoFriends = FriendConnectionRepository.getFriends("mrko");

            assertThat(donutFriends).isEqualTo(new HashSet<>(List.of("andole", "jun", "mrko")));
            assertThat(mrkoFriends).isEqualTo(new HashSet<>(List.of("donut", "shakevan")));

        }

        @Test
        void friend_length_over_2_exception() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko", "sbd"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = null;
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void friends_length_over_10000_exception() {
            String user = "mrko";
            List<List<String>> friends = IntStream.range(0, 10001)
                                    .mapToObj(i -> List.of("a", "b"))
                                    .collect(Collectors.toList());
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = null;
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void visitors_length_over_10000_exception() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = IntStream.range(0, 10001)
                    .mapToObj(i -> String.valueOf(i))
                    .collect(Collectors.toList());
            List<String> result = null;
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void friends_self_friend_exception() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("jun", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("donut");
            List<String> result = null;
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
