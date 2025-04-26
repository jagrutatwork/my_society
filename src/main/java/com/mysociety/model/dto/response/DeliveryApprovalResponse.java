package com.mysociety.model.dto.response;

public class DeliveryApprovalResponse {

    private Long requestId;
    private boolean approved;
    private Long respondedById; // 🆕 Add this field

    public DeliveryApprovalResponse() {}

    public DeliveryApprovalResponse(Long requestId, boolean approved, Long respondedById) {
        this.requestId = requestId;
        this.approved = approved;
        this.respondedById = respondedById;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getRespondedById() {
        return respondedById;
    }

    public void setRespondedById(Long respondedById) {
        this.respondedById = respondedById;
    }

    @Override
    public String toString() {
        return "DeliveryApprovalResponse [requestId=" + requestId + ", approved=" + approved
                + ", respondedById=" + respondedById + "]";
    }
}
