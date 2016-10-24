package com.sample;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum DocTypes {
	DOC_OWNER_PHOTO(1, "Owner Photograph"),
	DOC_USER_SIGNATURE(2, "User Signature"),
	DOC_PAN_CARD(3, "PAN Card"), 
	DOC_PRESENT_ADDRESS_PROOF(4, "Present Address Proof of Owner"),
	DOC_PRESENT_ADDRESS_PROOF_BACKVIEW(5, "Present Address Proof (Back View)"),
	DOC_PHOTO_ID_PROOF(6, "Photo ID Proof"),	
	DOC_CHASSIS_NO(7, "Chassis No."),
	DOC_CHASSIS_NO_DISTANT_VIEW(8, "Chassis No.  Distance View"),
	DOC_ENGINE_NO(9, "Engine No."),
	DOC_INDIVIDUAL_INVOICE(10, "Invoice"),	
	DOC_INSURANCE_POLICY_COPY(11, "Insurance Policy Copy"),
	DOC_VEHICLE_RIGHT(12, "Vehicle Right side view"),
	DOC_VEHICLE_FRONT(13, "Vehicle Front View"),
	DOC_VEHICLE_REAR(14, "Vehicle Rear side View"),
	DOC_VEHICLE_LEFT(15, "Vehicle Left side View"),
	DOC_VEHICLE_RIGHT_MODIFICATION(16, "Vehicle Right side view after modification"),
    DOC_VEHICLE_FRONT_MODIFICATION(17, "Vehicle Front side View after modification"),
    DOC_VEHICLE_REAR_MODIFICATION(18, "Vehicle Rear side View after modification"),
    DOC_VEHICLE_LEFT_MODIFICATION(19, "Vehicle Left side View after modification"),
    DOC_INTERIOR_VEHICLE_IMAGE_1(20, "Interior Vehicle Images 1"),
    DOC_INTERIOR_VEHICLE_IMAGE_2(21, "Interior Vehicle Images 2"),
    DOC_INTERIOR_VEHICLE_IMAGE_3(22, "Interior Vehicle Images 3"),
    DOC_FOOT_BOARD_IMAGE_OF_VEHICLE(23, "Foot board Image of  Vehicle"),
    DOC_EMERGENCY_EXIT_IMAGE(24, "Emergency Exit Image"),
    DOC_LETTER_FROM_DISTRICT_EDUCATIONAL_OFFICER (25, "Letter from District Educational Officer"),
    DOC_REGISTRATION_CERTIFICATE_EDUCATIONAL_INSTITUTE(26, "Registration certificate Educational Institute"),
    DOC_FORM22(27, "Form 22"),
    DOC_ROC(28, "ROC"),
    DOC_RTA_APPROVAL_LETTER(29, "RTA Approval letter"),
    DOC_LETTER_OF_AUTHORIZATION(30, "Letter of Authorization"),
    DOC_PASSPORT(31, "Passport"),
    DOC_VISA_COPY(32, "Visa Copy"),
    DOC_COPY_OF_PROCEEDINGS(33, "Copy of Proceedings"),
    DOC_FORM20DO(34, "Form 20 OR DO"),
    DOC_DIFFERENTLY_ABLED_CERTIFICATE(35, "Differently Abled Certificate"),
    DOC_EXTRA_1(36, "Extra Image 1"),
    DOC_EXTRA_2(37, "Extra Image 2"),
    DOC_TAX_INDIVIDUAL_INVOICE(38, "Tax Invoice"), 
    DOC_MINOR_INDIVIDUAL(39, "Minor Individual"), 
    DOC_FORM_21(40, "Form 21"), 
    DOC_DL(41, "Driving License"), 
    MODEL_NAME(42, "Model Name"), 
    DOC_DEALER_SIGNATURE(43, "Dealer Signature"), 
    DOC_FORM20DO_COPY(44, "Form 20 OR DO (Original Copy)"), 
    DOC_HELMET_INVOICE_COPY(45, "Helmet Invoice Copy");
    
	private static final Map<Integer, String> lookup = new HashMap<Integer, String>();
	private static final Map<String, DocTypes> labelToDocTypes = new HashMap<String, DocTypes>();
	private static final Map<Integer, DocTypes> valueToDocTypes = new HashMap<Integer, DocTypes>();

	static {
		for (DocTypes docType : EnumSet.allOf(DocTypes.class)) {
			lookup.put(docType.getValue(), docType.getLabel());
		}
		for (DocTypes docType : EnumSet.allOf(DocTypes.class)) {
			labelToDocTypes.put(docType.getLabel(), docType);
		}
		for (DocTypes docType : EnumSet.allOf(DocTypes.class)) {
			valueToDocTypes.put(docType.getValue(), docType);
		}
	}
	public static String getLabel(Integer value) {
		return lookup.get(value);
	}

	public static DocTypes getDocTypes(String label) {
		return  label==null || label.equals("")  ? null : labelToDocTypes.get(label.toUpperCase());
	}

	public static DocTypes getDocTypes(Integer value) {
		return valueToDocTypes.get(value);
	}
	 private int value;
	 private String label;
	 private DocTypes(int id, String label) {
		this.value = id;
		this.label = label;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int id) {
		this.value = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
}
