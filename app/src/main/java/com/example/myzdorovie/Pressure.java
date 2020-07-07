package com.example.myzdorovie;

import java.time.LocalDate;

public class Pressure {
  private   int userUpPressure;
  private   int userDownPressure;
  private   int userPulse;
  private boolean checkboxTachycardia;
  private LocalDate date;

    public Pressure(int userUpPressure, int userDownPressure, int userPulse, boolean checkboxTachycardia, LocalDate date) {
        this.userUpPressure = userUpPressure;
        this.userDownPressure = userDownPressure;
        this.userPulse = userPulse;
        this.checkboxTachycardia = checkboxTachycardia;
        this.date = date;
    }
}
