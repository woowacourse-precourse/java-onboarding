package onboarding;

public class Problem3 {
    public static int solution(int number) {
        checkList(number);

        int count = 0;

        String[] roomsize = new String[number];
        char[][] piece = new char[number][];


        for (int i = 0; i < number; i++) {
            roomsize[i]=Integer.toString(i+1);
            piece[i] = new char[roomsize[i].length()];

            for (int j = 0; j < roomsize[i].length(); j++) {
                piece[i][j] = roomsize[i].charAt(j);
            }
        }

        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[i].length; j++) {
                if (piece[i][j] == '3' || piece[i][j] == '6' || piece[i][j] == '9') {
                    count++;
                }
            }
        }
        return count;

    }

    public static void checkList(int number) throws IllegalArgumentException{
        if (number < 1 || number > 10000) {
            throw new IllegalArgumentException("number는 1 미만 10,000 초과인 자연수 입니다.");
        }
    }


}
