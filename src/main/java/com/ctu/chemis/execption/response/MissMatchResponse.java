package com.ctu.chemis.execption.response;

import lombok.Data;

@Data
public class MissMatchResponse {
    private int status;
    private String message;
    private long timestamp;
}
