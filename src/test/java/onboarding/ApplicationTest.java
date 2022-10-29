package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        void case1FindSumMaximumValueTest() {
            List<Integer> test1Digits = List.of(3, 4);
            List<Integer> test2Digits = List.of(45, 46);
            List<Integer> test3Digits = List.of(397, 398);

            assertThat(Problem1.findSumMaxValue(test1Digits)).isEqualTo(4);
            assertThat(Problem1.findSumMaxValue(test2Digits)).isEqualTo(10);
            assertThat(Problem1.findSumMaxValue(test3Digits)).isEqualTo(20);
        }

        @Test
        void findMaxValue() {
            List<Integer> mulMaxData = List.of(247, 248);
            assertThat(Problem1.findMaxValue(mulMaxData)).isEqualTo(64);

            List<Integer> sumMaxData = List.of(121, 122);
            assertThat(Problem1.findMaxValue(sumMaxData)).isEqualTo(5);
        }

        @Test
        void findMulMaxValueTest() {
//            List<Integer> test1Digits = List.of(3, 4);
            List<Integer> test2Digits = List.of(45, 46);
            List<Integer> test3Digits = List.of(119, 200);

//            assertThat(Problem1.findMulMaxValue(test1Digits)).isEqualTo(4);
            assertThat(Problem1.findMulMaxValue(test2Digits)).isEqualTo(24);
            assertThat(Problem1.findMulMaxValue(test3Digits)).isEqualTo(9);
        }

        @Test
        void case1ValidateOddEvenValidationTest() {
            List<Integer> testOddData = List.of(3, 4);

            assertThat(Problem1.checkOddEvenValidation(testOddData)).isEqualTo(true);
        }

        @Test
        void case1ValidateOddEvenValidationExceptionTest() {
            List<Integer> testOddData = List.of(4, 5);

            assertThat(Problem1.checkOddEvenValidation(testOddData)).isEqualTo(false);
        }
        // 페이지 연속성 유효성 검사
        @Test
        void case1ValidateIsSequencePageTest() {
            List<Integer> testSequenceData = List.of(3, 4);

            assertThat(Problem1.checkSequenceValidation(testSequenceData)).isEqualTo(true);
        }

        @Test
        void case1ValidateIsSequencePageExceptionTest() {
            List<Integer> testSequenceData = List.of(3, 6);

            assertThat(Problem1.checkSequenceValidation(testSequenceData)).isEqualTo(false);
        }

        // 시작 면과 마지막 면 유효성 테스트
        @Test
        void case1ValidateStartOrLastPageTest() {
            List<Integer> testValidationData = List.of(4, 5);

            assertThat(Problem1.validateStartOrLastPage(testValidationData)).isEqualTo(true);
        }

        @Test
        void case1ValidateStartOrLastPageExceptionStartTest() {
            List<Integer> testStartPageData = Arrays.asList(1, 2);

            assertThat(Problem1.validateStartOrLastPage(testStartPageData)).isEqualTo(false);
        }

        @Test
        void case1ValidateStartOrLastPageExceptionLastTest() {
            List<Integer> testStartPageData = Arrays.asList(399, 400);

            assertThat(Problem1.validateStartOrLastPage(testStartPageData)).isEqualTo(false);
        }

        @Test
        void validateStartPageExceptionTest() {
            List<Integer> startPageExceptionData = Arrays.asList(1, 2);

            assertThat(Problem1.validatePage(startPageExceptionData)).isEqualTo(false);
        }

        @Test
        void validateLastPageExceptionTest() {
            List<Integer> lastPageExceptionData = Arrays.asList(399, 400);

            assertThat(Problem1.validatePage(lastPageExceptionData)).isEqualTo(false);
        }

        @Test
        void validateSequencePageExceptionTest() {
            List<Integer> sequenceExceptionData = Arrays.asList(5, 8);

            assertThat(Problem1.validatePage(sequenceExceptionData)).isEqualTo(false);
        }

        @Test
        void validateOddPageExceptionTest() {
            List<Integer> oddExceptionData = Arrays.asList(4, 6);

            assertThat(Problem1.validatePage(oddExceptionData)).isEqualTo(false);
        }

        @Test
        void validateEvenPageExceptionTest() {
            List<Integer> evenExceptionData = Arrays.asList(5, 7);

            assertThat(Problem1.validatePage(evenExceptionData)).isEqualTo(false);
        }

        @Test
        void validatePageTest() {
            List<Integer> validationData = Arrays.asList(197, 198);

            assertThat(Problem1.validatePage(validationData)).isEqualTo(true);
        }

        @Test
        void validatePageSequenceExceptionTest() {
            List<Integer> sequenceExceptionData = Arrays.asList(5, 8);

            assertThat(Problem1.validatePage(sequenceExceptionData)).isEqualTo(false);
        }

        @Test
        void validatePageOddExceptionTest() {
            List<Integer> oddExceptionData = Arrays.asList(8, 9);

            assertThat(Problem1.validatePage(oddExceptionData)).isEqualTo(false);
        }

        @Test
        void validatePageEvenExceptionTest() {
            List<Integer> evenExceptionData = Arrays.asList(7, 9);

            assertThat(Problem1.validatePage(evenExceptionData)).isEqualTo(false);
        }

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
        void createCharactersSetSetTest() {
            String cryptogram = "zyelleyz";
            assertThat(Problem2.createCharactersSet(cryptogram).size()).isEqualTo(4);
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
        void numberToCharArrayTest() {
            assertThat(Problem3.numberToCharArray(100).length).isEqualTo(3);
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
        void solutionTest() {
            String word = "   ";
            String result = "   ";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void checkAlphaTest() {
            assertThat(Problem4.checkAlpha('a')).isEqualTo(true);
        }

        @Test
        void changeCharacter() {
            char data = 'b';
            assertThat(Problem4.changeCharacter(data)).isEqualTo(25 - data + 'a' * 2);
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
        void calculateMoneyNumTest() {
            assertThat(Problem5.calculateMoneyNum(5000, 19000)).isEqualTo(3);
        }

        @Test
        void calculateBalanceTest() {
            assertThat(Problem5.calculateBalance(5000, 19000)).isEqualTo(4000);
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
        void separateNicknameTest() {
            List<String> result = Problem6.separateNickname("제이엠가");
            List<String> answerList = List.of("제이", "이엠", "엠가", "제이엠", "이엠가", "제이엠가");
            assertThat(result).isEqualTo(answerList);
        }
        @Test
        void isDuplicateTest() {
            String nickname = "차영호입니다";
            List<String> strings = Problem6.separateNickname("영호일까");
            assertThat(Problem6.isDuplicate(nickname, strings)).isEqualTo(true);
        }

        @Test
        void isDuplicateFalseTest() {
            String nickname = "차영호입니다";
            List<String> strings = Problem6.separateNickname("영일호까");
            assertThat(Problem6.isDuplicate(nickname, strings)).isEqualTo(false);
        }

        @Test
        void inValidEmailTest() {
            List<List<String>> forms = List.of(
                    List.of("jmdsbfjdsfjdsfk@email.com", "제이엠"),
                    List.of("jm@email.com1", "제이엠"),
                    List.of("@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com",  "mj@email.com");
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
        void case1Test() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("youngho", "jun"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
            assertThat(Problem7.relationships.get("jun").size()).isEqualTo(3);
            assertThat(Problem7.relationships.get("jun")).isEqualTo(List.of("donut","youngho","shakevan"));
        }

    }
    @Nested
    class Problem7UnitTest{
        @BeforeEach
        void setUp() {
            Problem7.friendsList = new ArrayList<>();
            Problem7.recommendScore = new HashMap<>();
            Problem7.relationships = new HashMap<>();
        }
        @Test
        void initFriendsListTest() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("mrko", "shakevan")
            );

            for (List<String> friend : friends) {
                if (friend.contains(user)) {
                    Problem7.initFriendsList(friend, user);
                }
            }
            assertThat(Problem7.friendsList).isEqualTo(List.of("donut","shakevan"));
            assertThat(Problem7.friendsList.size()).isEqualTo(2);
        }

        @Test
        void initRelationshipsTest() {

            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("youngho", "donut"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("mrko", "shakevan")
            );

            for (List<String> friend : friends) {
                Problem7.initRelationships(friend, "mrko");
            }

            assertThat(Problem7.relationships.get("donut").size()).isEqualTo(3);
            assertThat(Problem7.relationships.get("donut")).isEqualTo(List.of("andole", "jun","youngho"));
        }

        @Test
        void addRecommendScoreTest() {
            Problem7.addRecommendScore("youngho", 10);
            Problem7.addRecommendScore("youngho", 1);
            Problem7.addRecommendScore("youngho", 1);
            Problem7.addRecommendScore("youngho", 10);

            Problem7.addRecommendScore("donut", 10);
            assertThat(Problem7.recommendScore.size()).isEqualTo(2);
            assertThat(Problem7.recommendScore.get("youngho")).isEqualTo(22);
        }
    }
}
