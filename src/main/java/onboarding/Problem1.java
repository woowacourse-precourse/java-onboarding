package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = 0, crongMax = 0, max = 0;
        int tmp;
       // System.out.println("pobi's page : ");
        for (int i = 0; i < pobi.size(); i++) {
            int sum = 0;
            int mul = 1;
            tmp = pobi.get(i);
            while (true) {
                if (tmp == 0)
                    break;
                sum += tmp % 10;
                if (tmp % 10 != 0)
                    mul *= tmp % 10;
                tmp /= 10;
                //   System.out.println("sum = "+sum+ " mul = "+ mul +" tmp = "+tmp);
            }
            if (max < mul)
                max = mul;
            else
                max = sum;

            if (pobiMax < max)
                pobiMax = max;
        }
            //System.out.println("crong's page : ");

            for (int i = 0; i < crong.size(); i++) {
                int sum = 0;
                int mul = 1;
                tmp = crong.get(i);
                while (true) {
                    if (tmp == 0)
                        break;
                    sum += tmp % 10;
                    if (tmp % 10 != 0)
                        mul *= tmp % 10;
                    tmp /= 10;
                    // System.out.println("sum = " + sum + " mul = " + mul + " tmp = " + tmp);
                }
                if (max < mul)
                    max = mul;
                else
                    max = sum;

                if (crongMax < max)
                    crongMax = max;
                // System.out.println(crongMax);
            }

            if (pobi.get(0) + 1 != pobi.get(1))
                return answer=-1;
            if (crong.get(0) + 1 != crong.get(1))
                return answer=-1;

            if (pobiMax > crongMax)
                return answer=1;
            else if (pobiMax < crongMax)
                return answer=2;
            else
                return answer=0;
        }
    }
