/*
Alexander Dutchak 1/20/22
Chapter 6, Problem 15, Page 239
Current Federal Tax Bracket info taken from:
https://www.nerdwallet.com/article/taxes/federal-income-tax-brackets
*/

public class TaxCalculator {

    public static void main(String[] args) {
        // print table headers
        System.out.println("Taxable income | Single | Married(jointly) | Married(separate) | Head of Household");
        System.out.println("_______________|________|__________________|___________________|__________________");
        // loop through possible incomes
        for (int income = 50000; income <= 60000; income += 50) {
            // array to organize data for each row of income
            double[] incomeRow = new double[4];
            // loop through status options
            for (int status = 0; status <= 3; status ++) {
                // compute tax and append to incomeRow
                incomeRow[status] = computeTax(status, income);
            }
            // print row
            System.out.println(income + "          |" + incomeRow[0] + "  |" + incomeRow[1] +
                    "            |" + incomeRow[2] + "             |" + incomeRow[3] + "            ");
        }
    }
    public static double computeTax(int status, double taxableIncome) {
        double tax;
        // calculate tax differently based on filing status
        if (status == 0 || status == 2) {
            // Single OR Married(separate filing)
            tax = 4664 + ((taxableIncome - 40525) * 0.22);
        }
        else if (status == 1) {
            // Married(joint filing)
            tax = 1990 + ((taxableIncome - 19900) * 0.12);
        }
        else {
            // Head of Household
            if (taxableIncome <= 54200) {
                tax = 1420 + ((taxableIncome - 14200) * 0.12);
            }
            else {
                tax = 6220 + ((taxableIncome - 54200) * 0.22);
            }
        }
        return tax;
    }
}
