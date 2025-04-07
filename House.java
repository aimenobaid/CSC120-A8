import java.util.*;
/**
 * The House class represents a residential building where students can live.
 * It extends the Building class and keeps track of student residents and whether it has a dining room.
 */

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for House without elevator.
   * 
   * @param name          name of the house
   * @param address       street address
   * @param nFloors       number of floors
   * @param hasDiningRoom whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Constructs a House with both dining room and elevator options.
   *
   * @param name           the name of the house
   * @param address        the street address of the house
   * @param nFloors        the number of floors
   * @param hasDiningRoom  true if the house has a dining room
   * @param hasElevator    true if the house has an elevator
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }


  /**
   * Checks if the house has a dining room.
   *
   * @return true if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns the number of residents in the house.
   *
   * @return the number of residents
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Moves a student into the house.
   * 
   * @param s The student moving in.
   */
  public void moveIn(Student s) {
    if (!this.residents.contains(s)) {
      this.residents.add(s);
    }
  }

  /**
   * Moves a student out of the house.
   * 
   * @param s The student moving out.
   * @return  The student who moved out.
   */
  public Student moveOut(Student s) {
    if (this.residents.remove(s)) {
      return s;
    }
    return null;
  }

  /**
   * Checks if a student is a resident.
   * 
   * @param s The student to check.
   * @return  True if the student is a resident, false otherwise.
   */
  public boolean isResident(Student s) {
    return this.residents.contains(s);
  }

  @Override
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(Student s)\n + moveOut(Student s)\n + isResident(Student s)\n + nResidents()\n + hasDiningRoom()");
  }

  /**
   * Overrides goToFloor to only allow elevator travel if elevator is present.
   * 
   * @param floorNum target floor number
   */
  @Override
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("Enter the building first.");
    }
    if (!this.hasElevator && Math.abs(floorNum - this.activeFloor) > 1) {
      throw new RuntimeException("No elevator! Use stairs to go one floor at a time.");
    }
    super.goToFloor(floorNum);
  }

  /**
   * Overloaded moveIn method: creates Student from name, id, year.
   *  
   * @param name   the student's name
   * @param id     the student's ID
   * @param year   the student's class year
   */
  public void moveIn(String name, String id, int year) {
    Student newStudent = new Student(name, id, year);
    this.moveIn(newStudent);
  }

  /**
   * Overloaded moveOut method: removes student by name.
   *
   * @param name the student's name
   * @return the removed student, or null if not found
   */
  public Student moveOut(String name) {
    for (Student s : this.residents) {
      if (s.getName().equals(name)) {
        return moveOut(s);
      }
    }
    return null;
  }

  /**
   * For testing the House class.
   */
  public static void main(String[] args) {
    House chase = new House("Chase House", "1 Paradise Rd", 3, true, true);
    chase.enter();
    chase.goToFloor(3);
    chase.moveIn("Alex", "12345", 2026);
    System.out.println("Residents:"+ chase.nResidents());
    chase.goToFloor(1);
    chase.moveOut("Alex");
    System.out.println("Residents:"+ chase.nResidents());
    chase.exit();
  }
}