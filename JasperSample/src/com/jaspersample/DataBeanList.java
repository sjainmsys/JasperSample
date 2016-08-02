package com.jaspersample;

import java.util.ArrayList;

public class DataBeanList 
{
	   public ArrayList<DataBean> getDataBeanList() {
		      ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

		      dataBeanList.add(produce("Ankur", "Kataria"));
		      dataBeanList.add(produce("Arjun", "Sharma"));
		      dataBeanList.add(produce("Nishtha", "Garg"));

		      return dataBeanList;
		   }

		   /**
		    * This method returns a DataBean object,
		    * with name and country set in it.
		    */
		   private DataBean produce(String name, String country) {
		      DataBean dataBean = new DataBean();
		      dataBean.setName(name);
		      dataBean.setCountry(country);
		      
		      return dataBean;
		   }
}
