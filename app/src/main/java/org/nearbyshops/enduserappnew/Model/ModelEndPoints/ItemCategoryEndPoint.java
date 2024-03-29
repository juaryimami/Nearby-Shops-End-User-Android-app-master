package org.nearbyshops.enduserappnew.Model.ModelEndPoints;



import org.nearbyshops.enduserappnew.Model.ItemCategory;

import java.util.ArrayList;
import java.util.List;


public class ItemCategoryEndPoint {

    private Integer itemCount;
    private Integer offset;
    private Integer limit;
    private List<ItemCategory> results;


    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<ItemCategory> getResults() {
        return results;
    }

    public void setResults(List<ItemCategory> results) {
        this.results = results;
    }

    public void setResults(ArrayList<ItemCategory> results) {
        this.results = results;
    }
}
