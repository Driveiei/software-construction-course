package lec10observer.weatherorama.ver2;

import javax.swing.*;
import java.awt.*;

public class StatisticsDisplay implements Observer {

	private double prevTemp;
	private double prevWave;

	private JFrame frame;
	private JTextArea weatherArea;
	private JTextArea oceanArea;

	public StatisticsDisplay() {

		frame = new JFrame();
		frame.setSize(200, 400);
		frame.setTitle("Current Condition");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		weatherArea = new JTextArea(200, 200);
		weatherArea.setBackground(Color.ORANGE);
		weatherArea.setText("Current Weather:\n\n");

		oceanArea = new JTextArea(200, 200);
		oceanArea.setBackground(Color.GRAY);
		oceanArea.setText("Current Ocean:\n\n");

		frame.setLayout(new GridLayout(2, 1));
		frame.add(weatherArea);
		frame.add(oceanArea);

	}

	@Override
	public void update(Subject data) {
		if (data instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) data;

			if (prevTemp == 0)
				prevTemp = weatherData.getTemperature();
			double avgTemp = (prevTemp + weatherData.getTemperature()) / 2;
			prevTemp = avgTemp;

			weatherArea.setBackground(Color.ORANGE);
			weatherArea.setText("Average Temperature:\n");
			weatherArea.append("Temperature = " + avgTemp);
		}
		if (data instanceof OceanData) {
			OceanData oceanData = (OceanData) data;

			if (prevWave == 0)
				prevWave = oceanData.getWaveHeight();
			double avgWave = (prevWave + oceanData.getWaveHeight()) / 2;
			prevWave = avgWave;

			oceanArea.setBackground(Color.GRAY);
			oceanArea.setText("Average Wave Height:\n");
			oceanArea.append("Wave Height = " + avgWave);
		}
	}
}
