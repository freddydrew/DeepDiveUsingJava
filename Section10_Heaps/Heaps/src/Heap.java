public class Heap {

    private int[] heap;
    private int size;

    public Heap(int capacity){
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value){
        if (isFull()){
            throw new IndexOutOfBoundsException(); //could resize
        }
        heap[size] = value;
        fixHeapAbove(size);
        size++;
    }

    public int delete(int idx){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        int parent = getParent(idx);
        int deletedValue = heap[idx];

        heap[idx] = heap[size-1];

        if (idx == 0 || heap[idx] < heap[parent]){
            fixHeapBelow(idx,size -1);
        } else {
            fixHeapAbove(idx);
        }
        size--;
        return deletedValue;
    }

    private void fixHeapAbove(int idx){
        int newValue = heap[idx];

        /*while we haven't hit the root, shift everything down until we have the space for the new value.
        * This happens when we drop out of the loop.*/
        while(idx > 0 && newValue > heap[getParent(idx)]){
            heap[idx] = heap[getParent(idx)];
            idx = getParent(idx);
        }
        heap[idx] = newValue;
    }

    private void fixHeapBelow(int idx, int lastHeapIdx){
        int childToSwap;

        while(idx <= lastHeapIdx){
            int leftChild = getChild(idx,true);
            int rightChild = getChild(idx, false);
            if (leftChild <= lastHeapIdx){ //if yes, it has a left child
                if (rightChild > lastHeapIdx){ //if yes, no right child
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if (heap[idx] < heap[childToSwap]){
                    int tmp = heap[idx];
                    heap[idx] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }
                idx = childToSwap;
            } else {
                break;
            }
        }
    }

    public void sort(){
        int lastHeapIdx = size - 1;
        for (int i = 0; i < lastHeapIdx; i++){
            int tmp = heap[0];
            heap[0] = heap[lastHeapIdx - i];
            heap[lastHeapIdx - i] = tmp;

            fixHeapBelow(0, lastHeapIdx - i - 1);
        }
    }

    public int peek(){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        return heap[0];
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int getParent(int idx){
        return (idx - 1)/2; //don't need floor because int division rounds down automatically
    }

    public int getChild(int idx, boolean left){
        return 2*idx + (left ? 1 : 2);
    }

    public void printHeap(){
        for (int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
