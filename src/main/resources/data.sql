insert into batches values
(1, 'Morgantown'),
(2, 'Virginia');

insert into admins values
(1, 'admin1');

insert into cars values 
(1, 'Teal', 'Ford', 'Thunderbird', 3, 3, 1972),
(2, 'Orange', 'Lexus', 'IS', 1, 1, 2012),
(3, 'Puce', 'Saab', '9-3', 2, 2, 2000),
(4, 'Fuscia', 'Isuzu', 'Rodeo', 3, 3, 2003),
(5, 'Violet', 'GMC', 'Sierra 2500', 2, 2, 2007),
(6, 'Orange', 'Hyundai', 'Santa Fe', 1, 1, 2003),
(7, 'Yellow', 'Chrysler', 'Fifth Ave', 5, 5, 1992),
(8, 'Maroon', 'Honda', 'Ridgeline', 5, 5, 2010),
(9, 'Teal', 'Ford', 'Aerostar', 3, 3, 1990),
(10, 'Pink', 'Mercedes-Benz', '300CE', 2, 2, 1993),
(11, 'Crimson', 'MINI', 'Cooper Countryman', 2, 2, 2011),
(12, 'Khaki', 'Dodge', 'Viper', 4, 4, 1994),
(13, 'Pink', 'Pontiac', 'Bonneville', 2, 2, 1987),
(14, 'Khaki', 'Buick', 'Electra', 4, 4, 1985),
(15, 'Puce', 'Lamborghini', 'Countach', 5, 5, 1990),
(16, 'Indigo', 'Ford', 'Taurus', 1, 1, 2012),
(17, 'Indigo', 'Volkswagen', 'Golf III', 1, 1, 1994),
(18, 'Goldenrod', 'Lotus', 'Esprit', 1, 1, 2002),
(19, 'Red', 'Land Rover', 'Range Rover', 1, 1, 1989),
(20, 'Pink', 'Mercedes-Benz', 'M-Class', 5, 5, 2000),
(21, 'Teal', 'Ford', 'Thunderbird', 3, 3, 1972),
(22, 'Orange', 'Lexus', 'IS', 1, 1, 2012),
(23, 'Puce', 'Saab', '9-3', 2, 2, 2000),
(24, 'Fuscia', 'Isuzu', 'Rodeo', 3, 3, 2003),
(25, 'Violet', 'GMC', 'Sierra 2500', 2, 2, 2007),
(26, 'Orange', 'Hyundai', 'Santa Fe', 1, 1, 2003),
(27, 'Yellow', 'Chrysler', 'Fifth Ave', 5, 5, 1992),
(28, 'Maroon', 'Honda', 'Ridgeline', 5, 5, 2010),
(29, 'Teal', 'Ford', 'Aerostar', 3, 3, 1990),
(30, 'Pink', 'Mercedes-Benz', '300CE', 2, 2, 1993),
(31, 'Crimson', 'MINI', 'Cooper Countryman', 2, 2, 2011),
(32, 'Khaki', 'Dodge', 'Viper', 4, 4, 1994),
(33, 'Pink', 'Pontiac', 'Bonneville', 2, 2, 1987),
(34, 'Khaki', 'Buick', 'Electra', 4, 4, 1985),
(35, 'Puce', 'Lamborghini', 'Countach', 5, 5, 1990),
(36, 'Indigo', 'Ford', 'Taurus', 1, 1, 2012),
(37, 'Indigo', 'Volkswagen', 'Golf III', 1, 1, 1994),
(38, 'Goldenrod', 'Lotus', 'Esprit', 1, 1, 2002),
(39, 'Red', 'Land Rover', 'Range Rover', 1, 1, 1989),
(40, 'Pink', 'Mercedes-Benz', 'M-Class', 5, 5, 2000),
(41, 'Indigo', 'Volkswagen', 'Golf III', 1, 1, 1994),
(42, 'Goldenrod', 'Lotus', 'Esprit', 1, 1, 2002);

insert into users (user_id, email, first_name, h_address, h_city,h_state, h_zip, is_driver, is_active, is_accepting_rides, last_name, phone_number,user_name, 
                   w_address, w_city,w_state, w_zip, batch_number, car) values 
