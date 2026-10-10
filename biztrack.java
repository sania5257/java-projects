import java.util.Scanner;
public class BizTrack {
    static Scanner scanner = new Scanner(System.in);

    static String productName;
    static double purchasePrice;
    static double sellingPrice;
    static int availableStock;
    static int soldQuantity;
    static int remainingStock;
    static double investment;
    static double expectedRevenue;
    static double expectedProfit;
    static double saleAmount;
    static double costOfGoods;
    static double actualProfit;
    static String expenseName;
    static double expenseAmount;
    static double totalExpenses;
    static double netProfit;

    public static void main(String[] args) {

        while(true){
            showMenu();
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    inventoryManagement();
                    break;
                    case 2:
                        salesManagement();
                        break;
                        case 3:
                            expenseManagement();
                            break;
                            case 4:
                                profitAnalyzer();
                                break;
                                case 5:
                                    businessSummary();
                                    break;
                                    case 6:
                                        exitProgram();
                                        return;
                                        default:
                                            System.out.println("Invalid Choice!");

            }

        }

    }
    public static void showMenu(){

        System.out.println();
        System.out.println("======================================");
        System.out.println("            BIZTRACK");
        System.out.println("     Small Business Management");
        System.out.println("======================================");

        System.out.println("1. Inventory Management");
        System.out.println("2. Sales Management");
        System.out.println("3. Expense Management");
        System.out.println("4. Profit Analyzer");
        System.out.println("5. Business Summary");
        System.out.println("6. Exit");

        System.out.print("Enter Choice : ");

    }
    public static void inventoryManagement(){
        System.out.println();
        System.out.println("==================================");
        System.out.println("      INVENTORY MANAGEMENT");
        System.out.println("==================================");

        System.out.print("Product Name : ");
        productName = scanner.nextLine();

        System.out.print("Purchase Price : ");
        purchasePrice = scanner.nextDouble();

        System.out.print("Selling Price : ");
        sellingPrice = scanner.nextDouble();

        System.out.print("Available Stock : ");
        availableStock = scanner.nextInt();

        scanner.nextLine();

        printInventoryReport();

    }
    public static void printInventoryReport(){
        investment = purchasePrice * availableStock;
        expectedRevenue = sellingPrice * availableStock;
        expectedProfit = expectedRevenue - investment;
        System.out.println();
        System.out.println("==================================");
        System.out.println("      INVENTORY REPORT");
        System.out.println("==================================");
        System.out.println("Product Name     : " + productName);

        System.out.printf("Purchase Price   : Rs. %,.2f%n", purchasePrice);
        System.out.printf("Selling Price    : Rs. %,.2f%n", sellingPrice);
        System.out.println("Available Stock  : " + availableStock);
        System.out.println("----------------------------------");
        System.out.printf("Investment       : Rs. %,.2f%n", investment);
        System.out.printf("Expected Revenue : Rs. %,.2f%n", expectedRevenue);

        if (expectedProfit > 0) {
            System.out.printf("Expected Profit  : Rs. %,.2f%n", expectedProfit);
        }
        else if (expectedProfit == 0) {
            System.out.printf("Expected Profit  : Rs. %,.2f (Break-even)%n", expectedProfit);
        }
        else {
            System.out.printf("Expected Profit  : Rs. %,.2f (Loss)%n", expectedProfit);
        }

        if (availableStock == 0) {
            System.out.println("Stock Status     : Out of Stock");
        }
        else if (availableStock <= 3) {
            System.out.println("Stock Status     : Low Stock");
        }
        else {
            System.out.println("Stock Status     : Good Stock");
        }
        System.out.println("==================================");
    }
    public static void salesManagement(){

        System.out.println();
        System.out.println("==================================");
        System.out.println("       SALES MANAGEMENT");
        System.out.println("==================================");

        if (availableStock == 0) {
            System.out.println("No inventory found!");
            System.out.println("Please add inventory first.");
            return;
        }

        System.out.println("Product Name    : " + productName);
        System.out.println("Available Stock : " + availableStock);

        System.out.print("Enter Quantity to Sell: ");
        soldQuantity = scanner.nextInt();
        scanner.nextLine();

        processSaleReport();
    }
    public static void processSaleReport() {
        System.out.println();
        System.out.println("==================================");
        System.out.println("        SALES REPORT");
        System.out.println("==================================");
        if (soldQuantity > 0 && soldQuantity <= availableStock) {
            remainingStock = availableStock - soldQuantity;
            saleAmount = sellingPrice * soldQuantity;
            costOfGoods = purchasePrice * soldQuantity;
            actualProfit = saleAmount - costOfGoods;
            System.out.println("Product Name      : " + productName);
            System.out.println("Available Stock   : " + availableStock);
            System.out.println("Sold Quantity     : " + soldQuantity);
            System.out.println("Remaining Stock   : " + remainingStock);
            System.out.println("----------------------------------");
            System.out.printf("Sale Amount       : Rs. %,.2f%n", saleAmount);
            System.out.printf("Cost of Goods     : Rs. %,.2f%n", costOfGoods);
            System.out.printf("Actual Profit     : Rs. %,.2f%n", actualProfit);
            System.out.println("----------------------------------");
            System.out.println("Sale Status       : SUCCESS");
            availableStock = remainingStock;

            if (remainingStock == 0) {
                System.out.println("Stock Status      : Out of Stock");
            }
            else if (remainingStock <= 3) {
                System.out.println("Stock Status      : Low Stock");
            }
            else {
                System.out.println("Stock Status      : Good Stock");
            }
        }

        else {
            System.out.println("Product Name      : " + productName);
            System.out.println("Available Stock   : " + availableStock);
            System.out.println("Requested Quantity: " + soldQuantity);

            System.out.println("----------------------------------");
            System.out.println("SALE FAILED");
            if (soldQuantity <= 0) {
                System.out.println("Reason: Invalid Quantity");
            }
            else {
                System.out.println("Reason: Insufficient Stock");
            }
        }
        System.out.println("==================================");
    }
    public static void expenseManagement(){
        System.out.println();
        System.out.println("==================================");
        System.out.println("     EXPENSE MANAGEMENT");
        System.out.println("==================================");
        System.out.print("Expense Name : ");
        expenseName = scanner.nextLine();

        System.out.print("Expense Amount : ");
        expenseAmount = scanner.nextDouble();
        scanner.nextLine();
        if (expenseAmount <= 0) {

            System.out.println("Invalid Expense Amount!");
            return;

        }
        totalExpenses += expenseAmount;
        printExpenseReport();
    }
    public static void printExpenseReport(){
        System.out.println();
        System.out.println("==================================");
        System.out.println("       EXPENSE REPORT");
        System.out.println("==================================");

        System.out.println("Expense Name     : " + expenseName);
        System.out.printf("Expense Amount   : Rs. %,.2f%n", expenseAmount);
        System.out.println("----------------------------------");
        System.out.printf("Total Expenses   : Rs. %,.2f%n", totalExpenses);
        if (expenseAmount >= 10000) {
            System.out.println("Expense Status   : High Expense");
        }
        else {
            System.out.println("Expense Status   : Normal Expense");
        }
        System.out.println("==================================");
    }
    public static void profitAnalyzer(){
        System.out.println();
        System.out.println("==================================");
        System.out.println("       PROFIT ANALYZER");
        System.out.println("==================================");
        if (saleAmount == 0) {
            System.out.println("No sales record found.");
            System.out.println("Please complete a sale first.");
            return;
        }
        netProfit = actualProfit - totalExpenses;
        System.out.printf("Actual Profit  : Rs. %,.2f%n", actualProfit);
        System.out.printf("Total Expenses : Rs. %,.2f%n", totalExpenses);
        System.out.println("----------------------------------");
        System.out.printf("Net Profit     : Rs. %,.2f%n", netProfit);
        if (netProfit > 0) {
            System.out.println("Business Status : Profit");
        }
        else if (netProfit == 0) {
            System.out.println("Business Status : Break-even");
        }
        else {
            System.out.println("Business Status : Loss");
        }
        System.out.println("==================================");
    }
    public static void businessSummary(){
        if (productName == null) {
            System.out.println("No business data available.");
            System.out.println("Please complete Inventory and Sales first.");
            return;
        }
        System.out.println();
        System.out.println("==================================");
        System.out.println("      BUSINESS SUMMARY");
        System.out.println("==================================");
        System.out.println("Product Name     : " + productName);
        System.out.println("Available Stock  : " + availableStock);
        System.out.println("Sold Quantity    : " + soldQuantity);
        System.out.println("----------------------------------");

        System.out.printf("Sale Amount      : Rs. %,.2f%n", saleAmount);
        System.out.printf("Total Expenses   : Rs. %,.2f%n", totalExpenses);
        System.out.printf("Net Profit       : Rs. %,.2f%n", netProfit);
        System.out.println("----------------------------------");

        if (netProfit > 0) {
            System.out.println("Business Status  : Running in Profit");
        }
        else if (netProfit == 0) {
            System.out.println("Business Status  : Break-even");
        }
        else {
            System.out.println("Business Status  : Running in Loss");
        }

        if (availableStock == 0) {
            System.out.println("Stock Status     : Out of Stock");
        }
        else if (availableStock <= 3) {
            System.out.println("Stock Status     : Low Stock");
        }
        else {
            System.out.println("Stock Status     : Good Stock");
        }
        System.out.println("==================================");
    }
    public static void exitProgram() {
        System.out.println();
        System.out.println("==================================");
        System.out.println(" Thank you for using BizTrack");
        System.out.println("==================================");
        System.out.println("Your business data has been processed successfully.");
        System.out.println("Good Luck with your Business!");
        System.out.println("Exiting Program...");
        System.out.println("==================================");
        scanner.close();
    }
}
