package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        StringBuffer sb = new StringBuffer();

        sb.append(cryptogram);
        String prevString = sb.toString();

        int i=0;

        while (true){
            for(i=1;i<sb.length();i++){
                if(sb.charAt(i-1) == sb.charAt(i)){
                    sb.delete(i-1,i+1);
                    break;
                }
            }
            System.out.println(prevString);
            if(prevString.equals(sb.toString()))
                break;
            prevString = sb.toString();
        }

        answer = sb.toString();
        return answer;
    }
}
