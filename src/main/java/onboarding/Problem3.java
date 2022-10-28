package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int totalNum(int number) {
        int countNum=0;
        for(int i=1; i<=number; i++){
            System.out.print(i + " ");
            countNum += oneNumToCharArr(i);
        }
        return countNum;
    }

    public static int oneNumToCharArr(int number){
        String str = String.valueOf(number);
        char[] charArr = str.toCharArray();

        return countNum(charArr);
    }

    public static int countNum (char[] charArr){
        int countNum=0;
        for(char ch : charArr){
            if(ch == '3' || ch == '6' || ch == '9'){
                countNum++;
            }
        }
        return countNum;
    }
}
