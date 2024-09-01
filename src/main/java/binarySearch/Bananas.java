package binarySearch;

public class Bananas {

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 1; int r = 1;

        for (int pile : piles) r = Math.max(pile, r); // go through array and find max right variable.
        int res = 1;

        while (l <= r) {
            int k = (r - l) / 2 + l;

            int hoursTaken = calculateHours(piles, k);

            if (hoursTaken <= h) {
                r = k - 1;
                res = k; // We know for sure that we can eat k bananas in the allotted time. Set it to the answer and shift the bound.
            }
            else {
                // We need more bananas per hour... Shift window to the right
                l = k + 1;
            }
        }

        return res;
    }

    // Calculate the rate of time it would take to eat bananas at `k` pace.
    public static int calculateHours(int[] piles, int k) {
        int hours = 0;
        for (int p : piles) {
            hours += Math.ceil((double) p / k);
        }
        return hours;
    }


    public static void main(String[] args) {
        int[] in = {3,6,7,11};
        int h = 8;

        System.out.printf("Min eating speed is %d", minEatingSpeed(in, h));

    }
}
