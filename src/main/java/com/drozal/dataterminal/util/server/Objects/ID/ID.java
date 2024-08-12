package com.drozal.dataterminal.util.server.Objects.ID;

import com.drozal.dataterminal.util.Misc.LogUtils;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.io.File;
import java.util.Optional;

import static com.drozal.dataterminal.util.Misc.LogUtils.log;
import static com.drozal.dataterminal.util.Misc.LogUtils.logError;
import static com.drozal.dataterminal.util.Misc.stringUtil.currentIDFileURL;

@XmlAccessorType(XmlAccessType.FIELD)
public class ID {
	
	@XmlElement(name = "Name")
	private String name;
	
	@XmlElement(name = "Birthday")
	private String birthday;
	
	@XmlElement(name = "Gender")
	private String gender;
	
	@XmlElement(name = "Address")
	private String address;
	
	@XmlElement(name = "Index")
	private int index;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstName() {
		if (name != null && !name.isEmpty()) {
			String[] parts = name.split(" ");
			return parts[0];
		}
		return "";
	}
	
	public String getLastName() {
		if (name != null && !name.isEmpty()) {
			String[] parts = name.split(" ");
			if (parts.length > 1) {
				return parts[parts.length - 1];
			}
		}
		return "";
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static IDs loadIDs() throws JAXBException {
		File file = new File(currentIDFileURL);
		if (!file.exists()) {
			return new IDs();
		}
		
		try {
			JAXBContext context = JAXBContext.newInstance(IDs.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (IDs) unmarshaller.unmarshal(file);
		} catch (JAXBException e) {
			logError("Error loading IDs: ", e);
			throw e;
		}
	}
	
	private static void saveIDs(IDs IDs) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(IDs.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		File file = new File(currentIDFileURL);
		marshaller.marshal(IDs, file);
	}
	
	public static void addID(ID ID) throws JAXBException {
		IDs IDs = loadIDs();
		
		if (IDs.getIdList() == null) {
			IDs.setIdList(new java.util.ArrayList<>());
		}
		
		Optional<ID> existingReport = IDs.getIdList().stream().filter(
				e -> e.getName().equals(ID.getName())).findFirst();
		
		if (existingReport.isPresent()) {
			IDs.getIdList().remove(existingReport.get());
			IDs.getIdList().add(ID);
			log("ID with number " + ID.getName() + " updated.", LogUtils.Severity.INFO);
		} else {
			IDs.getIdList().add(ID);
			log("ID with number " + ID.getName() + " added.", LogUtils.Severity.INFO);
		}
		
		saveIDs(IDs);
	}
	
	public static void deleteID(String fullName) throws JAXBException {
		IDs IDs = loadIDs();
		
		if (IDs.getIdList() != null) {
			IDs.getIdList().removeIf(e -> e.getName().equals(fullName));
			saveIDs(IDs);
			log("ID with number " + fullName + " deleted.", LogUtils.Severity.INFO);
		}
	}
}
