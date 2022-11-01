package onboarding;

import java.util.List;


class Problem1 {
    // 1. 페이지가 연속적인가 -> 아닐경우 return -1
    // 2. 오른쪽 왼쪽 페이지의 연산 메소드 => 덧셈 구하는 메소드, 곱셈 구하는 메소드
    // 3. 나의 큰수 결정하는 메소드
    // 4. 포비랑 크롱을 비교하는 메소드 -> return 값을 정하는 메소드 : solution
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(checkPage(pobi) && checkPage(crong)){
            if(calMax(pobi)>calMax(crong)) return 1;
            else if(calMax(pobi)<calMax(crong)) return 2;
            else return 0;
        }else return -1;
    }
    public static boolean checkSize(List<Integer> list){ // 페이지 길이 체크 확인하는 메소드
        if(list.size()!=2) return false;
        return true;
    }
    public static boolean checkPage(List<Integer> list){ // 페이지 연속 확인하는 메소드
        if(list.get(1)-list.get(0)==1) return true;
        else return false;
    }
    public static int calPlus(int num){ // 각페이지의 덧셈을 해주는 메소드
        // 98
        int sum =0;
        while (num!=0){ // 98/10 = 9…8
            sum +=num%10;
            num = num/10;
        }
        return sum;
    }

    public static int calMulti(int num){ // 각페이지의 곱셈을 해주는 메소드
        int multi =1;
        while (num!=0){ // 98/10 = 9…8
            multi *=num%10;
            num = num/10;
        }
        return multi;
    }

    public static int calMax(List<Integer> list){ // 왼쪽 오른쪽 페이지 계산해주는 메소드
        int leftNum = Math.max(calPlus(list.get(0)), calMulti((list.get(0))));
        int rigthNum = Math.max(calPlus(list.get(1)), calMulti((list.get(1))));
        int max = Math.max(leftNum,rigthNum);

        return max;
    }

}