public class DLList <T>{

    private node sentinel;
    private int size;

    private class node{
        private T item;
        private node prev;
        private node next;

        public node(T item, node prev, node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /*constructors*/
    public DLList(){
        this.sentinel = new node(null,null,null);
        size = 0;
    }

    public DLList(T item){
        this.sentinel = new node(null,null,null);
        this.sentinel.next = new node(item,sentinel,sentinel);
        this.sentinel.prev = sentinel.next;
        size = 1;
    }

    /*getters*/
    public int getSize(){
        return this.size;
    }

    public T getFirst(){
        if (this.size == 0){
            return null;
        }
        return this.sentinel.next.item;
    }

    public T getLast(){
        if (this.size == 0){
            return null;
        }
        return this.sentinel.prev.item;
    }

    public T get(int idx){
        if (idx == 0){
            return this.getFirst();
        } else if (idx == this.size - 1) {
            return this.getLast();
        } else {
            if (this.size == 0){return null;}
            node tmp = this.sentinel.next;
            while (idx != 1){
                tmp = tmp.next;
                idx--;
            }
            return tmp.next.item;
        }
    }

    /*setters*/
    public void setFirst(T item){
        if (this.size == 0){return;}
        this.sentinel.next.item = item;
    }

    public void setLast(T item){
        if (this.size == 0){return;}
        this.sentinel.prev.item = item;
    }

    public void set(T item, int idx){
        if (this.size == 0){
            this.addFirst(item);
        } else {
            node tmp = this.sentinel.next;
            while(idx != 1){
                tmp = tmp.next;
                idx--;
            }
            tmp.next.item = item;
        }
    }

    /*insertion methods*/
    public void addFirst(T item){
        if (this.size == 0){
            this.sentinel.next = new node(item,this.sentinel,this.sentinel);
            this.sentinel.prev = this.sentinel.next;
            size += 1;
            return;
        }
        node oldFirst = this.sentinel.next;
        this.sentinel.next = new node(item,sentinel,sentinel.next);
        oldFirst.prev = this.sentinel.next;
        size += 1;
    }

    public void addLast(T item){
        if (this.size == 0){
            this.sentinel.next = new node(item,this.sentinel,this.sentinel);
            this.sentinel.prev = this.sentinel.next;
            size += 1;
            return;
        }
        node oldLast = this.sentinel.prev;
        this.sentinel.prev = new node(item,oldLast,this.sentinel);
        oldLast.next = this.sentinel.prev;
        size += 1;
    }

    public void insert(T item, int idx){
        if (this.size == 0){
            this.sentinel.next = new node(item,this.sentinel,this.sentinel);
            this.sentinel.prev = this.sentinel.next;
            size += 1;
            return;
        }
        node tmp = sentinel.next;
        while(idx != 1){
            tmp = tmp.next;
            idx--;
        }
        node nodeToPushDown = tmp.next;
        tmp.next = new node(item,tmp,nodeToPushDown);
        nodeToPushDown.prev = tmp.next;
        size += 1;
    }

    /*deletion methods*/
    public T removeFirst(){
        if (this.size == 0){return null;}
        T item = this.sentinel.next.item;
        node newFirst = this.sentinel.next.next;
        newFirst.prev = this.sentinel;
        this.sentinel.next = newFirst;
        size -= 1;
        return item;
    }

    public T removeLast(){
        if (this.size == 0){return null;}
        T item = this.sentinel.prev.item;
        node newLast = this.sentinel.prev.prev;
        newLast.next = this.sentinel;
        this.sentinel.prev = newLast;
        size -= 1;
        return item;
    }

    public T remove(int idx){
        if (idx == 0){
            return this.removeFirst();
        } else if (idx == this.size-1) {
            return this.removeLast();
        } else {
            if (this.size == 0){return null;}
            node tmp = this.sentinel.next;
            while(idx != 1){
                tmp = tmp.next;
                idx--;
            }
            T item = tmp.next.item;
            node newNodeAtIdx = tmp.next.next;
            newNodeAtIdx.prev = tmp;
            tmp.next = newNodeAtIdx;
            size -= 1;
            return item;
        }
    }

    public void printList(){
        if (this.size == 0){return;}
        node tmp = this.sentinel.next;
        while(tmp != this.sentinel){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void reverse(){
        node tmp = this.sentinel.next;
        node newPrev = null;
        node next = null;
        int count = 0;
        while (count <= size){
            next = tmp.next;
            tmp.next = tmp.prev;
            tmp.prev = next;
            tmp = tmp.next;
            count ++;
        }
    }

    public static void main(String args[]){
        DLList<Integer> L = new DLList<>();
        L.printList();

        DLList<Integer> D = new DLList<>();
        int i = 0;
        while(i<5){
            D.addLast(i);
            i++;
        }
        D.addFirst(99);
        D.insert(99,3);
        System.out.println(D.removeFirst());
        D.removeLast();
        D.printList();
        System.out.println(D.remove(2));
        D.printList();
        D.set(500,3);
        D.printList();
        DLList<String> Name = new DLList<>("F");
        Name.addLast("R");
        Name.addLast("E");
        Name.addLast("D");
        Name.reverse();
        Name.printList();


    }


}
