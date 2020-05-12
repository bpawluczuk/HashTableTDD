public class HashTable<K, V> {
    private int size;
    private int numBuckets;
    public HashTable() {
        size = 0;
        numBuckets = 10;
    }
    public boolean isEmpty() {
        return getSize() == 0;
    }
    public int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return (int) hashCode % numBuckets;
    }
    public int getSize() {
        return size;
    }
    public void add() {
        size = size + 1;
    }
}







