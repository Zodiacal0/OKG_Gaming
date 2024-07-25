DROP DATABASE IF EXISTS DB_OKGShop;
CREATE DATABASE DB_OKGShop;
USE DB_OKGShop;

-- Tablas combinadas

CREATE TABLE Usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nickname VARCHAR(45),
    email VARCHAR(45) UNIQUE NOT NULL,
    contraseña VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(32),
    tipoDeUsuario ENUM('Cliente', 'Administrador')
);

CREATE TABLE MetodoDePago (
    idMetodoDePago INT PRIMARY KEY AUTO_INCREMENT,
    tarjeta BOOLEAN,
    paypal BOOLEAN,
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE
);

CREATE TABLE Tarjeta (
    idTarjeta INT PRIMARY KEY AUTO_INCREMENT,
    numeroDeLaTarjeta CHAR(16),
    nombreDelTitular VARCHAR(255),
    fechaDeCaducidad CHAR(5),
    codigoCVV CHAR(3),
    idMetodoDePago INT,
    FOREIGN KEY (idMetodoDePago) REFERENCES MetodoDePago(idMetodoDePago) ON DELETE CASCADE
);

CREATE TABLE Paypal (
    idPaypal INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    idMetodoDePago INT,
    FOREIGN KEY (idMetodoDePago) REFERENCES MetodoDePago(idMetodoDePago) ON DELETE CASCADE
);

CREATE TABLE TransaccionTarjeta (
    idTransaccionTarjeta INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(10, 2),
    fecha TIMESTAMP,
    idTarjeta INT,
    FOREIGN KEY (idTarjeta) REFERENCES Tarjeta(idTarjeta) ON DELETE CASCADE
);

CREATE TABLE TransaccionPaypal (
    idTransaccionPaypal INT PRIMARY KEY AUTO_INCREMENT,
    monto DECIMAL(10, 2),
    fecha TIMESTAMP,
    idPaypal INT,
    FOREIGN KEY (idPaypal) REFERENCES Paypal(idPaypal) ON DELETE CASCADE
);

CREATE TABLE Desarrolladora (
    idDesarrolladora INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    nacionalidad VARCHAR(255),
    telefono VARCHAR(32),
    email VARCHAR(255)
);

CREATE TABLE Juegos (
    idJuego INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    categoria VARCHAR(255),
    clasificacionPEGI INT,
    clasificacionESRB VARCHAR(5),
    precio DECIMAL(10, 2),
    stock INT,
    descripcion VARCHAR(255),
    idDesarrolladora INT,
    FOREIGN KEY (idDesarrolladora) REFERENCES Desarrolladora(idDesarrolladora) ON DELETE CASCADE
);

CREATE TABLE descuento (
    idCodigoDescuento INT PRIMARY KEY AUTO_INCREMENT,
    valorDescuento DECIMAL(10,2),
    descripcion VARCHAR(50),
    aplicacion ENUM('Monto minimo', 'Monto FiJo'),
    fechaDeCaducidad DATE
);

CREATE TABLE Carrito (
    idCarrito INT PRIMARY KEY AUTO_INCREMENT,
    subtotal DECIMAL(10, 2),
    total DECIMAL(10, 2),
    descuento DECIMAL(10, 2),
    idJuego INT,
    idUsuario INT,
    idCodigoDescuento INT,
    FOREIGN KEY (idJuego) REFERENCES Juegos(idJuego) ON DELETE CASCADE,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE,
    FOREIGN KEY (idCodigoDescuento) REFERENCES descuento(idCodigoDescuento) ON DELETE CASCADE
);

CREATE TABLE FacturaTarjeta (
    idFacturaTarjeta INT PRIMARY KEY AUTO_INCREMENT,
    id_transaccion CHAR(36) NOT NULL,
    fecha TIMESTAMP,
    monto DECIMAL(10, 2),
    detalle VARCHAR(255),
    idTransaccionTarjeta INT,
    redDeLaTarjeta ENUM('Visa', 'MasterCard'),
    idCarrito INT,
    FOREIGN KEY (idTransaccionTarjeta) REFERENCES TransaccionTarjeta(idTransaccionTarjeta) ON DELETE CASCADE,
    FOREIGN KEY (idCarrito) REFERENCES Carrito(idCarrito) ON DELETE CASCADE
);

CREATE TABLE FacturaPaypal (
    idFacturaPaypal INT PRIMARY KEY AUTO_INCREMENT,
    id_transaccion CHAR(36) NOT NULL,
    fecha TIMESTAMP,
    monto DECIMAL(10, 2),
    detalle VARCHAR(255),
    email_paypal VARCHAR(255),
    idTransaccionPaypal INT,
    idCarrito INT,
    FOREIGN KEY (idTransaccionPaypal) REFERENCES TransaccionPaypal(idTransaccionPaypal) ON DELETE CASCADE,
    FOREIGN KEY (idCarrito) REFERENCES Carrito(idCarrito) ON DELETE CASCADE
);


CREATE TABLE foro (
    idForo INT PRIMARY KEY AUTO_INCREMENT,
    comentario VARCHAR(50),
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE
);
