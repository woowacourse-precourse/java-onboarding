package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    //각 자리수마다 더하는 메서드
    public int allAdd(List<Integer> page){
        int result = 0;
        for (Integer p : page) {
            while(p > 0){
                result += p%10;
                p /= 10;
            }
        }
        return result;
    }

    //각 자리수마다 곱하는 메서드
    public int allMulti(List<Integer> page){
        int result = 1;
        for (Integer p : page) {
            while(p > 0){
                result *= p%10;
                p /= 10;
            }
        }
        return result;
    }

    //예외처리 메서드
    public boolean except(List<Integer> page){
        //페이지 번호가 순서대로가 아닐경우
        if(page.get(1) - page.get(0) != 1){
            return false;
        //시작면과 마지막면일 경우
        }else if(page.get(0) == 1 || page.get(1) == 400){
            return false;
        //왼쪽이 홀수 오른쪽이 짝수가 아닐경우
        }else if(page.get(0)%2 ==0 || page.get(1)%2 != 0){
            return false;
        }else{
            return true;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        Problem1 p = new Problem1();
        //예외처리
        if(p.except(pobi) && p.except(crong)){
            //각 자리수를 더한값과 곱한값의 최대값 구하기
            int pobiNum = Math.max(p.allAdd(pobi),p.allMulti(pobi));
            int crongNum = Math.max(p.allAdd(crong),p.allMulti(crong));

            //pobi와 crong의 조건대로 return
            if(pobiNum > crongNum){
                answer = 1;
            }else if(pobiNum < crongNum){
                answer = 1;
            }else{
                answer = 0;
            }
        }else{
            answer = -1;
        }
        return answer;
    }
}