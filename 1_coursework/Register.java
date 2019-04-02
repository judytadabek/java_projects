package lib;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import lib.Name;

/**
 * Register allows to create a new list containing names.
 * This is aggregation of Name class.
 * Contains several methods useful to add, remove, retrieve data from and to register and many more.
 * 
 * @author p15238407
 *
 */
public class Register implements Iterable <Name>{
	
	//fields
	private ArrayList<Name> reg = new ArrayList<>();
	
	
	//constructors
	/**
	 * Default constructor - creates an empty list of register
	 */
	public Register() {
		reg = new ArrayList<>();
	}
	
	//Methods
	/**
	 * Method adds name to the end of the register
	 * @param name - specified name is added to the register
	 */
	public void addName (Name name) {
		reg.add(name);
		
	}
	
	/**
	 * Returns the last name removed from register
	 * @param i - position number in register where from the name is removed
	 * @return the last name removed from register
	 */
	public Name removeName (int i) {
		return reg.remove(i);
	}
	
	/**
	 * Returns the name in the register on the specified position number
	 * @param i - position number in register
	 * @return the name in the register on the specified position number
	 */
	public Name getName (int i) {
		return reg.get(i);
	}
	
	public void setName (int index, Name n) {
		
		//if (index < 0 || index >= reg.size()) {
		//	System.out.println("Index is out of the register size");
		//}
		//else if (index >= 0 ){
			reg.set(index, n);
		//}
	}
	
	
	
	/**
	 * Returns size of the register
	 * @return size of the register
	 */
	public int registerSize() {
		return reg.size();
	}
	
	/**
	 * Clears register.
	 * Removes all the data from register.
	 */
	public void clearRegister() {
		reg.clear();
	}
	
	/**
	 * Returns true or false depending whether register is empty or not
	 * @return true - register empty; false - register is not empty
	 */
	public boolean isRegisterEmpty() {
		return reg.isEmpty();
	}
	
	/**
	 * Returns a textual representation of the register model state.
	 * @return a textual representation of the register model state
	 */
	@Override
	public String toString() {
		return "Register:[" + reg + "]";
	}
	
	
	/**
	 * Returns true or false whether any first name in register contains given string firstname
	 * @param firstname - given string to search through register first names
	 * @return true or false whether any first name in register contains given string
	 */
	public boolean searchRegisterByFirstName(String firstname) {
		return reg.stream().anyMatch(n -> n.getFirstName().contains(firstname));
	}
	
	/**
	 * Returns how many times a character c performs at family name of register
	 * @param c - given character to compare through family names
	 * @return number of given character occurrences in family names of the register
	 */
	public int countFamilyNameOccurrences(char c) {
		int counter = 0;		
		for (Name n : reg) {
			for (int i=0; i<reg.size(); i++) {
				if (n.getFamilyName().charAt(i) == c) {
				counter++; }
				}
		} return counter;
	}

	/**
	 * Returns iteration of the Name collection
	 * @return iteration of the Name collection
	 */
	@Override
	public Iterator <Name> iterator(){
		return this.reg.iterator();
	}
	
	
	/**
	 * Sorts register.
	 * Method is sorting register by family name, then first name.
	 */
	public void sortRegister() {
		Collections.sort(reg);
	}
	
}
