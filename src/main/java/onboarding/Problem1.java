package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Book pobiBook;
        Book crongBook;
        try {
            pobiBook = new Book(pobi.get(0), pobi.get(1));
            crongBook = new Book(crong.get(0), crong.get(1));
        }catch (Exception e){
            return -1;
        }
        int pobiMax = getMax(pobiBook);
        int crongMax = getMax(crongBook);
        /*
        크롱의 점수가 포비의 점수보다 큰가? 아니라면 포비의 점수가 더 큰가? 그것도 아니라면 둘의 점수는 동일하다.
         */
        return crongMax > pobiMax ? 2 : crongMax < pobiMax ? 1 : 0;
    }
    public static int getMax(Book book){
        return Math.max(getMaxValue(book.getPreviousPage()),getMaxValue(book.getNextPage()));
    }
    /*
    multipeMax == 각 자리 수 곱하기
    plusMax = 각 자리 수 더하기
     */
    public static int getMaxValue(int input){
        int multipleMax=1, plusMax=0;
        while(input!=0){
            multipleMax *= input%10;
            plusMax += input%10;
            input /= 10;
        }
        return Math.max(multipleMax,plusMax);
    }
    static class Book{
        private final int previousPage;
        private final int nextPage;
        public int getPreviousPage() {
            return previousPage;
        }
        public int getNextPage() {
            return nextPage;
        }
        Book(int previousPage, int nextPage) throws Exception {
            if (findException(previousPage,nextPage)) throw new Exception();
            this.previousPage = previousPage;
            this.nextPage = nextPage;
        }

        public boolean findException(int previousPage, int nextPage){
        /*
        예외사항 1. 1 페이지 혹은 400 페이지가 나오는 경우
        예외사항 2. 이전 페이지와 다음 페이지가 연속적이지 않은 경우
        예외사항 3. 이전 페이지가 홀수이고 다음 페이지가 짝수가 아닌 경우
        */
            if (previousPage==1 || nextPage==400) return true;
            if (previousPage-nextPage<-1) return true;
            return previousPage % 2 ==0 || nextPage % 2 ==1;
        }
    }
}