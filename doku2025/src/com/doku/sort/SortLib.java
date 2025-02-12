package com.doku.sort;

import java.util.Arrays;

public class SortLib {
	
    static void bubbleSort(int arr[]){
        int i, j, temp;
        int n = arr.length;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("...[" + i + "]: " + Arrays.toString(arr));

            if (swapped == false)
                break;
        }
    }
    
    static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
          
            // Assume the current position holds
            // the minimum element
            int min_idx = i;

            // Iterate through the unsorted portion
            // to find the actual minimum
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                  
                    // Update min_idx if a smaller element
                    // is found
                    min_idx = j;
                }
            }

            // Move minimum element to its
            // correct position
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;   
            
            System.out.println("...[" + i + "]: " + Arrays.toString(arr));
        }
    }
    
    static void  countSort(int array[]) {
    	int max = Arrays.stream(array).max().getAsInt();   // Find the max() element of the array
    	int[] count = new int[max + 1];                    // define counter array according max()
    	for(int n: array) count[n]++;    // counting each occurrence
    	
    	for(int i=0, idx=0; i<count.length; i++)   // replace original with expansion according to count
    		while(count[i]>0) {
    			array[idx]=i;
    			idx++;
    			count[i]--;
    		}
    }
    
    
    private static int partition(int a[], int low, int high)
    {
        int pivot = a[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
          
            // If current element is smaller than or
            // equal to pivot
            if (a[j] <= pivot)
            {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      a[] --> Array to be sorted,
      l  --> Starting index,
      h  --> Ending index */
    public static void quicksort(int a[], int l, int h)
    {
        if (l < h)
        {
            int pi = partition(a, l, h);

            // Recursively sort elements before
            // partition and after partition
            quicksort(a, l, pi-1);
            quicksort(a, pi+1, h);
        }
    }
    public static void quicksort(int a[]) {
    	quicksort(a, 0, a.length-1);
    }
}
