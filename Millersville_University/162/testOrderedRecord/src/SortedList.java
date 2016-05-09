class SortedList
{
	private Link first; // ref to first item on list
// -------------------------------------------------------------
	public SortedList() // constructor
	{ 
		first = null;
	}
// -------------------------------------------------------------
	public boolean isEmpty() // true if no links
	{
		return (first==null);
	}
// -------------------------------------------------------------
	public void insert(int id,String f, String l,double g) 
	{	
		Link newLink = new Link(id, f, l, g); // make new link
		Link previous = null; // start at first
		Link current = first;
		
		while (current != null && id > current.key)
		{
			previous = current;
			current = current.next;
		}
		
		if (previous == null)
			first = newLink;
		else
			previous.next = newLink;
		
		newLink.next = current;

	} // end insert
// -------------------------------------------------------------
	public Link remove() // return & delete first link
	{ 
		// (assumes non-empty list)
		Link temp = first; // save first
		first = first.next; // delete first
		return temp; // return value
	}
// -------------------------------------------------------------
	public void displayList()
	{
		System.out.println("List (first-->last): ");
		Link current = first; // start at beginning of list

		while(current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println("");
	}
} // end class SortedList
