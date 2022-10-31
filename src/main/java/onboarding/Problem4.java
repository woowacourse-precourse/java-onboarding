package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] charArr=word.toCharArray();
        int intArr[]=new int[charArr.length];

        for(int i=0;i<charArr.length;i++){
            if((int) charArr[i] != 32 && (int) charArr[i]>=65 && (int) charArr[i]<=90) {
                intArr[i] = (int) charArr[i];
                intArr[i] = 155 - intArr[i];
                charArr[i] = (char) intArr[i];
            }else if((int) charArr[i] != 32 && (int) charArr[i]>=97 && (int) charArr[i]<=122) {
                intArr[i] = (int) charArr[i];
                intArr[i] = 219 - intArr[i];
                charArr[i] = (char) intArr[i];
            }
        }
        answer= new String(charArr);
        return answer;
    }
}
