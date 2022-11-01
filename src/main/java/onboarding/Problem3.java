package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int cnt=0;
        String three = "3", six = "6", nine = "9";

        for (int i = 1 ; i<=number; i++){
            String strI = String.valueOf(i);
            String[] strIArr= strI.split("");
            for(int j = 0; j<strIArr.length; j++){
                // System.out.println("strIArr[j]="+strIArr[j]+" strI="+strI+" i="+i+" j="+j +" cnt=" + cnt);
                if (strIArr[j].equals(three) == true)
                    cnt++;
                if (strIArr[j].equals(six) == true)
                    cnt++;
                if (strIArr[j].equals(nine) == true)
                    cnt++;
            }
        }
        answer = cnt;
        return answer;
    }
}
