package com.file.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadCSVFileInJava8 {

	
	
	public static void main(String[] args) {
		Path path = Paths.get("C:\\projects\\KIDataFiles\\FileReadInJava\\User_KI_CEB_old.txt");
		BufferedReader newBufferedReader = null;
		try {
			newBufferedReader = Files.newBufferedReader(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		List<String> header = readHeader(newBufferedReader);
//		System.out.println(header);
		List<Transaction> transactions = readJSONFile();
		transactions.forEach(System.out::println);
//		System.out.println(readRecordsWithBufferedReader(newBufferedReader));		
	}
	
	private static List<String> readHeader(BufferedReader newBufferedReader) {
        return newBufferedReader.lines()
				.findFirst()
				.map(line -> Arrays.asList(line.split(",")))
				.get();
    }
	
	private static List<List<String>> readRecordsWithBufferedReader(BufferedReader newBufferedReader){
		return newBufferedReader.lines()
				.skip(1)
				.map(line -> Arrays.asList(line.split(",")))
				.collect(Collectors.toList());
	}
	
	private static List<Transaction> readJSONFile() {
		try(BufferedReader reader = Files.newBufferedReader(Paths.get("C:\\projects\\KIDataFiles\\FileReadInJava\\Input_Transactions.txt"))){
			
			JSONParser jsonParser = new JSONParser();
			Object object = null;
			try {
				object = jsonParser.parse(reader);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			JSONArray jsonArray = (JSONArray) object;
			List<Transaction> collect = (List<Transaction>) jsonArray.stream().map(jsonObject -> getTransaction((JSONObject)jsonObject))
			.collect(Collectors.toList());
			return collect;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Transaction getTransaction(JSONObject jsonObject) {
		Transaction t = new Transaction();
		t.setTransactionId((long)jsonObject.get("TransactionId"));
		t.setInstrument((String)jsonObject.get("Instrument"));
		t.setTransactionType((String)jsonObject.get("TransactionType"));
		t.setTransactionQuantity((long)jsonObject.get("TransactionQuantity"));
		return t;
	}
}


class Transaction{
	
	private long transactionId;
	private String instrument;
	private String transactionType;
	private long transactionQuantity;
	
	
	public Transaction() {
		super();
	}
	public Transaction(long transactionId, String instrument, String transactionType, long transactionQuantity) {
		super();
		this.transactionId = transactionId;
		this.instrument = instrument;
		this.transactionType = transactionType;
		this.transactionQuantity = transactionQuantity;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getTransactionQuantity() {
		return transactionQuantity;
	}
	public void setTransactionQuantity(long transactionQuantity) {
		this.transactionQuantity = transactionQuantity;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", instrument=" + instrument + ", transactionType="
				+ transactionType + ", transactionQuantity=" + transactionQuantity + "]";
	}
	
	
	
}
