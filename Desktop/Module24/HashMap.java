import java.util.LinkedList;

public class HashMap<K, V> {
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    public HashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            return;
        }

        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket == null) {
            bucket = new LinkedList<Entry<K, V>>();
            buckets[index] = bucket;
        }

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        bucket.add(new Entry<K, V>(key, value));
        size++;

        if (size >= buckets.length * 0.75) {
            resize();
        }
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket == null) {
            return null;
        }

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % buckets.length;
        return index;
    }

    private void resize() {
        LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[buckets.length * 2];

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int index = entry.hashCode() % newBuckets.length;
                    if (newBuckets[index] == null) {
                        newBuckets[index] = new LinkedList<Entry<K, V>>();
                    }
                    newBuckets[index].add(entry);
                }
            }
        }

        buckets = newBuckets;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Entry) {
                Entry<K, V> entry = (Entry<K, V>) obj;
                return key.equals(entry.getKey());
            }
            return false;
        }
    }
}
