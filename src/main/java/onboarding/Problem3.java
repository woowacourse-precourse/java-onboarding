package onboarding;

public class Problem3 {
    public static int solution(int number) {
        Problem3 p3 = new Problem3();
        return p3.totalNum(number);
    }

    public int totalNum(int number) {
        Problem3 p3 = new Problem3();
        int countNum=0;
        for(int i=1; i<=number; i++){
            System.out.print(i + " ");
            countNum += p3.oneNumToCharArr(i);
        }
        return countNum;
    }

    public int oneNumToCharArr(int number){
        Problem3 p3 = new Problem3();
        String str = String.valueOf(number);
        char[] charArr = str.toCharArray();

        return p3. countNum(charArr);
    }

    public int countNum (char[] charArr){
        int countNum=0;
        for(char ch : charArr){
            if(ch == '3' || ch == '6' || ch == '9'){
                countNum++;
            }
        }
        return countNum;
    }
}
