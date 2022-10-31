package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
    void isAllowedPageTest() {
      //given
      int pageA = 401;
      int pageB = 0;
      int pageC = 100;

      //then
      assertThrows(IllegalStateException.class, () -> {
        Problem1.isAllowedPage(pageA);
      });

      assertThrows(IllegalStateException.class, () -> {
        Problem1.isAllowedPage(pageB);
      });

      assertThat(Problem1.isAllowedPage(pageC)).isEqualTo(true);
    }

    @Test
    void isAllowedPagesCountTest() {
      //given
      List<Integer> pobi = List.of(131, 132);
      List<Integer> crong = List.of(131, 132, 133);

      //then
      assertThrows(IllegalStateException.class, () -> {
        Problem1.isAllowedPagesCount(crong);
      });

      assertThat(Problem1.isAllowedPagesCount(pobi)).isEqualTo(true);

    }

    @Test
    void isContinuousPageTest() {
      //given
      List<Integer> pobi = List.of(131, 132);
      List<Integer> crong = List.of(131, 134);

      //then
      assertThrows(IllegalStateException.class, () -> {
        Problem1.isContinuousPage(crong);
      });

      assertThat(Problem1.isContinuousPage(pobi)).isEqualTo(true);

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
      String cryptogram = "abbbaceed";
      String result = "cd";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void isAllowedStringTest() {
      //given
      String cryptogram = "browoAnoommnaon";

      //then
      assertThrows(IllegalStateException.class, () -> {
        Problem2.isAllowedString(cryptogram);
      });
    }

    @Test
    void isAllowedStringLength() {
      //given
      int cryptogramSize = 4001;

      //then
      assertThrows(IllegalStateException.class, () -> {
        Problem2.isAllowedStringLength(cryptogramSize);
      });
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
    void isAllowedNumberTest() {
      //given
      int numberSize = 10001;

      //then
      assertThrows(IllegalStateException.class, () -> {
        Problem3.isAllowedNumber(numberSize);
      });
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
    void isAlphabetTest() {
      //given
      String c1 = "a";
      String c2 = "A";
      String c3 = "1";

      //when
      boolean b1 = Problem4.isAlphabet(c1);
      boolean b2 = Problem4.isAlphabet(c2);
      boolean b3 = Problem4.isAlphabet(c3);

      //then
      assertThat(b1).isEqualTo(true);
      assertThat(b2).isEqualTo(true);
      assertThat(b3).isEqualTo(false);
    }

    @Test
    void isAllowedStringLengthTest() {
      //given
      int wordLength1 = 10;
      int wordLength2 = 1001;

      //then
      assertThat(Problem4.isAllowedStringLength(wordLength1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem4.isAllowedStringLength(wordLength2);
      });
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
    void isAllowedMoneyTest() {
      //given
      int money1 = 10_237;
      int money2 = 1_000_021;

      //then
      assertThat(Problem5.isAllowedMoney(money1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem5.isAllowedMoney(money2);
      });
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
    void isAllowedCrewSizeTest() {
      //given
      int crewSize1 = 2234;
      int crewSize2 = 10010;

      //then
      assertThat(Problem6.isAllowedCrewSize(crewSize1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem6.isAllowedCrewSize(crewSize2);
      });
    }

    @Test
    void isAllowedEmailTest() {
      //given
      String email1 = "abcd@email.com";
      String email2 = "@email.com";
      String email3 = "abcd@gmail.com";
      String email4 = "abcdgmail.com";

      //then
      assertThat(Problem6.isAllowedEmail(email1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem6.isAllowedEmail(email2);
      });
      assertThrows(IllegalStateException.class, () -> {
        Problem6.isAllowedEmail(email3);
      });
      assertThrows(IllegalStateException.class, () -> {
        Problem6.isAllowedEmail(email4);
      });
    }

    @Test
    void isAllowedNickNameTest() {
      //given
      String nickName1 = "박수환";
      String nickName2 = "5uhwann";
      String nickName3 = "aspodickalsefnaskldfmn2";

      //then
      assertThat(Problem6.isAllowedNickName(nickName1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem6.isAllowedNickName(nickName2);
      });
      assertThrows(IllegalStateException.class, () -> {
        Problem6.isAllowedNickName(nickName3);
      });
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
    void isAllowedIdTest() {
      //given
      String id1 = "qwln";
      String id2 = "asnjvkamsdncvsdhaasndasdfasdfvwklradf";
      String id3 = "qASWWC";

      //then
      assertThat(Problem7.isAllowedId(id1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem7.isAllowedId(id2);
      });
      assertThrows(IllegalStateException.class, () -> {
        Problem7.isAllowedId(id3);
      });
    }

    @Test
    void isAllowedFriendsInfoSizeTest() {
      //given
      int friendsLength1 = 1001;
      int friendsLength2 = 1000001;

      //then
      assertThat(Problem7.isAllowedFriendsInfoSize(friendsLength1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem7.isAllowedFriendsInfoSize(friendsLength2);
      });
    }

    @Test
    void isAllowedVisitorsSizeTest() {
      //given
      int visitorsSize1 = 1001;
      int visitorsSize2 = 1000001;

      //then
      assertThat(Problem7.isAllowedVisitorsSize(visitorsSize1)).isEqualTo(true);
      assertThrows(IllegalStateException.class, () -> {
        Problem7.isAllowedVisitorsSize(visitorsSize2);
      });

    }
  }
}
