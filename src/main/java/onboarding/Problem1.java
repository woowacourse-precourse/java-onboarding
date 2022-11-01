package onboarding;

import java.util.List;

import onboarding.problem1.Book;
import onboarding.problem1.PageUtil;
import onboarding.problem1.GameInfo;
import onboarding.problem1.PageInfo;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi == null || crong == null){
            return GameInfo.INVALID.getInfo();
        }

        if(pobi.size() < PageInfo.MIN_PAGES_COUNT.getInfo() || crong.size() < PageInfo.MIN_PAGES_COUNT.getInfo()){
            return GameInfo.INVALID.getInfo();
        }

        Book pobiBook = Book.builder()
            .leftPageNumber(pobi.get(PageInfo.LEFT.getInfo()))
            .rightPageNumber(pobi.get(PageInfo.RIGHT.getInfo()))
            .build();

        Book crongBook = Book.builder()
            .leftPageNumber(crong.get(PageInfo.LEFT.getInfo()))
            .rightPageNumber(crong.get(PageInfo.RIGHT.getInfo()))
            .build();

        if(!PageUtil.isValidPages(pobiBook) || !PageUtil.isValidPages(crongBook)){
            return GameInfo.INVALID.getInfo();
        }

        long pobiResult = Math.max(PageUtil.getMaxPlusPageNumber(pobiBook), PageUtil.getMaxTimesPageNumber(pobiBook));
        long crongResult = Math.max(PageUtil.getMaxPlusPageNumber(crongBook), PageUtil.getMaxTimesPageNumber(crongBook));

        if(pobiResult > crongResult){
            return GameInfo.POBI_WIN.getInfo();
        }

        if(pobiResult < crongResult){
            return GameInfo.CRONG_WIN.getInfo();
        }

        return GameInfo.DRAW.getInfo();
    }
}
