public class InsertionSort {

    public static void main(String[] args) {
        System.out.print("Unsorted:");
        int[] unsortedArray = {26, 40, 34, 27, 1, 1, 22, 46, 21, 28};//{42, 39, 15, 32, 8, 30, 37, 28, 21, 6};
        for (int i = 0; i < unsortedArray.length; i++) {
            System.out.print(" " + unsortedArray[i]);
        }

        int sorted = 0;
        for (int j = sorted + 1; j < unsortedArray.length; j++) {
            int elementX = unsortedArray[j];

            for (int k = sorted; k >= 0; k--) {
                if (unsortedArray[k] > elementX) {
                    unsortedArray[k + 1] = unsortedArray[k];
                    unsortedArray[k] = elementX;
                    sorted = j;
                } else {
//                    unsortedArray[k+1] = elementX;
                    sorted = j;
                    break;
                }
            }

        }
        System.out.print("\nSorted:");
        for (int l = 0; l < unsortedArray.length; l++) {
            System.out.print(" " + unsortedArray[l]);
        }

    }
}
