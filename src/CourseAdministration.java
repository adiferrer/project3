import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CourseAdministration {
    static BufferedReader br;
    static Scanner keyboard = new Scanner(System.in);

    /**
     * TODO: EJ
     */
    protected static ArrayList<Course> parseCSV() {
        ArrayList<Course> courseList = new ArrayList<>();
        String line;
        try {
            br = new BufferedReader(new FileReader("BSCSCurriculumData1WithGradesCopy.csv"));
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

    /**
     * TODO: EJ
     */
    private static String[] buildArray(String[] csvLine) {
        ArrayList<String> courseInfo = new ArrayList<>(Arrays.asList(csvLine));
        int size = 6 - courseInfo.size();
        for (int i = 0; i < size; i++) {
            courseInfo.add("");
        }
        // System.out.println(courseInfo.toString());
        return courseInfo.toArray(new String[6]);
    }

    /**
     * TODO: EJ
     */
    private static void saveChangesToFile(ArrayList<Course> courseList) {
        String decision = "x";
        String line;
        System.out.println("The changes will be permanent. Are you sure? Y/N");
        decision = keyboard.nextLine();
        if (decision.equals("Y") || decision.equals("y")) {
            try {
                for (Course c : courseList) System.out.println(c);

                PrintWriter outputWriter =
                        new PrintWriter(new FileWriter("BSCSCurriculumData1WithGradesCopy.csv"));
                for (int i = 0; i < courseList.size(); i++) outputWriter.println(courseList.get(i));
                outputWriter.close();
            } catch (IOException ioException) {
                System.out.println("I/O error: " + ioException);
            }
        } else {
            System.out.println("The changes were not saved.");
        }
    }

    /**
     * TODO: EJ
     */
    private static void displayHeaderWithGrades(int year, int term) {
        switch (year) {
            case 1:
                switch (term) {
                    case 1 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = First Year\tTerm = First Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = First Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = First Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                }
                break;
            case 2:
                switch (term) {
                    case 1 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Second Year\tTerm = First Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Second Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Second Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                }
                break;
            case 3:
                switch (term) {
                    case 1 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Third Year\tTerm = First Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Third Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Third Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                }
                break;
            case 4:
                switch (term) {
                    case 1 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fourth Year\tTerm = First Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fourth Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fourth Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                }
                break;
            case 5:
                switch (term) {
                    case 1 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fifth Year\tTerm = First Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fifth Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fifth Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                }
                break;
        }
    }

    /**
     * TODO: EJ
     */
    private static void termBuffer() {
        System.out.println();
        System.out.print("Press enter key to see courses for the next term.");
        keyboard.nextLine();
        System.out.println();
    }

    // TODO Enrico
    // refer to showCoursesWithGrades to show courses per term

    /**
     * TODO: Enrico
     */
    private static void showCourses(ArrayList<Course> courseList) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t      COURSES");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c : courseList)
            System.out.println(c);
    }

    /**
     * This method displays the student's failed courses.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1) Create an ArrayList wherein courses with failing grades are added. <br>
     * 2) Get the highest number of years and terms per year in the curriculum. <br>
     * 3) Display courses with failing grades for each term.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void showFailedCourses(ArrayList<Course> courseList) {
        ArrayList<Course> courseListCopy = new ArrayList<Course>();
        int highestYear = 1, highestTerm = 1;
        for (Course c : courseList) {
            if (c.getGrades() != 0) {
                highestYear = c.getYear();
                highestTerm = c.getTerm();
                courseListCopy.add(c);
            }
        }

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t      FAILED COURSES");
        for (int y = 1; y <= highestYear; y++) {
            for (int t = 1; t <= highestTerm; t++) {
                displayHeaderWithGrades(y, t);
                for (Course c : courseListCopy) {
                    if (c.getYear() == y && c.getTerm() == t) {
                        if (hasFailedCourse(c)) System.out.println(c);
                    } else {
                        termBuffer();
                        break;
                    }
                }
            }
        }
    }

    /**
     * TODO: Andre
     */
    // TODO Andre
    protected static ArrayList<Course> parseShifterCSV() {
        ArrayList<Course> shifterCourseList = new ArrayList<>();
        String l;
        try {
            br = new BufferedReader(new FileReader("ShifterData.csv"));
            br.readLine();
            while ((l = br.readLine()) != null) {
                String[] cSV = l.split(",");
                if (cSV.length < 6) cSV = buildArray(l.split(","));
                Course cTemp = new Course();
                cTemp.setYear(Byte.parseByte(cSV[0]));
                cTemp.setTerm(Byte.parseByte(cSV[1]));
                cTemp.setCourseNumber(cSV[2]);
                cTemp.setDescriptiveTitle(cSV[3]);
                cTemp.setUnits(Double.parseDouble(cSV[4]));
                if (cSV[5].equals("")) cTemp.setGrades(0);
                else cTemp.setGrades(Double.parseDouble(cSV[5]));
                shifterCourseList.add(cTemp);
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        return shifterCourseList;
    }

    /**
     * TODO: Andre
     */
    private static void shiftCourse(ArrayList<Course> courseList) {
        ArrayList<Course> shifterCourseList = parseShifterCSV();
        char shiftChoice;

        System.out.print("Are you sure you want to shift courses?(y/n): ");
        shiftChoice = keyboard.next().charAt(0);

        if (shiftChoice != 'y' && shiftChoice != 'Y') {
            System.out.println();
            showMenu();
            return;
        }

        for (Course sC : shifterCourseList) {
            for (Course c : courseList) {
                if ((sC.getDescriptiveTitle()).compareToIgnoreCase(c.getDescriptiveTitle()) == 0) {
                    c.setGrades(sC.getGrades());
                    break;
                }
            }
        }
        System.out.println();
        System.out.print("YOUR COURSES");
        showShifterCourses(shifterCourseList);

        showUncarriedCourses(courseList, shifterCourseList);

        System.out.println();
        System.out.print("You have successfully shifted courses!\n");
        System.out.println();
    }

    /**
     * TODO: Andre
     */
    private static void showShifterCourses(ArrayList<Course> shifterCourseList) {
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course sC : shifterCourseList) {
            System.out.println(sC.toString());
        }
    }

    /**
     * TODO: Andre
     */
    private static void showUncarriedCourses(ArrayList<Course> courseList, ArrayList<Course> shifterCourseList) {
        int prevSize;
        int curSize = 0;

        do {
            prevSize = curSize;
            for (int i = 0; i < shifterCourseList.size(); i++) {
                for (Course c : courseList) {
                    if ((shifterCourseList.get(i)).getDescriptiveTitle().compareToIgnoreCase(c.getDescriptiveTitle()) == 0) {
                        shifterCourseList.remove(i);
                        break;
                    }
                }
            }
            curSize = shifterCourseList.size();
        } while (prevSize != curSize);

        System.out.println();
        System.out.print("UNCARRIED COURSES");
        showShifterCourses(shifterCourseList);
    }

    /**
     * TODO: Jerome
     */
    private static boolean hasFailedCourse(Course course) {
        return course.getGrades() < 75 && course.getGrades() != 0;
    }

    /**
     * This method displays courses with their corresponding grades.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1) Get the highest year in the curriculum. <br>
     * 2) Print courses according to year and term.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void showCoursesWithGrades(ArrayList<Course> courseList) {
        int highestYear = 1;
        for (Course c : courseList) {
            if (c.getYear() > highestYear) highestYear = c.getYear();
        }

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   COURSES WITH GRADES");
        for (int y = 1; y <= highestYear; y++) {
            for (int t = 1; t <= 3; t++) {
                displayHeaderWithGrades(y, t);
                for (Course c : courseList) {
                    if (c.getYear() == y && c.getTerm() == t) {
                        System.out.println(c);
                    }
                }
                termBuffer();
            }
        }
    }

    /**
     * This method sorts courses by GPA, either in ascending or descending order.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1) Create a new ArrayList wherein courses with grades are added. <br>
     * 2) If choice is 1, return an ArrayList of courses with GPAs in ascending order. <br>
     * Else, return an ArrayList of courses with GPAs in descending order.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     * @param aOrD the choice indicating if the ArrayList should be sorted in descending or ascending order
     * @return an ArrayList of sorted courses with GPA
     */
    private static ArrayList<Course> sortCoursesByGPA(ArrayList<Course> courseList, int aOrD) {
        ArrayList<Course> courseListCopy = new ArrayList<Course>();
        for (Course c : courseList) {
            if (c.getGrades() != 0)
                courseListCopy.add(c);
        }

        switch (aOrD) {
            case 1 -> Collections.sort(courseListCopy); // Ascending Order
            case 2 -> { // Descending Order
                Collections.sort(courseListCopy);
                Collections.reverse(courseListCopy);
            }
        }
        return courseListCopy;
    }

    /**
     * TODO: Kurt
     */
    private static void showElectiveCourses(ArrayList<Course> courseList) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ELECTIVE COURSES");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c : courseList)
            if (c.getIsElective())
                System.out.println(c.toString());
    }

    /**
     * This method shows courses that have no GPA.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1) Print out courses from courseList that do not have a GPA.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void showCoursesWithoutGPA(ArrayList<Course> courseList) {
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   SHOWING COURSES WITHOUT GPA");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c : courseList)
            if (c.getGrades() == 0.0) System.out.println(c);
    }

    /**
     * TODO: Kurt
     */
    private static Course searchCourseList(ArrayList<Course> courseList,
                                           String searchKey) {
        for (Course course : courseList) {
            if (course.getCourseNumber().equalsIgnoreCase(searchKey))
                return course;
        }
        return new Course();
    }

    /**
     * TODO: Enrico
     */
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

    /**
     * This method allows the user to edit a course's code and description.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1) Display the courses from courseList. <br>
     * 2) Ask user for the course number to be changed. <br>
     * 3) If the course entered is null or not found in the list, the user has to input a valid course.
     * Else, the user is asked to enter a new course number and its new respective description
     * for the chosen course. <br>
     * 4) Display the new course number and its respective description.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void editCourse(ArrayList<Course> courseList) {
        Course courseToBeChanged;
        String searchKey;

        do {
            showCourses(courseList);
            searchKey = acceptStringInput("Enter course number to be changed (ex. CS 122): ");
            courseToBeChanged = searchCourseList(courseList, searchKey);
            if (courseToBeChanged.getCourseNumber().equals(""))
                System.out.println("Invalid Course Number inputted. Try again.");
            else {
                for (Course c : courseList) {
                    if (c.getCourseNumber().compareToIgnoreCase(courseToBeChanged.getCourseNumber()) == 0) {
                        String newCN = acceptStringInput("Enter the new course number: ");
                        String newTitle = acceptStringInput("Enter the new descriptive title: ");
                        c.setCourseNumber(newCN);
                        c.setDescriptiveTitle(newTitle);
                        System.out.println("New course number: " + c.getCourseNumber());
                        System.out.println("New course description: " + c.getDescriptiveTitle());
                        break;
                    }
                }
            }
        } while (courseToBeChanged.getCourseNumber().equals(""));
    }

    /**
     * TODO: EJ
     */
    private static byte acceptByteInput(String message) {
        byte input = -1;
        while (true) {
            try {
                input = Byte.parseByte(acceptStringInput(message));
                if (input != -1) return input;
            } catch (NumberFormatException exception) {
                System.out.println("You have entered an invalid integer.");
            } catch (Exception exception) {
                System.out.println("Fatal error: " + exception);
            }
        }
    }

    /**
     * TODO: Jerome
     */
    private static int acceptIntegerInput(String message) {
        int input = -1;
        while (true) {
            try {
                input = Integer.parseInt(acceptStringInput(message));
                if (input != -1) return input;
            } catch (NumberFormatException exception) {
                System.out.println("You have entered an invalid integer.");
            } catch (Exception exception) {
                System.out.println("Fatal error: " + exception);
            }
        }
    }

    /**
     * TODO: EJ
     */
    private static double acceptDoubleInput(String message) {
        Double input = -1.0;
        while (true) {
            try {
                input = Double.parseDouble(acceptStringInput(message));
                if (input != -1.0) return input;
            } catch (NumberFormatException exception) {
                System.out.println("You have entered an invalid Double value.");
            } catch (Exception exception) {
                System.out.println("Fatal error: " + exception);
            }
        }
    }

    /**
     * TODO: Kurt
     */
    private static String acceptStringInput(String message) {
        String userInput;
        while (true) {
            System.out.print(message);
            userInput = keyboard.nextLine();
            if (userInput != null) return userInput;
        }
    }

    /**
     * TODO: EJ
     */
    private static void inputBuffer() {
        System.out.println();
        System.out.print("Press enter key to choose another item.");
        keyboard.nextLine();
        System.out.println();
    }

    // TODO ADI AND KURT
    // Displays the contributions of each member
    // When invoked through the main menu
    private static void aboutTheDevelopers() {

    }

    /**
     * TODO: Kurt
     */
    private static void showIntroduction() {
        System.out.println("Welcome to the Course Administration program!");
        System.out.println("See menu below for available operations.");
        System.out.println();
    }

    /**
     * TODO: EJ
     */
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
                 <8> Save changes to file
                 <9> About the developers
                 <10> Quit
                =================================================
                """);
    }

    /**
     * TODO: Jerome
     */
    // TODO Jerome
    public static void main(String[] args) {
        ArrayList<Course> courseList = parseCSV();
        showIntroduction();
        byte choice = 0;
        do { // validates the input
            showMenu();
            try {
                choice = acceptByteInput("Select an item: ");
                if (choice < 1 || choice > 10)
                    System.out.println("The number must be from 1 to 8.");
                switch (choice) {
                    case 1:
                        showCourses(courseList);
                        inputBuffer();
                        break;
                    case 2:
                        showCoursesWithGrades(courseList);
                        inputBuffer();
                        break;
                    case 3:
                        showElectiveCourses(courseList);
                        inputBuffer();
                        break;
                    case 4:
                        showFailedCourses(courseList);
                        inputBuffer();
                        break;
                    case 5:
                        inputGrades(courseList);
                        inputBuffer();
                        break;
                    case 6:
                        editCourse(courseList);
                        inputBuffer();
                        break;
                    case 7:
                        shiftCourse(courseList);
                        inputBuffer();
                        break;
                    case 8:
                        saveChangesToFile(courseList);
                        inputBuffer();
                        break;
                    case 9:
                        aboutTheDevelopers();
                        inputBuffer();
                        break;
                }
            } catch (NumberFormatException x) {
                System.out.println("You entered an invalid integer.");
            }
        } while (choice != 10);
    }
}
