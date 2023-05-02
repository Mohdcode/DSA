
public class LL {

    public void Addodd(){


        Node temp=head;//temp

        while(temp!=null){
            if(temp.val%2!=0){
                tail.next=temp;
                tail=temp;
            }
            temp=temp.next;
        }
    }


    public Node getIntersectionNode(Node head1, Node head2)//to get intersection point linked linked list
    {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) {
                    return head2;//find the intersection point
                }
                temp = temp.next;//temp++
            }
            head2 = head2.next;//head2++
        }
        return null;
    }static void skipMdeleteN( Node head, int M, int N) {
        Node curr = head, t;
        int count;
        while (curr != null) {
            for (count = 1; count < M && curr != null; count++)//loop for M
                curr = curr.next;
            if (curr == null)
                return;
            t = curr.next;
            for (count = 1; count <= N && t != null; count++) {//loop for N
                Node temp = t;
                t = t.next;
            }
            curr.next = t;
            curr = t;
        }
    }




        private Node  head ;
          private Node tail;

          private int size;

          public LL() {
              this.size = 0;
          }
          public boolean cyclic(){//to find is linked list cyclic or not
              Node slow=head;
              Node fast=head;
              while (fast!=null && fast.next!=null){
                  slow=slow.next;
                  fast=fast.next.next;
                  if (slow==fast){
                      return true;
                  }
              }return false;
          }
          public void breakcyclic(){
              Node slow=head;
              Node fast=head;
              boolean cycle=false;
              while (fast!=null && fast.next!=null){
                  slow=slow.next;
                  fast=fast.next;
                  if (slow==fast) {
                      cycle=true;
                  }}
if(cycle ) {
    slow = head;
    Node prev = null;
    while (slow != fast) {
        prev = fast;
        slow = slow.next;
        fast = fast.next;

    }
    prev.next = null;//edge case if the cycle is at head then this code won't work for that
}
          }


    public Node mergesort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = Mid(head);
        Node rightHead = mid.next;
        mid.next = null;//end it with null to make it separate
        Node newLeft = mergesort(head);
        Node newRight = mergesort(rightHead);
        return merge(newLeft, newRight);
    }


    private Node merge(Node head1, Node head2) {
              Node mergeLL=new Node(-1);//new node to add linked list
              Node temp=mergeLL;//temprary Box which is going traverse
              while(head1!=null && head2!=null){
                  if(head1.val<=head2.val) {
                      temp.next = head1;
                      head1 = head1.next;//increment
                      temp = temp.next;//increment
                  }else{
                      temp.next=head2;
                      head2=head2.next;//increment
                      temp=temp.next;//increment

                  }
                  while(head1!=null){
                      temp.next=head1;
                      head1=head1.next;//increment
                      temp=temp.next;//increment
                  }    while(head2!=null){
                      temp.next=head2;
                      head2=head2.next;//increment
                      temp=temp.next;//increment
                  }
              }return mergeLL.next;
    }

    public boolean Plaindrome(){
              if(head==null || head.next==null){
                  return true;
              }
              Node curr= Mid(head);
              Node prev=null;

              while(curr!=null){//reversing the linked or half linked to get palindrome or not?
                 Node next=curr.next;
                  curr.next=prev;
                  prev=curr;
                  curr=next;
              }Node right=prev;
              Node left=head;

              while(right!=null){
                  if(left.val!=right.val){
                      return false;
                  }
                  left=left.next;
                  right=right.next;

              }return true;
          }
    // Function to swap two nodes of the linked list
    public static Node swapNodes(Node head, int x, int y) {
        if (x == y) {
            return head;
        }

        // Find the nodes to be swapped and their previous nodes
        Node prevX = null, currX = head;//while  changing the next stroing the previous
        while (currX != null && currX.val != x) {
            prevX = currX;
            currX = currX.next;//increment
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.val != y) {//while  changing the next stroing the previous 
            prevY = currY;
            currY = currY.next;
        }

        // If any of the nodes are not present in the list, return the head
        if (currX == null || currY == null) {
            return head;
        }

        // If x is not the head of the list
        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        // If y is not the head of the list
        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        // Swap the next pointers of the nodes
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

        return head;
    }


    private Node Mid(Node head) {
              Node slow=head;
              Node fast=head;
              while(fast!=null && fast.next!=null){
                  slow=slow.next;
                  fast=fast.next.next;
              }return slow;
    }

    public void reverse(){
              //variable to reverse the linked list
              Node prev=null;
              Node curr=head;
              Node next;//it is to store the link between next node in list which we have to revrse
              while(curr!=null){
                    next=curr.next;//first store it then change it
                    curr.next=prev;//here we are changing it
                  //curr.prev=next; addition if linked list double
                    prev=curr;//moving forward
                    curr=next;


              }head= prev;//prev is head in the last as list is reversed already
          }
              public void insertFirst(int value){
                  Node node=new Node(value);
                  node.next=head;//it's similar to swapping
                  head=node;

                  if(tail==null){
                      tail=head;
                  }
                       size+=1;
             
              }
              public void Display() {
              if(head==null){
                  System.out.print("LL is empty");
              }
              Node temp=head;//so it head don't change every time
              while(temp!=null){
                  System.out.print(temp.val +"->");
                  temp=temp.next;
              }    System.out.println("END");
              }
                    public void insertlast(int value){
              Node node=new Node(value);
              if (tail==null){
                  insertFirst(value);
                  return;
                  
              }
              tail.next=node;
              tail=node;
              size++;
              
              
                    }

                    public void insert(int value,int index){
                            if (index==0){
                                insertFirst(value);
                                return;
                            }  if (index==size){
                                insertlast(value);
                                return;
                        }     Node temp=head;//just to store the only value
                            for(int i=1;i<index;i++){//traversing till index-1
                                temp=temp.next;//changing temp everytime
                            }
                            Node node=new Node(value,temp.next);
                    }

                    public int DeleteFirst(){
              int value =head.val;
              head=head.next;
              if(head==null){
                  tail=null;
              }  size--;
              return value;
              
              
                    }

                    public int deletelast()   {
              if(size<=1){
                  return DeleteFirst();
              }   Node secondlast=get(size-2);//index value
              int value=tail.val;
              tail=secondlast;
              tail.next=null;
              return value;
               }


               public int delete(int index){
              if(index==0){
                  return DeleteFirst();
              } if(index==size-1){
                  return deletelast();
                    
                   }   Node prev=get(index-1);
              int value=prev.next.val;
              prev. next=prev.next.next;
              return value;
               }


               public int deletenth(int index){
              int n=size-index-1;
              Node pre=get(n);
       int value=pre.next.val;//this is just to get the value of that nod we are deleting
       pre.next=pre.next.next;//new connection
       return value;
               }
                    public Node get(int index){//get the index
              Node node=head;//by making the new node
              for(int i=1;i<index;i++){//traversing till before index
                  node=node.next;//increment
              }
              return node;
                    }




                    public Node Find(int value){
                                Node node=head;
                      while(node!=null){//condition
                      if(node.val==value){
                        return node;
                                   }
                      node=node.next;//this is the incrementation part

        }    return null;
    }



    public int Helper(Node head,int key){//recursive search
              if (head==null){
                  return -1;//base case
              }if(head.val==key){
                  return 0;//0 because head exist on 0 index that why
        }int idx=Helper(head.next,key) ;
              if(idx==-1) {
                  return -1;
              }return idx+1;//this is to correct index where we find the value or key
    }




    public int recSearch(int key){

return Helper(head,key);
    }




   private class Node {//data type or box to store data and next data
       private int val;
       private Node next;

       public Node(int val) {

           this.val = val;
       }

       public Node(int val, Node next) {
           this.val = val;
           this.next = null;
       }


   }}

