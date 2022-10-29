package onboarding;
// 주어진 숫자가 3, 6, 9를 가지고 있을때, 카운트를 추가하는 함수
// 1부터 주어진 숫자까지 카운트를 세서 반환하는 함수
// 총 카운트를 가져오는 함수

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
//        answer = checkNumber(number);

        return answer;
    }

//369를 지니고 있을때 카운트를 세서 반환하는 함수
    private static int increseCounts(int count, int current) {
        if((current %10)==3||(current %10)==6||(current %10)==9){
            count++;
        }
        return count;
    }
    
}
