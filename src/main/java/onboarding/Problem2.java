package onboarding;
public class Problem2 {

    public static int howManyZero(int start,int frontOrBack, char arr[]) {
        int cnt = 0;
        if (frontOrBack==1) {
            for (int i=start; i<arr.length; i++) {
                if (arr[i]=='0') {
                    cnt++;
                }
            }
        } else if (frontOrBack==0) {
            for (int i=start; i>0; i--) {
                if (arr[i]=='0') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void continuityToZero(int start, int end, char[] arr) {
        for (int i = start; i <= end; i++) {
            arr[i] = '0';
        }
    }

    public static String charArrayToString(char[] arr) {
        String toString ="";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0') {
                toString = toString + arr[i];
            }
        }
        return toString;
    }
    public static int zeroChecker(char[] arr, int numberOfZeros,int cryptogramPointer) {
        int continuityEnd=0;
        while (true) {
            if (cryptogramPointer<0||cryptogramPointer+numberOfZeros+1>=arr.length) {
                break;
            }
            if (arr[cryptogramPointer]==arr[cryptogramPointer+numberOfZeros+1]) {
                continuityEnd=cryptogramPointer+numberOfZeros+1;
                cryptogramPointer++;
            } else {
                break;
            }
        }
        return continuityEnd;
    }

    public static String solution(String cryptogram) {
        String answer="";
        int continuityEnd=0;
        int continuityStart=0;
        int numberOfZeros =0;
        int cryptogramPointer = 0;
        char[] cryptogramArray = cryptogram.toCharArray();

        while(true) {
            continuityStart=cryptogramPointer;
            numberOfZeros = howManyZero(cryptogramPointer,1,cryptogramArray);
            if (cryptogramPointer<0||cryptogramPointer+numberOfZeros+1>=cryptogramArray.length) {
                break;
            }
            if (cryptogramArray[cryptogramPointer]==cryptogramArray[cryptogramPointer+numberOfZeros+1]) {
                continuityEnd=zeroChecker(cryptogramArray,numberOfZeros,cryptogramPointer);
                continuityToZero(continuityStart,continuityEnd,cryptogramArray);
                cryptogramPointer=cryptogramPointer-howManyZero(cryptogramPointer,0,cryptogramArray);
            } else {
                cryptogramPointer++;
            }
        }
        answer=charArrayToString(cryptogramArray);

        return answer;
    }

}