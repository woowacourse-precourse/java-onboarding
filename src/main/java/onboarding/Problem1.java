package onboarding;

import java.util.List;
import java.util.Arrays;

class RestrictException extends Exception {
    String exMsg;

    public RestrictException() {
    }

    public RestrictException(String message) {
        exMsg = "RestrictException: " + message;
    }
}

class Problem1 {
    private static class Splitting {
        int[] leftElement = new int[3];
        int[] rightElement = new int[3];

        Splitting(List<Integer> client) throws RestrictException {
            if (client.get(1) - client.get(0) != 1 || client.get(0) == 1 || client.get(1) == 400 || client.get(0) % 2 != 1) {
                throw new RestrictException();
            } else {
                leftElement[0] = client.get(0) / 100;
                leftElement[1] = (client.get(0) % 100) / 10;
                leftElement[2] = client.get(0) % 10;
                rightElement[0] = client.get(1) / 100;
                rightElement[1] = (client.get(1) % 100) / 10;
                rightElement[2] = client.get(1) % 10;
            }
        }
    }

    private static class SelfMax {
        int[] maximumCandidates = {0, 1, 0, 1};

        SelfMax(int[] leftElement, int[] rightElement) {
            for (Integer element : leftElement) {
                this.maximumCandidates[0] += element;
            }
            for (int i = 0; i < 3; i++) {
                if (leftElement[i] == 0) {
                    continue;
                }
                this.maximumCandidates[1] *= leftElement[i];
            }
            for (Integer element : rightElement) {
                this.maximumCandidates[2] += element;
            }
            for (int i = 0; i < 3; i++) {
                if (rightElement[i] == 0) {
                    continue;
                }
                this.maximumCandidates[3] *= rightElement[i];
            }
        }

        public int findMaximum() {
            Arrays.sort(this.maximumCandidates);
            return maximumCandidates[3];
        }
    }

    private static class Winner {
        int pobi;
        int crong;

        Winner(int pobi, int crong) {
            this.pobi = pobi;
            this.crong = crong;
        }

        public int findWinner() {
            if (pobi > crong) {
                return 1;
            } else if (pobi < crong) {
                return 2;
            } else return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try {
            Splitting splitPobis = new Splitting(pobi);
            Splitting splitCrong = new Splitting(crong);
            SelfMax pobiMaximum = new SelfMax(splitPobis.leftElement, splitPobis.rightElement);
            SelfMax crongMaximum = new SelfMax(splitCrong.leftElement, splitCrong.rightElement);
            Winner winner = new Winner(pobiMaximum.findMaximum(), crongMaximum.findMaximum());
            answer = winner.findWinner();
        } catch (RestrictException e) {
            return answer = -1;
        }
        return answer;
    }
}