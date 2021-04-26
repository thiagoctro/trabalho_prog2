-- cria tabela de funcionarios
CREATE TABLE funcionarios(
	matrichttp://127.0.0.1:62215/datagrid/panel/3826214?is_query_tool=true&sgid=1&sid=1&server_type=pg&did=16394#ula INTEGER NOT NULL,
	nome VARCHAR,http://127.0.0.1:62215/datagrid/panel/3826214?is_query_tool=true&sgid=1&sid=1&server_type=pg&did=16394#
	endereco VARCHAR,
	senha VARCHAR
);

-- cria sequencia de auto incremento
CREATE SEQUENCE matricula_seq
	INCREMENT 1
	MINVALUE 101
	MAXVALUE 9223372036854775807
	START 101
	CACHE 1;

-- insere sequencia de auto incremento na coluna MATRICULA
ALTER TABLE funcionarios ALTER matricula SET DEFAULT NEXTVAL( 'matricula_seq' );

-- insere os dados na tabela de funcionarios
INSERT INTO funcionarios(
	nome,
	endereco,
	senha
)
VALUES (
	'Gabriela Medeiros',
	'Rua Pedro Atum, 117 ',
	'atum02'
);