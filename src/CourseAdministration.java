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
        ArrayList<String> courseInfo = new ArrayList<>(Arrays.asList(csvLine));
        int size = 6 - courseInfo.size();
        for (int i = 0; i < size; i++) {
            courseInfo.add("");
        }
        // System.out.println(courseInfo.toString());
        return courseInfo.toArray(new String[6]);
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

    // TODO Enrico
    // Prints a formatted result similar to what is
    // Displayed in the course specification
    // PRINT OUTPUTS ONLY, DO NOT MANIPULATE THE ARRAYLIST
    private static void showCourses(ArrayList<Course> courseList) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t      COURSES");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.","COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c:courseList)
            System.out.println(c.toString());
    }

    private static void showFailedCourses(ArrayList<Course> courseList) {
        System.out.println("FAILED COURSES");

        int y = 1, t = 1;
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.","COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c: courseList)
            if (hasFailedCourse(c))
                System.out.println(c.toString());
        System.out.println(t);
    }

    private static void displayHeader(int y, int t) {
        switch (y) {
            case 1:
                switch (t) {
                    case 1:

                        System.out.println("""
                                ------------------------------------------------------------------------------------------------ 
                                Year = First Year Term = First Semester
                                """);
                        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.","COURSE DESCRIPTION", "UNITS", "GRADE");
                        break;
                }
                break;
            case 2:
                break;
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
        return course.getGrades() < 75 && course.getGrades() != 0;
    }

    private static void showIntroduction() {
        System.out.println("Welcome to the Course Administration program!");
        System.out.println("See menu below for available operations.");
        System.out.println();
    }

    private static void showMenu() {
        System.out.println("""
            =================================================
             My Checklist Management
             <1> Show subjects for each school term
             <2> Show subjects with grades for each term
             <3> Show elective subjects only
             <4> Show failed courses
             <5> Enter grades for subjects recently finished
             <6> Edit a course
             <7> Shift from another program
             <8> Quit
            =================================================
            """);
    }



    // TODO Adi
    // Specifications similar to the showCourses() method,
    // However this method prints only courses with a GPA
    private static void showCoursesWithGrades(ArrayList<Course> courseList) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   COURSES WITH GRADES");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.","COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c:courseList) {
            if (c.getGrades() > 0)
                System.out.println(c.toString());
        }
    }

    // TODO KURT
    // Show only elective courses
    // DONE, TEST CODE PLS
    private static void showElectiveCourses(ArrayList<Course> courseList) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ELECTIVE COURSES");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.","COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c : courseList)
            if (c.getIsElective())
                System.out.println(c.toString());
    }

    private static void showCoursesWithoutGPA(ArrayList<Course> courseList) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   SHOWING COURSES WITHOUT GPA");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.","COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c : courseList)
            if (c.getGrades() != 0.0)
                System.out.println(c.toString());

    }

    private static Course searchCourseList(ArrayList<Course> courseList,
                                           String searchKey) {
        for (Course course : courseList) {
            if (course.getCourseNumber().equalsIgnoreCase(searchKey))
                return course;
        }
        return new Course();
    }

    // TODO KURT
    // Similar to editCourse
    // Print courses that have no GPA yet
    // Then allow user to select from that list
    private static void inputGrades(ArrayList<Course> courseList) {
        Course selectedCourse;
        String searchKey;
        do {
            showCoursesWithoutGPA(courseList);
            searchKey = acceptStringInput("Enter a course number: ");
            selectedCourse = searchCourseList(courseList, searchKey);
            if (selectedCourse.getCourseNumber().equals(""))
                System.out.println("Invalid Course Number inputted. Try again.");
        } while (selectedCourse.getCourseNumber().equals(""));
        selectedCourse.setGrades(acceptDoubleInput("Input GPA: "));
    }

    private static void editCourse(ArrayList<Course> courseList) {
        System.out.print("Enter course number to be changed (ex. CS122): ");
        String courseNumberToChange = keyboard.nextLine();
        for (int i = 0; i < courseList.size(); i++) {
            String cN = courseList.get(i).getCourseNumber();
            if (cN.compareToIgnoreCase(courseNumberToChange) == 0) {
                String newCN = acceptStringInput("Enter the new course number: ");
                String newTitle = acceptStringInput("Enter the new descriptive title: ");
                courseList.get(i).setCourseNumber(newCN);
                courseList.get(i).setDescriptiveTitle(newTitle);
                break;
            }
        }
    }

    private static byte acceptByteInput(String message) {
        byte input = 0;
        while (true) {
            try {
                input = Byte.parseByte(acceptStringInput(message));
            } catch (NumberFormatException exception) {
                System.out.println("You entered an invalid integer.");
            }
            return input;
        }
    }

    private static int acceptIntegerInput(String message) {
        int input = 0;
        while (true) {
            try {
                input = Integer.parseInt(acceptStringInput(message));
            } catch (NumberFormatException exception) {
                System.out.println("You entered an invalid integer.");
            }
            return input;
        }
    }

    // TODO Jomari
    // FINISHED BY: Kurt
    // Do your assigned work next time, wag pabigat :) - Kurt
    // Method for accepting integer input
    // Used for inputting Grades
    // and for searching the ArrayList for grades
    // inputted by the user
    // handle exceptions locally (do not use a throws clause!)
    private static double acceptDoubleInput(String message) {
        Double input = 0.0;
        while (true) {
            try {
                input = Double.parseDouble(acceptStringInput(message));
            } catch (NumberFormatException e) {
                System.out.println("You entered an invalid Double value.");
            }
            return input;
        }
    }

    private static String acceptStringInput(String message) {
        String userInput;
        while(true) {
            System.out.print(message);
            userInput = keyboard.nextLine();
            if (userInput != null) return userInput;
        }
    }

    private static void inputBuffer() {
        System.out.println();
        System.out.print("Press enter key to see courses for the next term.");
        keyboard.nextLine();
        System.out.println();
    }

    // TODO Jerome
    public static void main (String[] args) {
        ArrayList<Course> courseList = parseCSV();
        showIntroduction();
        showMenu();
        byte choice = 0;
        do { // validates the input
            try {
                choice = acceptByteInput("Select an item: ");
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
                        inputGrades(courseList);
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