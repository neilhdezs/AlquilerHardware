package es.nhs.alquilerhardware.utils;

import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Neil Hdez
 * this class is used to check if the one day of the week is the weekend or not
 */
@Service
public class CheckerDayOfWeek
{

    public boolean isWeekend(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

}
