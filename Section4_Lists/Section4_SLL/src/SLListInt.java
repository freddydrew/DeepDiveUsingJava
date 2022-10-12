public class SLListInt{

    private node sentinel;
    private int size;

    private class node{
        private int item;
        private node next;

        private node(int item, node rest){
            this.item = item;
            this.next = rest;
        }
    }

    /*constructors*/
    public SLListInt(){
        sentinel = new node(999,null);
        size = 0;

    }
    public SLListInt(int item){
        sentinel = new node(999,null);
        sentinel.next = new node(item,null);
        size = 1;
    }

    /*add methods*/
    public void addFirst(int item){
        sentinel.next = new node(item,sentinel.next);
        size += 1;
    }

    public void addLast(int item){
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

    public void insert(int item,int idx){
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

    public void insertSorted(int item){
        if(this.size == 0){
            this.addFirst(item);
        } else {
            node tmp = this.sentinel;
            while(tmp.next != null){
                if (tmp.next.item <= item){
                    tmp = tmp.next;
                } else if (tmp.next.item > item){
                    tmp.next = new node(item,tmp.next);
                    this.size += 1;
                    return;
                }
            }
            tmp.next = new node(item,null);
            this.size += 1;
        }
    }

    /*deletion methods*/
    public int removeFirst(){
        int item = this.sentinel.next.item;
        this.sentinel.next = sentinel.next.next;
        this.size -= 1;
        return item;
    }

    public int removeLast(){
        int count = this.size;
        node tmp = this.sentinel.next;
        while(count != 1){
            tmp = tmp.next;
            count--;
        }
        int item = tmp.next.item;
        tmp.next = null;
        this.size -= 1;
        return item;
    }

    public int remove(int idx){
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
            int item = tmp.next.item;
            tmp.next = tmp.next.next;
            this.size -= 1;
            return item;
        }
    }

    /*get method*/
    public int get(int idx){
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
    public void set(int item, int idx){
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
//        /*empty list test*/
//        SLListInt L = new SLListInt();
//        int i = 0;
//        while (i < 5){
//            L.addLast(i);
//            i++;
//        }
//        L.print();
//        L.insert(999,3);
//        L.print();
//        L.remove(3);
//        L.print();
//        L.set(999,3);
//        L.print();
//        L.set(420,0);
//        L.print();
//        System.out.println(L.get(0));
//        System.out.println(L.get(L.getSize()-1));

        SLListInt Lsort = new SLListInt();
        Lsort.insertSorted(10);
        Lsort.insertSorted(66);
        Lsort.insertSorted(3);
        Lsort.insertSorted(3);
        Lsort.insertSorted(100);
        Lsort.print();



    }
}
