package com.chef.assist.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenhong
 * @since 2021-03-01
 */
@Data
@Accessors(chain = true)
public class Th  {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String temperature;

    private String humidity;



}
