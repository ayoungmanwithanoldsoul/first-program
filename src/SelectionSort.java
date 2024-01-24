public class SelectionSort {
    public static void main(String[] args) {
        int[] unsortedArray = {38, 33, 44, 1, 39, 14, 37, 41, 31, 22};
        System.out.print("Unsorted: ");
        for (int i = 0; i < unsortedArray.length; i++) {
            System.out.print(" " + unsortedArray[i]);
        }

        for (int FirstUnsortedElement = 0; FirstUnsortedElement < unsortedArray.length - 1; FirstUnsortedElement++) {
            int currentMinimum = FirstUnsortedElement;
            for (int k = FirstUnsortedElement + 1; k < unsortedArray.length; k++) {
                if (unsortedArray[k] < unsortedArray[currentMinimum]) {
                    currentMinimum = k;
                }
            }
            int temp = unsortedArray[FirstUnsortedElement];
            unsortedArray[FirstUnsortedElement] = unsortedArray[currentMinimum];
            unsortedArray[currentMinimum] = temp;
        }

        System.out.print("\nSorted:");
        for (int k = 0; k < unsortedArray.length; k++) {
            System.out.print(" " + unsortedArray[k]);
        }
    }
}
