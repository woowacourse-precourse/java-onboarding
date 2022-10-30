package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer;
    int pobiValue = memberHighestValue(pobi);
    int crongValue = memberHighestValue(crong);

    answer = winMember(pobiValue, crongValue);
    
    return answer;
  }

  public static int winMember(int pobi, int crong) {
    if (pobi > crong)
      return 1;
    else if (pobi == crong)
      return 0;
    else
      return 2;
  }

  public static int memberHighestValue(List<Integer> member) {
    List<Integer> ints = new ArrayList<>();
    for (Integer num : member) {
      ints.add(pageHighestValue(num));
    }
    return Collections.max(ints);
  }

  public static int pageHighestValue(Integer num) {
    int i = num.intValue();
    int sum = 0;
    int multiply = 1;
    while (i != 0) {
      sum += i % 10;
      multiply *= i % 10;

      i /= 10;
    }
    return sum > multiply ? sum : multiply;
  }
}