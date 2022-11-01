package onboarding;

import java.util.ArrayList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
    void myCaseForPro1() {
      int result = -1;

      List<Integer> pobi1 = List.of(99, 103);
      List<Integer> crong1 = List.of(211, 213);

      List<Integer> pobi2 = List.of(92, 103);
      List<Integer> crong2 = List.of(212, 213);

      List<Integer> pobi3 = List.of(92, 102);
      List<Integer> crong3 = List.of(212, 212);

      List<Integer> pobi4 = List.of(1, 2);
      List<Integer> crong4 = List.of(399, 400);

      List<Integer> pobi5 = List.of(0, 1);
      List<Integer> crong5 = List.of(401, 402);

      List<Integer> pobi6 = List.of(-389, -390);
      List<Integer> crong6 = List.of(-389, -390);

      List<Integer> pobi7 = List.of(389);
      List<Integer> crong7 = List.of(399);

      List<Integer> pobi8 = List.of(99, 102, 10);
      List<Integer> crong8 = List.of(211, 212, 100);

      assertThat(Problem1.solution(pobi1, crong1)).isEqualTo(result);
      assertThat(Problem1.solution(pobi2, crong2)).isEqualTo(result);
      assertThat(Problem1.solution(pobi3, crong3)).isEqualTo(result);
      assertThat(Problem1.solution(pobi4, crong4)).isEqualTo(result);
      assertThat(Problem1.solution(pobi5, crong5)).isEqualTo(result);
      assertThat(Problem1.solution(pobi6, crong6)).isEqualTo(result);
      assertThatThrownBy(() -> {
        Problem1.solution(pobi7, crong7);
      }).isInstanceOf((IllegalArgumentException.class));
      assertThatThrownBy(() -> {
        Problem1.solution(pobi8, crong8);
      }).isInstanceOf((IllegalArgumentException.class));
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
      String cryptogram = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
      String result = "";
      assertThatThrownBy(() -> {
        Problem2.solution(cryptogram);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void myCaseForPro2Uppercase1() {
      String result = "";
      String cryptogram = "ZyelleyZ";
      assertThatThrownBy(() -> {
        Problem2.solution(cryptogram);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void myCaseForPro2Uppercase2() {
      String result = "";
      String cryptogram = "abccbaD";
      assertThatThrownBy(() -> {
        Problem2.solution(cryptogram);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void myCaseForPro2Space() {
      String result = "";
      String cryptogram = "";
      assertThatThrownBy(() -> {
        Problem2.solution(cryptogram);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void checkTmpError() {
      String result = "brnown";
      String cryptogram = "brooonown";
      assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void checkEmptyError() {
      String result = "rnown";
      String cryptogram = "bbrooonown";
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
      int number = -3;
      int result = 0;
      assertThatThrownBy(() -> {
        Problem3.solution(number);
      }).isInstanceOf((IllegalArgumentException.class));
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
    void over1000() {
      String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
      String result = "";
      assertThatThrownBy(() -> {
        Problem4.solution(word);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void case1000() {
      String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
      String result = "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
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
    void case3MaxMoney() {
      int money = 1000000;
      List<Integer> result = List.of(20, 0, 0, 0, 0, 0, 0, 0, 0);
      assertThat(Problem5.solution(money)).isEqualTo(result);
    }

    @Test
    void case4() {
      int money = 0;
      List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
      assertThatThrownBy(() -> {
        Problem5.solution(money);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void case5() {
      int money = 1000005;
      List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
      assertThatThrownBy(() -> {
        Problem5.solution(money);
      }).isInstanceOf((IllegalArgumentException.class));
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
    void caseStrangekorean() {
      List<List<String>> forms = List.of(
          List.of("jm@email.com", "제ㅇ엠"),
          List.of("jason@email.com", "제ㅇ슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제ㅇ"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
      assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    void noOneMatches() {
      List<List<String>> forms = List.of(
          List.of("jm@email.com", "일일"),
          List.of("jason@email.com", "일이"),
          List.of("woniee@email.com", "일삼"),
          List.of("mj@email.com", "일사"),
          List.of("nowm@email.com", "일오")
      );
      List<String> result = List.of();
      assertThat(Problem6.solution(forms)).isEqualTo(result);
    }

    @Test
    void noCrew() {
      List<List<String>> forms = List.of();
      List<String> result = List.of();
      assertThatThrownBy(() -> {
        Problem6.solution(forms);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void emailLength() {
      List<List<String>> forms = List.of(
          List.of("j123456789789789@email.com", "제이엠"),
          List.of("jason@email.com", "제이슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제이"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "j123456789789789@email.com",
          "mj@email.com");
      assertThatThrownBy(() -> {
        Problem6.solution(forms);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void emailForm() {
      List<List<String>> forms = List.of(
          List.of("@email.com", "제이엠"),
          List.of("jason@email.com", "제이슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제이"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "j@email.com", "mj@email.com");
      assertThatThrownBy(() -> {
        Problem6.solution(forms);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void emailForm2() {
      List<List<String>> forms = List.of(
          List.of("jm@naver.com", "제이엠"),
          List.of("jason@email.com", "제이슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제이"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "j@naver.com", "mj@email.com");
      assertThatThrownBy(() -> {
        Problem6.solution(forms);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void emailForm3() {
      List<List<String>> forms = List.of(
          List.of("@email.com@naver.com", "제이엠"),
          List.of("jason@email.com", "제이슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제이"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "@email.com@naver.com", "mj@email.com");
      assertThatThrownBy(() -> {
        Problem6.solution(forms);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void nicknameKorNum() {
      List<List<String>> forms = List.of(
          List.of("jm@email.com", "제2엠"),
          List.of("jason@email.com", "제2슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제2"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
      assertThatThrownBy(() -> {
        Problem6.solution(forms);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void nicknameKorEng() {
      List<List<String>> forms = List.of(
          List.of("jm@email.com", "제e엠"),
          List.of("jason@email.com", "제e슨"),
          List.of("woniee@email.com", "워니"),
          List.of("mj@email.com", "엠제e"),
          List.of("nowm@email.com", "이제엠")
      );
      List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
      assertThatThrownBy(() -> {
        Problem6.solution(forms);
      }).isInstanceOf((IllegalArgumentException.class));
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
    void userLengthOver30() {
      String user = "mrkoooooooooooooooooppppppppppp";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrkoooooooooooooooooppppppppppp"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrkoooooooooooooooooppppppppppp")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
      List<String> result = List.of("andole", "jun", "bedi");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void friendsLengthOver30() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("mrkoooooooooooooooooppppppppppp", "andole"),
          List.of("mrkoooooooooooooooooppppppppppp", "jun"),
          List.of("mrkoooooooooooooooooppppppppppp", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi",
          "mrkoooooooooooooooooppppppppppp");
      List<String> result = List.of("andole", "jun", "bedi");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void friendsListLengthOver2() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "andole", "bj"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
      List<String> result = List.of("andole", "jun", "bedi");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void idOnlyLowercase() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "Andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "Andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
      List<String> result = List.of("Andole", "jun", "bedi");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void idOnlyLowercase2() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andol2"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "andol2"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
      List<String> result = List.of("andol2", "jun", "bedi");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void idOnlyLowercase3() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andol이"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "andol이"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
      List<String> result = List.of("andol이", "jun", "bedi");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void everyonefriend4() {
      String user = "donut";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("andole", "jun"),
          List.of("jun", "donut")
      );
      List<String> visitors = List.of("andole", "jun");
      List<String> result = new ArrayList<>();
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void userNotFoundInList() {
      String user = "dayun";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = new ArrayList<>();
      List<String> result = new ArrayList<>();
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void OnlyinVisitor() {
      String user = "dayun";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("andole", "jun"),
          List.of("jun", "donut")
      );
      List<String> visitors = List.of("ejachoi", "bcho", "bcho", "ejachoi", "yback", "yback",
          "yback");
      List<String> result = List.of("yback", "bcho", "ejachoi");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void UserinVisitor() {
      String user = "dayun";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("andole", "jun"),
          List.of("jun", "donut")
      );
      List<String> visitors = List.of("bcho", "ejachoi", "bcho", "ejachoi", "yback", "yback",
          "dayun");
      List<String> result = List.of("bcho", "ejachoi", "yback");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }

    @Test
    void Morethan5People() {
      String user = "dayun";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("andole", "jun"),
          List.of("jun", "donut")
      );
      List<String> visitors = List.of("bcho", "ejachoi", "yback", "chanwjeo", "sungwoop", "abcdef");
      List<String> result = List.of("abcdef", "bcho", "chanwjeo", "ejachoi", "sungwoop");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void casebcho() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("donut", "mrko"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "abcd", "abcz");
      List<String> result = List.of("andole", "jun", "bedi", "abcd", "abcz");
      assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void findduplicate() {
      String user = "mrko";
      List<List<String>> friends = List.of(
          List.of("donut", "andole"),
          List.of("donut", "jun"),
          List.of("andole", "donut"),
          List.of("shakevan", "andole"),
          List.of("shakevan", "jun"),
          List.of("shakevan", "mrko")
      );
      List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "abcd", "abcz");
      List<String> result = List.of("andole", "jun", "bedi", "abcd", "abcz");
      assertThatThrownBy(() -> {
        Problem7.solution(user, friends, visitors);
      }).isInstanceOf((IllegalArgumentException.class));
    }


    @Test
    void case5() {
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
    void case7() {
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