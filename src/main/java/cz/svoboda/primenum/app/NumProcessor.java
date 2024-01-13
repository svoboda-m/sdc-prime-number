package cz.svoboda.primenum.app;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;

public class NumProcessor {

    public int process (Cell cell) {
        // process numeric values
        if (cell.getCellType() == CellType.NUMERIC && !DateUtil.isCellDateFormatted(cell)) {
            double doubleNum = cell.getNumericCellValue();

            if (doubleNum % 1 == 0) {
                return (int)doubleNum;
            } else {
                throw new NumberFormatException();
            }

        // process string values
        } else if (cell.getCellType() == CellType.STRING) {
            return Integer.parseInt(cell.getStringCellValue());

        } else {
            throw new NumberFormatException();
        }
    }
}
