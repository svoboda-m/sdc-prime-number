package cz.svoboda.primenum.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

/**
 * The class processes the input file and evaluates whether the number is prime.
 */
public class Application {
    protected static final Logger logger = LogManager.getLogger();
    private final String[] args;

    public Application(String[] args) {
        this.args = args;
    }

    /**
     * This is the main method of the application.
     * It opens a file via arguments, checks if a cell is convertible to integer,
     * then checks if a number is prime.
     * The output is shown in a console using Logger.
     * @throws IOException
     */
    public void run() throws IOException{
        PrimeNumber primeNumber = new PrimeNumber();
        NumProcessor numProcessor = new NumProcessor();
        int number;

        FileInputStream inputStream = new FileInputStream(args[0]);
        BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);

        XSSFWorkbook workbook = new XSSFWorkbook(bufferedStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Cell cell = row.getCell(1);

            if (cell != null) {

                try {
                    number = numProcessor.process(cell);
                } catch (NumberFormatException e) {
                    continue;
                }

                if (number > 0) {
                    if (primeNumber.isPrime(number)) {
                        logger.info("Prime number found: " + number);
                    }
                }
            }
        }

        inputStream.close();
    }
}
