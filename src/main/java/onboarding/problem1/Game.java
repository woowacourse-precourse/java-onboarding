package onboarding.problem1;

/*
 * 각 페이지의 숫자를 더하거나 곱하는 메소드를 가지는 클래스
 */
public class Game {

    /* 최종적으로 가장 큰 값이 저장되는 인스턴스 변수 */
    private int result = 0;
    /*
    * 모든 경우의 수를 검사하는 Game의 생성자
     * @param left 왼쪽 페이지
     * @param right 오른쪽 페이지
     */
    public Game(int left, int right){
        addAll(left);
        addAll(right);
        mulAll(left);
        mulAll(right);
    }
    /*
     * n의 각 자리 숫자를 더하는 메소드
     * @param n 숫자
     */
    private void addAll(int n){
        int sum = 0;
        while (n >= 1) {
            sum += n % 10;
            n /= 10;
        }
        result = Math.max(sum, result);
    }
    /*
     * n의 각 자리 숫자를 곱하는 메소드
     * @param n 숫자
     */
    private void mulAll(int n){
        int mul = 1;
        while (n >= 1) {
            mul *= n % 10;
            n /= 10;
        }
        result = Math.max(mul, result);
    }
    /*
     * 결과값을 리턴하는 메소드
     * @return 최종적인 결과값
     */
    public int getResult(){
        return result;
    }
}
