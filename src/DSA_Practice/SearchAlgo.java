package DSA_Practice;

public class SearchAlgo {
    //Linear search
    public static boolean linearSearch(int[] array, int x){
        int n = array.length;

        for(int i = 0; i < n; i++){
            if (array[i] == x){
                return true;
            }
        }

        return false;
    }

    //Binary Search
    public static boolean binarySearch(int[] array, int x, int left, int right){
        int mid = (left + right)/ 2;

        if (array[mid] == x){
            return true;
        }
        else if(x < array[mid]){
            return binarySearch(array, x, left, mid - 1);
        }
        else{
            return binarySearch(array, x, mid + 1, right);
        }
    }

    //main method
    public static void main(String[] args) {
        int[] lampHeights = {1, 2, 4, 5, 7, 9, 23, 65};

        if (linearSearch(lampHeights, 4)){
            System.out.println("Item found");
        }else{
            System.out.println("Item not found");
        }
    }
}
