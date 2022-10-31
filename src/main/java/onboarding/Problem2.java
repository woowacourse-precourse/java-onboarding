package onboarding;

public class Problem2 {


    public static String solution(String cryptogram) {
        String answer = "answer";
        int check = 0;

        do
        { 
            check = 0;
            for(int i = 0; i < cryptogram.length() -1; i++)
            {
                if(cryptogram.charAt(i) == cryptogram.charAt(i+1))
                {
                    cryptogram =  cryptogram.substring(0,i) + cryptogram.substring(i+2);
                    check = 1;
                }
                System.out.println(cryptogram);
            }

        }while(check == 1);

        answer = cryptogram;
        return answer;
    }
}
