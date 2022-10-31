package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //예외사항 찾기
        boolean pobiException = CheckException(pobi);
        boolean crongException = CheckException(crong);

        if(pobiException || crongException)
            return -1;

        //승부 결과 가져오기
        int pobiScore = GetScore(pobi);
        int crongScore = GetScore(crong);

        if(pobiScore == crongScore)
            return 0;
        else if(pobiScore > crongScore)
            return 1;
        else
            return 2;
    }

    public static boolean CheckException(List<Integer> target){
        int leftPageNum = target.get(0);
        int rightPageNum = target.get(1);

        if(leftPageNum % 2 == 0)
            return true;

        if(rightPageNum % 2 == 1)
            return true;

        if(rightPageNum - leftPageNum != 1)
            return true;

        return false;
    }

    public static int GetScore(List<Integer> target){
        int leftPageScore = CompareSumAndMulti(target.get(0));
        int rightPageScore = CompareSumAndMulti(target.get(1));

        return leftPageScore > rightPageScore ? leftPageScore : rightPageScore;

    }

    public static int CompareSumAndMulti(int pageNum){
        int multi = 1;
        int sum = 0;

        while(pageNum != 0){
            int num = pageNum % 10;
            multi *= num;
            sum += num;
            pageNum /= 10;
        }

        return multi > sum ? multi : sum;
    }
}
