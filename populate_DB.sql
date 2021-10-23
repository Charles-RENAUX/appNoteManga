USE `projet_JEE`;

INSERT INTO manga (name, resume, image) VALUES ('Naruto',
                                              'L''histoire commence pendant l''adolescence de Naruto, vers ses douze ans. Orphelin cancre et grand farceur, il fait toutes les bêtises possibles pour se faire remarquer. Son rêve : devenir le meilleur Hokage afin d''être reconnu par les habitants de son village.'
                                              ,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcer3vDh98fOuNaRC3rDTorG9r8DXjDcpvmg&usqp=CAU');
INSERT INTO manga (name, resume, image) VALUES ('One Piece',
                                              'Monkey D. Luffy rêve de retrouver ce trésor légendaire et de devenir le nouveau "Roi des Pirates". Après avoir mangé un fruit du démon, il possède un pouvoir lui permettant de réaliser son rêve',
                                              'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAIVTfttxpAw1ZoMDXlTohv-3XdQ7tF0mpIA&usqp=CAU');
INSERT INTO manga (name, resume, image) VALUES ('JuJutsu Kaisen',
                                              'Yūji Itadori, un lycéen lambda doté d''une force surhumaine et membre du club de spiritisme, trouve un jour dans l''abri météo de son lycée une relique de rang S protégée par un sceau.',
                                              'https://www.lalibrairie.com/cache/img/livres/537/9791032705537.jpg');
INSERT INTO manga (name, resume, image) VALUES ('Tokyo Ghoul',
                                              'Dans la ville de Tokyo, des créatures nommées goules sont apparues et se nourrissent de chair humaine pour survivre. Un jour, Ken Kaneki, jeune étudiant, se fait attaquer par l''une d''entre elles et subit une grave blessure.',
                                              'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRqd1o2sEeZ9iso-brfgY6uAL2g4Iijukz1A&usqp=CAU');
INSERT INTO manga (name, resume, image) VALUES ('Gurren Lagann',
                                              'Tengen toppa Gurren-Lagann se déroule dans un futur lointain où l''humanité a été forcée de vivre sous terre, créant des civilisations souterraines isolées. Ces cités n''ont aucun contact avec la surface ni avec les autres villages souterrains.',
                                              'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREYnKYNZuYSCi8KuTDINMECFapK0HH2fqhpQ&usqp=CAU');
INSERT INTO manga (name, resume, image) VALUES ('My Hero Academia',
                                              'Dans un monde où 80 % de la population possède un super-pouvoir appelé alter, les héros font partie de la vie quotidienne. Et les super-vilains aussi ! Face à eux se dresse l''invincible All Might, le plus puissant des héros !',
                                              'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIIOghicXy2nmIG6qlumZyqWTsxcQG8ViQLg&usqp=CAU');
INSERT INTO manga (name, resume, image) VALUES ('Air Gear',
                                              'Ikki est le leader du gang qui règne sur son lycée. Malgré sa force, il va connaître sa première défaite lors d''une altercation avec les Skull Sader, un groupe de Stormriders, des riders d''un genre nouveau qui se déplacent en bande sur des Air Trecks, des rollers motorisés.',
                                              'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLFYh42Aj4pai0eg2c5KNc4Wa2nxuqjH2mLA&usqp=CAU');
INSERT INTO manga (name, resume, image) VALUES ('Mob Psycho 100',
                                              'L''histoire suit Kageyama Shigeo, un élève de quatrième possédant des pouvoirs psychiques. Il peut plier et soulever n''importe quel objet avec son esprit.',
                                              'https://upload.wikimedia.org//wikipedia/en/4/4b/Mob_Psycho_100_manga_vol_1.jpg');

INSERT INTO users (name,firstname,pseudo,password,adminn) VALUES ('Compte', 'Admin','admin','admin', TRUE);
INSERT INTO users (name,firstname,pseudo,password,adminn) VALUES ('sanchez', 'pierre','mado','mdp1', FALSE );
INSERT INTO users (name,firstname,pseudo,password,adminn) VALUES ('renaux', 'charles','charles','mdp2', FALSE);
INSERT INTO users (name,firstname,pseudo,password,adminn) VALUES ('les', 'rageux','ldr','ldr', FALSE);

INSERT INTO review (text,note,authorId,idManga) VALUES ('A la conquête du Tropaion! Le roller c''est bien, le roller qui vole c''est mieux. A consommer  sans modération',
                                                        5,2 ,7);
INSERT INTO review (text,note,authorId,idManga) VALUES ('Nulle, qui va me rendre les précieuses minutes de ma vie que j''ai perdu à lire ça!' ,
                                                        1,4 ,7);
INSERT INTO review (text,note,authorId,idManga) VALUES ('Un classique. Je recommande',
                                                        4.5,2 ,2);
INSERT INTO review (text,note,authorId,idManga) VALUES ('Le manga a déjà fait ses preuves, si vous ne connaissez pas, sortez de votre grotte!',
                                                        4,3 ,2);
INSERT INTO review (text,note,authorId,idManga) VALUES ('C''est moyen, le concept de pirate est éclaté. Certains devraient retourner à l''école',
                                                        2,4 ,2);
INSERT INTO review (text,note,authorId,idManga) VALUES ('Pour les jeunes, c''est Boruto mais en mieux' ,
                                                        5,2 ,1);
INSERT INTO review (text,note,authorId,idManga) VALUES ('J''ai pas spécialement accroché au concept de ninja, mais ça reste sympa à lire',
                                                        3,3 ,1);
INSERT INTO review (text,note,authorId,idManga) VALUES ('Pas spécialement fan, mais je comprend que ça plaise. C''est un classique shonen',
                                                        3,2 ,3);
INSERT INTO review (text,note,authorId,idManga) VALUES ('Je suis neutre. Les voies du seigneur sont impénétrables',
                                                        2.5,1 ,3);
INSERT INTO review (text,note,authorId,idManga) VALUES ('Pas fou. Vu la couverture médiatique je m''attendais à mieux',
                                                        2,4 ,3);
