package eTest3;

public class Node
{
    
    private static Node nextNode;
    private int data;

    public Node()
    {
    	nextNode = null;
    }

    public Node(int nodeData)
    {
        data = nodeData;
        nextNode = null;
    }

    public Node(int nodeData, Node newNode)
    {
        data = nodeData;
        nextNode = newNode;
    }

    public int getData()
    {
    	return data;
    }

    public void setData(int nodeData)
    {
    	data = nodeData;
    }

    public static Node getNextNode()
    {
    	return nextNode;
    }

    public void setNextNode(Node newNode)
    {
    	nextNode = newNode;
    } 
}