package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int TIE = 0;
    public static final int ILLEGAL_ARG = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            Book pobiBook = new Book(pobi.get(0), pobi.get(1));
            Book crongBook = new Book(crong.get(0), crong.get(1));
            return whoIsWin(pobiBook,crongBook);
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
        if(book.hasFirstPageOrLess() ||book.hasLastPageOrMore() || book.getDifference()!=1)
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private static int getMaxValue(Book book) {
        return Math.max(getMaxSumValue(book),getMaxMulValue(book));
    }

    private static int getMaxSumValue(Book book) {
        return Math.max(sum(book.getLeftPage()), sum(book.getRightPage()));
    }

    private static int getMaxMulValue(Book book) {
        return Math.max(multiply(book.getLeftPage()), multiply(book.getRightPage()));
    }

    private static int sum(Integer page) {
        String[] split = getSplitString(page);
        int sum = Arrays.stream(split).mapToInt(Integer::valueOf).sum();
        return sum;
    }

    private static int multiply(Integer page) {
        String[] split = getSplitString(page);
        int mul=Arrays.stream(split).mapToInt(Integer::valueOf).reduce(1,(left,right)->left*right);
        return mul;
    }

    private static String[] getSplitString(Integer page) {
        String pageStr = String.valueOf(page);
        return pageStr.split("");
    }
}