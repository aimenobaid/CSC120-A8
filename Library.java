import java.util.*;

/**
 * The Library class represents a library building that stores a collection of books.
 * It extends the Building class and manages the availability of titles.
 */

public class Library extends Building implements LibraryRequirements{

  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
  * Constructs a new Library.
  * 
  * @param name    The name of the library.
  * @param address The address of the library.
  * @param nFloors The number of floors in the library.
  */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    this.hasElevator = true;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Constructs a Library with a user-defined elevator setting.
   *
   * @param name        the name of the library
   * @param address     the address of the library
   * @param nFloors     the number of floors
   * @param hasElevator true if elevator is available
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(String)\n + removeTitle(String)\n + checkOut(String)\n + returnBook(String)\n + containsTitle(String)\n + isAvailable(String)\n + printCollection()");
  }

   /**
   * Moves to a specified floor, only allowing jumps if elevator is present.
   *
   * @param floorNum the desired floor number
   */
  @Override
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You must enter the library first.");
    }
    if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
      throw new RuntimeException("This library has no elevator. You must move one floor at a time.");
    }
    super.goToFloor(floorNum);
  }

  /**
  * Adds a new title to the library's collection.
  * 
  * @param title The title of the book to add.
  */
  public void addTitle(String title) {
    collection.put(title, true); // Mark the book as available (true)
  }

  /**
  * Removes a title from the library's collection.
  * 
  * @param title The title of the book to remove.
  * @return The title that was removed.
  */
  public String removeTitle(String title) {
    collection.remove(title);
    return title;
  }

  /**
  * Checks out a book, marking it as unavailable.
  * 
  * @param title The title of the book to check out.
  */
  public void checkOut(String title) {
    if (collection.containsKey(title)) {
      collection.put(title, false); // Mark the book as unavailable (false)
    }
  }

  /**
  * Returns a book, marking it as available again.
  * 
  * @param title The title of the book to return.
  */
  public void returnBook(String title) {
    if (collection.containsKey(title)) {
      collection.put(title, true); // Mark the book as available (true)
    }
  }

  /**
  * Checks if the library contains a specific title.
  * 
  * @param title The title to check.
  * @return True if the title is in the collection, false otherwise.
  */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
  * Checks if a specific title is available.
  * 
  * @param title The title to check.
  * @return True if the book is available, false if it is checked out.
  */
  public boolean isAvailable(String title) {
    return collection.getOrDefault(title, false);
  }

  /**
  * Prints out the entire collection of books and their availability.
  */
  public void printCollection() {
    for (String title : collection.keySet()) {
      System.out.println(title + " - " + (collection.get(title) ? "Available" : "Checked out"));
    }
  }

    /**
   * Overloaded method: adds an array of titles.
   *
   * @param titles array of book titles
   */
  public void addTitle(String[] titles) {
    for (String t : titles) {
      this.addTitle(t);
    }
  }

  /**
   * Overloaded method: checks out an array of titles.
   *
   * @param titles array of book titles
   */
  public void checkOut(String[] titles) {
    for (String t : titles) {
      this.checkOut(t);
    }
  }

  /**
  * For testing the Library class.
  */
  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "7 Neilson Dr", 5, true);
    neilson.enter();
    neilson.goToFloor(4);
    neilson.addTitle(new String[]{"1984", "Dune", "Beloved"});
    neilson.printCollection();
    neilson.checkOut("1984");
    neilson.printCollection();
    System.out.println("Available? " + neilson.isAvailable("1984")); // should be false
    neilson.goToFloor(1);
    neilson.exit();
  }
}
