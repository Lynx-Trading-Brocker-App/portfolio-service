package com.lynx.portfolio_service.portfolio.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PositionResponse {

    private UUID id;
    private UUID userId;
    private String instrumentId;
    private String instrumentType;
    private BigDecimal quantity;
    private BigDecimal reservedQuantity;
    private BigDecimal averageCost;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
}