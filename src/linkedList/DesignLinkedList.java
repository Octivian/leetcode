package linkedList;

public class DesignLinkedList {
    class MyLinkedList {
        class Node {
            int val;
            Node next;

            Node(int val, Node next) {
                this.val = val;
                this.next = next;
            }
        }

        Node head;

        Node tail;
        int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            head = null;
            tail = head;
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {

            if (index >= size || index < 0) {
                return -1;
            }

            Node tmp = head;
            int i = 0;
            while (i < index) {
                tmp = tmp.next;
                i++;
            }

            return tmp.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will
         * be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (size == 0) {
                initInsertNode(val);
            } else {
                Node newNode = new Node(val, head);
                head = newNode;
            }
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            if (size == 0) {
                initInsertNode(val);
            } else {
                Node newNode = new Node(val, null);
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        private void initInsertNode(int val) {
            Node newNode = new Node(val, null);
            head = newNode;
            tail = newNode;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked
         * list, the node will be appended to the end of linked list. If index is greater than the length, the node will
         * not be inserted.
         */
        public void addAtIndex(int index, int val) {

            if (index == size) {
                addAtTail(val);
            } else if (index <= 0) {
                addAtHead(val);
            } else if (index < size) {
                Node tmp = head;
                int i = 0;
                while (i < index - 1) {
                    tmp = tmp.next;
                    i++;
                }
                Node next = tmp.next;
                tmp.next = new Node(val, next);
                size++;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {

            if (index >= size || index < 0) {
                return;
            }

            if (index == 0) {
                head = head.next;
            } else {
                Node tmp = head;
                int i = 0;
                while (i < index - 1) {
                    tmp = tmp.next;
                    i++;
                }
                Node pre = tmp;
                pre.next = tmp.next.next;
                tail = index == size - 1 ? pre : tail;
            }
            size--;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such: MyLinkedList obj = new MyLinkedList(); int
     * param_1 = obj.get(index); obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
