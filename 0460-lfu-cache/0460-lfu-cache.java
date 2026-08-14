import java.util.HashMap;

class LFUCache {
    
    class Node {
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
        
        Node(int k, int v) {
            key = k;
            val = v;
            freq = 1;
        }
    }
    
    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;
        
        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        void addNode(Node node) {
            Node temp = head.next;
            node.next = temp;
            node.prev = head;
            head.next = node;
            temp.prev = node;
            size++;
        }
        
        void removeNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
        
        Node removeTail() {
            if(size > 0) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                return tailNode;
            }
            return null;
        }
    }
    
    int cap;
    int minFreq;
    HashMap<Integer, Node> keyNodeMap;
    HashMap<Integer, DoublyLinkedList> freqListMap;
    
    public LFUCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqListMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(cap == 0 || !keyNodeMap.containsKey(key)) {
            return -1;
        }
        
        Node node = keyNodeMap.get(key);
        updateNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cap == 0) return;
        
        if(keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            node.val = value;
            updateNode(node);
        } else {
            if(keyNodeMap.size() == cap) {
                DoublyLinkedList minFreqList = freqListMap.get(minFreq);
                Node evictedNode = minFreqList.removeTail();
                keyNodeMap.remove(evictedNode.key);
            }
            
            Node newNode = new Node(key, value);
            keyNodeMap.put(key, newNode);
            minFreq = 1;
            
            DoublyLinkedList list = freqListMap.getOrDefault(1, new DoublyLinkedList());
            list.addNode(newNode);
            freqListMap.put(1, list);
        }
    }
    
    private void updateNode(Node node) {
        int currFreq = node.freq;
        DoublyLinkedList currList = freqListMap.get(currFreq);
        currList.removeNode(node);
        
        if(currFreq == minFreq && currList.size == 0) {
            minFreq++;
        }
        
        node.freq++;
        DoublyLinkedList newList = freqListMap.getOrDefault(node.freq, new DoublyLinkedList());
        newList.addNode(node);
        freqListMap.put(node.freq, newList);
    }
}