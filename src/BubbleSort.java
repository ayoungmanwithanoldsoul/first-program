public class BubbleSort {
    public static void main(String[] args) {
        boolean swapped;
        int[] unsortedArr = {10,0,14,40,3,43,34,18,9,8};
        System.out.print("Unsorted:");
        for (int i = 0; i < unsortedArr.length - 1; i++){
            System.out.print(" " + unsortedArr[i]);
        }
        do {
            swapped = false;
            for (int i = 0; i < unsortedArr.length-1; i++){
                if (unsortedArr[i] > unsortedArr[i+1]){
                    int temp;
                    temp = unsortedArr[i+1];
                    unsortedArr[i+1] = unsortedArr[i];
                    unsortedArr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        System.out.print("\nSorted: ");
        for (int i = 0; i < unsortedArr.length - 1; i++){
            System.out.print(" " + unsortedArr[i]);
        }
    }
}
