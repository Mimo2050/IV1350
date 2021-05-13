package util;

import se.kth.iv1350.POS.model.Amount;
import se.kth.iv1350.POS.model.SaleObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TotalRevenueFileOutput implements SaleObserver {


    private PrintWriter logFile;

    public TotalRevenueFileOutput() throws IOException {
        FileWriter fileWriter = new FileWriter("POS-TotalRevenueFile-file.txt");
        logFile = new PrintWriter(fileWriter, true);
    }

    @Override
    public void newTotalPrice(Amount totalPrice) {
        logException(totalPrice);
    }

    private void logException(Amount totalPrice) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(getCurrentTime());
        logMsgBuilder.append("; Print the total income: \n" +
                "Total income: ");
        logMsgBuilder.append(totalPrice.getAmount());
        logFile.println(logMsgBuilder);
    }
    private String getCurrentTime() {
        DateFormat dateFormate = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date currentDateAndTime = new Date();
        return dateFormate.format(currentDateAndTime).toString();
    }
}
