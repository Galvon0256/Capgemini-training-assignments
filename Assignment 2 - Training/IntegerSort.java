package assignment2;
public class IntegerSort {
    static void IntegerArraySort(int[] arr){
        for (int i = 0; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

    }

    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void main(String[] args) {
        int[] arr1 = {1,3,4,2,5};
        IntegerArraySort(arr1);
        printArray(arr1);
    }
}

