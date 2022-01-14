import java.util.Iterator;


/**
    Implements a singly-linked list.
    
    @author  Aaron Shih
    @version 12/9/2021
    
    @author  Period - 6
    @author  Assignment - SinglyLinkedList
    
    @author  Sources - Maria & Gary Litvin
 */
public class SinglyLinkedList<E> implements Iterable<E>
{
    private ListNode<E> head;
    private int nodeCount;

    // Constructor: creates an empty list
    public SinglyLinkedList()
    {
        head = null;
        nodeCount = 0;
    }

    /**
        Constructor: creates a list that contains all elements from the
        array values, in the same order
        @param values  array containing all elements for this list
     */
    public SinglyLinkedList(E[] values)
    {
        ListNode<E> tail = null;
        for (E value : values) // for each value to insert
        {
            ListNode<E> node = new ListNode<E>(value, null);
            if (head == null)
                head = node;
            else
                tail.setNext(node);
            tail = node;    // update tail
        }

        nodeCount = values.length;
    }

    /**
        Return true if this list is empty; otherwise returns false.
        @return true if this list is empty; otherwise returns false.
     */
    public boolean isEmpty()
    {
        return (0 == nodeCount || null == head);
    }

    /**
        Returns the number of elements in this list.
        @return  number of elements in this list.
     */
    public int size()
    {
        return nodeCount;
    }

    /**
        Returns true if this list contains an Object equal to obj; otherwise returns false.
        @return true if this list contains an Object equal to obj
     */
    public boolean contains(Object obj)
    {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
        Returns the index of the first Object equal to obj; if not found,
        returns -1.

        @param obj  Object to find
        @return  the index of the first Object in equal to obj; if not found,
                  returns -1.
     */
    public int indexOf(Object obj)
    {  
        int index = 0;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    /**
        Adds obj to this collection.  Returns true if successful;
        otherwise returns false.
        
        @param obj  element to add to this collection
        @return  true if successful; otherwise returns false.
     */
    public boolean add(E obj)
    {
        add(nodeCount, obj);
        return true;  
    }

    /**
        Removes the first element that is equal to obj, if any.
        Returns true if successful; otherwise returns false.

        @param obj  element to remove
        @return  true if successful; otherwise returns false.
     */
    public boolean remove(E obj)
    {
        if (isEmpty() || obj == null) {
            return false;
        }
        int idx = indexOf(obj);
        if (idx < 0) {
            return false;
        }
        remove(idx);
        return true;
    }

    /**
        Returns the i-th element.

        @param i  element to get from the list
        @return element at index i
        @throws IndexOutOfBoundsException 
     */
    public E get(int i)
    {
        if (i < 0 || i >= nodeCount) {
            throw new IndexOutOfBoundsException("get(" + i + "), but nodeCount = " + nodeCount + " IndexOutOfBoundsException");
        }
        int index = 0;
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            E elem = it.next();
            if (index == i) {
                return elem;
            }
            index++;
        }
        throw new IndexOutOfBoundsException("get(" + i + "), but nodeCount = " + nodeCount + " IndexOutOfBoundsException"); 
    }

    /**
        Replaces the i-th element with obj and returns the old value.
        
        @param i index of element to replace
        @param obj replacement element of element at index i
        @return old value previously located at index i
        @throws IndexOutOfBoundsException 
     */
    public E set(int i, E obj)
    {
        if (i < 0 || i >= nodeCount) {
            throw new IndexOutOfBoundsException("set()" + " i = " + i + " nodeCount " + nodeCount + " IndexOutOfBoundsException");
        }
        E rtn = null;
        if (0 == i) {
            if (isEmpty()) {
                head = new ListNode<E>(obj, null);
                return null;
            }
            else {
                rtn = head.getValue();
                head = new ListNode<E>(obj, head.getNext());
                return rtn;
            }
        }
        int index = 0;
        ListNode<E> curr = head;
        ListNode<E> prev = curr;
        while (index < i) {
            prev = curr;
            curr = curr.getNext();
            index++;
        }
        rtn = curr.getValue();
        prev.setNext(new ListNode<E>(obj, curr.getNext()));
        return rtn;
    }

    /**
        Inserts obj to become the i-th element. Increments the size
        of the list by one.
        
        @param i  insertion point in list for obj
        @param obj element to insert into list
        @throws IndexOutOfBoundsException 
     */
    public void add(int i, E obj)
    {
        if (i < 0 || i > nodeCount) {
            throw new IndexOutOfBoundsException("add()" + " i = " + i + " nodeCount " + nodeCount + " IndexOutOfBoundsException");
        }
        
        if (0 == i || isEmpty()) {
            head = new ListNode<E>(obj, head);
            nodeCount++;
            return;
        }
        int index = 0;
        ListNode<E> curr = head;
        ListNode<E> prev = curr;
        while (null != curr && index < i) {
            prev = curr;
            curr = curr.getNext();
            index++;
        }
        prev.setNext(new ListNode<E>(obj, curr));
        nodeCount++;
        return; 
    }

    /**
        Removes the i-th element and returns its value.
        Decrements the size of the list by one.

        @param i index of element to remove
        @return element removed from this list
     */
    public E remove(int i)
    {
        E rtn = null;
        if (isEmpty() || i >= nodeCount || i < 0) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        
        if (i == 0) {
            rtn = head.getValue();
            head= head.getNext();
            nodeCount--;
            return rtn;
        }
        ListNode<E> curr = head;
        ListNode<E> prev = curr;
        int index = 0;
        while (index < i) {
            prev = curr;
            curr = curr.getNext();
            index++;
        }
        rtn = curr.getValue();
        prev.setNext(curr.getNext());
        nodeCount--;
        return rtn;
    }

    /**
        Returns a string representation of this list.
        @return  a string representation of this list.
     */
    public String toString()
    { 
        String result = "[";
        
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            result += it.next();
            if (it.hasNext()) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    /**
        Returns an iterator for this collection.
        @return  an iterator for this collection.
     */
    public Iterator<E> iterator()
    {
        return new SinglyLinkedListIterator<E>(head);
    }
}

