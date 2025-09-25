package iofile;

import java.time.LocalDateTime;

public class ObjectClass implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double value;
	private transient String tempData="Temp data"; // This field will not be serialized
	private static String staticData = "Static Data"; // This field will not be serialized
	private final String finalData = "Final Data"; // This field will be serialized
	private LocalDateTime localDateTime; // This field will be serialized
	
	public ObjectClass(int id, String name, double value, String tempData) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.tempData = tempData;
		this.localDateTime = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "ObjectClass [id=" + id + ", name=" + name + ", value=" + value + ", tempData=" + tempData
				+ ", staticData=" + staticData + ", finalData=" + finalData + ", localDateTime=" + localDateTime + "]";
	}

}
