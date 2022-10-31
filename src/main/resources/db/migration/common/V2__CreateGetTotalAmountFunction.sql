CREATE FUNCTION get_total_amount()
    RETURNS NUMERIC AS
$total_amount$
DECLARE
    total_amount NUMERIC;
BEGIN
    SELECT SUM(balance)
    INTO total_amount
    FROM account;
    RETURN total_amount;
END;
$total_amount$
    LANGUAGE plpgsql;
