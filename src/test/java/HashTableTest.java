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
        // Default HashTable size is 4
        int capacity = 4;
        String key = "exampleKey";
        int hashCode = key.hashCode();
        int bucketIndex = Math.abs(hashCode % capacity);
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
        hashTable.add("key", "value");
        assertEquals(hashTable.size(), 1);
    }

    @Test
    public void testDecreaseSizeWhenRemoveElementFromHashTable() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.add("key", "value");
        assertEquals(hashTable.size(), 1);
        hashTable.remove("key");
        assertEquals(hashTable.size(), 0);
    }

    @Test
    public void testChangeSizeWhenAddAndRemoveElement() {
        HashTable<String, String> hashTable = new HashTable<>();
        assertEquals(hashTable.size(), 0);
        hashTable.add("key", "value");
        assertEquals(hashTable.size(), 1);
        hashTable.remove("key");
        assertEquals(hashTable.size(), 0);
    }

    @Test
    void testFetchedElementShouldHasTheSameValueWhenItWasAdded() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.add("key", "value");
        assertEquals(hashTable.get("key"), "value");
    }

    @Test
    void testCheckIfHashTableContainsKey() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.add("key", "value");
        assertTrue(hashTable.contains("key"));
    }
}

