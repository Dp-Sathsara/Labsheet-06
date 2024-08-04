public class LinkedList {

    private class Node {
        String studentNumber;
        String name;
        String gender;
        String grade;
        Node next;
        public Node(String studentNumber, String name, String gender, String grade) {
            this.studentNumber = studentNumber;
            this.name = name;
            this.gender = gender;
            this.grade = grade;
            this.next = null;
        } 
    }
    private Node head;
    private int size;

    public LinkedList(){
        this.head=null;
        this.size=0;
    }
    public boolean isempty(){
        return head==null;
    }
    public void insertLast(String studentNumber,String name,String gender,String grade){
        Node newNode=new Node(studentNumber, name, gender, grade);
        if (isempty()) {
            head=newNode;
        }else{
            Node current =head;
            while (current.next!=null) {
                current=current.next;
            }
            current.next=newNode;
        }
        size++;
    }
    public int size(){
        return size;
    }
    public void traverseList(){
        if(isempty()){
            System.out.println("List is empty");
        }else{
            Node current =head;
            System.out.println("Student Number\tName\tGender\tGrade");
            while (current!=null) {
                System.out.println(current.studentNumber+"\t"+current.name+"\t"+current.gender+"\t"+current.grade);
                current=current.next;
            }
        }
    }
    public void sortByGrade() {
        if (size > 1) {
            boolean wasChanged;
            do {
                Node current = head;
                Node previous = null;
                Node next = head.next;
                wasChanged = false;

                while (next != null) {
                    if (current.grade.compareTo(next.grade) > 0) {
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.next;
                            previous.next = next;
                            next.next = current;
                            current.next = sig;
                        } else {
                            Node sig = next.next;
                            head = next;
                            next.next = current;
                            current.next = sig;
                        }

                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (wasChanged);
        }
    }
    public void searchByGrade(String grade) {
        if (isempty()) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            System.out.println("Students with grade " + grade + ":");
            boolean found = false;
            while (current != null) {
                if (current.grade.equalsIgnoreCase(grade)) {
                    System.out.println(current.studentNumber + "\t" + current.name + "\t" + current.gender + "\t" + current.grade);
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("No students found with grade " + grade);
            }
        }
    }
    public void bubbleSortByGrade() {
        if (size > 1) {
            boolean wasChanged;
            do {
                Node current = head;
                Node previous = null;
                Node next = head.next;
                wasChanged = false;

                while (next != null) {
                    if (current.grade.compareTo(next.grade) > 0) {
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.next;
                            previous.next = next;
                            next.next = current;
                            current.next = sig;
                        } else {
                            Node sig = next.next;
                            head = next;
                            next.next = current;
                            current.next = sig;
                        }

                        previous = next;
                        next = current.next;
                    } else {
                        previous = current;
                        current = next;
                        next = next.next;
                    }
                }
            } while (wasChanged);
        }
    }
    public void selectionSortByGrade() {
        for (Node i = head; i != null && i.next != null; i = i.next) {
            Node min = i;
            for (Node j = i.next; j != null; j = j.next) {
                if (j.grade.compareTo(min.grade) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                String tempGrade = i.grade;
                String tempStudentNumber = i.studentNumber;
                String tempName = i.name;
                String tempGender = i.gender;

                i.grade = min.grade;
                i.studentNumber = min.studentNumber;
                i.name = min.name;
                i.gender = min.gender;

                min.grade = tempGrade;
                min.studentNumber = tempStudentNumber;
                min.name = tempName;
                min.gender = tempGender;
            }
        }
    }
    public void insertionSortByGrade() {
        if (head == null || head.next == null) {
            return;
        }

        Node sorted = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || sorted.grade.compareTo(current.grade) >= 0) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.grade.compareTo(current.grade) < 0) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }

            current = next;
        }

        head = sorted;
    }
    
    public static void main(String[] args) {
        LinkedList sList=new LinkedList();

        sList.insertLast("PS/2014/034", "Supun", "M", "A");
        sList.insertLast("PS/2014/345", "Nuwan", "M", "B");
        sList.insertLast("PS/2014/098", "Dasuni", "F", "B");
        sList.insertLast("PS/2014/019", "Kasun", "M", "A");
        sList.insertLast("PS/2014/109", "Nipuni", "F", "D");
        sList.insertLast("PS/2014/237", "Binura", "M", "A");
        sList.insertLast("PS/2014/200", "Ruwani", "F", "C");
        sList.insertLast("PS/2014/056", "Hasini", "F", "C");
        sList.insertLast("PS/2014/296", "Kusal", "M", "B");
        sList.insertLast("PS/2014/127", "Pawan", "M", "A");

        System.out.println("(01) i)---Answer");
        System.out.println("");
        sList.traverseList();
        System.out.println("");
        System.out.println("");

        System.out.println("(01) ii)---Answer");
        System.out.println("");
        sList.sortByGrade();
        sList.traverseList();


        System.out.println("(01) iii)---Bubble Sort");
        System.out.println("");
        sList.bubbleSortByGrade();
        sList.traverseList();
        System.out.println("");
        System.out.println("");

        System.out.println("(01) iii)---Selection Sort");
        System.out.println("");
        sList.selectionSortByGrade();
        sList.traverseList();
        System.out.println("");
        System.out.println("");

        System.out.println("(01) iii)---Insertion Sort");
        System.out.println("");
        sList.insertionSortByGrade();
        sList.traverseList();




    }
}

