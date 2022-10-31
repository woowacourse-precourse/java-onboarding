package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int[] countList = new int[5];

        return answer;
    }


    //몇 자리수 인지 구하기
    public static int getPlaceValue(int number) {

        String num = Integer.toString(number);

        int cnt = num.length();

        // 1:1의 자리, 2:10의 자리 3:100의 자리 4:1000의 자리 5:10000의 자리
        return cnt;
    }
}
