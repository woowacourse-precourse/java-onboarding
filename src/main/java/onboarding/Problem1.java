package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        Book pobiBook;
        Book crongBook;
        try {
            pobiBook = new Book(pobi.get(0), pobi.get(1));
            crongBook = new Book(crong.get(0), crong.get(1));
        }catch (Exception e){
            return -1;
        }
        return answer;
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