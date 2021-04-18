import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class CourseAdministration {
    static BufferedReader br;
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int INT_SENTINEL_VALUE = Integer.MIN_VALUE;
    private static final byte BYTE_SENTINEL_VALUE = Byte.MIN_VALUE;
    private static final double DOUBLE_SENTINEL_VALUE = Double.MIN_VALUE;

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
        String decision;
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

    /**
     * TODO: EJ
     */
    private static void displayHeader(int year, int term) {
        switch (year) {
            case 1:
                switch (term) {
                    case 1 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = First Year\tTerm = First Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = First Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = First Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
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
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Second Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Second Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
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
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Third Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Third Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
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
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fourth Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fourth Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
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
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 2 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fifth Year\tTerm = Second Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                    case 3 -> {
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println("\nYear = Fifth Year\tTerm = Third Semester ");
                        System.out.printf("%-15s %-110s %-14s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS");
                        for (int i = 0; i < 145; i++) System.out.print("-");
                        System.out.println();
                    }
                }
                break;
        }
    }

    /**
     * This method shows the list of courses and their respective units present in the term.
     * <p>
     * METHOD ALGORITHM <br>
     * 1. Gets the highest year in the curriculum data file.
     * 2. Displays the courses for each term.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void showCourses(ArrayList<Course> courseList) {
        int highestYear = 1;
            for (Course c: courseList) {
                if (c.getYear() > highestYear) highestYear = c.getYear();
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   COURSES");
            for (int y = 1; y <= highestYear; y++) {
                for (int t = 1; t <= 3; t++) {
                    displayHeader(y, t);
                    for (Course c: courseList) {
                        if (c.getYear() == y && c.getTerm() == t) {
                            System.out.printf("%-15s %-110s %-8s\n", c.getCourseNumber(), c.getDescriptiveTitle(), c.getUnits());
                        }
                    }
                    termBuffer();
                }
            }
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
     * This method essentially functions in the same way as the parseCSV method, but this
     * method opens a different CSV file which contains the shifter's data to be used in the
     * shifter methods.
     *
     * METHOD ALGORITHM:
     * 1. Create a new ArrayList
     * 2. Open the shifterData CSV file with FileReader
     * 3. Splits each value separated by commas
     * 4. Processes each value to be in line with the Course constructor
     * 5. Adds said course to the ArrayList
     */
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
     * This method is in charge of handling the course shift; it uses the shifter's data and
     * compares it to the main curriculum data, transferring the shifter's data and course number
     * over to their respective equivalent courses.
     * 
     * METHOD ALGORITHM:
     * 1. Compares each course in the Shifter's ArrayList and the original curriculum ArrayList
     * 2. If the course descriptions are the same (by comparing the descriptive titles)
     *      Changes the original course number into the shifter's course number
     *      Sets the original course grade to the shifter's course grade
     * 3. Shows the shifter's courses that had equivalents
     * 4. Shows the shifter's courses that did not have an equivalent
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
                    c.setCourseNumber(sC.getCourseNumber());
                    break;
                }
            }
        }
        
        System.out.println();
        System.out.print("YOUR COURSES");
        showShifterCourses(shifterCourseList);

        uncarriedCourses(courseList, shifterCourseList);

        System.out.println();
        System.out.print("You have successfully shifted courses!\n");
        System.out.println();
    }

    /**
     * This method is a very barebones way of displaying each course in the courseList; to
     * be used in the shifter methods.
     * 
     * METHOD ALGORITHM
     * 1. For each course in the course ArrayList
     *      Print said course into string
     */
    private static void showShifterCourses(ArrayList<Course> shifterCourseList) {
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course sC : shifterCourseList) {
            System.out.println(sC.toString());
        }
    }

    /**
     * This method sorts out the courses with no equivalents, removing courses with
     * equivalents from the original shifter's ArrayList. This method is also in charge of
     * adding the uncarried courses to the main course ArrayList.
     * 
     * METHOD ALGORITHM
     * 1. Compares each course in the Shifter's ArrayList and the original curriculum ArrayList
     * 2. If the descriptive titles are the same
     *      Removes the shifter course from the shifter's ArrayList
     * 3. Shows a list of the uncarried courses
     * 4. Adds the uncarried course to the main curriculum ArrayList
     *      Adds a prefix * to the course name
     *      Sets the units of the course to 0
     */
    private static void uncarriedCourses(ArrayList<Course> courseList, ArrayList<Course> shifterCourseList) {
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
        
        for (Course sC : shifterCourseList) {
            sC.setCourseNumber("*" + sC.getCourseNumber());
            sC.setUnits(0);
            courseList.add(sC);
        }
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
     * @param courseList the passed ArrayList contains the courses parsed from the CSV
     * This method displays elective courses and allows the user to edit them.
     * METHOD ALGORITHM:
     *     1. Display the header and elective courses
     *     2. Prompt user if they want to edit an elective
     *          if choice == 1, invoke the editCourse method,
     *              then print the updated electives list
     *          else return to main menu
     */
    private static void manageElectiveCourses(ArrayList<Course> courseList) {
        int choice;

        do { // validates the input
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ELECTIVE COURSES");
            for (int i = 0; i < 145; i++) System.out.print("-");
            System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
            for (Course c : courseList)
                if (c.getIsElective())
                    System.out.println(c);
            System.out.println("\nWhat would you like to do?\n");
            System.out.println("1. Manage an elective course.");
            System.out.println("2. Return to the main menu.\n");
            choice = acceptByteInput("Select an item: ");
            if (choice < 1 || choice > 2)
                System.out.println("The number must be from 1 to 2.");
            switch (choice) {
                case 1:
                    editCourse(courseList);
                    break;
                case 2:
                    break;

            }
        } while (choice != 2);

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
     * @param courseList the passed ArrayList contains the courses parsed from the CSV
     * @param searchKey a String parameter to be used for searching the ArrayList
     * @return return a matching course, or if no course if found, return an empty Course object
     * METHOD ALGORITHM:
     *  1. Use a for-each loop to iterate for every Course object in the loop
     *  2. If a course object's course number is equal to the search key, return this
     *     course object and terminate this method
     *  3. Else return an empty course
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
     * This method sets the GPA for a specific course number.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1) Displays the list of courses without GPAs
     * 2) Asks the user to input a course number from the displayed list
     * 3) If the inputted course number is not found or null, the user is asked to input a valid input
     * 4) Asks the user to input GPA for the selected course number.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
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
     * @param message signifies the message to be displayed upon prompting the user
     * @return a String value accepted from the keyboard
     * METHOD DESCRIPTION: Accepts input from the keyboard, loops until user enters
     * a valid String value
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
     * Outputs introductory messages to the console
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

    private static void searchForElectives(ArrayList<Course> courseList) {
        for (Course course : courseList) {
            if (course.getCourseNumber().equalsIgnoreCase("CSE"))
                course.setIsElective(true);
        }
    }

    /**
     * TODO: Jerome
     */
    public static void main(String[] args) {
        ArrayList<Course> courseList = parseCSV();
        showIntroduction();
        byte choice = 0;
        do { // validates the input
            showMenu();
            try {
                choice = acceptByteInput("Select an item: ");
                if (choice < 1 || choice > 10)
                    System.out.println("The number must be from 1 to 10.");
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
                        manageElectiveCourses(courseList);
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
                        showCourses(courseList);
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
