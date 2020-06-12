import java.util.ArrayList;

public class HashTable<K, V> {

    private int size;
    private int capacity = 10;
    private static final float FACTOR = 0.75F;
    private int threshold;

    private ArrayList<Entry<K, V>> bucketArray;

    public HashTable() {
        this.bucketArray = new ArrayList<>();
        this.size = 0;
        this.threshold = (int) (this.capacity * FACTOR);
        for (int i = 0; i < this.capacity; i++) {
            bucketArray.add(null);
        }
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return (int) hashCode % capacity;
    }

    public int getSize() {
        return size;
    }

    public void add() {
        size = size + 1;
    }
}







