import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;



public class SalesDataIntegration {
    public static void main(String[] args) {
        String input = "2023-12-01,Иванов,4500.75";
        Map<String, SalesRecord> salesTable = new HashMap<>();

        salesTable.put("2023-12-01", new SalesRecord("2023-12-01", 20000.50, 4));

        processSalesData(input, salesTable);
    }

    public static void processSalesData(String input, Map<String, SalesRecord> salesTable) {
        String[] parts = input.split(",");
        if (parts.length != 3) {
            System.out.println("Ошибка: некорректный формат входных данных.");
            return;
        }

        String dateStr = parts[0].trim();
        String clientName = parts[1].trim();
        String amountStr = parts[2].trim();

        LocalDate date;
        double amount;

        try {
            date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: некорректный формат даты.");
            return;
        }

        try {
            amount = Double.parseDouble(amountStr);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: некорректный формат суммы.");
            return;
        }

        System.out.println("Разобранные данные:");
        System.out.println("Дата: " + date);
        System.out.println("Клиент: " + clientName);
        System.out.println("Сумма транзакции: " + amount);

        if (salesTable.containsKey(dateStr)) {
            SalesRecord record = salesTable.get(dateStr);
            double updatedTotalSales = record.totalSales + amount;
            int updatedTransactions = record.transactionCount + 1;

            System.out.println("Обновлённые данные по продажам:");
            System.out.println("Дата: " + dateStr);
            System.out.println("Общий объём продаж: " + updatedTotalSales);
            System.out.println("Число транзакций: " + updatedTransactions);
        } else {
            System.out.println("Ошибка: Данные по данной дате отсутствуют в таблице.");
        }
    }
}

class SalesRecord {
    String date;
    double totalSales;
    int transactionCount;

    public SalesRecord(String date, double totalSales, int transactionCount) {
        this.date = date;
        this.totalSales = totalSales;
        this.transactionCount = transactionCount;
    }
}
