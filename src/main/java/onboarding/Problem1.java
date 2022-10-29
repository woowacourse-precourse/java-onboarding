package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try{
            Book pobiBook = new Book(pobi.get(0), pobi.get(1));
            Book crongBook = new Book(crong.get(0), crong.get(1));
            return whoIsWin(pobiBook,crongBook);
        }catch (IllegalArgumentException e){
            return -1;
        }
    }

    public static int whoIsWin(Book pobiBook, Book crongBook) {
        validBook(pobiBook);
        validBook(crongBook);
        int pobiMaxValue=getMaxValue(pobiBook);
        int crongMaxValue=getMaxValue(crongBook);
        if(crongMaxValue<pobiMaxValue){
            return 1;
        }else if(crongMaxValue>pobiMaxValue){
            return 2;
        }else{
            return 0;
        }
    }

    private static void validBook(Book book) {
        if(book.hasFirstPageOrLess() ||book.hasLastPageOrMore() || book.getDifference()!=1)
            throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    private static int getMaxValue(Book book) {
        return Math.max(getMaxSumValue(book),getMaxMulValue(book));
    }

    private static int getMaxMulValue(Book book) {
        return Math.max(multiply(book.getLeftPage()), multiply(book.getRightPage()));
    }

    private static int getMaxSumValue(Book book) {
        return Math.max(sum(book.getLeftPage()), sum(book.getRightPage()));
    }

    private static int multiply(Integer page) {
        String pageStr = String.valueOf(page);
        String[] split = pageStr.split("");
        int mul=Arrays.stream(split).mapToInt(Integer::valueOf).reduce(1,(left,right)->left*right);
        return mul;
    }

    private static int sum(Integer page) {
        String pageStr = String.valueOf(page);
        String[] split = pageStr.split("");
        int sum = Arrays.stream(split).mapToInt(Integer::valueOf).sum();
        return sum;
    }
}