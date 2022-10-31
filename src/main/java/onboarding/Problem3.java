package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int ans = 0, lnumber = 1, rnumber, exp = 1, point; //정답, 왼쪽 숫자, 오른쪽 숫자, 지수, 현재 커서가 가리키는 포인트
        while (lnumber > 0){ // 왼쪽 숫자가 더이상 없을 때 까지
            lnumber = number/(exp*10); // 지수 왼쪽 숫자
            rnumber = number%exp; // 포인트 오른쪽 숫자
            point = (number/exp)%10; // 포인트 숫자
            if (point != 0 && point % 3 == 0) ans += (lnumber*3+(point/3 - 1))*exp+rnumber+1; // 포인트가 3,6,9라면
            else if (point > 3) ans+= (lnumber*3+(point/3))*exp; // 포인트가 3초과이면 크다면
            else ans+= (lnumber * 3 * exp); // 3미만이면
            exp *= 10; // 지수 * 10;
        }
        return ans;
    }
}
