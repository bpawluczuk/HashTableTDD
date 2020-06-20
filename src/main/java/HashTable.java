import java.util.ArrayList;

public class HashTable<K, V> {

    private int capacity = 4;
    private static final float FACTOR = 0.75F;

    private int size;
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

    public int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % this.capacity);
        return index;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void add(K key, V value) {
        int bucketIndex = this.getBucketIndex(key);
        Entry<K, V> head = bucketArray.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        this.size++;
        head = bucketArray.get(bucketIndex);

        Entry<K, V> newEntry = new Entry<K, V>(key, value);
        newEntry.next = head;
        bucketArray.set(bucketIndex, newEntry);

        if (this.size == this.threshold) {
            resize();
        }
    }

    public void resize() {
        ArrayList<Entry<K, V>> temp = this.bucketArray;
        this.bucketArray = new ArrayList<>();
        this.capacity = this.capacity * 2;

        for (int i = 0; i < this.capacity; i++) {
            this.bucketArray.add(null);
        }

        for (Entry<K, V> head : temp) {
            while (head != null) {
                this.add(head.key, head.value);
                head = head.next;
            }
        }
    }

    public V get(K key) {
        int bucketIndex = this.getBucketIndex(key);
        Entry<K, V> head = this.bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucketIndex = this.getBucketIndex(key);
        Entry<K, V> head = this.bucketArray.get(bucketIndex);

        Entry<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;

            prev = head;
            head = head.next;
        }

        if (head == null)
            return null;

        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }

    public boolean contains(K key) {
        int bucketIndex = this.getBucketIndex(key);
        return this.bucketArray.get(bucketIndex) != null;
    }

    public void printTable() {
        System.out.print("HashTable = ");
        System.out.print("[");
        bucketArray.forEach(entry -> {
            if(entry == null){
                System.out.print("null, ");
            }else {
                System.out.print("" + entry.key + "=>" + entry.value + ", ");
            }
        });
        System.out.print("]");
    }
}
