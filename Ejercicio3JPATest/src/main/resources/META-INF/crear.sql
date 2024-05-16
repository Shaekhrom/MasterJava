CREATE TABLE `Noticia` (`titulo` VARCHAR(255) PRIMARY KEY, `autor` VARCHAR(255), `fecha` DATE );
CREATE TABLE `Comentario` (`id` INT PRIMARY KEY, `texto` TEXT, `autor` VARCHAR(255), `id_noticia` VARCHAR(255),FOREIGN KEY (`id_noticia`) REFERENCES `Noticia`(`titulo`));
