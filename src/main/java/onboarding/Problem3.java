package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;


        //0번 : 10의 자리, 1번 : 100의 자리, 2번 : 1000의 자리, 3번 : 10000의 자리
        int[] countList = new int[4];

        if (number == 10000) {return countList[3];}

        int placeValue = getPlaceValue(number);

        if (placeValue == 1) {
            answer = units(number);
        }


        return answer;
    }


    //몇 자리수 인지 구하기
    public static int getPlaceValue(int number) {

        String num = Integer.toString(number);

        int cnt = num.length();

        // 1:1의 자리, 2:10의 자리 3:100의 자리 4:1000의 자리 5:10000의 자리
        return cnt;
    }


    public static int units(int number) {

        return (int) number / 3;

    }

    public static void main(String[] args) {
        int number = 9;

        System.out.println(solution(number));
    }

}
