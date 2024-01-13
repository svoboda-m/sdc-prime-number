
import cz.svoboda.primenum.app.NumProcessor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumProcessorTest {
    FileInputStream inputStream;

    private Row prepareRowForTest (int n) throws IOException {
        inputStream = new FileInputStream("src/test/resources/data_testing.xlsx");
        BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
        XSSFWorkbook workbook = new XSSFWorkbook(bufferedStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        return sheet.getRow(n);
    }

    @Test
    void CellTypeStringWithNum1ShouldReturn1 () throws IOException {
        Row row = prepareRowForTest(1);
        NumProcessor numProcessor = new NumProcessor();

        assertEquals(1, numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeStringWithNum2Point5ShouldThrowException () throws IOException {
        Row row = prepareRowForTest(2);
        NumProcessor numProcessor = new NumProcessor();

        assertThrows(NumberFormatException.class,
                () -> numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeStringWithNumMinus3ShouldReturnMinus3 () throws IOException {
        Row row = prepareRowForTest(3);
        NumProcessor numProcessor = new NumProcessor();

        assertEquals(-3, numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeStringWithNumMinus4Point5ShouldThrowException () throws IOException {
        Row row = prepareRowForTest(4);
        NumProcessor numProcessor = new NumProcessor();

        assertThrows(NumberFormatException.class,
                () -> numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeStringWithStringThrowException () throws IOException {
        Row row = prepareRowForTest(5);
        NumProcessor numProcessor = new NumProcessor();

        assertThrows(NumberFormatException.class,
                () -> numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeNumericWithNum5ShouldReturn5 () throws IOException {
        Row row = prepareRowForTest(6);
        NumProcessor numProcessor = new NumProcessor();

        assertEquals(5, numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeNumericWithNum6Point25ShouldThrowException () throws IOException {
        Row row = prepareRowForTest(7);
        NumProcessor numProcessor = new NumProcessor();

        assertThrows(NumberFormatException.class,
                () -> numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeNumericWithNumMinus7Point0ShouldReturnMinus7 () throws IOException {
        Row row = prepareRowForTest(8);
        NumProcessor numProcessor = new NumProcessor();

        assertEquals(-7, numProcessor.process(row.getCell(1)));

        inputStream.close();
    }

    @Test
    void CellTypeDateShouldThrowException () throws IOException {
        Row row = prepareRowForTest(9);
        NumProcessor numProcessor = new NumProcessor();

        assertThrows(NumberFormatException.class,
                () -> numProcessor.process(row.getCell(1)));

        inputStream.close();
    }
}
