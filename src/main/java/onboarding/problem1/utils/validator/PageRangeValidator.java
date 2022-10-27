package onboarding.problem1.utils.validator;

import onboarding.problem1.utils.Constants;
import onboarding.problem1.utils.validator.exception.PageRangeException;

import java.util.List;

public class PageRangeValidator {
    private List<Integer> list;

    public PageRangeValidator(List<Integer> list) throws PageRangeException {
        this.list = list;
        validatePageRange();
    }

    private void validatePageRange() throws PageRangeException {
        if(!checkPageRange()){
            throw new PageRangeException("펼친 책 범위가 잘못됨");
        }
    }
    //펼친 책의 페이지 범위가 1<pages<400 인지 검사
    private boolean checkPageRange(){
        if((list.get(0) > Constants.FRIST_BOOK_PAGE_NUMBER) && (list.get(1) < Constants.LAST_BOOK_PAGE_NUMBER)){
            return true;
        }
        return false;
    }
}
