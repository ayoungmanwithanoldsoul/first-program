import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Random;

public class MergeSort4 {
    public static void main(String[] args) {
//        int preMin, preSec, postMin, postSec;
//        StopWatch watch = new StopWatch();

        Random rand = new Random();
        int[] numbers = new int[100000000];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000000);
        }

/*        System.out.println("Before: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }*/

        System.out.print("\nTime before exec: ");
        int[] pre = getTime();
        Instant start = Instant.now();
        mergeSort(numbers);
        Instant end = Instant.now();
        System.out.print("\nTime after exec: ");
        int[] post = getTime();
        System.out.printf("\nDifference: %d minutes, %d seconds, %d miliseconds", (post[0] - pre[0]), (post[1] - pre[1]), (post[2] - pre[2]));
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\nElapsed: " + timeElapsed);

/*        System.out.println("\nAfter: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }*/
    }

    private static void mergeSort(int[] inputArray) {
        int arrayLength = inputArray.length;

        if (arrayLength < 2) {
            return;
        }

        int midIndex = arrayLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[arrayLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = midIndex; i < inputArray.length; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        mergeArray(inputArray, leftHalf, rightHalf);
    }

    private static void mergeArray(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i, j, k;
        i = j = k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] > rightHalf[j]) {
                inputArray[k] = rightHalf[j];
                j++;
            } else {
                inputArray[k] = leftHalf[i];
                i++;
            }
            k++;
        }

        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    private static int[] getTime() {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);

        System.out.printf("%02d:%02d:%02d.%03d", hour, minute, second, millis);
        return new int[]{minute, second, millis};
    }
}