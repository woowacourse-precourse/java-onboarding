package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            if (pobi.get(0) < 0 || pobi.get(1) > 400
            || crong.get(0) < 0 || crong.get(1) > 400
            || pobi.size() > 2 || crong.size() > 2
            || crong.get(0) > crong.get(1) || pobi.get(0) > pobi.get(1)
            || (pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1))
                throw new Exception("예외가 발생 하였습니다");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

        int answer = Integer.MAX_VALUE;

        int pobiMax;
        int crongMax;

        pobiMax = (getPlus(pobi) > getMul(pobi)) ? getPlus(pobi) : getMul(pobi);
        crongMax = (getPlus(crong) > getMul(crong) ? getPlus(crong) : getMul(crong));

        answer = getMax(pobiMax, crongMax);

        return answer;
    }

    static int getPlus(List<Integer> list) {
        int listPlusLeft, listPlusRight;

        if (list.get(0)/10 == 0) {
            return list.get(1);
        } else if (list.get(0)/100 == 0) {
            listPlusLeft = (list.get(0) % 10) + (list.get(0) / 10);
            listPlusRight = (list.get(1) % 10) + (list.get(1) / 10);
        } else {
            listPlusLeft = (list.get(0) / 100) + ((list.get(0) % 100) / 10) + (list.get(0) % 10);
            listPlusRight = (list.get(1) / 100) + ((list.get(1) % 100) / 10) + (list.get(1) % 10);
        }

        return listPlusLeft > listPlusRight ? listPlusLeft : listPlusRight;
    }

    static int getMul(List<Integer> list) {
        int listMulLeft, listMulRight;

        if (list.get(0)/10 == 0) {
            return list.get(1);
        } else if (list.get(0)/100 == 0) {
            listMulLeft = (list.get(0) % 10) * (list.get(0) / 10);
            listMulRight = (list.get(1) % 10) * (list.get(1) / 10);
        } else {
            listMulLeft = (list.get(0) / 100) * ((list.get(0) % 100) / 10) * (list.get(0) % 10);
            listMulRight = (list.get(1) / 100) * ((list.get(1) % 100) / 10) * (list.get(1) % 10);
        }

        return listMulLeft > listMulRight ? listMulLeft : listMulRight;
    }

    static int getMax(int pobi, int crong) {
        return (pobi == crong) ? 0 : (pobi > crong) ? 1 : 2;
    }

}
    /**
     * 기능이 작동할 수 있도록 로직을 구현해 낸 이후 이 코드가 과연 좋은 것일까
     * 더 짧게, 더 가독성 높게 구현할 수 있지 않을까...
     * 이 부분에 대한 고민이 많아지는 시간이 있었던 순간이 많았던듯 합니다.
     * 이 때문에 해결 이후에도 한동안 계속해서 수정을 해보기도 하고 그랬습니다.
     * 결국 나온 코드는 위와 같은 코드인데 이보다 더 클린하게 만들 수 있지 않을까 싶으며
     * 모범적인 코드를 본다면 보고 배우는 시간을 가져볼까 합니다.
     */
