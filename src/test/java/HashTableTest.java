import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    @Test
    public void testCreateEmptyHashTable() {
        HashTable<String, String> hashTable = new HashTable<>();
        assertEquals(hashTable.isEmpty(), true);
    }
}
