import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void testCreateEmptyHashTable() {
        HashTable<String, String> hashTable = new HashTable<>();
        assertEquals(hashTable.isEmpty(), true);
    }

    @Test
    public void testGetBucketIndex(){
        HashTable<String, String> hashTable = new HashTable<>();
        // Default HashTable size is 10
        int numBuckets = 10;
        String key = "exampleKey";
        int hashCode = key.hashCode();
        int bucketIndex = (int) hashCode % numBuckets;
        assertEquals(hashTable.getBucketIndex("exampleKey"), bucketIndex);
    }

    @Test
    public void testIncreaseSizeWhenAddElementToHashTable(){
        HashTable<String, String> hashTable = new HashTable<>();
        // Init size = 0
        hashTable.add();
        assertEquals(hashTable.getSize(), 1);
    }

}

