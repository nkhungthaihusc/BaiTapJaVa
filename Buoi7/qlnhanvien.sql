USE [master]
GO
/****** Object:  Database [qlnhanvien]    Script Date: 5/13/2025 8:28:55 PM ******/
CREATE DATABASE [qlnhanvien]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'qlnhanvien', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\qlnhanvien.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'qlnhanvien_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\qlnhanvien_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [qlnhanvien] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [qlnhanvien].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [qlnhanvien] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [qlnhanvien] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [qlnhanvien] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [qlnhanvien] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [qlnhanvien] SET ARITHABORT OFF 
GO
ALTER DATABASE [qlnhanvien] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [qlnhanvien] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [qlnhanvien] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [qlnhanvien] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [qlnhanvien] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [qlnhanvien] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [qlnhanvien] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [qlnhanvien] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [qlnhanvien] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [qlnhanvien] SET  DISABLE_BROKER 
GO
ALTER DATABASE [qlnhanvien] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [qlnhanvien] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [qlnhanvien] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [qlnhanvien] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [qlnhanvien] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [qlnhanvien] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [qlnhanvien] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [qlnhanvien] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [qlnhanvien] SET  MULTI_USER 
GO
ALTER DATABASE [qlnhanvien] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [qlnhanvien] SET DB_CHAINING OFF 
GO
ALTER DATABASE [qlnhanvien] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [qlnhanvien] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [qlnhanvien] SET DELAYED_DURABILITY = DISABLED 
GO
USE [qlnhanvien]
GO
/****** Object:  Table [dbo].[DonVi]    Script Date: 5/13/2025 8:28:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonVi](
	[madv] [nvarchar](50) NOT NULL,
	[tendv] [nvarchar](50) NULL,
 CONSTRAINT [PK_DonVi] PRIMARY KEY CLUSTERED 
(
	[madv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/13/2025 8:28:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[manv] [nvarchar](50) NOT NULL,
	[hoten] [nvarchar](50) NULL,
	[ngaysinh] [date] NULL,
	[gioitinh] [bit] NULL,
	[hsl] [float] NULL,
	[ghichu] [nvarchar](max) NULL,
	[madv] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[manv] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[DonVi] ([madv], [tendv]) VALUES (N'001', N'Khoa Anh')
INSERT [dbo].[DonVi] ([madv], [tendv]) VALUES (N'002', N'Khoa Toán')
INSERT [dbo].[DonVi] ([madv], [tendv]) VALUES (N'003', N'Khoa Lý')
INSERT [dbo].[DonVi] ([madv], [tendv]) VALUES (N'004', N'Khoa Hóa')
INSERT [dbo].[DonVi] ([madv], [tendv]) VALUES (N'005', N'Khoa Sử')
INSERT [dbo].[DonVi] ([madv], [tendv]) VALUES (N'006', N'Khoa Báo Chí')
INSERT [dbo].[NhanVien] ([manv], [hoten], [ngaysinh], [gioitinh], [hsl], [ghichu], [madv]) VALUES (N'NV001', N'Võ Kim Cúc', CAST(N'2000-05-16' AS Date), 1, 6.5, N'Manh Lam Do', N'001')
INSERT [dbo].[NhanVien] ([manv], [hoten], [ngaysinh], [gioitinh], [hsl], [ghichu], [madv]) VALUES (N'NV002', N'Quách Thị Mông Mơ', CAST(N'2001-05-25' AS Date), 0, 6, N'Chay Nhanh Lam', N'001')
INSERT [dbo].[NhanVien] ([manv], [hoten], [ngaysinh], [gioitinh], [hsl], [ghichu], [madv]) VALUES (N'NV003', N'Lê Chí Thông', CAST(N'2003-06-28' AS Date), 1, 5.1, N'Don Stack', N'003')
INSERT [dbo].[NhanVien] ([manv], [hoten], [ngaysinh], [gioitinh], [hsl], [ghichu], [madv]) VALUES (N'NV004', N'Quách Tỉnh', CAST(N'1999-09-14' AS Date), 0, 5.2, N'Chich Dien Campu', N'003')
INSERT [dbo].[NhanVien] ([manv], [hoten], [ngaysinh], [gioitinh], [hsl], [ghichu], [madv]) VALUES (N'NV005', N'Mai Xuân Phong', CAST(N'2005-10-19' AS Date), 1, 4.2, N'Tang Toc Do', N'005')
INSERT [dbo].[NhanVien] ([manv], [hoten], [ngaysinh], [gioitinh], [hsl], [ghichu], [madv]) VALUES (N'NV006', N'Nguyễn Thị Thần Rùa', CAST(N'2005-12-07' AS Date), 0, 7, N'Gay', N'003')
INSERT [dbo].[NhanVien] ([manv], [hoten], [ngaysinh], [gioitinh], [hsl], [ghichu], [madv]) VALUES (N'NV007', N'Nguyễn Văn Hải', CAST(N'2003-12-10' AS Date), 1, 8, N'No Gay', N'003')
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_DonVi] FOREIGN KEY([madv])
REFERENCES [dbo].[DonVi] ([madv])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_DonVi]
GO
USE [master]
GO
ALTER DATABASE [qlnhanvien] SET  READ_WRITE 
GO
