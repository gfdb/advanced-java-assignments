import java.util.NoSuchElementException;
/**
 * The CellList class is used to created a linked list of 
 * cellphone objects. It has 2 attributes; CellNode and size. 
 * Each CellNode has a cellphone and a pointer.
 * @author Gianfranco Dumoulin
 * @version 1.0
 */
public class CellList {
	/**
	 * A CellNode head, used as a pointer to the beginning of the list
	 */
	private CellNode head;
	/**
	 * An integer, size, used to count how many nodes are in the list.
	 */
	private int size = 0;
	/**
	 * default constructor for the CellList class, will create a CellList with 
	 * head = null;
	 * size = 0;
	 */
	public CellList() 
	{
		head = null;
		size = 0;
	}
	/**
	 * copy constructor for the CellList class
	 * @param cl a CellList object
	 */
	public CellList(CellList cl)
	{
		if (cl.head == null) 
		{
			head = null;
			size = 0;
		} 
		else
		{
			head = null;
			CellNode t1, t2;
			t1 = cl.head;
			t2 = null;
			
			while(t1 != null)
			{
				if (head == null)
				{
					t2 = new CellNode(t1.cp, null);
					size++;
				}
				else
				{
					t2.next = new CellNode(t1.cp, null);
					t2 = t2.next;
					size++;
				}
				t1 = t1.next;
			}
			t2 = null; // this is to avoid a privacy leak
		}
	}
	/**
	 * addToStart is used to add a new node to the start of the list.
	 * @param c1 A cellPhone object that will be passed into a newly created node.
	 */
	
	public void addToStart(CellPhone c1)
	{
		head = new CellNode(c1, head);
		size++;
	}
	/**
	 * Insert at index is used to insert a CellPhone c1 at a given index i.
	 * @param c1 A cellphone object.
	 * @param i An integer value for an index, i.
	 */
	public void insertAtIndex(CellPhone c1, int i) 
	{
		try 
		{
			if (i == 0)
			{
				addToStart(c1);
			}
			if ( 0 < i && i <= size-1)
			{
				CellNode t = head;
				int cntr = -1;
				while (t.next != null)
				{
					t = t.next;
					cntr++;
					if (cntr+1 == i)
					{
						t.next = new CellNode(c1, t.next);
						size++;
						break;
					}
				}
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("The index you have entered is invalid."
					+ "\nThe program will now terminate to avoid a crash.");
			System.exit(0);
		}
		
	}
	/**
	 * deleteFromStart is used to delete the node at the beginning of the list.
	 * @return true if and only if the first node was deleted, false otherwise.
	 */
	public boolean deleteFromStart()
	{
		// empty list case
		if (head == null)
			return false;
		CellNode t = head;
		// only 1 element case
		if (t.next.next == null)
		{
			head = null;
			size--;
			return true;
		}
		// all other cases
		head = t.next.next;
		t = null;
		size--;
		return true;
	}
	/**
	 * deletes a node from the given index
	 * @param i an integer value for an index in the list.
	 */
	public void deleteFromIndex(int i) 
	{
		try 
		{
			CellNode t = head;
			if ( 0 <= i && i <= size-1)
			{
				if (i == 0)
				{
					deleteFromStart();
				}
				int cntr = -1;
				while (t.next != null)
				{
					t = t.next;
					cntr++;
					if (cntr+1 == i)
					{
						t.next = t.next.next;
						size--;
						break;
					}
				}
			}
			else
			{
				throw new NoSuchElementException();
			}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("The index you have entered is invalid."
					+ "\nThe program will now terminate to avoid a crash.");
			System.exit(0);
		}
	}
	/**
	 * Replaces the cellphone at the given index with the newly passed cellphone object c1.
	 * @param c1 passed CellPhone object
	 * @param i passed integer value for an index.
	 * @return true if and only if the cellphone was succesfully replaced in the given index, false otherwise.
	 */
	public boolean replaceAtIndex(CellPhone c1, int i)
	{
		if (0 <= i && i <= size-1)
		{
			CellNode t = head;
			int cntr = -1;
			while (t.next != null)
			{
				t = t.next;
				cntr++;
				if (cntr == i)
				{
					t.cp = c1;
					return true;
				}
			}	
		}
		return false;
	}
	public CellNode find(long l)
	{
		CellNode t = head;
		int cntr = 0;
		while (t != null && Long.compare(t.cp.getSerialNum(), l) != 0)
		{
			t = t.next;
			cntr++;
		}
		if (cntr == size)
			return null;
		return t;
		
	}
	/**
	 * Checks if there exists a cellphone in the list with a passed long value serial number.
	 * @param l long value representing the serial number of a cellphone.
	 * @return true if and only if there is an object in the list with a matching serial number, false otherwise.
	 */
	public boolean contains(long l)
	{
		CellNode t = find(l);
		if (t == null)
			return false;
		return true;
	}
	/**
	 * Prints the contents of a CellList using the toString method from CellPhone.
	 */
	public void showContents()
	{
		System.out.println("\nThe current size of the list is " + this.size 
				+ ". Here are the contents of the list"
				+ "\n===============================================================================");
		CellNode t = head;
		int cntr = 0;
		while (t.next != null)
		{
			System.out.print(t.cp.toString() + " ---> ");
			cntr++;
			if (cntr%3 == 0) {
				System.out.print("\n");
			}
			t = t.next;
		}
		System.out.print("X\n");
	}
	/**
	 * Equals method for the CellList class. Checks if two CellLists are equal.
	 * @param CL A CellList list.
	 * @return true if and only if two CellLists are identical in length and content.
	 */
	public boolean equals(CellList CL)
	{
		CellNode t = head;
		CellNode t1 = CL.head;
		int cntr = 0;
		if (this.size != CL.size)
			return false;
		while (t.next != null && t1.next != null)
		{
			t = t.next;
			t1 = t1.next;
			if (t.cp.equals(t1.cp))
			{ 
				cntr++;
				continue;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	public class CellNode implements Cloneable {
		
		private CellPhone cp;
		private CellNode next;
		
		public CellNode() 
		{
			cp = null;
			next = null;
		}
		public CellNode(CellNode cn)
		{
			this.cp = cn.cp;
			this.next = cn.next;
		}
		public CellNode clone()
		{
			CellNode cn = new CellNode(this.cp, this.next);
			return cn;
		}
		public CellNode(CellPhone phone, CellNode node)
		{
			cp = phone; // this will result in a privacy leak. 
			//In order to fix this issue, we could close the object and return that instead of returning the pointer.
			next = node;
		}
		public CellPhone getC1() {
			return cp;
			// this will result in a privacy leak. 
			//In order to fix this issue, we could close the object and return that instead of returning the pointer.
						
		}
		public void setC1(CellPhone c1) {
			this.cp = c1;
		}
		public CellNode getN() {
			return next;
		}
		public void setN(CellNode n) {
			this.next = n;
		}
		
		
		
	}

}
