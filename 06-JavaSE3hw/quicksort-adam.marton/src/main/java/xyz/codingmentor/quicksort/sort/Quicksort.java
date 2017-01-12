package xyz.codingmentor.quicksort.sort;

/**
 *
 * @author Ádám
 */
public class Quicksort {
    
    private Quicksort() {
        //default constructor
    }
    public static void sort(int[] array) {
        if(array.length > 1) {
            int firstIndex = 0;
            int lastIndex = array.length-1;
            quicksort(array, firstIndex, lastIndex);
        }
    }
    
    public static void quicksort(int[] array, int firstIndex, int lastIndex) {
        int pivotElement = array[firstIndex + (lastIndex-firstIndex)/2];
        int left = firstIndex;
        int right = lastIndex;
        while(left <= right) {
            while(array[left] < pivotElement) {
                left++;
            }
            while(array[right] > pivotElement) {
                right--;
            }
            if(left <= right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        if(firstIndex < right) {
            quicksort(array, firstIndex, right);
        }
        if(left < lastIndex) {
            quicksort(array, left, lastIndex);
        }
    }
}
