package onboarding;

/*
3 6 9가 아닌 10의 자리수일때 손뼉수 3
3 6 9 인 10의 자리수일때 손뼉수 10
1~99의 손뼉수는 7 * 3 + 3 * 10 = 51

3 6 9가 아닌 100의 자리수일때 손뼉수 51. 1~99의 손뼉수와 동일하기 때문이다.
3 6 9인 100의 자리수일때 손뼉수 100
1~999의 손뼉수는 51 * 7 + 100 * 3 = 657

3 6 9가 아닌 1000의 자리수일떄 손뼉수 657. 1~999의 손뼉수와 동일하기 때문이다.
3 6 9인 1000의 자리수일때 손뼉수 = 1000
1~9999의 손뼉수는 657 * 7 + 1000 * 3 = 4971
 */
public class Problem3 {
    public static int clapTen(int number){
        int digit369 = number / 30;
        int digitNormal = number / 10 - digit369 + 1;

        return digit369 * 10 + digitNormal * 3;
    }

    public static int clapHundred(int number){
        int digit369 = number / 300;
        int digitNormal = number / 100 - digit369 + 1;

        return digit369 * 100 + digitNormal * clapTen(99);
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
