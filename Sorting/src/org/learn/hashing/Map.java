package org.learn.hashing;

// Java program to demonstrate implementation of our
// own hash table with chaining for collision detection
import java.util.ArrayList;
import java.util.Objects;

import org.learn.sort.Student;

// A node of chains
class HashNode<K, V> {
	K key;//registrationId
	V value;//Student object
	final int hashCode;

	// Reference to next node
	HashNode<K, V> next;

	// Constructor
	public HashNode(K key, V value, int hashCode)
	{
		this.key = key;
		this.value = value;
		this.hashCode = hashCode;
	}
}

// Class to represent entire hash table
public class Map<K, V> {
	// bucketArray is used to store array of chains
	private ArrayList<HashNode<K, V> > bucketArray;

	// Current capacity of array list
	private int numBuckets;

	// Current size of array list
	private int size;

	// Constructor (Initializes capacity, size and
	// empty chains.
	public Map()
	{
		bucketArray = new ArrayList<>();
		numBuckets = 10;
		size = 0;

		// Create empty chains
		for (int i = 0; i < numBuckets; i++)
			bucketArray.add(null);
	}

	public int size() { return size; }
	public boolean isEmpty() { return size() == 0; }
	
	private final int hashCode (K key) {
		return Objects.hashCode(key);
	}

	// This implements hash function to find index
	// for a key
	private int getBucketIndex(K key)
	{
		int hashCode = hashCode(key);
		int index = hashCode % numBuckets; //hash fn  x%n, regId % size of the bucket
		// key.hashCode() coule be negative.
		index = index < 0 ? index * -1 : index;
		return index;
	}

	// Method to remove a given key
	public V remove(K key)//regId
	{
		// Apply hash function to find index for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		// Get head of chain
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// Search for key in its chain
		HashNode<K, V> prev = null;
		while (head != null) {
			// If Key found
			if (head.key.equals(key) && hashCode == head.hashCode)
				break;

			// Else keep moving in chain
			prev = head;
			head = head.next;
		}

		// If key was not there
		if (head == null)
			return null;

		// Reduce size
		size--;

		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			bucketArray.set(bucketIndex, head.next);

		return head.value;
	}

	// Returns value for a key
	public V get(K key)
	{
		// Find head of chain for given key
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
	
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// Search key in chain
		while (head != null) {
			if (head.key.equals(key) && head.hashCode == hashCode)
				return head.value;
			head = head.next;
		}

		// If key not found
		return null;
	}

	// Adds a key value pair to hash
	
	//regId, Student
	public void add(K key, V value)
	{
		// Find head of chain for given keyx
		int bucketIndex = getBucketIndex(key);
		int hashCode = hashCode(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);

		// Check if key is already present
		while (head != null) {
			if (head.key.equals(key) && head.hashCode == hashCode) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// Insert key in chain
		size++;
		head = bucketArray.get(bucketIndex);
		HashNode<K, V> newNode
			= new HashNode<K, V>(key, value, hashCode);
		newNode.next = head;
		bucketArray.set(bucketIndex, newNode);

		// If load factor goes beyond threshold, then
		// double hash table size
		if ((1.0 * size) / numBuckets >= 0.7) {
			ArrayList<HashNode<K, V> > temp = bucketArray;
			bucketArray = new ArrayList<>();
			numBuckets = 2 * numBuckets;
			size = 0;
			for (int i = 0; i < numBuckets; i++)
				bucketArray.add(null);

			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	// Driver method to test Map class
	public static void main(String[] args)
	{
		Map<Integer, Student> map = new Map<>();
		Student st1 = new Student(1212121, "Alex", "Mumbai", 98);
		Student st2 = new Student(2323232, "Alex1", "Mumbai", 98);
		Student st3 = new Student(565656, "Avaneesh", "Mumbai", 97);
		Student st4 = new Student(334343, "Salil", "Mumbai", 88);
		
		
		map.add(st1.getRegistartionID(), st1);
		map.add(st2.getRegistartionID(), st2);
		map.add(st3.getRegistartionID(), st3);
		map.add(st4.getRegistartionID(), st4);
		
		System.out.println(map.size());
		System.out.println(map.remove(st2.getRegistartionID()));
		System.out.println(map.remove(st3.getRegistartionID()));
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		
		Student obj = new Student(null, null, null, null);
		Student obj1 = new Student(null, null, null, null);
		System.out.println(new Integer(1212121).hashCode());
			
	}
}
