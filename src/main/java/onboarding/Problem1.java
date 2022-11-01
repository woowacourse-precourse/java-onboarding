package onboarding;

import java.util.List;

class Problem1 {
    public static int calBigNum(int num) {
        if(num / 10 == 0) {
            // 한자리 일 때
            return num;
        }

        if(num / 100 == 0) {
            // 두자리 일 때
            int sumNumber = num % 10 + num / 10;
            int mulNumber = (num % 10) * (num / 10);
            return Math.max(sumNumber, mulNumber);
        }

        if(num / 1000 == 0) {
            // 세자리 일 때
            int sumNumber = num % 10 + (num % 100) / 10 + num / 100;
            int mulNumber = (num % 10) * ((num % 100) / 10) * (num / 100);
            return Math.max(sumNumber, mulNumber);
        }

        return 0;
    }

    public static boolean checkInput(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1)-pobi.get(0) != 1) return false;
        if(crong.get(1)-crong.get(0) != 1) return false;
        if(pobi.size() != 2) return false;
        if(crong.size() != 2) return false;

        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!checkInput(pobi,crong)) {
            return -1;
        }

        int pobiScore = Math.max(calBigNum(pobi.get(0)), calBigNum(pobi.get(1)));
        int crongScore = Math.max(calBigNum(crong.get(0)), calBigNum(crong.get(1)));

        if(pobiScore > crongScore) {
            // pobi 승
            return 1;
        }

        if(pobiScore < crongScore) {
            // crong 승
            return 2;
        }

        if(pobiScore == crongScore) {
            // 무승부
            return 0;
        }

        return -1;
    }
}