import java.util.ArrayList;

public class CampusMap {

    private ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " from the map.");
        return b;
    }

    /**
     * Returns the number of buildings in the map
     * @return the number of buildings
     */
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        // Add basic buildings
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court", 4));

        // Add a library
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Dr", 5, true));

        // Add a house with elevator
        House chase = new House("Chase House", "1 Paradise Rd", 3, true, true);
        chase.moveIn("Zara", "z101", 2025);
        myMap.addBuilding(chase);

        // Add a house without elevator
        House gardiner = new House("Gardiner House", "9 Prospect St", 2, true);
        gardiner.moveIn("Leah", "l505", 2026);
        myMap.addBuilding(gardiner);

        // Add a cafe
        Cafe compass = new Cafe("Compass Cafe", "42 Elm St", 1, 80, 40, 40, 25);
        myMap.addBuilding(compass);

        // Add more buildings
        myMap.addBuilding(new Library("Young Library", "5 Library Ln", 3, false));
        myMap.addBuilding(new Cafe("Campus Coffee", "88 Main St", 1, 60, 30, 30, 20));
        myMap.addBuilding(new House("Morris House", "2 Paradise Rd", 4, false, true));
        myMap.addBuilding(new Building("Seelye Hall", "10 College Ln", 3));

        System.out.println("\n" + myMap);
    }
}
