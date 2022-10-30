package onboarding;

public class Sample3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=1;i<=number;i++){
            String numberString = String.valueOf(i);
            answer += calculateCount(numberString);
        }
        return answer;
    }

    private static int calculateCount(String numberString) {
        int count = 0;
        for(int j=0;j<numberString.length();j++){
            char nowChar = numberString.charAt(j);
            count+=isClap(nowChar);
        }
        return count;
    }

    private static int isClap(char numberChar) {
        if(numberChar=='3'||numberChar=='6'||numberChar=='9') {
            return 1;
        }
        return 0;
    }
}
