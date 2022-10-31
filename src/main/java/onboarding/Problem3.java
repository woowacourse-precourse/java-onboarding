package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0; // 3,6,9 count
        int save = 0;  //save number
        //repeat numbers and find that how many 3,6,9 in each number
        for (int i = 1; i <= number; i++) {
            save = i;
            while (save != 0) { //check each number
                if (save % 10 == 3 || save % 10 == 6 || save % 10 == 9){
                    count++;
                }
                save /= 10;
            }
        }

        int answer = count;
        return answer;
    }

}
