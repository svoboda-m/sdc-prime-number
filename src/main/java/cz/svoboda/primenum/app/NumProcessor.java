package cz.svoboda.primenum.app;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class NumProcessor {

    public int process (Cell cell) {
        int number = 0;

        // process numeric values
        if (cell.getCellType() == CellType.NUMERIC && !DateUtil.isCellDateFormatted(cell)) {
            double doubleNum = cell.getNumericCellValue();

            if (doubleNum % 1 == 0) {
                number = (int)doubleNum;
            }

        // process string values
        } else if (cell.getCellType() == CellType.STRING) {
            try {
                number = Integer.parseInt(cell.getStringCellValue());
            } catch (NumberFormatException ignore) {
            }
        }

        return number;
    }
}
