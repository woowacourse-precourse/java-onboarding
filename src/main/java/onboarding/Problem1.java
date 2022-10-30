package onboarding;

import java.util.*;

class Person{
    int left;
    int right;
    int maxNum;
    void getNum(List<Integer> list){
        this.left = list.get(0);
        this.right = list.get(1);
        this.maxNum = Math.max(calNum(left), calNum(right));
    }

    int calNum(int page){
        int sum=0;
        int mul=1;

        while (page>0){
            sum+=page%10;
            mul*=page%10;
            page/=10;
        }
        return Math.max(sum,mul);
    }

    // 예외사항 : (1) left가 홀수가 아니다 (2) left와 right의 차이가 1이 아니다. > 이부분도 모듈화 가능
    int checkVal(){
        if (this.left%2 !=1 || this.right-this.left!=1){
            return 0;
        }else{
            return 1;
        }
    }

}

class Pobi extends Person{
    Pobi(List pobiNum){
        this.getNum(pobiNum);
    }
}

class Crong extends Person{
    Crong(List crongNum){
        this.getNum(crongNum);
    }
}

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Pobi pobiCheck = new Pobi(pobi);
        Crong crongCheck = new Crong(crong);

        if (pobiCheck.checkVal()==0 || crongCheck.checkVal()==0){
            return -1;
        }else if (pobiCheck.maxNum > crongCheck.maxNum){
            return 1;

        } else if (pobiCheck.maxNum == crongCheck.maxNum) {
            return 0;
        }else{
            return 2;
        }
    }
}
