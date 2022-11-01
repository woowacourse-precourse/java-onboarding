package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import onboarding.problem4.WordConverter;
import onboarding.problem5.BillConverter;
import onboarding.problem5.UnitsOfBill;

class ApplicationTest {
    @Nested
    class Problem1Test {
        // 리스트 크기 != 2 테스트
        @Test
        void listIndexExceptionTest() {
            List<Integer> pobi = List.of(2, 4, 5);
            List<Integer> crong = List.of(13, 14);

            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
        }

        // (오른쪽 - 왼쪽) != 1 예외 테스트
        @Test
        void gapExceptionTest() {
            List<Integer> pobi = List.of(2, 4);
            List<Integer> crong = List.of(13, 14);

            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
        }

        // 왼쪽 페이지 짝수 예외 테스트
        @Test
        void oddEvenExceptionTest() {
            List<Integer> pobi = List.of(2, 3);
            List<Integer> crong = List.of(13, 14);

            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
        }

        // 페이지 번호 범위 미만, 초과 예외 테스트
        @Test
        void boundaryExceptionTest() {
            List<Integer> pobi1 = List.of(0, 98);
            List<Integer> crong1 = List.of(13, 401);

            List<Integer> pobi2 = List.of(401, 98);
            List<Integer> crong2 = List.of(13, 0);

            assertThat(Problem1.solution(pobi1, crong1)).isEqualTo(-1);
            assertThat(Problem1.solution(pobi2, crong2)).isEqualTo(-1);
        }

        // decideWinner() 테스트
        @Test
        void decideWinnerTest() {
            // pobi 승
            int pobiWinScore = 10;
            int crongLoseScore = 9;

            // crong 승
            int pobiLoseScore = 9;
            int crongWinScore = 10;

            // 무승부
            int pobiDrawScore = 10;
            int crongDrawScore = 10;

            Problem1 problem1 = new Problem1();
            assertThat(problem1.decideWinner(pobiWinScore, crongLoseScore)).isEqualTo(1);
            assertThat(problem1.decideWinner(pobiLoseScore, crongWinScore)).isEqualTo(2);
            assertThat(problem1.decideWinner(pobiDrawScore, crongDrawScore)).isEqualTo(0);
        }

