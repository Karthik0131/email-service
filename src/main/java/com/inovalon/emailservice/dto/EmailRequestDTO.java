package com.inovalon.emailservice.dto;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class EmailRequestDTO {
    private String templateId;
    private List<String> toAddresses;
    private String subject;
    private String name;
    private Map<String, Object> extractConfig;
}
