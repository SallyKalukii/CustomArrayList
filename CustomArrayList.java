public class CustomArrayList{
    //instances 
    private  int INITIAL_CAPACITY = 10;
    private int length; //to determine the size 
    private Object [] innerArray; //storing elements into an array 
    
    //overloaded contructor 
    public CustomArrayList(){
        innerArray = new Object[INITIAL_CAPACITY];
        length = 0;

    }


    //method for adding object element to the end of the list(boolean)
    public void add(Object element){
        
        if (length >=   INITIAL_CAPACITY){
            Object [] innerArrayCopy = innerArray;
            INITIAL_CAPACITY = 2*INITIAL_CAPACITY; //doubling current capacity 
            innerArray = new Object [INITIAL_CAPACITY];
            for (int i =0; i<length; i++){
                innerArray[i]= innerArrayCopy[i]; 
            }
            innerArray[length] = element;  //adding elements to the end of the list 
        }else{
            innerArray[length] = element; //adding elements to the end of the list 
        }
        length++; //increasing the length of the array 
         
    }

    //method for removing an element, takes in an index and returns the element 
    //throws an indexoutofbound exception 
    public Object remove(int index)throws IndexOutOfBoundsException{
        
        Object element = innerArray[index]; //element to be removed is assigned to variable element 
        for(int i= index+1; i<length; i++){
            //replace the element being removed with the component next to it 
            
            innerArray[i-1] = innerArray[i]; //if element is the last    
        }

        length--; //reducing the length of the array by 1

        return element;
    }

    //removing method by element  
    public Object remove(Object element){
        for (int i = 0; i<length; i++){
            if (innerArray[i].equals(element)){
                this.remove(i);
                return element;
            }
         
        }
        return null; 
    }

    //method for accessing elements in an arrayList and takes an index 
    //throws indexoutofbound exception 
    public Object get(int index) throws IndexOutOfBoundsException{
        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return innerArray[index];
    }

    //method for returning the size of the list
    public int size() {
        return length; 
    }

    //method to check whether the list is empty 
    public boolean isEmpty(){
        return length == 0; //return true if length is 0
    }

    //method to display the list content. Print in the format provided: [element, element, element,...., element]
    //the format can be made possible using String builder notation (more efficient)
    public String display(){
        if (length == 0){
            return "[]"; //what to display when the array is empty 
        }
        StringBuilder str = new StringBuilder ("[");
        for (int i =0; i<length; i++){ //looping through the elements 
            str.append(innerArray[i]).append(",");

        }
        //appends the last element of the array 
        str.append(innerArray[length - 1]).append("]");
        return str.toString();
    }

    //method to modify an element at a specific index 
    //throws an indexoutofbound exception 
    public void set(int index, Object element){
        if (index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        
        innerArray[index] = element; //sets the element at the specified index 

    }





}