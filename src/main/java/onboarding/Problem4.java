package onboarding;
import java.util.*;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(int i=0; i<word.length();i++){
            char ch=word.charAt(i);

            if(ch=='a' || ch =='A')
                ch+='Z'-'A';
            else if(ch=='b' || ch=='B')
                ch+='Y'-'B';
            else if(ch=='c'||ch=='C')
                ch+='X'-'C';
            else if(ch=='d'||ch=='D')
                ch+='W'-'D';
            else if(ch=='e'||ch=='E')
                ch+='V'-'E';
            else if(ch=='f'||ch=='F')
                ch+='U'-'F';
            else if(ch=='g'||ch=='G')
                ch+='T'-'G';
            else if(ch=='h'||ch=='H')
                ch+='S'-'H';
            else if(ch=='i'||ch=='I')
                ch+='R'-'I';
            else if(ch=='j'||ch=='J')
                ch+='Q'-'J';
            else if(ch=='k'||ch=='K')
                ch+='P'-'K';
            else if(ch=='l'||ch=='L')
                ch-='L'-'O';
            else if(ch=='m'||ch=='M')
                ch+='N'-'M';
            else if(ch=='n'||ch=='N')
                ch-='N'-'M';
            else if(ch=='o'||ch=='O')
                ch+='L'-'O';
            else if(ch=='p'||ch=='P')
                ch-='P'-'K';
            else if(ch=='q'||ch=='Q')
                ch-='Q'-'J';
            else if(ch=='r'||ch=='R')
                ch-='R'-'I';
            else if(ch=='s'||ch=='S')
                ch-='S'-'H';
            else if(ch=='t'||ch=='T')
                ch-='T'-'G';
            else if(ch=='u'||ch=='U')
                ch-='U'-'F';
            else if(ch=='v'||ch=='V')
                ch-='V'-'E';
            else if(ch=='w'||ch=='W')
                ch-='W'-'D';
            else if(ch=='x'||ch=='X')
                ch-='X'-'C';
            else if(ch=='y'||ch=='Y')
                ch-='Y'-'B';
            else if(ch=='z'||ch=='Z')
                ch-='Z'-'A';

            word=word.substring(0,i)+ch+word.substring(i+1);
        }

        return word;
    }
}
