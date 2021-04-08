import jdk.jfr.Description;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CourseAdministration {
    static BufferedReader br;
    static Scanner keyboard = new Scanner(System.in);

    protected static ArrayList<Course> parseCSV () {
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
    private static ArrayList<Course> sortCoursesByGPA(int key){
        ArrayList<Course> c = new ArrayList<Course>();

        switch(key) {
          case 1:
            // ascending arranged
            // c.sort();
            break;
        case 2:
            //descending arraged
            // c.sort();
            break;
        }
        return c;
    }

    private static void showFailedCourses(ArrayList<Course> courseList) {
        System.out.println("FAILED COURSES");
        System.out.printf("%-15s %-50s %-5s\n", "COURSE NO.", "COURSE DESCRIPTION", "GRADE");
        for (Course c: courseList) {
            if (hasFailedCourse(c))
                System.out.printf("%-15s %-50s %-5.2f\n", c.getCourseNumber(), c.getDescriptiveTitle(), c.getGrades());
        }
    }

    // TODO Andre
    // Read the project specification, specifically items
    // Two and Three
    private static void shiftCourse(ArrayList<Course> course) {
        // note: compareTo
        // note: shift from another program?
        
    }

    // TODO Enrico
    private static ArrayList<Course> inputGrades() {
        ArrayList<Course> c = new ArrayList<Course>();
        return c;
    }

    private static boolean hasFailedCourse(Course course) {
        boolean failed = false;
        double grade = course.getGrades();
        if (grade < 75 && grade != 0){
            failed = true;
        }
        return failed;
    }

    private static void showIntroduction() {
        System.out.println("Welcome to the Course Administration program!");
        System.out.println("See menu below for available operations.");
        System.out.println();
    }

    private static void showMenu() {
        // note: I saw text blocks in the previous program, and I want to try that
        System.out.println("""
            -------------------------------------------------
             My Checklist Management
             <1> Show subjects for each school term
             <2> Show subjects with grades for each term
             <3> Show elective subjects only
             <4> Show failed courses
             <5> Enter grades for subjects recently finished
             <6> Edit a course
             <7> Shift from another program
             <8> Quit
            -------------------------------------------------
            """);
    } 

    // TODO Enrico
    // Prints a formatted result similar to what is
    // Displayed in the course specification
    // PRINT OUTPUTS ONLY, DO NOT MANIPULATE THE ARRAYLIST
    private static void showCourses(ArrayList<Course> courseList) {
        System.out.println("COURSES");
        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.","COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c:courseList)
            System.out.println(c.toString());
    }

    // TODO Adi
    // Specifications similar to the showCourses() method,
    // However this method prints only courses with a GPA
    private static void showCoursesWithGrades(ArrayList<Course> courseList) {
        System.out.println("COURSES WITH GRADES");

    }

    // TODO KURT
    // Show only elective courses
    private static void showElectiveCourses(ArrayList<Course> courseList) {

    }

    // TODO KURT
    // Similar to editCourse
    // Print courses that have no GPA yet
    // Then allow user to select from that list
    private static void inputGrades(ArrayList<Course> courseList) {

    }

    private static void editCourse(ArrayList<Course> courseList) {
        System.out.print("Enter course number to be changed (ex. CS122): ");
        String courseNumberToChange = keyboard.nextLine();
        for (int i = 0; i < courseList.size(); i++) {
            String cN = courseList.get(i).getCourseNumber();
            if (cN.compareToIgnoreCase(courseNumberToChange) == 0) {
                System.out.print("Enter the new course number: ");
                String newCN = acceptStringInput();
                System.out.print("Enter the new descriptive title: ");
                String newTitle = acceptStringInput();
                courseList.get(i).setCourseNumber(newCN);
                courseList.get(i).setDescriptiveTitle(newTitle);
                break;
            }
        }
    }

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
    private static double acceptDoubleInput(int n) {
        
        return 0.0;
    }

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
        ArrayList<Course> courseList = parseCSV();
        showIntroduction();
        showMenu();
        byte choice = 0;
        do { // validates the input
            try {
                System.out.print("Enter a number: ");
                choice = Byte.parseByte(keyboard.nextLine());
                if (choice < 1 || choice > 8)
                    System.out.println("The number must be from 1 to 8.");
                switch(choice){
                    case 1:
                    showCourses(courseList);
                    break;
                    case 2:
                    showCoursesWithGrades(courseList);
                    break;
                    case 3:
                    showElectiveCourses(courseList);
                    break;
                    case 4:
                    showFailedCourses(courseList);
                    break;
                    case 5:
                    inputGrades();
                    break;
                    case 6:
                    editCourse(courseList);
                    break;
                    case 7:
                    shiftCourse(courseList);
                    break;
                }
            } catch (NumberFormatException x) {
                System.out.println("You entered an invalid integer.");
            }
        } while (choice != 8);
    }
}