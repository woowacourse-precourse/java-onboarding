package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    /**
     * 해당 숫자의 (3,6,9) 포함 개수 체크
     * @param i
     * @return
     */
    private static int checkTable(int i) {
        int check = 0;
        char[] table = {'3','6','9'};

        for (char x: Integer.toString(i).toCharArray()) {
            for (char tb : table) {
                if (x == tb) check++;
            }
        }
        return check;
    }
}
