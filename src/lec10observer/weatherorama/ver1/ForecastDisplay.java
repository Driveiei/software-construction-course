package lec10observer.weatherorama.ver1;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ForecastDisplay implements Observer{
	private JFrame frame;
	private JTextArea area;
	private double cumulativeTemperature;
	private int count;

	public ForecastDisplay() {
	        frame = new JFrame();
	        frame.setSize(200, 200);
	        frame.setTitle("Predict Temperature");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);

	        area = new JTextArea(150, 150);
	        frame.add(area);
	        area.setBackground(Color.YELLOW);
	        area.setText("Predict Temperature:\n\n");
	        count = 1;
	    }

	@Override
	public void update(double temp, double humid, double pressure) {
		double avg;
		if (count == 1) {
            avg = humid;
		}
		else 
			avg = (cumulativeTemperature + humid)/count;
		cumulativeTemperature += humid;
		count++;
        area.setBackground(Color.YELLOW);
        area.setText("Temperature:\n");
        area.append("Predict Temperature = "+avg);
	}
}
