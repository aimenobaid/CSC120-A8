Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
House.java

moveIn(String name, String id, int classYear): This lets us quickly add a student without needing to construct a Student object beforehand. It’s more user-friendly for testing and future code reuse.

moveOut(String name): Allows removal of a student by name alone, which is a practical shortcut when student objects aren’t easily referenced.

Library.java

addTitle(String[] titles): Allows adding multiple books at once for faster testing and bulk operations.

checkOut(String[] titles): Similar to the above, this lets you check out many books in one command.

Cafe.java

sellCoffee(int size): Assumes 1 sugar and 1 cream by default, reducing repetition.

restock(): A default restock method similar to the default sellCoffee one above.

These overloads make the classes more usable and extensible without duplicating logic.

- What worked, what didn't, what advice would you give someone taking this course in the future?

What worked well?

Using super effectively let us reuse logic from the Building class without rewriting core navigation methods.

The showOptions() overrides made it clear how each building subclass differs and helps anyone using the classes.

Constructor overloading gave us flexibility to build objects with minimal or complete data.

What didn’t work or needed rethinking?

At first, constructor chaining caused errors because of improper ordering — you can’t call an overloaded constructor that hasn’t been defined yet.

Java's default .equals() caused confusion with the isResident() method in House — two students with the same info weren’t equal unless they were the same object. I worked around this by storing the reference and not constructing new Student objects for checks.

Advice for future students

Follow the rubric closely and make sure every requirement is explicitly demonstrated.

Test every class with realistic scenarios — especially method overriding — and don’t skip writing main() methods.

Be very careful when chaining constructors. Define the full one first if you’re going to call it from a simpler one.

When something behaves weirdly (like contains() or == not working), it’s probably because of how Java handles object identity vs. value equality.