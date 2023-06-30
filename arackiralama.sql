-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 25 Haz 2023, 14:35:42
-- Sunucu sürümü: 10.4.28-MariaDB
-- PHP Sürümü: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `arackiralama`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `aracislemleri`
--

CREATE TABLE `aracislemleri` (
  `PLAKA` varchar(10) NOT NULL,
  `MARKA` varchar(30) NOT NULL,
  `YIL` int(4) NOT NULL,
  `RENK` varchar(25) NOT NULL,
  `YAKIT` varchar(15) NOT NULL,
  `KM` int(7) NOT NULL,
  `ÜCRET` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `aracislemleri`
--

INSERT INTO `aracislemleri` (`PLAKA`, `MARKA`, `YIL`, `RENK`, `YAKIT`, `KM`, `ÜCRET`) VALUES
('31 SZ 310', 'OPEL ASTRA', 2020, 'MAVİ', 'DİZEL', 115000, 6700),
('06 ANK 06', 'AUDİ A7', 2020, 'SİYAH', 'BENZİN', 77000, 2850),
('34 İST 34', 'RENAULT BROADWAY', 1998, 'GRİ', 'BENZİN+OTOGAZ', 345000, 300),
('35 İZM 35', 'MERCEDES C180', 2012, 'SİYAH', 'BENZİN', 19800, 650),
('07 ANT 07', 'SKODA SUPER B', 2021, 'BEYAZ', 'DİZEL', 125000, 850),
('16 BE 099', 'OPEL ASTRA', 2016, 'MAVİ', 'DİZEL', 117871, 1200),
('31 as 321', 'FİAT PUNTO', 2012, 'SİYAH', 'BENZİN', 134500, 1250),
('31 AD 3456', 'TOYOTA COROLLA', 2012, 'GRİ', 'BENZİN', 218765, 1050),
('31 DN 819', 'FİAT-DOBLO', 2006, 'GRİ', 'DİZEL', 286000, 3000),
('10 AFH 216', 'RENAULT-FULUANCE', 2016, 'BEYAZ', 'DİZEL', 120000, 4600),
('50 NE 7453', 'PORSCHE', 2023, 'SİYAH', 'BENZİN', 10000, 8200),
('31 AS 425', 'FİAT DOBLO', 2012, 'BEYAZ', 'DİZEL', 170000, 1000);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `kİD` int(11) NOT NULL,
  `kul_ad` varchar(50) NOT NULL,
  `sifre` varchar(50) NOT NULL,
  `yetki` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`kİD`, `kul_ad`, `sifre`, `yetki`) VALUES
(1, 'admin', '12345', 1),
(2, 'yusuf', '123', 0),
(4, 'SA', 'SASASA', 0),
(5, 'sa', 'sa', 0),
(11, '2', '2', 1),
(12, '123', '1234', 0),
(16, 'yeni', 'yeni', 0),
(17, 'admin', '12345', 0),
(20, 'hüseyin', '1234', 0),
(21, 'hüseyin', '1234', 0),
(22, '1', '2', 0),
(23, 'deneme', '1', 0),
(24, 'deneme', '123', 0),
(25, 'qw', 'wqq', 0),
(26, 'as', 'as', 0),
(27, '1', '1', 0),
(28, 'hasan', '123456', 0),
(29, 'hasan', '123456', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `müsteri`
--

CREATE TABLE `müsteri` (
  `tc` bigint(11) NOT NULL,
  `isim` varchar(50) NOT NULL,
  `soyisim` varchar(50) NOT NULL,
  `telno` bigint(11) NOT NULL,
  `adres` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `müsteri`
--

INSERT INTO `müsteri` (`tc`, `isim`, `soyisim`, `telno`, `adres`) VALUES
(38872423962, 'Yusuf', 'Söyler', 5316968767, 'Hatay Samandağ'),
(24568579866, 'Hüseyin', 'Yılmaz', 5967535665, 'Hatay Aantakya'),
(78998745665, 'Hasan', 'Karasu', 5696323221, 'Mersin Erdemli'),
(32112325333, 'Cumali', 'Meydan', 1233213585, 'İstanbul Bağcılar'),
(25896314774, 'Emir', 'Beyaz', 1477414565, 'İstanbul Esenler'),
(63996336966, 'Ali', 'Eryılmaz', 2563698556, 'Antalya Kaleiçi'),
(54658778965, 'Leyla', 'Kepek', 5214567895, 'Ankara Yenimahalle'),
(32165498747, 'Ece', 'Som', 5213256855, 'Bingöl Afadlar'),
(45678912325, 'AbdulMirkelam', 'Çetin', 5314567894, 'İzmir Karşıyaka'),
(74185296321, 'Damla', 'Sakız', 5622365487, 'İzmir Göztepe'),
(36925814789, 'Özgür', 'Demirtaş', 5312647896, 'Hatay İskenderun'),
(56489723158, 'Ali', 'Talha', 5312467897, 'Hatay Antakya');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`kİD`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `login`
--
ALTER TABLE `login`
  MODIFY `kİD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
