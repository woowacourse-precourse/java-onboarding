package onboarding;

//import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private static boolean validPageNum (List<Integer> Pages)
    {
      // 페이지 두개인지 확인
      //if (Pages.size()!= 2) return false;
      // 시작 페이지보다 작거나 같, 마지막 페이지보다 크거나 같은지 따짐.
        int leftPage = Pages.get(0);
        int rightPage = Pages.get(1);
      if (1>= leftPage || leftPage >=399)
          return false;
      if (2>= rightPage || rightPage >=400)
          return false;
      // 연속된 페이지 여야함.
      if (rightPage - leftPage != 1)
          return false;
      // 왼쪽 페이지 확인
      if (leftPage % 2 == 0)
          return false;
      // 오른쪽 페이지 확인
      if (rightPage % 2 == 1)
          return false;

      return true;
    }
    private static int getMaxNum (int Page)
    {
        int oneDigit = Page % 10;
        int tenDigit = Page % 100 /10;
        int hundDigit = Page / 100;
        int maxNum = tenDigit*hundDigit*oneDigit;
        // 십의 자리일 경우,
        if (hundDigit == 0)
        {
            maxNum= tenDigit * oneDigit;
            // 일의 자리일 경우,
            if (tenDigit ==0)
            {
                maxNum = oneDigit;
            }
        }
        return Math.max(maxNum , oneDigit+tenDigit+ hundDigit);
    }

    private static int getMaxPageNum(List<Integer> Pages)
    {
        if (validPageNum(Pages) ==true)
        {
            int leftMaxNum = getMaxNum(Pages.get(0));
            int rightMaxNum = getMaxNum(Pages.get(1));
            return Math.max(leftMaxNum, rightMaxNum);
        }
        return -1;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pobiMaxNum = getMaxPageNum(pobi);
        int cronMaxNum = getMaxPageNum(crong);
        if (pobiMaxNum != -1 && cronMaxNum != -1 )
        {
            if (pobiMaxNum == cronMaxNum) answer = 0;
            if (pobiMaxNum > cronMaxNum) answer = 1;
            if (pobiMaxNum< cronMaxNum) answer = 2;
        }
        return answer;
    }

    /*public static void main(String[] arg)
    {
        List<Integer> pobi = new ArrayList<Integer>();
        List<Integer> crong = new ArrayList<Integer>();
        pobi.add(99);
        pobi.add(102);
        crong.add(211);
        crong.add(212);
        System.out.println(solution(pobi, crong));
    }*/
}