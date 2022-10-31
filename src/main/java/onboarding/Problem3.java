package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 0; i < number+1; i++){
            String[] temp = Integer.toString(i).split("");

            for(int j = 0; j<temp.length; j++){
                if(temp[j].equals("3") || temp[j].equals("6") || temp[j].equals("9")){ answer++; }
            }
        }

        return answer;
    }
}
