package leetcode;

public class AddTowNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long n1=0, n2=0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode result = new ListNode(0);
        ListNode rp = result;
        int step = 0;
        while(p1 != null || p2 != null){
            int sum = 0;
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            sum += step;

            if(sum >= 10){
                rp.next = new ListNode(sum%10);
                step = 1;
            }else{
                rp.next = new ListNode(sum);
                step = 0;
            }
            rp = rp.next;
        }
        if(step > 0){
            rp.next = new ListNode(1);
        }


        return  result.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        long i = 0;
        ListNode p2 = l2;
        while(i < 9){
            p2.next = new ListNode(9);
            p2 = p2.next;
            i++;
        }
//        l2.next.next = new ListNode(6);
//        l2.next.next = new ListNode(1);


        AddTowNums add = new AddTowNums();
        add.addTwoNumbers(l1, l2);

    }
}


