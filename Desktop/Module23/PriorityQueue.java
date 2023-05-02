import java.util.ArrayList;
import java.util.NoSuchElementException;
//this is how a priorty queue is implemented from scratch

public class PriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> data;//<T> is generic type which given by java

    public PriorityQueue() {
        data = new ArrayList<T>();//implemented in arrays internally
    }

    public void add(T item) {//heaps
        data.add(item);
        int childIndex = data.size() - 1;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0 && data.get(childIndex).compareTo(data.get(parentIndex)) > 0) {
            T temp = data.get(childIndex);
            data.set(childIndex, data.get(parentIndex));
            data.set(parentIndex, temp);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public T remove() {
        if (data.isEmpty()) {
            throw new NoSuchElementException();
        }
        T maxItem = data.get(0);
        T lastItem = data.remove(data.size() - 1);
        if (!data.isEmpty()) {
            data.set(0, lastItem);
            int parentIndex = 0;
            while (true) {
                int leftChildIndex = 2 * parentIndex + 1;
                int rightChildIndex = 2 * parentIndex + 2;
                if (leftChildIndex >= data.size()) {
                    break;
                }
                int maxChildIndex = leftChildIndex;
                if (rightChildIndex < data.size() && data.get(rightChildIndex).compareTo(data.get(leftChildIndex)) > 0) {
                    maxChildIndex = rightChildIndex;
                }
                if (data.get(parentIndex).compareTo(data.get(maxChildIndex)) < 0) {
                    T temp = data.get(parentIndex);
                    data.set(parentIndex, data.get(maxChildIndex));
                    data.set(maxChildIndex, temp);
                    parentIndex = maxChildIndex;
                } else {
                    break;
                }
            }
        }
        return maxItem;
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
