package app.client;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import app.client.model.ClientCommonData;
import app.client.model.DataStat;

/**
 *  This class observes data changes for statistics like highest value,
 *  lowest value and the average. When any data changes are observed, 
 *  it informes the dataStat class to perform the changes on the User
 *  Interface.
 *
 */
public class DataStatObserver implements Observer{

	private DataStat stat;
	
	public DataStat getStat() {
		return stat;
	}

	public void setStat(DataStat stat) {
		this.stat = stat;
	}

	/*
	 * This method calculates the highest, lowest values received from 
	 * the server and calculates the average from them. After this it 
	 * returns the DataStat Model containing all the information.
	 * 
	 * @param: list: Pass the list of values for which the
	 * calculation has to be done.
	 * 
	 * @return: returns the DataStat model containing the prescribed values.
	 *  
	 */
	public static DataStat findStats(List<Integer> list) {
		
		int maxValue = Integer.MIN_VALUE;
		int minValue = Integer.MAX_VALUE;
		float sum = 0;
		
		for(int x : list) {
			if(x > maxValue)
				maxValue = x;
			if(x < minValue)
				minValue = x;
			sum += x;
		}
		
		DataStat stat = new DataStat();
		stat.setHighest(maxValue);
		stat.setLowest(minValue);
		stat.setAverage(sum/list.size());
		
		return stat;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		ClientCommonData data=(ClientCommonData) o;
		// list = data.getMyData();
		List<Integer> listOfValuesFromServer=data.getListOfAllValues();
		//List<Integer> list = new ArrayList<Integer>();
		//setStat(findStats(list));
		DataStat finalStats=findStats(listOfValuesFromServer);
		ClientCommonData.getInstance().updateAverage(finalStats.getAverage());
		ClientCommonData.getInstance().updateMaxValue(finalStats.getHighest());
		ClientCommonData.getInstance().updateMinvalue(finalStats.getLowest());
		
		
		
	}

}
