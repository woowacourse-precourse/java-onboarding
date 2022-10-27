package onboarding.problem1.utils.validator;

import onboarding.problem1.utils.validator.exception.PagePairException;
import java.util.List;

public class PagePairValidator {
    private List<Integer> list;

    public PagePairValidator(List<Integer> list) throws PagePairException {
        this.list = list;
        validatePagePair();
    }

    private void validatePagePair() throws PagePairException{
        if(!checkPagePair()){
            throw new PagePairException("페이지 짝 번호가 맞지 않음");
        }
    }
    //왼쪽 페이지 번호 + 1 이 오른쪽 페이지 번호가 맞는지 검증
    private boolean checkPagePair(){
        if((list.get(0)+1) == list.get(1)){
            return true;
        }
        return false;
    }

}


