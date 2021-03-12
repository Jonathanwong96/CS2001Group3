import java.io.Serializable;
import java.sql.Date;

@Configuration

@Entity
	public class MedicationCount implements Serializable  {

		private static final long serialVersionUID = 1L;

		@id
		@GeneratedValue
		private int id; 
		
		@Column(nullable=false)
	    private int staffID; 

		@Column(nullable=false)
	    private int medicationID; //Medication Name

	    @Column(nullable=false)
	    private int residentID; 

	    @Column(nullable=false)
	    private byte isMorningCount; 
	    @Column(nullable=false)
	    private Date dateFor; //includes day + evening total

	    @Column(nullable = false)
	    private Date cycleProjectToEndDate; //(initial count/ dosage) project days on calendar to get expiry date

	    @Column(nullable=false)
	    private int count; //includes day + evening total


	    public MedicationCount () {

	    }

	    public MedicationCount(Integer staffID, Integer medicationID, Integer residentID,Integer initialMedicationCount, Integer cycleprojectEndDate, Integer count, Date cycleProjectToEndDate, Date dateFor) {
	    	this.staffID = staffID;
	    	this.medicationID = medicationID;
	    	this.residentID = residentID; //evening + day count
	    	this.dateFor = dateFor;
	    	this.cycleProjectToEndDate = cycleProjectToEndDate;  //initialMedicationCount/medicationDosage
	    	this.count = count;
	    }


	    //Staff responsible for the updates and changes
	    public long getStaffId() {
	    	return staffID;
	    }
	    public void setStaffId(int staffId) {
	    	this.staffID = staffId;
	    }


	    public int getMedicationId() {
	    	return medicationID;
	    }
	    public void setresidentName(String residentName, int medicationID) {
	    	this.medicationID = medicationID;
	    }

	 
	    public int getResidentID() {
	    	return residentID;
	    }
	    public void isMorningCount(byte isMorningCount) {
	    	this. isMorningCount = isMorningCount;
	    }

	 
	    public Date dateFor() {
	    	return dateFor;
	    }
	    public void dateFor(Date dateFor) {
	    	this.dateFor = dateFor;
	    }

	 
	    public Date cycleProjectToEndDate() {
	    	return cycleProjectToEndDate;
	    }
	    public void getprojectEndDate(Date cycleProjectToEndDate) {
	    	this.cycleProjectToEndDate = cycleProjectToEndDate;
	    }
	  
	    public int count() {
	    	return count;
	    }

	}


