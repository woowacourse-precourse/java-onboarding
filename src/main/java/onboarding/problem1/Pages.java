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
        return getPagesMaxValue(pages.get(0)) > getPagesMaxValue(pages.get(1)) ? getPagesMaxValue(pages.get(0)) : getPagesMaxValue(pages.get(1));
    }
    private Integer getPagesMaxValue(Integer pageNumber){
        Integer multiplyResult = multiplyPageNumber(pageNumber);
        Integer sumResult = sumPageNumber(pageNumber);
        return multiplyResult > sumResult ? multiplyResult : sumResult;
        //3. 1, 2에 왼쪽 오른쪽 페이지를 넣고 최대 값을 반환하는 메소드
    }

    private boolean isFaultSet(){
        //6. 나올 수 없는 페이지인지, 연속된 페이지인지 체크는 메소드
        return false;
    }

    private Integer sumPageNumber(Integer pageNumber){
        Integer sum = 0;
        while (pageNumber > 0) {
            sum += pageNumber % 10;
            pageNumber /= 10;
        }
        return sum;
    }

    private Integer multiplyPageNumber(Integer pageNumber){
        Integer mul = 1;
        while (pageNumber > 0) {
            mul *= pageNumber % 10;
            pageNumber /= 10;
        }
        return mul;
        //2.각 자리 숫자를 모두 곱하는 메소드
    }





}
