package app.client.model;

/**
 * Model class to represent X and Y coordinate for the graph.
 * 
 * @author vishakhasingal
 * @version 1.0
 * @since February,2018
 *
 */
public class CoordinatesModel {

	private double xCoordinate;
	private double yCoordinate;

	/**
	 * Class constructor
	 * 
	 * @param xCoordinate
	 *            pass the x coordinate of the graph
	 * @param yCoordinate
	 *            pass the y coordinate of the graph
	 */
	public CoordinatesModel(double xCoordinate, double yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}

	/**
	 * @return the xCoordinate
	 */
	public double getxCoordinate() {
		return xCoordinate;
	}

	/**
	 * @param xCoordinate
	 *            the xCoordinate to set
	 */
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	/**
	 * @return the yCoordinate
	 */
	public double getyCoordinate() {
		return yCoordinate;
	}

	/**
	 * @param yCoordinate
	 *            the yCoordinate to set
	 */
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	/**
	 * Overriding the toString method to return a coordinate model.
	 */
	@Override
	public String toString() {
		return "CoordinatesModel [xCoordinate=" + xCoordinate + ", yCoordinate="
				+ yCoordinate + "]";
	}

}
