package onboarding;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("잘못된 페이지가 들어올 경우 - 연속된 페이지여야 한다")
    void case3() {
      List<Integer> pobi = List.of(99, 102);
      List<Integer> crong = List.of(211, 212);
      int result = -1;
      assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("잘못된 페이지가 들어올 경우 - 1 ~ 400 페이지여야 한다(pobi)")
    void case4() {
      List<Integer> pobi = List.of(401, 402);
      List<Integer> crong = List.of(211, 212);
      int result = -1;
      assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("잘못된 페이지가 들어올 경우 - 1 ~ 400 페이지여야 한다(crong)")
    void case5() {
      List<Integer> pobi = List.of(99, 102);
      List<Integer> crong = List.of(401, 402);
      int result = -1;
      assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("잘못된 페이지가 들어올 경우 - 1 ~ 400 페이지여야 한다(crong, pobi)")
    void case6() {
      List<Integer> pobi = List.of(401, 402);
      List<Integer> crong = List.of(-1, 0);
      int result = -1;
      assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("잘못된 페이지가 들어올 경우 - 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 한다")
    void case7() {
      List<Integer> pobi = List.of(99, 100);
      List<Integer> crong = List.of(100, 101);
      int result = -1;
      assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

    @Test
    @DisplayName("잘못된 페이지가 들어올 경우 - 왼쪽 페이지가 오른쪽 페이지보다 커야 한다.")
    void case8() {
      List<Integer> pobi = List.of(99, 100);
      List<Integer> crong = List.of(100, 101);
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
    void case3() {
      String cryptogram = "braaaaaaaboo";
      String result = "brb";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case4() {
      String cryptogram = "braaaaaaaboo";
      String result = "brb";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case5() {
      String cryptogram = "a";
      String result = "a";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case6() {
      String cryptogram = "a".repeat(1000);
      String result = "";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case7() {
      String cryptogram = "brbrbbrbrbbb";
      String result = "";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case8() {
      String cryptogram = "abcdefghijklmnopqrstuvwxyz".repeat(30);
      String result = "abcdefghijklmnopqrstuvwxyz".repeat(30);
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

    @Test
    void case4() {
      int number = 10000;
      int result = 12000;
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
      String word = "IllIlIlllIl";
      String result = "RooRoRoooRo";
      assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    @DisplayName("한글일때 변환 하지 않는다")
    void case3() {
      String word = "I love you 아들아";
      String result = "R olev blf 아들아";
      assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    void case4() {
      String word = "abcdefghijklmnopqrstuvwxyz".repeat(30);
      String result = "zyxwvutsrqponmlkjihgfedcba".repeat(30);
      assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    void case5() {
      String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".repeat(30);
      String result = "ZYXWVUTSRQPONMLKJIHGFEDCBA".repeat(30);
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
      int money = 66666;
      List<Integer> result = List.of(1, 1, 1, 1, 1, 1, 1, 1, 6);
      assertThat(Problem5.solution(money)).isEqualTo(result);
    }

    @Test
    void case4() {
      int money = 999_999;
      List<Integer> result = List.of(19, 4, 1, 4, 1, 4, 1, 4, 9);
      assertThat(Problem5.solution(money)).isEqualTo(result);
    }

    @Test
    void case5() {
      int money = 1_000_000;
      List<Integer> result = List.of(20, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(Problem5.solution(money)).isEqualTo(result);
    }

    @Test
    void case6() {
      int money = 589_548;
      List<Integer> result = List.of(11, 3, 1, 4, 1, 0, 0, 4, 8);
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
          List.of("jm@email.com", "제이제이"),
          List.of("jason@email.com", "제이슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제이"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com",
          "nowm@email.com");
      assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    void case3() {
      List<List<String>> forms = List.of(
          List.of("jm@email.com", "모모모모모모모모모모모모모모")
      );
      List<String> result = List.of();
      assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    @DisplayName("효율성 테스트 - 정확성 검사는 하지 않습니다!")
    void case4() {
      for (int i = 0; i < 100; i++) {
        List<List<String>> forms = new ArrayList<>();
        for (int j = 0; j < 10_000; j++) {
          generateCrew(forms);
        }
        long start = System.currentTimeMillis();
        Problem6.solution(forms);
        long end = System.currentTimeMillis();
        long timeLimit = 1_000; // 1초
        assertThat(end - start).isLessThan(timeLimit);
      }
      // 로컬 PC에서 돌렸을 때 end - start 결과
      // 83, 47, 59, 50, 48, 49, 39, 56, 42, 63,
      // 39, 73, 34, 35, 85, 50, 52, 93, 42, 35,
      // 35, 111, 60, 50, 44, 44, 44, 55, 41, 40,
      // 44, 51, 45, 104, 37, 35, 33, 34, 132, 50,
      // 55, 52, 46, 52, 51, 168, 55, 59, 34, 33,
      // 34, 92, 46, 33, 33, 34, 33, 32, 33, 35,
      // 119, 40, 36, 39, 38, 108, 51, 33, 33, 32,
      // 81, 44, 34, 33, 33, 33, 34, 32, 97, 53,
      // 44, 38, 34, 89, 38, 37, 38, 41, 43, 43,
      // 119, 36, 34, 34, 32, 33, 103, 62, 42, 41
    }

    private void generateCrew(List<List<String>> forms) {
      List<String> crew = new ArrayList<>();
      StringBuilder nickName = new StringBuilder(20);
      for (int j = 0; j < 20; j++) {
        nickName.append((char) ((Math.random() * 11172) + 0xAC00));
      }
      StringBuilder email = new StringBuilder(20);
      for (int j = 0; j < 20 - "@email.com".length(); j++) {
        email.append((char) ((Math.random() * 11172) + 0xAC00));
      }
      crew.add(email.toString());
      crew.add(nickName.toString());
      forms.add(crew);
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
    @DisplayName("mrko 친구 없음")
    void case2() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "hyeonmo"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "hyeonmo")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "woowa",
          "woowa");
      List<String> result = List.of("bedi", "woowa", "donut", "shakevan");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case3() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "mrko"),
          List.of("shakevan", "mrko"),
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "donut")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "jun");
      List<String> result = List.of("jun", "andole", "bedi");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case4() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "hyeonmo"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
      List<String> result = List.of("andole", "jun", "hyeonmo", "bedi");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    @DisplayName("추천할 사람이 5명을 초과하는 경우")
    void case5() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "hyeonmo"),
          List.of("shakevan", "mrko"),
          List.of("alex", "andole"),
          List.of("alex", "jun"),
          List.of("alex", "hyeonmo"),
          List.of("alex", "mrko"),
          List.of("babo", "wc"),
          List.of("babo", "jh"),
          List.of("babo", "hw"),
          List.of("babo", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
      List<String> result = List.of("andole", "jun", "hyeonmo", "hw", "jh");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    @DisplayName("효율성 테스트 - 정확성 검사는 하지 않습니다!")
    void case6() {
      for (int i = 0; i < 100; i++) {
        String user = "mrko";
        List<List<String>> friends = generateFriends();
        List<String> visitors = generateVisitors();
        long start = System.currentTimeMillis();
        Problem7.solution(user, friends, visitors);
        long end = System.currentTimeMillis();
        long timeLimit = 1_000; // 1초
        assertThat(end - start).isLessThan(timeLimit);
      }
    }

    @NotNull
    private List<String> generateVisitors() {
      List<String> visitors = new ArrayList<>(10_000);
      for (int i = 20_000; i < 30_000; i++) {
        visitors.add(generateFriend(i));
      }
      return visitors;
    }

    @NotNull
    private List<List<String>> generateFriends() {
      List<List<String>> friends = new ArrayList<>();
      for (int i = 0; i < 10_000; i++) {
        friends.add(generateFriendShip(i));
      }
      return friends;
    }

    private List<String> generateFriendShip(Integer seed) {
      String friend1 = generateFriend(seed);
      String friend2 = generateFriend(10000 + seed);
      String dummy = "abcdefghij".repeat(2);
      return List.of(dummy + friend1, dummy + friend2);
    }

    private String generateFriend(Integer seed) {
      StringBuilder sb = new StringBuilder().append(seed);
      for (int i = 0; i < sb.length(); i++) {
        sb.setCharAt(i, (char) (sb.charAt(i) - '0' + 'a'));
      }
      return sb.toString();
    }
  }
}
