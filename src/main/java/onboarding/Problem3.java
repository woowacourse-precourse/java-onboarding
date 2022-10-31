package onboarding;

public class Problem3 {
    public static int solution(int number) {

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



    }




}
