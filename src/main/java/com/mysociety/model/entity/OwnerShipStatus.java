package com.mysociety.model.entity;

public enum OwnerShipStatus {
	
    PRIMARY_RESIDENT, // Owner living in flat (default full control)
    LIMITED_OWNER,    // Owner after renting flat (only society news/comments access)
    DEACTIVATED,// Old owner or old tenant — no access
    NON_RESIDENT // Security and Admin
}

