package com.lynx.portfolio_service.portfolio.controller;

import com.lynx.portfolio_service.portfolio.dto.request.*;
import com.lynx.portfolio_service.portfolio.dto.response.*;
import com.lynx.portfolio_service.portfolio.service.PortfolioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    // ─── User-facing endpoints (called via API Gateway) ───────────────────────

    @GetMapping
    public ResponseEntity<List<HoldingResponse>> getHoldings(
            @RequestHeader("X-User-Id") UUID userId) {
        return ResponseEntity.ok(portfolioService.getHoldings(userId));
    }

    @GetMapping("/{instrumentId}")
    public ResponseEntity<PositionResponse> getPosition(
            @RequestHeader("X-User-Id") UUID userId,
            @PathVariable String instrumentId) {
        return ResponseEntity.ok(portfolioService.getPosition(userId, instrumentId));
    }

    // ─── Internal endpoints (called by Order Service) ─────────────────────────

    @PostMapping("/add")
    public ResponseEntity<Void> addPosition(
            @Valid @RequestBody AddPositionRequest request) {
        portfolioService.addPosition(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reserve")
    public ResponseEntity<Void> reserveQuantity(
            @Valid @RequestBody ReserveQuantityRequest request) {
        portfolioService.reserveQuantity(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/release")
    public ResponseEntity<Void> releaseQuantity(
            @Valid @RequestBody ReleaseQuantityRequest request) {
        portfolioService.releaseQuantity(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/capture")
    public ResponseEntity<Void> captureQuantity(
            @Valid @RequestBody CaptureQuantityRequest request) {
        portfolioService.captureQuantity(request);
        return ResponseEntity.ok().build();
    }
}