package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Problem1Test {
    @Nested
    class Problem1UnitTest{
        @Test
        public void solutionTieTest(){
            //given
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            //when
            //result=0 무승부를 의미한다.
            int result = 0;
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
            int result = 1;
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
            int result = 2;
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
            int result = -1;
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
            int result = -1;
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
            int result = -1;
            //then
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        public void whoIsWinTieTest(){
            //given
            Book pobiBook = new Book(new Page(97), new Page(98));
            Book crongBook = new Book(new Page(197), new Page(198));
            //when
            int result=0;
            //then
            assertThat(Problem1.whoIsWin(pobiBook, crongBook)).isEqualTo(result);
        }

        @Test
        public void whoIsWinPobiWinTest(){
            //given
            Book pobiBook = new Book(new Page(131), new Page(132));
            Book crongBook = new Book(new Page(211), new Page(212));
            //when
            int result=1;
            //then
            assertThat(Problem1.whoIsWin(pobiBook, crongBook)).isEqualTo(result);
        }

        @Test
        public void whoIsWinCrongWinTest(){
            //given
            Book pobiBook = new Book(new Page(211), new Page(212));
            Book crongBook = new Book(new Page(131), new Page(132));
            //when
            int result=2;
            //then
            assertThat(Problem1.whoIsWin(pobiBook, crongBook)).isEqualTo(result);
        }

        @Test
        public void whoIsWinFailTestCase1(){
            //given
            Book pobiBook = new Book(new Page(1), new Page(2));
            Book crongBook = new Book(new Page(197), new Page(198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }

        @Test
        public void whoIsWinFailTestCase2(){
            //given
            Book pobiBook = new Book(new Page(399), new Page(400));
            Book crongBook = new Book(new Page(197), new Page(198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }

        @Test
        public void whoIsWinFailTestCase3(){
            //given
            Book pobiBook = new Book(new Page(397), new Page(399));
            Book crongBook = new Book(new Page(197), new Page(198));
            //when
            Class<IllegalArgumentException> e = IllegalArgumentException.class;
            //then
            assertThatThrownBy(()->Problem1.whoIsWin(pobiBook, crongBook)).isInstanceOf(e);
        }
    }

}
