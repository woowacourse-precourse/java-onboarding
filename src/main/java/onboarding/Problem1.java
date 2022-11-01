package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        BookPage pobiBook = new BookPage(pobi.get(Page.LEFT_PAGE.getPage()),
                pobi.get(Page.RIGHT_PAGE.getPage()));
        BookPage crongBook = new BookPage(crong.get(Page.LEFT_PAGE.getPage()),
                crong.get(Page.RIGHT_PAGE.getPage()));

        if(!pobiBook.isValid() || !crongBook.isValid()) return Winner.EXCEPTION.getScore();

        Calculator<BookPage, Integer> po = new BookPageCalculator();
        po.setVariable(pobiBook);
        Calculator<BookPage, Integer> cr = new BookPageCalculator();
        cr.setVariable(crongBook);

        int pobiMaxNumber = po.calculation();
        int crongMaxNumber = cr.calculation();

        if(pobiMaxNumber > crongMaxNumber) answer = Winner.POBI.getScore();
        else if(pobiMaxNumber < crongMaxNumber) answer = Winner.CRONG.getScore();
        else answer = Winner.TIE.getScore();

        return answer;
    }

    public enum Page{
        LEFT_PAGE(0), RIGHT_PAGE(1);

        private int page;

        Page(int page){
            this.page = page;
        }

        public int getPage() {
            return page;
        }
    }

    public enum Winner{
        POBI(1), CRONG(2), TIE(0), EXCEPTION(-1);

        private final int score;

        Winner(int score){
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }

    public static class BookPage{
        private int left, right;

        BookPage(int left, int right){
            this.left = left;
            this.right = right;
        }

        public boolean isValid(){
            return (right - left) == 1;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }
    }

    private static class BookPageCalculator implements Calculator<BookPage, Integer>{
        private int left, right;

        @Override
        public Integer calculation(){
            return calMaxValue();
        }

        @Override
        public void setVariable(BookPage bookPage) {
            left = bookPage.getLeft();
            right = bookPage.getRight();
        }

        private int calMaxValue(){
            return Math.max(maxSum(), maxMultiply());
        }

        private int maxSum(){
            return Math.max(sum(left), multiply(right));
        }

        private int maxMultiply(){
            return Math.max(sum(left), multiply(right));
        }

        private int sum(int num){
            int value = 0;
            char[] chars = String.valueOf(num).toCharArray();
            for(int i=0; i<chars.length; i++){
                value += (chars[i]-'0');
            }
            return value;
        }

        private int multiply(int num){
            int value = 1;
            char[] chars = String.valueOf(num).toCharArray();
            for(int i=0; i<chars.length; i++){
                value *= (chars[i]-'0');
            }
            return value;
        }
    }
}