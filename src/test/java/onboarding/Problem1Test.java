package onboarding;

import onboarding.problem1.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Problem1Test {

    @Nested
    class Problem1UnitTest{

        public static final int ILLEGAL_ARG = -1;
        public static final int TIE = 0;
        public static final int POBI_WIN = 1;
        public static final int CRONG_WIN = 2;

        @Test
        public void solutionTieTest(){
            //given
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            //when
            //result=0 무승부를 의미한다.
            int result = TIE;
            //then
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        public void solutionPobiWinTest(){
            //given
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            //when
            //result=1 포비의 승리를 의미한다.
            int result = POBI_WIN;
            //then
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        public void solutionCrongWinTest(){
            //given
            List<Integer> pobi = List.of(211, 212);
            List<Integer> crong = List.of(131, 132);
            //when
            //result=2 크롱의 승리를 의미한다.
            int result = CRONG_WIN;
            //then
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        public void solutionErrorTestCase1(){
            //given
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(211, 212);
            //when
            //result=-1 에러를 의미한다.
            int result = ILLEGAL_ARG;
            //then
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        public void solutionErrorTestCase2(){
            //given
            List<Integer> pobi = List.of(399, 400);
            List<Integer> crong = List.of(211, 212);
            //when
            //result=-1 에러를 의미한다.
            int result = ILLEGAL_ARG;
            //then
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        public void solutionErrorTestCase3(){
            //given
            List<Integer> pobi = List.of(397, 399);
            List<Integer> crong = List.of(211, 212);
            //when
            //result=-1 에러를 의미한다.
            int result = ILLEGAL_ARG;
            //then
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        public void whoIsWinTieTest(){
            //given
            Book pobiBook = new Book(new Page(97,98));
            Book crongBook = new Book(new Page(197,198));
            //when
            int result=0;
            //then
            assertThat(Problem1.whoIsWin(pobiBook, crongBook)).isEqualTo(result);
        }

        @Test
        public void whoIsWinPobiWinTest(){
            //given
            Book pobiBook = new Book(new Page(131,132));
            Book crongBook = new Book(new Page(211,212));
            //when
            int result=1;
            //then
            assertThat(Problem1.whoIsWin(pobiBook, crongBook)).isEqualTo(result);
        }

        @Test
        public void whoIsWinCrongWinTest(){
            //given
            Book pobiBook = new Book(new Page(211,212));
            Book crongBook = new Book(new Page(131,132));
            //when
            int result= CRONG_WIN;
            //then
            assertThat(Problem1.whoIsWin(pobiBook, crongBook)).isEqualTo(result);
        }

        @Test
        public void whoIsWinFailTestCase1(){
            //given
            Book pobiBook = new Book(new Page(1,2));
            Book crongBook = new Book(new Page(197,198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }

        @Test
        public void whoIsWinFailTestCase2(){
            //given
            Book pobiBook = new Book(new Page(399,400));
            Book crongBook = new Book(new Page(197,198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }

        @Test
        public void whoIsWinFailTestCase3(){
            //given
            Book pobiBook = new Book(new Page(397,399));
            Book crongBook = new Book(new Page(197,198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }

        @Test
        public void whoIsWinFailTestCase4(){
            //given
            Book pobiBook = new Book(new Page(399,399));
            Book crongBook = new Book(new Page(197,198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }

        @Test
        public void whoIsWinFailTestCase5(){
            //given
            Book pobiBook = new Book(new Page(398,399));
            Book crongBook = new Book(new Page(197,198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }
    }

    @Nested
    class BookTest {

        @Test
        void getIsNotLeftPageOddTest(){
            //given
            Book book = new Book(new Page(2,3));
            //when
            boolean result=true;
            //then
            assertThat(book.isNotLeftPageOdd()).isEqualTo(result);
        }

        @Test
        void getIsNotRightPageEvenTest(){
            //given
            Book book = new Book(new Page(2,3));
            //when
            boolean result=true;
            //then
            assertThat(book.isNotLeftPageOdd()).isEqualTo(result);
        }

        @Test
        void getIsNotLeftPageOddFailTest(){
            //given
            Book book = new Book(new Page(1,2));
            //when
            boolean result=false;
            //then
            assertThat(book.isNotLeftPageOdd()).isEqualTo(result);
        }

        @Test
        void getIsNotRightPageEvenFailTest(){
            //given
            Book book = new Book(new Page(1,2));
            //when
            boolean result=false;
            //then
            assertThat(book.isNotLeftPageOdd()).isEqualTo(result);
        }

        @Test
        void hasFirstPageOrLessTest() {
            //given
            Book book = new Book(new Page(1,2));
            //when
            boolean result=true;
            //then
            assertThat(book.hasFirstPageOrLess()).isEqualTo(result);
        }

        @Test
        void hasLastPageOrMoreTest() {
            //given
            Book book = new Book(new Page(399,400));
            //when
            boolean result=true;
            //then
            assertThat(book.hasLastPageOrMore()).isEqualTo(result);
        }

        @Test
        void hasFirstPageOrLessFailTest() {
            //given
            Book book = new Book(new Page(2,3));
            //when
            boolean result=false;
            //then
            assertThat(book.hasFirstPageOrLess()).isEqualTo(result);
        }

        @Test
        void hasLastPageOrMoreFailTest() {
            //given
            Book book = new Book(new Page(398,399));
            //when
            boolean result=false;
            //then
            assertThat(book.hasLastPageOrMore()).isEqualTo(result);
        }

        @Test
        void getDifferenceTest() {
            //given
            Book book = new Book(new Page(2,3));
            //when
            int result=1;
            //then
            assertThat(book.pageDifference()).isEqualTo(result);
        }

        @Test
        void leftPageCalcForSumTest() {
            //given
            Book book = new Book(new Page(333,334));
            PageCalculator pageCalculator = new SumPageCalculator();
            //when
            int result=9;
            //then
            assertThat(book.leftPageCalc(pageCalculator)).isEqualTo(result);
        }

        @Test
        void leftPageCalcForMulTest() {
            //given
            Book book = new Book(new Page(333,334));
            PageCalculator pageCalculator = new MulPageCalculator();
            //when
            int result=27;
            //then
            assertThat(book.leftPageCalc(pageCalculator)).isEqualTo(result);
        }

        @Test
        void rightPageCalcForSumTest() {
            //given
            Book book = new Book(new Page(333,334));
            PageCalculator pageCalculator = new SumPageCalculator();
            //when
            int result=10;
            //then
            assertThat(book.rightPageCalc(pageCalculator)).isEqualTo(result);
        }

        @Test
        void rightPageCalcForMulTest() {
            //given
            Book book = new Book(new Page(333,334));
            PageCalculator pageCalculator = new MulPageCalculator();
            //when
            int result=36;
            //then
            assertThat(book.rightPageCalc(pageCalculator)).isEqualTo(result);
        }
    }
}
