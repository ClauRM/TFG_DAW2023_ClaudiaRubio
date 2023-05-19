-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2023 a las 19:54:10
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cronomedbd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `idmedicamento` int(3) NOT NULL,
  `medicamento` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabla para el registro de medicamentos';

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`idmedicamento`, `medicamento`) VALUES
(1, 'paracetamol 100 mg/ml'),
(2, 'ibuprofeno 20 mg/ml'),
(3, 'aerius 0,5 mg/ml'),
(4, 'ibuprofeno 40 mg/ml'),
(8, 'ibuprofeno 600 mg'),
(9, 'paracetamol 650 mg'),
(10, 'paracetamol 1 gr'),
(11, 'salbutamol 100 microgramos'),
(12, 'omeprazol 20 mg'),
(13, 'omeprazol 40 mg'),
(14, 'omeprazol 10 mg'),
(15, 'lexatin 1,5 mg'),
(16, 'lexatin 3 mg'),
(17, 'nolotil 575 mg'),
(18, 'amoxicilina/acido clavulanico 500mg/125mg'),
(19, 'diazepan 5 mg'),
(20, 'enantyum 25 mg'),
(21, 'diclofenaco 50 mg'),
(22, 'metamizol 575 mg'),
(23, 'naproxeno 500 mg'),
(24, 'almax Forte 1,5 g'),
(25, 'aspirina 500 mg'),
(26, 'Prednisona 30 mg'),
(27, 'Estilsona 13,3 g'),
(28, 'Antalgin 550 mg'),
(29, 'Tryptizol 10 mg'),
(30, 'Lorazepam 1 mg'),
(31, 'Ebastel Forte 20 mg'),
(32, 'amoxicilina 250 mg/5 ml polvo'),
(34, 'desloratadina 0,5 mg/ml');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamientos`
--

CREATE TABLE `tratamientos` (
  `idtratamiento` int(3) NOT NULL,
  `fidusuario` int(3) NOT NULL,
  `fidmedicamento` int(3) NOT NULL,
  `paciente` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `dosis` int(2) NOT NULL,
  `horas` int(2) NOT NULL,
  `duracion` int(2) NOT NULL,
  `inicio` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `tratamiento` text CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `observaciones` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL,
  `activo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabla para el registro de tratamientos';

--
-- Volcado de datos para la tabla `tratamientos`
--

INSERT INTO `tratamientos` (`idtratamiento`, `fidusuario`, `fidmedicamento`, `paciente`, `dosis`, `horas`, `duracion`, `inicio`, `tratamiento`, `observaciones`, `activo`) VALUES
(20, 1, 1, 'cometa', 2, 12, 2, '2023-04-23 09:27:00', '23-04-2023 09:27:00,23-04-2023 21:27:00,24-04-2023 09:27:00,24-04-2023 21:27:00', 'con tratamiento [ ]', 1),
(22, 1, 3, 'prueba', 2, 4, 2, '25-04-2023 19:01:57', '25-04-2023 19:01:57,25-04-2023 23:01:57,26-04-2023 03:01:57,26-04-2023 07:01:57,26-04-2023 11:01:57,26-04-2023 15:01:57,26-04-2023 19:01:57,26-04-2023 23:01:57,27-04-2023 03:01:57,27-04-2023 07:01:57,27-04-2023 11:01:57,27-04-2023 15:01:57', 'prueba', 1),
(23, 13, 3, 'victor', 1, 8, 1, '01-05-2023 09:40:36', '01-05-2023 09:40:36,01-05-2023 17:40:36,02-05-2023 01:40:36', '', 1),
(24, 13, 3, '!cla ru', 1, 11, 1, '06-05-2023 08:25:14', '06-05-2023 08:25:14,06-05-2023 19:25:14', '', 0),
(25, 13, 32, 'mateo', 8, 8, 3, '06-05-2023 08:47:17', '06-05-2023 08:47:17,06-05-2023 16:47:17,07-05-2023 00:47:17,07-05-2023 08:47:17,07-05-2023 16:47:17,08-05-2023 00:47:17,08-05-2023 08:47:17,08-05-2023 16:47:17,09-05-2023 00:47:17', '', 1),
(26, 3, 3, 'prueba paciente', 1, 12, 2, '12-05-2023 20:27:49', '12-05-2023 20:27:49,13-05-2023 08:27:49,13-05-2023 20:27:49,14-05-2023 08:27:49', 'prueba observaciones', 1),
(27, 3, 1, 'prueba paciente', 2, 8, 3, '12-05-2023 20:29:41', '12-05-2023 20:29:41,13-05-2023 04:29:41,13-05-2023 12:29:41,13-05-2023 20:29:41,14-05-2023 04:29:41,14-05-2023 12:29:41,14-05-2023 20:29:41,15-05-2023 04:29:41,15-05-2023 12:29:41', 'prueba observaciones', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusuario` int(3) NOT NULL,
  `nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin` int(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='Tabla para registro de usuarios';

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusuario`, `nombre`, `email`, `password`, `admin`) VALUES
(1, 'claudia', 'claudia@email.com', '111111', 1),
(2, 'mateo', 'mateo@email.com', 'Mateo1', 0),
(3, 'usuario', 'usuario@email.com', '123456', 0),
(13, 'victor', 'victor@email.com', '999999', 0),
(17, 'paco', 'paco@email.com', 'paco12', 0),
(18, 'prueba', 'prueba@email.co', 'prueba', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`idmedicamento`);

--
-- Indices de la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD PRIMARY KEY (`idtratamiento`),
  ADD KEY `fidusuario` (`fidusuario`),
  ADD KEY `fidmedicamento` (`fidmedicamento`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  MODIFY `idmedicamento` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  MODIFY `idtratamiento` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusuario` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tratamientos`
--
ALTER TABLE `tratamientos`
  ADD CONSTRAINT `tratamientos_ibfk_1` FOREIGN KEY (`fidusuario`) REFERENCES `usuarios` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tratamientos_ibfk_2` FOREIGN KEY (`fidmedicamento`) REFERENCES `medicamentos` (`idmedicamento`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
