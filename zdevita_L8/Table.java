//***************************************************************************
// Name: Zachary DeVita		Folder Name: zdevita_L8
// Class: CS260			     Lab #: 8
// Class time: 10:00am
// Date: 5/23/2014
// Program Name: Table.java
// Program Description:	Methods for generic Hash Table with Double hashing
//***************************************************************************

@SuppressWarnings("unchecked")
public class Table<K, E>
{
	private int manyItems = 0, max, collisions = 0;
	private Object[] keys, data;
	private boolean[] isUsed;
	private boolean isFound = false;

/*
*	public Table(int capacity)
Initializes an empty hash table with a specified capacity
Parameter:	capacity - the capacity of this hash table
Precondition:	capacity is non-negative
Postcondition:	This hash table is empty and has the given capacity
*/
	public Table(int capacity)
	{
		if(capacity <= 0)
			throw new IllegalArgumentException("Capacity is negative.");
		max = capacity;
		keys = new Object[capacity];
		data = new Object[capacity];
		isUsed = new boolean[capacity];
	}
/*
*	public boolean containsKey(K key)
Determines whether a specified key is in this table.
Parameter:	key - the non-null key to look for
Precondition: key cannot be null
Returns:	true(if this table contains an object with the specified key);
			false, otherwise
*/
	public boolean containsKey(K key)
	{
		return (findIndex(key) != -1);
	}
/*
*	public void put(K key, E element)
Add a new element to this table using the specified key.
Parameters:	key - the non-null key to use for the new element
			element - the new element that's being added to this table
Precondition:	If there is not already an element with the specified key,
				then this table's size must be less than its capacity
Postcodition:	The new element is added to the table with the specified key
*/
	public void put(K key, E element)
	{
		if(manyItems == data.length)
			throw new IllegalStateException("Table is full.");

		int index = hash1(key);

		if(keys[index] != null)
		{
			collisions++;
			System.out.println("Level 1 Collision");
			index += hash2(key);
			while(index >= max)
				index -= max;
			while(keys[index] != null)
			{
				collisions++;
				System.out.println("Level 2 Collision");
				index = nextIndex(index);
			}
		}
		keys[index] = key;
		data[index] = element;
		isUsed[index] = true;
		manyItems++;
	}
/*
*	private int findIndex(K key)
Finds the element of the hash table which contains the specified key.
Parameter:	key - the key that will be searched for
Postcondition:	If the specified key is found in the table, then the return value
				is the index of the specified key. Otherwise the return value is -1
*/
	private int findIndex(K key)
	{
		int count = 0;
		int index = hash1(key);

		if(!key.equals(keys[index]))
		{
			index += hash2(key);
			while(index >= max)
				index -= max;

			while(!key.equals(keys[index]) && (isUsed[index]))
				index = nextIndex(index);
		}
		if(key.equals(keys[index]))
			return index;
		return -1;
	}
/*
*	public E get(K key)
Retrieve an object for a specified key.
Parameter:	key - the non-null key to look for
Precondition:	key cannot be null
Returns:	A reference to the object with the specified key; null if the
			table does not contain such an object.
*/
	public E get(K key)
	{
		int index = findIndex(key);
		if(index != -1)
			return (E) data[index];
		else
			System.out.println("Item not found");
		return null;
	}
/*
*	public int getCapacity()
Accessor method that returns the capacity of the hash table.
Returns:	the capacity of the hash table
*/
	public int getCapacity()
	{
		return max;
	}
/*
*	public int getCollisions()
Accessor method that returns the total number of collisions that occured.
Returns:	the total number of collisions that occured
*/
	public int getCollisions()
	{
		return collisions;
	}
/*
*	public E getData(int index)
Accessor method that returns the data held in specified index of the hash table.
Parameter:	index - the specified location in the hash table
Returns:	the data from the specified element in the hash table
*/
	public E getData(int index)
	{
			return (E) data[index];
	}

/*
*	private int hash1(Object key)
Converts a key to a valid index of the table's arrays.
Parameter:	key - the key which will be converted to a valid index of the hash table
Returns:	The return value is a valid index of the table's arrays
*/
	private int hash1(Object key)
	{
		return Math.abs(key.hashCode()) % data.length;
	}
/*
*	private int hash2(Object key)
Finds another valid index in the hash table.
Parameter:	key - the key which will be converted to a valid index of the hash table
Returns:	The return value is a valid index of the table's arrays
*/
	private int hash2(Object key)
	{
		return key.hashCode()*33/12;
	}
/*
*	private int nextIndex(int i)
Returns the value of the next object in the hash table.
Parameter:	i - the current index of the table's array
Precondition:	the index number cannot be the last element of the table's array
Postcondition:	If index is the last element of the array, then the return value
				is 0; otherwise, return value is the current index incremented by 1
*/
	private int nextIndex(int i)
	{
		if(i+1 == data.length)
			return 0;
		return i+1;
	}
/*
*	public E remove(K key)
Remove an object for a specified key.
Parameter:	key - the non-null key to look for
Precondition:	key cannot be null
Postcondition:	If an object was found with the specified key, then that
				object has been removed and a copy is returned.
*/
	public E remove(K key)
	{
		int index = hash1(key);
		E answer = null;

		if(keys[index] != key)
		{
			index += hash2(key);
			while(index >= max)
				index -= max;
			while(keys[index] != key && (isUsed[index]))
				index = nextIndex(index);
		}
		if(keys[index] == key)
		{
			answer = (E) data[index];
			keys[index] = null;
			data[index] = null;
			manyItems--;
			return answer;
		}
		System.out.println("Item not found");
		return answer;
	}

}