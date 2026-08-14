import java.util.HashMap;

class LRUCache {
    
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int cap;
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    private void addNode(Node node){
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
    }
    
    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int ans = resNode.val;
            
            map.remove(key);
            deleteNode(resNode);
            addNode(resNode);
            map.put(key, head.next);
            
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node existingNode = map.get(key);
            map.remove(key);
            deleteNode(existingNode);
        }
        
        if(map.size() == cap){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        
        addNode(new Node(key, value));
        map.put(key, head.next);
    }
}