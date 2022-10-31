package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;


        // 0번 : 100, 1번 : 1000, 2번 : 10000 각각의 3의 개수
        int[] countList = new int[3];

        countList[0] = tens(100);
        System.out.println("countList[0] = " + countList[0]);

        if (number == 10000) {return countList[3];}

        int placeValue = getPlaceValue(number);

        switch (placeValue) {
            case 1 :
                answer = units(number);
                break;

            case 2 :
                answer = tens(number);
                break;


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

    public static int tens(int number) {

        int ten = (int) number / 10;
        int unit = number % 10;
        int tensThreeCount = (int)ten/3;

        int result = 0;


        if (ten%3 == 0) {
            result = ten * 3 + 10 * (tensThreeCount-1) +(unit + 1) + units(unit);
        } else {
            result = ten * 3 + 10 * tensThreeCount + units(unit);
        }

        return result;
    }



    public static void main(String[] args) {
        int number = 33;

        System.out.println(solution(number));
    }

}
