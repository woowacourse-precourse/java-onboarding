package onboarding.problem1;

import java.util.List;

public class PageGame {
    private Pages pobi;
    private Pages crong;

    public void join(List<Integer> pobi, List<Integer> crong){
        this.pobi = new Pages(pobi);
        this.crong = new Pages(crong);
        //1. 포비와 크롱의 배열을 인자로 받아 참가자 정하기

    }

    public Integer getWinner(){
        //2. 필드를 통해 구한 최댓값끼리 비교후 결과 반환하는 메소드
        if(pobi.isBiggerThan(crong)) return 1;
        if(crong.isBiggerThan(pobi)) return 2;
        if(pobi.isSameWith(crong)) return 0;
        return -1;
    }





}
