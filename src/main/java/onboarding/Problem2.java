package onboarding;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }
    public static String solution(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder(cryptogram);
        boolean flag = true;
        while(flag){
            flag = false;
            for (int i =1;i< stringBuilder.length();i++){
                if(stringBuilder.charAt(i)== stringBuilder.charAt(i-1)){
                    stringBuilder.replace(i-1,i+1,"");
                    flag = true;
                    i--;
                }
            }
        }

        return stringBuilder.toString();
    }
}
