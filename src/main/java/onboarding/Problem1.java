package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1) ||
                pobi.get(0) < 3 || pobi.get(1) < 3 || crong.get(0) < 3 || crong.get(1) < 3 ||
                pobi.get(0) > 398 || pobi.get(1) > 398 || crong.get(0) > 398 || crong.get(1) > 398) answer = -1;
        else {
            int pobiMax = getMax(pobi);
            int crongMax = getMax(crong);
            if(pobiMax > crongMax) answer = 1;
            else if (crongMax > pobiMax) answer = 2;
            else answer = 0;
        }
        return answer;
    }

    public static int getMax(List<Integer> list) {
        int listMax = 0;
        for (Integer integer : list) {
            int tmpMulti = 1;
            int tmpAdd = 0;
            int clone = integer;
            while (clone > 0) {
                tmpMulti *= clone % 10;
                clone /= 10;
            }
            clone = integer;
            while (clone > 0) {
                tmpAdd += clone % 10;
                clone /= 10;
            }
            if (tmpAdd >= tmpMulti && tmpAdd > listMax) listMax = tmpAdd;
            else if (tmpMulti > tmpAdd && tmpMulti > listMax) listMax = tmpMulti;
        }
        return listMax;
    }
}