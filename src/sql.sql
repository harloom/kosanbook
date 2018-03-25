/*
SQLyog Professional v12.4.1 (64 bit)
MySQL - 10.1.29-MariaDB : Database - db_kosanbook
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_kosanbook` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_kosanbook`;

/*Table structure for table `tbl_harga` */

DROP TABLE IF EXISTS `tbl_harga`;

CREATE TABLE `tbl_harga` (
  `id` decimal(11,0) NOT NULL,
  `50mbps` decimal(11,0) NOT NULL,
  `30mbps` decimal(11,0) NOT NULL,
  `20mbps` decimal(11,0) NOT NULL,
  `vip` decimal(10,0) NOT NULL,
  `standard` decimal(11,0) NOT NULL,
  `kosong` decimal(11,0) NOT NULL,
  `tanggal_update` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_harga` */

insert  into `tbl_harga`(`id`,`50mbps`,`30mbps`,`20mbps`,`vip`,`standard`,`kosong`,`tanggal_update`) values 
(1,30000,15000,10000,699999,3499999,249999,'2018-03-24');

/*Table structure for table `tbl_member` */

DROP TABLE IF EXISTS `tbl_member`;

CREATE TABLE `tbl_member` (
  `id_member` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `sewa` int(20) NOT NULL,
  `nohp` varchar(13) NOT NULL,
  `tipe_kamar` varchar(30) NOT NULL,
  `tipe_wifi` varchar(30) NOT NULL,
  `total` int(11) NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `expire` date NOT NULL,
  PRIMARY KEY (`id_member`),
  UNIQUE KEY `nohp` (`nohp`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_member` */

insert  into `tbl_member`(`id_member`,`nama`,`jenis_kelamin`,`alamat`,`sewa`,`nohp`,`tipe_kamar`,`tipe_wifi`,`total`,`tanggal_masuk`,`expire`) values 
(2,'Ilham','Laki-Laki','Metro',12,'082307304530','VIP','100Mbps',8000000,'2018-03-22','2019-03-22'),
(10,'Nanda Eranata','Pria','Jalan BandarLampugn',10,'0823073041','VIP','50Mbps',100000,'2018-02-25','2018-01-25'),
(11,'Kirito','Pria','Tokyo',7,'082314221414','Standar','30Mbps',100000,'2018-03-25','2018-10-25'),
(14,'Sinon','Pria','Sibuya',13,'082141512155','Standar','30Mbps',100000,'2018-03-25','2018-04-25'),
(15,'YU','Wanita','Akibarahara',13,'0982121414','Standar','50Mbps',100000,'2018-03-25','2018-04-25'),
(17,'Ilhamaja','Laki-Laki','Metro',12,'08230711530','VIP','100Mbps',8000000,'2018-03-25','2018-03-25'),
(18,'Sora','Pria','Doooo',13,'0871231231','VIP','50Mbps',100000,'2018-03-25','2019-04-25'),
(19,'Subaru','Pria','Isekai',11,'085414124114','VIP','50Mbps',8029989,'2018-03-25','2019-02-25');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
