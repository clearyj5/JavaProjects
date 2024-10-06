package eTest3;

public class LinkedList
{
    private int listCount;
    private Node head;

    public LinkedList()
    {
        head = new Node();
        listCount = 0;
    }
    
    public void add(int data)
    {
    	listCount = listCount + 1;
    	head.setData(data);
    }
    
    public void insert(int index)
    {
    	head.setData(index); 
    }
    
    public Node get(int index)
    {
    	return Node.getNextNode();
    }
    
    public void remove(int index)
    {
    	
    }
    
    public int size()
    {
    	return listCount;
    }
    
}
