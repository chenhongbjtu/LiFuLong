package com.chef.assist.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class KitBoardItems implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long item_id;


    private Long producer_id;

 //   @JsonProperty("dish_name")
    private String dish_name;

//    @JsonProperty("dish_count")
    private Integer dish_count;


    private String description;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getProducer_id() {
        return producer_id;
    }

    public void setProducer_id(Long producer_id) {
        this.producer_id = producer_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public Integer getDish_count() {
        return dish_count;
    }

    public void setDish_count(Integer dish_count) {
        this.dish_count = dish_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
