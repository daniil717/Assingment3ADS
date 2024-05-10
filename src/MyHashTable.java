import java.util.Objects;
public class MyHashTable<K, V> {
    private class HashNode<v, k>{
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashNode[M];
    }

    public MyHashTable(int m){
        this.M = m;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        int positiveHashCode = hashCode & Integer.MAX_VALUE;
        return positiveHashCode % M;
    }

    public void put(K key, V value){
        int index = hash(key);
        HashNode newNode = new HashNode(key, value);
        if(chainArray[index] == null){
            chainArray[index] = newNode;
        }
        else{
            HashNode currentNode = chainArray[index];
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    public V get(K key){

    }

    public V remove(K key){

    }

    public boolean contains(V value){

    }

    public K getKey(V value){

    }
}
