ALTER TABLE medicos ADD COLUMN salario INT4 NULL;

-- precisa ter um default com valor nem q seja: ' ', caso contrario ele nao cria pois estará vazio.
-- tbm caso eu apague a migration somente da pasta migration flayway do banco a coluna criada permanece
