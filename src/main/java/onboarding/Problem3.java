package onboarding;
/*
 * @version 1.0.0 2022년 11월 1일
 * @author DongWooE
 */
public class Problem3 {
    /* 최종적으로 몇번의 손뼉을 쳐야하는지 횟수가 담기는 인스턴스 변수 */
    int count = 0;
    /*
     * Problem 3의 메인 메소드
     * @param number 마지막 숫자
     * @return 손뼉를 쳐야하는 횟수
     */
    public static int solution(int number) {
        Problem3 p3 = new Problem3();
        p3.iterate(number);
        return p3.count;
    }
    /*
     * 1부터 number이하의 int값을 탐색하며 각각 몇번의 횟수를 쳐야하는지 저장하는 메소드
     * @param number 마지막 숫자
     */
    private void iterate(int number) {
        for(int i =1; i <= number; i++){
            count += countContain(i);
        }
    }
    /*
     * 해당 숫자일때 몇번의 횟수를 쳐야하는지 계산하는 메소드
     * @param n 해당 숫자
     * @return 횟수
     */
    private int countContain(int n) {
        int cnt = 0;
        while (n >= 1) {
            int m = n % 10;
            if(m !=0 && m%3 == 0) cnt++;
            n /= 10;
        }
        return cnt;
    }
}
