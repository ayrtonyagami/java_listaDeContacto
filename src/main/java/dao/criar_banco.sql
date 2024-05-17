
CREATE TABLE IF NOT EXISTS Contacto(
    id integer primary key autoincrement,
    nome varchar(50) not null,
    telefone varchar(14) not null,
    whatsapp varchar(15) null,
    email varchar(50) null
    idTipoContacto integer not null,
    idMunicipio    integer not null,
    idBairro integer not null
);

CREATE TABLE IF NOT EXISTS Municipio(
    id integer primary key autoincrement,
    nome varchar(50) not null,
    provincia varchar(50) not null
);

CREATE TABLE IF NOT EXISTS Bairro(
    id integer primary key autoincrement,
    nome         varchar(50) not null,
    provincia    varchar(50) not null,
    idMunicipio  integer not null
);


CREATE TABLE IF NOT EXISTS TipoContacto(
    id integer primary key autoincrement,
    nome         varchar(50) not null
);

