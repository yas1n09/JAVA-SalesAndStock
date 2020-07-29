-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 29 Tem 2020, 17:15:03
-- Sunucu sürümü: 10.4.11-MariaDB
-- PHP Sürümü: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `satisvestok`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `accounts`
--

CREATE TABLE `accounts` (
  `Id` int(11) NOT NULL,
  `YetkiId` int(11) DEFAULT NULL,
  `PersonelId` int(11) DEFAULT NULL,
  `Sifre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `accounts`
--

INSERT INTO `accounts` (`Id`, `YetkiId`, `PersonelId`, `Sifre`) VALUES
(2, 1, 2, '123'),
(3, 2, 3, '123'),
(4, 3, 4, '123'),
(5, 1, 5, '123');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kategori`
--

CREATE TABLE `kategori` (
  `Id` int(11) NOT NULL,
  `Adi` varchar(255) DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `kategori`
--

INSERT INTO `kategori` (`Id`, `Adi`, `ParentId`) VALUES
(1, 'Test Categorie', 0),
(2, 'Test 2', 0),
(3, 'Electronic', 0),
(4, 'Mobile Phone', 3),
(5, 'alt Categorie test', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `musteri`
--

CREATE TABLE `musteri` (
  `Id` int(11) NOT NULL,
  `AdiSoyadi` varchar(255) DEFAULT NULL,
  `Telefon` varchar(255) DEFAULT NULL,
  `Adres` varchar(255) DEFAULT NULL,
  `SehirId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `musteri`
--

INSERT INTO `musteri` (`Id`, `AdiSoyadi`, `Telefon`, `Adres`, `SehirId`) VALUES
(1, 'Birute R.', '5555555555', 'asdasafsasfa', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE `personel` (
  `Id` int(11) NOT NULL,
  `AdiSoyadi` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`Id`, `AdiSoyadi`, `Email`) VALUES
(2, 'Yasin Yagci', 'yasinyagci0990@gmail.com'),
(3, 'Orhan Cesur', 'Orhancesur@vs.com'),
(4, 'No Permissions', 'noperm@gmail.com');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `satis`
--

CREATE TABLE `satis` (
  `Id` int(11) NOT NULL,
  `UrunId` int(11) DEFAULT NULL,
  `MusteriId` int(11) DEFAULT NULL,
  `Adet` int(11) DEFAULT NULL,
  `PersonelId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `satis`
--

INSERT INTO `satis` (`Id`, `UrunId`, `MusteriId`, `Adet`, `PersonelId`) VALUES
(2, 1, 1, 26, 2),
(3, 1, 1, 5, 2),
(4, 1, 1, 4, 3),
(5, 1, 1, 1, 2),
(6, 1, 1, 2, 2),
(7, 2, 1, 1, 4),
(8, 5, 1, 25, 2),
(9, 1, 1, 50, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `stok`
--

CREATE TABLE `stok` (
  `Id` int(11) NOT NULL,
  `UrunId` int(11) DEFAULT NULL,
  `PersonelId` int(11) DEFAULT NULL,
  `Adet` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `stok`
--

INSERT INTO `stok` (`Id`, `UrunId`, `PersonelId`, `Adet`) VALUES
(1, 1, 2, 15),
(10, 1, 3, 20),
(11, 1, 2, 11),
(12, 1, 2, -26),
(13, 1, 2, -26),
(14, 1, 2, -26),
(15, 1, 2, 50),
(16, 1, 2, -5),
(17, 1, 3, -4),
(18, 1, 2, -1),
(19, 1, 2, 100),
(20, 1, 2, -2),
(21, 2, 4, -1),
(22, 2, 4, 10),
(23, 5, 2, 55),
(24, 5, 2, -25),
(25, 1, 2, 100),
(26, 1, 2, -50);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urunler`
--

CREATE TABLE `urunler` (
  `Id` int(11) NOT NULL,
  `Adi` varchar(255) DEFAULT NULL,
  `KategoriId` int(11) DEFAULT NULL,
  `Fiyat` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `urunler`
--

INSERT INTO `urunler` (`Id`, `Adi`, `KategoriId`, `Fiyat`) VALUES
(1, 'Laptop', 1, '0'),
(2, 'Calculator', 3, '0'),
(5, 'Headphones', 3, '50');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yetkiler`
--

CREATE TABLE `yetkiler` (
  `Id` int(11) NOT NULL,
  `Adi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `yetkiler`
--

INSERT INTO `yetkiler` (`Id`, `Adi`) VALUES
(1, 'Admin'),
(2, 'Diger Yetkili'),
(3, 'No Permission');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `musteri`
--
ALTER TABLE `musteri`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `satis`
--
ALTER TABLE `satis`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `urunler`
--
ALTER TABLE `urunler`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `yetkiler`
--
ALTER TABLE `yetkiler`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `accounts`
--
ALTER TABLE `accounts`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `kategori`
--
ALTER TABLE `kategori`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `musteri`
--
ALTER TABLE `musteri`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `personel`
--
ALTER TABLE `personel`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `satis`
--
ALTER TABLE `satis`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `stok`
--
ALTER TABLE `stok`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Tablo için AUTO_INCREMENT değeri `urunler`
--
ALTER TABLE `urunler`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `yetkiler`
--
ALTER TABLE `yetkiler`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
