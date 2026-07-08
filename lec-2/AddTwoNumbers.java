import java.util.*;

class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class AddTwoNumbers {

    public static Node add(Node head, Node head1) {

        Node d = new Node(0), t = d;
        int c = 0;

        while (head != null || head1 != null || c > 0) {

            int s = c;

            if (head != null) {
                s += head.data;
                head = head.next;
            }

            if (head1 != null) {
                s += head1.data;
                head1 = head1.next;
            }

            t.next = new Node(s % 10);
            t = t.next;

            c = s / 10;
        }

        return d.next;
    }

    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();

        Node d1 = new Node(0);
        Node t1 = d1;

        for (int i = 0; i < n1; i++) {
            t1.next = new Node(sc.nextInt());
            t1 = t1.next;
        }

        int n2 = sc.nextInt();

        Node d2 = new Node(0);
        Node t2 = d2;

        for (int i = 0; i < n2; i++) {
            t2.next = new Node(sc.nextInt());
            t2 = t2.next;
        }

        Node ans = add(d1.next, d2.next);

        printList(ans);

        sc.close();
    }
}