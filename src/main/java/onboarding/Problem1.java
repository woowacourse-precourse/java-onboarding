package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkException(pobi) || checkException(crong)){
            return Message.exception.message;
        }
        int pobiNum = getMax(pobi);
        int crongNum = getMax(crong);
        return getResult(pobiNum, crongNum);
    }

    static boolean checkException(List<Integer> list){
        if (list.get(0) + 1 != list.get(1) ||
                list.get(0) % 2 == 0 || list.get(1) % 2 == 1 ||
                list.get(0) == 1 || list.get(1) == 400) {

            return true;
        }
        return false;
    }

    static int getResult(int i, int j){
        if( i > j){
            return Message.pobiWin.message;
        }
        if (i < j){
            return Message.crongWin.message;
        }
        return Message.draw.message;
    }

    static int getMax(List<Integer> list){
        int page1 = list.get(0);
        int page2 = list.get(1);

        return Math.max(chooseMultiSum(page1), chooseMultiSum(page2));
    }



    static int chooseMultiSum(int page){
        int len = String.valueOf(page).length();
        int sum = 0;
        int multi = 1;

        int tmp = page;
        for (int i = 0; i < len; i++) {
            sum += tmp % 10;
            tmp /= 10;
        }

        tmp = page;
        for (int i = 0; i < len; i++) {
            multi *= tmp % 10;
            tmp /= 10;
        }
        return Math.max(sum, multi);
    }
}

enum Message {
    pobiWin(1), crongWin(2), draw(0), exception(-1);

    int message;

    Message(int message) {
        this.message = message;
    }
}