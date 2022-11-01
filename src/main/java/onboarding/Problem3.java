package onboarding;

public class Problem3 {
    public static int solution(int number) {

        String totalString = numToString(number);

        int count = countClap(totalString);

        return count;
    }

    public static int countClap(String totalString) { // 1부터 number까지 모든 정수를 문자열로 변환하는 기능
        int j;
        int count =0;
        for(j=0; j< totalString.length(); j++){
            if(totalString.charAt(j)=='3'|| totalString.charAt(j)=='6'|| totalString.charAt(j)=='9'){
                count++;
            }
        }
        return count;
    }

    public static String numToString(int number) {  // 손뼉을 쳐야하는 횟수를 반환하는 기능
        String totalString="";
        int i;
        for(i=1; i< number +1; i++){

            totalString+=Integer.toString(i);

        }
        return totalString;
    }
}
