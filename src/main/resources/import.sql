insert into tb_games (name) values('bagatelle');
insert into tb_games (name) values('balkline billiards');
insert into tb_games (name) values('baseball');
insert into tb_games (name) values('carom billiards');
insert into tb_games (name) values('eight ball');
insert into tb_games (name) values('golf');
insert into tb_games (name) values('pocket billiards');
insert into tb_games (name) values('pool');
insert into tb_games (name) values('pyramids');
insert into tb_games (name) values('straight-rail billiards');
insert into tb_games (name) values('acey-deucey');
insert into tb_games (name) values('backgammon');
insert into tb_games (name) values('checkers');
insert into tb_games (name) values('chess');
insert into tb_games (name) values('Chinese chess');
insert into tb_games (name) values('go');
insert into tb_games (name) values('goose');
insert into tb_games (name) values('Monopoly');
insert into tb_games (name) values('Nine Men’s Morris');
insert into tb_games (name) values('nyout');
insert into tb_games (name) values('Pachisi');
insert into tb_games (name) values('Polish checkers');
insert into tb_games (name) values('Scrabble');
insert into tb_games (name) values('shogi');
insert into tb_games (name) values('snooker');
insert into tb_games (name) values('Turkish checkers');

insert into TB_ROLES(authority) values ('ROLE_PLAYER');
insert into TB_ROLES(authority) values ('ROLE_TEAM');

insert into tb_users (role_id, first_name, last_name, email, password, cpf, is_open_to_work) values (1, 'Gustavo', 'Silva', 'gustavo.filho.gts@gmail.com', '$2a$12$PWugiEfMzTk71bKDL6AdXOaEEXNSrfiP6FdODa6G.NX75Khgyu7Ue', '523.132.298-62', true);
insert into tb_players (level, years_of_experience, id) values (1, 5, 1);

insert into tb_users (role_id, first_name, last_name, email, password, cpf, is_open_to_work) values (2, 'Gustavo', 'Tiago', 'gustavo.tiago.gts@gmail.com', '$2a$12$PWugiEfMzTk71bKDL6AdXOaEEXNSrfiP6FdODa6G.NX75Khgyu7Ue', '623.132.298-62', true);
insert into tb_players (level, years_of_experience, id) values (2, 5, 2);

insert into tb_users (role_id, first_name, last_name, email, password, cpf, is_open_to_work) values (1, 'Mateus', 'Zucheli', 'mateuszucheli@hotmail.com', '$2a$12$PWugiEfMzTk71bKDL6AdXOaEEXNSrfiP6FdODa6G.NX75Khgyu7Ue', '723.132.298-62', true);
insert into tb_players (level, years_of_experience, id) values (1, 5, 3);

insert into tb_player_games(user_id, game_id) values (1, 1);
insert into tb_player_games(user_id, game_id) values (1, 2);
insert into tb_player_games(user_id, game_id) values (1, 3);
insert into tb_player_games(user_id, game_id) values (1, 4);
insert into tb_player_games(user_id, game_id) values (1, 5);
insert into tb_player_games(user_id, game_id) values (1, 6);
insert into tb_player_games(user_id, game_id) values (1, 7);
insert into tb_player_games(user_id, game_id) values (1, 8);
insert into tb_player_games(user_id, game_id) values (1, 9);
insert into tb_player_games(user_id, game_id) values (2, 10);
insert into tb_player_games(user_id, game_id) values (2, 11);
insert into tb_player_games(user_id, game_id) values (2, 12);
insert into tb_player_games(user_id, game_id) values (2, 13);
insert into tb_player_games(user_id, game_id) values (2, 14);
insert into tb_player_games(user_id, game_id) values (2, 15);
insert into tb_player_games(user_id, game_id) values (2, 16);
insert into tb_player_games(user_id, game_id) values (2, 17);
insert into tb_player_games(user_id, game_id) values (2, 18);
insert into tb_player_games(user_id, game_id) values (2, 19);
insert into tb_player_games(user_id, game_id) values (2, 20);
insert into tb_player_games(user_id, game_id) values (3, 21);
insert into tb_player_games(user_id, game_id) values (3, 22);
insert into tb_player_games(user_id, game_id) values (3, 23);
insert into tb_player_games(user_id, game_id) values (3, 24);

insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (1, 'CS:GO - Rifler', 'Procuramos um jogador para a posição de Rifler com pelo menos 1 ano de experiência no jogo. Somos um time de nível amador e queremos jogar campeonatos nesse nível.', 'TEAM', '2022-09-23', '2022-10-23');
insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (2, 'CS:GO - Entry Fragger', 'Juntem-se ao nosso time! Temos quase uma década de história no CS, um dos melhores times do Brasil. Procuramos um Entry Fragger de rank Distinguished Master Guardian para cima para competir em campeonatos profissionais com a gente!', 'TEAM', '2022-05-22', '2022-06-23');
insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (1, 'CS:GO - AWPER', 'Somos um time da época das lan houses, CS 1.6. Queremos um AWPER para completar nossa equipe. Rank Gold ou maior. Pelo menos 25 anos e que possa jogar sextas e finais de semana.', 'TEAM', '2022-03-23', '2022-06-23');
insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (1, 'CS:GO - Coach', 'Time de nível amador a procura de um Coach para nos ajudar a treinar. Temos alguns jogadores com altíssimo potencial e queremos fazer parte do cenário competitivo nacional!', 'TEAM', '2022-02-23', '2022-03-23');
insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (1, 'CS:GO - Lurker', 'Procuramos um Lurker iniciante pro nosso time. Qualquer rank. Somos um grupo de amigos que se conheceu pelo Discord e decidimos começar a jogar CS juntos. Vem aprender com a gente!', 'TEAM', '2022-01-23', '2022-02-23');
insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (1, 'CS-GO - Manager', 'Somos um time novo no cenário de CS:GO. Procuramos um Manager será responsável por gerenciar e organizar nossa participação em campeonatos. Entendimento básico do jogo. Salário a combinar.', 'TEAM', '2021-09-23', '2021-10-23');
insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (1, 'CS-GO - Social Media', 'Venha fazer parte da nossa família! Um dos maiores times do mundo e campeão mundial. Procuramos alguém de Social Media para administrar redes como Twitter e Instagram. Uma pessoa que conheça e ame o jogo e esteja disposta a interagir com os fãs.', 'TEAM', '2021-09-23', '2021-10-23');
insert into tb_vacancies (user_id, name, description, vacancy_type, start_date, end_date) values (1, 'CS-GO - AWPER', 'Estamos montando um time com os melhores. Rank: Legendary Eagle ou maior. Pelo menos 3 anos de experiência com o jogo e alguma conquista em campeonatos. Necessário ser maior de idade.', 'TEAM', '2021-09-23', '2021-10-23');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('LOL - ADC', 'Queremos um ADC para fechar nosso time! Somos um grupo de amigos de rank Gold e procuramos jogar partidas casualmente aos finais de semana.', 'TEAM', '2021-09-23', '2021-10-23');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('LOL - Suporte', 'Time amador de League of Legends. Precisamos de alguém para jogar na posição suporte que tenha pelo menos elo platina. Procuramos alguém que saiba jogar com vários campeões e que seja adaptável!', 'TEAM', '2020-09-12', '2020-10-16');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('LOL - Mid Lane', 'Time profissional feminino! Queremos uma Mid Laner com pelo menos 3 anos de experiência no jogo e com elo Mestre ou maior. Apenas mulheres maiores de 16 anos!', 'TEAM', '2020-09-11', '2020-10-23');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('LOL - Top Lane', 'Somos um time amador de LOL com o sonho de nos tornarmos profissionais! Queremos um Top Laner de elo Platina que queira se juntar a nós com esse objetivo. Todos são bem-vindos!', 'TEAM', '2020-09-12', '2020-10-30');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('LOL - Jungler', 'Grupo de 3 amigos que acabou de começar a jogar o jogo. Queremos um Jungler iniciante que queira jogar conosco casualmente. Preferencialmente alguém na faixa entre 16~22 anos.', 'TEAM', '2020-09-25', '2020-10-15');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('LOL - ADC', 'Somos um time amador que veio do Dota 2! Somos de elo Ouro e queremos um AD Carry para completar nosso time. Nosso objetivo é subir a maior quantidade de elos possível, mas sem nenhuma expectativa de competir em campeonatos!', 'TEAM', '2020-09-11', '2020-10-12');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('CS:GO - Coach', 'Procuramos um Coach que já tenha jogado profissionalmente. Queremos alguém com ampla experiência para ajudar nossos jogadores a evoluirem e bolar táticas parar tirar o melhor deles!', 'TEAM', '2020-09-01', '2020-10-10');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('CS:GO - Entry Fragger', 'Somos um time iniciante e estamos em busca de um Entry Fragger também iniciante para jogar for fun. Procuramos alguém com pelo menos 20 anos e que tenha os fins de semana disponíveis para se juntar a nós.', 'TEAM', '2020-09-02', '2020-10-03');
insert into tb_vacancies (name, description, vacancy_type, start_date, end_date) values ('CS:GO - Lurker', 'Somos um time amador de Counter Strike procurando um Lurker rank Gold Nova III para cima. Temos alguns bons jogadores e estamos queremos fechar um time para começar a jogar campeonatos!', 'TEAM', '2020-09-03', '2020-10-06');

