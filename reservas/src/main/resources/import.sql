-- Mock data for EspacoFisico
INSERT INTO espaco_fisico (id, nome, descricao, tipo, capacidade, recursos, data_cadastro, data_procedimento, situacao,
                           localizacao, notas_adicionais)
VALUES (1, 'Sala 101', 'Sala de aula com 30 lugares', 'SALA_DE_AULA', 30, '["Projetor", "Ar Condicionado"]',
        '2023-01-01T10:00:00', '2023-01-01T10:00:00', 'ATIVO', 'Bloco A', 'Nenhuma'),
       (2, 'Auditório Principal', 'Auditório com capacidade para 200 pessoas', 'AUDITORIO', 200,
        '["Sistema de Som", "Microfone"]', '2023-01-01T10:00:00', '2023-01-01T10:00:00', 'ATIVO', 'Bloco B', 'Nenhuma'),
       (3, 'Laboratório de Informática', 'Laboratório com 20 computadores', 'LABORATORIO', 20,
        '["Computadores", "Projetor"]', '2023-01-01T10:00:00', '2023-01-01T10:00:00', 'MANUTENCAO', 'Bloco C',
        'Nenhuma');

-- Mock data for Reservas
INSERT INTO reservas (id, nome_evento, tipo_evento, responsavel, contato_responsavel, data_reserva, periodo, turno,
                      espaco_fisico_id, hora_inicio, hora_termino, total_participantes, situacao)
VALUES (1, 'Aula de Matemática', 'AULA', 'Prof. João', 'joao@example.com', '2023-01-10T08:00:00', 'MANHA', 'PRIMEIRO',
        1, '2023-01-10T08:00:00', '2023-01-10T10:00:00', 30, 'CONFIRMADA'),
       (2, 'Palestra de Tecnologia', 'PALESTRA', 'Prof. Maria', 'maria@example.com', '2023-01-15T14:00:00', 'TARDE',
        'SEGUNDO', 2, '2023-01-15T14:00:00', '2023-01-15T16:00:00', 150, 'CONFIRMADA'),
       (3, 'Aula de Programação', 'AULA', 'Prof. Carlos', 'carlos@example.com', '2023-01-20T10:00:00', 'MANHA',
        'SEGUNDO', 3, '2023-01-20T10:00:00', '2023-01-20T12:00:00', 20, 'CANCELADA');