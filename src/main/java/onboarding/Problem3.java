package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getApplause(number);
    }

    /**
     * [숫자 하나 당 박수 구하기]
     * - 입력으로 들어온 숫자에 몇 번의 박수를 처야하는지 반환
     * @param number
     * @return clap
     */
    public static int getClapPerNumber(int number){
        String strNumber = Integer.toString(number);
        int strNumberLength = strNumber.length();
        int clap = 0;
        for (int i = 0 ; i < strNumberLength; i ++) {
            if (Character.getNumericValue(strNumber.charAt(i)) != 0 && Character.getNumericValue(strNumber.charAt(i)) % 3 == 0) {
                clap += 1;
            }
        }
        return clap;
    }

    /**
     * [모든 박수 구하기]
     * - 1부터 입력으로 들어온 number까지 총 몇번의 박수를 처야하는지 반환
     * @param number
     * @return Applause
     */
    public static int getApplause(int number){
        int Applause = 0;
        for (int i = 1; i < number+1; i++) {
            Applause+=getClapPerNumber(i);
        }
        return Applause;
    }

}
