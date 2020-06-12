import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    void testCreateEntryObject() {
        Entry<String, String> entry = new Entry("key", "value");
        assertEquals(entry.key, "key");
        assertEquals(entry.value, "value");
    }

    @Test
    void testCreateEntryAndAssignNextElement() {
        Entry<String, String> entry_1 = new Entry("key", "value");
        Entry<String, String> entry_2 = new Entry("key", "value");
        entry_1.next = entry_2;
        assertEquals(entry_1.next, entry_2);
    }

    @Test
    public void testGetBucketIndex() {
        HashTable<String, String> hashTable = new HashTable<>();
        // Default HashTable size is 10
        int capacity = 10;
        String key = "exampleKey";
        int hashCode = key.hashCode();
        int bucketIndex = (int) hashCode % capacity;
        assertEquals(hashTable.getBucketIndex("exampleKey"), bucketIndex);
    }

    @Test
    public void testCreateEmptyHashTable() {
        HashTable<String, String> hashTable = new HashTable<>();
        assertEquals(hashTable.isEmpty(), true);
    }


    @Test
    public void testIncreaseSizeWhenAddElementToHashTable() {
        HashTable<String, String> hashTable = new HashTable<>();
        // Init size = 0
        hashTable.add();
        assertEquals(hashTable.getSize(), 1);
    }

}

