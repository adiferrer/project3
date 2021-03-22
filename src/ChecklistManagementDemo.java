import java.util.Scanner;
import java.io.*;

public class ChecklistManagementDemo {
    private Scanner fileReader;
    private CurriculumData[] curriculumData;

    // TODO main method - Andre

    // TODO run method - Andre

    // TODO populateCurriculumDataArray method - Enrico

    public void printOutput(CurriculumData[] cData, String outputFileName) throws Exception {
        for (CurriculumData cD : cData) {
            System.out.println(cD);
        }

        PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFileName));
        for (int i = 0; i < cData.length; i++) {
            outputWriter.println(cData[i]);
        }
        outputWriter.close();
    }

    // TODO countLinesOfTextInFile method - Jerome

    // TODO displaySubjectsAndGrades method - Andre

    // TODO displayGradesAccordingToSubject method - EJ

    // TODO displaySubjectsAccordingToGrades - Kurt

    // TODO displayHighestGPA method - Jerome

}
