package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clapHands = 0;

        for (int index = 1; index <= number; index++) {
            String candidate = String.valueOf(index);
            for (String each : candidate.split("")) {
                if (each.equals("3") || each.equals("6") || each.equals("9")) {
                    clapHands += 1;
                }
            }
        }
        return clapHands;
    }
}

//            if (i < 10) {
//                if (splitThreeSixNine[0].equals("3")) {
//                    clapHands += 1;
//                } else if (splitThreeSixNine[0].equals("6")) {
//                    clapHands += 1;
//                } else if (splitThreeSixNine[0].equals("9")) {
//                    clapHands += 1;
//                }
//            } else if (i >= 10) {
//                if (splitThreeSixNine[0].equals("3") && (splitThreeSixNine[1].equals("3") ||splitThreeSixNine[1].equals("6") || splitThreeSixNine[1].equals("9"))) {
//                    clapHands += 2;
//                } else if (splitThreeSixNine[0].equals("6") && (splitThreeSixNine[1].equals("6")|| splitThreeSixNine[1].equals("3")|| splitThreeSixNine[1].equals("9"))) {
//                    clapHands += 2;
//                } else if (splitThreeSixNine[0].equals("9") && (splitThreeSixNine[1].equals("9")|| splitThreeSixNine[1].equals("6")|| splitThreeSixNine[1].equals("3"))) {
//                    clapHands += 2;
//                } else if (splitThreeSixNine[0].equals("3") || splitThreeSixNine[1].equals("3")) {
//                    clapHands += 1;
//                } else if (splitThreeSixNine[0].equals("6") || splitThreeSixNine[1].equals("6")) {
//                    clapHands += 1;
//                } else if (splitThreeSixNine[0].equals("9") || splitThreeSixNine[1].equals("9")) {
//                    clapHands += 1;
//                }


//    }
//        return clapHands;
//}


