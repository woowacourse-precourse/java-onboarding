package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char[] arr = word.toCharArray();

        for(char c : arr){
            switch(c){
                case 'A' : answer +="Z"; break;
                case 'B' : answer +="Y"; break;
                case 'C' : answer +="X"; break;
                case 'D' : answer +="W"; break;
                case 'E' : answer +="v"; break;
                case 'F' : answer +="U"; break;
                case 'G' : answer +="T"; break;
                case 'H' : answer +="S"; break;
                case 'I' : answer +="R"; break;
                case 'J' : answer +="Q"; break;
                case 'K' : answer +="P"; break;
                case 'L' : answer +="O"; break;
                case 'M' : answer +="N"; break;
                case 'N' : answer +="M"; break;
                case 'O' : answer +="L"; break;
                case 'P' : answer +="K"; break;
                case 'Q' : answer +="J"; break;
                case 'R' : answer +="I"; break;
                case 'S' : answer +="H"; break;
                case 'T' : answer +="G"; break;
                case 'U' : answer +="F"; break;
                case 'V' : answer +="E"; break;
                case 'W' : answer +="D"; break;
                case 'X' : answer +="C"; break;
                case 'Y' : answer +="B"; break;
                case 'Z' : answer +="A"; break;
                ////////////////
                case 'a' : answer +="z"; break;
                case 'b' : answer +="y"; break;
                case 'c' : answer +="x"; break;
                case 'd' : answer +="w"; break;
                case 'e' : answer +="v"; break;
                case 'f' : answer +="u"; break;
                case 'g' : answer +="t"; break;
                case 'h' : answer +="s"; break;
                case 'i' : answer +="r"; break;
                case 'j' : answer +="q"; break;
                case 'k' : answer +="p"; break;
                case 'l' : answer +="o"; break;
                case 'm' : answer +="n"; break;
                case 'n' : answer +="m"; break;
                case 'o' : answer +="l"; break;
                case 'p' : answer +="k"; break;
                case 'q' : answer +="j"; break;
                case 'r' : answer +="i"; break;
                case 's' : answer +="h"; break;
                case 't' : answer +="g"; break;
                case 'u' : answer +="f"; break;
                case 'v' : answer +="e"; break;
                case 'w' : answer +="d"; break;
                case 'x' : answer +="c"; break;
                case 'y' : answer +="b"; break;
                case 'z' : answer +="a"; break;

                case ' ' : answer +=" "; break;
                default: answer += c;break;
            }
        }
        return answer;
    }
}
