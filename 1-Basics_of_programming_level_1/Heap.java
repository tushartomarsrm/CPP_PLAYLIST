/*
Heap : heapsort and graph algorithms like Dijkstra's algorithm.
Heaps can be implemented using arrays or linked lists. The array-based implementation is more common due to its simplicity and better cache performance.
*/

/*
They are categorized as follows:
- Min heap: In a min heap, each parent node is less than or equal to its child nodes.
- Max heap: In a max heap, each parent node is greater than or equal to its child nodes.
*/

// Implementation Details:
// For 1-based indexing (indexing starts at 1): //very important
// - The parent of a node at index i is found at index i/2.
// - The left child of a node at index i is found at index 2*i.
// - The right child of a node at index i is found at index 2*i + 1.

// For 0-based indexing (indexing starts at 0):
// - The parent of a node at index i is found at index (i - 1)/2.
// - The left child of a node at index i is found at index 2*i + 1.
// - The right child of a node at index i is found at index 2*i + 2.

/*
Heapification:
The term 'heapification' refers to the process of adjusting the heap to maintain its specific property (min or max) when an element is added or removed. This process is what keeps the heap in a valid state after any changes.
in simple words element ko tree me upper ya niche lejane k process ko heapification kehte hai.
*/
public class Heap {
    private int[] arr;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        arr = new int[capacity + 1]; // +1 for 1-based indexing
        this.size = 0;
        this.capacity = capacity;
    }

    public void insert(int val) {
        // step 0 : check if heap is full
        if (size == capacity) {
            System.out.println("Heap Overflow");
            return;
        }

        // step 1 : add the element at available position
        size++;
        // starting insertion from 1st index
        int index = size;
        arr[index] = val;

        // 1-based indexing hai. isliye array ko greater than 1 tak chala rahe.
        while (index > 1) {
            int parentIndex = index / 2;
            if (arr[parentIndex] < arr[index]) {
                swap(arr, parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    public void deleteFromHeap() {
        swap(arr, 1, size);
        this.size--;
        int index = 1;
        this.recursiveHeapify(arr, size, index);
    }

    public void printHeap() {
        System.out.println("Printing Heap");
        // since our array is 1-based indexing
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void iterativeHeapify(int[] arr, int n, int index) {
        while (index < size) {
            int largestkaIndex = index;
            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;
            if (leftIndex <= size && arr[largestkaIndex] < arr[leftIndex]) {
                largestkaIndex = leftIndex;
            }
            if (rightIndex <= size && arr[largestkaIndex] < arr[rightIndex]) {
                largestkaIndex = rightIndex;
            }
            if (index == largestkaIndex) {
                break;
            } else {
                swap(arr, largestkaIndex, index);
                index = largestkaIndex;
            }
        }
    }

    public void recursiveHeapify(int[] arr, int n, int index) {
        int rightKaIdx = 2 * index;
        int leftKaIdx = 2 * index + 1;
        int largestkaIndex = index;
        if (rightKaIdx <= n && arr[rightKaIdx] > arr[largestkaIndex]) {
            largestkaIndex = rightKaIdx;
        }
        if (leftKaIdx <= n && arr[leftKaIdx] > arr[largestkaIndex]) {
            largestkaIndex = leftKaIdx;
        }
        if (largestkaIndex == index) {
            return;
        } else {
            swap(arr, largestkaIndex, index);
            recursiveHeapify(arr, n, largestkaIndex);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Heap h = new Heap(10);
        h.insert(70);
        h.insert(50);
        h.insert(40);
        h.insert(20);
        h.insert(30);
        h.insert(60);
        h.printHeap();
        System.out.println("----------------------------------");
        h.deleteFromHeap();
        System.out.println("----------------------------------");
        h.printHeap();
    }
}
