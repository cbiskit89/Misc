class Link
{
	public int key; // key value

	public String firstName; // first Name

	public String lastName; // last Name

	public double gpa; // gpa

	public Link next; // next link in list
// -------------------------------------------------------------
	public Link(int keyvalue, String first, String last,double g ) // constructor
	{ 
		key = keyvalue;
		firstName = first;
		lastName = last;
		gpa = g; 
	}
// -------------------------------------------------------------
	public void displayLink() // display this link
	{ 
		System.out.println(key + "   " + firstName +'\t' +lastName +'\t' + gpa  ); 
	}
} // end class Link
