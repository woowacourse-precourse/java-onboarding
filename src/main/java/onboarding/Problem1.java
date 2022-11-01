package onboarding;

import java.util.List;

class Problem1 {

    //페이지 번호 점수 계산 메소드
    public static int getScore(int page) {
        int Sum = 0;
        int Mul = 1;

        while (page > 0) {
            Sum += (page % 10);
            Mul *= (page % 10);
            page = page / 10;

        }
        return Math.max(Sum, Mul);
    }

    //좌, 우 페이지 점수 비교후 최종 점수 메소드
    public static int getFinal(List<Integer> s){

        int left = getScore(s.get(0));
        int right = getScore(s.get(1));

        return Math.max(left, right);
    }

    public static boolean isInvalid(List<Integer> a, List<Integer> b){
        int aa = a.get(0);
        int bb = a.get(1);
        int cc = b.get(0);
        int dd = b.get(1);
        boolean valid1 =  ((aa < 0) ||(aa>400) || (bb<0)||(bb >400));
        boolean valid2 = ((cc < 0) ||(cc>400) || (dd<0)||(dd >400));
        boolean checkA = bb - aa != 1;
        boolean checkB = dd - cc != 1;
        boolean valid = (valid1 || valid2 || checkA || checkB);
        return valid;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        int pobiScore = getFinal(pobi);
        int crongScore = getFinal(crong);

        if (isInvalid(pobi, crong))
            return -1;

            if (pobiScore > crongScore) {
                answer = 1;
            } else if (pobiScore == crongScore) {
                answer = 0;
            } else
                answer = 2;



            return answer;
    }
}