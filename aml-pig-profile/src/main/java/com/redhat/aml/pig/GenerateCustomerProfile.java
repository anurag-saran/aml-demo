package com.redhat.aml.pig;
import java.io.IOException;
import java.util.*;
import org.apache.pig.PigServer;
import org.apache.pig.backend.executionengine.ExecException;
import java.util.Properties;
import org.apache.pig.ExecType;
import org.apache.pig.data.Tuple;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.ArrayList;

public class GenerateCustomerProfile {

	public static void main(String[] args) throws ExecException, IOException {
		// TODO Auto-generated method stub
		 Properties props = new Properties();
		 props.setProperty("fs.default.name", "hdfs://localhost:8020");
	
		 //props.setProperty("mapred.job.tracker", "<jobtracker-hostname>:<port>");
		 PigServer pigServer = new PigServer(ExecType.MAPREDUCE);
	  
	      try {
	         runMyQuery(pigServer, "hdfs://localhost:8020/user/aml-demo/trans.txt", "hdfs://localhost:8020/user/aml-demo/account.txt");
	        } 
	      catch (IOException e) {
	         e.printStackTrace();
	        }
	   }
	   
	   public static void runMyQuery(PigServer pigServer, String trans, String account) throws IOException {        
		pigServer.registerQuery("transaction = load '" + trans + "' using PigStorage(',') as (TransactionID:int,AccountNo:int,FirstName:chararray,LastName:chararray,Amount:int,TransactionType:chararray,FromZipCode:chararray,ToZipCode:chararray,IPAddress:chararray,DeviceLocation:chararray,Country:chararray,State:chararray);");
		pigServer.registerQuery("account = load '" + account + "' using PigStorage(',') as (AccountNo:int, FirstName:chararray, LastName:chararray, Street:chararray, City:chararray, State:chararray, ZipCode:chararray, Occupation:chararray, Age:int, Sex:chararray,MaritalStatus:chararray, AccountType:chararray);");
		pigServer.registerQuery("C = foreach account generate AccountNo as id, ZipCode,Occupation;");
		pigServer.registerQuery("jnd = join transaction by AccountNo, C by id;");
		pigServer.registerQuery("D = group jnd by (C::ZipCode,transaction::TransactionType,C::Occupation);");
		pigServer.registerQuery("E = foreach D generate flatten(group) as (zip,Tranaction,occupation),SUM($1.Amount) as total_spent,COUNT(jnd) as numOfTransactions,AVG($1.Amount) as avg;");
  		//pigServer.store("E", "/user/pig/anurag/data/idout");   
		Iterator<Tuple> itr = pigServer.openIterator("E");
		Tuple tup;
		//tup = itr.next();
		CustomerProfile customer;
		CustomerProfileList profileList=new CustomerProfileList();
		ArrayList<CustomerProfile> customerList = new ArrayList<CustomerProfile>();
//		customer.setId(10039);
//10039,DR,IceCreamShop,650,2,325.0
		while(itr.hasNext())
		{
		customer=new CustomerProfile();
		tup = itr.next();
		customer.setTranstype((String)tup.get(1));
		System.out.print("1");
		customer.setOccu((String)tup.get(2));
		System.out.print("2");
		customer.setSpend((String)tup.get(3));
		System.out.print("3");
		customer.setNumtr((String)tup.get(4));
		System.out.print("4");
		customer.setId((String)tup.get(0));
		System.out.print("5");
		customer.setAvg((String)tup.get(5));
		System.out.print("6");
		//System.out.print(element + " ");
		customerList.add(customer);
		}
//		System.out.println(tup);
		try{

		profileList.setCustomerList(customerList);
		File file = new File("/usr/aml-demo/custprofilelist.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(CustomerProfileList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();


		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(profileList, file);
		jaxbMarshaller.marshal(profileList, System.out);
		}catch (JAXBException e){
		e.printStackTrace();
		}
		
				
	}

	}



