package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1;i<=number;i++) {
            String numStr = Integer.toString(i);
            String[] strArr = numStr.split("");
            for(int j=0;j<strArr.length;j++){
                if(strArr[j].equals("3") || strArr[j].equals("6") || strArr[j].equals("9")){
                    answer++;
                }

            }
        }
        return answer;
    }
}
