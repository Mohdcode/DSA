public class Trie {
    static class Node{
        Node[] children =new Node[26];
        boolean eow=false;//end of word

         Node() {
             int i = 0;
             while (i <26) {
                 children[i]=null;
                 i++;
             }
         }
        public void insert(String word) {
            //every node has 25 letter array what ever character come it denote the index of arr
            Node current = this;//is root node
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';


            if (current.children[index] == null) {
                current.children[index] = new Node();//crate new node the array index
            }
            current = current.children[index];//changing the current node to children node
        }
            current.eow = true;
        }
        public  boolean wordbreak(String key){
             if(key.length()==0){
                 return true;
             }
            for (int i = 0; i < key.length(); i++) {
             if(search(key.substring(0,i))&& wordbreak( key.substring(i))){
                 return true;
                }

            }return false;
        }

        public boolean search(String word) {
            Node current = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    return false;
                }
                current = current.children[index];
            }
            return current.eow;
        }

    }
    public static void main(String[] args) {

    }
}
