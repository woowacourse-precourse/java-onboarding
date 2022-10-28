package onboarding;

import org.junit.jupiter.api.Nested;

import java.util.List;

class Problem1 {

  public static boolean isValidatePage(List<Integer> reader) {
    int gap = reader.get(1) - reader.get(0);
    if (gap != 1 || reader.get(0) > 400 || reader.get(1) > 400) {
      return false;
    }
    return true;
  }

  public static int find_max(int page) {
    int max = 0;
    int sum = 0;
    int multi = 1;
    int tmp = page;
    while (tmp > 0) {
      sum += tmp % 10;
      tmp /= 10;
    }
    int tmp2 = page;
    while (tmp2 > 0) {
      multi *= tmp2 % 10;
      tmp2 /= 10;
    }
    if (sum > multi) {
      return sum;
    }
    return multi;
  }

  public static int makeScore(int page1, int page2) {
    int score;
    int num1 = find_max(page1);
    int num2 = find_max(page2);
    if (num1 > num2) {
      score = num1;
    }
    score = num2;
    return score;
  }

  public static int compareScore(int a, int b) {
    int answer = 0;
      if (a > b) {
          answer = 1;
      } else if (a < b) {
          answer = 2;
      }
    return answer;
  }

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
      if (!isValidatePage(pobi) || !isValidatePage(crong)) {
          return (-1);
      }
    int pobiScore = makeScore(pobi.get(0), pobi.get(1));
    int crongScore = makeScore(crong.get(0), crong.get(1));
    answer = compareScore(pobiScore, crongScore);
    return answer;
  }
}