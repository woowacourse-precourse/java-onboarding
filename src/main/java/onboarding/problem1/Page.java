package onboarding.problem1;

public class Page {

    private Integer pageNumber;

    public Page(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /*
     * 페이지 각 자릿수의 합 계산
     */
    public int sumOfDigit() {
        int num = this.pageNumber, sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    /*
     * 페이지 각 자릿수의 곱 계산
     */
    public int multiplyOfDigit() {
        int num = this.pageNumber,  multiply = 1;
        while (num > 0) {
            multiply *= num % 10;
            num /= 10;
        }
        return multiply;
    }
}