INSERT INTO tb_teams (years_of_experience, name, description, vacancy_id, author_id) VALUES (10, 'SOFT', 'Time profissional com vários anos de história. Já fomos campeões mundiais e alguns dos melhores jogadores do mundo já passaram pela nossa equipe. Atualmente marcamos presença em alguns dos jogos mais populares, com resultados significativos em todos eles. Se você quer fazer parte da nossa lenda e acha que consegue contribuir com a equipe, dê uma olhada em algumas de nossas vagas! Estamos de braços abertos e ansiosos por novos talentos.', 1, 1);
INSERT INTO tb_teams (years_of_experience, name, description, vacancy_id, author_id) VALUES (5, 'Warriors of Light', 'Começamos apenas como um grupo de três amigos, jogando apenas por diversão depois da escola. Hoje somos um time em ascensão no cenário amador! Conquistamos diversos prêmios e altas colocações em campeonatos amadores e agora queremos expandir nossos horizontes! Procuramos por pessoas com paixão pela competição e que amam jogos e principalmente jogar jogos competitivos em equipe. Interessado? Se inscreve em nossas vagas!', 2, 1);
INSERT INTO tb_teams (years_of_experience, name, description, vacancy_id, author_id) VALUES (3, 'Ascension Gaming', 'Equipe criada pelo ex-jogador profissional Ascended, um dos maiores jogadores do mundo e que fez história nos 10 anos que jogou competitivamente. Queremos jovens talentos que amem o jogo e sonham em se tornar profissionais. Venha jogar com a gente tendo um dos melhores players do mundo como seu Coach! Não existirá um forma melhor de começar no cenário profissional. Em breve marcaremos presença em alguns do maiores torneios do mundo!', 3, 1);
INSERT INTO tb_teams (years_of_experience, name, description, author_id) VALUES (2, 'Vingadores da DC', 'Somos um grupo de amigos que gosta muito de jogos e gostamos de jogar pela diversão. Temos um time casual e um Discord onde conversamos. Entramos na plataforma buscando pessoas legais para jogarem com a gente. Se você é legal, bem-humorado e se dá bem com os outros, não deixe de dar uma olhada nas nossas vagas. Jogares tóxicos e trolls não serão tolerados!!! Queremos criar um ambiente divertido para todos com foco no jogo casual.', 1);
INSERT INTO tb_teams (years_of_experience, name, description, author_id) VALUES (7, 'Gamer Union', 'A Gamer Union é uma equipe profissional que já está a vários anos no cenário. Já participamos de diversos torneio nacionais e internacionais e fomos a casa de muitos bons jogadores. Atualmente estamos montando times de diversos níveis de jogo, então dê uma olhada em nossos vagas se está atrás de um oportunidade em um grupo renomado, feito de gamers para gamers.', 1);
INSERT INTO tb_teams (years_of_experience, name, description, author_id) VALUES (3, 'Llamers', 'Time de tiozões dos tempos da lan house e fliperamas. Queremos reviver aquela época e fazer encontros presenciais a cada 15 dias para jogarmos juntos! É tiozão também e quer lembrar daqueles tempos? Então você achou a equipe perfeita para você. Jogamos casualmente e queremos apenas companheiros da nossa idade com hobbies similares para contar histórias sobre os velhos tempos e jogar sem compromissos. Aceitamos apenas pessoas com +28 anos.', 1);

insert into TB_TEAMS_GAMES (team_id, game_id) values (1,1);
insert into TB_TEAMS_GAMES (team_id, game_id) values (1,2);
insert into TB_TEAMS_GAMES (team_id, game_id) values (1,3);
insert into TB_TEAMS_GAMES (team_id, game_id) values (2,4);
insert into TB_TEAMS_GAMES (team_id, game_id) values (2,5);
insert into TB_TEAMS_GAMES (team_id, game_id) values (3,6);
insert into TB_TEAMS_GAMES (team_id, game_id) values (3,7);
insert into TB_TEAMS_GAMES (team_id, game_id) values (4,8);
insert into TB_TEAMS_GAMES (team_id, game_id) values (4,9);
insert into TB_TEAMS_GAMES (team_id, game_id) values (4,10);
insert into TB_TEAMS_GAMES (team_id, game_id) values (4,11);
insert into TB_TEAMS_GAMES (team_id, game_id) values (1,12);
insert into TB_TEAMS_GAMES (team_id, game_id) values (1,13);
insert into TB_TEAMS_GAMES (team_id, game_id) values (1,14);
insert into TB_TEAMS_GAMES (team_id, game_id) values (5,15);
insert into TB_TEAMS_GAMES (team_id, game_id) values (5,16);
insert into TB_TEAMS_GAMES (team_id, game_id) values (5,17);
insert into TB_TEAMS_GAMES (team_id, game_id) values (5,18);
insert into TB_TEAMS_GAMES (team_id, game_id) values (5,1);