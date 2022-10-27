package onboarding;


import java.util.List;

class Problem1 {
    public static int compNum(int num) {
      int sum1 = 0, sum2 = 1;
      while(num > 0){
          sum1 += num % 10;
          sum2 *= num % 10;

          num = num / 10;
      }
      if(sum1 >= sum2){
          return sum1;
      } else {
          return sum2;
      }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        int pobiMax = 0, crongMax = 0;
        pobiMax = Math.max(compNum(pobi.get(0)), compNum(pobi.get(1)));
        crongMax = Math.max(compNum(crong.get(0)), compNum(crong.get(1)));
        if(pobi.get(0)+1 == pobi.get(1) && crong.get(0)+1 == crong.get(1)) {
            if (pobiMax > crongMax)
                answer = 1;
            else if (crongMax > pobiMax)
                answer = 2;
            else
                answer = 0;

        } else {
            answer = -1;
        }
        return answer;

    }
}