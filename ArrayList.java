import java.util.Iterator;
/**
 * ArrayList is an implementation (Data Structure) of the list
 * Abstract Data Type. It's randomly accessible, meaning items can
 * be accessed (added,removed,seen) from any point in the list. The
 * ArrayList is dynamic in size and has inifinite capacity, however
 * the default initial capacity of the ArrayList is 20. It will resize
 * to accomodate more data.
 * 
 * @author Connor Teal
 */
public class ArrayList<T extends Comparable> implements Iterable{
    protected Object[] array;
    private int numElements;

    /**
     * Iterator class to allow Iterable for arraylist class. This
     * is needed for the ArrayList class to implement and use
     * Iterable.
     */
    public class ArrayIterator implements Iterator<Object>{
        int index = 0;

        /**
         * hasNext will determine if the iterator has a next value
         * it can access.
         * 
         * @return boolean true if has next
         */
        @Override
        public boolean hasNext(){
            if(this.index < numElements){
                return true;
            }
            return false;
        }

        /**
        * Returns the next object in the arraylist using
        * iterator.
        * 
        * @return Object next in the list
        */
        @Override @SuppressWarnings("unchecked")
        public T next(){
            @SuppressWarnings("unchecked")
            T returnT = get(index++);
            return returnT;
        }

        /**
         * Remove will remove the current item during the iterator's
         * traversal of the arraylist.
         * 
         * @return none
         */
        @Override
        public void remove(){
            ArrayList.this.get(index++);
        }

    }

    /**
     * This method must be written in order to implement the Iterable
     * interface. It allows the iterator to be used in the arraylist
     * class.
     * 
     * @return Iterator for arraylist
     */
    public Iterator<Object> iterator(){
        return new ArrayIterator();
    }

    /**
     * No argument constructor creates array lst of capacity 20
     * 
     * @param None
     * @return ArrayList Object
     */
    public ArrayList(){
        this.array = new Object[20];
        this.numElements = 0;
    }

    /**
     * Copy Constructor
     * 
     * @param ArrayList
     * @return ArrayList Object
     */
    public ArrayList(ArrayList that){
        this.array = that.array.clone();
        this.numElements = that.numElements;
    }