(1, 'gpichmann0@artisteer.com', 'Grady', '454 W 22nd St', 'New York City', 'NY', '10011', false, false, false, 'Pichmann', '212-374-3466', 'gpichmann0', '30401 Esker Point', 'Des Moines', 'IA', '50347', 1,1),
(2, 'smigheli1@indiatimes.com', 'Salvidor', '5532 Larkwood Rd', 'Columbus', 'OH', '43229', true, true, true, 'Migheli', '614-513-2776', 'smigheli1', '35747 3rd Park', 'Philadelphia', 'PA', '19131', 1,2),
(3, 'fbraunroth2@ebay.co.uk', 'Fabien', '16413 Audrey St', 'Omaha', 'NE', '68136', true, true, true, 'Braunroth', '402-694-8099', 'fbraunroth2', '747 Crownhardt Place', 'New York City', 'NY', '10270', 1,3),
(4, 'aocullen3@google.com.au', 'Aldon', '906 Stowell St', 'Elmira', 'NY', '14901', true, false, false, 'O''Cullen', '607-732-5313', 'aocullen3', '2 Killdeer Avenue', 'Norwalk', 'CT', '06859', 1,4),
(5, 'hgledhill4@hatena.ne.jp', 'Hilda', '496 High St', 'Morgantown', 'WV', '26505', true, true, true, 'Gledhill', '239-528-0279', 'hgledhill4', '45476 Oriole Drive', 'Winston Salem', 'NC', '27110', 1,5),
(6, 'sdehoogh5@cnn.com', 'Simonne', '9241 13th Ave SW', 'Seattle', 'WA', '98106', false, false, true, 'De Hoogh', '206-506-8925', 'sdehoogh5', '68 Almo Terrace', 'New York City', 'NY', '10029', 1,6),
(7, 'dosullivan6@loc.gov', 'Darren', '105 Pearl St', 'Columbus', 'OH', '45830', true, true, true, 'O Sullivan', '614-197-3998', 'dosullivan6', '8445 Novick Hill', 'Gainesville', 'GA', '30506', 1,7),
(8, 'ddorro7@issuu.com', 'Donnell', '4579 E Fedora Ave', 'Fresno', 'CA', '93726', false, true, false, 'Dorro', '559-476-1222', 'ddorro7', '7175 Ruskin Point', 'Santa Monica', 'CA', '90405', 1,8),
(9, 'bmacvean8@shop-pro.jp', 'Brynne', '27334 Evergreen Rd', 'Southfield', 'MI', '48076', true, false, false, 'MacVean', '734-143-5188', 'bmacvean8', '39545 Canary Trail', 'Durham', 'NC', '27710', 1,9),
(10, 'tcurd9@illinois.edu', 'Tobe', '422 E 29th St', 'Brooklyn', 'NY', '11226', true, true, true, 'Curd', '646-919-8954', 'tcurd9', '127 Dunning Plaza', 'Saint Louis', 'MO', '63131', 1,10),
(11, 'medmundsa@tiny.cc', 'Marilyn', '357 patteson Drive', 'Morgantown', 'WV', '26505', true, true, true, 'Edmunds', '213-600-8430', 'medmundsa', '6 Bay Road', 'Columbia', 'MO', '65218', 1,11),
(12, 'wmatissoffb@facebook.com', 'Wynne', '7610 NW 6th St', 'Oklahoma City', 'OK', '73127', false, false, true, 'Matissoff', '405-888-7795', 'wmatissoffb', '1 Lakeland Way', 'Shawnee Mission', 'KS', '66215', 1,12),
(13, 'jlawfulc@simplemachines.org', 'Jozef', '3711 E 32nd Ave', 'Spokane', 'WA', '99223', false, true, true, 'Lawful', '509-805-2290', 'jlawfulc', '492 Quincy Road', 'Houston', 'TX', '77035', 1,13),
(14, 'flancashired@slideshare.net', 'Faythe', '3155 Preston Hall Dr', 'San Antonio', 'TX', '78247', true, true, true, 'Lancashire', '216-591-6593', 'flancashired', '1008 Pleasure Terrace', 'San Diego', 'CA', '92176', 1,14),
(15, 'llynnitte@creativecommons.org', 'Lorita', '8726 Avebury Dr', 'Charlotte', 'NC', '28213', true, false, true, 'Lynnitt', '704-705-3599', 'llynnitte', '05579 Clarendon Avenue', 'Los Angeles', 'CA', '90015', 1,15),
(16, 'modooghainef@reference.com', 'Marcellina', '12494 W Lewis And Clark Dr', 'Boise', 'ID', '83713', true, true, false, 'O''Dooghaine', '208-387-2634', 'modooghainef', '27040 Carioca Crossing', 'Detroit', 'MI', '48242', 1,16),
(17, 'jsellwoodg@wisc.edu', 'Jaine', '201 Philadelphia Pike', 'Wilmington', 'DE', '19809', false, true, false, 'Sellwood', '302-836-7801', 'jsellwoodg', '39 Merry Hill', 'Gadsden', 'AL', '35905', 1,17),
(18, 'wviani@homestead.com', 'Wain', '1 Wachovia Ctr', 'Charlotte', 'NC', '28288', false, false, true, 'Vian', '704-338-2790', 'wviani', '99 Delaware Hill', 'Athens', 'GA', '30605', 1,18),
(19, 'gtootellj@latimes.com', 'Geneva', '1304 S Claudina St', 'Anaheim', 'CA', '92806', false, false, false, 'Tootell', '714-167-0152', 'gtootellj', '61696 Algoma Park', 'Terre Haute', 'IN', '47812', 1,19),
(20, 'cgeertzk@senate.gov', 'Cissy', '31102 Oak Forest Hollow Ln', 'Spring', 'TX', '77386', false, false, true, 'Geertz', '281-310-3238', 'cgeertzk', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,20);

