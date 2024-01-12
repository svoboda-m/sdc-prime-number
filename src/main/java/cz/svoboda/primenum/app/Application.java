package cz.svoboda.primenum.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;


public class Application {
    protected static final Logger logger = LogManager.getLogger();
    private String[] args;

    public Application(String[] args) {
        this.args = args;
    }

    public void run() throws IOException{
        logger.info(args[0]);
        PrimeNumber primeNumber = new PrimeNumber();
        int number = 0;

        FileInputStream inputStream = new FileInputStream(args[0]);
        BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);

        XSSFWorkbook workbook = new XSSFWorkbook(bufferedStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell cell = row.getCell(1);

            if (cell != null) {
                System.out.println("-------------");
                System.out.println("raw input: " + cell);

                // process numeric values
                if (cell.getCellType() == CellType.NUMERIC) {
                    double doubleNum = cell.getNumericCellValue();

                    if (doubleNum % 1 == 0) {
                        number = (int)doubleNum;
                    } else {
                        continue;
                    }
                // process string values
                } else if (cell.getCellType() == CellType.STRING) {
                    try {
                        number = Integer.parseInt(cell.getStringCellValue());
                    } catch (NumberFormatException ignore) {
                        continue;
                    }
                }

                System.out.println("clean input: " + number);
                if (number > 0) {
                    if (primeNumber.isPrime(number)){
                        logger.info("Prime number found: " + number);
                    }
                }

                System.out.println();
            }
        }

        inputStream.close();
    }
}
