package onboarding;

import java.util.List;

class UserForProblem1 {

  private static final int LIST_LENGTH = 2;
  private final int max;

  public UserForProblem1(List<Integer> user) {
    int result = -1;
    if (!validateUser(user)) {
      PageForPro1 maxPage = new PageForPro1(user.get(0), user.get(1));
      result = maxPage.getMax();
    }
    this.max = result;
  }

  private boolean validateUser(List<Integer> user) {
    return user.size() != LIST_LENGTH;
  }

  public int getMax() {
    return max;
  }
}

class PageForPro1 {

  private static final int START_PAGE = 1;
  private static final int END_PAGE = 400;

  private final int max;

  public PageForPro1(int left, int right) {
    int result = -1;
    if (!validatePage(left, right)) {
      CalculateForPro1 calClass = new CalculateForPro1(left, right);
      result = calClass.compareTwo();
    }
    this.max = result;
  }

  private boolean validatePage(int left, int right) {
    return validatePage1r400(left) || validatePage1r400(right) || validateTwoPages(left, right);
  }

  private boolean validatePage1r400(int page) {
    return page <= START_PAGE || page >= END_PAGE;
  }

  private boolean validateTwoPages(int left, int right) {
    return inSerialNum(left, right) || evenOdd(left, right);
  }

  private boolean inSerialNum(int left, int right) {
    return left + 1 != right;
  }

  public boolean evenOdd(int left, int right) {
    return left % 2 == 0 || right % 2 == 1;
  }

  public int getMax() {
    return max;
  }
}

class CalculateForPro1 {

  private final int leftPageMax;
  private final int rightPageMax;

  public CalculateForPro1(int left, int right) {
    this.leftPageMax = compareTwo(addNum(left), mulNum(left));
    this.rightPageMax = compareTwo(addNum(right), mulNum(right));
  }

  private int addNum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }

  private int mulNum(int num) {
    int mul = 1;
    while (num > 0) {
      mul *= num % 10;
      num /= 10;
    }
    return mul;
  }

  private int compareTwo(int a, int b) {
    return Math.max(a, b);
  }

  public int compareTwo() {
    return Math.max(leftPageMax, rightPageMax);
  }
}

class Problem1 {
  private static final int POBI_WIN = 1;
  private static final int CRONG_WIN = 2;
  private static final int DRAW = 0;
  private static final int EXCEPTION = -1;

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    UserForProblem1 userPobi = new UserForProblem1(pobi);
    UserForProblem1 userCrong = new UserForProblem1(crong);
    return winner(userPobi.getMax(), userCrong.getMax());
  }

  public static int winner(int a, int b) {
    if (a == -1 || b == -1) {
      return EXCEPTION;
    }
    if (a - b > 0) {
      return POBI_WIN;
    }
    if (a - b < 0) {
      return CRONG_WIN;
    }
    return DRAW;
  }
}