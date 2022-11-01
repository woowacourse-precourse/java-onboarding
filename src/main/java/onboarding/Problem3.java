package onboarding;

public class Problem3 {
    public static int solution(int number) {
        String numOrder = "";

        for(int i=1; i <= number; i++){
            numOrder += i;
        }
        
        String[] numSet = numOrder.split("");
        int count = 0;
        for(int i = 0; i < numSet.length; i++){
            if(numSet[i].equals("3")||numSet[i].equals("6")||numSet[i].equals("9")){
                count += 1;
            }
        }

        return count;
    }
}
