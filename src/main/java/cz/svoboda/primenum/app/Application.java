package cz.svoboda.primenum.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;


public class Application {
    protected static final Logger logger = LogManager.getLogger();
    private final String[] args;

    public Application(String[] args) {
        this.args = args;
    }

    public void run() throws IOException{
        PrimeNumber primeNumber = new PrimeNumber();
        NumProcessor numProcessor = new NumProcessor();
        int number;
        logger.info(args[0]);

        FileInputStream inputStream = new FileInputStream(args[0]);
        BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);

        XSSFWorkbook workbook = new XSSFWorkbook(bufferedStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            Cell cell = row.getCell(1);

            if (cell != null) {
                System.out.println("-------------");
                System.out.println("raw input: " + cell);

                number = numProcessor.process(cell);

                System.out.println("clean input: " + number);
                if (number > 0) {
                    if (primeNumber.isPrime(number)) {
                        logger.info("Prime number found: " + number);
                    }
                }

                System.out.println();
            }
        }

        inputStream.close();
    }
}
