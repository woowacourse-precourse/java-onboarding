package onboarding;

import onboarding.problem1.*;

import java.util.List;

class Problem1 {

    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int TIE = 0;
    public static final int ILLEGAL_ARG = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            Book pobiBook = new Book(new Page(pobi.get(0),pobi.get(1)));
            Book crongBook = new Book(new Page(crong.get(0),crong.get(1)));
            return whoIsWin(pobiBook, crongBook);
        }catch (IllegalArgumentException e){
            return ILLEGAL_ARG;
        }
    }

    public static int whoIsWin(Book pobiBook, Book crongBook) {
        validBook(pobiBook);
        validBook(crongBook);
        int pobiMaxValue=getMaxValue(pobiBook);
        int crongMaxValue=getMaxValue(crongBook);
        if(crongMaxValue<pobiMaxValue){
            return POBI_WIN;
        }else if(crongMaxValue>pobiMaxValue){
            return CRONG_WIN;
        }else{
            return TIE;
        }
    }

    private static void validBook(Book book) {
        if(book.hasFirstPageOrLess() || book.hasLastPageOrMore() || book.pageDifference()!=1
                || book.isNotLeftPageOdd() || book.isNotRightPageEven())
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private static int getMaxValue(Book book) {
        return Math.max(getMaxValueForSum(book),getMaxValueForMul(book));
    }

    private static int getMaxValueForSum(Book book) {
        PageCalculator pageCalculator = new SumPageCalculator();
        return Math.max(book.leftPageCalc(pageCalculator), book.rightPageCalc(pageCalculator));
    }

    private static int getMaxValueForMul(Book book) {
        PageCalculator pageCalculator = new MulPageCalculator();
        return Math.max(book.leftPageCalc(pageCalculator), book.rightPageCalc(pageCalculator));
    }

}