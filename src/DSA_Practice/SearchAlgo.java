package DSA_Practice;
//Yabann Steven
//167027
// ICS 2.1 E


public class SearchAlgo {
    //Linear search
    // linear search O(n)
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
    // binary Search O(log(n))
    public static boolean binarySearch(int[] array, int x, int left, int right){
        if (left > right){
            System.out.println("Invalid index values");
            return false;
        }

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
        int[] lampHeights = {1, 2, 4, 5, 7, 9, 13, 20, 24};

        if (linearSearch(lampHeights, 4)){
            System.out.println("Item found");
        }else{
            System.out.println("Item not found");
        }

        if (binarySearch(lampHeights, 1, lampHeights.length-1, 0)){
            System.out.println("Item found");
        }else{
            System.out.println("Item not found");
        }
    }
}
