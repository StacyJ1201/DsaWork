package Hash;

public class Implementation {
    public static void main(String[] args) {
        Hash hash = new Hash(5);

        hash.put(1, 100);
        hash.put(2, 200);
        hash.put(3, 300);
        hash.put(4, 100);
        hash.put(5, 200);
        hash.put(6, 300);

//        System.out.println(hash.get(1));

        hash.print();

    }
    static class Hash{
        class Node{
            int key;
            int value;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        Node[] buckets;
        int size;

        public Hash( int size) {
            this.buckets = new Node[size];
            this.size = size;
        }

        private int getHash(int key){
            return key % size;
        }

        public void put(int key, int value){
            int index = getHash(key);
            Node newNode = new Node(key, value);

            if(buckets[index] == null){
                buckets[index] = newNode;
            } else {
               Node current = buckets[index];
               while(current != null){
                   if(current.key == key){
                       current.value = value;
                       return;
                   }
                   if(current.next == null) {
                       break;
                   }
                   current = current.next;
               }
                current.next = newNode;
            }
        }

        public int get(int key){
            int index = getHash(key);
            Node current = buckets[index];
            while(current != null){
                if(current.key == key){
                    return current.value;
                }
                current = current.next;
            }
            return -1;
        }

        public void delete(int key){
            int index = getHash(key);
            Node current = buckets[index];
            Node previous = null;

            while(current != null){
                if(current.key == key){
                    if(previous == null){
                        buckets[index] = current.next;
                    } else{
                        previous.next = current.next;
                    }
                    return;
                }
                previous = current;
                current = current.next;
            }
        }

        public void print(){
            for (int i = 0; i < size; i++) {
                System.out.print("Bucket " + i + ": ");
                Node current = buckets[i];
                while(current != null){
                    if(current.next != null) {
                        System.out.print("[ " + current.key + ", " + current.value + " ]" + " --> ");
                        current = current.next;
                    }
                    else{
                        System.out.print("[ " + current.key + ", " + current.value + " ]");
                        current = current.next;
                    }
                }
                System.out.println();
            }
        }

    }
}
