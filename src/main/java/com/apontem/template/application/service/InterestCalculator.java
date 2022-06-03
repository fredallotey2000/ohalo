/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bvirtual.api.service;

/**
 *
 * @author Bsystems
 */
public class InterestCalculator {

    public static String calculateInterest(
            String nominalAnnualInterestRate,
            String periodsPerYear,
            String principal,
            String daysInYear
    ) {
        double interest = ((Double.parseDouble(nominalAnnualInterestRate) / 100)
                / Double.parseDouble(periodsPerYear) / Double.parseDouble(daysInYear))
                * Double.parseDouble(principal);
        return Double.toString(interest);
    }
}
