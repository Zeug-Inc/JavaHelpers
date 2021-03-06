package helpers.array;

/**
 * This is a special type of Integer Array, it adds features, which are not exactly intended by Java.
 * 
 * @author Philipp Kumitz
 *
 */
public class StringArray {
	private String[] array;

	public StringArray(String[] array) {
		this.array = array;
	}

	public StringArray() {
		this.array = new String[]{};
	}

	public String[] getArray() {
		return this.array.clone();
	}

	/**
	 * Removes the first element from an array.
	 * 
	 * @return The element at Index 0
	 */
	public String popLeft() {
		String poppedElement = this.array[0];
		String[] newArray = new String[this.array.length - 1];
		System.arraycopy(this.array, 1, newArray, 0, this.array.length - 1);
		this.array = newArray;
		return poppedElement;
	}
	
	/**
	 * Removes an element from the array.
	 * 
	 * @return the last element in the array
	 * @see #pop(int)
	 * @see #popLeft()
	 */
	public String pop() {
		String poppedElement = this.array[this.array.length - 1];
		String[] newArray = new String[this.array.length - 1];
		System.arraycopy(this.array, 0, newArray, 0, this.array.length - 1);
		this.array = newArray;
		return poppedElement;
	}

	/**
	 * Removes an element with the given index from the array.
	 * 
	 * @param index Index of the element you want to get.
	 * @return Element with the given index.
	 * @throws ArrayIndexOutOfBoundsException When the given index exceeds the elements in the array.
	 * 
	 */
	public String pop(int index) {
		String poppedElement;
		String[] newArray = new String[this.array.length - 1];
		if (index == 0) {
			poppedElement = this.array[0];
			System.arraycopy(this.array, 1, newArray, 0, this.array.length - 1);
		} else {
			if (index < 0) {
				int indexNew = (this.array.length) - (index * -1);
				if (indexNew != this.array.length - 1) {
					poppedElement = this.array[indexNew];
					System.arraycopy(this.array, 0, newArray, 0, indexNew);
					System.arraycopy(this.array, indexNew + 1, newArray, indexNew, this.array.length - indexNew - 1);
				} else {
					if (indexNew == 0) {
						poppedElement = this.array[0];
						System.arraycopy(this.array, 1, newArray, 0, this.array.length - 1);
					} else {
						poppedElement = this.array[this.array.length - 1];
						System.arraycopy(this.array, 0, newArray, 0, this.array.length - 1);
					}
				}
			} else {
				if (index == this.array.length - 1) {
					System.arraycopy(this.array, 0, newArray, 0, this.array.length - 1);
				} else {
					System.arraycopy(this.array, 0, newArray, 0, index);
					System.arraycopy(this.array, index + 1, newArray, index, this.array.length - index - 1);
				}
				poppedElement = this.array[index];

			}
		}
		this.array = newArray;
		return poppedElement;

	}
	
	/**
	 * Appends an element to the array.
	 * 
	 * @param stringToAppend A value, that is appended to the array
	 */
	public void append(String stringToAppend) {
		String[] newArray = new String[this.array.length + 1];
		System.arraycopy(this.array, 0, newArray, 0, this.array.length);
		newArray[newArray.length - 1] = stringToAppend;
		this.array = newArray;
	}

}
