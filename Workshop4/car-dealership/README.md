# Rivera Auto Sales

This is my Car Dealership workshop for Year Up United. It’s a Java console
app that an employee can use to search for vehicles, add them to the
inventory, and remove them.

## What It Does

- Searches by price, make and model, year, color, mileage, and vehicle type
- Lists all vehicles in the inventory
- Adds vehicles and checks for duplicate VINs
- Asks for confirmation before removing a vehicle
- Saves changes to inventory.csv after adding or removing vehicles
- Loads the saved inventory when the program starts

## Classes

- Vehicle stores the details for one vehicle.
- Dealership holds the inventory and handles searches, additions, and removals.
- DealershipFileManager reads and writes the inventory file.
- UserInterface handles the menu, user input, and printed results.
- Program starts the app.

## How to Run

1. Open the car-dealership project in IntelliJ.
2. Use Java 17 and let Maven load.
3. Set the working directory to the car-dealership folder.
4. Run Program.java.
5. Choose an option from the menu. Enter 99 to quit.

For prices and mileage, enter numbers without commas or dollar signs.
This workshop uses whole numbers for VINs.

## Files

inventory.csv stores the dealership information on the first line
and the vehicles on the remaining lines. The values are separated by |.

inventory-backup.csv is a copy of the original data.

## What I Learned

I practiced giving each class its own responsibility and using loops
and conditions to find matching vehicles. I also worked on reading
data from a file and saving changes so they are still there when
the program runs again.