package onboarding;

public class Problem3 {

    //손뼉 쳐야하는 숫자들
    private static final char[] NUMBER_TYPES = {'3', '6', '9'};

    //각 숫자가 나왔을 때 개수 세기
    private static int countEachNumberType(int i, char numberType) {
        String stringCountNumber = "" + i;

        //처음 숫자 길이 - 3(혹은 6,9)를 공백으로 대체 후 길이 = 3(6or9)개수
        return stringCountNumber.length() - stringCountNumber.replace(String.valueOf(numberType), "").length();
    }

    //모든 손뼉쳐야하는 숫자들에 대해 개수 세기
    private static int countNumberTypes(int i) {
        int count = 0;
        for (char numberType : NUMBER_TYPES) {
            count += countEachNumberType(i, numberType);
        }
        return count;
    }
    
    public static int solution(int number) {

        int answer = 0;

        for (int i = 0; i <= number; i++) {
            answer += countNumberTypes(i);
        }

        return answer;
    }
}
