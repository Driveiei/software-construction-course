package lec10observer.weatherorama.ver1;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HumidityAverageDisplay implements Observer{
	private JFrame frame;
	private JTextArea area;
	private double cumulativeHumid;
	private int count;

	public HumidityAverageDisplay() {
	        frame = new JFrame();
	        frame.setSize(200, 200);
	        frame.setTitle("Average humidity");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);

	        area = new JTextArea(150, 150);
	        frame.add(area);
	        area.setBackground(Color.BLUE);
	        area.setText("Average humidity:\n\n");
	        count = 1;
	    }

	@Override
	public void update(double temp, double humid, double pressure) {
		double avg;
		if (count == 1) {
            avg = humid;
		}
		else 
			avg = (cumulativeHumid + humid)/count;
		cumulativeHumid += humid;
		count++;
        area.setBackground(Color.BLUE);
        area.setText("Average Humidity:\n");
        area.append("Humidity = "+avg);
	}
}
