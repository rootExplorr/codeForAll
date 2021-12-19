package org.learn.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSorter {
	
//------------------------------Heap Sort-------------------------------------------------------------	
	public static void heapSort(Student arr[]) {
		int n = arr.length;
	
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            Student temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            //reducing the siex each time
            heapify(arr, i, 0);
        }
	}
	
	// To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    public static void heapify(Student arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1 (+1)
        int r = 2 * i + 2; // right = 2*i + 2 (+1)

        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest])==1)
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r].compareTo(arr[largest])==1)
            largest = r;

        // If largest is not root
        if (largest != i) {
            Student swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
//-------------------------------------------------------------------------------------------    

//------------------------------Merge Sort-------------------------------------------------------------    
    public static void merge(Student arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
  
        /* Create temp arrays */
        Student L[] = new Student[n1];
        Student R[] = new Student[n2];
  
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
        	//  L[i] <= R[j]
            if (L[i].compareTo(R[j]) == -1 || L[i].compareTo(R[j]) == 0) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort(Student arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
  
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
//--------------------------------------------------------------------------------------------------

//-----------------------------------------Quick Sort---------------------------------------------------------    
 // A utility function to swap two elements
    static void swap(Student[] arr, int i, int j)
    {
        Student temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
      
    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(Student[] arr, int low, int high)
    {
          
        // pivot
        Student pivot = arr[high]; 
          
        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1); 
      
        for(int j = low; j <= high - 1; j++)
        {
              
            // If current element is smaller 
            // than the pivot
        	//arr[j] < pivot[1, 12]
            if (arr[j].compareTo(pivot) == -1) 
            {
                  
                // Increment index of 
                // smaller element
                i++; 
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
      
    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(Student[] arr, int low, int high)
    {
        if (low < high) 
        {
              
            // pi is partitioning index, arr[p]
            // is now at right place 
            int pi = partition(arr, low, high);
      
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

//-----------------------------------------------------------------------------------------------------------------

//----------------------------------Radix Sort--------------------------------------------------------------------
    
 // Using counting sort to sort the elements in the basis of significant places
    //1, 10, 100, 1000...
    public static void countingSort(Student array[], int size, int place) {
      Student[] output = new Student[size + 1];
      Student max = array[0];
      for (int i = 1; i < size; i++) {
    	//array[i] > max
        if (array[i].compareTo(max)==1)
          max = array[i];
      }
      int[] count = new int[max.grade + 1];

      for (int i = 0; i < max.grade; ++i)
        count[i] = 0;

      // Calculate count of elements
      for (int i = 0; i < size; i++)
        count[(array[i].grade / place) % 10]++;

      // Calculate cumulative count
      for (int i = 1; i < max.grade+1; i++)
        count[i] += count[i - 1];

      // Place the elements in sorted order
      for (int i = size - 1; i >= 0; i--) {
        output[count[(array[i].grade / place) % 10] - 1] = array[i];
        count[(array[i].grade / place) % 10]--;
      }

      for (int i = 0; i < size; i++)
        array[i] = output[i];
    }

    // Function to get the largest element from an array
    public static Student getMax(Student array[], int n) {
      Student max = array[0];
      for (int i = 1; i < n; i++)
    	  //array[i] > max
        if (array[i].compareTo(max)==1)
          max = array[i];
      return max;
    }

    // Main function to implement radix sort
    public static void radixSort(Student array[], int size) {
      // Get maximum element
      Student max = getMax(array, size);

      // Apply counting sort to sort elements based on place value.
      for (int place = 1; max.grade / place > 0; place *= 10)
        countingSort(array, size, place);
    }
    
//------------------------------------------------------------------------------------------------------------    

//---------------------------------------------Bucket Sort-------------------------------------------------
//    public void bucketSort(float[] arr, int n) {
//        if (n <= 0)
//          return;
//        
//        ArrayList<Float>[] bucket = new ArrayList[n];
//
//        // Create empty buckets
//        for (int i = 0; i < n; i++)
//          bucket[i] = new ArrayList<Float>();
//
//        // Add elements into the buckets
//        for (int i = 0; i < n; i++) {
//          int bucketIndex = (int) arr[i].grade * n;
//          bucket[bucketIndex].add(arr[i]);
//        }
//
//        // Sort the elements of each bucket
//        for (int i = 0; i < n; i++) {
//          Collections.sort((bucket[i]));
//        }
//
//        // Get the sorted array
//        int index = 0;
//        for (int i = 0; i < n; i++) {
//          for (int j = 0, size = bucket[i].size(); j < size; j++) {
//            arr[index++] = bucket[i].get(j);
//          }
//        }
//      }
    
    	
    public static void printArray(Student arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i].grade + " ");
        System.out.println();
    }

	public static void main(String[] args) {
		  List<Student> arr = Arrays.asList(new Student[] { new Student(12, "Alestar", "Mumbai", 98), new Student(56, "Avaneesh", "Mumbai", 97), new Student(3, "Ale", "Mumbai", 88), new Student(4, "star", "Mumbai", 92), new Student(6, "Alex", "Mumbai", 75), new Student(7, "Al", "Mumbai", 68)});
		  
		  List<Student> arr1 = new ArrayList<Student>(20);
		  Collections.copy(arr1, arr);
		  
		  System.out.println(arr1.size());
		  
		  Boolean x = Boolean.FALSE;
		  
		  
//	      DataSorter.printArray(arr);
//	      DataSorter.heapSort(arr);
//	      DataSorter.printArray(arr);
		
		  //DataSorter.printArray(arr);
          //DataSorter.mergeSort(arr, 0, arr.length - 1);
          //DataSorter.printArray(arr);
		  //DataSorter.printArray(arr);
		  //DataSorter.quickSort(arr, 0, arr.length-1);
		  //DataSorter.printArray(arr);
		

		  //int x[] = new int[]{7, 5, 0, 1, 5 , 6};
//		  DataSorter.printArray(arr);
//		  DataSorter.radixSort(arr , arr.length);
//		  DataSorter.printArray(arr);
	}
}