package com.etienne.cellier.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

  /**
   * Convertit une chaîne de caractères en objet Date.
   *
   * @param dateString la chaîne de caractères représentant la date
   * @param format le format de la date (par exemple, "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
   * @return l'objet Date correspondant à la chaîne de caractères
   * @throws ParseException si la chaîne de caractères ne peut pas être analysée
   */
  public static Date convertStringToDate(String dateString, String format) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return dateFormat.parse(dateString);
  }

  public static String getDateOnlyFormat() {
    return "yyyy-MM-dd";
  }

  /**
   * Convertit une date en une date sans l'heure.
   *
   * @param date la date à convertir
   * @return la date sans l'heure
   * @throws ParseException si la date ne peut pas être analysée
   */
  public static Date stripTime(Date date) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat(getDateOnlyFormat());
    String dateString = dateFormat.format(date);
    return dateFormat.parse(dateString);
  }
}
