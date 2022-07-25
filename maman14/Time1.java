
/**
 * @ Shahar Gilad
 * Time1 Represents time - hours:minutes.
 *
 * @1.0
 */
public class Time1
{
    public final int MAX_HOURS = 23, MAX_MINUTES = 59, DEFAULT_VAL = 0;
    public final int HOURS_IN_DAY = 24, MINUTES_IN_HOUR=60;
    public final int MINUTES_IN_DAY = HOURS_IN_DAY * MINUTES_IN_HOUR;

    private int _hour, _minute;

    /**
     * Construct a new time instance with the specified hour and minute.
     * @param h the hour of the time
     * @param m the minute of the time
     */
    public Time1(int h,int m){
        _hour = (h >= DEFAULT_VAL && h <= MAX_HOURS) ? h : DEFAULT_VAL;
        _minute = (m >= DEFAULT_VAL && m <= MAX_MINUTES) ? m : DEFAULT_VAL;
    }
    
    /**
     * Copy constructor for Time1.
     * @param other The time object from which to construct the new time
     */
    public Time1(Time1 other){
       _hour = other._hour;
       _minute = other._minute;
    }
    
    /**
     * Returns the hour of the time.
     * @return The hour of the time
     */
    public int getHour(){
        return _hour;
    }
    
    /**
     * Returns the minute of the time.
     * @return The minute of the time
     */
    public int getMinute(){
        return _minute;
    }
    
    /**
     * Changes the hour of the time. If an illegal number is received hour will be unchanged.
     * @param num The new hour
     */
    public void setHour(int num){
        if(num >= DEFAULT_VAL && num <= MAX_HOURS)
            _hour = num;
    }
    
    /**
     * Changes the minute of the time. If an illegal number is received minute will be unchanged.
     * @param num The new minute
     */
    public void setMinute(int num){
        if(num >= DEFAULT_VAL && num <= MAX_MINUTES)
            _minute = num;
    }
    
    /**
     * Return a string representation of this time (hh:mm).
     * @return String representation of this time (hh:mm).
     */
    public String toString(){
       return ((_hour < 9) ? "0" + _hour : _hour) 
           + ":" + ((_minute < 9) ? "0" + _minute : _minute);
    }
    
    /**
     * Return the amount of minutes since midnight.
     * @return Amount of minutes since midnight.
     */
    public int minFromMidnight(){
        return ((_hour * 60) + _minute);
    }
    
    /**
     * Check if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    public boolean equals(Time1 other){
        return (other._hour == _hour && other._minute == _minute);
    }
    
    /**
     * Check if this time is before a received time.
     * @param other The time to check if this point is before
     * @return True if this time is before other time
     */
    public boolean before(Time1 other){
        if(_hour < other._hour){
            return true;
        }
        else if(_hour == other._hour && _minute < other._minute){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Check if this time is after a received time.
     * @param other The time to check if this point is after
     * @return True if this time is after other time
     */
    public boolean after(Time1 other){
        return other.before(this);
    }
    
    /**
     * Calculates the difference (in minutes) between two times.
     * @param other The time to check the difference to
     * @return int difference in minutes
     */
    public int difference(Time1 other){
        return minFromMidnight() - other.minFromMidnight();
    }
    
    /**
     * Copy current object and add requested minutes to new object.
     * @param num The minutes need to add.
     * @return new update Time1 object.
     */
    public Time1 addMinutes(int num){
        num  = num % MINUTES_IN_DAY; // num should be between +minutes a day and -minutes a day 
        int minFromYesterdayMidnight = MINUTES_IN_DAY + minFromMidnight() + num; // Add a day in minutes to handle yesterday.
        int h = (minFromYesterdayMidnight / MINUTES_IN_HOUR) % HOURS_IN_DAY;
        int m = minFromYesterdayMidnight % MINUTES_IN_HOUR;
        return new Time1(h, m);
    }
}
