package onboarding;

import java.util.List;

class User1 {

  private static final int LIST_LENGTH = 2;
  private final List<Integer> UserPageList;

  public User1(List<Integer> user) {
    validateUser(user);
    this.UserPageList = user;
  }

  private void validateUser(List<Integer> user) {
    if (user.size() != LIST_LENGTH) {
      throw new IllegalArgumentException();
    }
  }

  private boolean validatePage() {
    Page1 pageClass = new Page1();
    return pageClass.validatePage(UserPageList.get(0), UserPageList.get(1));
  }

  public int calMax() {
    Calculate1 calClass = new Calculate1(UserPageList.get(0), UserPageList.get(1));
    if (validatePage()) {
      return -1;
    }
    return calClass.compareTwo();
  }
}

class Page1 {

  private static final int START_PAGE = 1;
  private static final int END_PAGE = 400;

  public boolean validatePage(int left, int right) {
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
}

class Calculate1 {

  private final int leftPageMax;
  private final int rightPageMax;

  public Calculate1(int left, int right) {
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
    User1 userPobi = new User1(pobi);
    User1 userCrong = new User1(crong);
    return winner(userPobi.calMax(), userCrong.calMax());
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