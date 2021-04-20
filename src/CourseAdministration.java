import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CourseAdministration {
    private static BufferedReader br;
    private static final Scanner keyboard = new Scanner(System.in);
    private static final int INT_SENTINEL_VALUE = Integer.MIN_VALUE;
    private static final byte BYTE_SENTINEL_VALUE = Byte.MIN_VALUE;
    private static final double DOUBLE_SENTINEL_VALUE = Double.MIN_VALUE;

    /**
     * This method allows the creation of the Array list with its data retrieved from
     * a cvs file.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. The method first creates a new Array List named courseList. <br>
     * 2. Encased in a try and catch a new buffered reader is created
     * to read the cvs file. <br>
     * 3. Also within the try and catch a while loop is located for the
     * construction of the arrays. <br>
     * 3.1. Firstly It splits the cvs file on comma using a line.split <br>
     * 3.2. It then constructs the a new course file for the input of values. <br>
     * 3.3. Values will then be added using the different input methods <br>
     * 3.4. It then adds it to the array of data to the list.
     */
    protected static ArrayList<Course> parseCSV(String fileName) {
        ArrayList<Course> courseList = new ArrayList<>();
        String line;
        try {
            br = new BufferedReader(new FileReader(fileName));
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
     * This method allows the construction of the array.
     *
     * @param csvLine the String read by the BufferedReader
     * @return an array of Strings containing data for a Course object
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
     * This method allows the user to save the changes made to the file.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. The method asks the user whether or not to permanently change
     * the file. <br>
     * 2. If the user inputs Y for yes. <br>
     * 2.1. The file will go through a for loop to print out the list. <br>
     * 2.2. Then gets overwritten by a writer. <br>
     * 3. If the user inputs otherwise a message prompt will appear saying
     * the changes have not been saved.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void saveChangesToFile(ArrayList<Course> courseList) {
        String decision;
        String line;
        System.out.print("The changes will be permanent. Are you sure? Y/N");
        decision = keyboard.nextLine();
        if (decision.equals("Y") || decision.equals("y")) {
            try {
                for (Course c : courseList) System.out.println(c);

                PrintWriter outputWriter =
                        new PrintWriter(new FileWriter("BSCSCurriculumData1WithGradesCopy.csv"));
                for (int i = 0; i < courseList.size(); i++) {
                    if (courseList.get(i).getGrades() == 0)
                        outputWriter.println(courseList.get(i).getYear() + "," + courseList.get(i).getTerm() + "," +
                                courseList.get(i).getCourseNumber() + "," + courseList.get(i).getDescriptiveTitle() +
                                "," + courseList.get(i).getUnits() + ",");
                    else
                        outputWriter.println(courseList.get(i).getYear() + "," + courseList.get(i).getTerm() + "," +
                                courseList.get(i).getCourseNumber() + "," + courseList.get(i).getDescriptiveTitle() +
                                "," + courseList.get(i).getUnits() + "," + courseList.get(i).getGrades());
                }

                outputWriter.close();

                PrintWriter outputWriter2 = new PrintWriter(new FileWriter("BSCSCurriculumData1WithGradesTabularCopy.txt"));
                outputWriter2.printf("%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                for (int i = 0; i < courseList.size(); i++) outputWriter2.println(courseList.get(i));
                outputWriter2.close();
            } catch (IOException ioException) {
                System.out.println("I/O error: " + ioException);
            }
        } else {
            System.out.println("The changes were not saved.");
        }
    }

    /**
     * This method displays the header for its specific year and term which includes grade.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Accepts the specified year and term. <br>
     * 2. It goes through a first switch expression to determine the year level. <br>
     * 3. It then goes to a second switch expression to determine the term. <br>
     * 4. It then displays the header for the specified year and term.
     *
     * @param year the year that a certain set of courses are in
     * @param term the term that a certain set of courses are in
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
     * Serves as a buffer in between operations.
     */
    private static void termBuffer() {
        System.out.println();
        System.out.print("Press enter key to see courses for the next term...");
        keyboard.nextLine();
        System.out.println();
    }

    /**
     * This method displays the header for its specific year and term
     * which does not include grades.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Accepts the specified year and term. <br>
     * 2. It goes through a first switch expression to determine the year level. <br>
     * 3. It then goes to a second switch expression to determine the term. <br>
     * 4. It then displays the header for the specified year and term.
     *
     * @param year the year that a certain set of courses are in
     * @param term the term that a certain set of courses are in
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
     * 1. Gets the highest year in the curriculum data file. <br>
     * 2. Displays the courses for each term.
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void showCourses(ArrayList<Course> courseList) {
        int highestYear = 1;
        for (Course c : courseList) {
            if (c.getYear() > highestYear) highestYear = c.getYear();
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   COURSES");
        for (int y = 1; y <= highestYear; y++) {
            for (int t = 1; t <= 3; t++) {
                displayHeader(y, t);
                for (Course c : courseList) {
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
        ArrayList<Course> courseListCopyFail = new ArrayList<Course>();
        for (Course c : courseList) {
            if (c.getGrades() != 0 && hasFailedCourse(c)) {
                courseListCopyFail.add(c);
            }
        }

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t      FAILED COURSES");
        for (int i = 0; i < 145; i++) System.out.print("-");
        System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
        for (Course c : courseListCopyFail) System.out.println(c);
    }

    /**
     * This method is in charge of handling the course shift; it uses the shifter's data and
     * compares it to the main curriculum data, transferring the shifter's data and course number
     * over to their respective equivalent courses.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Compares each course in the Shifter's ArrayList and the original curriculum ArrayList <br>
     * 2. If the course descriptions are the same (by comparing the descriptive titles) <br>
     * Changes the original course number into the shifter's course number <br>
     * Sets the original course grade to the shifter's course grade <br>
     * 3. Shows the shifter's courses that had equivalents <br>
     * 4. Shows the shifter's courses that did not have an equivalent
     *
     * @param courseList the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
     */
    private static void shiftCourse(ArrayList<Course> courseList) {
        ArrayList<Course> shifterCourseList = parseCSV("ShifterData.csv");
        char shiftChoice;
        System.out.println("Detected Shifter CSV: BSIT 1");
        System.out.println("Shifting to: BSCS 1");
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
        System.out.print("You have successfully shifted courses!");
        System.out.println();
    }

    /**
     * This method is a very barebones way of displaying each course in the courseList; to
     * be used in the shifter methods.
     * <p>
     * METHOD ALGORITHM <br>
     * 1. For each course in the course ArrayList <br>
     * Print said course into string
     *
     * @param shifterCourseList the ArrayList of courses from the ShifterData.csv file
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
     * <p>
     * METHOD ALGORITHM <br>
     * 1. Compares each course in the Shifter's ArrayList and the original curriculum ArrayList <br>
     * 2. If the descriptive titles are the same <br>
     * Removes the shifter course from the shifter's ArrayList <br>
     * 3. Shows a list of the uncarried courses <br>
     * 4. Adds the uncarried course to the main curriculum ArrayList <br>
     * Adds a prefix to the course name <br>
     * Sets the units of the course to 0
     *
     * @param shifterCourseList the ArrayList of courses from the ShifterData.csv file
     * @param courseList        the ArrayList of courses from the BSCSCurriculumData1WithGrades.csv file
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
     * METHOD ALGORITHM: <br>
     * 1. Return true if the grade of the course if the grade is less than <br>
     * 75 and if the grade is not equal to 0 (the grade is 0 if the grade has not been registered).
     *
     * @param course receives the Course instance
     * @return true if the course has a failing grade.
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

        System.out.println();
        System.out.print("Press enter key to see grades in ascending order...");
        keyboard.nextLine();
        System.out.println();

        sortCoursesByGPA(courseList, 1);

        System.out.println();
        System.out.print("Press enter key to see grades in descending order...");
        keyboard.nextLine();
        System.out.println();

        sortCoursesByGPA(courseList, 2);
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
     * @param aOrD       the choice indicating if the ArrayList should be sorted in descending or ascending order
     */
    private static void sortCoursesByGPA(ArrayList<Course> courseList, int aOrD) {
        ArrayList<Course> courseListCopy = new ArrayList<Course>();
        for (Course c : courseList) {
            if (c.getGrades() != 0)
                courseListCopy.add(c);
        }

        switch (aOrD) {
            case 1 -> { // Ascending Order
                Collections.sort(courseListCopy);
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   ASCENDING ORDER");
                System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                for (int i = 0; i < 145; i++) System.out.print("-");
                System.out.println();
                for (Course c : courseListCopy) System.out.println(c);
            }
            case 2 -> { // Descending Order
                Collections.sort(courseListCopy);
                Collections.reverse(courseListCopy);
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   DESCENDING ORDER");
                System.out.printf("\n%-15s %-110s %-8s %-6s\n", "COURSE NO.", "COURSE DESCRIPTION", "UNITS", "GRADE");
                for (int i = 0; i < 145; i++) System.out.print("-");
                System.out.println();
                for (Course c : courseListCopy) System.out.println(c);
            }
        }
    }

    /**
     * METHOD ALGORITHM: <br>
     * 1. Display the header and elective courses <br>
     * 2. Prompt user if they want to edit an elective <br>
     * if choice == 1, invoke the editCourse method,
     * then print the updated electives list <br>
     * else return to main menu <br>
     *
     * @param courseList the passed ArrayList contains the courses parsed from the CSV
     *                   This method displays elective courses and allows the user to edit them.
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
     * METHOD ALGORITHM: <br>
     * 1. Use a for-each loop to iterate for every Course object in the loop <br>
     * 2. If a course object's course number is equal to the search key, return this <br>
     * course object and terminate this method <br>
     * 3. Else return an empty course
     *
     * @param courseList the passed ArrayList contains the courses parsed from the CSV
     * @param searchKey  a String parameter to be used for searching the ArrayList
     * @return return a matching course, or if no course if found, return an empty Course object
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
     * 1) Displays the list of courses without GPAs <br>
     * 2) Asks the user to input a course number from the displayed list <br>
     * 3) If the inputted course number is not found or null, the user is asked to input a valid input <br>
     * 4) Asks the user to input GPA for the selected course number. <br>
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
     * This method helps accept a variable with the byte data type.
     * <p>
     * METHOD DESCRIPTION: <br>
     * Accepts the input given by the user within the
     * range of the byte data type. The method is
     * enclosed in a loop and will continue till the
     * user either enters a valid input or hits an error.
     *
     * @param message message prompt
     * @return the valid byte input to be used
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
     * METHOD ALGORITHM: <br>
     * 1. Initialize variable input to hold the value registered by the user <br>
     * 2. While true <br>
     * 2.1 Accept an input from the user <br>
     * 2.2 If input is not equal to -1, return input <br>
     * 2.3 Catch necessary exceptions
     *
     * @param message message prompt
     * @return an integer input.
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
     * This method helps accept a variable with the double data type.
     * <p>
     * METHOD DESCRIPTION: <br>
     * Accepts the input given by the user within the
     * range of the double data type. The method is
     * enclosed in a loop and will continue till the
     * user either enters a valid input or hits an error.
     *
     * @param message message prompt
     * @return a double input
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
     * METHOD DESCRIPTION: Accepts input from the keyboard, loops until user enters
     * a valid String value
     *
     * @param message signifies the message to be displayed upon prompting the user
     * @return a String value accepted from the keyboard
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
     * Serves as buffer in between operations.
     */
    private static void inputBuffer() {
        System.out.println();
        System.out.print("Press enter key to choose another item.");
        keyboard.nextLine();
        System.out.println();
    }

    /**
     * Displays the contributions of each member when invoked through the main menu
     */
    private static void aboutTheDevelopers() {
        System.out.println("""
                =================================================
                Bustarde, Jerome
                1. hasFailedCourse()
                2. main()
                3. showCourses()
                4. Assisted with Javadoc comments
                                
                Castro, Enrico Nathanielle
                1. inputGrades()
                2. showCourses()
                3. displayHeader()
                4. showMenu()
                                
                Dela Cruz, Jonah Andre
                1. showMenu()
                2. shiftCourse(), shifter csv file and associated methods
                                
                Ferrer, Jeanne Adeline
                1. showFailedCourses()
                2. editCourse()
                3. sortCoursesByGPA()
                4. showCoursesWithGrades
                5. Edited the javadoc comments
                6. toString() and compareTo() methods in the Course class
                7. displayHeaderWithGrades()
                8. Edited the parseCSV method, added the buildArray method so that 
                   parseCSV won't throw an ArrayIndexOutOfBounds exception 
                   when the grade cell in a csv file is null
                9. termBuffer() and inputBuffer()
                                
                Nudo, Kurt Matthew
                1. Created the actual code logic design
                2. parseCSV()
                3. Reference class Course
                4. Fixed the displayHeader() methods
                5. manageElectiveCourses() and associated methods
                6. searchCourseList()
                7. inputGrades()
                8. Rewrote the acceptInput() methods, made them handle exceptions locally
                9. Modified methods that accept input from the keyboard to use the
                   acceptInput() methods
                                
                Ocampo, Jomari
                ????
                                
                Pangwi, Eugene Justin
                1. parseCSV()
                2. saveChangesToFile()
                3. Assisted with Javadoc comments 
                 
                """);
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
     * Displays the current main menu of the program.
     * Displays what the program is able to do and with further added functions.
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
     * Main Method.
     * <p>
     * METHOD ALGORITHM: <br>
     * 1. Initialize variable courseList to hold CSV. <br>
     * 2. Invoke showIntroduction to display introductory message. <br>
     * 3. Initialize variable choice. <br>
     * 4. Insert do while loop to validate the input <br>
     * 5. do <br>
     * 5.1 Invoke showMenu to display the choices available. <br>
     * 5.2 Accept the input from the user for the variable choice. <br>
     * 5.3 If choice is less than 1 or choice is greater than 10, Display a message <br>
     * 5.4 Insert a switch case statement <br>
     * case 1: Invoke showCourses method <br>
     * case 2: Invoke showCoursesWithGrades method <br>
     * case 3: Invoke showElectiveCourses method <br>
     * case 4: Invoke showFailedCourses method <br>
     * case 5: Invoke inputGrades method <br>
     * case 6: Invoke editCourse method <br>
     * case 7: Invoke shiftCourse method <br>
     * case 8: Invoke saveChangesToFile method <br>
     * case 9: Invoke aboutTheDevelopers method <br>
     * 5.5 Catch necessary exceptions <br>
     * while choice is not equal to 10
     *
     * @param args command line argument
     */
    public static void main(String[] args) {
        ArrayList<Course> courseList = parseCSV("BSCSCurriculumData1WithGrades.csv");
        searchForElectives(courseList);
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
