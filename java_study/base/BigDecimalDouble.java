package base;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class BigDecimalDouble {
    static Logger logger = Logger.getLogger(BigDecimalDouble.class.getName());
    /**
     * Decimal 是精确计算 , 所以一般牵扯到金钱的计算 , 都使用 Decimal
     */
    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("0.05");
        BigDecimal bd2 = new BigDecimal("0.01");

        BigDecimal sum = bd.add(bd2);
        BigDecimal product = bd.subtract(bd2);

        String sum1 = String.valueOf(sum);
        logger.info(sum1);

        String product1 = String.valueOf(product);
        logger.info(product1);
    }
}
