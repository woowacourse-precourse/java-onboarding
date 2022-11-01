package onboarding;


import java.util.Arrays;
import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Problem1 solve = new Problem1();
        if(solve.hasException(pobi, crong))
            return -1;
        int pobiMaxNum = solve.getMaxNum(solve.getNumByPage(pobi, "left"), solve.getNumByPage(pobi, "right"));
        int crongMaxNum = solve.getMaxNum(solve.getNumByPage(crong, "left"), solve.getNumByPage(crong, "right"));
        return solve.getWinner(pobiMaxNum, crongMaxNum);
    }



    private int getNumByPage(List<Integer> user, String page) {
        int index = (page=="left")?0:1;
        int resultAdd = Arrays.stream(user.get(index).toString().split(""))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        int resultMul = Arrays.stream(user.get(index).toString().split(""))
                .map(Integer::parseInt)
                .reduce(1, (a,b) -> a*b);
        return (resultAdd>resultMul)?resultAdd:resultMul;
    }

    private int getWinner(int pobiMaxNum, int crongMaxNum) {
        if (pobiMaxNum > crongMaxNum)
            return 1;
        else if (pobiMaxNum < crongMaxNum)
            return 2;
        return 0;
    }

    private int getMaxNum(int leftMaxNum, int rightMaxNum) {
        return (leftMaxNum >= rightMaxNum) ? leftMaxNum : rightMaxNum;
    }


    private boolean hasException(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2)
            return true;
        else if (pobi.get(0) % 2 != 1 || (pobi.get(0) + 1) != pobi.get(1))
            return true;
        else if (crong.get(0) % 2 != 1 || (crong.get(0) + 1) != crong.get(1))
            return true;
        return false;
    }

}