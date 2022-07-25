/**
 * @ Shahar Gilad 204058887
 * 
 * This class represents the flight schedule at the airport in 24 hours. 
 *
 * @1.0
 */
public class Airport
{
    private final int MAX_FLIGHTS = 200, MIN_FLIGHTS = 0;
    private int _noOfFlights;
    private Flight[] _flightsSchedule;
    private String _city;
    
    
    /**
     * Constructor for a Airport object.
     * @param city The Airport's city location.
     */
    public Airport(String city){
        _flightsSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = 0;
        _city = new String(city);
    }
    
    /**
     * Add flight to array.
     * @param f The Flight to add.
     * @return True if successful, otherwise false.
     */
    public boolean addFlight(Flight f){
        if(_noOfFlights == MAX_FLIGHTS)
            return false;
            
        if(f.getOrigin().equals(_city) || f.getDestination().equals(_city))
        {
            _flightsSchedule[_noOfFlights++] = new Flight(f);
            return true;
        }
        
        return false;
    }
    
    /**
     * Remove flight from the array.
     * @param f The Flight to remove.
     * @return True if successful, otherwise false.
     */
    public boolean removeFlight(Flight f){
        int i;
        for(i = 0; i < _noOfFlights; i++){
            if(_flightsSchedule[i].equals(f)){ //find flight to remove
                for(int j = i; j < _noOfFlights-1;j++){// move the rest of flight 1 step back except the last one
                    _flightsSchedule[j] = _flightsSchedule[j+1]; // move from right to left
                }
                _flightsSchedule[_noOfFlights-1] = null; //make the lase index null
                _noOfFlights--;
                return true;
            }
        }
        return false;
    }
    
    /**
     * Return the first flight from origin that given us.
     * @param place The city to check the first flight .
     * @return Time1 if successful, otherwise null.
     */
    public Time1 firstFlightFromOrigin(String place){
        if(place.equals("") || place == null){
            return null;
        }
        
        if(_noOfFlights == MIN_FLIGHTS){
            return null;
        }
        
        int numberOfFlightsFrom = 0; // counter for how many flights with origen = place
        Flight[] theFlightsFromOrigen = new Flight[MAX_FLIGHTS];// temp array contain flights with origen = place
        for(int i = 0; i < _noOfFlights; i++){
            if(_flightsSchedule[i].getOrigin().equals(place)){
                theFlightsFromOrigen[numberOfFlightsFrom++] = new Flight(_flightsSchedule[i]); // add flight to temp array
            }
        }
        
        if(numberOfFlightsFrom == MIN_FLIGHTS)
            return null;
        
        Flight first = new Flight(theFlightsFromOrigen[0]); // assume the first in the array is earlier
        for(int j = 1 ; j < numberOfFlightsFrom; j++){
            if(theFlightsFromOrigen[j].landsEarlier(first)){ // check the other flights in the array
               first =  new Flight(theFlightsFromOrigen[j]);
            }
        }
        return new Flight(first).getDeparture();
    }
    
    
    /**
     * Return the amount of full flights.
     * @return The amount of full flights.
     */
    public int howManyFullFlights(){
        int howManyFull = 0;
        if(_noOfFlights == MIN_FLIGHTS)
            return howManyFull;
        for(int i = 0 ; i < _noOfFlights ; i++){
            if(_flightsSchedule[i].getIsFull()){
                howManyFull++;
            }
        }
        return howManyFull;
    }
    
    
    /**
     * Return the amout of flights that the place give us in flight's distination or origin.
     * @param place The city to check.
     * @return The amout of flights that place is in distination or origin.
     */
    public int howManyFlightsBetween(String place){
        int howManyBetween = 0;
        
        if(place.equals("") || place == null){
            return howManyBetween;
        }
        
        if(_noOfFlights == MIN_FLIGHTS){
            return howManyBetween;
        }
        
        
        for(int i = 0 ; i < _noOfFlights ; i++){
            //check for every fligt if place is in origin or destination
            if(_flightsSchedule[i].getOrigin().equals(place) || _flightsSchedule[i].getDestination().equals(place)){ 
                howManyBetween++;
            }
        }
        return howManyBetween;
    }
    
    
    /**
     * Return a string representation flights schedule at the airport.
     * @return String representation flights schedule at the airport.
     */
    public String toString(){
        if(_noOfFlights == MIN_FLIGHTS){
            return null;
        }
        String str = new String("The flights for airport " + _city + " today are: \n");
        for(int i = 0 ; i < _noOfFlights ; i++){
            str = new String(str + _flightsSchedule[i].toString());
            if(i != _noOfFlights - 1){
               str =  new String(str + "\n");
            }
        }
        return str;
    }
    
    
    /**
     * Return the most popular destination in the flights array.
     * @return The most popular destination in the flights array.
     */
    public String mostPopularDestination(){
        
        if(_noOfFlights == MIN_FLIGHTS)
            return null;
        
        String mostPopuCity = _flightsSchedule[0].getDestination(); // assume the first destination is most populare
        String tempCity; // temp city for checking
        int countCity = 0;
        int tempCountCity =0;
        
        for(int i = 0 ; i < _noOfFlights; i++){
            tempCity = _flightsSchedule[i].getDestination();
            for(int j = 0; j < _noOfFlights; j++){
                if(tempCity.equals(_flightsSchedule[j].getDestination())){
                    tempCountCity++; //add how many times the destination equals to tempCity
                }
            }
            if(countCity < tempCountCity){ // if tempCountCity bigger then the current value in countCity
                countCity = tempCountCity;
                mostPopuCity = tempCity;
            }
            tempCountCity = 0; //restart tempCountCity to zero befor loop
        }
        return mostPopuCity;
    }
    
    
    /**
     * Return the most expensive flight.
     * @return Flight most expensive flight.
     */
    public Flight mostExpensiveTicket(){
        
        if(_noOfFlights == MIN_FLIGHTS)
            return null;
        
        int mostExpensivePrice = 0;
        int mostExpensiveIndex = 0;
        
        for(int i = 0; i < _noOfFlights; i++){
            if(_flightsSchedule[i].getPrice() > mostExpensivePrice){// check if flight's price is more expensive from mostExpensivePrice
                mostExpensivePrice = _flightsSchedule[i].getPrice(); // put the expensive price in mostExpensivePrice
                mostExpensiveIndex = i; // save most expensive index
            }
        }
        
        return new Flight(_flightsSchedule[mostExpensiveIndex]);
    }
    
    
    /**
     * Return the longest flight duration.
     * @return Flight longest flight duration.
     */
    public Flight longestFlight(){
        
        if(_noOfFlights == MIN_FLIGHTS)
            return null;
        
        int longFlight = 0;
        int longFlightIndex = 0;
        
        for(int i = 0; i < _noOfFlights; i++){
            if(_flightsSchedule[i].getFlightDuration() > longFlight){
               longFlight = _flightsSchedule[i].getFlightDuration();
               longFlightIndex = i;
            }
        }
        
        return new Flight(_flightsSchedule[longFlightIndex]);
    }
}
