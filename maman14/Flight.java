
/**
 * @ Shahar Gilad 
 * Represents a flight. A Flight object is represented by the 
 * flight's origin,destination,departure time,
 * flight duration, no of passengers,if it is full and the price.
 *
 * @1.0
 */
public class Flight
{
    public final int MAX_CAPACITY = 250 ,DEFAULT_VAL = 0;
    private String _origin;
    private String _destination;
    private Time1 _departure;
    private int _flightDuration;
    private int _noOfPassengers;
    private boolean _isFull;
    private int _price;
    
    /**
     * Constructor for a Flight object.
     * @param origin The city the flight leaves from.
     * @param dest The city the flight lands at.
     * @param depHour the departure hour (should be between 0-23).
     * @param depMinute The departure minute (should be between 0-59).
     * @param durTimeMinutes The duration time in minutes(should not be negative).
     * @param noOfPass The number of passengers (should be between 0-maximum capacity).
     * @param price The price (should not be negative).
     */
    public Flight(String origin, String dest,
                    int depHour, int depMinute, 
                    int durTimeMinutes,
                    int noOfPass, int price){
        _origin = (origin.equals("") ? "israel" : origin);
        _destination = (dest.equals("") ? "germany" : dest);
        _departure = new Time1(depHour,depMinute);
        _flightDuration = (durTimeMinutes < DEFAULT_VAL) ? DEFAULT_VAL : durTimeMinutes;
        if(noOfPass > MAX_CAPACITY)
            _noOfPassengers = MAX_CAPACITY;
        else if(noOfPass < DEFAULT_VAL)
            _noOfPassengers = DEFAULT_VAL;
        else
            _noOfPassengers = noOfPass;
        _price = (price < DEFAULT_VAL) ? DEFAULT_VAL : price;
        _isFull = (_noOfPassengers == MAX_CAPACITY) ? true : false;
    }
    
    /**
     * Copy constructor for a Flight object.
     * @param other The Flight object from which to construct the new Flight.
     */
    public Flight(Flight other){
        _origin = other._origin;
        _destination = other._destination;
        _departure = new Time1(other._departure);
        _flightDuration = other._flightDuration;
        _noOfPassengers = other._noOfPassengers;
        _isFull = other._isFull;
        _price = other._price;
    }
    
    /**
     * Returns the flight origin.
     * @return The flight origin.
     */
    public String getOrigin(){
        return _origin;
    }
    
    /**
     * Returns the flight destination.
     * @return The flight destination.
     */
    public String getDestination(){
        return _destination;
    }
    
    /**
     * Returns the flight departure time.
     * @return A copy of the flight departure time.
     */
     public Time1 getDeparture(){
         return new Time1(_departure);
     }
     
    /**
     * Returns the flight duration time in minutes.
     * @return The flight duration.
     */
    public int getFlightDuration(){
        return _flightDuration;
    }
    
    /**
     * Returns the number of passengers on the flight.
     * @return The number of passengers.
     */
    public int getNoOfPassengers(){
        return _noOfPassengers;
    }
    
    /**
     * Returns whether the flight is full or not.
     * @return True if the flight is full.
     */
    public boolean getIsFull(){
        return _isFull;
    }
    
    /**
     * Returns the price of the flight.
     * @return The price.
     */
    public int getPrice(){
        return _price;
    }
    
    /**
     * Changes the flight's destination.
     * @param dest The flight's new destination.
     */
    public void setDestination(String dest){
        _destination = dest;
    }

    /**
     * Changes the flight's origin.
     * @param origin The flight's new origin.
     */
    public void setOrigin(String origin){
        _origin = origin;
    }
    
    /**
     * Changes the flight's departure time.
     * @param departureTime The flight's new departure time.
     */
    public void setDeparture(Time1 departureTime){
        _departure = new Time1(departureTime);
    }
    
    /**
     * Changes the flight's duration time.
     * If the parameter is negative the duration time will remain unchanged.
     * @param durTimeMinutes The flight's new duration time.
     */
    public void setFlightDuration(int durTimeMinutes){
        if(durTimeMinutes >= DEFAULT_VAL)
            _flightDuration = durTimeMinutes;
    }
    
    /**
     * Changes the number of passengers.
     * If the parameter is negative or larger than the maximum 
     * capacity the number of passengers will remain unchanged.
     * @param noOfPass The new number of passengers.
     */
    public void setNoOfPassengers(int noOfPass){
        if(noOfPass >= DEFAULT_VAL && noOfPass <= MAX_CAPACITY){
            if(noOfPass == MAX_CAPACITY) {
                _isFull = true;
            }
            _noOfPassengers = noOfPass;
        }
    }
    
    /**
     * Changes the flight price. If the parameter is negative the price will remain unchanged.
     * @param price The new price.
     */
    public void setPrice(int price){
        if(price > DEFAULT_VAL)
            _price = price;
    }
    
    /**
     * Return a string representation of this flight.
     * @return String representation of this flight.
     */
    public String toString(){
        return "Flight from " + _origin + " to " + _destination
            + " departs at " + _departure.toString() + ". Flight is " +
            ((_isFull) ? "" : "not ") + "full.";
    }
    
    /**
     * Check if the received flight is equal to this flight.
     * @param other The flight to be compared with this flight.
     * @return True if the received flight is equal to this flight.
     */
    public boolean equals(Flight other){
        return (other._origin.equals(_origin) && other._destination.equals(_destination) 
                && other._departure.equals(_departure));
    }
    
    /**
     * Returns the arrival time of the flight.
     * @return The arrival time of this flight.
     */
    public Time1 getArrivalTime(){
        return _departure.addMinutes(_flightDuration);
    }
    
    /**
     * Add passengers to this flight.
     * @param num The number of passengers to be added to this flight.
     * @return True if the passengers were added to the flight.
     */
    public boolean addPassengers(int num){
        if(_noOfPassengers + num > MAX_CAPACITY)
            return false;
        _noOfPassengers += num;
        if(_noOfPassengers == MAX_CAPACITY)
            _isFull = true;
        return true;
    }
    
    /**
     * Check if this flight is cheaper than another flight.
     * @param other The flight whose price is to be compared with this flight's price.
     * @return True if this flight is cheaper than the received flight.
     */
    public boolean isCheaper(Flight other){
        return _price < other._price;
    }
    
    /**
     * Calculate the total price of the flight.
     * @return The total price of the flight.
     */
    public int totalPrice(){
        return _noOfPassengers * _price;
    }
    
    /**
     * Check if this flight lands before another flight.
     * @param other The flight whose arrival time to be compared with this flight's arrival time.
     * @return True if this flight arrives before the received flight.
     */
    public boolean landsEarlier(Flight other){
        Time1 thisLandTime = getArrivalTime();
        Time1 otherLandTime = other.getArrivalTime();
        return thisLandTime.before(otherLandTime);
    }
}
