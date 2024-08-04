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
        sList.traverseList();
    }
}

