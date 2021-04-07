import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseAdministration {
    static BufferedReader br;
    static Scanner keyboard = new Scanner(System.in);

    // TODO EJ
    protected static List<Course> parseCSV () {
        ArrayList<Course> courseList = new ArrayList<>();
        String line;
        try {
            br = new BufferedReader(new FileReader("BSCSCurriculumData1WithGrades.csv"));
            br.readLine();
            while ((line = br.readLine()) != null) {
                // Split on comma
                String[] courseCSV = line.split(",");
                if (courseCSV.length < 6) courseCSV = buildArray(line.split(","));
                // Create course object to store values
                Course courseTemp = new Course();
                // add values from csv to Course object
                courseTemp.setYear(Byte.parseByte(courseCSV[0]));
                courseTemp.setTerm(Byte.parseByte(courseCSV[1]));
                courseTemp.setCourseNumber(courseCSV[2]);
                courseTemp.setDescriptiveTitle(courseCSV[3]);
                courseTemp.setUnits(Double.parseDouble(courseCSV[4]));
                if (courseCSV[5].equals("")) courseTemp.setGrades(0);
                else courseTemp.setGrades(Double.parseDouble(courseCSV[5]));
                courseList.add(courseTemp);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found.");
        } catch (IOException ioException) {
            System.out.println("I/O error: " + ioException);
        }
        return courseList;
    }

    private static String[] buildArray(String[] csvLine) {
        ArrayList<String> courseInfo = new ArrayList<String>(Arrays.asList(csvLine));
        int size = 6 - courseInfo.size();
        for (int i = 0; i < size; i++) {
            courseInfo.add("");
        }
        // System.out.println(courseInfo.toString());
        return courseInfo.toArray(new String[6]);
    }

    // TODO EJ
    // Implement if parseCSV() does not have a case
    // for a CSV file with grades
    protected static List<Course> parseCSVWithGrades() {
        ArrayList<Course> c = new ArrayList<Course>();
        return c;
    }

    // TODO Jomari
    // Implement two cases: ascending and descending
    // NOTE: THIS METHOD DOES NOT DISPLAY THE COURSES
    // THIS METHOD JUST REARRANGES AN EXISTING COURSE LIST
    // KEEPING THE CONTENTS OF AN ARRAYLIST INTACT
    private static List<Course> sortCoursesByGPA(int key) {
        ArrayList<Course> c = new ArrayList<Course>();
        switch(key) {
        }
        return c;
    }

    // TODO Adi
    // Implement similar to the showCourses() method
    // Print only to the console if the Course
    // has a failing grade
    // PRINT OUTPUTS ONLY, DO NOT MANIPULATE THE ARRAYLIST
    private static void showFailedCourses(List<Course> courseList) {
        System.out.println("FAILED COURSES");
        System.out.printf("%-15s %-50s %-5s\n", "COURSE NO.", "COURSE DESCRIPTION", "GRADE");
        for (Course c: courseList) {
            if (hasFailedCourse(c))
                System.out.printf("%-15s %-50s %-5d", c.getCourseNumber(), c.getDescriptiveTitle(), c.getGrades());
        }
    }

    // TODO Andre
    // Read the project specification, specifically items
    // Two and Three
    private static void shiftCourse(Course course) {
        
    }

    // TODO Enrico
    private static List<Course> inputGrades() {
        ArrayList<Course> c = new ArrayList<Course>();
        return c;
    }

    // TODO Jerome
    // Check if the passed parameter
    // has a failing grade
    // HINT: Check for the instance variable called "grades"
    private static boolean hasFailedCourse(Course course) {
        boolean failed = false;
        double grade = course.getGrades();
        if (grade<75){
            failed = true;
        }
        return failed;
    }

    // TODO Kurt
    private static void showIntroduction() {
        System.out.println("Welcome to the Course Administration program!");
        System.out.println("See menu below for available operations.");
        System.out.println();
    }

    // TODO Andre
    // The menu pertains to the "Checklist Management"
    // Method showCourses() is responsible for displaying
    // courses
    private static void showMenu() {
        // note: I saw text blocks in the previous program, and I want to try that
        System.out.println("""
            -------------------------------------------------
             My Checklist Management
             <1> Show subjects for each school term
             <2> Show subjects with grades for each term
             <3> Enter grades for subjects recently finished
             <4> Edit a course
             <5> Quit
            -------------------------------------------------
            """);
    }

    // TODO Enrico
    // Prints a formatted result similar to what is
    // Displayed in the course specification
    // PRINT OUTPUTS ONLY, DO NOT MANIPULATE THE ARRAYLIST
    private static void showCourses(List<Course> courseList) {
        System.out.println("COURSES");
        System.out.printf("%-15s %-50s %-5s\n", "COURSE NO.", "COURSE DESCRIPTION", "GRADE");
        for (Course c:courseList)
            System.out.println(c.toString());
    }

    // TODO Adi
    // Edit a course's descriptive title and course number
    private static void editCourse(ArrayList<Course> courseList) {
        System.out.print("Enter course number to be changed (ex. CS122): ");
        String courseNumberToChange = keyboard.nextLine();
        for (int i = 0; i < courseList.size(); i++) {
            String cN = courseList.get(i).getCourseNumber();
            if (cN.compareToIgnoreCase(courseNumberToChange) == 0) {
                System.out.print("Enter the new course number: ");
                String newCN = keyboard.nextLine();
                System.out.print("Enter the new descriptive title: ");
                String newTitle = keyboard.nextLine();
                courseList.get(i).setCourseNumber(newCN);
                courseList.get(i).setDescriptiveTitle(newTitle);
                break;
            }
        }
    }

    // TODO EJ
    // Method for accepting byte input
    // Used for inputting Year and Term
    // inputted by the user
    // handle exceptions locally (do not use a throws clause!)
    private static byte acceptByteInput() {
        byte userInput = 0;
        try{
            System.out.println("Input(Byte): ");
            userInput = keyboard.nextByte();
        } catch(NumberFormatException e) {
            System.out.println("Out of bounds! " +e);
        }
        return userInput;
    }

    // TODO Jerome
    // Method for accepting integer input
    // Used for inputting Grades
    // for searching the ArrayList for grades
    // inputted by the user
    // and for navigating the menu
    // handle exceptions locally (do not use a throws clause!)
    private static int acceptIntegerInput() {
        int input = 0;
        boolean t = false;
        while (!t) {
            try {
                System.out.println("Enter an integer: ");
                input = Integer.parseInt(keyboard.nextLine());
                t = true;
            } catch (NumberFormatException exception) {
                System.out.println("You entered an invalid integer.");
            }
        }
        return input;
    }

    // TODO Jomari
    // Method for accepting integer input
    // Used for inputting Grades
    // and for searching the ArrayList for grades
    // inputted by the user
    // handle exceptions locally (do not use a throws clause!)
    private static double acceptDoubleInput() {
        return 0.0;
    }

    // TODO Kurt
    // Method for accepting String input
    // Usually for editing a course's descriptive title
    // Or if searching for a course
    private static String acceptStringInput() {
        String userInput = null;
        while(true) {
            System.out.print("User Input: ");
            userInput = keyboard.nextLine();
            if (userInput != null) return userInput;
        }
    }

    // TODO Jerome
    public static void main (String[] args) {
        ArrayList<Course> courseList = new ArrayList<>();
        showIntroduction();
        showMenu();
        byte choice = 0;
        do { // validates the input
            try {
                System.out.print("Enter a number: ");
                choice = Byte.parseByte(keyboard.nextLine());
                if (choice < 1 || choice > 9)
                    System.out.println("The number must be from 1 to 5.");
            } catch (NumberFormatException x) {
                System.out.println("You entered an invalid integer. Please enter integer:");
            }
        } while (choice < 1 || choice > 5);

        parseCSV();
    }
}