package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

  private static final int ERROR = -1;
  private static final int POBIWIN = 1;
  private static final int CRONGWIN = 2;
  private static final int DRAW = 0;
  private static final int MINPAGE = 1;
  private static final int MAXPAGE = 400;

  public static int solution(List<Integer> pobi, List<Integer> crong) {
    int answer = Integer.MAX_VALUE;
    if (pageException(pobi, crong) == ERROR) {
      return ERROR;
    }
    User Pobi = new User(pobi);
    User Crong = new User(crong);
    answer = numCompare(Pobi.maxVal, Crong.maxVal);
    return answer;
  }

  public static int pageException(List<Integer> usr1, List<Integer> usr2) {
    if (usr1.size() != 2 || usr2.size() != 2) {
      throw new IllegalArgumentException("length of pobi and crong is not 2");
    }
    if (pageInRange(usr1, usr2) == -1) {
      return ERROR;
    }
    if (evenOddCheck(usr1, usr2) == -1) {
      return ERROR;
    }
    if (pagesInPair(usr1, usr2) == -1) {
      return ERROR;
    }
    return DRAW;
  }

  public static int numCompare(int usr1Max, int usr2Max) {
    if (usr1Max == usr2Max) {
      return DRAW;
    }
    if (usr1Max > usr2Max) {
      return POBIWIN;
    } else {
      return CRONGWIN;
    }
  }

  public static int pageInRange(List<Integer> usr1, List<Integer> usr2) {

    for (int i = 0; i < 2; i++) {
      if (usr1.get(i) <= MINPAGE || usr1.get(i) >= MAXPAGE) {
        return ERROR;
      }
    }
    for (int i = 0; i < 2; i++) {
      if (usr2.get(i) <= MINPAGE || usr2.get(i) >= MAXPAGE) {
        return ERROR;
      }
    }
    return 1;
  }

  public static int evenOddCheck(List<Integer> usr1, List<Integer> usr2) {
    if (usr1.get(0) % 2 != 1 || usr1.get(1) % 2 != 0) {
      return ERROR;
    }
    if (usr2.get(0) % 2 != 1 || usr2.get(1) % 2 != 0) {
      return ERROR;
    }
    return 1;
  }

  public static int pagesInPair(List<Integer> usr1, List<Integer> usr2) {
    if (usr1.get(1) != usr1.get(0) + 1 || usr2.get(1) != usr2.get(0) + 1) {
      return ERROR;
    }
    return 1;
  }

}

class User {

  int lBookPage;
  int rBookPage;
  int maxVal;

  public User(List<Integer> user) {
    this.lBookPage = user.get(0);
    this.rBookPage = user.get(1);
    this.maxVal = getAnswer(lBookPage, rBookPage);
  }

  int getAnswer(int lPage, int rPage) {
    int answer = compare2(getMax(lPage), getMax(rPage));
    return answer;
  }

  int getSum(int page) {
    List<Integer> pageDigits = getDigit(page);
    int sum = 0;
    for (int i = 0; i < pageDigits.size(); i++) {
      sum += pageDigits.get(i);
    }
    return sum;
  }

  int getMulti(int page) {
    List<Integer> pageDigits = getDigit(page);
    int multi = 1;
    for (Integer pageDigit : pageDigits) {
      multi *= pageDigit;
    }
    return multi;
  }

  List<Integer> getDigit(int page) {
    List<Integer> digitList = new ArrayList<Integer>();
    while (page != 0) {
      digitList.add(page % 10);
      page /= 10;
    }
    return digitList;
  }

  int getMax(int bookPage) {
    return compare2(getSum(bookPage), getMulti(bookPage));
  }

  int compare2(int a, int b) {
    return Math.max(a, b);
  }
}