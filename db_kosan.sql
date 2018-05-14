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

/*Table structure for table `tbl_admin` */

DROP TABLE IF EXISTS `tbl_admin`;

CREATE TABLE `tbl_admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `tgl_login` date NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_admin` */

insert  into `tbl_admin`(`username`,`password`,`tgl_login`) values 
('admin','123','2018-05-04');

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
(1,35000,20000,15000,755000,500000,150000,'2018-04-20');

/*Table structure for table `tbl_hargaa` */

DROP TABLE IF EXISTS `tbl_hargaa`;

CREATE TABLE `tbl_hargaa` (
  `kode_h` varchar(11) NOT NULL,
  `harga` decimal(10,0) NOT NULL,
  `jumlah_max` int(11) NOT NULL,
  `tgl_update` date NOT NULL,
  PRIMARY KEY (`kode_h`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_hargaa` */

insert  into `tbl_hargaa`(`kode_h`,`harga`,`jumlah_max`,`tgl_update`) values 
('20mbps',10,10,'2017-12-20'),
('30mbps',10,10,'2017-12-20'),
('50mbps',10,10,'2017-12-20'),
('ko',10,10,'2017-12-20'),
('std',10,10,'2017-12-20'),
('vip',10,10,'2017-12-20');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_member` */

insert  into `tbl_member`(`id_member`,`nama`,`jenis_kelamin`,`alamat`,`sewa`,`nohp`,`tipe_kamar`,`tipe_wifi`,`total`,`tanggal_masuk`,`expire`) values 
(1,'hafid','Pria','Jalan Pekalogam',24,'08123121231','VIP','50Mbps',18960000,'2018-05-04','2020-05-04'),
(2,'ilham','Pria','Jalan Khaibrass',10,'082307120741','VIP','50Mbps',7900000,'2018-05-04','2019-03-04'),
(3,'Rem','Wanita','Isekai',6,'087564563564','Standar','30Mbps',3120000,'2018-05-05','2018-11-05'),
(4,'nanda','Pria','metro',9,'085655464646','Kosong','20Mbps',1485000,'2018-05-08','2019-02-08');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
