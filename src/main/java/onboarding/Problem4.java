package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] tmp = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            System.out.print(tmp[i]);
            if (tmp[i] == 'a' || tmp[i] == 'A')
                tmp[i] += 25;
            else if (tmp[i] == 'b' || tmp[i] == 'B')
                tmp[i] += 23;
            else if (tmp[i] == 'c' || tmp[i] == 'C')
                tmp[i] += 21;
            else if (tmp[i] == 'd' || tmp[i] == 'D')
                tmp[i] += 19;
            else if (tmp[i] == 'e' || tmp[i] == 'E')
                tmp[i] += 17;
            else if (tmp[i] == 'f' || tmp[i] == 'F')
                tmp[i] += 15;
            else if (tmp[i] == 'g' || tmp[i] == 'G')
                tmp[i] += 13;
            else if (tmp[i] == 'h' || tmp[i] == 'H')
                tmp[i] += 11;
            else if (tmp[i] == 'i' || tmp[i] == 'I')
                tmp[i] += 9;
            else if (tmp[i] == 'j' || tmp[i] == 'J')
                tmp[i] += 7;
            else if (tmp[i] == 'k' || tmp[i] == 'K')
                tmp[i] += 5;
            else if (tmp[i] == 'l' || tmp[i] == 'L')
                tmp[i] += 3;
            else if (tmp[i] == 'm' || tmp[i] == 'M')
                tmp[i] += 1;
            else if (tmp[i] == 'n' || tmp[i] == 'N')
                tmp[i] -= 1;
            else if (tmp[i] == 'o' || tmp[i] == 'O')
                tmp[i] -= 3;
            else if (tmp[i] == 'p' || tmp[i] == 'P')
                tmp[i] -= 5;
            else if (tmp[i] == 'q' || tmp[i] == 'Q')
                tmp[i] -= 7;
            else if (tmp[i] == 'r' || tmp[i] == 'R')
                tmp[i] -= 9;
            else if (tmp[i] == 's' || tmp[i] == 'S')
                tmp[i] -= 11;
            else if (tmp[i] == 't' || tmp[i] == 'T')
                tmp[i] -= 13;
            else if (tmp[i] == 'u' || tmp[i] == 'U')
                tmp[i] -= 15;
            else if (tmp[i] == 'v' || tmp[i] == 'V')
                tmp[i] -= 17;
            else if (tmp[i] == 'w' || tmp[i] == 'W')
                tmp[i] -= 19;
            else if (tmp[i] == 'x' || tmp[i] == 'X')
                tmp[i] -= 21;
            else if (tmp[i] == 'y' || tmp[i] == 'Y')
                tmp[i] -= 23;
            else if (tmp[i] == 'z' || tmp[i] == 'Z')
                tmp[i] -= 25;
            System.out.println(tmp[i]);
            answer += tmp[i];
        }

        return answer;
    }
}