        // calculateScore() 테스트
        @Test
        void calculateScoreTest() {
            // 3자리수, 2자리수, 1자리수에 대해 테스트 수행
            List<Integer> hundredsPageNumbers = new ArrayList<>();
            hundredsPageNumbers.add(197);
            hundredsPageNumbers.add(198);

            List<Integer> tensPageNumbers = new ArrayList<>();
            tensPageNumbers.add(55);
            tensPageNumbers.add(56);

            List<Integer> onesPageNumbers = new ArrayList<>();
            onesPageNumbers.add(7);
            onesPageNumbers.add(8);

            int resultOfHundreds = 72;
            int resultOfTens = 30;
            int resultOfOnes = 8;

            Problem1 problem1 = new Problem1();
            try {
                assertThat(problem1.calculateScore(hundredsPageNumbers)).isEqualTo(resultOfHundreds);
                assertThat(problem1.calculateScore(tensPageNumbers)).isEqualTo(resultOfTens);
                assertThat(problem1.calculateScore(onesPageNumbers)).isEqualTo(resultOfOnes);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // makePageMaxNumber(), splitNumbers() 테스트
        @Test
        void makePageMaxNumberTest(){
            // 3자리수, 2자리수, 1자리수에 대해 테스트 수행
            int hundredsPageNumber = 197;
            int tensPageNumber = 56;
            int onesPageNumber = 7;

            // 예상 결과
            int resultOfHundreds = 63;
            int resultOfTens = 30;
            int resultOfOnes = 7;

            Problem1 problem1 = new Problem1();
            try {
                assertThat(problem1.makePageMaxNumber(hundredsPageNumber)).isEqualTo(resultOfHundreds);
                assertThat(problem1.makePageMaxNumber(tensPageNumber)).isEqualTo(resultOfTens);
                assertThat(problem1.makePageMaxNumber(onesPageNumber)).isEqualTo(resultOfOnes);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

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
        // 예외처리 테스트
        @Test
        void exceptionTest() {
            String cryptogramOverThousand = "a".repeat(1001);
            String cryptogramUnderOne = "";
            String cryptogramWithUpperCase = "aaAa";

            String resultOfBoundaryException = "Cryptogram length out of bounds.";
            String resultOfUpperCaseException = "There is an UPPER CASE in cryptogram.";

            assertThat(Problem2.solution(cryptogramOverThousand)).isEqualTo(resultOfBoundaryException);
            assertThat(Problem2.solution(cryptogramUnderOne)).isEqualTo(resultOfBoundaryException);
            assertThat(Problem2.solution(cryptogramWithUpperCase)).isEqualTo(resultOfUpperCaseException);
        }

        // deleteRepeatedString 테스트
        @Test
        void deleteRepeatedStringTest() {
            // 문자열 중복 구간 존재 여부에 따른 결과 테스트
            String cryptogram1 = "browoanooommmmmnaon";
            String cryptogram2 = "brown";

            String result1 = "browoannaon";
            String result2 = "NOT MODIFIED";

            Problem2 problem2 = new Problem2();
            try {
                assertThat(problem2.deleteRepeatedString(cryptogram1)).isEqualTo(result1);
                assertThat(problem2.deleteRepeatedString(cryptogram2)).isEqualTo(result2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        // deleteRepeatedCharacter 테스트
        @Test
        void deleteRepeatedCharacterTest() {
            // 문자 중복 구간 시작 인덱스에 따른 결과 테스트
            String cryptogram = "browoanooommmmmnaon";
            int repeatStartIndex1 = 7;
            int repeatStartIndex2 = 10;

            String result1 = "browoanmmmmmnaon";
            String result2 = "browoanooonaon";

            Problem2 problem2 = new Problem2();
            assertThat(problem2.deleteRepeatedCharacter(cryptogram, repeatStartIndex1)).isEqualTo(result1);
            assertThat(problem2.deleteRepeatedCharacter(cryptogram, repeatStartIndex2)).isEqualTo(result2);
        }

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
        // 전체 과정 테스트
        @Test
        void countClapTest() {
            int number = 3293;

            int result = 3166;

            Problem3 problem3 = new Problem3();
            assertThat(problem3.countClap(number)).isEqualTo(result);
        }

        // 과정3 테스트
        @Test
        void thirdProcessTest() {
            int number = 3293;
            int numberOfThousands = 3;
            int numberOfHundreds = 2;
            int numberOfTens = 9;

            int result1 = 294;
            int result2 = 0;
            int result3 = 4;

            Problem3 problem3 = new Problem3();
            assertThat(problem3.thirdProcess(3, numberOfThousands, number)).isEqualTo(result1);
            assertThat(problem3.thirdProcess(2, numberOfHundreds, number)).isEqualTo(result2);
            assertThat(problem3.thirdProcess(1, numberOfTens, number)).isEqualTo(result3);
        }

        // 과정2 테스트
        @Test
        void secondProcessTest() {
            int numberOfThousands = 3;
            int numberOfHundreds = 2;
            int numberOfTens = 9;

            int result1 = 0;
            int result2 = 0;
            int result3 = 20;

            Problem3 problem3 = new Problem3();
            assertThat(problem3.secondProcess(3, numberOfThousands)).isEqualTo(result1);
            assertThat(problem3.secondProcess(2, numberOfHundreds)).isEqualTo(result2);
            assertThat(problem3.secondProcess(1, numberOfTens)).isEqualTo(result3);
        }

        // 과정1 테스트
        @Test
        void firstProcessTest() {
            int numberOfThousands = 3;
            int numberOfHundreds = 2;
            int numberOfTens = 9;

            int result1 = 2700;
            int result2 = 120;
            int result3 = 27;

            Problem3 problem3 = new Problem3();
            assertThat(problem3.firstProcess(3, numberOfThousands)).isEqualTo(result1);
            assertThat(problem3.firstProcess(2, numberOfHundreds)).isEqualTo(result2);
            assertThat(problem3.firstProcess(1, numberOfTens)).isEqualTo(result3);
        }

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
        // 예외 처리 테스트
        @Test
        void exceptionTest() {
            String wordOverThousand = "a".repeat(1001);
            String wordUnderOne = "";

            String result = "Word length is out of range.";

            assertThat(Problem4.solution(wordOverThousand)).isEqualTo(result);
            assertThat(Problem4.solution(wordUnderOne)).isEqualTo(result);
        }

        // 대문자 변환 기능 테스트
        @Test
        void convertUpperCharacterTest() {
            String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            for (int i = 0; i < word.length(); i++) {
                char result = word.charAt(word.length() - i - 1);
                assertThat(WordConverter.convertUpperCharacter(word.charAt(i))).isEqualTo(result);
            }
        }

        // 소문자 변환 기능 테스트
        @Test
        void convertLowerCharacterTest() {
            String word = "abcdefghijklmnopqrstuvwxyz";

            for (int i = 0; i < word.length(); i++) {
                char result = word.charAt(word.length() - i - 1);
                assertThat(WordConverter.convertLowerCharacter(word.charAt(i))).isEqualTo(result);
            }
        }

        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        // 화폐 개수 및 잔돈 출력 기능 테스트
        // private 메소드에 대한 테스트는 권장되지 않지만, 방법에 대해 경험해 보기 위해 구현
        @Test
        void calculateNumberOfBillsTest() {
            try {
                BillConverter billConverter = new BillConverter();

                // REFLECTION 활용
                // private 메소드 테스트를 위한 접근 가능 여부 수정
                // Method와 Field를 받아와 Accessible을 true로 설정하여 접근 가능하도록 한다.
                Method calculateNumberOfBillsMethod = billConverter.getClass()
                    .getDeclaredMethod("calculateNumberOfBills", UnitsOfBill.class, int.class);
                Field numberOfBillsField = billConverter.getClass().getDeclaredField("numberOfBills");
                calculateNumberOfBillsMethod.setAccessible(true);
                numberOfBillsField.setAccessible(true);

                int money = 32_345;

                List<Integer> resultNumberOfBills = new ArrayList<>(List.of(0, 3, 0, 0, 0, 0, 0, 0, 0));
                int resultChange = 2_345;

                Object change = calculateNumberOfBillsMethod.invoke(billConverter, UnitsOfBill.valueOf("TEN_THOUSAND"), money);
                Object numberOfBills = numberOfBillsField.get(billConverter);

                assertThat(change).isEqualTo(resultChange);
                assertThat(numberOfBills).isEqualTo(resultNumberOfBills);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
    }
}
