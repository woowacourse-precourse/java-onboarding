package onboarding;

import java.util.List;

/*
기능 구현 사항
1. 포비의 가장 큰 수를 구한다.
2. 크롱의 가장 큰 수를 구한다.
3. 두 명의 점수를 비교해서 높은 사람이 이긴다.
4. 포비나 크롱의 리스트에 시작 면, 마지막 면이 있으면 예외사항을 리턴한다.
 */

class Problem1 {
    private final static int EXCEPTION = -1;
    private final static int POBI_WIN = 1;
    private final static int CRONG_WIN = 2;
    private final static int TIE = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageList pobiPageList = new PageList(pobi);
        PageList crongPageList = new PageList(crong);

        if(!pobiPageList.isValidPageList() || !crongPageList.isValidPageList()) {
            return EXCEPTION;
        }

        Integer pobiMaxValue = pobiPageList.findMaxPageList();
        Integer crongMaxValue = crongPageList.findMaxPageList();

        if(pobiMaxValue > crongMaxValue) {
            return POBI_WIN;
        }
        if(pobiMaxValue < crongMaxValue) {
            return CRONG_WIN;
        }
        return TIE;
    }

    private static class PageList {
        private final Page left;
        private final Page right;
        PageList(List<Integer> pages) {
            left = new Page(pages.get(0));
            right = new Page(pages.get(1));
        }

        Integer findMaxPageList() {
            Integer leftMaxNumber = left.findMaximumNumber();
            Integer rightMaxNumber = right.findMaximumNumber();

            return Math.max(leftMaxNumber, rightMaxNumber);
        }

        boolean isValidPageList() {
            if(!left.isValidPage() || !right.isValidPage()) {
                return false;
            }
            if(!left.isLeftPage() || right.isLeftPage()) {
                return false;
            }
            if(!right.isNextPage(left)) {
                return false;
            }
            return true;
        }
    }

    private static class Page {
        private final Integer number;

        Page(Integer number) {
            this.number = number;
        }

        char[] changeIntegerToCharArray() {
            String stringPageNumber = number.toString();
            return stringPageNumber.toCharArray();
        }

        Integer findMaximumNumber() {
            PageCharArray pageCharArray = new PageCharArray(this);
            Integer plusPageValue = pageCharArray.plusPageNumber();
            Integer multipliedPageValue = pageCharArray.multiplyPageNumber();
            return Math.max(plusPageValue, multipliedPageValue);
        }

        boolean isValidPage() {
            if (number == 1 || number == 400) {
                return false;
            }
            return true;
        }

        boolean isNextPage(Page previousPage) {
            if(number == previousPage.number + 1) {
                return true;
            }
            return false;
        }

        boolean isLeftPage() {
            if(number % 2 == 1) {
                return true;
            }
            return false;
        }

    }

    private static class PageCharArray {
        private final char[] stringPageNumber;

        PageCharArray(Page page) {
            stringPageNumber = page.changeIntegerToCharArray();
        }
        Integer plusPageNumber() {
            int result = 0;
            for (char pageNumber : stringPageNumber) {
                int eachPageNumber = Character.getNumericValue(pageNumber);
                result += eachPageNumber;
            }
            return result;
        }

        Integer multiplyPageNumber() {
            int result = 1;
            for (char pageNumber : stringPageNumber) {
                int eachPageNumber = Character.getNumericValue(pageNumber);
                result *= eachPageNumber;
            }
            return result;
        }
    }
}