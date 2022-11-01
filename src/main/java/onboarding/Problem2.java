package onboarding;

import java.util.Arrays;

public class Problem2 {



    public static String solution(String cryptogram) {
        String answer = "";
        String tmp= "";
        char[] c = cryptogram.toCharArray();
        char first = c[0];
        int cnt = 0;


        int cou =1;
        while(true)
        {
            tmp+=first;
            System.out.println("c.length = " + c.length);
            try {
                for (int i = 1; i < c.length; i++) {
                    if (first == c[i]) {
                        cnt += 1;
                        if (tmp.length() > 1)
                            tmp = tmp.substring(0, tmp.length() - 1);
                        else
                            tmp = tmp.substring(0, 0);
                    } else {
                        tmp += c[i];
                    }
                    first = c[i];
                }
            }catch (Exception e){
                System.out.println("e = " + e);
                System.out.println("c len = " + c.length);
                System.out.println("tmp1 = " + tmp);
            }

            if(cnt ==0 || tmp.equals("")) {
                answer=tmp;
                System.out.println("tsol mp = " + tmp);
                break;
            }
            try {
                System.out.println("tmp2 = " + tmp);
                System.out.println("cnt = " + cnt);
                c = tmp.toCharArray();
                System.out.println("c = " + Arrays.toString(c));

                cnt = 0;
                first = c[0];
                System.out.println("first = " + first);
                tmp = "";
                cou += 1;
            }
            catch (Exception e){
                System.out.println("e = " + e);
                System.out.println();
            }
        }


        return answer;
    }

    }

