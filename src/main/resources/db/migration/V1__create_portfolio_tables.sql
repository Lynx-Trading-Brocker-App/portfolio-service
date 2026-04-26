CREATE TABLE positions
(
    id              UUID           NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    user_id         UUID           NOT NULL,
    instrument_id   VARCHAR(50)    NOT NULL,
    instrument_type VARCHAR(20)    NOT NULL,
    quantity        NUMERIC(19, 4) NOT NULL DEFAULT 0,
    reserved_quantity NUMERIC(19, 4) NOT NULL DEFAULT 0,
    average_cost    NUMERIC(19, 4) NOT NULL DEFAULT 0,
    created_at      TIMESTAMP      NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMP      NOT NULL DEFAULT NOW(),
    is_active       BOOLEAN        NOT NULL DEFAULT TRUE,

    CONSTRAINT uq_position_user_instrument UNIQUE (user_id, instrument_id),
    CONSTRAINT chk_instrument_type CHECK (instrument_type IN ('STOCK', 'OPTION'))
);

CREATE INDEX idx_position_user_id ON positions (user_id);