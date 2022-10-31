package onboarding;

import java.util.List;
class Main{
    public static void main(String[] args){
        Problem1 prob = new Problem1();
        prob.solution(List.of(97, 98),List.of(97, 98));
    }
}
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /*
        1. 포비와 크롱의 페이지가 유효한 지 체크 - 예외 시 -1 리턴
        2. 포비와 크롱, 각 자리수를 더하는 것과, 곱하는 것 중 최댓값을 찾음
        3. 크기 비교하여 answer 리턴
        */        
        System.out.println(16 == getBestScore(182));     
        return answer;
    }
    static boolean checkException(List<Integer> pages){
        int left = pages.get(0);
        int right = pages.get(1);
        if ( right - left != 1 || left % 2 == 0 || 
            left + right < 0 || left + right > 799) return false;
        return true;
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