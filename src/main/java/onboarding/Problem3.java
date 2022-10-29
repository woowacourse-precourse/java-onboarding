package onboarding;
// 주어진 숫자가 3, 6, 9를 가지고 있을때, 카운트를 추가하는 함수
// 1부터 주어진 숫자까지 카운트를 세서 반환하는 함수
// 총 카운트를 가져오는 함수

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = checkNumber(number);

        return answer;
    }
    public static int checkNumber(int number){
        int count = 0;
        for(int i=1;i<=number;i++){
            int current = i;
            count = getCount(count, current);
        }
        return count;
    }
// 현재 주어진 숫자가 3,6,9가 들어간 숫자를 얼마나 포함하고 있었는가 계산하는 함수
    private static int getCount(int count, int current) {
        while (current != 0){
            count = increseCounts(count, current);
            current /=10;
        }
        return count;
    }

    private static int increseCounts(int count, int current) {
        if((current %10)==3||(current %10)==6||(current %10)==9){
            count++;
        }
        return count;
    }
    
}
