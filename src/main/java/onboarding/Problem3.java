package onboarding;

/*
3 6 9가 아닌 10의 자리수일때 손뼉수 3
3 6 9 인 10의 자리수일때 손뼉수 10 + 3
1~99의 손뼉수는 7 * 3 + 3 * 13 = 60

3 6 9가 아닌 100의 자리수일때 손뼉수 60. 1~99의 손뼉수와 동일하기 때문이다.
3 6 9인 100의 자리수일때 손뼉수 100 + 60
1~999의 손뼉수는 60 * 7 + 160 * 3 = 900

3 6 9가 아닌 1000의 자리수일떄 손뼉수 900. 1~999의 손뼉수와 동일하기 때문이다.
3 6 9인 1000의 자리수일때 손뼉수 = 1000 + 900
1~9999의 손뼉수는 900 * 7 + 1900 * 3 = 12000
 */
public class Problem3 {
    public static int clapTen(int number){
        int digit369, digitNormal, number1Digit;
        boolean is369 = number % 30 < 10 ? true : false;
        if(is369){
            digit369 = number / 30 - 1;
            digitNormal = number / 10 - digit369;
            number1Digit = number % 10 + 1 + (number % 10 / 3);
        }
        else{
            digit369 = number / 30;
            digitNormal = number / 10 - digit369;
            number1Digit = number % 10 / 3;
        }
        return digit369 * 13 + digitNormal * 3 + number1Digit;
    }

    public static int clapHundred(int number){
        int digit369, digitNormal, number10Digit;
        boolean is369 = number % 300 < 100 ? true : false;
        if(is369){
            digit369 = number / 300 - 1;
            digitNormal = number / 100 - digit369;
            number10Digit = number % 100 + 1 + clapTen(number % 100);
        }
        else{
            digit369 = number / 300;
            digitNormal = number / 100 - digit369;
            number10Digit = clapTen(number % 100);
        }
        return digit369 * 160 + digitNormal * 60 + number10Digit;
    }

    public static int clapThousand(int number){
        int digit369, digitNormal, number100Digit;
        boolean is369 = number % 3000 < 1000 ? true : false;
        if(is369){
            digit369 = number / 3000 - 1;
            digitNormal = number / 1000 - digit369;
            number100Digit = number % 1000 + 1 + clapHundred(number % 1000);
        }
        else{
            digit369 = number / 3000;
            digitNormal = number / 1000 - digit369;
            number100Digit = clapHundred(number % 1000);
        }
        return digit369 * 900 + digitNormal * 1900 + number100Digit;
    }

    public static int solution(int number) {
        int answer = 0;

        if(number == 10000)
            answer = clapThousand(9999);
        else if(number / 1000 > 0)
            answer = clapThousand(number);
        else if(number / 100 > 0)
            answer = clapHundred(number);
        else
            answer = clapTen(number);

        return answer;
    }
}
