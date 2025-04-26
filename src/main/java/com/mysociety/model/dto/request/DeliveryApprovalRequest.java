package com.mysociety.model.dto.request;

public class DeliveryApprovalRequest {
    private Long flatId;         // Which flat is the delivery for?
    private Long addedByUserId;  // Who is the guard adding this request?
    private String note;         // Optional: "Food", "Grocery", "Amazon", etc.
    
	@Override
	public String toString() {
		return "DeliveryApprovalRequest [flatId=" + flatId + ", addedByUserId=" + addedByUserId + ", note=" + note
				+ "]";
	}
	public DeliveryApprovalRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryApprovalRequest(Long flatId, Long addedByUserId, String note) {
		super();
		this.flatId = flatId;
		this.addedByUserId = addedByUserId;
		this.note = note;
	}
	public Long getFlatId() {
		return flatId;
	}
	public void setFlatId(Long flatId) {
		this.flatId = flatId;
	}
	public Long getAddedByUserId() {
		return addedByUserId;
	}
	public void setAddedByUserId(Long addedByUserId) {
		this.addedByUserId = addedByUserId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	

	
    
    
}
