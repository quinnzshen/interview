public class RetainBestCache<K, T extends Rankable> {
    DataSource dataSource;
    ConcurrentHashMap<K, T> cache;
    TreeMap<Long, Set<K>> rankMap;
    int maxEntriesToRetain;
 
    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache(DataSource<K,T> ds, int entriesToRetain) {
        dataSource = ds;
        cache = new ConcurrentHashMap<>();
        treeMap = new TreeMap<>();
        maxEntriesToRetain = entriesToRetain;
    }
 
    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
     * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public T get(K key) {
        if (cache.hasKey(key)) {
            return cache.get(key);
        } else {
            T value = dataSource.get(key);

            put(key, value);
            return value;
        }
    }

    public synchronized void put(K key, T value) {
        if (cache.size() >= maxEntriesToRetain) {
            Map.Entry<Long, Set<K>> lowestRankEntry = rankMap.firstEntry();
            Set<K> lowestRankSet = lowestRankEntry.getValue();
            K keyToDelete = lowestRankSet.iterator().next();

            if (lowestRankSet.size() > 1) {
                lowestRankSet.remove(keyToDelete);
            } else {
                rankMap.remove(lowestRankEntry.getKey()); 
            }
        }

        cache.put(key, value);

        Set<K> rankSet = rankMap.getOrDefault(key, new HashSet<>());
        rankSet.add(key);
        rankMap.put(key.getRank(), rankSet);
    }
}
 
/*
 * For reference, here are the Rankable and DataSource interfaces.
 * You do not need to implement them, and should not make assumptions
 * about their implementations.
 */
 
public interface Rankable {
    /**
     * Returns the Rank of this object, using some algorithm and potentially
     * the internal state of the Rankable.
     */
    long getRank();
}
 
public interface DataSource<K, T extends Rankable> {
    T get (K key);
}