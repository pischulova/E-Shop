create table admins (admin_id int auto_increment, login varchar(10), passw varchar(10), primary key (admin_id));
insert into admins (login, passw) values ('root', 'root'), ('admin', 'admin');

create table clients (client_id int auto_increment, login varchar(10), passw varchar(10), 
	client_name varchar(30), email varchar(20), phone varchar(15), primary key (client_id));
insert into clients (login, passw, client_name, email, phone) values 
	('alex', 'alex12', 'Alex Ivanov', 'alex@mail.ru', '345890784'), 
    ('lola', '1234', 'Lolita Johanson', 'lola@gmail.com', '567209590'),
    ('andrey', 'and', 'Андрей Коваленко', 'andrey@mail.com', '12345093'),
    ('sara', 'aras', 'Sara Goodman', 'sara@mail.ru', '450924575'),
    ('jack', 'jack', 'Jack White', 'jack@gmail.com', '973859258'),
    ('helena', 'lena', 'Helena Brandebovich', 'helena@gmail.com', '884521111'),
    ('den', 'den1', 'Den Brown', 'den@mail.com', '459385760');
    
create table product_categories (category_id int auto_increment, category_name_en varchar(20) NOT NULL, 
	category_name_ru varchar(20) NOT NULL, primary key (category_id));
insert into product_category (category_name_en, category_name_ru) values ('Airtickets', 'Авиабилеты'), 
	('Hotels', 'Отели'); 

create table countries (country_id int auto_increment, country_name_en varchar(20) NOT NULL, 
	country_name_ru varchar(20) NOT NULL, primary key (country_id));
insert into countries (country_name_en, country_name_ru) values ('Sweden', 'Швеция'), ('Great Britain', 'Великобритания'), 
	('Sri Lanka', 'Шри-Ланка'), ('Greece', 'Греция');

create table products (product_id int auto_increment, product_name_en varchar(30) NOT NULL, 
	product_name_ru varchar(30) NOT NULL, category_id int NOT NULL, country_id int NOT NULL, price int NOT NULL, 
    primary key (product_id), foreign key (category_id) references product_categories (category_id),
    foreign key (country_id) references countries (country_id));
insert into products (product_name_en, product_name_ru, category_id, country_id, price) values 
	('Kiev-Stockholm-Kiev', 'Киев-Стокгольм-Киев', 1, 1, 4380), ('Kiev-Malmo-Kiev', 'Киев-Мальме-Киев', 1, 1, 5050), 
    ('Kiev-London-Kiev', 'Киев-Лондон-Киев', 1, 2, 3950), ('Kiev-Liverpool-Kiev', 'Киев-Ливерпуль-Киев', 1, 2, 4500),
    ('Kiev-Glasgow-Kiev', 'Киев-Глазго-Киев', 1, 2, 5700), ('Kiev-Colombo-Kiev', 'Киев-Коломбо-Киев', 1, 3, 9830),
    ('Kiev-Athens-Kiev', 'Киев-Афины-Киев', 1, 4, 6100), ('Kiev-Heraklion-Kiev', 'Киев-Ираклион-Киев', 1, 4, 5820),
    ('Kiev-Thessaloniki-Kiev', 'Киев-Салоники-Киев', 1, 4, 5550), 
    ('Stockholm Hilton 5*', 'Стокгольм Hilton 5*', 2, 1, 4850), ('Stockholm Inn 4*', 'Стокгольм Inn 4*', 2, 1, 3200),
    ('Malmo Radisson 5*', 'Мальме Radisson 5*', 2, 1, 6290), ('Malmo Moment 3*', 'Мальме Moment 3*', 2, 1, 3670),
    ('London Blakemore 5*', 'Лондон Blakemore 5*', 2, 2, 9460), ('London Best 4*', 'Лондон Best 4*', 2, 2, 7400),
    ('London Qbic 3*', 'Лондон Qbic 3*', 2, 2, 5810), ('Liverpool Titanic 4*', 'Ливерпуль Titanic 4*', 2, 2, 7260),
    ('Liverpool Hilton 5*', 'Ливерпуль Hilton 5*', 2, 2, 7900), ('Liverpool Camp 2*', 'Ливерпуль Camp 2*', 2, 2, 3530),
    ('Glasgow Central 4*', 'Глазго Central 4*', 2, 2, 5850), ('Glasgow Dock 3*', 'Глазго Dock 3*', 2, 2, 4970),
    ('Colombo Residence 5*', 'Коломбо Residence 5*', 2, 3, 7700), ('Colombo Galle 4*', 'Коломбо Galle 4*', 2, 3, 6900), 
    ('Colombo Ceylon 3*', 'Коломбо Ceylon 3*', 2, 3, 4790), ('Athens New Hotel 4*', 'Афины New Hotel 4*', 2, 4, 8650),
    ('Athens Electra 5*', 'Афины Electra 5*', 2, 4, 9300), ('Athens Hermes 3*', 'Афины Hermes 3*', 2, 4, 4430),
    ('Heraklion Dream 4*', 'Ираклион Dream 4*', 2, 4, 4180), ('Heraklion Aquila 5*', 'Ираклион Aquila 5*', 2, 4, 5500),
    ('Thessaloniki Kronos 3*', 'Салоники Kronos 3*', 2, 4, 3200), ('Thessaloniki Adrian 4*', 'Салоники Adrian 4*', 2, 4, 5320),
    ('Thessaloniki Megaron 5*', 'Салоники Megaron 5*', 2, 4, 6670);
    
create table orders (order_id int auto_increment, order_date date, client_id int, amount int, product_id int, 
	primary key (order_id), foreign key (client_id) references clients (client_id),
    foreign key (product_id) references products(product_id));
    
    