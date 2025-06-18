CREATE PROCEDURE get_total_amount(OUT total_amount NUMERIC)
AS $$
BEGIN
    SELECT SUM(balance) INTO total_amount FROM account;
END;
$$ LANGUAGE plpgsql;
