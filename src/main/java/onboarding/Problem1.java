package onboarding;

import java.util.List;


class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkPage(pobi) && checkPage(crong)){
            if(calMax(pobi)>calMax(crong)) return 1;
            else if(calMax(pobi)<calMax(crong)) return 2;
            else return 0;
        }else return -1;
    }

    public static boolean checkPage(List<Integer> list){ // 페이지 연속 확인하는 메소드
        if(list.get(1)-list.get(0)==1) return true;
        else return false;

    }

    public static int calMax(List<Integer> list){ // 왼쪽 오른쪽 페이지 계산해주는 메소드
        int leftNum = Math.max(calPlus(list.get(0)), calMulti((list.get(0))));
        int rigthNum = Math.max(calPlus(list.get(1)), calMulti((list.get(1))));
        int max = Math.max(leftNum,rigthNum);

        return max;
    }

    public static int calPlus(int num){ // 각페이지의 덧셈을 해주는 메소드
        // 98
        int sum =0;
        while (num!=0){ // 98/10 = 9...8
            num = num/10;
            sum +=num%10;
        }
        return sum;
    }

    public static int calMulti(int num){ // 각페이지의 곱셈을 해주는 메소드
        int multi =0;
        while (num!=0){ // 98/10 = 9...8
            num = num/10;
            multi *=num%10;
        }
        return multi;
    }


}