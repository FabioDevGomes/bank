INSERT INTO Customer (id, name, exclusive_plan, balance, account_number, birth_date) VALUES
  (1111, 'Ancle Bob', true, 1000.0, '1234567890', '2002-05-05'),
  (1112, 'Robert C. Martin', false, 1000.0, '1234567891', '2002-05-06'),
  (1113, 'Fábio Gomes', true, 100.0, '1234567892', '2002-05-06'),
  (1114, 'Kakashi', false, 1000.0, '1234567893', '2002-05-06');
  
  
  INSERT INTO Transaction (id, operation_date, operation_value, operation_type, current_balance, customer_id) VALUES
  (1111, '2023-05-05', 100.0, 0, 900.0, 1112),
  (1112, '2023-05-05', 100.0, 0, 800.0, 1112),
  (1113, '2023-05-05', 100.0, 1, 900.0, 1112),
  (1114, '2023-05-05', 80.0, 1, 980.0, 1112);