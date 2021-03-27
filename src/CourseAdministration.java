import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CourseAdministration {
    static BufferedReader br;

    // TODO EJ
    protected static List<Course> parseCSV () {
        List<Course> courseList = null;
        String line;
        try {
            br = new BufferedReader(new FileReader("BSCSCurriculumData1WithGrades.csv"));
            while ((line = br.readLine()) != null) {
                // Split on comma
                String[] courseCSV = line.split(",");
                // Create course object to store values
                Course courseTemp = new Course();
                // add values from csv to Course object
                courseTemp.setYear(Byte.parseByte(courseCSV[0]));
                courseTemp.setTerm(Byte.parseByte(courseCSV[1]));
                courseTemp.setCourseNumber(courseCSV[2]);
                courseTemp.setDescriptiveTitle(courseCSV[3]);
                courseTemp.setUnits(Double.parseDouble(courseCSV[4]));
                // TODO add a conditional statement for when the the grade cell is blank
                courseTemp.setGrades(Double.parseDouble(courseCSV[5]));
                courseList.add(courseTemp);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found.");
        } catch (IOException ioException) {
            System.out.println("I/O error: " + ioException);
        }
        return courseList;
    }

    // TODO EJ
    // Implement if parseCSV() does not have a case
    // for a CSV file with grades
    protected static List<Course> parseCSVWithGrades() {
    }

    // TODO Jomari
    // Implement two cases: ascending and descending
    // NOTE: THIS METHOD DOES NOT DISPLAY THE COURSES
    // THIS METHOD JUST REARRANGES AN EXISTING COURSE LIST
    // KEEPING THE CONTENTS OF AN ARRAYLIST INTACT
    private static List<Course> sortCoursesByGPA(int key) {
        switch(key) {
        }
    }

    // TODO Adi
    // Implement similar to the showCourses() method
    // Print only to the console if the Course
    // has a failing grade
    // PRINT OUTPUTS ONLY, DO NOT MANIPULATE THE ARRAYLIST
    private static void showFailedCourses(List<Course> courseList) {

    }

    // TODO Andre
    // Read the project specification, specifically items
    // Two and Three
    private static void shiftCourse(Course course) {

    }

    // TODO Enrico
    private static List<Course> inputGrades() {
    }

    // TODO Jerome
    // Check if the passed parameter
    // has a failing grade
    // HINT: Check for the instance variable called "grades"
    private static boolean hasFailedCourse(Course courseList) {

    }

    // TODO Kurt
    private static void showIntroduction() {

    }

    // TODO Andre
    // The menu pertains to the "Checklist Management"
    // Method showCourses() is responsible for displaying
    // courses
    private static void showMenu() {

    }

    // TODO Enrico
    // Prints a formatted result similar to what is
    // Displayed in the course specification
    // PRINT OUTPUTS ONLY, DO NOT MANIPULATE THE ARRAYLIST
    private static void showCourses(List<Course> courseList) {

    }

    // TODO Adi
    // Edit a course's descriptive title and course number
    private static void editCourse(List<Course> courseList) {

    }

    // TODO EJ
    // Method for accepting byte input
    // Used for inputting Year and Term
    // inputted by the user
    // handle exceptions locally (do not use a throws clause!)
    private static byte acceptByteInput() {

    }

    // TODO Jerome
    // Method for accepting integer input
    // Used for inputting Grades
    // for searching the ArrayList for grades
    // inputted by the user
    // and for navigating the menu
    // handle exceptions locally (do not use a throws clause!)
    private static int acceptIntegerInput() {

    }

    // TODO Jomari
    // Method for accepting integer input
    // Used for inputting Grades
    // and for searching the ArrayList for grades
    // inputted by the user
    // handle exceptions locally (do not use a throws clause!)
    private static double acceptDoubleInput() {

    }

    // TODO Kurt
    // Method for accepting String input
    // Usually for editing a course's descriptive title
    // Or if searching for a course
    private static String acceptStringInput() {

    }

    // TODO Jerome
    public static void main (String[] args) {
        List<Course> courseList = new ArrayList<>();
        System.out.println(courseList);
    }
}