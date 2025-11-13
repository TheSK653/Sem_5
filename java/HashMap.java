
import java.util.ArrayList;

public class HashMap<K,V> {
    class Node {
        K key;
        V value;
        Node next;
    }

    private int size=0;
    ArrayList<Node> buckets=new ArrayList<>();

    public HashMap(){
        this(4);
    }

    public HashMap(int n){
        for(int i=0;i<n;i++){
            buckets.add(null);
        }
    }

    public void put(K key, V value){
        int idx = Hashfun(key);
        Node temp = buckets.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                temp.value=value;
                return;
            }
            temp=temp.next;
        }
        Node nn=new Node();
        nn.key=key;
        nn.value=value;
        temp=buckets.get(idx);
        nn.next=temp;
        buckets.set(idx,nn);
        size++;
        double thf=2.0;
        double lf=(size*1.0)/buckets.size();
        if(lf>thf){
            rehashing();
        }
    }

    public void rehashing(){
        ArrayList<Node> new_buckets=new ArrayList<>();
        for(int i=0;i<buckets.size()*2;i++){
            new_buckets.add(null);
        }
        ArrayList<Node> old_buckets=buckets;
        buckets=new_buckets;
        size=0;
        for(Node nn:old_buckets){
            Node temp=nn;
            while(temp!=null){
                put(temp.key,temp.value);
                temp=temp.next;
            }
        }
    }

    public V get(K key){
        int idx=Hashfun(key);
        Node temp=buckets.get(idx);
        while(temp!=null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp=temp.next;
        }
        return null;
    }

    public boolean containsKey(K key)
    {
        int idx=Hashfun(key);
        Node temp=buckets.get(idx);
        while(temp!=null)
        {
            if(temp.key.equals(key))
            {
                return true;
            }
            temp=temp.next;
        }
        return false;
    }

    public V remove(K key)
    {
        int idx=Hashfun(key);
        Node curr=buckets.get(idx);
        Node prev=null;
        while(curr!=null)
        {
            if(curr.key.equals(key))
            {
                break;
            }
            prev=curr;
            curr=curr.next;
        }
        if(curr==null)
        {
            return null;
        }
        else if(prev==null)
        {
            buckets.set(idx, curr.next);
            
        }
        else
        {
            prev.next=curr.next;
        }
        curr.next=null;
        size--;
        return curr.value;
    }

    public int Hashfun(K key){
        int idx=key.hashCode() % buckets.size();
        if(idx<0){
            idx+=buckets.size();
        }
        return idx;
    }
    public int size(){
        return size;
    }
    public ArrayList<K> keySet(){
        ArrayList<K> keys=new ArrayList<>();
        for(Node nn:buckets){
            Node temp=nn;
            while(temp!=null){
                keys.add(temp.key);
                temp=temp.next;
            }
        }
        return keys;
    }
}