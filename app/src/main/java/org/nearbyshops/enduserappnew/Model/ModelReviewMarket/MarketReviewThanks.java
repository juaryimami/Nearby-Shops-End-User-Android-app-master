package org.nearbyshops.enduserappnew.Model.ModelReviewMarket;



public class MarketReviewThanks {

    // Table Name
    public static final String TABLE_NAME = "ITEM_REVIEW_THANKS";

    // column Names
    public static final String END_USER_ID = "END_USER_ID"; // foreign Key
    public static final String ITEM_REVIEW_ID = "ITEM_REVIEW_ID"; // foreign Key





    // instance Variables

    private Integer endUserID;
    private Integer itemReviewID;


    public Integer getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(Integer endUserID) {
        this.endUserID = endUserID;
    }

    public Integer getItemReviewID() {
        return itemReviewID;
    }

    public void setItemReviewID(Integer itemReviewID) {
        this.itemReviewID = itemReviewID;
    }
}
