
/**
 * @ Shahar Gilad
 * Time2 Represents time - hours:minutes.
 *
 * @1.0
 */
public class Time2
{
    public final int MAX_HOURS = 23, MAX_MINUTES = 59, DEFAULT_VAL = 0;
    public final int HOURS_IN_DAY = 24, MINUTES_IN_HOUR=60;
    public final int MINUTES_IN_DAY = HOURS_IN_DAY * MINUTES_IN_HOUR;
    private int _minFromMid;
    
    /**
     * Constructs a Time2 object. Construct a new time instance with the specified hour and minute .
     * @param h the hour of the time
     * @param m the minute of the time
     */
    public Time2(int h,int m){
        int hour = (h >= DEFAULT_VAL && h <= MAX_HOURS) ? h : DEFAULT_VAL;
        int minute = (m >= DEFAULT_VAL && m <= MAX_MINUTES) ? m : DEFAULT_VAL;
        _minFromMid = hour * MINUTES_IN_HOUR + minute;
    }
    
    /**
     * Copy constructor for Time2.
     * @param other The time object from which to construct the new time
     */
    public Time2(Time2 other){
        _minFromMid = other._minFromMid;
    }
    
    /**
     * Returns the hour of the time.
     * @return The hour of the time.
     */
    public int getHour(){
        return _minFromMid / MINUTES_IN_HOUR;
    }
    
    /**
     * Returns the minute of the time.
     * @return The minute of the time.
     */
    public int getMinute(){
        return _minFromMid % MINUTES_IN_HOUR;
    }
    
    /**
     * Changes the hour of the time. If an illegal number is received hour will be unchanged.
     * @param num The new hour
     */
    public void setHour(int num){
        int min;
        if(num >= DEFAULT_VAL && num <= MAX_HOURS){
            min = this.getMinute();
            _minFromMid = (num * MINUTES_IN_HOUR) + min;
        }
            
    }
    
    /**
     * Changes the minute of the time. If an illegal number is received minute will be unchanged.
     * @param num The new minute
     */
    public void setMinute(int num){
        int hour;
        if(num >= DEFAULT_VAL && num <= MAX_MINUTES){
           hour = _minFromMid / MINUTES_IN_HOUR;
           _minFromMid = num + (hour * MINUTES_IN_HOUR);
        }
        
    }
    
    /**
     * Return the amount of minutes since midnight.
     * @return amount of minutes since midnight.
     */
    public int minFromMidnight(){
        return _minFromMid;
    }
    
    /**
     * Checks if the received time is equal to this time.
     * @param other The time to be compared with this time
     * @return True if the received time is equal to this time
     */
    public boolean equals(Time2 other){
        return (other._minFromMid == _minFromMid);
    }
    
    /**
     * Checks if this time is before a received time.
     * @param other The time to check if this point is before
     * @return True if this time is before other time
     */
    public boolean before(Time2 other){
        return _minFromMid < other._minFromMid;
    }
    
    /**
     * Checks if this time is after a received time.
     * @param other The time to check if this point is after
     * @return True if this time is after other time
     */
    public boolean after(Time2 other){
        return other.before(this);
    }
    
    /**
     * Calculates the difference (in minutess) between two times.
     * @param other The time to check the difference with.
     * @return int difference in minutes
     */
    public int difference(Time2 other){
        return _minFromMid - other._minFromMid;
    }
    
    /**
     * Returns a string representation of this time(hh:mm).
     * @return String representation of this time(hh:mm).
     */
    public String toString(){
        int hours = _minFromMid / MINUTES_IN_HOUR;
        int minutes = _minFromMid % MINUTES_IN_HOUR;
        return ((hours < 9) ? "0" + hours : hours) 
           + ":" + ((minutes < 9) ? "0" + minutes : minutes);
    }
    
    /**
     * Copy current object and add requested minutes to new object.
     * @param num The minutes need to add.
     * @return new update Time1 object.
     */
    public Time2 addMinutes(int num){
        num  = num % MINUTES_IN_DAY; // num should be between +minutes a day and -minutes a day 
        int minFromYesterdayMidnight = MINUTES_IN_DAY + minFromMidnight() + num; // Add a day in minutes to handle yesterday.
        int h = (minFromYesterdayMidnight / MINUTES_IN_HOUR) % HOURS_IN_DAY;
        int m = minFromYesterdayMidnight % MINUTES_IN_HOUR;
        return new Time2(h, m);
    }
}
