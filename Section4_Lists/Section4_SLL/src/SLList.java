public class SLList <T>{

    private node sentinel;
    private int size;

    private class node{
        private T item;
        private node next;

        private node(T item, node rest){
            this.item = item;
            this.next = rest;
        }
    }

    /*constructors*/
    public SLList(){
        sentinel = new node(null,null);
        size = 0;

    }
    public SLList(T item){
        sentinel = new node(null,null);
        sentinel.next = new node(item,null);
        size = 1;
    }

    /*add methods*/
    public void addFirst(T item){
        sentinel.next = new node(item,sentinel.next);
        size += 1;
    }

    public void addLast(T item){
        if (this.size == 0){
            this.addFirst(item);
            return;
        }
        node tmp = sentinel.next;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new node(item,null);
        size += 1;
    }

    public void insert(T item,int idx){
        if (idx == 1){
            this.addFirst(item);
        } else if (idx >= this.size) {
            this.addLast(item);
        } else {
            node tmp = this.sentinel.next;
            while (idx != 1) {
                tmp = tmp.next;
                idx--;
            }
            tmp.next = new node(item, tmp.next);
            size += 1;
        }
    }

    /*deletion methods*/
    public T removeFirst(){
        T item = this.sentinel.next.item;
        this.sentinel.next = sentinel.next.next;
        this.size -= 1;
        return item;
    }

    public T removeLast(){
        int count = this.size;
        node tmp = this.sentinel.next;
        while(count != 1){
            tmp = tmp.next;
            count--;
        }
        T item = tmp.next.item;
        tmp.next = null;
        this.size -= 1;
        return item;
    }

    public T remove(int idx){
        if (idx == 0){
            return this.removeFirst();
        } else if (idx >= this.size) {
            return this.removeLast();
        } else {
            node tmp = this.sentinel.next;
            while (idx != 1){
                tmp = tmp.next;
                idx--;
            }
            T item = tmp.next.item;
            tmp.next = tmp.next.next;
            this.size -= 1;
            return item;
        }
    }

    /*get method*/
    public T get(int idx){
        if (idx == 0){
            return this.sentinel.next.item;
        }
        node tmp = this.sentinel.next;
        while(idx != 1){
            tmp = tmp.next;
            idx--;
        }
        return tmp.next.item;
    }

    public int getSize(){
        return this.size;
    }

    /*set methods*/
    public void set(T item, int idx){
        if (idx == 0){
            this.sentinel.next.item = item;
            return;
        }
        node tmp = this.sentinel.next;
        while(idx != 1){
            tmp = tmp.next;
            idx--;
        }
        tmp.next.item = item;
    }

    /*print methods*/
    public void print(){
        node tmp = this.sentinel.next;
        while (tmp != null){
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String args[]){
        /*empty list test*/
        SLList<Integer> L = new SLList<>();
        int i = 0;
        while (i < 5){
            L.addLast(i);
            i++;
        }
        L.print();
        L.insert(999,3);
        L.print();
        L.remove(3);
        L.print();
        L.set(999,3);
        L.print();
        L.set(420,0);
        L.print();
        System.out.println(L.get(0));
        System.out.println(L.get(L.getSize()-1));




    }
}