    /**
     * Constructor that creates an arraylist of a given starting capacity
     * 
     * @param int capacity declares initial list capacity
     * @return ArrayList Object with given starting capacity
     */
    public ArrayList(int capacity){
        try{
            if(capacity <= 0){
                throw new Exception("Capacity Must be Greater than or equal to 1!");
            }
            this.array = new Object[capacity];
            this.numElements = 0;
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * add will insert a new object at the end of the arraylist
     * 
     * @param Object object to add to the list
     * @return None
     */
    public void add(T object){
        boolean done = false;
        while(!done){
            try{
                this.isFull();
                this.array[numElements++] = object;
                done = true;
            }catch(ReachedListCapacityException e){
                this.array = this.doubleCap(this.array);
            }
        }
    }

    /**
     * insert allows an object to be placed at a specified index position
     * as long as that index is within the size (number of elements) of the
     * arraylist.
     * 
     * @param Object a object to insert
     * @param int index the position to insert the object
     * @return None
     */
    public void insert(T a, int index){
        boolean isDone = false; //Initially not done inserting

        while(!isDone){
            try{
                //Check to see if index is in range
                isIndexInRange(index);
                //Check to see if full -- throw exception if so
                this.isFull();

                this.array[index] = a;
                isDone = true;
                //if adding to end of the list increase numElements
                if(index == numElements){
                    numElements++;
                }
            }catch(IndexOutOfRangeException e){
                //Trying to insert the object outside of the list
                System.out.println(e.getMessage());
                isDone = true;
            }catch(ReachedListCapacityException ex){
                //List needs to increase in size
                this.array = this.doubleCap(this.array);
            }
        }
    }

    /**
     * size returns the number of objects in an arraylist
     * 
     * @param None
     * @return int size is the number of items in the list
     */
    public int size(){
        return this.numElements;
    }

    /**
    * swap will swap two objects in the array given two index positions
    * as integers
    * 
    * @param idx1 index of one object
    * @param idx2 index of another object
    * @return Nothing
    */
    @SuppressWarnings("unchecked")
    public void swap(int idx1, int idx2){
        T temp = (T) array[idx2];
        array[idx2] = array[idx1];
        array[idx1] = temp;
    }

    /**
     * shiftLeft will shift elements in the list one index to the left
     * from a given starting index
     * 
     * @param int index is the startng point for the shift
     * @return Nothing
     */
    private void shiftLeft(int index){
        try{
            //Check to see if index is within range
            isIndexInRange(index);
            for(int i = index; i < numElements - 1; i++){
                this.array[index] = this.array[index + 1];
            }
            this.array[numElements - 1] = null;
            numElements--;
        }catch(IndexOutOfRangeException e){
            //If the index isn't in range end program
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * remove will remove and return the element at a given index and then
     * resize the list.
     * 
     * @param int index is the position of the element to remove
     * @return Object the object at the specified index
     */
    public T remove(int index){
        try{
            //Check to see if index is in range
            isIndexInRange(index);

            //Assigns return value
            @SuppressWarnings("unchecked")
            T retVal = (T) new ArrayList(this).array[index]; 

            //Shifts left to adjust list for missing element
            this.shiftLeft(index);

            return retVal;
        }catch(IndexOutOfRangeException e){
            //If index isn't in range close program
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * toString prints out the elements of a list separated by commas
     * 
     * @param None
     * @return String the list separated by commas
     */
    @Override
    public String toString(){
        return this.toString(0);
    }

    /**
     * isEmpty checks to see if the list has any elements
     * 
     * @param None
     * @return boolean true if list is empty
     */
    public boolean isEmpty(){
        //If no elements than the list is empty
        if(numElements == 0){
            return true;
        }

        return false;
    }

    /**
    * indexOf will return the index of a target object if it's contained
    * in the list. Otherwise it returns -1 indicating it wasn't found.
    * 
    * @param Object the object that is being searched for
    * @return int index of the object searched for
    */
    @SuppressWarnings("unchecked")
    public int indexOf(T object){
        for(int i = 0; i < numElements; i++){
            T temp = (T) this.array[i];
            if(temp.equals(object)){
                return i;
            }
        }

        return -1;
    }

    /*
    * This is a helper method I made to explore/practice recursion. I
    * would likely implement this with a for string given my understanding
    * of recursion at this point in my programming career.
    */
    @SuppressWarnings("unchecked")
    private String toString(int n){
        if(n == numElements){
            return "";
        }

        return (T) this.array[n] + "\n" + (T) this.toString(n+1);
    }

    /**
     * isIndexInRange checks to see if the target index is within the
     * range of declared elements in the array list
     * 
     * @param int index is the index to check
     * @return boolean true if inside the range
     * @throws IndexOutOfRangeException when index outside range
     */
    private boolean isIndexInRange(int index) throws IndexOutOfRangeException{
        if(index > numElements || index < 0){
            throw new IndexOutOfRangeException();
        }

        return true;
    }

    /**
     * equals will check to see if two lists are equal. In this case
     * equal means same size and same values at the same indexes.
     * 
     * @param Object ArrayList to compare against
     * @return boolean true if equal
     */
    public boolean equals(Object that){
        ArrayList temp = new ArrayList((ArrayList)that);
        if(this.size() != temp.size()){
            return false;
        }
        for(int i = 0; i < numElements; i++){
            if(new ArrayList(this).array[i] != temp.array[i]){
                return false;
            }
        }
        return true;
    }

    /**
    * get will return the object at a target index
    * 
    * @param index is the position of the element to get
    * @return Object at specified index
    * @exception IndexOutOfRangeException if index out of range
    */
    @SuppressWarnings("unchecked")
    public T get(int index){
        try{
            isIndexInRange(index);
            T returnT = (T) new ArrayList(this).array[index];
            return returnT;
        }catch(IndexOutOfRangeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * doubleCap is a private helper method that doubles the capacity
     * of a list.
     * 
     * @param list is Object Array
     * @return list is the Object Array with twice the capacity
     */
    private Object[] doubleCap(Object[] list){
        Object[] retVal = new Object[list.length * 2];
        for(int i = 0; i < list.length; i++){
            retVal[i] = list[i];
        }
        return retVal;
    }

    /**
     * isFull is a helper method that determines if the capacity of
     * a list has been fully utilized.
     * 
     * @param None
     * @return boolean false if not full
     * @throws ReachedListCapacityException if full
     */
    private boolean isFull() throws ReachedListCapacityException{
        if(this.numElements == this.array.length){
            throw new ReachedListCapacityException();
        }
        return false;
    } 

    /**
     * Returns a trimmed array of only the size of the elements in
     * the array list.
     * 
     * @return Object array of all non-null values
     */
    protected Object[] getArray(){
        int numberOfValues = 0;
        Object[] retArray = new Object[numElements];
        for(Iterator iterator = this.iterator(); iterator.hasNext();){
            retArray[numberOfValues++] = iterator.next();
        }
        return retArray;
    }

    /**
     * clear will clear the entire arraylist of items
     * 
     * @param None
     * @return Nothing
     */
    public void clear(){
        for(int i = 0; i < numElements; i++){
            this.array[i] = null;
        }
        this.numElements = 0;
    }

}
