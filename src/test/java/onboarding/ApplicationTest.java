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

    @Test
    void case4() {
      assertThat(Problem1.solution(List.of(131, 132), List.of(211, 212))).isEqualTo(1);
      assertThat(Problem1.solution(List.of(211, 212), List.of(131, 132))).isEqualTo(2);
      assertThat(Problem1.solution(List.of(99, 102), List.of(211, 212))).isEqualTo(-1);
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
      String cryptogram = "";
      String result = "";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case4() {
      String cryptogram = "baaaaaaab";
      String result = "";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case5() {
      String cryptogram = "zyellleyz";
      String result = "";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case6() {
      String cryptogram = "zyelileyz";
      String result = "zyelileyz";
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
    void case3() {
      int money = 1;
      List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 1);
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
              List.of("jm@email.com", "제이엠"),
              List.of("jason@email.com", "제이슨"),
              List.of("woniee@email.com", "워니"),
              List.of("mj@email.com", "엠이엠"),
              List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
      assertThat(Problem6.solution(forms)).isEqualTo(result);
    }
    @Test
    void case3() {
      List<List<String>> forms = List.of(
              List.of("jm@email.com", "가나다"),
              List.of("jason@email.com", "라마바"),
              List.of("woniee@email.com", "사차카"),
              List.of("mj@email.com", "에이요"),
              List.of("nowm@email.com", "메미무")
      );
      List<String> result = List.of();
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
      String user = "Walter";
      List<List<String>> friends = List.of(
              List.of("Christa", "Alyce"),
              List.of("Hobart", "Retha"),
              List.of("Elijah", "Josh"),
              List.of("Cecil", "Lamont"),
              List.of("Eliza", "Lamont"),
              List.of("Austyn", "Retha"),
              List.of("Retha", "Mara"),
              List.of("Walter", "Lamont"),
              List.of("Retha", "Walter"),
              List.of("Urban", "Walter")
      );
      List<String> visitors = List.of("Cecil", "Eliza", "Adonis", "Mara");
      List<String> result = List.of("Cecil", "Eliza", "Mara", "Austyn", "Hobart");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case3() {
      String user = "Eliza";
      List<List<String>> friends = List.of(
              List.of("Cecil", "Hobart"),
              List.of("Austyn", "Mara"),
              List.of("Adonis", "Eliza"),
              List.of("Lamont", "Retha"),
              List.of("Jan", "Christa"),
              List.of("Milton", "Retha"),
              List.of("Josh", "Eliza"),
              List.of("Eliza", "Jesus"),
              List.of("Retha", "Eliza")
      );
      List<String> visitors = List.of("Retha", "Rosalia", "Hobart", "Jayne");
      List<String> result = List.of("Lamont", "Milton", "Hobart", "Jayne", "Rosalia");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case4() {
      String user = "Adonis";
      List<List<String>> friends = List.of(List.of("Kali", "Kali"),
              List.of("Walter", "Urban"),
              List.of("Adonis", "Mara"),
              List.of("Eliza", "Lamont"),
              List.of("Josh", "Milton"),
              List.of("Jayne", "Elijah"),
              List.of("Jan", "Urban"),
              List.of("Urban", "Adonis"),
              List.of("Adonis", "Christa"),
              List.of("Retha", "Adonis")
      );
      List<String> visitors = List.of("Rosalia", "Elijah", "Lamont", "Cecil");
      List<String> result = List.of("Jan", "Walter", "Cecil", "Elijah", "Lamont");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case5() {
      String user = "Adonis";
      List<List<String>> friends = List.of(List.of("Kali", "Kali"),
              List.of("Walter", "Urban"),
              List.of("Eliza", "Lamont"),
              List.of("Josh", "Milton"),
              List.of("Jayne", "Elijah"),
              List.of("Jan", "Urban")
      );
      List<String> visitors = List.of("aosalia", "blijah", "camont", "decil");
      List<String> result = List.of("aosalia", "blijah", "camont", "decil");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case6() {
      String user = "Adonis";
      List<List<String>> friends = List.of(
              List.of("Kali", "Kali"),
              List.of("Mara", "Urban"),
              List.of("Adonis", "Mara")
      );
      List<String> visitors = List.of();
      List<String> result = List.of("Urban");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }
    @Test
    void case7() {
      String user = "Adonis";
      List<List<String>> friends = List.of(List.of("Kali", "Kali"),
              List.of("Walter", "Urban"),
              List.of("Eliza", "Lamont"),
              List.of("Josh", "Milton"),
              List.of("Urban", "Elijah"),
              List.of("Jan", "Urban"),
              List.of("Jan", "Adonis")
      );
      List<String> visitors = List.of("aosalia","aosalia","aosalia","aosalia","aosalia","aosalia","aosalia","aosalia","aosalia","aosalia","aosalia","aosalia", "blijah", "camont", "decil");
      List<String> result = List.of("aosalia", "Urban", "blijah", "camont", "decil");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }
  }
}
