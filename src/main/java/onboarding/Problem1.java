package onboarding;

import java.util.List;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. 포비와 크롱의 페이지가 유효한 지 체크 - 예외 시 -1 리턴
 		if (checkException(pobi) || checkException(crong)) return -1;

 		// 2. 포비와 크롱, 각 자리수를 더하는 것과, 곱하는 것 중 최댓값을 찾음
 		int pobiScore = Math.max(getBestScore(pobi.get(0)), getBestScore(pobi.get(1)));
 		int crongScore = Math.max(getBestScore(crong.get(0)), getBestScore(crong.get(1)));

 		//3. 크기 비교하여 answer 리턴		 
 		if ( pobiScore == crongScore ) return 0;   
        return (pobiScore > crongScore)? 1: 2;
    }
    static boolean checkException(List<Integer> pages){
        int left = pages.get(0);
        int right = pages.get(1);

        if ( right - left != 1 || left % 2 == 0 || 
            left + right < 0 || left + right > 799) return true;

        return false;
 	}
    static int getBestScore(int page){
 		int sum = 0;
 		int multiple = 1;

 		while ( page != 0 ){
 			sum += page%10;
 			multiple *= page%10;

 			page /= 10;
 		}

 		return Math.max(sum, multiple);
 	}
}