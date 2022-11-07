package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = countNumber(number);
        return answer;
    }

    //ver.1 Brutal Idea
    public static int countNumber(int number){
        int count = 0 ; // count total of clap
        for(int n =1;n<number+1;n++)
        {
            String stringnum = Integer.toString(n);
            String[] numarr = stringnum.split("");
            for (int k = 0; k<numarr.length;k++)
            {
                if(numarr[k].contains("3")||numarr[k].contains("6")||numarr[k].contains("9"))
                {
                    count+=1;
                }
            }

        }
        return count;
    }
}
