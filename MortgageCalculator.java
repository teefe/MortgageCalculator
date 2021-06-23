package com.company;

import java.text.NumberFormat;

public class MortgageCalculator {

    final byte MONTHS_IN_YEAR = 12;
    final  byte PERCENT =100;
    public  double principal;
    private  int numberofPayments;
    private  double monthlyinterestrate;
    public  double annualInterestRate;
    public  int period;
    private  double Mortgage;

    public  double mortgageBalanceLogic(double numberofPaymentsmade){
        double balance = getPrincipal() * (Math.pow(1 + getMonthlyinterestrate(), getNumberofPayments())
                - Math.pow(1 + getMonthlyinterestrate(), numberofPaymentsmade)) /
                (Math.pow(1 + getMonthlyinterestrate(), getNumberofPayments()) - 1);
        return balance;
    }

    public  double mortgageCalculator(double principal)
    {
         setMonthlyinterestrate(getAnnualInterestRate() / PERCENT / MONTHS_IN_YEAR);
        setNumberofPayments((getPeriod() * MONTHS_IN_YEAR));

        setMortgage(principal * (getMonthlyinterestrate() * Math.pow(1+ getMonthlyinterestrate(), getNumberofPayments()))
                / ((Math.pow( 1 + getMonthlyinterestrate(), getNumberofPayments())) - 1));

        return getMortgage();
    }

    public int getNumberofPayments() {
        return numberofPayments;
    }

    public void setNumberofPayments(int numberofPayments) {
        this.numberofPayments = numberofPayments;
    }

    public double getMonthlyinterestrate() {
        return monthlyinterestrate;
    }

    public void setMonthlyinterestrate(double monthlyinterestrate) {
        this.monthlyinterestrate = monthlyinterestrate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public  int getPeriod() {
        return period;
    }

    public  double getMortgage() {
        return Mortgage;
    }

    public  void setMortgage(double mortgage) {
        Mortgage = mortgage;
    }

    public static String currencyFormatter( double number) {
        String FormatedCurrency = NumberFormat.getCurrencyInstance().format(number);
        return FormatedCurrency;
    }

    public  double getPrincipal() {
        return principal;
    }

    public  void printBalance(){

        for (int months = 1; months <=(getPeriod() * MONTHS_IN_YEAR) ; months++) {
            System.out.println(currencyFormatter( mortgageBalanceLogic(months)));
        }
    }
}
