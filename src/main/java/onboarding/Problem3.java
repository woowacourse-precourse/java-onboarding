package onboarding;

public class Problem3 {
    public static String[] splitStr(int num){
        String str = Integer.toString(num);
        String[] arrStr=str.split("");
        return arrStr;
    }
    public static int solution(int number) {
        int answer = 0;
        for(int i=1;i<=number;i++) {
            String[] strArr = splitStr(i);
            for(int j=0;j<strArr.length;j++){
                if(strArr[j].equals("3") || strArr[j].equals("6") || strArr[j].equals("9")){
                    answer++;
                }
            }
        }
        return answer;
    }
}