insert into users (user_id, email, first_name, h_address, h_city,h_state, h_zip, is_driver, is_active, is_accepting_rides, last_name, phone_number,user_name, 
                   w_address, w_city,w_state, w_zip, batch_number, car) values
(21, 'ianbrown@senate.gov', 'Ian', '888 Fairchance Rd', 'Morgantown', 'WV', '26508', false, false, true, 'Brown',
         '281-333-3238', 'ianbr', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,21),
(22, 'SallyBanks@senate.gov', 'Sally', 'Blue', 'Morgantown', 'WV', '26505', false, false, true, 'Banks',
    '281-444-3238', 'SallyB', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,22),
(23, 'BillyRocks@senate.gov', 'Billy', '72 Beulah Rd', 'Morgantown', 'WV', '26508', false, false, true, 'Rocks',
    '281-555-3238', 'BillyR', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,23),
(24, 'TomHanks@senate.gov', 'Tom', '74 Kingwood St', 'Morgantown', 'WV', '26501', false, false, true, 'Hanks',
    '281-666-3238', 'TomHnk', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,24),
(25, 'VarusMorn@senate.gov', 'Tom', '74 Pierce St #APT G', 'Morgantown', 'WV', '26501', false, false, true, 'Morn',
    '281-777-3238', 'Varrus', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,25),

(26, 'JuliusAugustus@enate.gov', 'Julius', '1704 Park Vista Dr', 'Arlington', 'TX', '76012', false, false, true, 'Augustus',
    '281-888-3238', 'Empor23', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,26),
(27, 'JulieAubigny@senate.gov', 'Julie', '2406 Windsprint Way', 'Arlington', 'TX', '76014', false, false, true, 'Aubigny',
    '281-999-3238', 'Fence', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,27),
(28, 'BobaFett@empire.edu', 'Boba', '2112 Hoover Dr', 'Arlington', 'TX', '76011', false, false, true, 'Fett',
    '282-000-3238', 'Shooty', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,28),
(29, 'RobertWalpole@parliament.gov', 'Robert', '2532 Sherry St', 'Arlington', 'TX', '76014', false, false, true, 'Walpole',
    '282-111-3238', 'Scheme', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,29),
(30, 'SyrioForell@swords.com', 'Syrio', '801 Woodard Way #APT 324', 'Arlington', 'TX', '76011 ', false, false, true, 'Forell',
    '283-222-3238', 'nottoday', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,30),

(31, 'SansaStark@north.com', 'Sansa', '11305 Hollyglen Dr', 'Tampa', 'FL', '33624', false, false, true, 'Stark',
    '283-333-3238', 'Winter', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,31),
(32, 'RobertBaratheon@castle.com', 'Robert', '12011 Citrus Falls Cir', 'Tampa', 'FL', '33625', false, false, true, 'Baratheon',
    '283-444-3238', 'Hammertime', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,32),
(33, 'JonSnow@north.com', 'Jon', '12205 N 58th St', 'Tampa', 'FL', '33617', false, false, true, 'Snow',
    '283-555-3238', 'Wolf', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,33),
(34, 'TyrionLannister@castle.com', 'Tyrion', '12231 N 16th St #208E', 'Tampa', 'FL', '33612', false, false, true, 'Lannister',
    '283-666-3238', 'Plots', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,34),
(35, 'HanSolo@falcon.com', 'Han', '12418 Queensland Ln', 'Tampa', 'FL', '33625', false, false, true, 'Solo',
    '283-777-3238', 'StolenGoods', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,35),

(36, 'GraceOmalley@yarr.com', 'Grace', '39 W 37th St #15TH', 'New York', 'NY', '10018', false, false, true, 'Omalley',
    '283-888-3238', 'PirateQueen', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,36),
(37, 'CalicoJack@yarr.com', 'Jack', '10 W 138th St #APT 3G', 'New York', 'NY', '10037', false, false, true, 'Rackham',
    '283-999-3238', 'Calico', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,37),
(38, 'BlackBeardy@yarr.com', 'Edward', '222 E 93rd St', 'New York', 'NY', '10128', false, false, true, 'Thatch',
    '284-000-3238', 'Shortfuse', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,38),
(39, 'AnneBonny@yarr.com', 'Anne', '966 Lexington Ave', 'New York', 'NY', '10021', false, false, true, 'Bonny',
    '285-111-3238', 'Yarrr', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,39),
(40, 'JackSparrow@yarr.com', 'Jack', '55 La Salle St #12K', 'New York', 'NY', '10027', false, false, true, 'Sparrow',
    '285-222-3238', 'Yoho', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,40),
(41, 'SethBullock@deadwood.com', 'Seth', '2216 White Cornus Ln', 'Reston', 'VA', '20191', false, false, true, 'Bullock',
    '285-333-3238', 'Sheriff', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,41),
(42, 'CalamityJane@deadwood.com', 'Calamity', '15017 75th Rd', 'Flushing', 'NY', '11367', false, false, true, 'Jane',
    '285-444-3238', 'Shootin', '3 Dexter Alley', 'Frederick', 'MD', '21705', 1,42);