import java.util.Objects;

import static java.lang.Math.abs;

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
        int positiveHashCode = abs(hashCode);
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
        int index = hash(key);
        HashNode currentNode = chainArray[index];
        while (currentNode != null){
            if(Objects.equals(currentNode.key, key)){
                return (V) currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public V remove(K key){
        int index = hash(key);
        HashNode currentNode = chainArray[index];
        HashNode prevNode = null;
        while (currentNode != null){
            if (Objects.equals(currentNode.key, key)){
                if (prevNode == null){
                    chainArray[index] = currentNode.next;
                }else{
                    prevNode.next = currentNode.next;
                }
                size--;
                return (V) currentNode.value;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            HashNode currentNode = chainArray[i];
            while (currentNode != null) {
                if (Objects.equals(currentNode.value, value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            HashNode currentNode = chainArray[i];
            while (currentNode != null) {
                if (Objects.equals(currentNode.value, value)) {
                    return (K) currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        return null;
    }
    public HashNode<K, V>[] getChainArray() {
        return chainArray;
    }

    public int getM() {
        return M;
    }
}
