package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTIONAL_CIRCUMSTANCES = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!BookPageDiscriminator.isProperBookPage(pobi, crong)){
            return EXCEPTIONAL_CIRCUMSTANCES;
        }

        int pobiScore = BookScoreCalculator.score(pobi);
        int crongScore = BookScoreCalculator.score(crong);

        if (pobiScore > crongScore) return POBI_WIN;
        if (pobiScore < crongScore) return CRONG_WIN;
        return DRAW;
    }
}

class BookPageDiscriminator {
    private static final int MAX_PAGE_NUMBER = 400;

    public static boolean isProperBookPage(List<Integer>... books){
        return Arrays.stream(books)
                .map(book -> isProperBookPage(book))
                .reduce(true, (a,b) -> a && b);
    }

    public static boolean isProperBookPage(List<Integer> book){
        return isListSize2(book) && isLeftPageNumberOdd(book)
                && isNextPage(book) && isPageNumberInBook(book);
    }

    private static boolean isListSize2(List<Integer> list){
        return list.size() == 2;
    }

    private static boolean isLeftPageNumberOdd(List<Integer> book){
        return book.get(0) % 2 == 1;
    }

    private static boolean isNextPage(List<Integer> book){
        return book.get(0) + 1 == book.get(1);
    }

    private static boolean isPageNumberInBook(List<Integer> book){
        return 1 <= book.get(0) && book.get(0) <= MAX_PAGE_NUMBER;
    }
}

class BookScoreCalculator {
    public static int score(List<Integer> book){
        return Math.max(pageScore(book.get(0)), pageScore(book.get(1)));
    }

    private static int pageScore(Integer pageNumber){
        int[] digitArray = makeDigitArray(pageNumber);
        return Math.max(addArrayElementsIntoSum(digitArray), multiplyArrayElementsIntoProduct(digitArray));
    }

    private static int[] makeDigitArray (Integer number){
        int totalDigitNumber = (int) ( Math.log10(number)+1 );
        int[] digitArray = new int[totalDigitNumber];

        for (int i=0; i<totalDigitNumber; i++){
            digitArray[i] = number / (int) Math.pow(10, totalDigitNumber - (i+1)) % 10;
        }
        return digitArray;
    }

    private static int addArrayElementsIntoSum(int[] array){
        return Arrays.stream(array).sum();
    }

    private static int multiplyArrayElementsIntoProduct(int[] array){
        return Arrays.stream(array).reduce(1, (a,b) -> a*b);
    }
}