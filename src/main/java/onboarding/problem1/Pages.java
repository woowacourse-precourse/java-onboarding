package onboarding.problem1;

import java.util.List;

public class Pages {
    //페이지 리스트
    private List<Integer> pages;

    public Pages(List<Integer> pobi) {
        pages = pobi;
        if(isFaultSet())throw new RuntimeException();
    }

    public boolean isBiggerThan(Pages opposite){
        return this.getMaxValue() > opposite.getMaxValue();
    }

    public boolean isSameWith(Pages opposite){
        return this.getMaxValue() == opposite.getMaxValue();
    }

    private Integer getMaxValue(){
        return 0;
        //3. 1, 2에 왼쪽 오른쪽 페이지를 넣고 최대 값을 반환하는 메소드
    }

    private boolean isFaultSet(){
        //6. 나올 수 없는 페이지인지, 연속된 페이지인지 체크는 메소드
        return false;
    }

    private Integer sumPageNumber(Integer pageNumber){
        return 0;
        //1.각 자리 숫자를 모두 더하는 메소드
    }

    private Integer multiplyPageNumber(Integer pageNumber){
        return 0;
        //2.각 자리 숫자를 모두 곱하는 메소드
    }





}
