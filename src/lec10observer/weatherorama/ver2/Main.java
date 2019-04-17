package lec10observer.weatherorama.ver2;

public class Main {

    public static void main(String[] args) {
        // subject
        WeatherData weatherData = new WeatherData();
        OceanData oceanData = new OceanData();
        PollutionData pollutionData = new PollutionData();

        // observers
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();

        // connect subject and observers
        weatherData.registerObserver(currentConditionDisplay);
        weatherData.registerObserver(statisticsDisplay);
        oceanData.registerObserver(currentConditionDisplay);
        oceanData.registerObserver(statisticsDisplay);
        pollutionData.registerObserver(currentConditionDisplay);
        pollutionData.registerObserver(statisticsDisplay);

        // input receives new data from a user via System.in
        // whenever a user inputs new data, all observers are
        // updated
        InputUI inputUI = new InputUI();
        inputUI.receive(weatherData, oceanData, pollutionData);
    }
}
