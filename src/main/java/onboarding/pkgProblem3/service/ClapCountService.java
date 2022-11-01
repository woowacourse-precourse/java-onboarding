package onboarding.pkgProblem3.service;

import java.util.ArrayList;
import java.util.List;

public class ClapCountService {

    static final ArrayList<Integer> clapNumberList = new ArrayList<Integer>(List.of(3,6,9));
    private int count;

    /* ---------------- Public operations -------------- */

    /**
     * 주어진 숫자까지 쳐야하는 박수의 숫자를 구하는 메소드
     * @param number - 게임에 주어진 숫자
     * @return number까지 쳐야하는 박수 숫자 return
     */
    public int clapCount(int number){
        for(int i=1; i<=number;i++){
            int a = i;
            while(a > 0){
                for(int n : clapNumberList){
                    if(a % 10 == n){ //현재 1의 자리수에 369가 있는지 확인
                        count++;
                        break;
                    }
                }
                a = a/10; // 다음 자리수 확인을 위함
            }
        }
        return count;
    }
}
