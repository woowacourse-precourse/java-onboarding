package onboarding;

public class Problem3 {
    public static int solution(int number) {


        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {
                if (piece[i][j] == '3' || piece[i][j] == '6' || piece[i][j] == '9') {
                    count++;
                }
            }
        }
        return count;

    }


}
