package onboarding;
import java.util.List;

class Problem1 {
    private static Integer getDigitNum(char Digit){
        return Integer.parseInt(Character.toString(Digit));
    }
    private static Integer comparePlusMul(String pageDigit) {
        Integer plusNum = 0;
        Integer mulNum = 1;

        for (int index = 0; index < pageDigit.length(); index++) {
            plusNum += getDigitNum(pageDigit.charAt(index));
            mulNum *= getDigitNum(pageDigit.charAt(index));
        }

        Integer maxNum = Math.max(plusNum, mulNum);

        return maxNum;
    }
    private static Integer getMaxNum(List<Integer> Page) {
        Integer leftPage = Page.get(0);
        Integer rightPage = Page.get(1);

        if(leftPage>400||leftPage<1|| rightPage >400|| rightPage<1|| leftPage%2==0 || rightPage%2==1 || rightPage - leftPage!=1){
            return -1;
        }

        String leftPageDigit = leftPage.toString();
        String rightPageDigit = rightPage.toString();

        Integer leftMaxnum = comparePlusMul(leftPageDigit);
        Integer rightMaxnum = comparePlusMul(rightPageDigit);

        Integer ret = Math.max(leftMaxnum,rightMaxnum);

        return ret;
    }
    private static Integer compareNum(Integer pobiMaxNum, Integer crongMaxNum){
        if(pobiMaxNum==-1 || crongMaxNum==-1){
            return  -1;
        }
        if(pobiMaxNum > crongMaxNum){
            return  1;
        }
        if(pobiMaxNum < crongMaxNum){
            return  2;
        }
        if(pobiMaxNum == crongMaxNum){
            return  0;
        }
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        Integer pobiMaxNum = getMaxNum(pobi);
        Integer crongMaxNum = getMaxNum(crong);
        answer = compareNum(pobiMaxNum,crongMaxNum);
        return answer;
    }
}