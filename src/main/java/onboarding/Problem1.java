package onboarding;

import java.util.List;

/**
 * 예외의 경우
 * 1. 왼쪽이 홀수, 오른쪽이 짝수가 아닌 경우
 * 2. 두 페이지의 차이가 1보다 클 경우
 * 3. 페이지에 음수 혹은 0이 들어갈 경우
 * 4. 첫 장 혹은 마지막 장을 폈을 경우 -> 1,2 혹은 399,400을 펼 경우 점수를 미리 알 수 있으니 예외라고 판단.
 */

class Problem1 {
    public static int getAddMultiple(int page){
        int add = 0;
        int multiple = 1;
        while(page!=0) {
            int k = page % 10;
            add += k;
            multiple *= k;
            page /= 10;
        }
        if(add>multiple){
            return add;
        }
        return multiple;
    }

    public static int getGreater(int page1, int page2){
        int record1 = getAddMultiple(page1);
        int record2 = getAddMultiple(page2);
        if(record1>record2){
            return record1;
        }
        return record2;
    }

    public static boolean isValidate(int page1, int page2){
        if(page1%2==0 || page2%2==1){
            return false;
        }
        if((page2-page1)!=1){
            return false;
        }
        if(page1<=0 || page2<=0){
            return false;
        }
        if(page1==1 || page2 == 400){
            return false;
        }
        return true;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        if(isValidate(pobi.get(0),pobi.get(1))&&isValidate(crong.get(0), crong.get(1))) {
            int greaterPobi = getGreater(pobi.get(0), pobi.get(1));
            int greaterCrong = getGreater(crong.get(0), crong.get(1));


            if (greaterPobi > greaterCrong) {
                answer = 1;
            } else if (greaterCrong > greaterPobi) {
                answer = 2;
            } else answer = 0;
        }
        return answer;
    }
}