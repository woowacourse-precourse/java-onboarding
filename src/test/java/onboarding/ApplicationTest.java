package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

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

        @Test
        void checkDuplicateCharTest(){
            String cryptogram = "abcdde";
            boolean[] arr =new boolean[cryptogram.length()];
            arr[3] = true;
            arr[4] = true;
            assertThat(checkIsSame(Problem2.checkDuplicateChar(cryptogram), arr)).isEqualTo(true);
        }

        @Test
        void getNewStringTest(){
            String cryptogram ="browoanoommnaon";
            String answer = "browoannaon";
            boolean[] arr = new boolean[cryptogram.length()];
            arr[7] = true;
            arr[8] = true;
            arr[9] = true;
            arr[10] = true;

            assertThat(Problem2.getNewString(cryptogram,arr)).isEqualTo(answer);
        }

        boolean checkIsSame(boolean[] isDuplicate, boolean[] arr){

            for(int i=0; i<arr.length; i++){
                if(arr[i]!=isDuplicate[i])return false;
            }
            return true;
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
        void countAllClapInNumberTest(){
            int number = 1334;
            int result = 2;
            assertThat(Problem3.countAllClapInNumber(number)).isEqualTo(result);
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
        void convertCharacterTest(){
            char ch1 = 'C';
            char result1 = 'X';
            char ch2 = 'e';
            char result2 = 'v';
            assertThat(Problem4.convertCharacter('A', ch1)).isEqualTo(result1);
            assertThat(Problem4.convertCharacter('a', ch2)).isEqualTo(result2);
        }

        @Test
        void convertTest(){
            char ch1 = 'C';
            char ch2 = 'a';
            char ch3 = '!';
            assertThat(Problem4.convert(ch1)).isEqualTo('X');
            assertThat(Problem4.convert(ch2)).isEqualTo('z');
            assertThat(Problem4.convert(ch3)).isEqualTo('!');
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
        void calculateRequiredMoneyTest(){
            List<Integer> ans = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0,0));
            List<Integer> result = List.of(0, 4, 0, 0, 0, 0, 0, 0, 0);
            Problem5.calculateRequiredMoneyCount(45000,1,ans);

            for(int i=0; i<9; i++)
                assertThat(ans.get(i)).isEqualTo(result.get(i));
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
        void determineIsDuplicateTest(){
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            boolean[] isDuplicate = new boolean[forms.size()];
            Map<String, Integer> twoChars = new HashMap<>();
            boolean result = true;
            Problem6.determineIsDuplicate(forms,  twoChars, isDuplicate, 0);
            Problem6.determineIsDuplicate(forms,  twoChars, isDuplicate, 1);
            Problem6.determineIsDuplicate(forms,  twoChars, isDuplicate, 2);
            assertThat(isDuplicate[0]).isEqualTo(result);
            assertThat(isDuplicate[1]).isEqualTo(result);
            assertThat(isDuplicate[2]).isEqualTo(!result);
        }
        @Test
        void addEmailTest(){
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            Set<String> emails = new HashSet<>();
            List<String> ans = new ArrayList<>();
            Problem6.addEmail(emails,"jm@email.com",true, ans);
            Problem6.addEmail(emails, "hello@email.com", false, ans);
            Problem6.addEmail(emails, "jm@email.com", true, ans);
            assertThat(ans.size()).isEqualTo(1);
            assertThat(!emails.contains("hello@email.com")).isEqualTo(true);
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
        void initializeRelationTest() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            Map<String, List<String>> relation = Problem7.initializeRelation(friends);
            List<String> friendsOfUser = relation.get(user);
            assertThat(friendsOfUser.contains("jun")).isEqualTo(false);
            assertThat(friendsOfUser.contains("donut")).isEqualTo(true);
            assertThat(friendsOfUser.contains("andole")).isEqualTo(false);
        }

        @Test
        void addPointToRecommendedTest(){
            String friend = "mrko";
            Map<String, Integer> recommend = new HashMap<>();
            Map<String, List<String>> relation = new HashMap<>();

            relation.put(friend, new ArrayList<>());
            relation.get(friend).add("donut");
            relation.get(friend).add("doa");
            Problem7.addPointToRecommended(relation, recommend, "mrko");

            int result = 10;
            assertThat(recommend.size()).isEqualTo(2);
            assertThat(recommend.get("donut")).isEqualTo(result);
        }
    }
}
