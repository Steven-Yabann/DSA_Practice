package DSA_Practice;
import java.util.concurrent.TimeUnit;
public class Sort {

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    //Bubble Sort
    public static void bubbleSort(int[] array){
        boolean sortComplete = false;
        int last = array.length - 1;

        while(!sortComplete){
            sortComplete = true;
            for(int i = 0; i < last; i++) {
                if(array[i] > array[i + 1]){
                    swap(array, i, i+1);
                    sortComplete = false;
                }
            }
            //last --;
        }
    }

    //Insertion sort
    public static void insertionSort(int[] array){
        int n = array.length;

        for(int i = 1; i < n; i++){
            int key = array[i];
            int j = i - 1;
            while()
        }
    }
    public static void main(String[] args){
        int[] numbers = {45, 23, 78, 43, 12, 9};    //9 12 23 43 45 78
        long startTime = System.nanoTime();
        bubbleSort(numbers);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("\nExe time in ns is:" + timeTaken);
    }
}
