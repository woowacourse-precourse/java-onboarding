package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String temp = cryptogram;
        int i, k;
        int prev = cryptogram.charAt(0);
        boolean check = false;

        System.out.println(temp.length());

        while(!check) {
            check = true;
            i = 1;
            k = 0;

            while (i < temp.length() - 1) {
                if (prev != temp.charAt(i)) {
                    if (k != 0) {
                        prev = temp.charAt(i);

                        k = 0;

                        i++;

                        continue;
                    }
                    else
                    {
                        System.out.println(i);
                        answer += (char) prev;
                        k = 0;
                    }
                }
                else
                {
                    check = false;

                    k = i + 1;
                }

                System.out.println("i: " + i + " prev: " + prev + " i: " + i);
                prev = cryptogram.charAt(i);

                i++;
                System.out.println("i: " + i + " prev: " + prev + " i: " + i);
            }

            System.out.println(i);

            if(k != 0) {
                answer += (char)prev;
            }

            temp = answer;

            System.out.println(temp);

            break;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }
}
