package com.lynx.portfolio_service.portfolio.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class HoldingResponse {

    private String ticker;
    private String instrumentType;
    private BigDecimal quantity;
    private BigDecimal averageCost;
}