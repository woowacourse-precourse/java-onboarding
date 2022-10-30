package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int count = 0;

        for(int i = 1; i < number + 1; i++) {
            String[] numberArray = Integer.toString(i).split("");

            for(int j = 0; j < numberArray.length; j++) {
                if(numberArray[j].equals("3") || numberArray[j].equals("6") || numberArray[j].equals("9")) {
                    count += 1;
                }
            }
        }

        answer = count;

        return answer;
    }
}
