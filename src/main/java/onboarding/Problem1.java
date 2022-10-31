package onboarding;

import java.util.List;

class Problem1 {

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = -1;
    try {
      checkPages(pobi);
      checkPages(crong);
      if (calcPoint(pobi) > calcPoint(crong)) {
        answer = 1;
      } else if (calcPoint(pobi) < calcPoint(crong)) {
        answer = 2;
      } else {
        answer = 0;
      }
    } catch (Exception e) {
      answer = -1;
    }
    return answer;
  }

  static void checkPages(List<Integer> pages) throws Exception {
    if (pages.size() != 2 || pages.get(1) - pages.get(0) != 1 || pages.get(0) < 2
        || pages.get(1) >= 400) {
      throw new Exception();
    }
  }

  static int calcPoint(List<Integer> pages) {
    int point = 0;
    for (int i = 0; i < pages.size(); i++) {
      point = Math.max(point, Math.max(addDigit(pages.get(i)), mulDigit(pages.get(i))));
    }
    return point;
  }

  static int addDigit(int page) {
    int sum = 0;
    while (page != 0) {
      sum += page % 10;
      page /= 10;
    }
    return sum;
  }

  static int mulDigit(int page) {
    int product = 1;
    while (page != 0) {
      product *= page % 10;
      page /= 10;
    }
    return product;
  }
}