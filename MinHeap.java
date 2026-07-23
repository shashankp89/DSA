/*Implement Min Heap
Subscribe to TUF+

Hints
Company
You need to implement the Min Heap with the following given methods.

insert (x) -> insert value x to the min heap
getMin -> Output the minimum value from min heap
exctractMin -> Remove the minimum element from the heap
heapSize -> return the current size of the heap
isEmpty -> returns if heap is empty or not
changeKey (ind, val) -> update the value at given index to val (index will be given 0-based indexing)
initializeHeap -> Initialize the heap

Example 1

Input : operation = [ "initializeheap", "insert", "insert", "insert", "getMin", "heapSize", "isEmpty", "extractMin", "changeKey" , "getMin" ]

nums = [ [4], [1], [10], [0, 16] ]

Output : [ null, null, null, null, 1, 3, 0, null, null, 10 ]

Explanation : In 1st operation we initialize the heap to empty heap.

In 2nd, 3rd, 4th operation we insert 4, 1, 10 to the heap respectively. The heap after 4th operation will be -> [1, 4, 10].

In 5th operation we output the minimum element from the heap i.e. 1.

In 6th operation we output the size of the current heap i.e. 3.

In 7th operation we output whether the heap is empty or not i.e. false (0).

In 8th operation we remove the minimum element from heap. So the ne heap becomes -> [4, 10].

In 9th operation we change the 0th index element to 16. So new heap becomes -> [16, 10]. After heapify -> [10, 16].

In 10th operation we output the minimum element of the heap i.e. 10.

Example 2

Input : operation = [ "initializeheap", "insert", "insert", "extractMin", "getMin", "insert", "heapSize", "isEmpty", "extractMin", "changeKey" , "getMin" ]

nums = [ [4], [1], [1], [0, 2] ]

Output : [ null, null, null, null, 4, null, 2, 0, null, null, 2 ]

Explanation : In 1st operation we initialize the heap to empty heap.

In 2nd, 3rd operation we insert 4, 1 to the heap respectively. The heap after 4th operation will be -> [1, 4].

In 4th operation we remove the minimum element from heap. So the ne heap becomes -> [4].

In 5th operation we output the minimum element of the heap i.e. 4.

In 6th operation we operation we insert 1 to the heap. The heap after 6th operation will be -> [1, 4].

In 7th operation we output the size of the current heap i.e. 2.

In 8th operation we output whether the heap is empty or not i.e. false (0).

In 9th operation we remove the minimum element from heap. So the ne heap becomes -> [4].

In 10th operation we change the 0th index element to 2. So new heap becomes -> [2].

In 11th operation we output the minimum element of the heap i.e. 2.

Constraints

1 <= n <= 105
-105 <= nums[i] <= 105 */


import java.util.Arrays;

class Solution {
    private int[] heap;
    private int size;
    private int capacity;

    public void initializeHeap() {
        capacity = 100005; // Initialize with a reasonably large capacity
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int key) {
        // Dynamically resize if the heap gets full
        if (size == capacity) {
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }
        
        size++;
        int i = size - 1;
        heap[i] = key;
        
        // Heapify Up: Fix the min heap property if it's violated
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void changeKey(int index, int newVal) {
        if (index < 0 || index >= size) return;
        
        int oldVal = heap[index];
        heap[index] = newVal;
        
        // If the new value is smaller, it might need to bubble up
        if (newVal < oldVal) {
            int i = index;
            while (i != 0 && heap[parent(i)] > heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
        } 
        // If the new value is larger, it might need to bubble down
        else {
            heapify(index);
        }
    }

    public void extractMin() {
        if (size <= 0) return;
        
        if (size == 1) {
            size--;
            return;
        }
        
        // Move the last element to the root and reduce size
        heap[0] = heap[size - 1];
        size--;
        
        // Heapify Down: Restore the min heap property from the root
        heapify(0);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMin() {
        if (size <= 0) return -1; // Assuming -1 for empty heap, or throw an exception
        return heap[0];
    }

    public int heapSize() {
        return size;
    }
    
    // --- Helper Methods ---
    
    private int parent(int i) { 
        return (i - 1) / 2; 
    }
    
    private int left(int i) { 
        return (2 * i + 1); 
    }
    
    private int right(int i) { 
        return (2 * i + 2); 
    }

    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        
        if (l < size && heap[l] < heap[smallest]) {
            smallest = l;
        }
        if (r < size && heap[r] < heap[smallest]) {
            smallest = r;
        }
        
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}