package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        sb.append(cryptogram.charAt(0));

        char temp = cryptogram.charAt(0);
        for (int i = 1; i < cryptogram.length(); i++) {
            if(temp == cryptogram.charAt(i)){
                temp = cryptogram.charAt(i);
                sb.setLength(sb.length() - 1);
                System.out.println("if : " + sb.toString());
            }
            else{
                temp = cryptogram.charAt(i);
                sb.append(cryptogram.charAt(i));
                System.out.println("else : " + sb.toString());
            }
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    public static void main(String[] args) {
        String cryptogram = "browoanoommnaon";
        solution(cryptogram);
    }
}