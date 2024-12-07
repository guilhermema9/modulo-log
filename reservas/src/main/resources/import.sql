-- Inserindo registros em Responsavel
INSERT INTO Responsavel (id, nome, cpf)
VALUES (1, 'João da Silva', '123.456.789-00');
INSERT INTO Responsavel (id, nome, cpf)
VALUES (2, 'Maria Oliveira', '987.654.321-00');

-- Inserindo registros em EspacoFisico
INSERT INTO EspacoFisico (id, nome, descricao, tipo, capacidade, recursos, dataCadastro, dataProcedimento, situacao,
                          localizacao, notasAdicionais)
VALUES (1, 'Auditório Central', 'Auditório para eventos de grande porte', 'AUDITORIO', 200, 'Projetor, Wi-Fi, Som',
        '2024-12-01T10:00:00', '2024-12-01T10:00:00', 'ATIVO', 'Prédio A', 'Sem notas adicionais'),
       (2, 'Laboratório de Informática', 'Laboratório com computadores para aulas práticas', 'LABORATORIO', 30,
        'Computadores, Projetor, Wi-Fi', '2024-12-01T10:00:00', '2024-12-01T10:00:00', 'MANUTENCAO', 'Prédio B',
        'Reservado para manutenções');

-- Inserindo registros em Reservas
INSERT INTO Reservas (id, nomeEvento, tipoEvento, responsavel_id, contatoResponsavel, dataReserva, periodo, turno,
                      espacoFisico_id, horaInicio, horaTermino, totalParticipantes, situacao)
VALUES (1, 'Aula de Matemática', 'AULA', 1, 'joao.silva@ifto.edu.br', '2024-12-15T08:00:00', 'MANHA', 'PRIMEIRO', 1,
        '2024-12-15T08:00:00', '2024-12-15T10:00:00', 30, 'CONFIRMADA'),
       (2, 'Palestra de Tecnologia', 'PALESTRA', 2, 'maria.oliveira@ifto.edu.br', '2024-12-16T14:00:00', 'TARDE',
        'SEGUNDO', 2, '2024-12-16T14:00:00', '2024-12-16T16:00:00', 100, 'CANCELADA');
